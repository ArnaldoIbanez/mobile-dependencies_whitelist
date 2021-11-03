package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    initiative = "1148"

    propertyDefinitions {
        widget_id(
                required: true,
                type: PropertyType.Numeric,
                description: "Indicates an ID of the widget"
        )
        collect_methods_count(
                required: true,
                type: PropertyType.Numeric,
                description: "Indicates the amount of collect methods that the user has enabled"
        )
        collect_method(
                required: true,
                type: PropertyType.String,
                description: "Indicates which collect method is being used from the widget"
        )
    }

    propertyGroups {
        id_group(widget_id)
        config_group(widget_id,collect_methods_count)
        collect_method_group(widget_id,collect_method)
    }

    // Widget paths
    "/widget" (platform: "/mobile/android", isAbstract: true) { }
    "/widget/seller_collect" (platform: "/mobile/android", isAbstract: true) { }
    "/widget/seller_collect/config" (platform: "/mobile/android", type: TrackType.View) {
        config_group
    }
    "/widget/seller_collect/config/error" (platform: "/mobile/android", type: TrackType.View, parentPropertiesInherited:false) {
        id_group
    }
    "/widget/seller_collect/config/back" (platform: "/mobile/android", type: TrackType.Event, parentPropertiesInherited:false) {
        id_group
    }
    "/widget/seller_collect/config/save" (platform: "/mobile/android", type: TrackType.Event, parentPropertiesInherited:false) {
        collect_method_group
    }
    "/widget/seller_collect/config/not_logged" (platform: "/mobile/android", type: TrackType.View, parentPropertiesInherited:false) {
        id_group
    }
    "/widget/seller_collect/tap" (platform: "/mobile/android", type: TrackType.Event) {
        collect_method_group
    }
    "/widget/seller_collect/remove" (platform: "/mobile/android", type: TrackType.Event) {
        collect_method_group
    }
    "/widget/seller_collect/not_logged" (platform: "/mobile/android", type: TrackType.Event) {
        collect_method_group
    }

    // Hour Definition
    def timeSchema = objectSchemaDefinitions {
        hour(required: true,type: PropertyType.Numeric,description: "Indicates the selected hour from 0 to 23")
        minutes(required: true,type: PropertyType.Numeric,description: "Indicates the selected minutes from 0 to 59")
    }

    // Floating button paths
    "/floating_button" (platform: "/mobile/android", isAbstract: true) { // Floating button abstract base path
        button_uuid(required: true, type: PropertyType.String, description: "UUID randomly generated for a given button configuration persisted until the configuration is changed or deleted")
        button_type(required: true, type: PropertyType.String, values: ["seller_collect"], description: "Indicates which type of floating button we are using (currently 'seller_collect' is the only one)")
    }
    "/floating_button/button_mounted" (platform: "/mobile/android", type: TrackType.View) {  // When the floating button service renders a visible view on the screen
        trigger(required: true,type: PropertyType.String, values: ["schedule", "manual", "notification"], description: "If the button activation was triggered manually, by a notification or by the scheduler")
        tooltip_buttons(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "The button_id of all tooltip buttons that the user has enabled (in 'seller_collect' there is one for each collection method allowed in site)")
        side_buttons(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "The button_id of all side buttons that the user has enabled (in 'seller_collect' there is only configuration')")
    }
    "/floating_button/button_view_opened" (platform: "/mobile/android", type: TrackType.View) { } // The floating button tooltip and side buttons have been opened. The opened layout is showing.
    "/floating_button/button_view_closed" (platform: "/mobile/android", type: TrackType.View) { } // The floating button tooltip and side buttons have been closed. The draggable layout is showing.
    "/floating_button/button_tapped" (platform: "/mobile/android", type: TrackType.Event) { // A button from the view has been pressed. We will navigate to the associated deeplink.
        button_id(required: true,type: PropertyType.String, values: ["point", "qr", "link", "configuration"], description: "The associated id of the pressed button")
    }
    "/floating_button/button_unmounted" (platform: "/mobile/android", type: TrackType.Event) { } // The user closed the floating button view. This happens before stoping service or showing a notification.
    "/floating_button/button_stopped" (platform: "/mobile/android", type: TrackType.Event) { } // The floating button service has been stopped by user action
    "/floating_button/button_screen_dimensions_change" (platform: "/mobile/android", type: TrackType.Event) { // The underlying OS reported new screen dimensions so we need to redraw the floating button. This can be caused by a screen rotation or foldables.
        new_width(required: true,type: PropertyType.Numeric,description: "Screen width in pixels")
        new_height(required: true,type: PropertyType.Numeric,description: "Screen height in pixels")
     }
    "/floating_button/phone_reboot_reconfiguring_button" (platform: "/mobile/android", type: TrackType.Event) { } // Re-configured floating button after phone reboot

    // Floating buttons' notification for closing during open hours paths
    "/floating_button/reopen_button_notification_shown" (platform: "/mobile/android", type: TrackType.View) { } // Triggered a local notification inviting the user to reopen the button or close it until next day
    "/floating_button/reopen_button_notification_accepted" (platform: "/mobile/android", type: TrackType.Event) { } // The user re-opened the button from the notification
    "/floating_button/reopen_button_notification_dismissed" (platform: "/mobile/android", type: TrackType.Event) { } // The user closed the button for today from the notification

    // Floating buttons' scheduler paths
    "/floating_button/scheduled_start" (platform: "/mobile/android", type: TrackType.Event) { } // The scheduler triggered the opening of the button because it is now the configured the opening time
    "/floating_button/scheduled_stop" (platform: "/mobile/android", type: TrackType.Event) { } // The scheduler triggered the closing of the button because it is now the configured the closing time

    // Gadget settings' screens paths
    "/gadgets" (platform: "/mobile/android", isAbstract: true) { // Gadgets abstract base path
        session_uuid(required: true, type: PropertyType.String, description: "UUID randomly generated when the user first enters any of the gadget screens")
    } 
    "/gadgets/chooser" (platform: "/mobile/android", type: TrackType.View) { // Chooser screen showing rows for widget and floating button (if supported)
        supports_floating_button(required: true, type: PropertyType.Boolean, description: "If the phone supports the floating button feature")
    }
    "/gadgets/widget_settings" (platform: "/mobile/android", type: TrackType.View) {} // Widget FAQ screen
    "/gadgets/floating_button_settings" (platform: "/mobile/android", type: TrackType.View) {} // Floating button configuration screen
    "/gadgets/floating_button_settings/start_now" (platform: "/mobile/android", type: TrackType.Event) { // The button service was started without a configured schedule
        button_uuid(required: true, type: PropertyType.String, description: "UUID randomly generated for a given button configuration persisted until the configuration is changed or deleted")
    }
    "/gadgets/floating_button_settings/schedule_saved" (platform: "/mobile/android", type: TrackType.Event) { // The button service was started with a configured schedule
        button_uuid(required: true, type: PropertyType.String, description: "UUID randomly generated for a given button configuration persisted until the configuration is changed or deleted")
        opening_time(required: true,type: PropertyType.Map(timeSchema),description: "Selected opening time")
        closing_time(required: true,type: PropertyType.Map(timeSchema),description: "Selected closing time")
        opening_days(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "The scheduled opening days, possible values: (monday, tuesday, wednesday, thursday, friday, saturday, sunday)")
    }
    "/gadgets/floating_button_settings/schedule_cleared" (platform: "/mobile/android", type: TrackType.Event) {} // The previously saved schedule was cleared

    // Modal for requesting overlay permission paths
    "/gadgets/floating_button_settings/modal_draw_overlays_permissions" (platform: "/mobile/android", type: TrackType.View) {} // Modal explaining users that require extra permissions to draw overlays from the user to continue and we are redirecting them to their permission settings (system_overlay can´t be granted like other permissions)
    "/gadgets/floating_button_settings/modal_draw_overlays_permissions/continue" (platform: "/mobile/android", type: TrackType.Event) {} // Seller decided to continue to their permission settings
    "/gadgets/floating_button_settings/modal_draw_overlays_permissions/dismiss" (platform: "/mobile/android", type: TrackType.Event) {} // Seller declined to proceed
    "/gadgets/floating_button_settings/modal_draw_overlays_permissions/granted" (platform: "/mobile/android", type: TrackType.Event) {} // We regained control from the permission settings and we have been granted permissions
    "/gadgets/floating_button_settings/modal_draw_overlays_permissions/denied" (platform: "/mobile/android", type: TrackType.Event) {}  // We regained control from the permission settings and we have NOT been granted permissions
}