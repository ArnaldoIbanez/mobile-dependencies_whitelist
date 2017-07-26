import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

/**
 * The events means actions related to the application,
 * as example of that we can consider when we open the application
 */

tracks {

    "/application/open"(platform:"/mobile", type: TrackType.Event) { }

}
