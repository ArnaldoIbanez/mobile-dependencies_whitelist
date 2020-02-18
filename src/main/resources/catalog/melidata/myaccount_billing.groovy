package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1014"

    //Myaccount_Billing
    "/myaccount"(type: TrackType.View, isAbstract: true) {}
    "/myaccount/billing"(type: TrackType.View, isAbstract: true) {}
    "/myaccount/billing/summary"(type: TrackType.View) {
        bills_to_pay(type: PropertyType.Numeric, required: true)
        total_debt(type: PropertyType.Numeric, required: true)
        has_automatic_debit(type: PropertyType.Boolean, required: true)
        completed(type: PropertyType.Boolean, required: true)

    }
    "/myaccount/billing/detail"(type: TrackType.View) {
        opened_bill(type: PropertyType.Boolean, required: false)
    }

    "/myaccount/billing/detail/collapsible"(type: TrackType.Event) {
        row_type(type: PropertyType.String, required: true)
    }
}
