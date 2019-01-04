import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/make-an-offer"(platform: "/", isAbstract: true) {}
    "/make-an-offer/congrats"(platform: "/") {}
    "/make-an-offer/send-offer"(platform: "/", type: TrackType.Event) {
        offer(required: true, type: PropertyType.Numeric ,  description: "offer value of an item")
    }
}