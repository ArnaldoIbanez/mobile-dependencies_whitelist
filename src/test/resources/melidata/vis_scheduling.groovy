package src.test.resources.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("VIS scheduling terms and conditions step") {
        def commonProperties = {
            item_id = "MLC123123"
            category_id = "MLC1234"
            vertical = "realEstate"
            buyer_id = 799550806
            seller_id = 799550807
            is_ltr = true
        }
        "/vis/scheduling/terms_conditions"(platform: "/", type: TrackType.View, commonProperties)
        "/vis/scheduling/terms_conditions/continue"(platform: "/", type: TrackType.Event, commonProperties)
        "/vis/scheduling/terms_conditions/accept"(platform: "/", type: TrackType.Event) {
            commonProperties()
            accept_conditions = true
        }
    }

    test("VIS scheduling scheduling selection step") {
        def commonProperties = {
            item_id = "MLC123123"
            category_id = "MLC1234"
            vertical = "realEstate"
            buyer_id = 799550806
            seller_id = 799550807
            is_ltr = true
        }
        "/vis/scheduling/calendar"(platform: "/", type: TrackType.View, commonProperties)
        "/vis/scheduling/calendar/days"(platform: "/", type: TrackType.Event) {
            commonProperties()
            selected_days = ["monday", "thursday"]
        }
        "/vis/scheduling/calendar/hours_range"(platform: "/", type: TrackType.Event) {
            commonProperties()
            selected_hours_range = ["morning", "afternoon"]
        }
        "/vis/scheduling/calendar/schedule"(platform: "/", type: TrackType.Event) {
            commonProperties()
            selected_days = ["monday", "thursday"]
            selected_hours_range = ["morning", "afternoon"]
        }
    }

    test("VIS scheduling congrats step") {
        def commonProperties = {
            item_id = "MLC123123"
            category_id = "MLC1234"
            vertical = "realEstate"
            buyer_id = 799550806
            seller_id = 799550807
            is_ltr = true
        }
        "/vis/scheduling/congrats"(platform: "/", type: TrackType.View, commonProperties)
        "/vis/scheduling/congrats/view_more_items"(platform: "/", type: TrackType.Event, commonProperties)
        "/vis/scheduling/congrats/my_data"(platform: "/", type: TrackType.Event, commonProperties)
    }
}
