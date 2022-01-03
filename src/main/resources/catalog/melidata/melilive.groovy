package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    initiative = 1267

    // ************** VIEWER **************

    def prelive_stream_info_definition = objectSchemaDefinitions {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
        title(required: true, type: PropertyType.String, description: "Broadcast title")
        starts_at(required: true, type: PropertyType.String, description: "Date when stream has is supposed to start")
    }

    def stream_info_definition = objectSchemaDefinitions {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
        title(required: true, type: PropertyType.String, description: "Broadcast title")
        template_id(required: true, type: PropertyType.String, description: "Template id configuration")
        channel_id(required: true, type: PropertyType.Numeric, description: "Channel id where broadcast belongs")
        started_at(required: true, type: PropertyType.String, description: "Date when stream has started")
        viewers(required: false, type: PropertyType.Numeric, description: "Current amount of viewers")
        time_elapsed(required: false, type: PropertyType.Numeric, description: "Time since stream started and user joined")
    }

    def exit_stream_info_definition = objectSchemaDefinitions {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
        title(required: true, type: PropertyType.String, description: "Broadcast title")
        status(required: true, type: PropertyType.String, values: ["SCHEDULED", "LIVE", "ENDED", "RECORDED"], description: "Current status of the broadcast")
        time_elapsed(required: false, type: PropertyType.Numeric, description: "Time viewer was watching the stream")
        viewers(required: false, type: PropertyType.Numeric, description: "Current amount of viewers")
    }

    def group_stream_info_definition = objectSchemaDefinitions {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
        title(required: true, type: PropertyType.String, description: "Broadcast title")
        status(required: true, type: PropertyType.String, values: ["LIVE", "ENDED", "RECORDED"], description: "Current status of the broadcast")
        viewers(required: false, type: PropertyType.Numeric, description: "Current amount of viewers")
    }

    def share_stream_info_definition = objectSchemaDefinitions {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
        title(required: true, type: PropertyType.String, description: "Broadcast title")
        url(required: true, type: PropertyType.String, description: "Shared URL")
        status(required: true, type: PropertyType.String, values: ["SCHEDULED","LIVE", "ENDED", "RECORDED"], description: "Current status of the broadcast")
        viewers(required: false, type: PropertyType.Numeric, description: "Current amount of viewers")
    }

    def bookmark_stream_info_definition = objectSchemaDefinitions {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
        viewers(required: false, type: PropertyType.Numeric, description: "Current amount of viewers")
    }

    def product_info_definition = objectSchemaDefinitions {
        seller_id(required: false, type: PropertyType.Numeric, description: "Seller ID")
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        item_id(required: false, type: PropertyType.String, description: "Id that identify the item")
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        domain_id(required: false, type: PropertyType.String, description: "Item's domain id")
        catalog_product_id(required: false, type: PropertyType.String)
        is_catalog_listing(required: false, type: PropertyType.Boolean, description: "Item's catalog listing. It will be true when comes from VPP")
        highlight(required: false, type: PropertyType.Boolean, description: "Flag if the item is highlighted")
    }

    def product_group_info_definition = objectSchemaDefinitions {
        item_id(required: true, type: PropertyType.String, description: "Id that identify the item")
        product_id(required: false, type: PropertyType.String, description:  "Product Id")
        highlighted(required: true, type: PropertyType.Boolean, description: "Flag that indicate if the item is highlighted")
        tags(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "Tags added to the item")
    }

    def viewer_info_definition = objectSchemaDefinitions {
        loyalty_level(required: true, type: PropertyType.Numeric, description: "Current Loyalty Level")
        zipcode(required: false, type: PropertyType.String, description: "User's Zipcode")
        muted(required: false, type: PropertyType.Boolean, description: "Flag if video is muted or not")
        overlay_on(required: false, type: PropertyType.Boolean, description: "Flag if video has overlay on or not")
        orientation(required: true, type: PropertyType.String, description: "Current orientation, landscape or portrait")
    }

    propertyDefinitions {
        tracking_id(required: true, type: PropertyType.String, description: "Unique ID to track if a Item comes from a LiveStream")
        stream(required: true, type: PropertyType.Map(stream_info_definition), description: "Stream information")
        products(required: true, type: PropertyType.ArrayList(PropertyType.Map(product_info_definition)), description: "Products associated to the stream")
        viewer_info(required: true, type: PropertyType.Map(viewer_info_definition), description: "Viewer information")
    }

    propertyGroups {
        streamStatusGroup(tracking_id,stream,products,viewer_info)
    }

    "/melilive"(platform: "/" , isAbstract:true ) {}

    "/melilive/stream"(platform: "/" , isAbstract:true ) {}

    "/melilive/stream/live"(platform: "/", type: TrackType.View) {
        streamStatusGroup
    }

    "/melilive/stream/end"(platform: "/", type: TrackType.View) {
        streamStatusGroup
    }

    "/melilive/stream/recorded"(platform: "/", type: TrackType.View) {
        streamStatusGroup
    }

    "/melilive/webview"(platform: "/mobile", type: TrackType.View) {
        uri(required: true, type: PropertyType.String, description: "Live URL")
    }

    "/melilive/stream/exit"(platform: "/", type: TrackType.Event) {
        stream(required: true, type: PropertyType.Map(exit_stream_info_definition), description: "Stream information")
        viewer_info(required: true, type: PropertyType.Map(viewer_info_definition), description: "Viewer information")
    }

    "/melilive/stream/prelive"(platform: "/", type: TrackType.View) {
        stream(required: true, type: PropertyType.Map(prelive_stream_info_definition), description: "Stream information")
        viewer_info(required: true, type: PropertyType.Map(viewer_info_definition), description: "Viewer information")
    }

    "/melilive/stream/group"(platform: "/", type: TrackType.Event) {
        stream(required: true, type: PropertyType.Map(group_stream_info_definition), description: "Stream information")
        group_id(required: true, type: PropertyType.String, description: "Group ID selected")
        products(required: true, type: PropertyType.ArrayList(PropertyType.Map(product_group_info_definition)), description: "Product added to the group")
    }

    "/melilive/stream/share"(platform: "/", type: TrackType.Event) {
        stream(required: true, type: PropertyType.Map(share_stream_info_definition), description: "Stream information")
    }

    "/melilive/stream/bookmark"("platform": "/", type: TrackType.Event, isAbstract: true) {
        stream(required: true, type: PropertyType.Map(bookmark_stream_info_definition), description: "Stream information")
        item_id(required: true, type: PropertyType.String, description: "Id that identify the item")
        product_id(required: false, type: PropertyType.String, description:  "Product Id")
        viewers(required: false, type: PropertyType.Numeric, description: "Current amount of viewers")
        context(required: true, type: PropertyType.String, description: "Melilive Context")
    }

    "/melilive/stream/bookmark/add"("platform": "/", type: TrackType.Event) {
    }

    "/melilive/stream/bookmark/remove"("platform": "/", type: TrackType.Event) {
    }

    // ************** CREATOR **************

    def group_product_definition = objectSchemaDefinitions {
        item_id(required: true, type: PropertyType.String, description: "Id that identify the item")
        product_id(required: false, type: PropertyType.String, description:  "Product Id")
        visible(required: true, type: PropertyType.Boolean, description: "Flag that indicate if the item is visible")
        highlighted(required: true, type: PropertyType.Boolean, description: "Flag that indicate if the item is highlighted")
        position(required: true, type: PropertyType.Numeric, description: "Number that indicate the position in the group")
    }

    def group_definition = objectSchemaDefinitions {
        group_id(required: true, type: PropertyType.String, description: "Group ID")
        products(required: true, type: PropertyType.ArrayList(PropertyType.Map(group_product_definition)), description: "Products associated to the group")
    }


    "/melilive/creator/start_live"("platform": "/", type: TrackType.Event) {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
        groups(required: true, PropertyType.ArrayList(PropertyType.Map(group_definition)), description: "Groups associated to the broadcast")
    }

    "/melilive/creator/end_live"("platform": "/", type: TrackType.Event) {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
    }

    "/melilive/creator/share"("platform": "/", type: TrackType.Event) {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
        url(required: true, type: PropertyType.String, description: "Shared URL")
    }

    "/melilive/creator/item/event"("platform": "/", type: TrackType.Event) {
        event_type(required: true, type: PropertyType.String, values: ["HIGHLIGHT", "UNHIGHLIGHT", "SHOW", "HIDE"], description: "Event type name sent")
        item_id(required: true, type: PropertyType.String, description: "Id that identify the item")
        product_id(required: false, type: PropertyType.String, description:  "Product Id")
        group_id(required: true, type: PropertyType.String, description: "Group Id")
    }

    // ************** CHAT **************

    def chat_stream_info_definition = objectSchemaDefinitions {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
    }

    def chat_room_info_definition = objectSchemaDefinitions {
        room_id(required: true, type: PropertyType.String, description: "Room ID")
        slow_mode(required: false, type: PropertyType.Boolean, description: "Slow mode status")
        slow_mode_time(required: false, type: PropertyType.Numeric, description: "Slow mode configurated time")
    }

    // ************** VIEWER **************

    "/melilive/stream/chat"(platform: "/" , isAbstract:true ) {
        stream(required: true, type: PropertyType.Map(chat_stream_info_definition), description: "Broadcast object")
        chat(required: true, type: PropertyType.Map(chat_room_info_definition), description: "Chat object")
    }

    "/melilive/stream/chat/first_message"(platform: "/", type: TrackType.Event) { 
        role(required: true, type: PropertyType.String, values: ["PUBLISHER", "MODERATOR", "VIEWER"], description: "User role")
    }

    "/melilive/stream/chat/message_error"(platform: "/", type: TrackType.View) { 
        role(required: true, type: PropertyType.String, values: ["PUBLISHER", "MODERATOR", "VIEWER"], description: "User role")
        error_code(required: true, type: PropertyType.String, description: "Message error cause")
    }

    // ************** CREATOR **************

    "/melilive/creator/chat"(platform: "/", isAbstract: true) {
        stream(required: true, type: PropertyType.Map(chat_stream_info_definition), description: "Broadcast object")
        chat(required: true, type: PropertyType.Map(chat_room_info_definition), description: "Chat object")
    }

    "/melilive/creator/chat/first_message"(platform: "/", type: TrackType.Event) { 
        role(required: true, type: PropertyType.String, values: ["PUBLISHER", "MODERATOR", "VIEWER"], description: "User role")
    }

    "/melilive/creator/chat/message_error"(platform: "/", type: TrackType.View) {
        role(required: true, type: PropertyType.String, values: ["PUBLISHER", "MODERATOR", "VIEWER"], description: "User role")
        error_code(required: true, type: PropertyType.String, description: "Message error cause")
     }

    "/melilive/creator/chat/ban"(platform: "/", type: TrackType.Event) {
        ban_type(required: true, type: PropertyType.String, values: ["SLOW_MODE"])
     }

}


