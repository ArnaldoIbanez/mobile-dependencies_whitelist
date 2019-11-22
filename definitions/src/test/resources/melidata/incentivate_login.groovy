package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"
    test("navigation incentivate login show track") {
        "/navigation/login/show"(platform: "/", type: TrackType.View) {
            app_id="web-vip"
            widget_type="modal"
        }
    }

    test("navigation incentivate login close track") {
        "/navigation/login/close"(platform: "/", type: TrackType.Event) {
            app_id="web-vip"
            widget_type="modal"
        }
    }

    test("navigation incentivate login autoclose track") {
        "/navigation/login/autoclose"(platform: "/", type: TrackType.Event) {
            app_id="web-vip"
            widget_type="modal"
        }
    }

    test("navigation incentivate login for login link track") {
        "/navigation/login/login_link"(platform: "/", type: TrackType.Event) {
            app_id="web-vip"
            widget_type="modal"
        }
    }

    test("navigation incentivate login for register link track") {
        "/navigation/login/register_link"(platform: "/", type: TrackType.Event) {
            app_id="web-vip"
            widget_type="modal"
        }
    }

    test("navigation incentivate login show track with widget type tooltip") {
        "/navigation/login/show"(platform: "/", type: TrackType.View) {
            app_id="web-vip"
            widget_type="tooltip"
        }
    }

    test("navigation incentivate login show track with widget type banner") {
        "/navigation/login/show"(platform: "/", type: TrackType.View) {
            app_id="web-vip"
            widget_type="banner"
        }
    }
}
