package com.ml.melidata.catalog

import com.ml.melidata.catalog.exceptions.CatalogException
import com.ml.melidata.catalog.tree.TrackValidationResponse

/**
 * Created by geisbruch on 11/10/14.
 */
class TrackDefinitionProperty {

    def String name
    def String description
    def PropertyTypeValidator type = SimpleProperty.String
    def Boolean required = true
    def ArrayList<String> values = null
    def String regex = null
    def ArrayList<Validator> validators
    def Boolean serverSide = false
    def Boolean inheritable = true

    def setRegex(String regex){
        this.validators.push(ValidatorFactory.CreateRegexValidator(regex))
        this.regex = regex
    }

    def setType(PropertyTypeValidator type){
        this.validators.push(ValidatorFactory.CreateTypeValidator(type))
        this.type = type
    }

    def setValues(ArrayList<String> vals){
        this.validators.push(ValidatorFactory.CreateValuesValidator(vals))
        this.values = vals
    }

    def setServerSide(Boolean value) {
        this.serverSide = value
    }

    def setInheritable(Boolean value) {
        this.inheritable = value
    }

    public TrackDefinitionProperty(Map map) {
        this.validators = new ArrayList<Validator>()
        map?.each { k, v ->
            if (this.hasProperty(k)) this[k] = v
        }
        if(regex && values) {
            throw new CatalogException("Regex and Values can't be defined together in the same property");
        }
    }

    def hasValue(String value){
        return this.values.find {v -> v.equals(value)} != null
    }

    def validate(TrackValidationResponse response, def property, def trackPropertyValue){
        def valid = true
        validators.each { v ->
            valid = valid && v.validate(response, property, trackPropertyValue, required)
        }

        return valid
    }
}