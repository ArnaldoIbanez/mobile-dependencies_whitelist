import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/denounce"(platform: "/", isAbstract: true) {}

    "/denounce/form"(platform: "/", type: TrackType.View) {}
    "/denounce/form/success"(platform: "/", type: TrackType.View) {}

    "/denounce/form/error"(platform: "/", type: TrackType.View) {}
    "/denounce/error"(platform: "/", type: TrackType.View) {}
}
