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

    test("sale_condition step should be tracked"){
    	"/sell/list/sale_condition"(platform: "/", type: TrackType.View){
            session_id = "11111"
    	}
    }

    test("Selected a photo album in the list flow") {
        "/sell/list/pictures/album_selected"(platform: "/mobile", type: TrackType.Event) {
            session_id = "245084411-list-4519bc3c72aa"
            album_name = "Galería de fotos"
        }
    }

    test("Selected a photo album in the modify flow") {
        "/sell/update/pictures/album_selected"(platform: "/mobile", type: TrackType.Event) {
            session_id = "245084411-list-4519bc3c72aa"
            album_name = "Galería de fotos"
        }
    }

    test("The intention of upgrading should be tracked"){
        "/sell/change_listing_type/upgrade_intention"(platform: "/web", type: TrackType.Event){
            source = "upgrade_on"
            seller_experience = "ADVANCED"
            item_id = "MLB13838282"
            vertical = "MOTOR"
        }
    }
}