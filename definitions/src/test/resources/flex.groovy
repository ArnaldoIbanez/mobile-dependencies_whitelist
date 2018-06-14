import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadoenvios"

    test("flex optin track returned success view"){

        def defaultTrackInformation = {
            view = "success_flex"
        }

        "/flex/optin"(platform:"/", type: TrackType.Event) {
            defaultTrackInformation()
        }

    }

    test("flex optout track returned form view"){

        def defaultTrackInformation = {
            view = "form"
        }

        "/flex/optout"(platform:"/", type: TrackType.Event) {
            defaultTrackInformation()
        }

    }

    test("flex landing view"){
        "/flex/landing"(platform:"/", type: TrackType.Event) {}
    }
}
