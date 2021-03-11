package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    test("Compatibilities :: Show congrats details tracking RE") {

        "/compatibilities"(platform: "/") {
            item_id = "MLA750001220"
            category_id = "MLA1466"
            event_source = "vip"
            domain_id = "AUTOPARTS"
            widget_state = "Nuevo"
        }

        "/compatibilities/modal"(platform: "/") {
            item_id = "MLA750001220"
            category_id = "MLA1466"
            event_source = "vip"
            domain_id = "AUTOPARTS"
            widget_state = "Nuevo"
        }

    }
}