package src.test.resources

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("fulfillment landing") {

        //Views
        "/fbm/landing"(platform: "/", type: TrackType.View) {}

        //Events
        "/fbm/landing/contact_me_button_top"(platform: "/", type: TrackType.Event) {}
        "/fbm/landing/contact_me_button_bottom"(platform: "/", type: TrackType.Event) {}
        "/fbm/landing/open_faq_opt_in"(platform: "/", type: TrackType.Event) {}
        "/fbm/landing/open_faq_dc_location"(platform: "/", type: TrackType.Event) {}
        "/fbm/landing/open_faq_send_my_inventory"(platform: "/", type: TrackType.Event) {}
        "/fbm/landing/open_faq_send_inventory_from_supplier"(platform: "/", type: TrackType.Event) {}
        "/fbm/landing/open_faq_fees"(platform: "/", type: TrackType.Event) {}
        "/fbm/landing/open_faq_manage_inventory"(platform: "/", type: TrackType.Event) {}
        "/fbm/landing/hotjar"(platform: "/", type: TrackType.Event) { hotjar_user_id = 1234567890 }

    }
}
