import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //Myaccount_Billing
    "/myaccount"(platform: "/", isAbstract: true) {}
    "/myaccount/billing"(platform: "/", isAbstract: true) {}

    "/myaccount/billing/detail"(type: TrackType.View) {
        userId(type: PropertyType.Numeric, required: false)
        openedBill(type: PropertyType.Boolean, required: false)
        siteId(type: PropertyType.String, required: false)
    }
    "/myaccount/billing/detail"(platform: "/", isAbstract: true) {}

    "/myaccount/billing/detail/collapsible"(type: TrackType.Event) {
        userId(type: PropertyType.Numeric, required: false)
        openedBill(type: PropertyType.Boolean, required: false)
        siteId(type: PropertyType.String, required: false)
    }
}
