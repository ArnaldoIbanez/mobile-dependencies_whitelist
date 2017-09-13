import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("melidata vip track") {

        def defaultTrackInformation = {
            item_id = "MLA213512313"
            attribute_id = 2131
        }

        def trackModals = {
            show = "fae_details"
        }

        "/vip/variations"(platform: "/web") {
            defaultTrackInformation()
        }

        "/vip/reviews"(platform: "/", type: TrackType.Event) {
            trackModals()
        }

    }

}
