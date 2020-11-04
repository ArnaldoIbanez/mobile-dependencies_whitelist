package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    test("Contact :: Show congrats details tracking RE") {

        "/contact/congrats"(platform: "/") {
            item_id = "MLA750001220"
            category_id = "MLA1466"
            buying_mode = "classified"
            category_path = ["MLA1234","MLA6789"]
            vertical = "realEstate"
            item_condition = "used"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
        }

        "/contact/congrats"(platform: "/web") {
            item_id = "MLA750001220"
            category_id = "MLA1466"
            buying_mode = "classified"
            category_path = ["MLA1234","MLA6789"]
            vertical = "realEstate"
            item_condition = "used"
            item_status = "active"
            listing_type_id = "gold_special"
            seller_id = 131662738
            deal_ids = []
            // classified's fields
            contract_available = false
            comparator_available = false
            gallery_pattern = ""
            description_type = "plain_text"
            price_comparison_available = true
            has_good_price = true
        }

    }
}