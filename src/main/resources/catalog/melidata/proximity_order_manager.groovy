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
            required: false,
            type: PropertyType.Numeric,
            description: "Store Id"
        )
        action_type(
            required: true,
            type: PropertyType.String,
            description: "Action Event Name",
            values: ["PRINT", "REPRINT", "REJECT", "CANCEL", "AUTOMATIC_CANCEL", "CLOSE_STORE", "OPEN_STORE", "CHANGE_STORE_STATUS", "ORDER_DETAILS", "CONFIRM_ORDER"]
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
            required: false,
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
        session_store_id(
           required: false,
            type: PropertyType.String,
            description: "Session Store Id"
        )
        purchase_id(
            required: false,
            type: PropertyType.Numeric,
            description: "Purchased Id"
        )
        sale_id(
            required: false,
            type: PropertyType.Numeric,
            description: "Sale Id"
        )
        sale_type(
            required: true,
            type: PropertyType.String,
            description: "Sale Event Name",
            values: ["RECEIVE", "PUSH", "DELETE", "DELETE_BY_TTL", "CHANGE_STATUS"]
        )
        sale_status(
            required: false,
            type: PropertyType.String,
            description: "Sale Current Status",
            values: ["TO_PREPARE", "IN_PREPARE", "IN_TRANSIT", "FINALIZED", "UNKNOWN"]
        )
        sale_sub_status(
            required: false,
            type: PropertyType.String,
            description: "Sale Current SubStatus",
            values: ["TO_CONFIRM", "ON_TIME", "DELAYED", "DELIVERED", "NOT_DELIVERED", "DELIVERY_FAILED", "CANCELLED", "UNKNOWN"]
        )
        store_status(
            required: false,
            type: PropertyType.String,
            description: "Store Current Status",
            values: ["pending", "enabled", "disabled", "paused", "blocked"]
        )
    }

    propertyGroups {
        actionGroup(opening_hours_today, seller_id, store_id, action_type,session_id, session_store_id, purchase_id, sale_id, exception)
        sessionGroup(session_id, seller_id, session_type, date, created_at, updated_at)
        saleGroup(sale_id, seller_id, store_id, sale_type, session_id, purchase_id, sale_status, sale_sub_status, session_store_id, exception)
    }

    def business_hour_definition = objectSchemaDefinitions {
        open(required: false, type: PropertyType.String, description: "Open hour")
        close(required: false, type: PropertyType.String, description: "Close hour")
    }

    def business_hours_definition = objectSchemaDefinitions {
        monday(required: false, type: PropertyType.ArrayList(PropertyType.Map(business_hour_definition)), description: "Monday")
        tuesday(required: false, type: PropertyType.ArrayList(PropertyType.Map(business_hour_definition)), description: "Tuesday")
        wednesday(required: false, type: PropertyType.ArrayList(PropertyType.Map(business_hour_definition)), description: "Wednesday")
        thursday(required: false, type: PropertyType.ArrayList(PropertyType.Map(business_hour_definition)), description: "Thursday")
        friday(required: false, type: PropertyType.ArrayList(PropertyType.Map(business_hour_definition)), description: "Friday")
        saturday(required: false, type: PropertyType.ArrayList(PropertyType.Map(business_hour_definition)), description: "Saturday")
        sunday(required: false, type: PropertyType.ArrayList(PropertyType.Map(business_hour_definition)), description: "Sunday")
        holidays(required: false, type: PropertyType.ArrayList(PropertyType.Map(business_hour_definition)), description: "Holidays")
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

    "/proximity_order_manager/sale" (platform: "/", type: TrackType.Event) {
        saleGroup
    }

    "/proximity_order_manager/store" (platform: "/", type: TrackType.Event) {
        store_id(
            required: true,
            type: PropertyType.Numeric,
            description: "Store id"
        )
        seller_id(
            required: true,
            type: PropertyType.Numeric,
            description: "Seller id"
        )
        type(
            required: true,
            type: PropertyType.String,
            description: "Store event name",
            values: ["SHOULD_BE_ENABLED"]
        )
        status(
            required: true,
            type: PropertyType.String,
            description: "Store Current Status",
            values: ["pending", "enabled", "disabled", "paused", "blocked"]
        )
        time_zone(
            required: true,
            type: PropertyType.String,
            description: "Time zone"
        )
        business_hours(
            required: true,
            type: PropertyType.Map(business_hours_definition),
            description: "Business hours"
        )
    }

    "/proximity_order_manager/shipment" (platform: "/", type: TrackType.Event) {
        shipment_id(
            required: true,
            type: PropertyType.Numeric,
            description: "Shipment id"
        )
        pack_id(
            required: true,
            type: PropertyType.Numeric,
            description: "Pack id"
        )
        seller_id(
            required: true,
            type: PropertyType.Numeric,
            description: "Seller id"
        )
        type(
            required: true,
            type: PropertyType.String,
            description: "Event type",
            values: ["CREATE", "CHANGE_STATUS", "DELAY"]
        )
        status(
            required: true,
            type: PropertyType.String,
            description: "Shipment status"
        )
        sub_status(
            required: true,
            type: PropertyType.String,
            description: "Shipment sub status"
        )
        elapsed_seconds(
            required: true,
            type: PropertyType.Numeric,
            description: "Relative to each event type, could be seconds to be created, to change to current status, or an unexpected delay"
        )
        purchase_id(
            required: false,
            type: PropertyType.Numeric,
            description: "Purchase id, currently not available in all event types"
        )
    }
}
