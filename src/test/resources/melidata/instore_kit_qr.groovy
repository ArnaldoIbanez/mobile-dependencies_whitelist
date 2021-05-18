package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"
  
    test("View Lading Page landings KIT") {
        "/instore_kit_qr/landing" (platform: "/", type: TrackType.View) {
            product = "kit-qr-standalone"
            currency = "ARS"
            price = 500
            discount = 401
            price_with_discount = 99
            has_coupon = true
            coupon_code = "K97EN"
            coupon_type = "default"
        }
    }
    
    test("Event Buy product") {
        "/instore_kit_qr/landing/buy" (platform: "/", type: TrackType.Event) {
            product = "kit-qr-standalone"
        }
    }

    test("Event Error Api example") {
        "/instore_kit_qr/landing/error" (platform: "/", type: TrackType.Event) {
            product = "kit-qr-standalone"
            value = "Ocurrio un Error"
        }
    }

    test("Event Open Modal example") {
        "/instore_kit_qr/component/tap" (platform: "/", type: TrackType.Event) {
            component_id = "main_action"
            component_type = "action"
            value = "Open Modal"
        }
    }  

}
