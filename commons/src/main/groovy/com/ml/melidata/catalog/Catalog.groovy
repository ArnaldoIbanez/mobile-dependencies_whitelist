package com.ml.melidata.catalog

import com.ml.melidata.Track
import com.ml.melidata.catalog.exceptions.CatalogException
import com.ml.melidata.catalog.initiatives.InitiativeAPI
import com.ml.melidata.catalog.tree.CatalogTree
import com.ml.melidata.catalog.tree.PlatformTree
import com.ml.melidata.catalog.tree.TrackValidationResponse
import com.ml.melidata.catalog.tree.TreeNode

/**
 * Created by geisbruch on 11/13/14.
 */
class Catalog implements CatalogInterface{

    //This map is <Business, PlatformTree>
    def Map<String,PlatformTree> platformTrees

    def platforms = []

    def abPlatforms = []

    def abPlatformsSubscriptions = []

    def defaultBusiness

    def CatalogCoverage catalogCoverage

    Set<File> includedFiles = new HashSet<File>()

    def Catalog() {
        platformTrees = new HashMap<String,PlatformTree>()
        catalogCoverage = new CatalogCoverage(this)
    }

    def addBusiness(String business) {
        if ( ! platformTrees.containsKey(business) ) {
            def p = new PlatformTree()
            platforms.each { platform ->
                addPlatform(p, platform)
            }
            platformTrees.put(business, p);
        }
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

    def addAbPlatforms(platforms) {
        abPlatforms.addAll(platforms)
    }

    def addAbPlatformsSubscriptions(platforms) {
        abPlatformsSubscriptions.addAll(platforms)
    }


    def addFile(File file) {
        includedFiles.add(file)
    }

    Collection<File> getFiles() {
        return includedFiles
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
        PlatformTree platformNode = platformTree.getNodeByPath(trackDefinition.platform);
        if(!platformNode) {
            throw new CatalogException("Platform ${trackDefinition.platform} not found");
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
    TrackValidationResponse validate(Track track) {
        return validate(track, false)
    }

    /**
     * It should validate a track object checking if the track matches the
     * definition
     *
     * @param track
     * @param serverSide if the validate occurs on server o client side
     * @return
     */
    @Override
    def TrackValidationResponse validate(Track track, boolean serverSide) {
        TrackValidationResponse tr = new TrackValidationResponse();
        try {

            def catalogDefinition = getTrackDefinition(track)

            if ( catalogDefinition != null ) {
                return catalogDefinition.validate(track, serverSide)
            } else {
                tr.addValidation(false, "Path '${track.path}' not found in catalog (check if it's defined in the catalog file and if it's defined for the specified platform & business")
                return tr
            }
        }catch (CatalogException e) {
            tr.addValidation(false, e.message)
            return tr
        }
    }

    String getTrackInitiativeWithFallBack(Track singleTrack) {
        def trackInitiative = this.getTrackInitiative(singleTrack)
        def trackApplication = this.getTrackApplication(singleTrack)

        if(!trackInitiative && trackApplication) {
            trackInitiative = InitiativeAPI.getInstance().getInitiativeFromApplication(trackApplication)
        }

        return trackInitiative
    }

    private String getTrackInitiative(Track track) {
        def catalogDefinition = getTrackDefinition(track)

        return catalogDefinition.getTrackInitiative()
    }

    private String getTrackApplication(Track track) {
        def catalogDefinition = getTrackDefinition(track)

        if ( catalogDefinition != null ) {
            return catalogDefinition.getTrackApplication(track.platform)
        } else {
            throw new CatalogException("Application for track ${track.path} ${track.business} ${track.platform} not found")
        }
    }

    def String getDefaultBusiness(b) {
        return b != null ? b : defaultBusiness
    }

    def getTrackDefinition(Track track) {
        def business = getDefaultBusiness(track.business)

        def platformTree = platformTrees.get(business)
        if(!platformTree) {
            throw new CatalogException("Business ${business} not found")
        }
        PlatformTree platformNode = platformTree.getNodeByPath(track.platform)
        if(!platformNode) {
            throw new CatalogException("Platform '${track.platform}' not found")
        }

        return platformNode.getTrackDefinition(track.path)
    }
}
