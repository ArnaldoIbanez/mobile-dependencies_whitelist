import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/*****************************
*   DISCOUNT CENTER TRACKS   *
******************************/

tracks {

    def item_definition = objectSchemaDefinitions {
        tracking_id(type: PropertyType.String, required: true, description: "The id of the item we are showing")
        blocked(type: PropertyType.Boolean, required: true, description: "If the discount is blocked or not")
        name(type: PropertyType.String, required: true, description: "The name of the discount")
        category(type: PropertyType.String, required: false, description: "The category of the discount")
        mcc(type: PropertyType.Numeric, required: false, description: "The mcc of the category of the discount")
        position(type: PropertyType.Numeric, required: true, description: "The position of the discount in the list")
        availability(type: PropertyType.String, required: false, description: "Availability status of the discount")
        level(type: PropertyType.Numeric, required: true, description: "The minimum loyalty level required for the discount")
        distance(type: PropertyType.Numeric, required: false, description: "The distance to the closest store")
        store_id(type: PropertyType.Numeric, required: false, description: "The store id of the closest store")
        amount(type: PropertyType.Numeric, required: false, description: "The discount amount in fixed values")
        priority(type: PropertyType.Numeric, required: true, description: "The discount brand priority")
    }
	
    "/discount_center" (platform: "/mobile", isAbstract: true) {}
    "/discount_center/payers" (platform: "/mobile", isAbstract: true) {}

    // LIST

    "/discount_center/payers/list" (platform: "/mobile", type: TrackType.View) {}

    "/discount_center/payers/list/show" (platform: "/mobile", type: TrackType.Event) {
      items(required: true, type: PropertyType.ArrayList(PropertyType.Map(item_definition)), description: "Items shown in the list")
    }

    // DETAIL

    "/discount_center/payers/detail" (platform: "/mobile", type: TrackType.View) {
      tracking_id(required: true, type: PropertyType.String, description: "Tracking id of the presented detail")
    }

    "/discount_center/payers/detail/share" (platform: "/mobile", type: TrackType.Event) {
      tracking_id(required: true, type: PropertyType.String, description: "Tracking id of the presented detail")
    }

    // LOCATION REQUEST

    "/discount_center/payers/request_location" (platform: "/mobile", type: TrackType.View) {}

    "/discount_center/payers/request_location/result" (platform: "/mobile", type: TrackType.Event) {
      result(required: true, type: PropertyType.String, values: ['enabled','disabled'] )
    }

    "/discount_center/payers/request_location/back" (platform: "/mobile", type: TrackType.Event) {}
}
