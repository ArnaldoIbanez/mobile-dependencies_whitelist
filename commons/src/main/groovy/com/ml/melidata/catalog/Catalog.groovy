package com.ml.melidata.catalog

import com.ml.melidata.catalog.exceptions.CatalogException
import com.ml.melidata.catalog.tree.CatalogTree
import com.ml.melidata.catalog.tree.PlatformTree
import com.ml.melidata.catalog.tree.TrackValidationResponse
import com.ml.melidata.catalog.tree.TreeNode

/**
 * Created by geisbruch on 11/13/14.
 */
class Catalog implements CatalogInterface{

    PlatformTree platformTree;

    def Catalog() {
        platformTree = new PlatformTree();
    }

    def addPlatform(String platform) {
        platformTree.addNode(platform, new CatalogTree(), true);
    }



    /**
     * It should enable to add new definitions to the catalog
     *
     * WARNING: all platforms should be added before add a track definition, if not
     * you could have hierarchy problems
     *
     * @param trackDefinition
     * @return
     */
    @Override
    def addTrackDefinition(TrackDefinition trackDefinition) {
        def platformNode = platformTree.getNodeByPath(trackDefinition.platform);
        if(!platformNode) {
            throw new CatalogException("Platform ${platformPath} not found");
        }
       platformNode.addTrackDefinition(trackDefinition);
    }

    /**
     * It should validate a track object checking if the track matches the
     * definition
     *
     * @param track
     * @return
     */
    @Override
    def validate(Track track) {
        TrackValidationResponse tr = new TrackValidationResponse();
        try {
            def PlatformTree platformNode = platformTree.getNodeByPath(track.platform);
            def catalogDefinition = platformNode.getTrackDefinition(track.path);
            return catalogDefinition.validate(track)
        }catch (CatalogException e) {
            tr.addValidation(false, e.message)
            return tr
        }

    }
}
