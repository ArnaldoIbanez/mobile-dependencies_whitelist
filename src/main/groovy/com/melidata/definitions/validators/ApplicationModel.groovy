package com.melidata.definitions.validate

class ApplicationModel {

    private String initiativeId
    private String applicationId

    ApplicationModel(String initiativeId, String applicationId) {
        this.applicationId = applicationId
        this.initiativeId = initiativeId
    }

    String getInitiativeId() {
        return initiativeId
    }

    void setInitiativeId(String initiativeId) {
        this.initiativeId = initiativeId
    }

    String getApplicationId() {
        return applicationId
    }

    void setApplicationId(String applicationId) {
        this.applicationId = applicationId
    }
}
