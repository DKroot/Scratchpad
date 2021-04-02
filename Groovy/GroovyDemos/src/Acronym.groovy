static String getAcronymFromSnakeCase(String s) {
  s ? s.split(/_/)*.getAt(0).join() : ''
}

def s = 'nlm_idconverter'
println "Acronym for `${s}` = `${getAcronymFromSnakeCase(s)}`"

s = 'word'
println "Acronym for `${s}` = `${getAcronymFromSnakeCase(s)}`"

s = ''
println "Acronym for `${s}` = `${getAcronymFromSnakeCase(s)}`"