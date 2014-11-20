package com.ml.melidata.catalog

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.tree.TrackValidationResponse

import java.sql.Timestamp

/**
 * Created by apetalas on 13/11/14.
 */

public abstract class Validator {

    abstract void validate(TrackValidationResponse response, Object value, boolean required=true)

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

public class ValuesValidator extends Validator{

    private ArrayList<String> values;

    def ValuesValidator(ArrayList<String> values){
        this.values = values
    }

    @Override
    void validate(TrackValidationResponse response, Object value, boolean required=true) {
        if(!required && value == null)
            return;
        if(!values.find{va -> va.equals(value)})
            response.addValidation(false, "Property has invalid value '${value}'. (possible values: ${this.values})")
    }
}

public class RegexValidator extends Validator{

    private def regex

    def RegexValidator(regex){
        this.regex = regex
    }

    @Override
    void validate(TrackValidationResponse response, Object value, boolean required=true) {
        if(!(value ==~ regex))
            response.addValidation(false, "Property has invalid value '${value}'. (value must match with: ${this.regex})")
    }
}

public class TypeValidator extends Validator {

    private def type = null

    def TypeValidator(type){
        this.type = type
    }

    @Override
    void validate(TrackValidationResponse response, Object value, boolean required=true) {
        if(type == PropertyType.Numeric && value?.class == Integer.class)
            return
        if(type == PropertyType.String && value?.class == String.class)
            return
        if(type == PropertyType.Timestamp && value?.class == Timestamp.class)
            return
        if(type == value?.class)
            return

        response.addValidation(false, "Property has invalid type '${value?.class}'. (value must be: ${type})")

    }
}

public class CategoryValidator extends RegexValidator{

    def CategoryValidator() {
        super(/[a-zA-Z]{1,3}[0-9]+/)
    }
}