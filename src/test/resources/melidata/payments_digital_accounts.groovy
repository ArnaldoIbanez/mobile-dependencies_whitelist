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
        "/banking/balance"(platform: "/", type: TrackType.View) {
            available = true
            account = false
            invested = false
            to_release = false
            embargo_invested = false
            retained = false
            shortcuts = ['money_in', 'money_out']
            debts = true
            cerc = true
            activities = false
        }
    }

    test("Track Components Events") {
        "/banking/balance/print"(platform: "/", type: TrackType.View) {
            my_money_available = [
                component_id: 'available',
                content_id: ['available']
            ]
        }

        "/banking/to_release/print"(platform: "/", type: TrackType.View) {
            my_money_to_release = [
                 component_id: 'to_release',
                 content_id: ['to_release_component']
            ]
        }

        "/banking/balance/available_component"(platform: "/", type: TrackType.View) {
            my_money_available = [
                component_id: 'available',
                content_id: ['to_release_component']
            ]
        }

        "/banking/balance/card_available_component"(platform: "/", type: TrackType.View) {
            my_money_card_available = [
                component_id: 'card_available',
                content_id: ['to_release_component']
            ]
        }

        "/banking/balance/shortcuts_component"(platform: "/", type: TrackType.View) {
            my_money_shortcuts = [
                component_id: 'shortcuts',
                content_id: ['account_fund_component', 'withdraw_component']
            ]
        }

        "/banking/balance/cross_selling_carousel_component"(platform: "/", type: TrackType.View) {
            my_money_cross_selling_carousel = [
                component_id: 'cross_selling_carousel',
                content_id: ['portability_component']
           ]
        }

        "/banking/balance/retained_component"(platform: "/", type: TrackType.View) {
            my_money_retained = [
                component_id: 'retained',
                content_id: ['reserve_for_dispute_component']
            ]
        }

        "/banking/balance/card_to_release_component"(platform: "/", type: TrackType.View) {
            my_money_card_to_release = [
                 component_id: 'card_to_release',
                 content_id: []
            ]
        }

        "/banking/to_release/to_release_component"(platform: "/", type: TrackType.View) {
            my_money_to_release = [
                component_id: 'to_release',
                content_id: []
            ]
        }

        "/banking/to_release/card_to_release_component"(platform: "/", type: TrackType.View) {
            my_money_card_to_release = [
                component_id: 'card_to_release',
                content_id: []
            ]
        }

        "/banking/to_release/to_advance_component"(platform: "/", type: TrackType.View) {
             my_money_to_advance = [
                component_id: 'to_advance',
                content_id: []
            ]
        }

        "/banking/to_release/card_calendar_component"(platform: "/", type: TrackType.View) {
             my_money_card_calendar = [
                component_id: 'card_calendar',
                content_id: []
            ]
        }

        "/banking/to_release/calendar_daily_component"(platform: "/", type: TrackType.View) {
            my_money_calendar_daily = [
                component_id: 'calendar_daily',
                content_id: []
            ]
        }

        "/banking/to_release/cerc_component"(platform: "/", type: TrackType.View) {
             my_money_cerc = [
                 component_id: 'cerc',
                 content_id: []
             ]
        }

        "/banking/balance/last_activities_component"(platform: "/", type: TrackType.View) {
            my_money_last_activities = [
                component_id: 'last_activities',
                content_id: [],
                component_data: [
                    elements: 5
                ]
            ]
        }

        "/banking/balance/last_activities_component"(platform: "/", type: TrackType.View) {
            my_money_last_activities = [
                component_id: 'last_activities',
                content_id: [],
                component_data: [
                    elements: 5,
                    status: 'disabled'
                ]
            ]
        }

       "/banking/balance/open_banking_component"(platform: "/", type: TrackType.View) {
            my_money_open_banking = [
                component_id: 'open_banking',
                component_data: [
                     elements: 5
                ],
                content_id: [
                        'Mercado Pago',
                        'Cadastrar conta'
                ]
             ]
        }

        "/banking/balance/debt_balance_component"(platform: "/", type: TrackType.View) {
             my_money_debt_balance = [
                  component_id: 'debt_balance',
                  component_data: [
                      status: 'printed'
                 ]
             ]
         }
    }

    test("Balance to release") {
         "/banking/to_release"(platform: "/", type: TrackType.View) {}
    }

    test("Balance openbanking") {
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
        "/banking/to_release/action"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/to_release/footer_action"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/balance/footer_action"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/balance/row"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/to_release/row"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/to_release/calendar_anual"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/calendar/calendar_anual"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/to_release/calendar"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/balance/error"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/activities/row"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/debts/action"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/calendar/action"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/balance/cerc"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/balance/cerc/optin"(platform: "/", type: TrackType.Event) {
            action_id = 'test'
        }
        "/banking/balance/open_banking"(platform: "/", type: TrackType.Event) {
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

    test("Regulations Cerc") {
        "/regulations/cerc"(platform: "/", type: TrackType.View) {}

        "/regulations/cerc/contracts"(platform: "/", type: TrackType.View) {}

        "/regulations/cerc/reply"(platform: "/", type: TrackType.View) {}

        "/regulations/cerc/reply/congrats"(platform: "/", type: TrackType.View) {}

        "/regulations/cerc/optin"(platform: "/", type: TrackType.View) {}

        "/regulations/cerc/optin_form"(platform: "/", type: TrackType.View) {}

        "/regulations/cerc/optin_form/select"(platform: "/", type: TrackType.View) {}

        "/regulations/cerc/optin_form/confirm"(platform: "/", type: TrackType.View) {}

        "/regulations/cerc/optin_form/congrats"(platform: "/", type: TrackType.View) {}

        "/regulations/cerc/optin/faqs"(platform: "/", type: TrackType.Event) {
            cerc_action_id = 'button_click'
        }

        "/regulations/cerc/optin/help"(platform: "/", type: TrackType.Event) {
            cerc_action_id = 'button_click'
        }

        "/regulations/cerc/optin/button_faqs"(platform: "/", type: TrackType.Event) {
            cerc_action_id = 'button_click'
        }

        "/regulations/cerc/optin/go_optin_form"(platform: "/", type: TrackType.Event) {
            cerc_action_id = 'button_click'
        }

        "/regulations/cerc/optin/opt-out_confirm"(platform: "/", type: TrackType.Event) {
            cerc_action_id = 'button_click'
        }

        "/regulations/cerc/optin/opt-out_cancel"(platform: "/", type: TrackType.Event) {
            cerc_action_id = 'button_click'
        }

        "/regulations/cerc/optin/opt-out"(platform: "/", type: TrackType.Event) {
            cerc_action_id = 'button_click'
        }

        "/regulations/cerc/optin_form/select/form_submit"(platform: "/", type: TrackType.Event) {
            cerc_action_id = 'button_click'
        }

        "/regulations/cerc/optin_form/confirm/form_edit"(platform: "/", type: TrackType.Event) {
            cerc_action_id = 'button_click'
        }

        "/regulations/cerc/optin_form/confirm/form_confirm"(platform: "/", type: TrackType.Event) {
            cerc_action_id = 'button_click'
        }
        
        "/regulations/cerc/optin_form/confirm/form_error_close"(platform: "/", type: TrackType.Event) {
            cerc_action_id = 'button_click'
        }
        
        "/regulations/cerc/optin_form/congrats/help"(platform: "/", type: TrackType.Event) {
            cerc_action_id = 'button_click'
        }

        "/regulations/cerc/contracts/reply"(platform: "/", type: TrackType.Event) {
            action_type = 'test'
        }

        "/regulations/cerc/contracts/help"(platform: "/", type: TrackType.Event) {
            action_type = 'test'
        }

        "/regulations/cerc/reply/reason"(platform: "/", type: TrackType.Event) {
            action_type = 'test'
        }

        "/regulations/cerc/reply/confirm"(platform: "/", type: TrackType.Event) {
            action_type = 'test'
        }

        "/regulations/cerc/reply/cancel"(platform: "/", type: TrackType.Event) {
            action_type = 'test'
        }

        "/regulations/cerc/congrats/return"(platform: "/", type: TrackType.Event) {
            action_type = 'test'
        }
    }
}
