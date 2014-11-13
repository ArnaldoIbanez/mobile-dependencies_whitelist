package com.ml.melidata.catalog
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
    def ArrayList<String> values

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        TrackDefinitionProperty that = (TrackDefinitionProperty) o

        if (name != that.name) return false

        return true
    }

    def hasValue(String value){
        return this.values.find {v -> v.equals(value)} != null
    }

    int hashCode() {
        int result
        result = (name != null ? name.hashCode() : 0)

        return result
    }
}
