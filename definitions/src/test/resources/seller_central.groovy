    
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Seller central
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Test base path") {
        "/seller_central"(platform: "/", type: TrackType.View) {}
        "/seller_central/listings"(platform: "/", type: TrackType.View) {}
    }

    test("seller central listing main page") {
        "/seller_central/listings/list"(platform: "/", type: TrackType.View) {}
    }


    test("seller central listing filters") {
        "/seller_central/listings/filters"(platform: "/", type: TrackType.Event) {}
        "/seller_central/listings/action"(platform: "/", type: TrackType.Event) {
            action_id = "MODIFY"
        }
    }

}
