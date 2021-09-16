package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    initiative = 1267

    // Definitions

    def stream_info_definition = objectSchemaDefinitions {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
        template_id(required: true, type: PropertyType.String, description: "Template id configuration")
        channel_id(required: true, type: PropertyType.Numeric, description: "Channel id where broadcast belongs")
        started_at(required: true, type: PropertyType.String, description: "Date when stream has started")
        status(required: true, type: PropertyType.String, values: ["LIVE", "ENDED", "RECORDED"],  description: "Current status of the broadcast: LIVE, END, RECORDED")
        viewers(required: false, type: PropertyType.Numeric, description: "Current amount of viewers")
        time_elapsed(required: false, type: PropertyType.Numeric, description: "Time since stream started and user joined")
    }

    def product_info_definition = objectSchemaDefinitions {
        seller_id(required: true, type: PropertyType.Numeric, description: "Seller ID")
        official_store_id(required: false, type: PropertyType.Numeric, description: "Id of item's official store")
        is_free_shipping(required: true, type: PropertyType.Boolean, description: "Define is the shipping is free")
        price(required: true, type: PropertyType.Numeric, description: "Indicates the item price seen by the user. After discount")
        original_price(required: false, type: PropertyType.Numeric, description: "Indicates the original price of the item. Before applying discounts")
        discount(required: false, type: PropertyType.Numeric, description: "Indicates the discounts applied to the item")
        currency_id(required: true, type: PropertyType.String, description: "Id that identify the currency type")
        item_id(required: true, type: PropertyType.String, description: "Id that identify the item")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        domain_id(required: true, type: PropertyType.String, description: "Item's domain id")
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
        zipcode(required: true, type: PropertyType.String, description: "User's Zipcode")
        muted(required: false, type: PropertyType.Boolean, description: "Flag if video is muted or not")
        overlay_on(required: false, type: PropertyType.Boolean, description: "Flag if video has overlay on or not")
        orientation(required: true, type: PropertyType.String, description: "Current orientation, landscape or portrait")
    }

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

    // Tracks

    "/melilive"(platform: "/" , isAbstract:true ) {}

    "/melilive/stream"(platform: "/", type: TrackType.View) {
        tracking_id(required: true, type: PropertyType.String, description: "Unique ID to track if a Item comes from a LiveStream")
        stream(required: true, type: PropertyType.Map(stream_info_definition), description: "Stream information")
        products(required: true, type: PropertyType.ArrayList(PropertyType.Map(product_info_definition)), description: "Products associated to the stream")
        viewer_info(required: true, type: PropertyType.Map(viewer_info_definition), description: "Viewer information")
    }

    "/melilive/webview"(platform: "/mobile", type: TrackType.View) {
        url(required: true, type: PropertyType.String, description: "Live URL")
    }

    "/melilive/stream/exit"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
        time_elapsed(required: false, type: PropertyType.Numeric, description: "Time viewer was watching the stream")
        viewers(required: false, type: PropertyType.Numeric, description: "Current amount of viewers")
        viewer_info(required: true, type: PropertyType.Map(viewer_info_definition), description: "Viewer information")
    }

    "/melilive/prelive"(platform: "/", type: TrackType.View) {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
        start_at(required: true, type: PropertyType.String, description: "Date when stream has is supposed to start")
        viewer_info(required: true, type: PropertyType.Map(viewer_info_definition), description: "Viewer information")
    }

    "/melilive/stream/group"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
        status(required: true, type: PropertyType.String, values: ["LIVE", "ENDED", "RECORDED"], description: "Current status of the broadcast")
        group_id(required: true, type: PropertyType.String, description: "Group ID selected")
        viewers(required: false, type: PropertyType.Numeric, description: "Current amount of viewers")
        products(required: true, type: PropertyType.ArrayList(PropertyType.Map(product_group_info_definition)), description: "Product added to the group")
    }

    "/melilive/stream/share"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
        url(required: true, type: PropertyType.String, description: "Shared URL")
        viewers(required: false, type: PropertyType.Numeric, description: "Current amount of viewers")
    }

    "/melilive/stream/bookmark"("platform": "/", type: TrackType.Event, isAbstract: true, parentPropertiesInherited: false) {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
        item_id(required: true, type: PropertyType.String, description: "Id that identify the item")
        product_id(required: false, type: PropertyType.String, description:  "Product Id")
        viewers(required: false, type: PropertyType.Numeric, description: "Current amount of viewers")
        context(required: true, type: PropertyType.String, description: "Melilive Context")
    }

    "/melilive/stream/bookmark/add"("platform": "/", type: TrackType.Event) {
    }

    "/melilive/stream/bookmark/remove"("platform": "/", type: TrackType.Event) {
    }

    "/melilive/creator/start_live"("platform": "/", type: TrackType.Event) {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
        groups(required: true, PropertyType.ArrayList(PropertyType.Map(group_definition)), description: "Groups associated to the broadcast"))
    }

    "/melilive/creator/end_live"("platform": "/", type: TrackType.Event) {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
    }

    "/melilive/creator/share"("platform": "/", type: TrackType.Event) {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
        url(required: true, type: PropertyType.String, description: "Shared URL")
    }

    "/melilive/creator/item/event"("platform": "/", type: TrackType.Event) {
        event_type(required: true, type: PropertyType.String, "Event type name sent")
        item_id(required: true, type: PropertyType.String, description: "Id that identify the item")
        product_id(required: false, type: PropertyType.String, description:  "Product Id")
        group_id(required: true, type: PropertyType.String, description: "Group Id")
    }

}


