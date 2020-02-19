package com.ml.melidata.catalog.model

class ApplicationModel {

    private String initiativeId
    private String applicationName

    ApplicationModel(String initiativeId, String applicationName) {
        this.applicationName = applicationName
        this.initiativeId = initiativeId
    }

    String getInitiativeId() {
        return initiativeId
    }

    void setInitiativeId(String initiativeId) {
        this.initiativeId = initiativeId
    }

    String getApplicationName() {
        return applicationName
    }

    void setApplicationName(String applicationName) {
        this.applicationName = applicationName
    }

}
