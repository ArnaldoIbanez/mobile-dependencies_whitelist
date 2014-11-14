package com.ml.melidata.catalog

import com.ml.melidata.catalog.tree.TrackValidationResponse

/**
 * Created by apetalas on 13/11/14.
 */

public abstract class Validator {

    abstract void validate(TrackValidationResponse response, Object value)
}

public class ValuesValidator extends Validator{

    private ArrayList<String> values;

    def ValuesValidator(ArrayList<String> values){
        this.values = values
    }

    @Override
    void validate(TrackValidationResponse response, Object value) {
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
    void validate(TrackValidationResponse response, Object value) {
        if(!(value ==~ this.regex))
            response.addValidation(false, "Property has invalid value '${value}'. (value must match with: ${this.regex})")
    }
}

public class TypeValidator extends Validator {

    private def type

    def TypeValidator(type){
        this.type = type
    }

    @Override
    void validate(TrackValidationResponse response, Object value) {
        if(value.class != type)
            response.addValidation(false, "Property has invalid type '${value.class}'. (value must be: ${this.type})")

    }
}

public class CategoryValidator extends RegexValidator{

    def CategoryValidator() {
        super(/[a-zA-Z]{1,3}[0-9]+/)
    }
}