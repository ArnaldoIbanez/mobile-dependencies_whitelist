package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("Landing view is loaded successfully") {
        "/business_config/landing/success"(platform: "/", type: TrackType.View) {}
    }

    test("Landing view is loaded with errors") {
        "/business_config/landing/error"(platform: "/", type: TrackType.Event) {
            status = '123'
            message = 'error message'
        }
    }

    test("User closes the landing view") {
        "/business_config/landing/close"(platform: "/mobile", type: TrackType.Event) {}
    }

    test("User clicks a row with navigate action type") {
        "/business_config/landing/card/row/action"(platform: "/", type: TrackType.Event) {
            card = 'card_1'
            row = 'row_2'
            action = 'navigate'
            value = 'mercadopago://deeplink'
        }
    }

    test("User opens the tooltip from a disabled row") {
        "/business_config/landing/card/row/disable/tooltip/show"(platform: "/", type: TrackType.Event) {
            card = 'card_1'
            row = 'row_1'
            tooltip = 'tooltip_1'
        }
    }

    test("User closes the tooltip from a disabled row") {
        "/business_config/landing/card/row/disable/tooltip/hide"(platform: "/", type: TrackType.Event) {
            card = 'card_1'
            row = 'row_1'
            tooltip = 'tooltip_1'
        }
    }

    test("User clicks the tooltip's primary action from a disabled row") {
        "/business_config/landing/card/row/disable/tooltip/primary"(platform: "/", type: TrackType.Event) {
            card = 'card_1'
            row = 'row_1'
            tooltip = 'tooltip_1'
            url = 'http://url'
        }
    }

    test("User clicks the tooltip's secondary action from a disabled row") {
        "/business_config/landing/card/row/disable/tooltip/secondary"(platform: "/", type: TrackType.Event) {
            card = 'card_1'
            row = 'row_1'
            tooltip = 'tooltip_1'
            url = 'http://url'
        }
    }

    test("User opens the tooltip from an active row") {
        "/business_config/landing/card/row/tooltip/show"(platform: "/", type: TrackType.Event) {
            card = 'card_1'
            row = 'row_1'
            tooltip = 'tooltip_1'
        }
    }

    test("User closes the tooltip from an active row") {
        "/business_config/landing/card/row/tooltip/hide"(platform: "/", type: TrackType.Event) {
            card = 'card_1'
            row = 'row_1'
            tooltip = 'tooltip_1'
        }
    }

    test("User clicks the tooltip's primary action from an active row") {
        "/business_config/landing/card/row/tooltip/primary"(platform: "/", type: TrackType.Event) {
            card = 'card_1'
            row = 'row_1'
            tooltip = 'tooltip_1'
            url = 'http://url'
        }
    }

    test("User clicks the tooltip's secondary action from an active row") {
        "/business_config/landing/card/row/tooltip/secondary"(platform: "/", type: TrackType.Event) {
            card = 'card_1'
            row = 'row_1'
            tooltip = 'tooltip_1'
            url = 'http://url'
        }
    }

    test("User dismisses the row's message") {
        "/business_config/landing/card/row/message/dismiss"(platform: "/", type: TrackType.Event) {
            card = 'card_1'
            row = 'row_1'
            message = 'message_1'
        }
    }

    test("User clicks the primary action of a row's message") {
        "/business_config/landing/card/row/message/primary"(platform: "/", type: TrackType.Event) {
            card = 'card_1'
            row = 'row_1'
            message = 'message_1'
            url = 'http://url'
        }
    }

    test("User clicks the secondary action of a row's message") {
        "/business_config/landing/card/row/message/secondary"(platform: "/", type: TrackType.Event) {
            card = 'card_1'
            row = 'row_1'
            message = 'message_1'
            url = 'http://url'
        }
    }

    test("User dismisses the cards's message") {
        "/business_config/landing/card/message/dismiss"(platform: "/", type: TrackType.Event) {
            card = 'card_1'
            message = 'message_1'
        }
    }

    test("User clicks the primary action of a card's message") {
        "/business_config/landing/card/message/primary"(platform: "/", type: TrackType.Event) {
            card = 'card_1'
            message = 'message_1'
            url = 'http://url'
        }
    }

    test("User clicks the secondary action of a card's message") {
        "/business_config/landing/card/message/secondary"(platform: "/", type: TrackType.Event) {
            card = 'card_1'
            message = 'message_1'
            url = 'http://url'
        }
    }

    test("User dismisses the landing's message") {
        "/business_config/landing/message/dismiss"(platform: "/", type: TrackType.Event) {
            message = 'message_1'
        }
    }

    test("User clicks primary action of a landing's message") {
        "/business_config/landing/message/primary"(platform: "/", type: TrackType.Event) {
            message = 'message_1'
            url = 'http://url'
        }
    }

    test("User clicks the secondary action of a landing's message") {
        "/business_config/landing/message/secondary"(platform: "/", type: TrackType.Event) {
            message = 'message_1'
            url = 'http://url'
        }
    }

    test("User clicks the tooltip/help of a card") {
        "/business_config/landing/card/help"(platform: "/", type: TrackType.Event) {
            card = 'card_1'
            url = 'http://url'
        }
    }

    test("User uploads a logo image successfully") {
        "/business_config/landing/form/image/success"(platform: "/web", type: TrackType.Event) {
            card = 'card_1'
            row = 'row_1'
        }
    }

    test("User uploads a logo image and there's an error") {
        "/business_config/landing/form/image/error"(platform: "/web", type: TrackType.Event) {
            card = 'card_1'
            row = 'row_1'
            status = '123'
            message = 'error message'
        }
    }

    test("User submits form successfully") {
        "/business_config/landing/form/success"(platform: "/web", type: TrackType.Event) {
            card = 'card_1'
            input = ['input_1', 'input_2']
        }
    }

    test("User submits form and there's an error") {
        "/business_config/landing/form/error"(platform: "/web", type: TrackType.Event) {
            card = 'card_1'
            status = '123'
            message = 'error message'
        }
    }

    test("User clicks the tooltip's primary action of an input") {
        "/business_config/landing/form/input/tooltip/primary"(platform: "/web", type: TrackType.Event) {
            card = 'card_1'
            row = 'row_1'
            tooltip = 'tooltip_1'
            url = 'http://url'
        }
    }

    test("User clicks the tooltip's secondary action of an input") {
        "/business_config/landing/form/input/tooltip/secondary"(platform: "/web", type: TrackType.Event) {
            card = 'card_1'
            row = 'row_1'
            tooltip = 'tooltip_1'
            url = 'http://url'
        }
    }
}