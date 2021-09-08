package src.test.resources.melidata
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"

    test("Point Devices views") {
        //Main list view
        "/point/devices/list"(platform: "/", type: TrackType.View) {}
    }

    test("Point Devices events") {
        //Actions with redirect
        "/point/devices/out_of_paper"(platform: "/", type: TrackType.Event) {}
        "/point/devices/issues"(platform: "/", type: TrackType.Event) {}
        "/point/devices/change_owner"(platform: "/", type: TrackType.Event) {}
        "/point/devices/cards_promos"(platform: "/", type: TrackType.Event) {}
        "/point/devices/connect"(platform: "/", type: TrackType.Event) {}

        //Modal associate action
        "/point/devices/associate/start"(platform: "/", type: TrackType.Event) {}
        "/point/devices/associate/end"(platform: "/", type: TrackType.Event) {}

        //Modal delete action
        "/point/devices/delete/start"(platform: "/", type: TrackType.Event) {}
        "/point/devices/delete/end"(platform: "/", type: TrackType.Event) {}

        //Modal reset pin action
        "/point/devices/reset_pin/start"(platform: "/", type: TrackType.Event) {}
        "/point/devices/reset_pin/end"(platform: "/", type: TrackType.Event) {}
    }
}
