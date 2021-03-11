package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("Coachmark starts after loading") {
        "/pricing_section/coachmark/start" (platform: "/", type: TrackType.Event) { }
    }

    test("User closes coachmark before seeing all steps") {
        "/pricing_section/coachmark/dismiss" (platform: "/", type: TrackType.Event) { }
    }

    test("User closes coachmark after seeing all steps") {
        "/pricing_section/coachmark/finish" (platform: "/", type: TrackType.Event) { }
    }

    test("Costs section finish loading successful") {
        "/pricing_section/success" (platform: "/", type: TrackType.View) {}
    }

    test("Costs section finish loading with an error") {
        "/pricing_section/error" (platform: "/", type: TrackType.View) {
            status = "400"
        }
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

    // OptIn Ahora 12
    test("Error trying to render Ahora 12 page") {
        "/pricing_section/a12/error" (platform: "/", type: TrackType.View) { }
    }
    test("Renders Ahora 12 page") {
        "/pricing_section/a12/success" (platform: "/", type: TrackType.View) { }
    }
    test("Renders Ahora 12 OptIn component") {
        "/pricing_section/a12/optin" (platform: "/", type: TrackType.View) { }
    }
    test("Renders Ahora 12 Shield component") {
        "/pricing_section/a12/shield" (platform: "/", type: TrackType.View) {
            shield_id = "shield_id"
        }
    }
    test("Renders Ahora 12 Cuit-Verification component") {
        "/pricing_section/a12/cuit_verification" (platform: "/", type: TrackType.View) { }
    }
    test("Go back was clicked - A12") {
        "/pricing_section/a12/back" (platform: "/", type: TrackType.Event) { }
    }
    test("A link was clicked - A12") {
        "/pricing_section/a12/navigate" (platform: "/", type: TrackType.Event) {
            link_id = "link_id"
        }
    }
    test("The save button was clicked with a satisfactory result - A12") {
        "/pricing_section/a12/save/success" (platform: "/", type: TrackType.Event) {
            channels = [
                    [
                        id : "point",
                        description : "Point",
                        active : false
                    ],
                    [
                        id : "qr",
                        description : "Código QR",
                        active : true
                    ],
                    [
                        id : "op",
                        description : "Cobros online",
                        active : true
                    ],
            ]
            schema = "AHORAADMIN_12"
        }
    }
    test("The save button was clicked with a error result 1 - A12") {
        "/pricing_section/a12/save/error" (platform: "/", type: TrackType.Event) {
            status = "500"
        }
    }
    test("The save button was clicked with a error result 2 - A12") {
        "/pricing_section/a12/save/error" (platform: "/", type: TrackType.Event) {
            status = "500"
            message = "Error"
        }
    }
    test("The accept button was clicked in cuit-verification component") {
        "/pricing_section/a12/cuit_verification/accept" (platform: "/", type: TrackType.Event) { }
    }

    // OptIn PSJ
    test("Error trying to render PSJ page") {
        "/pricing_section/psj/error" (platform: "/", type: TrackType.View) { }
    }
    test("Renders PSJ page") {
        "/pricing_section/psj/success" (platform: "/", type: TrackType.View) { }
    }
    test("Renders PSJ OptIn component") {
        "/pricing_section/psj/optin" (platform: "/", type: TrackType.View) { }
    }
    test("Renders PSJ Shield component") {
        "/pricing_section/psj/shield" (platform: "/", type: TrackType.View) {
            shield_id = "shield_id"
        }
    }
    test("Go back was clicked - PSJ") {
        "/pricing_section/psj/back" (platform: "/", type: TrackType.Event) { }
    }
    test("A link was clicked - PSJ") {
        "/pricing_section/psj/navigate" (platform: "/", type: TrackType.Event) {
            link_id = "link_id"
        }
    }
    test("A help was open") {
        "/pricing_section/psj/help" (platform: "/", type: TrackType.Event) { }
    }
    test("The save button was clicked with a satisfactory result - PSJ") {
        "/pricing_section/psj/save/success" (platform: "/", type: TrackType.Event) {
            installments = 12
        }
    }
    test("The save button was clicked with a error result 1 - PSJ") {
        "/pricing_section/psj/save/error" (platform: "/", type: TrackType.Event) {
            status = "500"
        }
    }
    test("The save button was clicked with a error result 2 - PSJ") {
        "/pricing_section/psj/save/error" (platform: "/", type: TrackType.Event) {
            status = "500"
            message = "Error"
        }
    }
}
