package com.ml.melidata.catalog;

public enum TrackSourceType {
    SERVER, CLIENT, ALL

    public static TrackSourceType fromString(String a){
        def result
        switch (a.toUpperCase()) {
            case "SERVER": result = SERVER; break
            case "CLIENT": result = CLIENT; break
            default: throw new IllegalArgumentException("Could not find track source type $a".toString())
        }

        return result
    }

}
