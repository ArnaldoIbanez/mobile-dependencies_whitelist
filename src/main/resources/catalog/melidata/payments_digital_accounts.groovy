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
    }

    def component_definition = objectSchemaDefinitions {
        component_id(required: true, type: PropertyType.String, description: "parent component id")
        component_data(required: false, type: PropertyType.Map(element_definition), description: "child component relevant content data")
        content_id(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "children component ids")
    }

    //Definitions
    propertyDefinitions {
        // Global variables
        action_id(required: true, type: PropertyType.String, description: "The action executed")

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

        // Components
        my_money_available(required: false, type: PropertyType.Map(component_definition))
        my_money_card_available(required: false, type: PropertyType.Map(component_definition))
        my_money_to_release(required: false, type: PropertyType.Map(component_definition))
        my_money_card_to_release(required: false, type: PropertyType.Map(component_definition))
        my_money_shortcuts(required: false, type: PropertyType.Map(component_definition))
        my_money_cross_selling_carousel(required: false, type: PropertyType.Map(component_definition))
        my_money_retained(required: false, type: PropertyType.Map(component_definition))
        my_money_to_advance(required: false, type: PropertyType.Map(component_definition))
        my_money_last_activities(required: false, type: PropertyType.Map(component_definition))
        my_money_card_calendar(required: false, type: PropertyType.Map(component_definition))
        my_money_calendar_daily(required: false, type: PropertyType.Map(component_definition))
        my_money_cerc(required: false, type: PropertyType.Map(component_definition))
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
        cercEventClick (
                action_type
        )
        componentsPrints (
                my_money_available,
                my_money_card_available,
                my_money_to_release,
                my_money_card_to_release,
                my_money_shortcuts,
                my_money_cross_selling_carousel,
                my_money_retained,
                my_money_to_advance,
                my_money_last_activities,
                my_money_card_calendar,
                my_money_calendar_daily,
                my_money_cerc,
        )
    }

    // MP Banking
    "/banking"(platform: "/", isAbstract: true) {}

    // Components Balance
    "/banking/balance/print"(platform: "/", type: TrackType.View) { componentsPrints }
    "/banking/balance/available_component"(platform: "/", type: TrackType.View) { componentsPrints }
    "/banking/balance/card_available_component"(platform: "/", type: TrackType.View) { componentsPrints }
    "/banking/balance/shortcuts_component"(platform: "/", type: TrackType.View) { componentsPrints }
    "/banking/balance/cross_selling_carousel_component"(platform: "/", type: TrackType.View) { componentsPrints }
    "/banking/balance/retained_component"(platform: "/", type: TrackType.View) { componentsPrints }
    "/banking/balance/card_to_release_component"(platform: "/", type: TrackType.View) { componentsPrints }
    "/banking/balance/last_activities_component"(platform: "/", type: TrackType.View) { componentsPrints }

    // Components ToRelease
    "/banking/to_release/print"(platform: "/", type: TrackType.View) { componentsPrints }
    "/banking/to_release/to_release_component"(platform: "/", type: TrackType.View) { componentsPrints }
    "/banking/to_release/card_to_release_component"(platform: "/", type: TrackType.View) { componentsPrints }
    "/banking/to_release/to_advance_component"(platform: "/", type: TrackType.View) { componentsPrints }
    "/banking/to_release/card_calendar_component"(platform: "/", type: TrackType.View) { componentsPrints }
    "/banking/to_release/calendar_daily_component"(platform: "/", type: TrackType.View) { componentsPrints }
    "/banking/to_release/cerc_component"(platform: "/", type: TrackType.View) { componentsPrints }

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
    "/banking/to_release/action"(platform: "/", type: TrackType.Event) { balanceEventClick }

    // ToRelease Events
    "/banking/to_release/calendar"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/to_release/row"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/to_release/footer_action"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/to_release/calendar_anual"(platform: "/", type: TrackType.Event) { balanceEventClick }

    // Other Events
    "/banking/debts"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/calendar/calendar_anual"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/activity/row"(platform: "/", type: TrackType.Event) { balanceEventClick }

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

    // Regulations Cerc Events
    "/regulations/cerc/contracts/reply"(platform: "/", type: TrackType.Event) { cercEventClick }
    "/regulations/cerc/contracts/help"(platform: "/", type: TrackType.Event) { cercEventClick }
    "/regulations/cerc/reply/reason"(platform: "/", type: TrackType.Event) { cercEventClick }
    "/regulations/cerc/reply/confirm"(platform: "/", type: TrackType.Event) { cercEventClick }
    "/regulations/cerc/reply/cancel"(platform: "/", type: TrackType.Event) { cercEventClick }
    "/regulations/cerc/congrats/return"(platform: "/", type: TrackType.Event) { cercEventClick }
    "/regulations/cerc/optin/faqs"(platform: "/", type: TrackType.Event) { cercEventClick }
    "/regulations/cerc/optin/help"(platform: "/", type: TrackType.Event) { cercEventClick }
}
