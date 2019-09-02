//Arrays.stream("nlm_idconverter".split("_")).map(e -> e.toString()).collect(Collectors.toList())

"nlm_idconverter".split(/_/).collect { it ? it[0] : "" }.join()

//"".split("_").collect { it[0] }.join()

//"".split("_").collect { it ? it[0] : "" }