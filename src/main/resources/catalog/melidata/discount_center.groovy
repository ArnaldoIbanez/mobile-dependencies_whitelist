package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/*****************************
*   DISCOUNT CENTER TRACKS   *
******************************/

tracks {

    initiative = "1218"

    def item_definition = objectSchemaDefinitions {
        tracking_id(type: PropertyType.String, required: true, description: "The id of the item we are showing")
        blocked(type: PropertyType.Boolean, required: true, description: "If the discount is blocked or not")
        name(type: PropertyType.String, required: true, description: "The name of the discount")
        category(type: PropertyType.String, required: false, description: "The category of the discount")
        mcc(type: PropertyType.Numeric, required: false, description: "The mcc of the category of the discount")
        position(type: PropertyType.Numeric, required: true, description: "The position of the discount in the list")
        index(type: PropertyType.Numeric, required: true, description: "The index of the discount in the list")
        availability(type: PropertyType.String, required: false, values: ['full', 'fewleft', 'soldout', 'soldout_today'], description: "Availability status of the discount")
        level(type: PropertyType.Numeric, required: true, description: "The minimum loyalty level required for the discount")
        distance(type: PropertyType.Numeric, required: false, description: "The distance to the closest store")
        store_id(type: PropertyType.Numeric, required: false, description: "The store id of the closest store")
        amount_type(type: PropertyType.String, required: true, values: ['fixed', 'percent'], description: "The amount type")
        amount(type: PropertyType.Numeric, required: false, description: "The discount amount in fixed values")
        priority(type: PropertyType.Numeric, required: true, description: "The discount brand priority")
        collector_id(type: PropertyType.Numeric, required: false, description: "The discount collector id")
        has_logo(type: PropertyType.Boolean, required: true, description: "If the discount has a logo or not")
        coupon_used(type: PropertyType.Boolean, required: true, description: "If the coupon is used")
    }

    def section_definition = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true, description: "The section identifier")
        type(type: PropertyType.String, required: true, description: "The section type")
        position(type: PropertyType.Numeric, required: true, description: "The position of the section in the list")
    }
	
    "/discount_center" (platform: "/mobile", isAbstract: true) {}
    "/discount_center/payers" (platform: "/mobile", isAbstract: true) {}

    // LIST

    "/discount_center/payers/list" (platform: "/mobile", type: TrackType.View) {
      session_id(required: false, type: PropertyType.String, description: "Unique code that identifies a user's session")
    }

    "/discount_center/payers/list/print" (platform: "/mobile", type: TrackType.Event) {
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(item_definition)), description: "Items shown in the list")
    }

    "/discount_center/payers/list/show" (platform: "/mobile", type: TrackType.Event) {
      items(required: true, type: PropertyType.ArrayList(PropertyType.Map(item_definition)), description: "Items shown in the list")
      offset(required: false, type: PropertyType.Numeric, description: "The offset in the list")
      filters(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "The enabled filters")
      user_loyalty_level(required: true, type: PropertyType.Numeric, description: "The user loyalty level")
    }

    "/discount_center/payers/list/tap_filter" (platform: "/mobile", type: TrackType.Event) {
        filter_id(required: true, type: PropertyType.String, description: "The filter identifier")
        index(required: true, type: PropertyType.Numeric, description: "The filter position")
        action(required: true, type: PropertyType.String, description: "The filter state")
    }

    // DETAIL

    "/discount_center/payers/detail" (platform: "/mobile", type: TrackType.View) {
        title(required: false, type: PropertyType.String, description: "The discount name")
        enabled(required: false, type: PropertyType.Boolean, description: "If the discount can be consumed or not")
        availability(required: false, type: PropertyType.String, values: ['full', 'fewleft', 'soldout', 'soldout_today'], description: "Availability status of the discount")
        mcc(required: false, type: PropertyType.String, description: "The mcc of the category of the discount")
        level(required: false, type: PropertyType.Numeric, description: "The discount level")
        blocked(required: false, type: PropertyType.Boolean, description: "If the discount is not available for the user level")
        amount(required: false, type: PropertyType.Numeric, description: "The discount campaign amount")
        amount_type(required: false, type: PropertyType.String,  values: ['fixed', 'percent'], description: "The amount type")
        status(required: false, type: PropertyType.String, values: ['active', 'inactive', 'finished'], description: "The discount campaign status")
        stores_id(required: false, type: PropertyType.ArrayList(PropertyType.Numeric), description: "A list of stores who are in a nearby radius")
        has_logo(type: PropertyType.Boolean, required: false, description: "If the discount has a logo or not")
        coupon_used(type: PropertyType.Boolean, required: false, description: "If the coupon is used")
        sections(required: false, type: PropertyType.ArrayList(PropertyType.Map(section_definition)), description: "Sections shown in the list")
        tracking_id(required: false, type: PropertyType.String, description: "Tracking id of the presented detail")
        session_id(required: false, type: PropertyType.String, description: "Unique code that identifies a user's session")
        referer_origin(required: false, type: PropertyType.String, description: "The user who share the discount")
        category(type: PropertyType.String, required: false, description: "The category of the item")
        collector_id(type: PropertyType.String, required: false, description: "The collector id of the item")
        store_id(type: PropertyType.Numeric, required: false, description: "The store id of the closest store")
    }

    "/discount_center/payers/detail/share" (platform: "/mobile", type: TrackType.Event) {}

    "/discount_center/payers/detail/terms" (platform: "/mobile", type: TrackType.Event) {}

    "/discount_center/payers/detail/tap" (platform: "/mobile", type: TrackType.Event) {}

    // LOCATION REQUEST

    "/discount_center/payers/request_location" (platform: "/mobile", type: TrackType.View) {
      session_id(required: false, type: PropertyType.String, description: "Unique code that identifies a user's session")
    }

    "/discount_center/payers/request_location/result" (platform: "/mobile", type: TrackType.Event) {
      result(required: true, type: PropertyType.String, values: ['enabled','disabled'] )
    }

    "/discount_center/payers/request_location/back" (platform: "/mobile", type: TrackType.Event) {}

    // SESSION

    "/discount_center/payers/session" (platform: "/mobile", isAbstract: true) {}

    "/discount_center/payers/session/end" (platform: "/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Unique code that identifies a user's session")
    }

    // TOUCH POINT

    propertyDefinitions {
        flow_detail(required: false, description: "External info")
        flow(required: false, type: PropertyType.String, description: "External flow name")
        session_id(required: false, type: PropertyType.String, description: "Internal session id")
        session_time(required: false, type: PropertyType.Numeric, description: "Session time")
        checkout_type(required: false, type: PropertyType.String, description: "Checkout type")
        collector_id(required: false, description: "Collector external id")
        security_enabled(required: false, type: PropertyType.Boolean, description: "If the user has biometric or passcode validation to make a payment")
        category(type: PropertyType.String, required: false, description: "The category id")
        experiments(required: false, type: PropertyType.String, description: "Active experiments")
    }

    def touchpoint_item_definition = objectSchemaDefinitions {
        tracking_id(type: PropertyType.String, required: true, description: "The id of the item we are showing")
    }

    propertyGroups {
        externalData(flow, flow_detail, collector_id, session_id, session_time, checkout_type, security_enabled, category, experiments)
    }

    "/discount_center/payers/touchpoint" (platform: "/mobile", isAbstract: true) {}
    "/discount_center/payers/touchpoint/px_congrats" (platform: "/mobile", isAbstract: true) {}

    "/discount_center/payers/touchpoint/px_congrats/tap" (platform: "/mobile", type: TrackType.Event) {
        externalData
        tracking_id(required: true, type: PropertyType.String, description: "The id campaign")
    }

    "/discount_center/payers/touchpoint/px_congrats/show" (platform: "/mobile", type: TrackType.Event) {
        externalData
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(touchpoint_item_definition)), description: "The items")
    }

    "/discount_center/payers/touchpoint/px_congrats/print" (platform: "/mobile", type: TrackType.Event) {
        externalData
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(touchpoint_item_definition)), description: "The items")
    }

    // MARKETPLACE

    def main_slider_item_definition = objectSchemaDefinitions {
        tracking_id(type: PropertyType.String, required: true, description: "The id of the main slider item we are showing")
        index(type: PropertyType.Numeric, required: true, description: "The position of the banner")
    }

    def main_actions_item_definition = objectSchemaDefinitions {
        tracking_id(type: PropertyType.String, required: true, description: "The id of the main action we are showing")
        index(type: PropertyType.Numeric, required: true, description: "The position of the main action")
    }

    def image_banner_item_definition = objectSchemaDefinitions {
        tracking_id(type: PropertyType.String, required: true, description: "The id of the image banner we are showing")
        index(type: PropertyType.Numeric, required: true, description: "The position of the image banner")
    }

    def marketplace_main_slider_definition = objectSchemaDefinitions {
        segment_id(type: PropertyType.String, required: true, description: "The section segment")
        marketplace_type(type: PropertyType.String, required: true, description: "The section type")
        marketplace_index(type: PropertyType.Numeric, required: true, description: "The position of the segment in the list")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(main_slider_item_definition)), description: "Items shown in the carousel")
    }

    def marketplace_main_action_definition = objectSchemaDefinitions {
        segment_id(type: PropertyType.String, required: true, description: "The section segment")
        marketplace_type(type: PropertyType.String, required: true, description: "The section type")
        marketplace_index(type: PropertyType.Numeric, required: true, description: "The position of the segment in the list")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(main_actions_item_definition)), description: "Items shown in the carousel")
    }

    def marketplace_carousel_definition = objectSchemaDefinitions {
        segment_id(type: PropertyType.String, required: true, description: "The section segment")
        marketplace_type(type: PropertyType.String, required: true, description: "The section type")
        marketplace_index(type: PropertyType.Numeric, required: true, description: "The position of the segment in the list")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(item_definition)), description: "Items shown in the carousel")
    }

    def marketplace_row_definition = objectSchemaDefinitions {
        segment_id(type: PropertyType.String, required: true, description: "The section segment")
        marketplace_type(type: PropertyType.String, required: true, description: "The section type")
        marketplace_index(type: PropertyType.Numeric, required: true, description: "The position of the segment in the list")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(item_definition)), description: "Items shown in the carousel")
    }

    def marketplace_image_banner_definition = objectSchemaDefinitions {
        segment_id(type: PropertyType.String, required: true, description: "The section segment")
        marketplace_type(type: PropertyType.String, required: true, description: "The section type")
        marketplace_index(type: PropertyType.Numeric, required: true, description: "The position of the segment in the list")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(image_banner_item_definition)), description: "Items shown in the banner")
    }

    def marketplace_components_definition = objectSchemaDefinitions {
        main_slider(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_main_slider_definition)), description: "Main slider components")
        main_actions(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_main_action_definition)), description: "Main actions components")
        carousel(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_carousel_definition)), description: "Carousel components")
        row(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_row_definition)), description: "Row components")
        image_banner(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_image_banner_definition)), description: "Image banner components")
        last_viewed(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_last_viewed_definition)), description: "Last Viewed components")
    }

    def marketplace_last_viewed_definition = objectSchemaDefinitions {
        segment_id(type: PropertyType.String, required: true, description: "The section segment")
        marketplace_type(type: PropertyType.String, required: true, description: "The section type")
        marketplace_index(type: PropertyType.Numeric, required: true, description: "The position of the segment in the list")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(item_definition)), description: "Items shown in the last viewed section")
    }

    "/discount_center/payers/marketplace" (platform: "/mobile", type: TrackType.View) {
      session_id(required: false, type: PropertyType.String, description: "Unique code that identifies a user's session")
    }

    "/discount_center/payers/marketplace/components" (platform: "/mobile", type: TrackType.View) { }

    "/discount_center/payers/marketplace/components/tap" (platform: "/mobile", type: TrackType.Event) {
      marketplace_id(required: true, type: PropertyType.String, description: "An unique identifier to group the same marketplace")
      components(required: true, type: PropertyType.Map(marketplace_components_definition), description: "Marketplace components")
    }
    
    "/discount_center/payers/marketplace/components/show" (platform: "/mobile", type: TrackType.Event) {
      marketplace_id(required: true, type: PropertyType.String, description: "An unique identifier to group the same marketplace")
      components(required: true, type: PropertyType.Map(marketplace_components_definition), description: "Marketplace components")
    }

    "/discount_center/payers/marketplace/components/print" (platform: "/mobile", type: TrackType.Event) {
      marketplace_id(required: true, type: PropertyType.String, description: "An unique identifier to group the same marketplace")
      components(required: true, type: PropertyType.Map(marketplace_components_definition), description: "Marketplace components")
    }

    //WHATSAPP

    "/discount_center/payers/detail/whatsapp" (platform: "/mobile", type: TrackType.View) {
        store_id(type: PropertyType.Numeric, required: false, description: "The store id of the store")
        collector_id(type: PropertyType.String, required: false, description: "The collector id of the item")
        session_id(required: true, type: PropertyType.String, description: "Unique code that identifies a user's session")
        category(type: PropertyType.String, required: false, description: "The category of the item")
        title(required: false, type: PropertyType.String, description: "The store name")
        tracking_id(required: true, type: PropertyType.String, description: "Tracking id of the presented whatsapp detail")
    }
}
