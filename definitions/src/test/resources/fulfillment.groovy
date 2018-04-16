package src.test.resources

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("fulfillment landing") {

        //Views
        "/fbm/landing"(platform: "/", type: TrackType.View) {}

        //Events
        "/fbm/landing/contact_me"(platform: "/", type: TrackType.Event) { location = "top" }
        "/fbm/landing/contact_me"(platform: "/", type: TrackType.Event) { location = "bottom"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "opt_in"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "dc_location"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "send_my_inventory"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "send_inventory_from_supplier"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "fees"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "manage_inventory"}

    }
}
