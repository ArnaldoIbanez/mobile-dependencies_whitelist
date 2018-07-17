package src.test.resources

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("fulfillment landing") {

        //Views
        "/fbm/landing"(platform: "/", type: TrackType.View) {}
        "/fbm/landing/optin"(platform: "/", type: TrackType.View) {}
        "/fbm/landing/congrats"(platform: "/", type: TrackType.View) {}        
        "/fbm/panel/inbound/units"(platform: "/", type: TrackType.View) {}
        "/fbm/panel/inbound/labeling"(platform: "/", type: TrackType.View) {}

        //Events
        "/fbm/landing/contact_me"(platform: "/", type: TrackType.Event) { location = "top" }
        "/fbm/landing/contact_me"(platform: "/", type: TrackType.Event) { location = "bottom"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "opt_in"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "dc_location"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "send_my_inventory"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "send_inventory_from_supplier"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "fees"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "manage_inventory"}
        "/fbm/landing/cancel_opt_in"(platform: "/", type: TrackType.Event) { }
    }

    test("Inbound units") {
        "/fbm/panel/inbound/units/input_change"(platform: "/", type: TrackType.Event) {
            warning_type = 'show_incentive'
            warning_value = 51
            inbound_id = 2649
            inventory_id = 'YWGV00053'
            input_value = 6
        }

        "/fbm/panel/inbound/units/submit_error"(platform: "/", type: TrackType.Event) {
             warnings = [
                [
                    warning_type: 'show_restriction',
                    warning_value : 100, 
                    inbound_id : 2649, 
                    inventory_id : 'YWGV00053',
                    input_value : 300
                ]
            ]
        }

        "/fbm/panel/inbound/units/input_delete"(platform: "/", type: TrackType.Event) {
            inbound_id = 2649
            inventory_id = 'YWGV00053'
        }
    }
}
