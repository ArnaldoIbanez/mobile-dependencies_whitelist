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

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        TrackDefinitionProperty that = (TrackDefinitionProperty) o

        if (name != that.name) return false

        return true
    }

    int hashCode() {
        int result
        result = (name != null ? name.hashCode() : 0)

        return result
    }
}
