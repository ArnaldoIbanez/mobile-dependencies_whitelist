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
        session_id(required: false, type: PropertyType.String, description: "Internal session id")
        collector_id(required: false, description: "Collector external id")
        category(type: PropertyType.String, required: false, description: "The category id")
        mcc(type: PropertyType.String, required: true, description: "The mcc")
        store_id(type: PropertyType.Numeric, required: true, description: "The store id")
        brand_id(type: PropertyType.Numeric, required: false, description: "The brand id")
        name(type: PropertyType.String, required: false, description: "The name")
        distance(type: PropertyType.Numeric, required: true, description: "The distance")
        review(type: PropertyType.Map(store_review_definition), required: false, description: "The review node")
        discounts(type: PropertyType.ArrayList(PropertyType.Map(store_discount_definition)), required: false, description: "The discounts")
        delivery(type: PropertyType.Map(store_delivery_definition), required: false, description: "The delivery node")
    }

    propertyGroups {
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

    def vsp_components_definition = objectSchemaDefinitions {
        actionable_info(required: false, type: PropertyType.ArrayList(PropertyType.Map(vsp_actionable_info_definition)), description: "Actionable info components")
    }

    def vsp_actionable_info_definition = objectSchemaDefinitions {
        segment_id(type: PropertyType.String, required: true, description: "The section segment")
        marketplace_type(type: PropertyType.String, required: true, description: "The section type")
        marketplace_index(type: PropertyType.Numeric, required: true, description: "The position of the segment in the list")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(actionable_info_item_definition)), description: "Actionable info item")
    }

    def actionable_info_item_definition = objectSchemaDefinitions {
        index(type: PropertyType.Numeric, required: true, description: "The index of the actionable info item")
        tracking_id(type: PropertyType.String, required: true, description: "The unique id of the actionable info item item we are showing")
        collector_id(type: PropertyType.Numeric, required: true, description: "The collector id")
        store_id(type: PropertyType.Numeric, required: true, description: "The store id")
    }

    "/discount_center/payers/vsp/components" (platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false, isAbstract: true) { 
        session_id(required: false, type: PropertyType.String, description: "Unique code that identifies a user's session")
    }

    "/discount_center/payers/vsp/components/tap" (platform: "/mobile", type: TrackType.Event) {
      components(required: true, type: PropertyType.Map(vsp_components_definition), description: "VSP components")
    }

    "/discount_center/payers/vsp/components/print" (platform: "/mobile", type: TrackType.Event) {
      components(required: true, type: PropertyType.Map(vsp_components_definition), description: "VSP components")
    }

    "/discount_center/payers/vsp/components/show" (platform: "/mobile", type: TrackType.Event) {
      components(required: true, type: PropertyType.Map(vsp_components_definition), description: "VSP components")
    }

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

    // MARKETPLACE

    def store_item_definition = objectSchemaDefinitions {
        storeGroup
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

    def marketplace_filters_definition = objectSchemaDefinitions {
        tracking_id(type: PropertyType.String, required: true, description: "The id of the image banner we are showing")
        selected(type: PropertyType.String, required: true, values: ['selected', 'unselected', 'none'], description: "The state of the displayed filters")
        index(type: PropertyType.Numeric, required: true, description: "The position of the filter within the component")
    }

    def marketplace_filters_l2_definition = objectSchemaDefinitions {
        tracking_id(type: PropertyType.String, required: true, description: "The id of the image banner we are showing")
        selected(type: PropertyType.Boolean, required: true, description: "The state of the filter we are showing")
        index(type: PropertyType.Numeric, required: true, description: "The position of the filter within the component")
    }

    def marketplace_cover_carousel_definition = objectSchemaDefinitions {
        segment_id(type: PropertyType.String, required: true, description: "The section segment")
        marketplace_type(type: PropertyType.String, required: true, values: ['cover_carousel'], description: "The section type")
        marketplace_index(type: PropertyType.Numeric, required: true, description: "The position of the segment in the list")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(store_item_definition)), description: "Items shown in the carousel")
    }

    def marketplace_components_definition = objectSchemaDefinitions {
        main_slider(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_main_slider_definition)), description: "Main slider components")
        main_actions(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_main_action_definition)), description: "Main actions components")
        carousel(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_carousel_definition)), description: "Carousel components")
        row(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_row_definition)), description: "Row components")
        image_banner(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_image_banner_definition)), description: "Image banner components")
        last_viewed(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_last_viewed_definition)), description: "Last Viewed components")
        hybrid_last_viewed(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_last_viewed_definition)), description: "Last Viewed components")
        hybrid_row(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_row_definition)), description: "Hybrid Row components")
        hybrid_carousel(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_carousel_definition)), description: "Carousel components")
        filters(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_filters_definition)), description: "Filters components")
        filters_l2(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_filters_l2_definition)), description: "Filters L2 components")
        cover_carousel(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_cover_carousel_definition)), description: "Cover carousel components")
    }

    "/discount_center/payers/marketplace" (platform: "/mobile", type: TrackType.View) {
      session_id(required: false, type: PropertyType.String, description: "Unique code that identifies a user's session")
    }

    "/discount_center/payers/marketplace/components" (platform: "/mobile", type: TrackType.Event, isAbstract: true) { }

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
