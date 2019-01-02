package com.ml.melidata.catalog

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.tree.TrackValidationResponse

import java.sql.Timestamp

/**
 * Created by apetalas on 13/11/14.
 */

public abstract class Validator {

    abstract void validate(TrackValidationResponse response, String property,Object value, boolean required)

    public static CreateValuesValidator(ArrayList<String> values){
        return new ValuesValidator(values)
    }

    public static CreateRegexValidator(regex){
        return new RegexValidator(regex)
    }

    public static CreateTypeValidator(type){
        return new TypeValidator(type)
    }

    public static CreateCategoryValidator(){
        return new CategoryValidator()
    }

    public static CreateNestedValidator(Map<String,TrackDefinitionProperty> properties){
        return new NestedValidator(properties)
    }
}

public class RegexValidator extends Validator{

    private def regex

    def RegexValidator(regex){
        this.regex = regex
    }


    void validate(TrackValidationResponse response, String property, Object value, boolean required=true) {
        if(!(value ==~ regex))
            response.addValidation(false, "Property '${property}' has invalid value '${value}'. (value must match with: ${this.regex})")
    }
}

public class TypeValidator extends Validator {

    private def PropertyType type = null

    def TypeValidator(PropertyType type){
        this.type = type
    }


    void validate(TrackValidationResponse response, String property, Object value, boolean required=true) {

        if(type?.validate(value))
            return

        response.addValidation(false, "Property '${property}' has invalid type '${value?.class}'. (value must be: ${type})")
    }
}

public class CategoryValidator extends RegexValidator{

    def CategoryValidator() {
        super(/[a-zA-Z]{1,3}[0-9]+/)
    }
}

public class NestedValidator extends Validator {

    private Map<String,TrackDefinitionProperty> properties = [:]

    def NestedValidator(Map<String,TrackDefinitionProperty> properties) {

        this.properties = properties
    }


    void validate(TrackValidationResponse response, String property, Object value, boolean required=true) {

        if(!required) return
        properties.each { k, v ->
            def mapProperty = value[k]
            v.validate(response, k, mapProperty)
        }

        if(!response.status) {
            response.addValidation(false, "The error ocurred in property '${property}'")
        }

    }
}