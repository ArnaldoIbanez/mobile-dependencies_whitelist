import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("flex optin track"){

        def defaultTrackInformation = {
            view="success_flex"
        }

        "/shipping/flex/optin"(platform: "/") {
            defaultTrackInformation()
        }

    }

}
