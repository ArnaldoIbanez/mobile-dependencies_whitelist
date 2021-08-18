import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    test("Profile") {

        "/profile"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            account_type = "BU"
            access = "full"
            registered_by_phone = false
            has_identification = false
        }

        "/profile"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = true
            account_type = "CO"
            access = "partial"
            registered_by_phone = false
            has_identification = false
        }

        "/profile"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            account_type = "BU"
            access = "full"
            registered_by_phone = false
            has_identification = true
        }

        "/profile"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            account_type = "CO"
            access = "fullrestricted"
            registered_by_phone = true
            has_identification = false
        }

        "/profile"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            account_type = "BU"
            access = "denied"
            registered_by_phone = false
            has_identification = true
        }

        "/profile"(platform: "/", type: TrackType.View) {
            entity_type = "unknown"
            is_compliant = true
            account_type = "CO"
            access = "denied"
            registered_by_phone = false
            has_identification = true
        }

        "/profile"(platform: "/", type: TrackType.View) {
            entity_type = "unknown"
            is_compliant = false
            account_type = "BU"
            access = "partial"
            registered_by_phone = true
            has_identification = false
        }
    }

    test("Email") {

        "/profile/email"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            account_type = "CO"
            status = "verified"
        }

        "/profile/email"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            status = "not-verified"
        }

        "/profile/email"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            status = "not-verified"
        }

        "/profile/email"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            account_type = "BU"
            status = "verified"
        }

        "/profile/email"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            status = "information"
        }

        "/profile/email"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = true
            account_type = "BU"
            status = "verified"
        }
    }

    test("Identity") {

        "/profile/identity"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            account_type = "CO"
            access = "full"
            registered_by_phone = true
        }

        "/profile/identity"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            access = "restricted"
            registered_by_phone = false
        }

        "/profile/identity"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            access = "denied"
            registered_by_phone = true
        }

        "/profile/identity"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            account_type = "BU"
            access = "partial"
            registered_by_phone = false
        }

        "/profile/identity"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            access = "denied"
            registered_by_phone = true
        }

        "/profile/identity"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = true
            account_type = "BU"
            access = "full"
            registered_by_phone = false
        }
    }

    test("phone") {

        "/profile/phone"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            account_type = "CO"
            registered_by_phone = true
            status = "verified"
        }

        "/profile/phone"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            registered_by_phone = false
            status = "information"
        }

        "/profile/phone"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/phone"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            account_type = "BU"
            registered_by_phone = false
            status = "verified"
        }

        "/profile/phone"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/phone"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = true
            account_type = "BU"
            registered_by_phone = false
            status = "information"
        }
    }

    test("Phone alternative") {

        "/profile/phone_alternative"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            account_type = "CO"
            registered_by_phone = true
            status = "verified"
        }

        "/profile/phone_alternative"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            registered_by_phone = false
            status = "information"
        }

        "/profile/phone_alternative"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/phone_alternative"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            account_type = "BU"
            registered_by_phone = false
            status = "verified"
        }

        "/profile/phone_alternative"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/phone_alternative"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = true
            account_type = "BU"
            registered_by_phone = false
            status = "information"
        }
    }

    test("Preferred name") {

        "/profile/preferred_name"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            account_type = "CO"
            status = "verified"
        }

        "/profile/preferred_name"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            status = "information"
        }

        "/profile/preferred_name"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            status = "not-verified"
        }

        "/profile/preferred_name"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            account_type = "BU"
            status = "verified"
        }

        "/profile/preferred_name"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            status = "not-verified"
        }

        "/profile/preferred_name"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = true
            account_type = "BU"
            status = "information"
        }
    }

    test("User name") {

        "/profile/user_name"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            account_type = "CO"
            status = "verified"
        }

        "/profile/user_name"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            status = "information"
        }

        "/profile/user_name"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            status = "not-verified"
        }

        "/profile/user_name"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            account_type = "BU"
            status = "verified"
        }

        "/profile/user_name"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "CO"
            status = "not-verified"
        }

        "/profile/user_name"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = true
            account_type = "BU"
            status = "information"
        }
    }

    test("Identity View") {

        "/profile/identity"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            account_type = "CO"
            is_compliant = true
            access = "full"
            has_identification = true
        }

        "/profile/identity"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "CO"
            is_compliant = false
            access = "restricted"
            has_identification = false
        }

        "/profile/identity"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "CO"
            is_compliant = false
            access = "denied"
            has_identification = true
        }

        "/profile/identity"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            account_type = "BU"
            is_compliant = true
            access = "partial"
            has_identification = false
        }

        "/profile/identity"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "CO"
            is_compliant = false
            access = "denied"
            has_identification = true
        }

        "/profile/identity"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "BU"
            is_compliant = true
            access = "full"
            has_identification = false
        }
    }

    test("Identity Validation") {

        "/profile/identity/validation"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            account_type = "CO"
            is_compliant = true
            has_identification = true
        }

        "/profile/identity/validation"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "CO"
            is_compliant = false
            has_identification = false
        }

        "/profile/identity/validation"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "CO"
            is_compliant = false
            has_identification = true
        }

        "/profile/identity/validation"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            account_type = "BU"
            is_compliant = true
            has_identification = false
        }

        "/profile/identity/validation"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "CO"
            is_compliant = false
            has_identification = true
        }

        "/profile/identity/validation"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "BU"
            is_compliant = true
            has_identification = false
        }
    }

    test("Identity correction") {

        "/profile/identity/correction"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            account_type = "CO"
            is_compliant = true
            event_type = "onboarding"
        }

        "/profile/identity/correction"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "CO"
            is_compliant = false
            event_type = "redirect"
        }

        "/profile/identity/correction"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "CO"
            is_compliant = false
            event_type = "onboarding"
        }

        "/profile/identity/correction"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            account_type = "BU"
            is_compliant = true
            event_type = "redirect"
        }

        "/profile/identity/correction"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "CO"
            is_compliant = false
            event_type = "onboarding"
        }

        "/profile/identity/correction"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "BU"
            is_compliant = true
            event_type = "redirect"
        }
    }

    test("Identity fiscal_upgrade") {

        "/profile/identity/fiscal_upgrade"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            account_type = "CO"
            is_compliant = true
            event_type = "onboarding"
        }

        "/profile/identity/fiscal_upgrade"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "CO"
            is_compliant = false
            event_type = "redirect"
        }

        "/profile/identity/fiscal_upgrade"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "CO"
            is_compliant = false
            event_type = "onboarding"
        }

        "/profile/identity/fiscal_upgrade"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            account_type = "BU"
            is_compliant = true
            event_type = "redirect"
        }

        "/profile/identity/fiscal_upgrade"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "CO"
            is_compliant = false
            event_type = "onboarding"
        }

        "/profile/identity/fiscal_upgrade"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "BU"
            is_compliant = true
            event_type = "redirect"
        }
    }

    test("Identity ownership_change") {

        "/profile/identity/ownership_change"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            account_type = "CO"
            is_compliant = true
            event_type = "onboarding"
        }

        "/profile/identity/ownership_change"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "CO"
            is_compliant = false
            event_type = "redirect"
        }

        "/profile/identity/ownership_change"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "CO"
            is_compliant = false
            event_type = "onboarding"
        }

        "/profile/identity/ownership_change"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            account_type = "BU"
            is_compliant = true
            event_type = "redirect"
        }

        "/profile/identity/ownership_change"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "CO"
            is_compliant = false
            event_type = "onboarding"
        }

        "/profile/identity/ownership_change"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            account_type = "BU"
            is_compliant = true
            event_type = "redirect"
        }
    }
}
