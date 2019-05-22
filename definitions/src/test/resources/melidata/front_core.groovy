package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


/*************************
*       FRONT CORE       *
*************************/

trackTests {

    defaultBusiness = "mercadopago"

    test("Mercadopago Home") {
        "/front_core/home"(platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Home Pull") {
        "/front_core/pull"(platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Home Show") {

        "/front_core/show"(platform: "/mobile", type: TrackType.Event) {
            header = [title: "nombre"]
            // items = [
            //     {
            //         ordinal = "1"
            //         id = "banking"
            //         type = "BANKING"
            //         item_tracking_data = {
            //             data = ""
            //         }
            //     }
            // ]
            // backend_tracking_data = []
        }
    }

}