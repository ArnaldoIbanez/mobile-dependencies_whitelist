import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //Myaccount_Billing
    "/myaccount"(type: TrackType.View, isAbstract: true) {}
    "/myaccount/billing"(type: TrackType.View, isAbstract: true) {}
    "/myaccount/billing/detail"(type: TrackType.View) {
        userId(type: PropertyType.Numeric, required: true)
        openedBill(type: PropertyType.Boolean, required: false)
        siteId(type: PropertyType.String, required: false)
    }

    "/myaccount/billing/detail/collapsible"(type: TrackType.Event) {
    }
}
