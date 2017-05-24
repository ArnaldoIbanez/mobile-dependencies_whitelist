import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
    // Chekout Flow
    "/checkout_off"(platform: "/", isAbstract: true){

    }
    "/checkout_off/init"(platform: "/", type: TrackType.View) {}
    "/checkout_off/congrats"(platform: "/", type: TrackType.View) {}
}