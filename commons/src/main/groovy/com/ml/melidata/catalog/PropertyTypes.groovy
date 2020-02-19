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

    static Map(PropertyTypeValidator keys, PropertyTypeValidator values) {

        return new ClassicMapProperty(keys, values)
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

class ClassicMapProperty implements PropertyTypeValidator {
    PropertyTypeValidator keys
    PropertyTypeValidator values

    ClassicMapProperty(PropertyTypeValidator keys, PropertyTypeValidator values) {
        this.keys = keys
        this.values = values
    }

    boolean validate(TrackValidationResponse response, String property, Object value) {

        def valid = true

        value.each { k, v ->
            if(!keys.validate(response, property, k)) {
                response.addComment(". The error ocurred at key with value ${k}")
                valid = false
            }

            if(!values.validate(response, property, v)) {
                response.addComment(". The error ocurred at value with value ${v}")
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
        def mapErrorComment = ". The error ocurred at map property '${property}'"

        if (!(value instanceof Map)) {
            response.addValidation(false, "Property '${property}' was expected as map or array of maps but ${value.class} was received in it")
            return false
        }

        value.each { k, v ->
            if(nestedProperties[k] == null && v != null) {
                response.addValidation(false, "Property '${k}' is not cataloged" +
                        " (you can't add properties to a track that are not declared in the catalog)" + mapErrorComment)
                valid = false
            }
        }



        nestedProperties.each { k, v ->
            def mapProperty = value[k]
            if(mapProperty == null && v.required) {
                response.addValidation(false, "Property '${k}'" +
                        "${v.description?'('+v.description+')':''} is required" + mapErrorComment)
            } else {
                if(!v.validate(response, k, mapProperty)) {
                    response.addComment(mapErrorComment)
                    valid = false
                }
            }
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