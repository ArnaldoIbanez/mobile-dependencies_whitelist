package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"


    test("Listing intention event tests"){

        "/listing_intention"(platform:"/web/mobile") {
            from = "congrats"
            context = "vip"
            go_to = "hub"
        }

        "/listing_intention"(platform:"/web/desktop") {
            from = "congrats"
            context = "vip"
            go_to = "motors"
            item_id = "MLA750001220"
            category_id = "MLA1466"
            buying_mode = "classified"
            category_path = ["MLA1234","MLA6789"]
            vertical = "realEstate"
            item_condition = "used"
            listing_type_id = "gold_special"
        }

    }

}
