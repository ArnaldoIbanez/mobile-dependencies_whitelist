package com.ml.melidata.catalog

import com.ml.melidata.catalog.exceptions.CatalogException
import com.ml.melidata.catalog.tree.TrackValidationResponse

/**
 * Created by geisbruch on 11/10/14.
 */

enum PropertyType {
    String, Numeric, Timestamp
}
class TrackDefinitionProperty {

    def String name;
    def String description;
    def PropertyType type = PropertyType.String;
    def Boolean required = false;
    def ArrayList<String> values = null
    def String regex = null
    def ArrayList<Validator> validators

    def setRegex(String regex){
        this.validators.push(Validator.CreateRegexValidator(regex))
        this.regex = regex
    }

    def setType(PropertyType type){
        this.validators.push(Validator.CreateTypeValidator(type))
        this.type = type
    }

    def setValues(ArrayList<String> vals){
        this.validators.push(Validator.CreateValuesValidator(vals))
        this.values = vals
    }

    public TrackDefinitionProperty(Map map) {
        this.validators = new ArrayList<Validator>()
        map?.each { k, v ->
          this[k] = v
        }
        if(regex && values) {
            throw new CatalogException("Regex and Values can't be defined together in the same property");
        }
    }


    def hasValue(String value){
        return this.values.find {v -> v.equals(value)} != null
    }


    def validate(TrackValidationResponse response, def trackPropertyValue){
        validators.each { v -> v.validate(response, trackPropertyValue)}
    }
}
