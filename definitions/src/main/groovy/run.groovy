def catalog = evaluate(new File("./src/main/groovy/catalog.groovy"))
def tests = evaluate(new File("./src/main/groovy/tests.groovy"))

println "*************************************"
println "ready to run ${tests.size()} track tests"
println "*************************************"

def menssages = [:]
def result = null
tests.each { t ->
    t.tracks.each{ tr ->
        result = catalog.validate(tr)
        if(!result.status){
            menssages.put(t.name, result.menssages)
            print "X"
        }else
            print "."
    }
}


println " "
println "*************************************"
println "Tracks Invalid: ${menssages}"
println "*************************************"
