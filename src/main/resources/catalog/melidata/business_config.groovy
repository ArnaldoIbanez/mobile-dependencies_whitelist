import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    initiative = "1148"

    propertyDefinitions {
        action(required: true, type: PropertyType.String, description: "the action type from the row selected by the user", values: ['navigate', 'picker', 'switch'])
    }

    //Business Config
    "/business_config"(platform: "/", isAbstract: true) {}
    "/business_config/landing/card"(platform: "/", isAbstract: true) {}
    "/business_config/landing/card/message"(platform: "/", isAbstract: true) {}
    "/business_config/landing/card/row"(platform: "/", isAbstract: true) {}
    "/business_config/landing/card/tooltip"(platform: "/", isAbstract: true) {}
    "/business_config/landing/card/disable"(platform: "/", isAbstract: true) {}
    "/business_config/landing/card/row"(platform: "/", isAbstract: true) {}
    "/business_config/landing/card/row/disable"(platform: "/", isAbstract: true) {}
    "/business_config/landing/card/row/disable/tooltip"(platform: "/", isAbstract: true) {}
    "/business_config/landing/card/row/tooltip"(platform: "/", isAbstract: true) {}
    "/business_config/landing/card/row/message"(platform: "/", isAbstract: true) {}
    "/business_config/landing/form"(platform: "/", isAbstract: true) {}
    "/business_config/landing/form/image"(platform: "/", isAbstract: true) {}
    "/business_config/landing/form/input"(platform: "/", isAbstract: true) {}
    "/business_config/landing/form/input/tooltip"(platform: "/", isAbstract: true) {}
    "/business_config/landing/message"(platform: "/", isAbstract: true) {}
    "/business_config/landing"(platform: "/", isAbstract: true) {}
    
    "/business_config/landing/success"(platform: "/", type: TrackType.View) {}
    "/business_config/landing/error"(platform: "/", type: TrackType.View) {
        status(required: true, type: PropertyType.String, description: "The code status")
        message(required: true, type: PropertyType.String, description: "The message error")
    }
    "/business_config/landing/close"(platform: "/mobile", type: TrackType.Event) {}

    "/business_config/landing/card/row/action"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        row(required: true, type: PropertyType.String, description: "The row id")
        action(required: true, type: PropertyType.String, description: "The action type from the row")
        value(required: true, type: PropertyType.String, description: "Deeplink or url according to the row action type")
    }
    "/business_config/landing/card/row/disable/tooltip/show"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        row(required: true, type: PropertyType.String, description: "The row id")
        tooltip(required: true, type: PropertyType.String, description: "The tooltip id")
    }
    "/business_config/landing/card/row/disable/tooltip/hide"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        row(required: true, type: PropertyType.String, description: "The row id")
        tooltip(required: true, type: PropertyType.String, description: "The tooltip id")
    }
    "/business_config/landing/card/row/disable/tooltip/primary"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        row(required: true, type: PropertyType.String, description: "The row id")
        tooltip(required: true, type: PropertyType.String, description: "The tooltip id")
        url(required: true, type: PropertyType.String, description: "The url from the action button")
    }
    "/business_config/landing/card/row/disable/tooltip/secondary"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        row(required: true, type: PropertyType.String, description: "The row id")
        tooltip(required: true, type: PropertyType.String, description: "The tooltip id")
        url(required: true, type: PropertyType.String, description: "The url from the action button")
    }
    "/business_config/landing/card/row/tooltip/show"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        row(required: true, type: PropertyType.String, description: "The row id")
        tooltip(required: true, type: PropertyType.String, description: "The tooltip id")
    }
    "/business_config/landing/card/row/tooltip/hide"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        row(required: true, type: PropertyType.String, description: "The row id")
        tooltip(required: true, type: PropertyType.String, description: "The tooltip id")
    }
    "/business_config/landing/card/row/tooltip/primary"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        row(required: true, type: PropertyType.String, description: "The row id")
        tooltip(required: true, type: PropertyType.String, description: "The tooltip id")
        url(required: true, type: PropertyType.String, description: "The url from the action button")
    }
    "/business_config/landing/card/row/tooltip/secondary"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        row(required: true, type: PropertyType.String, description: "The row id")
        tooltip(required: true, type: PropertyType.String, description: "The tooltip id")
        url(required: true, type: PropertyType.String, description: "The url from the action button")
    }
    "/business_config/landing/card/row/message/dismiss"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        row(required: true, type: PropertyType.String, description: "The row id")
        message(required: true, type: PropertyType.String, description: "The message id")
    }
    "/business_config/landing/card/row/message/primary"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        row(required: true, type: PropertyType.String, description: "The row id")
        message(required: true, type: PropertyType.String, description: "The message id")
        url(required: true, type: PropertyType.String, description: "The url from the action button")
    }
    "/business_config/landing/card/row/message/secondary"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        row(required: true, type: PropertyType.String, description: "The row id")
        message(required: true, type: PropertyType.String, description: "The message id")
        url(required: true, type: PropertyType.String, description: "The url from the action button")
    }
    "/business_config/landing/card/message/dismiss"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        message(required: true, type: PropertyType.String, description: "The message id")
    }
    "/business_config/landing/card/message/primary"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        message(required: true, type: PropertyType.String, description: "The message id")
        url(required: true, type: PropertyType.String, description: "The url from the action button")
    }
    "/business_config/landing/card/message/secondary"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        message(required: true, type: PropertyType.String, description: "The message id")
        url(required: true, type: PropertyType.String, description: "The url from the action button")
    }
    "/business_config/landing/message/dismiss"(platform: "/", type: TrackType.Event) {
        message(required: true, type: PropertyType.String, description: "The message id")
    }
    "/business_config/landing/message/primary"(platform: "/", type: TrackType.Event) {
        message(required: true, type: PropertyType.String, description: "The message id")
        url(required: true, type: PropertyType.String, description: "The url from the action button")
    }
    "/business_config/landing/message/secondary"(platform: "/", type: TrackType.Event) {
        message(required: true, type: PropertyType.String, description: "The message id")
        url(required: true, type: PropertyType.String, description: "The url from the action button")
    }
    "/business_config/landing/card/help"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        url(required: true, type: PropertyType.String, description: "The url")
    }
    "/business_config/landing/card/help/success"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        url(required: true, type: PropertyType.String, description: "The url")
    }
    "/business_config/landing/card/help/error"(platform: "/", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        url(required: true, type: PropertyType.String, description: "The url")
        error(required: true, type: PropertyType.String, description: "The error message")
    }
    "/business_config/landing/form/image/success"(platform: "/web", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        row(required: true, type: PropertyType.String, description: "The row id")
    }
    "/business_config/landing/form/image/error"(platform: "/web", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        row(required: true, type: PropertyType.String, description: "The row id")
        status(required: true, type: PropertyType.String, description: "The error status")
        message(required: true, type: PropertyType.String, description: "The error message")
    }
    "/business_config/landing/form/success"(platform: "/web", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        input(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "The input ids")
    }
    "/business_config/landing/form/error"(platform: "/web", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        status(required: true, type: PropertyType.String, description: "The error status")
        message(required: true, type: PropertyType.String, description: "The error message")
    }
    "/business_config/landing/form/input/tooltip/primary"(platform: "/web", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        row(required: true, type: PropertyType.String, description: "The row id")
        tooltip(required: true, type: PropertyType.String, description: "The tooltip id")
        url(required: true, type: PropertyType.String, description: "The url from the action button")
    }
    "/business_config/landing/form/input/tooltip/secondary"(platform: "/web", type: TrackType.Event) {
        card(required: true, type: PropertyType.String, description: "The card id")
        row(required: true, type: PropertyType.String, description: "The row id")
        tooltip(required: true, type: PropertyType.String, description: "The tooltip id")
        url(required: true, type: PropertyType.String, description: "The url from the action button")
    }
}