package com.ml.melidata.catalog

import com.ml.melidata.catalog.tree.TrackValidationResponse

public interface PropertyTypeValidator {
    boolean validate(TrackValidationResponse response, String property, Object value)
}

class PropertyType {

    public static PropertyTypeValidator String = SimpleProperty.String
    public static PropertyTypeValidator Numeric = SimpleProperty.Numeric
    public static PropertyTypeValidator Boolean = SimpleProperty.Boolean
    public static PropertyTypeValidator ArrayList = SimpleProperty.ArrayList
    public static PropertyTypeValidator Map = SimpleProperty.Map

    static Map(Map<String,TrackDefinitionProperty> nestedProperties) {

        return new MapProperty(nestedProperties)
    }

    static ArrayList(PropertyTypeValidator propertyType) {

        return new ArrayListProperty(propertyType)
    }
}

class ArrayListProperty implements PropertyTypeValidator {

    PropertyTypeValidator propertyType

    ArrayListProperty(PropertyTypeValidator propertyType) {
        this.propertyType = propertyType
    }

    boolean validate(TrackValidationResponse response, String property, Object value) {

        def valid = true

        value.each { val ->
            if(!propertyType.validate(response, property, val)) {
                response.addComment(". The error ocurred at List with value ${val}")
                valid = false
            }
        }

        return valid
    }

}

class MapProperty implements PropertyTypeValidator {
    Map<String,TrackDefinitionProperty> nestedProperties

    MapProperty(Map<String,TrackDefinitionProperty> nestedProperties) {
        this.nestedProperties = nestedProperties
    }

    boolean validate(TrackValidationResponse response, String property, Object value) {

        def valid = true

        try {
            nestedProperties.each { k, v ->
                def mapProperty = value[k]
                if(!v.validate(response, k, mapProperty)) {
                    response.addComment(". The error ocurred at property '${property}'")
                    valid = false
                }

            }
        } catch (Exception e) {
            response.addValidation(false, "Property '${property}' was expected as map or array of maps but ${value?.class} was received")
            valid = false

        }

        return valid

    }

}

public enum SimpleProperty implements PropertyTypeValidator{
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

    boolean validate(TrackValidationResponse response, String property, Object value) {

        if(this.validate(value))
            return true

        response.addValidation(false, "Property '${property}' has invalid type '${value?.class}'. (value must be: ${this})")
        return false
    }
}