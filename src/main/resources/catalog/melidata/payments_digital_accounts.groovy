package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1238"

    /******************************************
    *  Payments - Digital Accounts - Banking  *
    ******************************************/

    //Definitions
    propertyDefinitions {
        section_id(required: true, type: PropertyType.String, description: "Identifier for the realestate to consume")
        component_id(required: true, type: PropertyType.String, description: "Identifier for the component")
        content_id(required: true, type: PropertyType.String, description: "Identifier for the unique content shown")
        audience(required: true, type: PropertyType.String, description: "The audience for which this content was prepared")
        position(required: true, type: PropertyType.Numeric, description: "Position starting at 1 where it was shown")
        logic(required: true, type: PropertyType.String, description: "Origin of the content")
        bu(required: true, type: PropertyType.String, description: "The business unit")
        bu_line(required: true, type: PropertyType.String, description: "The business unit related to the content")
        flow(required: true, type: PropertyType.String, description: "The flow related to the content")
        action_id(required: true, type: PropertyType.String, description: "The action executed")
        link(required: true, type: PropertyType.String, description: "Link to execute")

        // Movements
        action_type(required: true, type: PropertyType.String, description: "Movement type indicator")
        period_type(required: true, type: PropertyType.String, values: ["default", "range"], description: "Period type indicator")
        period_option(required: false, type: PropertyType.String, description: "In case of default period type, option selected")
        begin_date(required: true, type: PropertyType.String, description: "Start date of the selected period")
        end_date(required: true, type: PropertyType.String, description: "End date of the selected period")
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
    }

    // MP Banking
    "/banking"(platform: "/", isAbstract: true) {}

    // Balance Views
    "/banking/balance"(platform: "/", type: TrackType.View) {}
    "/banking/calendar"(platform: "/", type: TrackType.View) {}
    "/banking/activities"(platform: "/", type: TrackType.View) {}
    "/banking/cerc"(platform: "/", type: TrackType.View) {}
    "/banking/debts"(platform: "/", type: TrackType.View) {}

    // Balance Events
    "/banking/balance/action"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/balance/footer_action"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/balance/row"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/balance/calendar_anual"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/balance/calendar"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/balance/error"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/balance/activity_row"(platform: "/", type: TrackType.Event) { balanceEventClick }
    "/banking/balance/debts"(platform: "/", type: TrackType.Event) { balanceEventClick }

    // PNF
    "/banking/pnf"(platform: "/", type: TrackType.View) {}

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
}
