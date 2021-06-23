package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadoshops"

     
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Landing Mercadoshops
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Mercado Shops home"){
        "/mercado_shops/home"(platform: "/", type: TrackType.View){}

        "/mercado_shops/home/landing"(platform: "/", type: TrackType.View){ 
            ref = "ref"
            business = "mercadoshops"
        }
    }

    test("Mercado Shops Landing Templates"){
        "/mercado_shops/home/landing/click"(platform: "/", type: TrackType.Event){
            shop_id = 158689680
            shop_domain = "www.test-shop.mercadoshops.com.ar"
            shop_name = "Test Shop"
            business = "mercadoshops"
        } 
    }

      test("Mercado Shops Landing activate_store"){
        "/mercado_shops/home/landing/activate_store"(platform: "/", type: TrackType.Event){
            location = "test"
            business = "mercadoshops"
        } 
    }
}