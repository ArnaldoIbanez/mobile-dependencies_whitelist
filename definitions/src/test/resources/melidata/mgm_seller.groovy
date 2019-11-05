package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"


    test("Mercadopago MGM Seller Referal") {
        "/mgm_seller/referal" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago MGM Seller Referal tap") {
        "/mgm_seller/referal/tap" (platform: "/mobile", type: TrackType.Event) {
            media = "whatsapp"
            device= "Point Mini"
        }
    }

    test("Mercadopago MGM Seller Referal swipe") {
        "/mgm_seller/referal/swipe" (platform: "/mobile", type: TrackType.Event) {}
    }
}