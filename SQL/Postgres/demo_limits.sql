SELECT CASE WHEN count(patent_num_wila) > 1000000 THEN 'Narrow down!' END
FROM tmp_us_patents;