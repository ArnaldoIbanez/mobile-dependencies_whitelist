import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1171"

    //Messages
    "/notification/messages_new"(platform: "/") {}
    "/notification/messages_read"(platform: "/") {}
    "/notification/messages_driver_logistics"(platform: "/") {}
    "/notification/messages_driver_flex"(platform: "/") {}
    "/notification/messages_flex"(platform: "/") {}
    "/notification/messages_quotes"(platform: "/") {}
}