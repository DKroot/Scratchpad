component output="false" extends="RAP.components.RAPDomain.PersistenceService" {
    /**
    * Retrieve availalble B/C FYs
    *
    * @appropriation filter by appropriation
    * @IC filter by IC
    */
    remote query function readBCFYs(string appropriation="", string IC="") {
        var bindParameters = "";
        var sql = "
                (
                SELECT
                    u.fy
                FROM
                    NV_REIMBURSABLE_BILLING u
                    LEFT OUTER JOIN NV_REIMBURSABLE_BILLING billed
                        ON billed.action_code = 'BILLING' AND
                        u.nbrss_seq_nbr = billed.unbilled_seq_nbr
                WHERE
                    u.action_code = 'IC REIMB RCV' AND
                    u.cart_id <> 'CONVERSION CLOSED'";
        if (appropriation != "") {
            sql &= " AND :approp = u.approp";
            bindParameters = "approp=" & appropriation;
        }
        if (IC != "") {
            sql &= " AND :IC = u.icd";
            bindParameters = ListAppend(bindParameters, "IC=" & IC);
        }
        sql &= "
                GROUP BY
                    u.cart_txn_id,
                    u.fy,
                    u.can,
                    u.unbilled_amt
                HAVING
                    u.unbilled_amt - COALESCE(SUM(billed.billed_amt), 0) <> 0
                ) INTERSECT (
                SELECT
                    ro.fy
                FROM
                    NV_REIMBURSABLE_BILLING ro
                    LEFT OUTER JOIN NV_REIMBURSABLE_BILLING billed
                        ON billed.action_code = 'BILLING' AND
                        ro.docno = billed.docno AND
                        ro.fy = billed.fy AND
                        ro.can = billed.can AND
                        ro.facts_tp_code = billed.facts_tp_code
                WHERE
                    ro.action_code = 'REIMB AUTH' AND
                    COALESCE(ro.prepay_ind, 'N' ) <> 'Y'";
        if (appropriation != "") {
            sql &= " AND :approp = ro.approp";
        }
        if (IC != "") {
            sql &= " AND :IC = ro.icd";
        }
        sql &= "
                GROUP BY
                    ro.docno,
                    ro.fy,
                    ro.can
                HAVING
                    SUM(ro.authority_amt) - COALESCE(SUM(billed.billed_amt), 0) <> 0
                )
                ORDER BY
                    fy DESC";
        return db(sql, bindParameters);
    }

    /**
    * Retrieve availalble B/C CANs by FY
    *
    * @FY
    */
    remote query function readBCCANs(string FY) {
        var bindParameters = "";
        var sql = "
                (
                SELECT
                    u.can
                FROM
                    NV_REIMBURSABLE_BILLING u
                    LEFT OUTER JOIN NV_REIMBURSABLE_BILLING billed
                        ON billed.action_code = 'BILLING' AND
                        u.nbrss_seq_nbr = billed.unbilled_seq_nbr
                WHERE
                    u.action_code = 'IC REIMB RCV' AND
                    u.cart_id <> 'CONVERSION CLOSED' AND
                    :FY = u.fy
                GROUP BY
                    u.cart_txn_id,
                    u.fy,
                    u.can,
                    u.unbilled_amt
                HAVING
                    u.unbilled_amt - COALESCE(SUM(billed.billed_amt), 0) <> 0
                ) INTERSECT (
                SELECT
                    ro.can
                FROM
                    NV_REIMBURSABLE_BILLING ro
                    LEFT OUTER JOIN NV_REIMBURSABLE_BILLING billed
                        ON billed.action_code = 'BILLING' AND
                        ro.docno = billed.docno AND
                        ro.fy = billed.fy AND
                        ro.can = billed.can AND
                        ro.facts_tp_code = billed.facts_tp_code
                WHERE
                    ro.action_code = 'REIMB AUTH' AND
                    COALESCE(ro.prepay_ind, 'N' ) <> 'Y' AND
                    :FY = ro.fy
                GROUP BY
                    ro.docno,
                    ro.fy,
                    ro.can
                HAVING
                    SUM(ro.authority_amt) - COALESCE(SUM(billed.billed_amt), 0) <> 0
                )
                ORDER BY
                    can";
        return db(sql, "FY=" & FY);
    }

    /*
    remote array function readFYs() {
        var select = readBCFYs();
        var result = ArrayNew(2);
        for (var i = 1; i <= select.RecordCount; i++) {
            ArrayAppend(result, [select.FY[i], select.FY[i]]);
        }
        return result;
    }
    */
}