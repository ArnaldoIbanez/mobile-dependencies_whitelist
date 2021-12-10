import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    test("Profile") {

        "/profile"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            access = "full"
            registered_by_phone = false
            has_identification = false
        }

        "/profile"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = true
            user_type = "CO"
            access = "partial"
            registered_by_phone = false
            has_identification = false
        }

        "/profile"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "BU"
            access = "full"
            registered_by_phone = false
            has_identification = true
        }

        "/profile"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            access = "restricted"
            registered_by_phone = true
            has_identification = false
        }

        "/profile"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "BU"
            access = "denied"
            registered_by_phone = false
            has_identification = true
        }

        "/profile"(platform: "/", type: TrackType.View) {
            entity_type = "unknown"
            is_compliant = true
            user_type = "CO"
            access = "denied"
            registered_by_phone = false
            has_identification = true
        }

        "/profile"(platform: "/", type: TrackType.View) {
            entity_type = "unknown"
            is_compliant = false
            user_type = "BU"
            access = "partial"
            registered_by_phone = true
            has_identification = false
        }
    }

    test("Email") {

        "/profile/email"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            status = "verified"
        }

        "/profile/email"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/email"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/email"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            status = "verified"
        }

        "/profile/email"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "information"
        }

        "/profile/email"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            status = "verified"
        }

        "/profile/email/edit"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            status = "verified"
        }

        "/profile/email/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/email/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/email/edit"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            status = "verified"
        }

        "/profile/email/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "information"
        }

        "/profile/email/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            status = "verified"
        }

        "/profile/email/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            status = "verified"
        }

        "/profile/email/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/email/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/email/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            status = "verified"
        }

        "/profile/email/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "information"
        }

        "/profile/email/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            status = "verified"
        }
    }

    test("phone") {

        "/profile/phone"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            registered_by_phone = true
            status = "verified"
        }

        "/profile/phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            registered_by_phone = true
            status = "verified"
        }

        "/profile/phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            registered_by_phone = true
            status = "verified"
        }

        "/profile/phone"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = false
            status = "information"
        }

        "/profile/phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = false
            status = "information"
        }

        "/profile/phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = false
            status = "information"
        }

        "/profile/phone"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/phone"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "verified"
        }

        "/profile/phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "verified"
        }

        "/profile/phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "verified"
        }

        "/profile/phone"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/phone"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "information"
        }

        "/profile/phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "information"
        }

        "/profile/phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "information"
        }
    }

    test("Alternative phone") {

        "/profile/alternative_phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            registered_by_phone = true
            status = "verified"
        }

        "/profile/alternative_phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            registered_by_phone = true
            status = "verified"
        }

        "/profile/alternative_phone"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            registered_by_phone = true
            status = "verified"
        }

        "/profile/alternative_phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = false
            status = "information"
        }

        "/profile/alternative_phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = false
            status = "information"
        }

        "/profile/alternative_phone"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = false
            status = "information"
        }

        "/profile/alternative_phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/alternative_phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/alternative_phone"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/alternative_phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "verified"
        }

        "/profile/alternative_phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "verified"
        }

        "/profile/alternative_phone"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "verified"
        }

        "/profile/alternative_phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/alternative_phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/alternative_phone"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/alternative_phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "information"
        }

        "/profile/alternative_phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "information"
        }

        "/profile/alternative_phone"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "information"
        }
    }

    test("Contact phone") {

        "/profile/contact_phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            registered_by_phone = true
            status = "verified"
        }

        "/profile/contact_phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            registered_by_phone = true
            status = "verified"
        }

        "/profile/contact_phone"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            registered_by_phone = true
            status = "verified"
        }

        "/profile/contact_phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = false
            status = "information"
        }

        "/profile/contact_phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = false
            status = "information"
        }

        "/profile/contact_phone"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = false
            status = "information"
        }

        "/profile/contact_phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/contact_phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/contact_phone"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/contact_phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "verified"
        }

        "/profile/contact_phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "verified"
        }

        "/profile/contact_phone"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "verified"
        }

        "/profile/contact_phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/contact_phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/contact_phone"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            registered_by_phone = true
            status = "not-verified"
        }

        "/profile/contact_phone/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "information"
        }

        "/profile/contact_phone/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "information"
        }

        "/profile/contact_phone"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            registered_by_phone = false
            status = "information"
        }
    }

    test("Preferred name") {

        "/profile/preferred_name/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            status = "verified"
        }

        "/profile/preferred_name/edit"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            status = "verified"
        }

        "/profile/preferred_name"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            status = "verified"
        }

        "/profile/preferred_name/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "information"
        }

        "/profile/preferred_name/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "information"
        }

        "/profile/preferred_name"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "information"
        }

        "/profile/preferred_name/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/preferred_name/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/preferred_name"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/preferred_name/edit"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            status = "verified"
        }

        "/profile/preferred_name/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            status = "verified"
        }

        "/profile/preferred_name"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            status = "verified"
        }

        "/profile/preferred_name/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/preferred_name/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/preferred_name"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/preferred_name/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            status = "information"
        }

        "/profile/preferred_name/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            status = "information"
        }

        "/profile/preferred_name"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            status = "information"
        }
    }

    test("User name") {

        "/profile/user_name/edit"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            status = "verified"
        }

        "/profile/user_name/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            status = "verified"
        }

        "/profile/user_name"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "CO"
            status = "verified"
        }

        "/profile/user_name/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "information"
        }

        "/profile/user_name/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "information"
        }

        "/profile/user_name"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "information"
        }

        "/profile/user_name/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/user_name/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/user_name"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/user_name/edit"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            status = "verified"
        }

        "/profile/user_name/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            status = "verified"
        }

        "/profile/user_name"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            user_type = "BU"
            status = "verified"
        }

        "/profile/user_name/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/user_name/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/user_name"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            user_type = "CO"
            status = "not-verified"
        }

        "/profile/user_name/edit"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            status = "information"
        }

        "/profile/user_name/edit/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            status = "information"
        }

        "/profile/user_name"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = true
            user_type = "BU"
            status = "information"
        }
    }

    test("Identity") {

        "/profile/identity"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            user_type = "CO"
            is_compliant = true
            access = "full"
            has_identification = true
        }

        "/profile/identity"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            access = "restricted"
            has_identification = false
        }

        "/profile/identity"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            access = "denied"
            has_identification = true
        }

        "/profile/identity"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            user_type = "BU"
            is_compliant = true
            access = "partial"
            has_identification = false
        }

        "/profile/identity"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            access = "denied"
            has_identification = true
        }

        "/profile/identity"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            user_type = "BU"
            is_compliant = true
            access = "full"
            has_identification = false
        }
    }

    test("Identity Validation") {

        "/profile/identity/validation/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            user_type = "CO"
            is_compliant = true
            has_identification = true
        }

        "/profile/identity/validation/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            has_identification = false
        }

        "/profile/identity/validation/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            has_identification = true
        }

        "/profile/identity/validation/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            user_type = "BU"
            is_compliant = true
            has_identification = false
        }

        "/profile/identity/validation/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            has_identification = true
        }

        "/profile/identity/validation/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "BU"
            is_compliant = true
            has_identification = false
        }
    }

    test("Identity correction") {
        // For view
        "/profile/identity/correction"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            user_type = "CO"
            is_compliant = true
            event_type = "onboarding"
        }

        "/profile/identity/correction"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            event_type = "redirect"
        }

        "/profile/identity/correction"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            event_type = "onboarding"
        }

        "/profile/identity/correction"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            user_type = "BU"
            is_compliant = true
            event_type = "redirect"
        }

        "/profile/identity/correction"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            event_type = "onboarding"
        }

        "/profile/identity/correction"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            user_type = "BU"
            is_compliant = true
            event_type = "redirect"
        }

        // For event
        "/profile/identity/correction/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            user_type = "CO"
            is_compliant = true
            event_type = "onboarding"
        }

        "/profile/identity/correction/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            event_type = "redirect"
        }

        "/profile/identity/correction/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            event_type = "onboarding"
        }

        "/profile/identity/correction/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            user_type = "BU"
            is_compliant = true
            event_type = "redirect"
        }

        "/profile/identity/correction/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            event_type = "onboarding"
        }

        "/profile/identity/correction/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "BU"
            is_compliant = true
            event_type = "redirect"
        }
    }

    test("Identity fiscal_upgrade") {

        // For view
        "/profile/identity/fiscal_upgrade"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            user_type = "CO"
            is_compliant = true
            event_type = "onboarding"
        }

        "/profile/identity/fiscal_upgrade"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            event_type = "redirect"
        }

        "/profile/identity/fiscal_upgrade"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            event_type = "onboarding"
        }

        "/profile/identity/fiscal_upgrade"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            user_type = "BU"
            is_compliant = true
            event_type = "redirect"
        }

        "/profile/identity/fiscal_upgrade"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            event_type = "onboarding"
        }

        "/profile/identity/fiscal_upgrade"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            user_type = "BU"
            is_compliant = true
            event_type = "redirect"
        }

        // For event
        "/profile/identity/fiscal_upgrade/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            user_type = "CO"
            is_compliant = true
            event_type = "onboarding"
        }

        "/profile/identity/fiscal_upgrade/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            event_type = "redirect"
        }

        "/profile/identity/fiscal_upgrade/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            event_type = "onboarding"
        }

        "/profile/identity/fiscal_upgrade/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            user_type = "BU"
            is_compliant = true
            event_type = "redirect"
        }

        "/profile/identity/fiscal_upgrade/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            event_type = "onboarding"
        }

        "/profile/identity/fiscal_upgrade/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "BU"
            is_compliant = true
            event_type = "redirect"
        }

    }

    test("Identity ownership_change") {

        "/profile/identity/ownership_change/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            user_type = "CO"
            is_compliant = true
            event_type = "onboarding"
        }

        "/profile/identity/ownership_change/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            event_type = "redirect"
        }

        "/profile/identity/ownership_change/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            event_type = "onboarding"
        }

        "/profile/identity/ownership_change/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            user_type = "BU"
            is_compliant = true
            event_type = "redirect"
        }

        "/profile/identity/ownership_change/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "CO"
            is_compliant = false
            event_type = "onboarding"
        }

        "/profile/identity/ownership_change/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "BU"
            is_compliant = true
            event_type = "redirect"
        }
    }

    test("Legal representative") {
        "/profile/legal_representative"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "BU"
            access = "full"
            status = "information"
            is_compliant = true
            registered_by_phone = false
            has_identification = false
        }

        "/profile/legal_representative"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "BU"
            access = "full"
            status = "information"
            is_compliant = false
            registered_by_phone = false
            has_identification = false
        }
    }

    test("Account data") {
        "/profile/account_data"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "BU"
            access = "full"
            status = "information"
            is_compliant = true
            registered_by_phone = false
            has_identification = true
        }

        "/profile/account_data"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "BU"
            access = "full"
            status = "information"
            is_compliant = true
            registered_by_phone = false
            has_identification = false
        }

        "/profile/account_data/edit"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "BU"
            access = "full"
            status = "information"
            is_compliant = true
            registered_by_phone = false
            has_identification = true
        }

        "/profile/account_data/edit"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "BU"
            access = "full"
            status = "information"
            is_compliant = true
            registered_by_phone = false
            has_identification = false
        }
    }

    test("Fiscal data") {
        "/profile/fiscal_data"(platform: "/", type: TrackType.Event) {
            status = "verified"
            entity_type = "company"
            user_type = "BU"
            access = "full"
            is_compliant = true
            registered_by_phone = false
            has_identification = true
        }

        "/profile/fiscal_data"(platform: "/", type: TrackType.Event) {
            status = "not-verified"
            entity_type = "company"
            user_type = "BU"
            access = "full"
            is_compliant = true
            registered_by_phone = false
            has_identification = true
        }

        "/profile/fiscal_data"(platform: "/", type: TrackType.Event) {
            status = "information"
            entity_type = "company"
            user_type = "BU"
            access = "full"
            is_compliant = true
            registered_by_phone = false
            has_identification = true
        }

        "/profile/fiscal_data/fiscal_condition"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            user_type = "BU"
            access = "full"
            status = "information"
            is_compliant = true
            registered_by_phone = false
            has_identification = true
        }

        "/profile/fiscal_data/fiscal_condition"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            user_type = "BU"
            access = "full"
            status = "information"
            is_compliant = true
            registered_by_phone = false
            has_identification = true
        }

        "/profile/fiscal_data/fiscal_condition"(platform: "/", type: TrackType.Event) {
            entity_type = "unknown"
            user_type = "BU"
            access = "full"
            status = "information"
            is_compliant = true
            registered_by_phone = false
            has_identification = true
        }

        "/profile/fiscal_data/gross_income_regime"(platform: "/", type: TrackType.Event) {
            user_type = "CO"
            entity_type = "company"
            access = "full"
            status = "information"
            is_compliant = true
            registered_by_phone = false
            has_identification = true
        }

        "/profile/fiscal_data/gross_income_regime"(platform: "/", type: TrackType.Event) {
            user_type = "BU"
            entity_type = "company"
            access = "full"
            status = "information"
            is_compliant = true
            registered_by_phone = false
            has_identification = true
        }

        "/profile/fiscal_data/gross_income_exclusion"(platform: "/", type: TrackType.Event) {
            is_compliant = true
            entity_type = "company"
            user_type = "BU"
            access = "full"
            status = "information"
            registered_by_phone = false
            has_identification = true
        }

        "/profile/fiscal_data/gross_income_exclusion"(platform: "/", type: TrackType.Event) {
            is_compliant = false
            entity_type = "company"
            user_type = "BU"
            access = "full"
            status = "information"
            registered_by_phone = false
            has_identification = true
        }
    }
}
