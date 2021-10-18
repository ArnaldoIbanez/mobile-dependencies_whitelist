package src.test.resources.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("VIS reservation terms and conditions step") {
        def commonProperties = {
            item_id = "MLC123123"
            category_id = "MLC1234"
            vertical = "realEstate"
            buyer_id = 799550806
            seller_id = 799550807
            is_ltr = true
        }
        "/vis/reservation/terms_conditions"(platform: "/", type: TrackType.View, commonProperties)
        "/vis/reservation/terms_conditions/continue"(platform: "/", type: TrackType.Event, commonProperties)
        "/vis/reservation/terms_conditions/privacy"(platform: "/", type: TrackType.Event, commonProperties)
        "/vis/reservation/terms_conditions/terms_conditions"(platform: "/", type: TrackType.Event, commonProperties)
        "/vis/reservation/terms_conditions/accept"(platform: "/", type: TrackType.Event) {
            commonProperties()
            accept_conditions = true
        }
    }

    test("VIS reservation detail step") {
        def commonProperties = {
            item_id = "MLC123123"
            category_id = "MLC1234"
            vertical = "realEstate"
            buyer_id = 799550806
            seller_id = 799550807
            is_ltr = true
        }
        "/vis/reservation/detail"(platform: "/", type: TrackType.View, commonProperties)
        "/vis/reservation/detail/reserve"(platform: "/", type: TrackType.Event, commonProperties)
        "/vis/reservation/detail/refund"(platform: "/", type: TrackType.Event, commonProperties)
        "/vis/reservation/detail/requirements"(platform: "/", type: TrackType.Event, commonProperties)
        "/vis/reservation/detail/payment_detail"(platform: "/", type: TrackType.Event, commonProperties)
    }

    test("VIS reservation congrats step success case") {
        def commonProperties = {
            item_id = "MLC123123"
            category_id = "MLC1234"
            vertical = "realEstate"
            buyer_id = 799550806
            seller_id = 799550807
            is_ltr = true
        }
        "/vis/reservation/congrats/success"(platform: "/", type: TrackType.View, commonProperties)
        "/vis/reservation/congrats/success/view_item"(platform: "/", type: TrackType.Event, commonProperties)
    }

    test("VIS reservation congrats step failed case") {
        def commonProperties = {
            item_id = "MLC123123"
            category_id = "MLC1234"
            vertical = "realEstate"
            buyer_id = 799550806
            seller_id = 799550807
            is_ltr = true
        }
        "/vis/reservation/congrats/failed"(platform: "/", type: TrackType.View, commonProperties)
        "/vis/reservation/congrats/failed/retry"(platform: "/", type: TrackType.Event, commonProperties)
    }
}
