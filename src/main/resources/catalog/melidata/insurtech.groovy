package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1212"

    def product = objectSchemaDefinitions {
        entity_type(required: true, type: PropertyType.String, description: "Entity type insurtech product ", values: ["quote", "order", "item_id"])
        entity_id(required: true, type: PropertyType.String, description: "Entity id of the insurtech product")
        product_type(required: false, type: PropertyType.String, description: "Insurtech product type", values: ["roda", "garex"])
        product_id(required: false, type: PropertyType.String, description: "Id insurtech product")
    }

    // INSURTECH RODA Abstract
    "/insurtech"(platform: "/", isAbstract: true) {}
    "/insurtech/protections"(platform: "/", isAbstract: true) {}

    // INSURTECH CLAIMS RODA
    "/insurtech/protections/claims"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
    } 
   
    "/insurtech/protections/claims/cancel"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
    }
    "/insurtech/protections/claims/execute"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
    }

    "/insurtech/protections/claims/use_service"(platform:"/", type: TrackType.Event) {}
    "/insurtech/protections/claims/use_service_certificate"(platform:"/", type: TrackType.Event) {}
    "/insurtech/protections/claims/use_service_not_certificate"(platform:"/", type: TrackType.Event) {}
    "/insurtech/protections/claims/cancel_protection"(platform:"/", type: TrackType.Event) {}
    "/insurtech/protections/claims/help"(platform:"/", type: TrackType.Event) {}
    "/insurtech/protections/claims/read_certificate"(platform:"/", type: TrackType.Event) {}
    "/insurtech/protections/claims/feedback"(platform:"/", type: TrackType.Event) {}

    "/insurtech/protections/claims/need_help"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
    }
    "/insurtech/protections/claims/need_help/select"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        help_id(required: true, type: PropertyType.String, description: "")
    }

    "/insurtech/protections/claims/cancel/reasons"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
    }
    "/insurtech/protections/claims/cancel/reasons/select"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        reason_id(required: true, type: PropertyType.String, description: "")
    }

    "/insurtech/protections/claims/cancel/reasons/other"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
    }
    "/insurtech/protections/claims/cancel/reasons/other/confirm"(platform:"/", type: TrackType.Event) {}

    "/insurtech/protections/claims/cancel/review"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
    }
    "/insurtech/protections/claims/cancel/review/confirm"(platform:"/", type: TrackType.Event) {}
    "/insurtech/protections/claims/cancel/review/keep_protection"(platform:"/", type: TrackType.Event) {}

    "/insurtech/protections/claims/cancel/congrats"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
        type_congrats(required: false, type: PropertyType.String, description: "Insurtech product type", values: ["success", "error"])
    }

    "/insurtech/protections/claims/execute/item"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
    }
    "/insurtech/protections/claims/execute/item/confirm"(platform:"/", type: TrackType.Event) {}

    "/insurtech/protections/claims/execute/description"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
    }
    "/insurtech/protections/claims/execute/description/confirm"(platform:"/", type: TrackType.Event) {}

    "/insurtech/protections/claims/execute/questions"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
    }

    "/insurtech/protections/claims/execute/questions/select_reasons"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        reason_id(required: true, type: PropertyType.String, description: "")
    }
    "/insurtech/protections/claims/execute/questions/select_police_report"(platform:"/", type: TrackType.Event) {}
    "/insurtech/protections/claims/execute/questions/select_not_police_report"(platform:"/", type: TrackType.Event) {}


    "/insurtech/protections/claims/execute/address"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
    }

   "/insurtech/protections/claims/execute/address/check"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        address_id(required: true, type: PropertyType.Numeric, description: "Id of the selected address")
    }
    "/insurtech/protections/claims/execute/address/confirm"(platform:"/", type: TrackType.Event) {}

    "/insurtech/protections/claims/execute/imei_lock_code"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
    }

    "/insurtech/protections/claims/execute/imei_lock_code/confirm"(platform:"/", type: TrackType.Event) {}

    "/insurtech/protections/claims/execute/review"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
    }
    "/insurtech/protections/claims/execute/review/confirm"(platform:"/", type: TrackType.Event) {}

   "/insurtech/protections/claims/execute/congrats"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
        type_congrats(required: false, type: PropertyType.String, description: "Insurtech product type", values: ["success", "error"])
    }

    "/insurtech/protections/claims/execute/congrats/feedback"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
        type_congrats(required: false, type: PropertyType.String, description: "Congrats state", values: ["success", "error"])
    }

    "/insurtech/protections/claims/execute/certificate_update"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
    }
    "/insurtech/protections/claims/execute/certificate_update/confirm"(platform:"/", type: TrackType.Event) {}

    "/insurtech/protections/claims/execute/franchise"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_data(required: true, type: PropertyType.Map(product), description: "Product data")
    }
    "/insurtech/protections/claims/execute/franchise/confirm"(platform:"/", type: TrackType.Event) {}
    "/insurtech/protections/claims/execute/franchise/cancel"(platform:"/", type: TrackType.Event) {}
}
