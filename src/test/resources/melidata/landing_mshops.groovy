package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadoshops"

     
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Landing Mercadoshops
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercado Shops home"){
        "/home"(platform: "/", type: TrackType.View){}

        "/home/landing"(platform: "/", type: TrackType.View){}
    }

    test("Mercado Shops Landing Templates"){
        "/home/landing/click"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
        }
    }

      test("Mercado Shops Landing activate_store"){
        "/home/landing/activate_store"(platform: "/", type: TrackType.Event){
            location = "test"
        }
        "/home/landing/already_active"(platform: "/", type: TrackType.Event){
            location = "test"
        }
    }
}