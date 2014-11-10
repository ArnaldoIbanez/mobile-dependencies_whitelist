/**
 * Created by geisbruch on 11/10/14.
 */
class TrackDefinitionNode {

    private static def pathRegex = ~/\/(\w+)/

    def String segment;

    def TrackDefinitionNode(String segment = "/") {
        this.segment = segment;
    }

    def TrackDefinition originalDefinition;

    def TrackDefinition definitions;

    def TrackDefinitionNode[] children = [];

    def TrackDefinitionNode addChildren(TrackDefinition trackDefinition, Boolean override=false) {
        TrackDefinition finalDefinition = new TrackDefinition(trackDefinition.path);
        def localTree= this;
        def pathParts = trackDefinition.path =~ pathRegex;

        pathParts.each { part ->
            def localPath = part[1];
            def TrackDefinitionNode node = localTree.getChildren(localPath)
            if(!node) {
                node = new TrackDefinitionNode(localPath);
                localTree.children+=node
            }
            if(node.definitions) {
                finalDefinition.properties.putAll(node.definitions.properties);
            }
            localTree = node;
        }
        if(override || !localTree.definitions) {
            finalDefinition.properties.putAll(trackDefinition.properties);
            localTree.originalDefinition = trackDefinition;
            localTree.definitions = finalDefinition;
            localTree.originalDefinition
            localTree.fireDataChange();
        }
        localTree
    }

    def TrackDefinitionNode getChildren(String segment) {

        for (e in this.children) {
            if (e.segment == segment)
                return e;
        }

        return null;
    }

    def fireDataChange() {

        children.each {c ->
            if(c.originalDefinition) {
                TrackDefinition newDefinition = new TrackDefinition(c.originalDefinition.path)
                newDefinition.properties.putAll(definitions.properties);
                newDefinition.properties.putAll(c.originalDefinition.properties);
                c.definitions=newDefinition
                c.fireDataChange();
            }
        }
    }
}
