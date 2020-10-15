package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/*****************************
*   DISCOUNT CENTER TRACKS   *
******************************/

tracks {

    initiative = "1218"
	
    "/discount_center" (platform: "/mobile", isAbstract: true) {}
    "/discount_center/payers" (platform: "/mobile", isAbstract: true) {}

    propertyDefinitions {
        flow_detail(required: false, description: "External info")
        flow(required: false, type: PropertyType.String, description: "External flow name")
        session_id(required: false, type: PropertyType.String, description: "Internal session id")
        session_time(required: false, type: PropertyType.Numeric, description: "Session time")
        checkout_type(required: false, type: PropertyType.String, description: "Checkout type")
        collector_id(required: false, description: "Collector external id")
        security_enabled(required: false, type: PropertyType.Boolean, description: "If the user has biometric or passcode validation to make a payment")
        category(type: PropertyType.String, required: false, description: "The category id")
        mcc(type: PropertyType.String, required: true, description: "The mcc")
        experiments(required: false, type: PropertyType.String, description: "Active experiments")
        store_id(type: PropertyType.Numeric, required: true, description: "The store id")
        brand_id(type: PropertyType.Numeric, required: false, description: "The brand id")
        name(type: PropertyType.String, required: false, description: "The name")
        distance(type: PropertyType.Numeric, required: true, description: "The distance")
        review(type: PropertyType.Map(store_review_definition), required: false, description: "The review node")
        discounts(type: PropertyType.ArrayList(PropertyType.Map(store_discount_definition)), required: false, description: "The discounts")
        delivery(type: PropertyType.Map(store_delivery_definition), required: false, description: "The delivery node")
    }

    propertyGroups {
        externalData(flow, flow_detail, collector_id, session_id, session_time, checkout_type, security_enabled, category, experiments)
        storeGroup(store_id, collector_id, brand_id, name, distance, category, mcc, review, discounts, delivery, session_id)
    }

    def store_review_definition = objectSchemaDefinitions {
        rating(type: PropertyType.Numeric, required: true, description: "The store rating")
        count(type: PropertyType.Numeric, required: true, description: "The number of reviews")
    }

    def store_discount_definition = objectSchemaDefinitions {
        campaign_id(type: PropertyType.Numeric, required: true, description: "The campaign id")
        index(type: PropertyType.Numeric, required: true, description: "The position in the list")
        blocked(type: PropertyType.Boolean, required: true, description: "If the discount is not usable")
        availability(type: PropertyType.String, required: false, values: ['full', 'fewleft', 'soldout', 'soldout_today'], description: "Availability status")
        level(type: PropertyType.Numeric, required: true, description: "The minimum loyalty level required")
        amount_type(type: PropertyType.String, required: true, values: ['fixed', 'percent'], description: "The amount type")
        amount(type: PropertyType.Numeric, required: true, description: "The amount")
        priority(type: PropertyType.Numeric, required: true, description: "The discount brand priority")
    }

    def store_delivery_definition = objectSchemaDefinitions {
        radius(type: PropertyType.Numeric, required: false, description: "The delivery radius")
        delivery(type: PropertyType.Boolean, required: true, description: "If the store has delivery")
        pickup(type: PropertyType.Boolean, required: true, description: "If the store has pickup")
    }

    // VSP
    "/discount_center/payers/vsp" (platform: "/mobile", type: TrackType.View) {
        storeGroup
    }

    // DETAIL

    def section_definition = objectSchemaDefinitions {
        id(type: PropertyType.String, required: true, description: "The section identifier")
        type(type: PropertyType.String, required: true, description: "The section type")
        position(type: PropertyType.Numeric, required: true, description: "The position of the section in the list")
    }

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

    def touchpoint_item_definition = objectSchemaDefinitions {
        tracking_id(type: PropertyType.String, required: true, description: "The id of the item we are showing")
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

    def store_item_definition = objectSchemaDefinitions {
        store_id(type: PropertyType.Numeric, required: true, description: "The store id")
        brand_id(type: PropertyType.Numeric, required: false, description: "The brand id")
        name(type: PropertyType.String, required: false, description: "The name")
        distance(type: PropertyType.Numeric, required: true, description: "The distance")
        review(type: PropertyType.Map(store_review_definition), required: false, description: "The review node")
        discounts(type: PropertyType.ArrayList(PropertyType.Map(store_discount_definition)), required: false, description: "The discounts")
        delivery(type: PropertyType.Map(store_delivery_definition), required: false, description: "The delivery node")
        collector_id(required: false, description: "Collector external id")
        session_id(required: false, type: PropertyType.String, description: "Internal session id")
        category(type: PropertyType.String, required: false, description: "The category id")
        mcc(type: PropertyType.String, required: true, description: "The mcc")
    }

    def card_item_definition = objectSchemaDefinitions {
        type(type: PropertyType.String, required: true, description: "The card type identifier")
        index(type: PropertyType.Numeric, required: true, description: "The position card within the component")
        store(type: PropertyType.Map(store_item_definition), required: false, description: "The store tracking definition for type 'store' cards")
    }

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
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(card_item_definition)), description: "Items shown in the carousel")
    }

    def marketplace_row_definition = objectSchemaDefinitions {
        segment_id(type: PropertyType.String, required: true, description: "The section segment")
        marketplace_type(type: PropertyType.String, required: true, description: "The section type")
        marketplace_index(type: PropertyType.Numeric, required: true, description: "The position of the segment in the list")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(store_item_definition)), description: "Items shown in the carousel")
    }

    def marketplace_image_banner_definition = objectSchemaDefinitions {
        segment_id(type: PropertyType.String, required: true, description: "The section segment")
        marketplace_type(type: PropertyType.String, required: true, description: "The section type")
        marketplace_index(type: PropertyType.Numeric, required: true, description: "The position of the segment in the list")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(image_banner_item_definition)), description: "Items shown in the banner")
    }

    def marketplace_last_viewed_definition = objectSchemaDefinitions {
        segment_id(type: PropertyType.String, required: true, description: "The section segment")
        marketplace_type(type: PropertyType.String, required: true, description: "The section type")
        marketplace_index(type: PropertyType.Numeric, required: true, description: "The position of the segment in the list")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(store_item_definition)), description: "Items shown in the last viewed section")
    }

    def marketplace_components_definition = objectSchemaDefinitions {
        main_slider(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_main_slider_definition)), description: "Main slider components")
        main_actions(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_main_action_definition)), description: "Main actions components")
        carousel(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_carousel_definition)), description: "Carousel components")
        row(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_row_definition)), description: "Row components")
        image_banner(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_image_banner_definition)), description: "Image banner components")
        last_viewed(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_last_viewed_definition)), description: "Last Viewed components")
        hybrid_row(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_row_definition)), description: "Hybrid Row components")
        hybrid_carousel(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_carousel_definition)), description: "Carousel components")
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
}
