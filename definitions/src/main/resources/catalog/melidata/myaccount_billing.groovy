import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //Myaccount_Billing
    "/myaccount"(type: TrackType.View, isAbstract: true) {}
    "/myaccount/billing"(type: TrackType.View, isAbstract: true) {}
    "/myaccount/billing/detail"(type: TrackType.View) {
        opened_bill(type: PropertyType.Boolean, required: false)
    }

    "/myaccount/billing/detail/collapsible"(type: TrackType.Event) {
        row_type(type: PropertyType.String, required: true)
    }
}
