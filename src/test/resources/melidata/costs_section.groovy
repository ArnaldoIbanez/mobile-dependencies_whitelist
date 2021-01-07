package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("Costs section finish loading successful") {
        "/pricing_section/success" (platform: "/", type: TrackType.View) {}
    }

    test("Costs section finish loading with an error") {
        "/pricing_section/error" (platform: "/", type: TrackType.View) { 
            status = "400"
            message = "server not found"
        }
    }

    test("User close Costs section (with back button)") {
        "/pricing_section/close" (platform: "/mobile", type: TrackType.Event) { }
    }

    test("A message at the most top level is dismissed") {
        "/pricing_section/message/dismiss" (platform: "/", type: TrackType.Event) { 
            message_id = "cost_section_message"
        }
    }

    test("A top-level message primary action is clicked") {
        "/pricing_section/message/action/primary" (platform: "/", type: TrackType.Event) {
            message_id = "cost_section_message"
            url = "https://www.mercadopago.com.ar/cost-section/about"
        }
    }

    test("A top-level message secondary action is clicked") {
        "/pricing_section/message/action/secondary" (platform: "/", type: TrackType.Event) {
            message_id = "cost_section_message"
            url = "https://www.mercadopago.com.ar/cost-section/about"
        }
    }

    // Section

    test("A message inside a section is dismissed") {
        "/pricing_section/section/message/dismiss" (platform: "/", type: TrackType.Event) { 
            message_id = "financing_section_message"
            section_id = "financing_section"
        }
    }

    test("A primary action of a message inside a section is clicked") {
        "/pricing_section/section/message/action/primary" (platform: "/", type: TrackType.Event) {
            message_id = "financing_section_message"
            url = "https://www.mercadopago.com.ar/cost-section/about"
            section_id = "financing_section"
        }
    }

    test("A secondary action of a message inside a section is clicked") {
        "/pricing_section/section/message/action/secondary" (platform: "/", type: TrackType.Event) {
            message_id = "financing_section_message"
            url = "https://www.mercadopago.com.ar/cost-section/about"
            section_id = "financing_section"
        }
    }

    // Component

    test("An external component finish loading successful") {
        "/pricing_section/section/component/success" (platform: "/", type: TrackType.Event) { 
            section_id = "fees_section"
            component_id = "fees_component"
        }
    }

    test("An external component finish loading with an error") {
        "/pricing_section/section/component/error" (platform: "/", type: TrackType.Event) { 
            section_id = "fees_section"
            component_id = "fees_component"
        }
    }

    // Card

    test("A message inside a card is dismissed") {
        "/pricing_section/section/card/message/dismiss" (platform: "/", type: TrackType.Event) { 
            message_id = "financing_section_message"
            section_id = "financing_section"
            card_id = "financing_psj"
        }
    }

    test("A primary action of a message inside a card is clicked") {
        "/pricing_section/section/card/message/action/primary" (platform: "/", type: TrackType.Event) {
            message_id = "financing_section_message"
            url = "https://www.mercadopago.com.ar/cost-section/about"
            section_id = "financing_section"
            card_id = "financing_psj"
        }
    }

    test("A secondary action of a message inside a card is clicked") {
        "/pricing_section/section/card/message/action/secondary" (platform: "/", type: TrackType.Event) {
            message_id = "financing_section_message"
            url = "https://www.mercadopago.com.ar/cost-section/about"
            section_id = "financing_section"
            card_id = "financing_psj"
        }
    }

    // Row

    test("A message inside a row is dismissed") {
        "/pricing_section/section/card/row/message/dismiss" (platform: "/", type: TrackType.Event) { 
            message_id = "financing_section_message"
            section_id = "financing_section"
            card_id = "financing_a12"
            row_id = "a12"
        }
    }

    test("A primary action of a message inside a row is clicked") {
        "/pricing_section/section/card/row/message/action/primary" (platform: "/", type: TrackType.Event) {
            message_id = "financing_section_message"
            url = "https://www.mercadopago.com.ar/cost-section/about"
            section_id = "financing_section"
            card_id = "financing_a12"
            row_id = "a12"
        }
    }

    test("A secondary action of a message inside a row is clicked") {
        "/pricing_section/section/card/row/message/action/secondary" (platform: "/", type: TrackType.Event) {
            message_id = "financing_section_message"
            url = "https://www.mercadopago.com.ar/cost-section/about"
            section_id = "financing_section"
            card_id = "financing_a12"
            row_id = "a12"
        }
    }

    test("A row was clicked") {
        "/pricing_section/section/card/row/action" (platform: "/", type: TrackType.Event) { 
            section_id = "financing_section"
            card_id = "financing_a12"
            row_id = "a12"
            url = ""
        }
    }

    test("A tooltip (triggered by a click in a row) was opened") {
        "/pricing_section/section/card/row/tooltip/show" (platform: "/", type: TrackType.Event) { 
            section_id = "financing_section"
            card_id = "financing_a12"
            row_id = "a12"
            tooltip_id = "a12_tooltip"
        }
    }

    test("A tooltip (triggered by a click in a row) was closed") {
        "/pricing_section/section/card/row/tooltip/hide" (platform: "/", type: TrackType.Event) { 
            section_id = "financing_section"
            card_id = "financing_a12"
            row_id = "a12"
            tooltip_id = "a12_tooltip"
        }
    }
    
}