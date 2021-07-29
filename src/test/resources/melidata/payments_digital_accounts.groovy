package src.test.resources.melidata

import com.ml.melidata.catalog.PropertyType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadopago"

    /******************************************
    *  Payments - Digital Accounts - Banking  *
    ******************************************/

    test("Balance available") {
        "/banking/balance"(platform: "/", type: TrackType.View) {}
    }

    test("Track Components views") {
        "/banking/balance"(platform: "/", type: TrackType.View) {
            my_money_balance_available = [
                component_id: 'balance_available',
                content_id: ['available']
            ]
        }

        "/banking/balance/available"(platform: "/", type: TrackType.View) {
            my_money_available = [
                component_id: 'available',
            ]
        }

        "/banking/balance/card_available"(platform: "/", type: TrackType.View) {
            my_money_card_available = [
                component_id: 'card_available',
            ]
        }

        "/banking/balance/shortcuts"(platform: "/", type: TrackType.View) {
            my_money_shortcuts = [
                component_id: 'shortcuts',
                content_id: ['account_fund', 'withdraw']
            ]
        }

        "/banking/balance/cross_selling_carousel"(platform: "/", type: TrackType.View) {
            my_money_cross_selling_carousel = [
                component_id: 'cross_selling_carousel',
                content_id: ['portability']
           ]
        }

        "/banking/balance/retained"(platform: "/", type: TrackType.View) {
            my_money_retained = [
                component_id: 'retained',
                content_id: ['reserve_for_dispute']
            ]
        }

        "/banking/balance/to_release"(platform: "/", type: TrackType.View) {
            my_money_to_release = [
                component_id: 'to_release',
                content_id: []
            ]
        }

        "/banking/balance/card_to_release"(platform: "/", type: TrackType.View) {
            my_money_card_to_release = [
                component_id: 'card_to_release',
                content_id: []
            ]
        }

        "/banking/balance/to_advance"(platform: "/", type: TrackType.View) {
             my_money_to_advance = [
                component_id: 'to_advance',
                content_id: []
            ]
        }

        "/banking/balance/card_calendar"(platform: "/", type: TrackType.View) {
             my_money_card_calendar = [
                component_id: 'card_calendar',
                content_id: []
            ]
        }

        "/banking/balance/calendar_daily"(platform: "/", type: TrackType.View) {
            my_money_calendar_daily = [
                component_id: 'calendar_daily',
                content_id: []
            ]
        }

        "/banking/balance/last_activities"(platform: "/", type: TrackType.View) {
            my_money_activities = [
                component_id: 'activities',
                component_data: [
                    elements: 5
                ]
            ]
        }

        "/banking/balance/last_activities"(platform: "/", type: TrackType.View) {
            my_money_activities = [
                component_id: 'activities',
                component_data: [
                    elements: 5,
                    status: 'disabled'
                ]
            ]
        }
    }

    test("Balance to release") {
         "/banking/to_release"(platform: "/", type: TrackType.View) {}
    }

    test("Balance to release") {
             "/banking/open_banking"(platform: "/", type: TrackType.View) {}
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

    test("Balance Cerc Optin") {
        "/banking/cerc/optin"(platform: "/", type: TrackType.View) {}
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
        "/banking/balance/cerc"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/balance/cerc/optin"(platform: "/", type: TrackType.Event) {
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

    test("Vouchers") {
        "/banking/vouchers"(platform: "/", type: TrackType.View) {}

        "/banking/vouchers/benefits/categories"(platform: "/", type: TrackType.Event) {}

        "/banking/vouchers/account-money/switch"(platform: "/", type: TrackType.Event) {}

        "/banking/vouchers/activities/row"(platform: "/", type: TrackType.Event) {}
        "/banking/vouchers/activities/footer"(platform: "/", type: TrackType.Event) {}

        "/banking/vouchers/card"(platform: "/", type: TrackType.Event) {}

        "/banking/vouchers/help"(platform: "/", type: TrackType.Event) {}
    }
}
