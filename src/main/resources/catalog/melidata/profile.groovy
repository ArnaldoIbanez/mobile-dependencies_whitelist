package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1172"

    //Profile
    "/profile"(platform: "/", type: TrackType.View) {
        entity_type(type: PropertyType.String, required: true, values: ["company", "person", "unknown"],  description: "Indicates the entity type for KYC (person, company, unknown)")
        account_type(type: PropertyType.String, required: true, values:["BU", "CO"], description: "Indicates the account type in marketplace (BU, CO)")
        is_compliant(type: PropertyType.Boolean, required: true, description: "Indicates if is compliant with my-data-hub initiative (L5)", inheritable:false)
        access(type: PropertyType.String, required: true, values:["full", "partial", "restricted", "denied"], description: "Check for soft_compliant users")
        registered_by_phone(type: PropertyType.Boolean, required: true, description: "Indicates if user was registered by new registration (true) or legacy (false)", inheritable:false)
        has_identification(type: PropertyType.Boolean, required: true, description: "Indicates if the user has a non-validated identity or there is no information", inheritable:false)
    }

    //Email
    "/profile/email"(platform: "/", type: TrackType.Event) {
        entity_type(type: PropertyType.String, required: true, values: ["company", "person", "unknown"],  description: "Indicates the entity type for KYC (person, company, unknown)")
        account_type(type: PropertyType.String, required: true, values:["BU", "CO"], description: "Indicates the account type in marketplace (BU, CO)")
        is_compliant(type: PropertyType.Boolean, required: true, description: "Indicates if is compliant with my-data-hub initiative (L5)", inheritable:false)
        status(type: PropertyType.String, required: true, values:["verified", "not-verified", "information"], description: "Indicates if field is verified or not (if applies) when clicking")
        access(type: PropertyType.String, required: false, values:["full", "partial", "restricted", "denied"], description: "Check for soft_compliant users")
        registered_by_phone(type: PropertyType.Boolean, required: false, description: "Indicates if user was registered by new registration (true) or legacy (false)")
        has_identification(type: PropertyType.Boolean, required: false, description: "Indicates if the user has a non-validated identity or there is no information")
    }

    //Identity
    "/profile/identity"(platform: "/", type: TrackType.Event) {
        entity_type(type: PropertyType.String, required: true, values: ["company", "person", "unknown"],  description: "Indicates the entity type for KYC (person, company, unknown)")
        account_type(type: PropertyType.String, required: true, values:["BU", "CO"], description: "Indicates the account type in marketplace (BU, CO)")
        is_compliant(type: PropertyType.Boolean, required: true, description: "Indicates if is compliant with my-data-hub initiative (L5)", inheritable:false)
        access(type: PropertyType.String, required: true, values:["full", "partial", "restricted", "denied"], description: "Check for soft_compliant users")
        registered_by_phone(type: PropertyType.Boolean, required: true, description: "Indicates if user was registered by new registration (true) or legacy (false)", inheritable:false)
        has_identification(type: PropertyType.Boolean, required: false, description: "Indicates if the user has a non-validated identity or there is no information")
    }

    //Phone
    "/profile/phone"(platform: "/", type: TrackType.Event) {
        entity_type(type: PropertyType.String, required: true, values: ["company", "person", "unknown"],  description: "Indicates the entity type for KYC (person, company, unknown)")
        account_type(type: PropertyType.String, required: true, values:["BU", "CO"], description: "Indicates the account type in marketplace (BU, CO)")
        is_compliant(type: PropertyType.Boolean, required: true, description: "Indicates if is compliant with my-data-hub initiative (L5)", inheritable:false)
        registered_by_phone(type: PropertyType.Boolean, required: true, description: "Indicates if user was registered by new registration (true) or legacy (false)",  inheritable:false)
        status(type: PropertyType.String, required: true, values:["verified", "not-verified", "information"], description: "Indicates if field is verified or not (if applies) when clicking")
        has_identification(type: PropertyType.Boolean, required: false, description: "Indicates if the user has a non-validated identity or there is no information")
        access(type: PropertyType.String, required: false, values:["full", "partial", "restricted", "denied"], description: "Check for soft_compliant users")
    }

    //Phone alternative
    "/profile/phone_alternative"(platform: "/", type: TrackType.Event) {
        entity_type(type: PropertyType.String, required: true, values: ["company", "person", "unknown"],  description: "Indicates the entity type for KYC (person, company, unknown)")
        account_type(type: PropertyType.String, required: true, values:["BU", "CO"], description: "Indicates the account type in marketplace (BU, CO)")
        is_compliant(type: PropertyType.Boolean, required: true, description: "Indicates if is compliant with my-data-hub initiative (L5)", inheritable:false)
        registered_by_phone(type: PropertyType.Boolean, required: true, description: "Indicates if user was registered by new registration (true) or legacy (false)",  inheritable:false)
        status(type: PropertyType.String, required: true, values:["verified", "not-verified", "information"], description: "Indicates if field is verified or not (if applies) when clicking")
        access(type: PropertyType.String, required: false, values:["full", "partial", "restricted", "denied"], description: "Check for soft_compliant users")
        has_identification(type: PropertyType.Boolean, required: false, description: "Indicates if the user has a non-validated identity or there is no information")
    }

    //Preferred name
    "/profile/preferred_name"(platform: "/", type: TrackType.Event) {
        entity_type(type: PropertyType.String, required: true, values: ["company", "person", "unknown"],  description: "Indicates the entity type for KYC (person, company, unknown)")
        is_compliant(type: PropertyType.Boolean, required: true, description: "Indicates if is compliant with my-data-hub initiative (L5)", inheritable:false)
        account_type(type: PropertyType.String, required: true, values:["BU", "CO"], description: "Indicates the account type in marketplace (BU, CO)")
        status(type: PropertyType.String, required: true, values:["verified", "not-verified", "information"], description: "Indicates if field is verified or not (if applies) when clicking")
        access(type: PropertyType.String, required: false, values:["full", "partial", "restricted", "denied"], description: "Check for soft_compliant users")
        registered_by_phone(type: PropertyType.Boolean, required: false, description: "Indicates if user was registered by new registration (true) or legacy (false)")
        has_identification(type: PropertyType.Boolean, required: false, description: "Indicates if the user has a non-validated identity or there is no information")
    }

    //User name
    "/profile/user_name"(platform: "/", type: TrackType.Event) {
        entity_type(type: PropertyType.String, required: true, values: ["company", "person", "unknown"],  description: "Indicates the entity type for KYC (person, company, unknown)")
        account_type(type: PropertyType.String, required: true, values:["BU", "CO"], description: "Indicates the account type in marketplace (BU, CO)")
        is_compliant(type: PropertyType.Boolean, required: true, description: "Indicates if is compliant with my-data-hub initiative (L5)", inheritable:false)
        status(type: PropertyType.String, required: true, values:["verified", "not-verified", "information"], description: "Indicates if field is verified or not (if applies) when clicking")
        registered_by_phone(type: PropertyType.Boolean, required: false, description: "Indicates if user was registered by new registration (true) or legacy (false)")
        access(type: PropertyType.String, required: false, values:["full", "partial", "restricted", "denied"], description: "Check for soft_compliant users")
        has_identification(type: PropertyType.Boolean, required: false, description: "Indicates if the user has a non-validated identity or there is no information")
    }

    //Identity View
    "/profile/identity"(platform: "/", type: TrackType.View) {
        entity_type(type: PropertyType.String, required: true, values: ["company", "person", "unknown"],  description: "Indicates the entity type for KYC (person, company, unknown)")
        account_type(type: PropertyType.String, required: true, values:["BU", "CO"], description: "Indicates the account type in marketplace (BU, CO)")
        registered_by_phone(type: PropertyType.Boolean, required: false, description: "Indicates if user was registered by new registration (true) or legacy (false)")
        is_compliant(type: PropertyType.Boolean, required: true, description: "Indicates if is compliant with my-data-hub initiative (L5)", inheritable:false)
        access(type: PropertyType.String, required: true, values:["full", "partial", "restricted", "denied"], description: "Check for soft_compliant users")
        has_identification(type: PropertyType.Boolean, required: true, description: "Indicates if the user has a non-validated identity or there is no information", inheritable:false)
    }

    //Identity Validation
    "/profile/identity/validation"(platform: "/", type: TrackType.Event) {
        entity_type(type: PropertyType.String, required: true, values: ["company", "person", "unknown"],  description: "Indicates the entity type for KYC (person, company, unknown)")
        account_type(type: PropertyType.String, required: true, values:["BU", "CO"], description: "Indicates the account type in marketplace (BU, CO)")
        is_compliant(type: PropertyType.Boolean, required: true, description: "Indicates if is compliant with my-data-hub initiative (L5)", inheritable:false)
        has_identification(type: PropertyType.Boolean, required: true, description: "Indicates if the user has a non-validated identity or there is no information", inheritable:false)
        access(type: PropertyType.String, required: false, values:["full", "partial", "restricted", "denied"], description: "Check for soft_compliant users")
        registered_by_phone(type: PropertyType.Boolean, required: false, description: "Indicates if user was registered by new registration (true) or legacy (false)")
    }

    //Identity correction
    "/profile/identity/correction"(platform: "/", type: TrackType.Event) {
        entity_type(type: PropertyType.String, required: true, values: ["company", "person", "unknown"],  description: "Indicates the entity type for KYC (person, company, unknown)")
        account_type(type: PropertyType.String, required: true, values:["BU", "CO"], description: "Indicates the account type in marketplace (BU, CO)")
        is_compliant(type: PropertyType.Boolean, required: true, description: "Indicates if is compliant with my-data-hub initiative (L5)", inheritable:false)
        event_type(type: PropertyType.String, required: true, values:["onboarding", "redirect"], description: "Indicates if is an informative or a redirect event")
        access(type: PropertyType.String, required: false, values:["full", "partial", "restricted", "denied"], description: "Check for soft_compliant users")
        has_identification(type: PropertyType.Boolean, required: false, description: "Indicates if the user has a non-validated identity or there is no information")
        registered_by_phone(type: PropertyType.Boolean, required: false, description: "Indicates if user was registered by new registration (true) or legacy (false)")
    }

    //Identity fiscal_upgrade
    "/profile/identity/fiscal_upgrade"(platform: "/", type: TrackType.Event) {
        entity_type(type: PropertyType.String, required: true, values: ["company", "person", "unknown"],  description: "Indicates the entity type for KYC (person, company, unknown)")
        account_type(type: PropertyType.String, required: true, values:["BU", "CO"], description: "Indicates the account type in marketplace (BU, CO)")
        is_compliant(type: PropertyType.Boolean, required: true, description: "Indicates if is compliant with my-data-hub initiative (L5)", inheritable:false)
        event_type(type: PropertyType.String, required: true, values:["onboarding", "redirect"], description: "Indicates if is an informative or a redirect event")
        access(type: PropertyType.String, required: false, values:["full", "partial", "restricted", "denied"], description: "Check for soft_compliant users")
        registered_by_phone(type: PropertyType.Boolean, required: false, description: "Indicates if user was registered by new registration (true) or legacy (false)")
        has_identification(type: PropertyType.Boolean, required: false, description: "Indicates if the user has a non-validated identity or there is no information")
    }

    //Identity ownership_change
    "/profile/identity/ownership_change"(platform: "/", type: TrackType.Event) {
        entity_type(type: PropertyType.String, required: true, values: ["company", "person", "unknown"],  description: "Indicates the entity type for KYC (person, company, unknown)")
        account_type(type: PropertyType.String, required: true, values:["BU", "CO"], description: "Indicates the account type in marketplace (BU, CO)")
        is_compliant(type: PropertyType.Boolean, required: true, description: "Indicates if is compliant with my-data-hub initiative (L5)", inheritable:false)
        access(type: PropertyType.String, required: false, values:["full", "partial", "restricted", "denied"], description: "Check for soft_compliant users")
        event_type(type: PropertyType.String, required: true, values:["onboarding", "redirect"], description: "Indicates if is an informative or a redirect event")
        has_identification(type: PropertyType.Boolean, required: false, description: "Indicates if the user has a non-validated identity or there is no information")
        registered_by_phone(type: PropertyType.Boolean, required: false, description: "Indicates if user was registered by new registration (true) or legacy (false)")
    }
}