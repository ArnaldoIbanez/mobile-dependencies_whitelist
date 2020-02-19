package com.ml.melidata.catalog.initiatives

import com.ml.melidata.catalog.model.ApplicationModel
import groovyx.net.http.ContentType
import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.RESTClient

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class InitiativeAPI implements Runnable {

    public List<ApplicationModel> applications = []
    private static InitiativeAPI INSTANCE = null

    private InitiativeAPI() {

    }

    static InitiativeAPI getInstance() {
        if(!INSTANCE) {
            INSTANCE = new InitiativeAPI()
        }

        return INSTANCE
    }

    String getInitiativeFromApplication(String applicationName) {
        return this.applications.find({ApplicationModel init -> init.getApplicationName() == applicationName})?.getInitiativeId()
    }

    void generateInitiativesList() {
        getAllApplicationsFromAPI()
    }

    private void getAllApplicationsFromAPI() {
        def client = new RESTClient('http://initiatives-api.furycloud.io/')
        HttpResponseDecorator resultApplication = client.get(path: '/applications', contentType: ContentType.JSON)
        List<ApplicationModel> applicationsFromAPI = []

        for(application in resultApplication.data) {
            applicationsFromAPI << new ApplicationModel(Integer.toString(application.id_initiative), application.application_name)
        }

        applications = applicationsFromAPI
    }

    void init() {
        getAllApplicationsFromAPI()
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(this, 0, 24, TimeUnit.HOURS)
    }

    @Override
    void run() {
        try {
            getAllApplicationsFromAPI()
        } catch(Throwable e) {

        }
    }
}
