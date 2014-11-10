/**
 * Created by geisbruch on 11/10/14.
 */

enum Platform {
    Desktop, Mobile, all
}

enum SubPlatform {
    Android, IOS, all
}

enum TrackType {
    View, Event, Email
}

class TrackDefinition {
    def String path = ""
    def Platform platform;
    def SubPlatform subPlatform;
    def Map<String,TrackDefinitionProperty> properties = [:];
    def TrackType type;
    def TrackDefinition(String path, TrackType type = TrackType.View,
                        Platform platform = Platform.all, SubPlatform subPlatform = SubPlatform.all) {
        this.path = path;
        this.platform = platform;
        this.subPlatform = subPlatform;
        this.type = type;
    }


    def addProperty(TrackDefinitionProperty p) {
        this.properties.put(p.name, p);
        this
    }

    def Boolean validate(Track t) {
        def comments = ""
        def status = true;
        t.properties.each { property, value ->
            def p = properties.get(property);
            if(!p) {
                status = false;
                comments+="Property ${property} is not cataloged\n";
            }
        }
        properties.each { k , v ->
            if(v.required && t.properties.get(v.name)==null) {
                status = false;
                comments+="Property ${k} is required\n"
            }
        }

        println(comments);
        return status
    }
}
