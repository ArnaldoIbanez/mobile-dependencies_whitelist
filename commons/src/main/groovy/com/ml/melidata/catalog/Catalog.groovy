package com.ml.melidata.catalog

/**
 * Created by geisbruch on 11/10/14.
 */


class Catalog {



    def TrackDefinitionNode tree;

    def Map trackPathIdx = [:]

    def Catalog() {
        tree = new TrackDefinitionNode();
    }

    public addTrackDefinition(TrackDefinition trackDefinition) {

        Queue<TrackDefinitionNode> childrens = new LinkedList<TrackDefinitionNode>();
        childrens.add(tree.addChildren(trackDefinition));
        while(childrens.size()>0) {
            TrackDefinitionNode c = childrens.pop();
            trackPathIdx.put(c.definitions.path, c.definitions);
            childrens.addAll(c.children);
        }
    }



    public String validate(Track track) {
        def trackDefinition = trackPathIdx.get(track.path);
        if(!trackDefinition) {
            print("Path ${track.path} doesn't exist");
        }
        trackDefinition.validate(track);
    }


    public static void main(String[] args) {



        Catalog validator = new Catalog();

        validator.addTrackDefinition(new TrackDefinition("/search")
            .addProperty(new TrackDefinitionProperty(name: "layout",description: "The layout used in the search query"))
            .addProperty(new TrackDefinitionProperty(name: "query", description: "Query wrote by the user", required: true)))

        validator.addTrackDefinition(new TrackDefinition("/search/refine/f1")
                .addProperty(new TrackDefinitionProperty(name: "f1",description: "value of f1", required: true)))


        validator.addTrackDefinition(new TrackDefinition("/search/refine")
                .addProperty(new TrackDefinitionProperty(name: "filter",description: "filter applied by the user", required: true)))


        Track t1 = new Track();
        t1.path ="/search/refine/f1";
        println("validando falta filter y f1")
        t1.properties.putAll(["query":"hola mundo","layout":"pe"])
        println(validator.validate(t1));


        println("validando f1")
        t1.properties.putAll(["filter":"pepito"])
        println(validator.validate(t1));

        println("validando ok")
        t1.properties.putAll(["f1":"s"])
        println(validator.validate(t1));

        t1.properties.putAll(["pepeito<":"s"])
        println(validator.validate(t1));

    }

}
