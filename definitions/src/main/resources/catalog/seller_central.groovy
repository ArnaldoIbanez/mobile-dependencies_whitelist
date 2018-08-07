import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/seller_central"(platform: "/", type: TrackType.View) {}
    "/seller_central/listings"(platform: "/", type: TrackType.View) {}
    "/seller_central/listings/list"(platform: "/", type: TrackType.View) {}
    "/seller_central/listings/filters"(platform: "/", type: TrackType.Event) {}

}
