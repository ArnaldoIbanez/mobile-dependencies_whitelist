package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


/*************************
*       FRONT CORE       *
*************************/


trackTests {

    defaultBusiness = "mercadopago"

    /*************************
    *    HOME TEST TRACKS    *
    *************************/

    test("Mercadopago Home") {
        "/front_core/home" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Home Pull") {
        "/front_core/home/pull" (platform: "/mobile", type: TrackType.Event) {
            backend_tracking_data = [ title: "name" ]
        }
    }

    test("Mercadopago Home Show") {
        "/front_core/home/show" (platform: "/mobile", type: TrackType.Event) {
            header = [ title : "name" ]
            items = [
                banking: [
                    ordinal: 1,
                    type: "BANKING"
                ]
            ]
            backend_tracking_data = [ title: "name" ]
        }
    }
    
    test("Mercadopago Home Show by Id") {
        "/front_core/home/banking" (platform: "/mobile", type: TrackType.Event) {
            type = "BANKING"
            ordinal = 1
        }

        "/front_core/home/main_actions" (platform: "/mobile", type: TrackType.Event) {
            type = "MAIN_ACTIONS"
            ordinal = 2
        }

        "/front_core/home/secondary_actions" (platform: "/mobile", type: TrackType.Event) {
            type = "SECONDARY_ACTIONS"
            ordinal = 3
        }

        "/front_core/home/benefits" (platform: "/mobile", type: TrackType.Event) {
            type = "VERTICAL_LIST"
            ordinal = 4
        }

        "/front_core/home/cross_selling" (platform: "/mobile", type: TrackType.Event) {
            type = "CAROUSEL"
            ordinal = 5
        }

        "/front_core/home/activities" (platform: "/mobile", type: TrackType.Event) {
            type = "ACTIVITIES"
            ordinal = 6
        }

        "/front_core/home/qr_map" (platform: "/mobile", type: TrackType.Event) {
            type = "PROMOTION"
            ordinal = 7
        }
    }

    /************************************
    *    ACTIVITY MOBILE TEST TRACKS    *
    ************************************/

    test("Mercadopago Activities List Mobile") {
        "/front_core/activities/list" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Activity Apply Filters Mobile") {
        "/front_core/activities/filters/apply" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Activity Filters List Mobile") {
        "/front_core/activities/filters" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Activity Filters Options List Mobile") {
        "/front_core/activities/filters/options" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Activity Remove Filters Mobile") {
        "/front_core/activities/list/remove_filter" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Operation Detail List Mobile") {
        "/front_core/activities/detail" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Operation Detail List Mobile") {
        "/front_core/activities/detail/list" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Operation Detail Add Note List Mobile") {
        "/front_core/activities/detail/add_note" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Operation Detail Buyer Information Mobile") {
        "/front_core/activities/detail/user_info" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Operation Detail Shipping Mobile") {
        "/front_core/activities/detail/shipping" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Operation Detail Web View Mobile") {
        "/front_core/activities/detail/web_view" (platform: "/mobile", type: TrackType.View) {
            url = "https://mercadolibre.com"
        }
    }

    test("Mercadopago Operation Detail Send Realtimes Activities Mobile") {
        "/front_core/activities/real_time/push" (platform: "/mobile", type: TrackType.Event) {
            activity_id = 'merch-123124'
            date_created = '12/11/19'
        }
    }

    test("Mercadopago Operation Detail Number Of Realtimes Activities Mobile") {
        "/front_core/activities/real_time/total" (platform: "/mobile", type: TrackType.Event) {
            total = 12
        }
    }
}