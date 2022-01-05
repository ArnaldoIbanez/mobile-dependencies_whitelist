package src.test.resources.melidata

import com.ml.melidata.catalog.PropertyType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadopago"

    /******************************************
    *  Vouchers - Benefits  *
    ******************************************/

    test("Vouchers") {
        "/vouchers"(platform: "/", type: TrackType.View) {}
        "/benefits"(platform: "/", type: TrackType.View) {}

        "/benefits/settings"(platform: "/", type: TrackType.Event) {}
        "/benefits/categories"(platform: "/", type: TrackType.Event) {}

        "/benefits/account-money/switch"(platform: "/", type: TrackType.Event) {}

        "/benefits/activities/row"(platform: "/", type: TrackType.Event) {}
        "/benefits/activities/footer"(platform: "/", type: TrackType.Event) {}

        "/benefits/card"(platform: "/", type: TrackType.Event) {}

        "/benefits/help"(platform: "/", type: TrackType.Event) {}
    }
}
