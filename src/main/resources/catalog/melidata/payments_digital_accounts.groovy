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
    }

    propertyGroups {
        eventDataTrack (
                section_id, component_id, content_id, audience, position, logic, bu, bu_line, flow
        )
        actionEventDataTrack (
                section_id, component_id, content_id, audience, position, logic, bu, bu_line, flow, action_id, link
        )
    }

    // MP Banking
    "/banking"(platform: "/", isAbstract: true) {}

    // Balance
    "/banking/balance"(platform: "/", type: TrackType.View) {}
    "/banking/calendar"(platform: "/", type: TrackType.View) {}
    "/banking/activities"(platform: "/", type: TrackType.View) {}
    "/banking/cerc"(platform: "/", type: TrackType.View) {}

    // PNF
    "/banking/pnf"(platform: "/", type: TrackType.View) {}

    // Movements
    "/banking/movements"(platform: "/", type: TrackType.View) {}

    // MP Balance - Merch Engine Events Credits

    "/banking/balance/credits"(platform: "/" , , isAbstract: true) {}
    "/banking/balance/credits/print"(platform: "/", type: TrackType.Event) { eventDataTrack }
    "/banking/balance/credits/tap"(platform: "/", type: TrackType.Event) { actionEventDataTrack }
}
