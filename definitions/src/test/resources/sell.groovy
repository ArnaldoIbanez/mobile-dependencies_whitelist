package src.test.resources
import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("item_description step should be tracked"){
    	"/sell/list/item_description"(platform: "/", type: TrackType.View){
            session_id = "11111"
            listing_type_id = "1111"
            vertical = "CORE"
            buying_mode = "buy_it_now"
            condition = "new"
            price = 10000
    	}
    }
}