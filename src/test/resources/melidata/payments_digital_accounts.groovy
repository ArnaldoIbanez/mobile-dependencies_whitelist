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

    test("Balance Debts") {
        "/banking/debts"(platform: "/", type: TrackType.View) {}
    }

    test("Balance Debts Detail") {
        "/banking/debts/detail"(platform: "/", type: TrackType.View) {}
    }

    test("Balance Events") {
        "/banking/balance/action"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/balance/footer_action"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/balance/row"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/balance/calendar_anual"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/balance/calendar"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/balance/error"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/balance/activity_row"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/balance/debts"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
    }

    test("Movements") {
        "/banking/movements"(platform: "/", type: TrackType.View) {}

        "/banking/movements/list/detail"(platform: "/", type: TrackType.Event) {}
        "/banking/movements/pagination/change"(platform: "/", type: TrackType.Event) {}

        "/banking/movements/filters/action"(platform: "/", type: TrackType.Event) {
            action_type = 'income'
        }
        "/banking/movements/filters/period"(platform: "/", type: TrackType.Event) {
            period_type = 'default'
            period_option = '30'
            begin_date = '2020-12-22T00:00:00.000Z'
            end_date = '2021-01-06T23:59:59.999Z'
        }
        "/banking/movements/filters/period"(platform: "/", type: TrackType.Event) {
            period_type = 'range'
            begin_date = '2020-12-22T00:00:00.000Z'
            end_date = '2021-01-06T23:59:59.999Z'
        }
        "/banking/movements/filters/open_datepicker"(platform: "/", type: TrackType.Event) {}

        "/banking/movements/reports/view"(platform: "/", type: TrackType.Event) {}
        "/banking/movements/reports/create"(platform: "/", type: TrackType.Event) {
            action_type = 'income'
            begin_date = '2020-12-22T00:00:00.000Z'
            end_date = '2021-01-06T23:59:59.999Z'
        }
        "/banking/movements/reports/create"(platform: "/", type: TrackType.Event) {
            action_type = ''
            begin_date = '2020-12-22T00:00:00.000Z'
            end_date = '2021-01-06T23:59:59.999Z'
        }
    }

    test("PNF") {
        "/banking/pnf"(platform: "/", type: TrackType.View) {}
    }

    test("PNF confirm") {
        "/banking/pnf/confirm"(platform: "/", type: TrackType.Event) {}
    }

    test("PNF confirm back") {
        "/banking/pnf/back"(platform: "/", type: TrackType.Event) {
            action = 'PAGE_BACK'
        }
    }

    test("PNF progress") {
        "/banking/pnf/inprogress"(platform: "/", type: TrackType.View) {}
    }

    test("PNF error") {
        "/banking/pnf/error"(platform: "/", type: TrackType.View) {
            page = 'myPage'
        }
    }

    test("PNF congrats FAIL") {
        "/banking/pnf/congrats"(platform: "/", type: TrackType.Event) {
            status = 'error'
        }
    }

    test("PNF congrats SUCCESS") {
        "/banking/pnf/congrats"(platform: "/", type: TrackType.Event) {
            status = 'success'
        }
    }

    test("Banking Balance Merch Engine Events") {
        "/banking/balance/credits/print" (platform: "/", type: TrackType.Event) {
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
            component_id = 'component_12'
            content_id = 'banking_merch_engine'
            audience = 'credits'
            position = 1
            logic = 'campaigns'
            bu = 'mp'
            bu_line = 'banking'
            flow = '1'
        }
    }
}
