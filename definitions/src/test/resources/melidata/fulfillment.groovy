package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Fbm inbound views") {
        "/fbm/panel/inbound/units"(platform: "/", type: TrackType.View) {}
        "/fbm/panel/inbound/labeling"(platform: "/", type: TrackType.View) {}
        "/fbm/panel/inbound/identifiers"(platform: "/", type: TrackType.View) {}
    }

    test("Fbm landing views") {
      "/full/landing/buyer"(platform: "/", type: TrackType.View) {}
    }

    test("Inbound units events") {
        "/fbm/panel/inbound/units/input_change"(platform: "/", type: TrackType.Event) {
            warning_type = 'show_incentive'
            warning_value = 51
            inbound_id = 2649
            inventory_id = 'YWGV00053'
            input_value = 6
        }

        "/fbm/panel/inbound/units/submit_error"(platform: "/", type: TrackType.Event) {
             warnings = [
                [
                    warning_type: 'show_restriction',
                    warning_value : 100, 
                    inbound_id : 2649, 
                    inventory_id : 'YWGV00053',
                    input_value : 300
                ]
            ]
        }

        "/fbm/panel/inbound/units/input_delete"(platform: "/", type: TrackType.Event) {
            inbound_id = 2649
            inventory_id = 'YWGV00053'
        }
    }
}
