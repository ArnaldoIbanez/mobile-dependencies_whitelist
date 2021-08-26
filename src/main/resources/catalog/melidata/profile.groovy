package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1172"

    //Profile
    "/profile"(platform: "/", type: TrackType.View) {
        entity_type(type: PropertyType.String, required: false, values: ["company", "person", "unknown"],  description: "Indicates the entity type for KYC (person, company, unknown)")
        user_type(type: PropertyType.String, required: false, values:["BU", "CO"], description: "Indicates the account type in marketplace (BU, CO)")
        is_compliant(type: PropertyType.Boolean, required: false, description: "Indicates if is compliant with my-data-hub initiative (L5)", inheritable:true)
        access(type: PropertyType.String, required: false, values:["full", "partial", "restricted", "denied"], description: "Check for soft_compliant users")
        registered_by_phone(type: PropertyType.Boolean, required: false, description: "Indicates if user was registered by new registration (true) or legacy (false)")
        has_identification(type: PropertyType.Boolean, required: false, description: "Indicates if the user has a non-validated identity or there is no information", inheritable:true)
    }

    //Email
    "/profile/email"(platform: "/", type: TrackType.Event) {
        status(type: PropertyType.String, required: true, values:["verified", "not-verified", "information"], description: "Indicates if field is verified or not (if applies) when clicking")
    }

    //Identity
    "/profile/identity"(platform: "/", type: TrackType.Event) {}

    //Phone
    "/profile/phone"(platform: "/", type: TrackType.Event) {
        status(type: PropertyType.String, required: true, values:["verified", "not-verified", "information"], description: "Indicates if field is verified or not (if applies) when clicking")
    }

    //Phone alternative
    "/profile/phone_alternative"(platform: "/", type: TrackType.Event) {
        status(type: PropertyType.String, required: true, values:["verified", "not-verified", "information"], description: "Indicates if field is verified or not (if applies) when clicking")
    }

    //Preferred name
    "/profile/preferred_name"(platform: "/", type: TrackType.Event) {
        status(type: PropertyType.String, required: true, values:["verified", "not-verified", "information"], description: "Indicates if field is verified or not (if applies) when clicking")
    }

    //User name
    "/profile/user_name"(platform: "/", type: TrackType.Event) {
        status(type: PropertyType.String, required: true, values:["verified", "not-verified", "information"], description: "Indicates if field is verified or not (if applies) when clicking")
    }

    //Identity View
    "/profile/identity"(platform: "/", type: TrackType.View) {}

    //Identity Validation
    "/profile/identity/validation"(platform: "/", type: TrackType.Event) {}

    //Identity correction
    "/profile/identity/correction"(platform: "/", type: TrackType.Event) {
        event_type(type: PropertyType.String, required: true, values:["onboarding", "redirect"], description: "Indicates if is an informative or a redirect event")
    }

    //Identity fiscal_upgrade
    "/profile/identity/fiscal_upgrade"(platform: "/", type: TrackType.Event) {
        event_type(type: PropertyType.String, required: true, values:["onboarding", "redirect"], description: "Indicates if is an informative or a redirect event")
    }

    //Identity ownership_change
    "/profile/identity/ownership_change"(platform: "/", type: TrackType.Event) {
        event_type(type: PropertyType.String, required: true, values:["onboarding", "redirect"], description: "Indicates if is an informative or a redirect event")
    }
}