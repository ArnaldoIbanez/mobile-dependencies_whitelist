package com.melidata.definitions.validate

import groovy.sql.Sql
import groovyx.net.http.ContentType
import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.RESTClient

class InitiativeValidate {

    private static List<ApplicationModel> applications = []
    private static Set validPaths = []
    private static Set totalPaths = []
    private static double baseCoverage = 90

    static void generateInitiativesList() {
        getAllInitiativesFromAPI()
    }

    private static List getAllInitiativesFromAPI() {
        def client = new RESTClient('https://initiatives-api.furycloud.io/')
        HttpResponseDecorator resultApplication = client.get(path: '/applications', contentType: ContentType.JSON)

        for(application in resultApplication.data) {
            applications << new ApplicationModel(Integer.toString(application.id_initiative), Integer.toString(application.id_application))
        }
    }

    static validateInitiative(String path, String initiativeId) {
        totalPaths << path

        if(initiativeId && applications.any() {ApplicationModel init -> init.getInitiativeId() == initiativeId }) {
            validPaths << path
            return true
        } else {
            return false
        }
    }

    static String getInitiativeFromApplication(String applicationId) {
        return applications.find({ApplicationModel init -> init.getApplicationId() == applicationId})?.getInitiativeId()
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
