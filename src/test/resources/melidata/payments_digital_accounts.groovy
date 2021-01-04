package src.test.resources.melidata

import com.ml.melidata.catalog.PropertyType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadopago"

    /******************************************
    *  Payments - Digital Accounts - Banking  *
    ******************************************/

    test("Balance") {
        "/banking/balance"(platform: "/", type: TrackType.View) {}
    }

    test("Balance Calendar") {
        "/banking/calendar"(platform: "/", type: TrackType.View) {}
    }

    test("Balance Activities") {
        "/banking/activities"(platform: "/", type: TrackType.View) {}
    }

    test("Balance Cerc") {
        "/banking/cerc"(platform: "/", type: TrackType.View) {}
    }

    test("Movements") {
        "/banking/movements"(platform: "/", type: TrackType.View) {}
    }

    test("PNF") {
        "/banking/pnf"(platform: "/", type: TrackType.View) {}
    }

    test("Banking Balance Merch Engine Events") {
        "/banking/balance/credits/print" (platform: "/", type: TrackType.Event) {
            section_id = 'cards'
            component_id = 'component_12'
            content_id = 'banking_merch_engine'
            audience = 'credits'
            position = 1
            logic = 'campaigns'
            bu = 'mp'
            bu_line = 'banking'
            flow = '1'
        }
        "/banking/balance/credits/tap" (platform: "/", type: TrackType.Event) {
            section_id = 'cards'
            component_id = 'component_12'
            content_id = 'banking_merch_engine'
            audience = 'credits'
            position = 1
            logic = 'campaigns'
            bu = 'mp'
            bu_line = 'banking'
            flow = '1'
            action_id = 'banking'
            link = '/banking'
        }
    }
}
