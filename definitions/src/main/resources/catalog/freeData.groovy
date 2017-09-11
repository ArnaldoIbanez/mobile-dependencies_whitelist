import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

/**
 *  Tracks for the Free Data project where Mercado Libre pays for its users mobile data consumption.
 */
tracks {

    "/free_data"(platform: "/mobile", type: TrackType.Event) {
        sponsored_data()
    }
}