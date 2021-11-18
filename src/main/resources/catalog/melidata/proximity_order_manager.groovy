package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    initiative = "1305"

    def opening_hour_definition = objectSchemaDefinitions {
        open(required: true, type: PropertyType.String, description: "Open Hour")
        close(required: true, type: PropertyType.String, description: "Close Hour")
    }

    propertyDefinitions {
        opening_hours_today(
            required: false,
            type: PropertyType.ArrayList(PropertyType.Map(opening_hour_definition)), 
            description: "Opening Hours"
        )
        seller_id(
            required: true,
            type: PropertyType.Numeric,
            description: "Seller Id"
        )
        store_id(
            required: true,
            type: PropertyType.Numeric,
            description: "Store Id"
        )
        action_type(
            required: true,
            type: PropertyType.String,
            description: "Action Event Name",
            values: ["PRINT", "REPRINT", "REJECT", "CANCEL", "AUTOMATIC_CANCEL", "CLOSE_STORE", "OPEN_STORE", "CHANGE_STORE_STATUS"]
        )
        session_type(
            required: true,
            type: PropertyType.String,
            description: "Session Event Name",
            values: ["CREATE", "DELETE", "UPDATE"]
        )
        exception(
            required: false,
            type: PropertyType.String,
            description: "Exception Stack"
        )
        session_id(
            required: true,
            type: PropertyType.String,
            description: "Session Id"
        )
        date(
            required: true,
            type: PropertyType.String,
            description: "Session date"
        )
        created_at(
            required: true,
            type: PropertyType.String,
            description: "Session date created"
        )
        updated_at(
            required: false,
            type: PropertyType.String,
            description: "Session date updated"
        )
    }

    propertyGroups {
        actionGroup(opening_hours_today, seller_id, store_id, action_type, exception)
        sessionGroup(session_id, seller_id, session_type, date, created_at, updated_at)
    }

    "/proximity_order_manager" (platform: "/", isAbstract: true) {}

    // Views:

    "/proximity_order_manager/home" (platform: "/", type: TrackType.View) {}

    // Events:

    "/proximity_order_manager/action" (platform: "/", type: TrackType.Event) {
        actionGroup
    }

    "/proximity_order_manager/session" (platform: "/", type: TrackType.Event) {
        sessionGroup
    }
}
