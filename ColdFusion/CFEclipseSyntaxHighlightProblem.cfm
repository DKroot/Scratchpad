<cfscript>
    cookie.RAPWarning = "Please correct the following problems:<br>" & ArrayToList(validationResults.errors, "<br>");
    if (prepayment) {
        tr.lastUpdatedBy = user;
    } else {
        switch(action) {
            case "new": //create
                tr.cartId = user.activeCart;
                tr.create();
                created = true;

                break;
            case "edit": //update
                tr.update();
                break;
            default:
                ;
        }
    }
</cfscript>
