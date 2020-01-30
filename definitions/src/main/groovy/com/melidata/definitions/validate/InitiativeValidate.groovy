package com.melidata.definitions.validate

import groovy.sql.Sql
import groovyx.net.http.ContentType
import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.RESTClient

class InitiativeValidate {

    private static List<ApplicationModel> initiatives = []
    private static Set validPaths = []
    private static Set totalPaths = []
    private static double baseCoverage = 50

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
            ApplicationModel im = new ApplicationModel(row.idinitiative, row.idapplication)
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
            initiatives << new ApplicationModel(Integer.toString(application.id_initiative), Integer.toString(application.id_application))
        }
    }

    private static String buildQuery() {
        return "SELECT idapplication, application.idinitiative from application_initiatives_export as application\n" +
                "JOIN initiatives_export as initiative ON initiative.idinitiative = application.idinitiative"
    }

    static validateInitiative(String path, String initiative) {
        totalPaths << path

        if(initiative && initiatives.any() {ApplicationModel init -> init.getInitiativeId() == initiative }) {
            validPaths << path
            return true
        } else {
            return false
        }
    }

    static String getInitiativeFromApplication(String application) {
        return initiatives.find({ApplicationModel init -> init.getApplicationId() == application})?.getInitiativeId()
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
