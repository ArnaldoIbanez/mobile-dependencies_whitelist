import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/full"(platform: "/", isAbstract: true) {}
    "/full/landing"(platform: "/", isAbstract: true) {}

    /**
     *  Landing for Envios Full
     */

    //Views
    "/full/landing/buyer"(platform: "/", type: TrackType.View) {}

}
