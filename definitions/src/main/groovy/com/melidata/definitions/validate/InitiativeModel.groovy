package com.melidata.definitions.validate

class InitiativeModel {

    private String id
    private String initiativeName
    private String applicationName

    InitiativeModel(String id, String initiativeName, String applicationName) {
        this.id = id
        this.initiativeName = initiativeName
        this.applicationName = applicationName
    }

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getInitiativeName() {
        return initiativeName
    }

    void setInitiativeName(String initiativeName) {
        this.initiativeName = initiativeName
    }

    String getApplicationName() {
        return applicationName
    }

    void setApplicationName(String applicationName) {
        this.applicationName = applicationName
    }
}
