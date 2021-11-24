package src.test.resources.melidata
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"

    test("Point Devices views") {
        //Main list view
        "/point_devices/list"(platform: "/", type: TrackType.View) {}
        "/point_devices/reactivate_chips"(platform: "/", type: TrackType.View) {}
    }

    test("Point Devices events") {
        //Actions with redirect
        "/point_devices/out_of_paper"(platform: "/", type: TrackType.Event) {}
        "/point_devices/issues"(platform: "/", type: TrackType.Event) {}
        "/point_devices/change_owner"(platform: "/", type: TrackType.Event) {}
        "/point_devices/cards_promos"(platform: "/", type: TrackType.Event) {}
        "/point_devices/connect"(platform: "/", type: TrackType.Event) {}

        //Modal associate action
        "/point_devices/associate/start"(platform: "/", type: TrackType.Event) {}
        "/point_devices/associate/end"(platform: "/", type: TrackType.Event) {}

        //Modal delete action
        "/point_devices/delete/start"(platform: "/", type: TrackType.Event) {}
        "/point_devices/delete/end"(platform: "/", type: TrackType.Event) {}

        //Modal reset pin action
        "/point_devices/reset_pin/start"(platform: "/", type: TrackType.Event) {}
        "/point_devices/reset_pin/end"(platform: "/", type: TrackType.Event) {}

        //Reactivate chips button action
        "/point_devices/reactivate_chips/start"(platform: "/", type: TrackType.Event) {}
    }
}
