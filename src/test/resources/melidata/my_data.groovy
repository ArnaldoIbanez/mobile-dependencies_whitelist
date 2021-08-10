import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    test("My data") {

        "/my_data"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            compliant = "valid"
            account_type = "BU"
        }

        "/my_data"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            compliant = "not-valid"
            account_type = "BU"
        }

        "/my_data"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            compliant = "na"
            account_type = "CO"
        }

        "/my_data/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            compliant = "valid"
            account_type = "CO"
            event_type = "click"
            target = "nickname"
        }

        "/my_data/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            compliant = "not-valid"
            account_type = "BU"
            event_type = "click"
            target = "user"
        }

        "/my_data/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            compliant = "valid"
            account_type = "CO"
            event_type = "click"
            target = "phone"
        }

        "/my_data/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            compliant = "valid"
            account_type = "CO"
            event_type = "click"
            target = "identity"
        }

        "/my_data/action"(platform: "/", type: TrackType.Event) {
            entity_type = "unknown"
            compliant = "na"
            account_type = "CO"
            event_type = "click"
            target = "user"
        }

        "/my_data/action"(platform: "/", type: TrackType.Event) {
            entity_type = "unknown"
            compliant = "valid"
            account_type = "BU"
            event_type = "click"
            target = "preferred-name"
        }

        "/my_data/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            compliant = "na"
            account_type = "BU"
            event_type = "click"
            target = "identity"
        }

        "/my_data/action"(platform: "/", type: TrackType.Event) {
            entity_type = "unknown"
            compliant = "valid"
            account_type = "BU"
            event_type = "click"
            target = "user"
        }

        "/my_data/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            compliant = "not-valid"
            account_type = "BU"
            event_type = "click"
            target = "email"
        }
    }

    test("identity") {


        "/my_data/identity"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            compliant = "valid"
            account_type = "BU"
        }

        "/my_data/identity"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            compliant = "not-valid"
            account_type = "BU"
        }

        "/my_data/identity"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            compliant = "valid"
            account_type = "CO"
        }

        "/my_data/identity"(platform: "/", type: TrackType.View) {
            entity_type = "unknown"
            compliant = "valid"
            account_type = "BU"
        }

        "/my_data/identity"(platform: "/", type: TrackType.View) {
            entity_type = "unknown"
            compliant = "not-valid"
            account_type = "CO"
        }

        "/my_data/identity/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            compliant = "valid"
            account_type = "CO"
        }

        "/my_data/identity/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            compliant = "not-valid"
            account_type = "BU"
        }

        "/my_data/identity/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            compliant = "not-valid"
            account_type = "BU"
        }

        "/my_data/identity/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            compliant = "not-valid"
            account_type = "BU"
        }

        "/my_data/identity/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            compliant = "not-valid"
            account_type = "CO"
        }

        "/my_data/identity/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            compliant = "na"
            account_type = "BU"
        }

        "/my_data/identity/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            compliant = "valid"
            account_type = "BU"
        }

        "/my_data/identity/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            compliant = "valid"
            account_type = "BU"
        }

        "/my_data/identity/action"(platform: "/", type: TrackType.Event) {
            entity_type = "unknown"
            compliant = "na"
            account_type = "CO"
        }

        "/my_data/identity/action"(platform: "/", type: TrackType.Event) {
            entity_type = "unknown"
            compliant = "valid"
            account_type = "BU"
        }

        "/my_data/identity/action"(platform: "/", type: TrackType.Event) {
            entity_type = "unknown"
            compliant = "valid"
            account_type = "CO"
        }
    }
}
