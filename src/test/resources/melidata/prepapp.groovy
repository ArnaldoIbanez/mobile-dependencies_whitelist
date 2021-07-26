package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS PREPARATION APP GENERAL
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Preparation App - Melidata Tracks Tests") {

        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // DATA SET
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        def dataSet = {
            seller = [
                    [
                            meli_id: 123456
                    ]
            ]
            context = "auth"
            error = "no_permission"
        }


        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TEST TRACKS PREPARATION APP - GENERAL
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        "/prepapp/splash"(platform:"/", type: TrackType.View) {
        }

        "/prepapp/enter"(platform:"/", type: TrackType.View) {
        }

        "/prepapp/auth"(platform:"/", type: TrackType.View) {
        }

        "/prepapp/error"(platform:"/", type: TrackType.View) {
            dataSet()
        }
    }
}