UNWIND $input_data AS row
MATCH (c:Publication {node_id: row.scp})-[r:CITES]->(d:Publication)
WHERE c.pub_year = 1985 AND c.citation_type = 'ar' AND d.pub_year <=1985 AND c.node_id <> d.node_id
WITH c.node_id as scp, count(r) as citations
MATCH (a:Publication)<-[r1:CITES]-(c:Publication {node_id: scp})-[r2:CITES]->(b:Publication)
WHERE a.node_id <> c.node_id AND b.node_id <> c.node_id AND a.pub_year <= 1985 AND b.pub_year <= 1985 AND a.node_id < b.node_id AND citations >= 5
RETURN a.node_id AS cited_1, b.node_id AS cited_2, COUNT(scp) as frequency
ORDER BY frequency DESC;

UNWIND [1557355, 314129, 4939, 84988060701, 4243603481] AS row
MATCH (c:Publication {node_id: row})-[r:CITES]->(d:Publication)
WHERE c.pub_year = 1985 AND c.citation_type = 'ar' AND d.pub_year <=1985 AND c.node_id <> d.node_id
WITH c.node_id as scp, count(r) as citations
MATCH (a:Publication)<-[r1:CITES]-(c:Publication {node_id: scp})-[r2:CITES]->(b:Publication)
WHERE a.node_id <> c.node_id AND b.node_id <> c.node_id AND a.pub_year <= 1985 AND b.pub_year <= 1985 AND a.node_id < b.node_id AND citations >= 5
RETURN a.node_id AS cited_1, b.node_id AS cited_2, COUNT(scp) as frequency
ORDER BY frequency DESC;

UNWIND $input_data AS row
MATCH (c:Publication {node_id: row.scp})-[r:CITES]->(d:Publication)
WHERE c.pub_year = 1985 AND c.citation_type = 'ar' AND d.pub_year <= 1985
WITH c.node_id as scp, count(r) as citations
MATCH (a:Publication)<-[r1:CITES]-(c:Publication {node_id: scp})-[r2:CITES]->(b:Publication)
WHERE a.node_id <> c.node_id AND b.node_id <> c.node_id AND a.pub_year <= 1985 AND b.pub_year <= 1985 AND a.node_id < b.node_id AND citations >= 5
RETURN a.node_id AS cited_1, b.node_id AS cited_2, COUNT(scp) AS frequency
ORDER BY cited_1, cited_2;
// 403 rows

UNWIND $input_data AS row
MATCH (c:Publication {node_id: row.scp})-[r:CITES]->(d:Publication)
WHERE c.pub_year = 1985 AND c.citation_type = 'ar' AND d.pub_year <= 1985
WITH c.node_id as scp, count(r) as citations
MATCH (a:Publication)<-[r1:CITES]-(c:Publication {node_id: scp})-[r2:CITES]->(b:Publication)
WHERE a.node_id <> c.node_id AND b.node_id <> c.node_id AND a.pub_year <= 1985 AND b.pub_year <= 1985 AND a.node_id < b.node_id AND citations >= 5
RETURN a.node_id AS cited_1, b.node_id AS cited_2, scp;
// 403 rows

MATCH (a:Publication {node_id: 140752})<-[r1:CITES]-(c:Publication)-[r2:CITES]->(b:Publication {node_id: 84987097935})
RETURN a.node_id AS cited_1, b.node_id AS cited_2, COUNT(c) AS frequency;

MATCH (c:Publication)
WHERE c.pub_year = 1985 AND c.citation_type = 'ar'
RETURN c.node_id
LIMIT 5;

UNWIND [1557355, 314129, 4939, 84988060701, 4243603481] AS row
MATCH (c:Publication {node_id: row})-[r:CITES]->(d:Publication)
WHERE c.pub_year = 1985 AND c.citation_type = 'ar' AND d.pub_year <=1985 AND c.node_id <> d.node_id
WITH c.node_id as scp, count(r) as citations
MATCH (a:Publication)<-[r1:CITES]-(c:Publication {node_id: scp})-[r2:CITES]->(b:Publication)
WHERE a.node_id <> c.node_id AND b.node_id <> c.node_id AND a.pub_year <= 1985 AND b.pub_year <= 1985 AND a.node_id < b.node_id AND citations >= 5
RETURN a.node_id AS cited_1, b.node_id AS cited_2, COUNT(scp) as frequency
ORDER BY frequency DESC;

UNWIND [1557355, 314129, 4939, 84988060701, 4243603481] AS row
MATCH (c:Publication {node_id: row})
//WHERE c.pub_year = 1985 AND c.citation_type = 'ar'
RETURN c.node_id AS scp, c.pub_year;

UNWIND $input_data AS row
MATCH (c:Publication {node_id: row.scp})
WHERE c.pub_year = 1985 AND c.citation_type = 'ar'
RETURN c.node_id AS scp;
