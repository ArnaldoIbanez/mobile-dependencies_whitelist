package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1171"

    propertyDefinitions {
        transactional_type(required: true, type: PropertyType.String, values: ["STOCK", "SHIPPING", "INTEREST", "CASH", "INSTALLMENT", "BILLING", "WARRANTY"], description: "Type of the transacional result")
    }

    propertyGroups {
        transactional_types(transactional_type)
    }

    def answer = objectSchemaDefinitions {
        answer_id(required: true, type: PropertyType.Numeric)
    }

    def question_result = objectSchemaDefinitions {
        question_id(required: true, type: PropertyType.Numeric)
        answers(required: true, type: PropertyType.ArrayList(PropertyType.Map(answer)))
    }

    def transactional_result = objectSchemaDefinitions {
        transactional_types
    }

    "/questions/qadb"(platform: "/", isAbstract: true) {}

    "/questions/qadb/view"(platform: "/", type: TrackType.Event) {
        catalog_product_id(required: true, type: PropertyType.String)
        catalog_parent_id(required: false, type: PropertyType.String)
        item_id(required: true, type: PropertyType.String)
        results(required: false, type: PropertyType.ArrayList(PropertyType.Map(question_result)), description: "Initial results")
        context(required: true, type: PropertyType.String, description: "If the context is pdp or vip", values:["PDP", "VIP"])
    }

    "/questions/qadb/show"(platform: "/", type: TrackType.View) {
        catalog_product_id(required: false, type: PropertyType.String)
        catalog_parent_id(required: false, type: PropertyType.String)
        item_id(required: true, type: PropertyType.String)
        results(required: false, type: PropertyType.ArrayList(PropertyType.Map(question_result)), description: "Initial results")
        context(required: true, type: PropertyType.String, description: "If the context is pdp or vip", values:["PDP", "VIP"])
    }

    "/questions/qadb/search"(platform: "/", type: TrackType.Event) {
        catalog_product_id(required: false, type: PropertyType.String)
        catalog_parent_id(required: false, type: PropertyType.String)
        item_id(required: true, type: PropertyType.String)
        results(required: false, type: PropertyType.ArrayList(PropertyType.Map(question_result)), description: "Initial results")
        query(required: true, type: PropertyType.String, description: "Search query")
        transactional_results(required: false, type: PropertyType.ArrayList(PropertyType.Map(transactional_result)))
        intentions(required: false, type: PropertyType.ArrayList(PropertyType.Map(transactional_result)))
        context(required: true, type: PropertyType.String, description: "If the context is pdp or vip", values:["PDP", "VIP"])
    }

    "/questions/qadb/feedback"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String)
        catalog_parent_id(required: false, type: PropertyType.String)
        item_id(required: true, type: PropertyType.String)
        query(required: true, type: PropertyType.String, description: "Search query")
        transactional_types
        feedbackMessage(required: true, type: PropertyType.Boolean, description: "Like or dislike of the feedback")
    }

    "/questions/qadb/see_more"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String)
        catalog_parent_id(required: false, type: PropertyType.String)
        item_id(required: true, type: PropertyType.String)
        query(required: true, type: PropertyType.String, description: "Search query")
        see_more_limit(required: true, type: PropertyType.Numeric, description: "Quantity of inital visible answers")
        total_answers(required: true, type: PropertyType.Numeric, description: "Quantity of total answers")
        context(required: true, type: PropertyType.String, description: "If the context is pdp or vip", values:["PDP", "VIP"])
    }

    "/questions/qadb/more_info"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String)
        catalog_parent_id(required: false, type: PropertyType.String)
        item_id(required: true, type: PropertyType.String)
        query(required: true, type: PropertyType.String, description: "Search query")
        transactional_types
        context(required: true, type: PropertyType.String, description: "If the context is pdp or vip", values:["PDP", "VIP"])
    }

    "/questions/qadb/input_focus"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String)
        catalog_parent_id(required: false, type: PropertyType.String)
        item_id(required: true, type: PropertyType.String)
        context(required: true, type: PropertyType.String, description: "If the context is pdp or vip", values:["PDP", "VIP"])
    }

    "/questions/qadb/question"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String)
        catalog_parent_id(required: false, type: PropertyType.String)
        item_id(required: true, type: PropertyType.String)
        query(required: true, type: PropertyType.String, description: "Search query")
        context(required: true, type: PropertyType.String, description: "If the context is pdp or vip", values:["PDP", "VIP"])
    }

    "/questions/qadb/smart_vs_modal"(platform: "/", parentPropertiesInherited: false) {
        catalog_product_id(required: true, type: PropertyType.String)
        catalog_parent_id(required: false, type: PropertyType.String)
        item_id(required: true, type: PropertyType.String)
        context(required: true, type: PropertyType.String, description: "If the context is pdp or vip", values:["PDP", "VIP"])
    }
}