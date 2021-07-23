package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoshops"

     test("Social networks") {
        "/social"(platform: "/", type: TrackType.Event) {
            social_network = "facebook"
            shop_id = 121221
            shop_name = "name shop"
            shop_domain = "www.shop-domain.com"
            status = "active"
            from = "home"
        }
     }
     
}
