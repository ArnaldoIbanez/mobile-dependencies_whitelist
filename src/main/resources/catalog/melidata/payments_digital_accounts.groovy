package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1238"

    /******************************************
    *  Payments - Digital Accounts - Banking  *
    ******************************************/

    //inner properties definitions
    def element_definition = objectSchemaDefinitions {
        elements(required: false, type: PropertyType.Numeric, description: "items quantity")
        status(required: false, type: PropertyType.String, description: "component status")
        empty(required: false, type: PropertyType.Boolean, description: "quantity status")
        last_update(required: false, type: PropertyType.String, description: "timestamp")
    }

    def component_definition = objectSchemaDefinitions {
        component_id(required: true, type: PropertyType.String, description: "parent component id")
        component_data(required: false, type: PropertyType.Map(element_definition), description: "child component relevant content data")
        content_id(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "children component ids")
    }

    //Definitions
    propertyDefinitions {
        // Global variables
        action_id(required: true, type: PropertyType.String, description: "The action executed")
        cerc_action_id(required: true, type: PropertyType.String, values: ["button_click"], description: "The action executed")

        // Credits Merch engine
        component_id(required: true, type: PropertyType.String, description: "Identifier for the component")
        content_id(required: true, type: PropertyType.String, description: "Identifier for the unique content shown")
        audience(required: true, type: PropertyType.String, description: "The audience for which this content was prepared")
        position(required: true, type: PropertyType.Numeric, description: "Position starting at 1 where it was shown")
        logic(required: true, type: PropertyType.String, description: "Origin of the content")
        bu(required: true, type: PropertyType.String, description: "The business unit")
        bu_line(required: true, type: PropertyType.String, description: "The business unit related to the content")
        flow(required: true, type: PropertyType.String, description: "The flow related to the content")

        // Movements
        action_type(required: true, type: PropertyType.String, description: "Movement type indicator")
        period_type(required: true, type: PropertyType.String, values: ["default", "range"], description: "Period type indicator")
        period_option(required: false, type: PropertyType.String, description: "In case of default period type, option selected")
        begin_date(required: true, type: PropertyType.String, description: "Start date of the selected period")
        end_date(required: true, type: PropertyType.String, description: "End date of the selected period")

        //Banking
        available(required: true, type: PropertyType.Boolean, description: "Indicates if the user has money available")
        account(required: true, type: PropertyType.Boolean, description: "Indicates if the user has money in MP account")
        invested(required: true, type: PropertyType.Boolean, description: "Indicates if user has money invested")
        to_release(required: true, type: PropertyType.Boolean, description: "Indicates if user has money to release")
        embargo_invested(required: true, type: PropertyType.Boolean, description: "Indicates if user has money retained by embargo")
        retained(required: true, type: PropertyType.Boolean, description: "Indicates if user has money retained")
        shortcuts(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Indicates the shortcuts available for the user")
        debts(required: true, type: PropertyType.Boolean, description: "Indicates if user has debt card")
        cerc(required: true, type: PropertyType.Boolean, description: "Indicates if user has cerc capability")
        activities(required: true, type: PropertyType.Boolean, description: "Indicates if user has money activities")

        // Components
        my_money_available(required: true, type: PropertyType.Map(component_definition), description: "Available component print")
        my_money_card_available(required: true, type: PropertyType.Map(component_definition), description: "Card Available component print")
        my_money_to_release(required: true, type: PropertyType.Map(component_definition), description: "ToRelease component print")
        my_money_card_to_release(required: true, type: PropertyType.Map(component_definition), description: "Card ToRelease component print")
        my_money_shortcuts(required: true, type: PropertyType.Map(component_definition), description: "Shorts Component print")
        my_money_cross_selling_carousel(required: true, type: PropertyType.Map(component_definition), description: "Cross Selling carousel print")
        my_money_retained(required: true, type: PropertyType.Map(component_definition), description: "Retained component print")
        my_money_to_advance(required: true, type: PropertyType.Map(component_definition), description: "ToAdvance component print")
        my_money_last_activities(required: true, type: PropertyType.Map(component_definition), description: "Last Activities component print")
        my_money_card_calendar(required: true, type: PropertyType.Map(component_definition), description: "CardCalendar component print")
        my_money_calendar_daily(required: true, type: PropertyType.Map(component_definition), description: "Calendar Daily component ptint")
        my_money_cerc(required: true, type: PropertyType.Map(component_definition), description: "Card CERC component print")
        my_money_open_banking(required: true, type: PropertyType.Map(component_definition), description: "Open Banking component print")
        my_money_debt_balance(required: true, type: PropertyType.Map(component_definition), description: "Debt balance component print")
        my_money_contingency_message(required: true, type: PropertyType.Map(component_definition), description: "Contingency message component print")
        my_money_bank_detail(required: true, type: PropertyType.Map(component_definition), description: "Bank detail component print")
        my_money_account_list(required: true, type: PropertyType.Map(component_definition), description: "Bank account list component print")
        my_money_cards_list(require: true, type: PropertyType.Map(component_definition), description: "Bank cards list component print")
        my_money_timestampPrint(required: true, type: PropertyType.Map(component_definition), description: "Bank resource timestamp component print")
    }

    propertyGroups {
        eventDataTrack (
                component_id, content_id, audience, position, logic, bu, bu_line, flow
        )
        movementsFiltersAction (
                action_type
        )
        movementsFiltersPeriod (
                period_type, period_option, begin_date, end_date
        )
        movementsReportsCreate (
                action_type, begin_date, end_date
        )
        balanceEventClick (
                action_id
        )
        bankingTrack (
                available, account, debts, retained, embargo_invested, invested, to_release, shortcuts, activities, cerc
        )
        cercEventClick (
                action_type
        )
        cercOptinEventClick (
                cerc_action_id
        )
        availablePrint (
                my_money_available
        )
        cardAvailablePrint (
                my_money_card_available
        )
        toReleasePrint (
                my_money_to_release
        )
        cardToReleasePrint (
                my_money_card_to_release
        )
        shortcutsPrint (
                my_money_shortcuts
        )
        crossSellingCarouselPrint (
                my_money_cross_selling_carousel
        )
        retainedPrint (
                my_money_retained
        )
        toAdvancePrint (
                my_money_to_advance
        )
        lastActivitiesPrint (
                my_money_last_activities
        )
        cardCalendarPrint (
                my_money_card_calendar
        )
        calendarDailyPrint (
                my_money_calendar_daily
        )
        cercPrint (
                my_money_cerc
        )
        openBankingPrint (
                my_money_open_banking
        )
        debtBalancePrint (
                my_money_debt_balance
        )
        contingencyMessagePrint (
                my_money_contingency_message
        )
        accountListPrint (
                my_money_account_list
        )
        cardsListPrint (
                my_money_cards_list
        )
        timestampPrint (
                my_money_timestamp
        )
        bankDetailPrint (
                my_money_bank_detail
        )
    }

    // MP Banking
    "/banking"(platform: "/", isAbstract: true) {}

    // Components Balance
    "/banking/balance/print"(platform: "/", type: TrackType.View) { availablePrint }
    "/banking/balance/available_component"(platform: "/", type: TrackType.View) { availablePrint }
    "/banking/balance/card_available_component"(platform: "/", type: TrackType.View) { cardAvailablePrint }
    "/banking/balance/shortcuts_component"(platform: "/", type: TrackType.View) { shortcutsPrint }
    "/banking/balance/cross_selling_carousel_component"(platform: "/", type: TrackType.View) { crossSellingCarouselPrint }
    "/banking/balance/retained_component"(platform: "/", type: TrackType.View) { retainedPrint }
    "/banking/balance/card_to_release_component"(platform: "/", type: TrackType.View) { cardToReleasePrint }
    "/banking/balance/last_activities_component"(platform: "/", type: TrackType.View) { lastActivitiesPrint }
    "/banking/balance/open_banking_component"(platform: "/", type: TrackType.View) { openBankingPrint }
    "/banking/balance/debt_balance_component"(platform: "/", type: TrackType.View) { debtBalancePrint }
    "/banking/balance/contingency_message_component"(platform: "/", type: TrackType.View) { contingencyMessagePrint }

    // Components ToRelease
    "/banking/to_release/print"(platform: "/", type: TrackType.View) { toReleasePrint }
    "/banking/to_release/to_release_component"(platform: "/", type: TrackType.View) { toReleasePrint }
    "/banking/to_release/card_to_release_component"(platform: "/", type: TrackType.View) { cardToReleasePrint }
    "/banking/to_release/to_advance_component"(platform: "/", type: TrackType.View) { toAdvancePrint }
    "/banking/to_release/card_calendar_component"(platform: "/", type: TrackType.View) { cardCalendarPrint }
    "/banking/to_release/calendar_daily_component"(platform: "/", type: TrackType.View) { calendarDailyPrint }
    "/banking/to_release/cerc_component"(platform: "/", type: TrackType.View) { cercPrint }

    // Components Open Finance
    "/banking/balance/accounts_list_component"(platform: "/", type: TrackType.View) { accountListPrint }
    "/banking/balance/cads_list_component"(platform: "/", type: TrackType.View) { cardsListPrint }
    "/banking/balance/timestamp_component"(platform: "/", type: TrackType.View) { timestampPrint }
    "/banking/balance/bank_detail_component"(platform: "/", type: TrackType.View) { bankDetailPrint }

    // Balance Views
    "/banking/balance"(platform: "/", type: TrackType.View) {}
    "/banking/to_release"(platform: "/", type: TrackType.View) {}
    "/banking/calendar"(platform: "/", type: TrackType.View) {}
    "/banking/activities"(platform: "/", type: TrackType.View) {}
    "/banking/cerc"(platform: "/", type: TrackType.View) {}
    "/banking/cerc/optin"(platform: "/", type: TrackType.View) {}
    "/banking/debts"(platform: "/", type: TrackType.View) {}
    "/banking/debts/detail"(platform: "/", type: TrackType.View) {}
    "/banking/open_banking"(platform: "/", type: TrackType.View) {}

    // Balance Events
    "/banking/balance/action"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/balance/footer_action"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/balance/row"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/balance/error"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/balance/cerc"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/balance/cerc/optin"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/balance/open_banking"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/balance/sections"(platform: "/", type: TrackType.Event) { bankingTrack }

    // ToRelease Events
    "/banking/to_release/calendar"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/to_release/row"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/to_release/footer_action"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/to_release/calendar_anual"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/to_release/action"(platform: "/", type: TrackType.Event) { balanceEventClick }

    // Other Events
    "/banking/debts/action"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/calendar/action"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/calendar/calendar_anual"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/activities/row"(platform: "/", type: TrackType.Event) { balanceEventClick }

    // PNF
    "/banking/pnf"(platform: "/", type: TrackType.View) {}
    "/banking/pnf/confirm"(platform: "/", type: TrackType.Event) {}
    "/banking/pnf/congrats"(platform: "/", type: TrackType.Event) {
        status( required: true, type: PropertyType.String , description: "Pnf congrats whether the screen was successful or not" )
    }
    "/banking/pnf/back"(platform: "/", type: TrackType.Event) {
        action( require: true, type: PropertyType.String, description: "Identifies back action component")
    }
    "/banking/pnf/inprogress"(platform: "/", type: TrackType.View) {}
    "/banking/pnf/error"(platform: "/", type: TrackType.View) {
        page( require: true, type: PropertyType.String, description: "Identifies from which screen ends in error view")
    }

    // Movements
    "/banking/movements"(platform: "/", type: TrackType.View) {}

    // Movements - List
    "/banking/movements/list"(platform: "/", isAbstract: true) {}
    "/banking/movements/list/detail"(platform: "/", type: TrackType.Event) {}

    // Movements - Pagination
    "/banking/movements/pagination"(platform: "/", isAbstract: true) {}
    "/banking/movements/pagination/change"(platform: "/", type: TrackType.Event) {}

    // Movements - Filters
    "/banking/movements/filters"(platform: "/", isAbstract: true) {}
    "/banking/movements/filters/action"(platform: "/", type: TrackType.Event) { movementsFiltersAction }
    "/banking/movements/filters/period"(platform: "/", type: TrackType.Event) { movementsFiltersPeriod }
    "/banking/movements/filters/open_datepicker"(platform: "/", type: TrackType.Event) {}

    // Movements - Reports
    "/banking/movements/reports"(platform: "/", isAbstract: true) {}
    "/banking/movements/reports/create"(platform: "/", type: TrackType.Event) { movementsReportsCreate }
    "/banking/movements/reports/view"(platform: "/", type: TrackType.Event) {}

    // MP Balance - Merch Engine Events Credits
    "/banking/balance/credits"(platform: "/", isAbstract: true) {}
    "/banking/balance/credits/print"(platform: "/", type: TrackType.Event) { eventDataTrack }
    "/banking/balance/credits/tap"(platform: "/", type: TrackType.Event) { eventDataTrack }

    // Vouchers
    "/banking/vouchers"(platform: "/", type: TrackType.View) {}

    // Vouchers - Benefits
    "/banking/vouchers/benefits"(platform: "/", isAbstract: true) {}
    "/banking/vouchers/benefits/categories"(platform: "/", type: TrackType.Event) {}

    // Vouchers - Account switch
    "/banking/vouchers/account-money"(platform: "/", isAbstract: true) {}
    "/banking/vouchers/account-money/switch"(platform: "/", type: TrackType.Event) {}

    // Vouchers - Activities
    "/banking/vouchers/activities"(platform: "/", isAbstract: true) {}
    "/banking/vouchers/activities/row"(platform: "/", type: TrackType.Event) {}
    "/banking/vouchers/activities/footer"(platform: "/", type: TrackType.Event) {}

    // Vouchers - MP Card
    "/banking/vouchers/card"(platform: "/", type: TrackType.Event) {}

    // Vouchers - Help
    "/banking/vouchers/help"(platform: "/", type: TrackType.Event) {}

    // Regulations Cerc Views
    "/regulations/cerc"(platform: "/", type: TrackType.View) {}
    "/regulations/cerc/contracts"(platform: "/", type: TrackType.View) {}
    "/regulations/cerc/reply"(platform: "/", type: TrackType.View) {}
    "/regulations/cerc/reply/congrats"(platform: "/", type: TrackType.View) {}
    "/regulations/cerc/optin"(platform: "/", type: TrackType.View) {}
    "/regulations/cerc/optin_form"(platform: "/", type: TrackType.View) {}
    "/regulations/cerc/optin_form/select"(platform: "/", type: TrackType.View) {}
    "/regulations/cerc/optin_form/confirm"(platform: "/", type: TrackType.View) {}
    "/regulations/cerc/optin_form/congrats"(platform: "/", type: TrackType.View) {}

    // Regulations Cerc Events
    "/regulations/cerc/contracts/reply"(platform: "/", type: TrackType.Event) { cercEventClick }
    "/regulations/cerc/contracts/help"(platform: "/", type: TrackType.Event) { cercEventClick }
    "/regulations/cerc/reply/reason"(platform: "/", type: TrackType.Event) { cercEventClick }
    "/regulations/cerc/reply/confirm"(platform: "/", type: TrackType.Event) { cercEventClick }
    "/regulations/cerc/reply/cancel"(platform: "/", type: TrackType.Event) { cercEventClick }
    "/regulations/cerc/congrats/return"(platform: "/", type: TrackType.Event) { cercEventClick }

    "/regulations/cerc/optin/faqs"(platform: "/", type: TrackType.Event) { cercOptinEventClick }
    "/regulations/cerc/optin/help"(platform: "/", type: TrackType.Event) { cercOptinEventClick }
    "/regulations/cerc/optin/go_optin_form"(platform: "/", type: TrackType.Event) { cercOptinEventClick }
    "/regulations/cerc/optin/optout_confirm"(platform: "/", type: TrackType.Event) { cercOptinEventClick }
    "/regulations/cerc/optin/optout_cancel"(platform: "/", type: TrackType.Event) { cercOptinEventClick }
    "/regulations/cerc/optin/optout"(platform: "/", type: TrackType.Event) { cercOptinEventClick }
    "/regulations/cerc/optin_form/select/form_submit"(platform: "/", type: TrackType.Event) { cercOptinEventClick }
    "/regulations/cerc/optin_form/confirm/form_edit"(platform: "/", type: TrackType.Event) { cercOptinEventClick }
    "/regulations/cerc/optin_form/confirm/form_confirm"(platform: "/", type: TrackType.Event) { cercOptinEventClick }
    "/regulations/cerc/optin_form/confirm/form_error_close"(platform: "/", type: TrackType.Event) { cercOptinEventClick }
    "/regulations/cerc/optin_form/congrats/form_close"(platform: "/", type: TrackType.Event) { cercOptinEventClick }
    "/regulations/cerc/optin_form/congrats/help"(platform: "/", type: TrackType.Event) { cercOptinEventClick }
}
