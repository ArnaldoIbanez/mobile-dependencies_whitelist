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
        has_logo(type: PropertyType.Boolean, required: true, description: "If the discount has a logo or not")
        coupon_used(type: PropertyType.Boolean, required: true, description: "If the coupon is used")
        sections(required: false, type: PropertyType.ArrayList(PropertyType.Map(section_definition)), description: "Sections shown in the list")
        tracking_id(required: false, type: PropertyType.String, description: "Tracking id of the presented detail")
        session_id(required: false, type: PropertyType.String, description: "Unique code that identifies a user's session")
    }

    "/discount_center/payers/detail/share" (platform: "/mobile", type: TrackType.Event) {}

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
}
