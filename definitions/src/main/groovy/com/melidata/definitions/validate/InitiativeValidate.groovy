package com.melidata.definitions.validate

import groovy.sql.Sql
import groovyx.net.http.ContentType
import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.RESTClient

class InitiativeValidate {

    private static List<InitiativeModel> initiatives = []
    private static Set validPaths = []
    private static Set totalPaths = []
    private static double baseCoverage = 0.6

    static void generateInitiativesList() {
        //getAllInitiativesFromAPI()
        initiatives = getAllInitiativesFromDump()
    }

    private static List getAllInitiativesFromDump() {
        def query = buildQuery()
        def presto_certs_path = System.getProperty("user.dir") + "/src/main/resources/presto_cacerts"

        def db = [url:"jdbc:presto://melidata-presto.ml.com:443/hive/default?SSL=true&SSLKeyStorePath=${presto_certs_path}&applicationNamePrefix=catalog",
                  user:'catalog_md', password:'Entrada.10', driver:'com.facebook.presto.jdbc.PrestoDriver']
        def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)
        List result = []
        sql.eachRow(query) { row ->
            InitiativeModel im = new InitiativeModel(Integer.parseInt(row.idinitiative), row.externalname, row.name)
            result << im
        }

        return result
    }

    private static List getAllInitiativesFromAPI() {
        def initiativesMap = [:]
        def client = new RESTClient('https://initiatives-api.furycloud.io')
        HttpResponseDecorator resultInitiatives = client.get(path: '/initiatives', contentType: ContentType.JSON)
        HttpResponseDecorator resultApplication = client.get(path: '/applications', contentType: ContentType.JSON)

        System.err.println('IVE JUST RECEIVED SMTH')

        for(initiative in resultInitiatives.data) {
            initiativesMap[initiative.id_initiative] = initiative.external_name
        }

        for(application in resultApplication.data) {
            initiatives << InitiativeModel(application.id_initiative, initiativesMap[application.id_initiative], application.name)
        }
    }

    private static String buildQuery() {
        return "SELECT name,  application.idinitiative, externalName from application_initiatives_export as application\n" +
                "JOIN initiatives_export as initiative ON initiative.idinitiative = application.idinitiative"
    }

    static validateInitiative(String path, String initiative) {
        totalPaths << path

        if(initiative && initiatives.any() {InitiativeModel init -> init.getInitiativeName() == initiative }) {
            validPaths << path
            return true
        } else {
            return false
        }
    }

    static String getInitiativeFromApplication(String application) {
        return initiatives.find({InitiativeModel init -> init.getApplicationName() == application})?.getInitiativeName()
    }

    static boolean checkCoverage() {
        def actualCoverage = (validPaths.size() / totalPaths.size()) * 100
        def isValidStatus = actualCoverage > baseCoverage
        if(!isValidStatus) {
            println "\n"+starBar()
            println("\tInitiatives coverage is too low!")
            println starBar()+"\n"

            println("\033[91m - Actual coverage: "+actualCoverage+"\033[0m")
            println("\033[92m - Intended coverage: "+baseCoverage+"\033[0m")
        }

        return isValidStatus
    }

    def static starBar() {
        return "**************************************************"
    }
}
