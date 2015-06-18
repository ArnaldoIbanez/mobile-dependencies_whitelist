package com.ml.melidata.catalog

import com.ml.melidata.catalog.tree.TrackValidationResponse


/**
 * Created by apetalas on 13/11/14.
 */

public abstract class Validator {

    abstract void validate(TrackValidationResponse response, String property,Object value, boolean required, TrackSourceType sourceType, TrackSourceType globalSourceType)

    public static CreateValuesValidator(List<String> values){
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

    void validate(TrackValidationResponse response, String property,Object value, boolean required=true, TrackSourceType sourceType = TrackSourceType.CLIENT, TrackSourceType globalSourceType = TrackSourceType.CLIENT) {
        if(!required && value == null)
            return;
        if(!values.find{va -> va.equals(value)} && (globalSourceType in [TrackSourceType.ALL, sourceType]))
            response.addValidation(false, "Property '${property}' has invalid value '${value}'. (possible values: ${this.values})")
    }
}

public class RegexValidator extends Validator{

    private def regex

    def RegexValidator(regex){
        this.regex = regex
    }

    void validate(TrackValidationResponse response, String property, Object value, boolean required=true, TrackSourceType sourceType = TrackSourceType.CLIENT, TrackSourceType globalSourceType = TrackSourceType.CLIENT) {
        if(!(value ==~ regex))
            response.addValidation(false, "Property '${property}' has invalid value '${value}'. (value must match with: ${this.regex})")
    }
}

public class TypeValidator extends Validator {

    private def PropertyType type = null

    def TypeValidator(PropertyType type){
        this.type = type
    }

    void validate(TrackValidationResponse response, String property, Object value, boolean required=true, TrackSourceType sourceType = TrackSourceType.CLIENT, TrackSourceType globalSourceType = TrackSourceType.CLIENT) {

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