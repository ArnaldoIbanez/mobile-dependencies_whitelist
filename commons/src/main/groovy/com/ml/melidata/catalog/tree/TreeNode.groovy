package com.ml.melidata.catalog.tree

import com.ml.melidata.catalog.TrackDefinition
import sun.reflect.generics.tree.Tree

/**
 * Created by geisbruch on 11/11/14.
 */
abstract class TreeNode<P>{

    def segment

    def Map<String,TreeNode> children = [:];

    def TreeNode(String segment) {
        this.segment = segment
    }

    def addNode(String path, P data = null, override=false) {
        def segments = getSegments(path);
        def List<TreeNode<P>> parents = []
        def localNode = this;
        segments.each { s ->
            parents.add(localNode);
            if(localNode.children[s] == null) {
                localNode.children[s] = this.class.newInstance(s);
            }
            localNode = localNode.children[s]
        }

        return localNode.setNodeData(data, parents.subList(1,parents.size), override);
    }

    public abstract def setNodeData(P data, List<TreeNode<P>> parents, Boolean override);

    def getSegments(String path) {
        def segments = path.split("/");
        if(segments.size() == 0) {
            segments+="/"
        }else {
            segments[0]="/"
        }
        return segments
    }
    public abstract def P getNodeData();

    def TreeNode<P> getNodeByPath(String path) {
        def segments = getSegments(path)
        def localNode = this;
        for(s in segments) {
            localNode = getChildBySegment(s,localNode);
            if(!localNode)
                return null;
        }
        return localNode;
    }

    def getChildBySegment(String segment, TreeNode<P> node = this) {

        return  node.children[segment]
    }



}
