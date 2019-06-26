import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
     * Singe player Antenna Screen Tracks
     */
    "/antenna"(platform: "/mobile", isAbstract: true) {}

    "/antenna/manual_input"(platform: "/mobile", type: TrackType.View) {
        company (required: false, type: PropertyType.String, description: "Name of the company")
    }
    "/antenna/topup_helper" (platform: "/mobile", type:TrackType.View) {}
}