package com.ml.melidata.catalog.tree

/**
 * Created by geisbruch on 11/13/14.
 */
class TrackValidationResponse {

    boolean status = true
    ArrayList<String> messages

    def TrackValidationResponse(){
        this.messages = new ArrayList<String>()
    }

    def addValidation(boolean status, String message = null){
        // if all the status are true -> the result is true!
        // if one is false -> the result es false :(
        this.status = this.status && status
        if(message)
            this.messages.push(message)
    }

    def addComment(String comment) {
        this.messages[messages.size() - 1] = this.messages[messages.size() - 1] + comment
    }
}