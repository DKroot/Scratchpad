WITH 1 AS foo, "bar" AS bar
MATCH (x:Publication {node_id: 0})
WITH collect(x) AS xes, foo, bar
RETURN *;

OPTIONAL MATCH (x:Publication {node_id: 0})
RETURN collect(x);
