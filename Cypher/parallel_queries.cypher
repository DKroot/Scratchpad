CALL apoc.periodic.iterate(
'MATCH (c)
RETURN c.node_id AS scp
LIMIT 100',
"CALL apoc.export.csv.query(
    'WITH $batch AS batch
    RETURN batch.scp',
    '/neo4j_data1/sb_plus/sb-plus-batch.csv'
    params: {params}
  )
  YIELD file, source, format, nodes, relationships, properties, time, rows, batchSize, batches, done, data
  RETURN *",
//'/neo4j_data1/sb_plus/sb-plus-batch' + $batch[0].scp + '.csv',
{batchSize: 10, parallel: true, batchMode: 'BATCH_SINGLE'}
);


// Jaccard Co-Citation* Index: |N(xy) = Co-citing set|/|NxUNy = N*(x) union with N*(y)| in parallel
// 5 pairs: 4.4s
WITH $DB_conn_string AS db,
     '
     SELECT cited_1, cited_2
     FROM cc2.ten_year_cocit_union_freq11_freqsum_bins
     WHERE bin = 1
     ORDER BY random()
     LIMIT ' + $input_limit AS sql
CALL apoc.load.jdbc(db, sql) YIELD row
WITH collect({x_scp: row.cited_1, y_scp: row.cited_2}) AS pairs
CALL apoc.cypher.mapParallel2('
  MATCH (x:Publication {node_id: _.x_scp})<--(Nxy)-->(y:Publication {node_id: _.y_scp})
  WITH count(Nxy) AS intersect_size, _.x_scp AS x_scp, _.y_scp AS y_scp
  MATCH (x:Publication {node_id: x_scp})<--(Nx:Publication)
    WHERE Nx.node_id <> y_scp
  WITH collect(Nx) AS nx_list, intersect_size, x_scp, y_scp
  MATCH (y:Publication {node_id: y_scp})<--(Ny:Publication)
    WHERE Ny.node_id <> x_scp
  WITH nx_list + collect(Ny) AS union_list, intersect_size, x_scp, y_scp
  UNWIND union_list AS union_node
  RETURN x_scp AS cited_1, y_scp AS cited_2,
         toFloat(intersect_size) / (count(DISTINCT union_node) + 2) AS jaccard_co_citation_star_index', {}, pairs, 16)
YIELD value
RETURN value.cited_1 AS cited_1, value.cited_2 AS cited_2,
       value.jaccard_co_citation_star_index AS jaccard_co_citation_star_index;

// Jaccard Co-Citation* Index: |N(xy) = Co-citing set|/|NxUNy = N*(x) union with N*(y)| in parallel
// 5 pairs: ?
WITH $DB_conn_string AS db,
     '
     SELECT cited_1, cited_2
     FROM cc2.ten_year_cocit_union_freq11_freqsum_bins
     WHERE bin = 1
     ORDER BY random()
     LIMIT ' + $input_limit AS sql
CALL apoc.load.jdbc(db, sql) YIELD row
RETURN collect({x_scp: row.cited_1, y_scp: row.cited_2}) AS pairs;

MATCH (x:Publication {node_id: 9482260}), (y:Publication {node_id: 14949207})
WITH [x, y] AS pair
RETURN pair[0], pair[1];