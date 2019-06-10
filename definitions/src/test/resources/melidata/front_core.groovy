package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


/**************************
* WALLET HOME TEST TRACKS *
**************************/


trackTests {

    defaultBusiness = "mercadopago"

    test("Mercadopago Home") {
        "/wallet/home" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago Home Pull") {
        "/wallet/home/pull" (platform: "/mobile", type: TrackType.Event) {}
    }

    test("Mercadopago Home Tap") {
        "/wallet/home/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://instore/scan_qr"
        }
    }

    test("Mercadopago Home Show") {
        "/wallet/home/show" (platform: "/mobile", type: TrackType.Event) {
            header = "name"
            items = [
                [
                    id: "banking",
                    ordinal: 1,
                    type: "BANKING"
            ]
            ]
        }
    }

    test("Mercadopago Home Show Instore generic") {
        "/wallet/home/show/instore/promotion/generic"(platform: "/mobile", type: TrackType.Event) {
            header = "name"
            items = [
                    [
                            id: "generic",
                            ordinal: 4,
                            type: "PROMOTION"
                    ]
            ]
            header_title = "Any title"
            link = "Any deeplink"
            items = ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"]
            items_size = "3"
        }
    }

    test("Mercadopago Home Show Instore qr_map") {
        "/wallet/home/show/instore/promotion/qr_map"(platform: "/mobile", type: TrackType.Event) {
            header = "name"
            items = [
                    [
                            id: "qr_map",
                            ordinal: 4,
                            type: "PROMOTION"
                    ]
            ]
            header_title = "Any title"
            link = "Any deeplink"
            items = ["instore_home_sections_brand_mla_shell", "instore_home_sections_brand_mla_patagonia", "instore_home_sections_brand_mla_kfc"]
            items_size = "3"
        }
    }


}