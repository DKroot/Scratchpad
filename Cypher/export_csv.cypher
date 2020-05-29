CALL apoc.export.csv.query(
  'WITH $scp AS scp
  RETURN *',
  '/neo4j_data1/sb_plus/sb-plus-batch.csv',
  {params: {scp: 12345}}
);