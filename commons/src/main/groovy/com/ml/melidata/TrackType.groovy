package com.ml.melidata

enum TrackType {
    View, Event, Email, Control

    public static TrackType fromString(String a){
        def result;
        switch (a.toUpperCase()) {
            case "VIEW": result = View; break;
            case "EVENT":result = Event; break;
            case "EMAIL": result = Email; break;
            case "CONTROL": result = Control; break;
        }
        return result;
    }
}