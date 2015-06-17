package com.ml.melidata.catalog

import com.ml.melidata.Track
import com.ml.melidata.catalog.exceptions.CatalogException
import com.ml.melidata.catalog.tree.CatalogTree
import com.ml.melidata.catalog.tree.PlatformTree
import com.ml.melidata.catalog.tree.TrackValidationResponse

/**
 * Created by geisbruch on 11/13/14.
 */
class Catalog implements CatalogInterface{

    //This map is <Business, PlatformTree>
    def Map<String,PlatformTree> platformTrees;

    def platforms = []

    def defaultBusiness;

    def Catalog() {
        platformTrees = new HashMap<String,PlatformTree>()
    }

    def addBusiness(String business) {
        def p = new PlatformTree();
        platforms.each {platform ->
            addPlatform(p, platform)
        }
        platformTrees.put(business, p);

    }

    def addPlatform(String platform) {
        platforms.add(platform)
        platformTrees.each { k, v ->
            addPlatform(v,platform)
        }

    }

    def addPlatform(PlatformTree tree , String platform) {
        tree.addNode(platform, new CatalogTree(), true);
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
        def business = getDefaultBusiness(trackDefinition.business)
        def platformTree = platformTrees.get(business)
        if(platformTree == null ) {
            throw new CatalogException("Business ${business} not found");
        }
        def platformNode = platformTree.getNodeByPath(getDefaultBusiness(trackDefinition.platform));
        if(!platformNode) {
            throw new CatalogException("Platform ${trackDefinition.platform} not found");
        }
       platformNode.addTrackDefinition(trackDefinition);
    }

    def TrackValidationResponse validate(Track track, String platform) {

    }
    /**
     * It should validate a track object checking if the track matches the
     * definition
     *
     * @param track
     * @return
     */
    @Override
    def TrackValidationResponse validate(Track track, TrackSourceType sourceType = TrackSourceType.CLIENT) {
        def business = getDefaultBusiness(track.business);
        TrackValidationResponse tr = new TrackValidationResponse();
        try {
            def platformTree = platformTrees.get(business);
            if(!platformTree) {
                throw new CatalogException("Business ${business} not found");
            }
            def PlatformTree platformNode = platformTree.getNodeByPath(track.platform);
            if(!platformNode) {
                throw  new CatalogException("Platform '${track.platform}' not found")
            }
            def catalogDefinition = platformNode.getTrackDefinition(track.path);

            return catalogDefinition.validate(track,sourceType)
        }catch (CatalogException e) {
            tr.addValidation(false, e.message)
            return tr
        }

    }

    def String getDefaultBusiness(b) {
        return b != null ? b : defaultBusiness
    }
}
