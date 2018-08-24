import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

tracks {
    "/seller_central"(platform: "/", type: TrackType.View) {}
    "/seller_central/listings"(platform: "/", type: TrackType.View) {}
    "/seller_central/listings/list"(platform: "/", type: TrackType.View) {}
    "/seller_central/listings/filters"(platform: "/", type: TrackType.Event) {}
    "/seller_central/listings/action"(platform: "/", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "Action id")
    }
}
