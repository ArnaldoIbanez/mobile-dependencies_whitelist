package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoenvios"

    test ("Fulfillment landings views") {
      "/fbm/landing"(platform: "/", type: TrackType.View) {}
      "/fbm/landing/optin"(platform: "/", type: TrackType.View) {}
      "/fbm/landing/congrats"(platform: "/", type: TrackType.View) {}
    }

    test ("Fulfillment landings events") {
      "/fbm/landing/contact_me"(platform: "/", type: TrackType.Event) { location = "top" }
      "/fbm/landing/contact_me"(platform: "/", type: TrackType.Event) { location = "bottom"}
      "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "opt_in"}
      "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "dc_location"}
      "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "send_my_inventory"}
      "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "send_inventory_from_supplier"}
      "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "fees"}
      "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "manage_inventory"}
      "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "send_any_product"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "billing_warehouse"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "cost_fulfillment"}
      "/fbm/landing/cancel_opt_in"(platform: "/", type: TrackType.Event) {}
    }

    defaultBusiness = "mercadolibre"

    test ("Fulfillment landings views") {
        "/fbm/landing"(platform: "/", type: TrackType.View) {}
        "/fbm/landing/optin"(platform: "/", type: TrackType.View) {}
        "/fbm/landing/congrats"(platform: "/", type: TrackType.View) {}
    }

    test ("Fulfillment landings events") {
        "/fbm/landing/contact_me"(platform: "/", type: TrackType.Event) { location = "top" }
        "/fbm/landing/contact_me"(platform: "/", type: TrackType.Event) { location = "bottom"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "opt_in"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "dc_location"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "send_my_inventory"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "send_inventory_from_supplier"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "fees"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "manage_inventory"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "send_any_product"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "billing_warehouse"}
        "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) { faq = "cost_fulfillment"}
        "/fbm/landing/cancel_opt_in"(platform: "/", type: TrackType.Event) {}
    }

}
