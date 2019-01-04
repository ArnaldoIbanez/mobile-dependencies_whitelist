package com.ml.melidata.catalog

import com.ml.melidata.catalog.tree.TrackValidationResponse

class PropertyType {

    public static Validator String = SimpleProperty.String
    public static Validator Numeric = SimpleProperty.Numeric
    public static Validator Boolean = SimpleProperty.Boolean
    public static Validator ArrayList = SimpleProperty.ArrayList
    public static Validator Map = SimpleProperty.Map

    static Map(Map<String,TrackDefinitionProperty> nestedProperties) {

        return new MapProperty(nestedProperties)
    }

    static ArrayList(Validator propertyType) {

        return new ArrayListProperty(propertyType)
    }
}

class ArrayListProperty implements Validator {

    Validator propertyType

    ArrayListProperty(Validator propertyType) {
        this.propertyType = propertyType
    }

    boolean validate(TrackValidationResponse response, String property, Object value, boolean required=true) {

        def valid = true

        if(!required) return true
        value.each { val ->
            if(!propertyType.validate(response, property, val, required)) {
                response.addComment(". The error ocurred at List with value ${val}")
                valid = false
            }
        }

        return valid
    }

}

class MapProperty implements Validator {
    Map<String,TrackDefinitionProperty> nestedProperties

    MapProperty(Map<String,TrackDefinitionProperty> nestedProperties) {
        this.nestedProperties = nestedProperties
    }

    boolean validate(TrackValidationResponse response, String property, Object value, boolean required=true) {

        def valid = true

        if(!required) return true
        nestedProperties.each { k, v ->
            def mapProperty = value[k]
            if(!v.validate(response, k, mapProperty)) {
                response.addComment(". The error ocurred at property '${property}'")
                valid = false
            }
        }

        return valid

    }

}

public enum SimpleProperty implements Validator{
    String {
        public Boolean validate(Object value) {
            return value instanceof String
        }
    },
    Numeric {
        public Boolean validate(Object value) {
            return value instanceof Number
        }
    },
    Boolean {
        public Boolean validate(Object value) {
            return value instanceof Boolean
        }
    },
    ArrayList {
        public Boolean validate(Object value) {
            return value instanceof ArrayList
        }
    },
    Map {
        public Boolean validate(Object value) {
            return value instanceof Map
        }
    }

    boolean validate(TrackValidationResponse response, String property, Object value, boolean required=true) {

        if(this.validate(value))
            return true

        response.addValidation(false, "Property '${property}' has invalid type '${value?.class}'. (value must be: ${this})")
        return false
    }
}