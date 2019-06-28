import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("Preference") {

        // Init event
        "/preference/init"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
            url = "url"
        }

        // Init event with pref_id
        "/preference/init"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
            pref_id = "pref id"
        }

        // Init event with short_id
        "/preference/init"(platform: "/mobile", type: TrackType.Event) {
            session_id = "id"
            short_id = "short id"
        }    
    }
}
