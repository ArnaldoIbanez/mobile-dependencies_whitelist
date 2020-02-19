package com.ml.melidata.catalog.parsers.json

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.Catalog
import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty
import com.ml.melidata.catalog.tree.CatalogTree
import com.ml.melidata.catalog.tree.PlatformTree
import groovy.json.JsonBuilder
import org.json.simple.JSONObject
import org.json.simple.JSONValue

import javax.swing.tree.TreeNode
import java.util.concurrent.LinkedBlockingQueue

/**
 * Created by geisbruch on 12/16/14.
 */
class CatalogJsonOutput {

    def toMap(Catalog c) {
        def tracks = []
        def platforms = []
        c.platformTrees.each { business, platformTree ->
            plainTree(platformTree).each { platformPath, PlatformTree pTree ->
                platforms.add(platformPath)
                    if(pTree.nodeData) {
                    plainTree(
                            pTree.nodeData).each { path, CatalogTree cTree ->
                        def track = tracksFromNodeTree(cTree)
                        if(track.size() != 0) {
                            track["platform"] = platformPath
                            track["business"] = business
                            tracks.add(track)
                        }
                    }
                }
            }
        }
        return ["platforms":platforms, "tracks":tracks, "business":c.platformTrees.keySet().toList(), "default_business":c.defaultBusiness]
    }

    def tracksFromNodeTree(CatalogTree cTree){
        TrackDefinition definition = (TrackDefinition) cTree.nodeData
        def track = [:]
        if(definition == null) return track;
        track["path"] = definition.path

        def properties = []
        definition.properties.each { name, propDefinition ->
            def propDefinitionMap = ["name":name];
            propDefinitionMap["description"] = propDefinition.description
            propDefinitionMap["required"] = propDefinition.required
            propDefinitionMap["type"] = propDefinition.type.toString()
            if(propDefinition.regex) {
                propDefinitionMap["regex"] = propDefinition.regex
            } else if(propDefinition.values) {
                propDefinitionMap["values"] = propDefinition.values
            }
            properties.add(propDefinitionMap);
        }
        track["properties"] = properties;
        return track
    }

    def toJson(Catalog c) {
        def m = toMap(c);
        return JSONValue.toJSONString(m).replaceAll("\\\\/","/")

    }

    def plainTree(com.ml.melidata.catalog.tree.TreeNode tree) {
        def plainTree = [:]

        def workingPaths = [:]

        if(tree.segment == null) {
            tree.children.each { k,v ->
                workingPaths[k] = v
            }
        } else {
            workingPaths[tree.segment] = tree;
        }

        while(workingPaths.size() > 0) {
            def newWorking = [:]
            workingPaths.each {path, com.ml.melidata.catalog.tree.TreeNode t ->
                plainTree[path] = t
                t.children.each { newSegment, newTree ->
                    if("/".equals(path))
                        path=""
                    newWorking[path+"/"+newSegment] = newTree
                }
            }
            workingPaths = newWorking;
        }
        return plainTree
    }
}
