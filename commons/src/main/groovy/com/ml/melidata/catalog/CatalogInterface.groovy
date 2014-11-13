package com.ml.melidata.catalog

/**
 * Created by geisbruch on 11/11/14.
 */
interface CatalogInterface {

    /**
     * It should enable to add new definitions to the catalog
     *
     * @param trackDefinition
     * @return
     */
    def addTrackDefinition(TrackDefinition trackDefinition);

    /**
     * It should validate a track object checking if the track matches the
     * definition
     *
     * @param track
     * @return
     */
    def validate(Track track);
}
