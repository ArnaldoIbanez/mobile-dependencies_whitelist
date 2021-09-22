package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

tracks {

    initiative = "1048"

    propertyDefinitions {
        site_id(required: true, type: PropertyType.String, description: "Site of current session integration")
        flow_id(required: true, type: PropertyType.String, description: "Flow of session intgration")
        session_id(required: true, type: PropertyType.String, description: "Internal session id")
        session_time(required: true, type: PropertyType.Numeric, description: "Session time")
    }

    propertyGroups {
        externalData(site_id, flow_id, session_id, session_time)
    }

    // ********************************************* Abstract *********************************************
    "/card_form"(platform: "/mobile", isAbstract: true){
        externalData
    }

    "/card_form/expiration_security/date"(platform: "/mobile", isAbstract: true) {}
    "/card_form/expiration_security/cvv"(platform: "/mobile", isAbstract: true) {}

    // ********************************************* Events *********************************************
    // Init & success
    "/card_form/init"(platform: "/mobile", type: TrackType.Event) {
        type(required: false, type: PropertyType.String, description: "type of init", values: ["traditional" , "web_view"])
    }
    "/card_form/success"(platform: "/mobile", type: TrackType.Event) {
        bin(required: false, type: PropertyType.String, description: "first six digits")
        issuer(required: false, type: PropertyType.Numeric, description: "issuer id")
        payment_method_id(required: false, type: PropertyType.String, description: "payment method id")
        payment_method_type(required: false, type: PropertyType.String, description: "payment method type")
    }

    // Next, back, error
    "/card_form/next"(platform: "/mobile", type: TrackType.Event) {
        current_step(required: true, type: PropertyType.String, description: "Name of current step")
    }

    "/card_form/back"(platform: "/mobile", type: TrackType.Event) {
        current_step(required: true, type: PropertyType.String, description: "Name of current step")
    }

    "/card_form/error"(platform: "/mobile", type: TrackType.Event) {
        error_step(required: true, type: PropertyType.String, description: "Current step of error")
        error_message(required: false, type: PropertyType.String, description: "Description of error")
    }

    // Bin number step
    "/card_form/bin_number/clear"(platform: "/mobile", type: TrackType.Event) {}
    "/card_form/bin_number/invalid"(platform: "/mobile", type: TrackType.Event) {
        bin_number(required: true, type: PropertyType.String, description: "Bin number")
    }
    "/card_form/bin_number/valid"(platform: "/mobile", type: TrackType.Event) {}
    "/card_form/bin_number/recognized"(platform: "/mobile", type: TrackType.Event) {}
    "/card_form/bin_number/unknown"(platform: "/mobile", type: TrackType.Event) {
        bin_number(required: true, type: PropertyType.String, description: "Bin number")
    }

    // Name step
    "/card_form/name/clear"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/card_form/name/valid"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Security & expiration step
    "/card_form/expiration_security/date/valid"(platform: "/mobile", type: TrackType.Event) {}
    "/card_form/expiration_security/date/invalid"(platform: "/mobile", type: TrackType.Event) {}
    "/card_form/expiration_security/cvv/valid"(platform: "/mobile", type: TrackType.Event) {}
    "/card_form/expiration_security/cvv/invalid"(platform: "/mobile", type: TrackType.Event) {}

    // Identification step
    "/card_form/identification/valid"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/card_form/identification/invalid"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
        type(required: true, type: PropertyType.String, description: "Type of identification selected by user")
        value(required: true, type: PropertyType.String, description: "Value entered by user")
    }

    // Issuers step
    "/card_form/issuers/selected"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
        issuer_id(required: true, type: PropertyType.Numeric, description: "Id of selected issuer")
    }
    "/card_form/issuers/close"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }


    // ********************************************* Views *********************************************
    "/card_form/bin_number"(platform: "/mobile", type: TrackType.View) {}

    "/card_form/name"(platform: "/mobile", type: TrackType.View) {
        prepopulated(required: true, type: PropertyType.Boolean, description: "Screen field is prepopulated or not")
    }

    "/card_form/expiration_security"(platform: "/mobile", type: TrackType.View) {}

    "/card_form/identification"(platform: "/mobile", type: TrackType.View) {
        prepopulated(required: true, type: PropertyType.Boolean, description: "Screen field is prepopulated or not")
    }

    "/card_form/issuers"(platform: "/mobile", type: TrackType.View) {
        issuers_quantity(required: true, type: PropertyType.Numeric, description: "Number of issuers in list")
    }

    "/card_form/web_view"(platform: "/mobile", type: TrackType.View) {
        url(required: true, type: PropertyType.String, description: "url of web view")
    }
}
