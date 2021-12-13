package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1362"

    //Profile
    "/profile"(platform: "/", type: TrackType.View) {
        entity_type(type: PropertyType.String, required: false, values: ["company", "person", "unknown"], description: "Indicates the entity type for KYC (person, company, unknown)")
        user_type(type: PropertyType.String, required: false, values: ["BU", "CO"], description: "Indicates the account type in marketplace (BU, CO)")
        is_compliant(type: PropertyType.Boolean, required: false, description: "Indicates if is compliant with my-data-hub initiative (L5)", inheritable: true)
        access(type: PropertyType.String, required: false, values: ["full", "partial", "restricted", "denied"], description: "Check for soft_compliant users")
        registered_by_phone(type: PropertyType.Boolean, required: false, description: "Indicates if user was registered by new registration (true) or legacy (false)")
        has_identification(type: PropertyType.Boolean, required: false, description: "Indicates if the user has a non-validated identity or there is no information", inheritable: true)
    }

    //Email
    "/profile/email"(platform: "/", type: TrackType.View) {
        status(type: PropertyType.String, required: true, values: ["verified", "not-verified", "information"], description: "Indicates if field is verified or not (if applies) when clicking")
    }

    "/profile/email/edit"(platform: "/", type: TrackType.View) {}

    "/profile/email/edit/action"(platform: "/", type: TrackType.Event) {}

    //Phone
    "/profile/phone"(platform: "/", type: TrackType.View) {
        status(type: PropertyType.String, required: true, values: ["verified", "not-verified", "information"], description: "Indicates if field is verified or not (if applies) when clicking")
    }

    "/profile/phone/edit"(platform: "/", type: TrackType.View) {}

    "/profile/phone/edit/action"(platform: "/", type: TrackType.Event) {}

    //Contact phone
    "/profile/contact_phone"(platform: "/", type: TrackType.View) {
        status(type: PropertyType.String, required: true, values: ["verified", "not-verified", "information"], description: "Indicates if field is verified or not (if applies) when clicking")
    }

    "/profile/contact_phone/edit"(platform: "/", type: TrackType.View) {}

    "/profile/contact_phone/edit/action"(platform: "/", type: TrackType.Event) {}

    //Alternative phone
    "/profile/alternative_phone"(platform: "/", type: TrackType.View) {
        status(type: PropertyType.String, required: true, values: ["verified", "not-verified", "information"], description: "Indicates if field is verified or not (if applies) when clicking")
    }

    "/profile/alternative_phone/edit"(platform: "/", type: TrackType.View) {}

    "/profile/alternative_phone/edit/action"(platform: "/", type: TrackType.Event) {}

    //Preferred name
    "/profile/preferred_name"(platform: "/", type: TrackType.View) {
        status(type: PropertyType.String, required: true, values: ["verified", "not-verified", "information"], description: "Indicates if field is verified or not (if applies) when clicking")
    }

    "/profile/preferred_name/edit"(platform: "/", type: TrackType.View) {}

    "/profile/preferred_name/edit/action"(platform: "/", type: TrackType.Event) {}

    //User name
    "/profile/user_name"(platform: "/", type: TrackType.View) {
        status(type: PropertyType.String, required: true, values: ["verified", "not-verified", "information"], description: "Indicates if field is verified or not (if applies) when clicking")
    }

    "/profile/user_name/edit"(platform: "/", type: TrackType.View) {}

    "/profile/user_name/edit/action"(platform: "/", type: TrackType.Event) {}

    //Identity
    "/profile/identity"(platform: "/", type: TrackType.View) {}

    //Identity Validation
    "/profile/identity/validation/action"(platform: "/", type: TrackType.Event) {}

    //Identity correction
    "/profile/identity/correction"(platform: "/", type: TrackType.View) {
        event_type(type: PropertyType.String, required: true, values: ["onboarding", "redirect"], description: "Indicates if is an informative or a redirect event")
    }

    "/profile/identity/correction/action"(platform: "/", type: TrackType.Event) {
        event_type(type: PropertyType.String, required: true, values: ["onboarding", "redirect"], description: "Indicates if is an informative or a redirect event")
    }

    //Identity fiscal_upgrade
    "/profile/identity/fiscal_upgrade"(platform: "/", type: TrackType.View) {
        event_type(type: PropertyType.String, required: true, values: ["onboarding", "redirect"], description: "Indicates if is an informative or a redirect event")
    }

    "/profile/identity/fiscal_upgrade/action"(platform: "/", type: TrackType.Event) {
        event_type(type: PropertyType.String, required: true, values: ["onboarding", "redirect"], description: "Indicates if is an informative or a redirect event")
    }

    //Identity ownership_change
    "/profile/identity/ownership_change/action"(platform: "/", type: TrackType.Event) {
        event_type(type: PropertyType.String, required: true, values: ["onboarding", "redirect"], description: "Indicates if is an informative or a redirect event")
    }

    //BU Legal representative
    "/profile/legal_representative"(platform: "/", type: TrackType.Event) {
        is_compliant(type: PropertyType.Boolean, required: true, description: "Indicates whether a user is compliant with my-data-hub initiative")
    }

    //BU account data
    "/profile/account_data"(platform: "/", type: TrackType.Event) {
        has_identification(type: PropertyType.Boolean, required: true, description: "Indicates whether a user has identification")
    }

    "/profile/account_data/edit"(platform: "/", type: TrackType.Event) {
        has_identification(type: PropertyType.Boolean, required: true, description: "Indicates whether a user has identification")
    }

    //Fiscal data
    "/profile/fiscal_data"(platform: "/", type: TrackType.Event) {
        status(type: PropertyType.String, required: true, values: ["verified", "not-verified", "information"], description: "Indicates if user's fiscal data is verified")
    }

    "/profile/fiscal_data/fiscal_condition"(platform: "/", type: TrackType.Event) {
        entity_type(type: PropertyType.String, required: true, values: ["person", "company", "unknown"], description: "Indicates the user's entity type for kyc")
    }

    "/profile/fiscal_data/gross_income_regime"(platform: "/", type: TrackType.Event) {
        user_type(type: PropertyType.String, required: true, values: ["CO", "BU"], description: "Indicates the user's account type in marketplace")
    }

    "/profile/fiscal_data/gross_income_exclusion"(platform: "/", type: TrackType.Event) {
        is_compliant(type: PropertyType.Boolean, required: true, description: "Indicates whether a user is compliant with my-data-hub initiative")
    }
}
