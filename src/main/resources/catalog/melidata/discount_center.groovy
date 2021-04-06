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
        category_id(type: PropertyType.String, required: true, description: "The Category item id")
        item_id(type: PropertyType.String, required: true, description: "The item id")
        item_name(type: PropertyType.String, required: true, description: "The item title")
    }

    propertyGroups {
        storeGroup(store_id, collector_id, brand_id, name, distance, category, mcc, review, discounts, delivery, session_id)
        moreInfoGroup(store_id, collector_id, brand_id, session_id)
        vipGroup(collector_id, category_id, item_id, item_name, session_id)
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

    def context_info_definition = objectSchemaDefinitions {
        has_cart(type: PropertyType.Boolean, required: true, description: "If the cart is available")
        has_catalog(type: PropertyType.Boolean, required: false, description: "If the Catalog is available")
        version_code(type: PropertyType.Numeric, required: false, description: "The version used")
        version_name(type: PropertyType.String, required: false, description: "The version name used")
    }


    // VSP

    "/discount_center/payers/vsp" (platform: "/mobile", type: TrackType.View) {
        storeGroup
        context_info(type: PropertyType.Map(context_info_definition), required: false, description: "The context information")
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


    // MORE INFO

    "/discount_center/payers/more_info" (platform: "/mobile", type: TrackType.View) {
        moreInfoGroup
    }

    def amount_definition = objectSchemaDefinitions {
        final_price(type: PropertyType.Numeric, required: true, description: "The final price with discount if exits")
        currency(type: PropertyType.String, required: true, description: "The currency")
        discount(type: PropertyType.Numeric, required: false, description: "The discount in percent")
        original_price(type: PropertyType.Numeric, required: false, description: "The price without discount")
    }

    // VIP

    "/discount_center/payers/vip" (platform: "/mobile", type: TrackType.View) {
        vipGroup
        amount(type: PropertyType.Map(amount_definition), required: true, description: "The price")
        context_info(type: PropertyType.Map(context_info_definition), required: true, description: "The context information")
    }


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

    def purchase_item_definition = objectSchemaDefinitions {
        index(type: PropertyType.Numeric, required: true, description: "The index of the actionable info item")
        collector_id(type: PropertyType.Numeric, required: true, description: "The collector id")
        store_id(type: PropertyType.Numeric, required: true, description: "The store id")
        name(type: PropertyType.String, required: true, description: "The name")
        purchase_id(type: PropertyType.Numeric, required: true, description: "The purchase id")
        purchase_state(type: PropertyType.String, required: true, values: ['paid'], description: "The purchase state")
        action_label(type: PropertyType.String, required: true, description: "Label text of the action link")
        action_target(type: PropertyType.String, required: true, description: "Target of the action link")
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

    def marketplace_purchases_status_definition = objectSchemaDefinitions {
        segment_id(type: PropertyType.String, required: true, description: "The section segment")
        marketplace_type(type: PropertyType.String, required: true, values: ['purchases_status'], description: "The section type")
        marketplace_index(type: PropertyType.Numeric, required: true, description: "The position of the segment in the list")
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(purchase_item_definition)), description: "Items shown in the purchase carousel")
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
        purchases_status(required: false, type: PropertyType.ArrayList(PropertyType.Map(marketplace_purchases_status_definition)), description: "Purchases status components")
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
