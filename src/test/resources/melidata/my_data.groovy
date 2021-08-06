import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    test("My data") {

        "/my-data"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            account_type = "BU"
        }

        "/my-data"(platform: "/", type: TrackType.View) {
            entity_type = "company"
            is_compliant = false
            account_type = "BU"
        }

        "/my-data"(platform: "/", type: TrackType.View) {
            entity_type = "person"
            is_compliant = true
            account_type = "CO"
        }

        "/my-data/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            account_type = "CO"
            event_type = "click"
            target = "nickname"
        }

        "/my-data/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "BU"
            event_type = "click"
            target = "user"
        }

        "/my-data/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = true
            account_type = "CO"
            event_type = "click"
            target = "phone"
        }

        "/my-data/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            account_type = "CO"
            event_type = "click"
            target = "identity"
        }
    }

    test("User") {

        "/my-data/user-identity-me/action"(platform: "/", type: TrackType.Event) {
            entity_type = "person"
            is_compliant = true
            account_type = "CO"
            target = "modified"
        }

        "/my-data/user-identity-me/action"(platform: "/", type: TrackType.Event) {
            entity_type = "company"
            is_compliant = false
            account_type = "BU"
            target = "modified"
        }
    }
}
