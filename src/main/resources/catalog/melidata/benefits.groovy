package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /******************************************
    *  Vouchers - Benefits  *
    ******************************************/

    // Vouchers - Benefits
    "/vouchers"(platform: "/", type: TrackType.View) {}
    "/benefits"(platform: "/", type: TrackType.View) {}

    // Vouchers - Settings
    "/benefits/settings"(platform: "/", type: TrackType.Event) {}

    // Vouchers - Categories
    "/benefits/categories"(platform: "/", type: TrackType.Event) {}

    // Vouchers - Account switch
    "/benefits/account-money"(platform: "/", isAbstract: true) {}
    "/benefits/account-money/switch"(platform: "/", type: TrackType.Event) {}

    // Vouchers - Activities
    "/benefits/activities"(platform: "/", isAbstract: true) {}
    "/benefits/activities/row"(platform: "/", type: TrackType.Event) {}
    "/benefits/activities/footer"(platform: "/", type: TrackType.Event) {}

    // Vouchers - MP Card
    "/benefits/card"(platform: "/", type: TrackType.Event) {}

    // Vouchers - Help
    "/benefits/help"(platform: "/", type: TrackType.Event) {}


}
