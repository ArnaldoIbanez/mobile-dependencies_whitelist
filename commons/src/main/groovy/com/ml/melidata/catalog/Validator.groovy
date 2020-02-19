package com.ml.melidata.catalog

import com.ml.melidata.catalog.tree.TrackValidationResponse

/**
 * Created by apetalas on 13/11/14.
 */

public interface Validator {
    boolean validate(TrackValidationResponse response, String property,Object value, boolean required)
}

public abstract class ValidatorFactory {

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
}

public class RegexValidator implements Validator{

    private def regex

    def RegexValidator(regex){
        this.regex = regex
    }


    boolean validate(TrackValidationResponse response, String property, Object value, boolean required=true) {
        def valid = true
        if(!(value ==~ regex))
            response.addValidation(false, "Property '${property}' has invalid value '${value}'. (value must match with: ${this.regex})")
            valid = false

        return valid
    }
}

public class TypeValidator implements Validator {

    private def PropertyTypeValidator type = null

    def TypeValidator(PropertyTypeValidator type){
        this.type = type
    }

    boolean validate(TrackValidationResponse response, String property, Object value, boolean required=true) {

        if(!required) return true
        return type?.validate(response, property, value)
    }
}

public class CategoryValidator extends RegexValidator{

    def CategoryValidator() {
        super(/[a-zA-Z]{1,3}[0-9]+/)
    }
}

public class ValuesValidator implements Validator{

    private ArrayList<String> values;

    def ValuesValidator(ArrayList<String> values){
        this.values = values
    }


    boolean validate(TrackValidationResponse response, String property,Object value, boolean required=true) {
        def valid = true

        if(!required && value == null)
            return true;
        if(!values.find{va -> va.equals(value)}) {
            response.addValidation(false, "Property '${property}' has invalid value '${value}'. (possible values: ${this.values})")
            valid = false
        }

        return valid

    }
}