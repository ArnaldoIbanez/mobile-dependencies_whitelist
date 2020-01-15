import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    //My Account
    "/myaccount"(type: TrackType.View, isAbstract: true) {}
    "/myaccount/search_alerts"(type: TrackType.View, isAbstract: true) {}
    "/myaccount/search_alerts/list"(platform: "/", type: TrackType.View) {
        quantity(required: true, type: PropertyType.Numeric, description: "Quantity of search alerts")
    }
}
