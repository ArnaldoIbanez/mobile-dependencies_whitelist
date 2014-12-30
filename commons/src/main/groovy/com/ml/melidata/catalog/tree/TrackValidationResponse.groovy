package com.ml.melidata.catalog.tree

/**
 * Created by geisbruch on 11/13/14.
 */
class TrackValidationResponse {

    boolean status = true
    ArrayList<String> menssages

    def TrackValidationResponse(){
        menssages = new ArrayList<String>()
    }

    def addValidation(boolean status, String message = null){
        // if all the status are true -> the result is true!
        // if one is false -> the result es false :(
        this.status = this.status && status
        if(message)
            this.menssages.push(message)
    }
}