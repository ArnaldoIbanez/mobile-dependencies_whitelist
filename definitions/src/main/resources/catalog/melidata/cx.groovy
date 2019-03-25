import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    "/cx" (platform: "/mobile", isAbstract: true){}
    "/cx/click_on_article" (platform: "/mobile", type: TrackType.Event){
        article_id(required: true, type: PropertyType.String)
    }
    "/cx/click_on_help" (platform: "/mobile", type: TrackType.Event){}
    "/cx/click_on_error" (platform: "/mobile", type: TrackType.Event){}
    "/cx/click_on_suggestion" (platform: "/mobile", type: TrackType.Event){}
    "/cx/contact_types" (platform: "/mobile", isAbstract: true){}
    "/cx/contact_types/click_on_contact_form" (platform: "/mobile", type: TrackType.Event){}

    propertyDefinitions {
        portal_contact(required: true, type: PropertyType.Map,
            description: "Indicates if the current hub has channels enabled and why it hasn't")
        portal_content_id(required: true, type: PropertyType.Numeric,
            description: "Indicates the id of the content shown on the page")
        portal_source_id(required: true, type: PropertyType.Numeric,
            description: "Indicates the source ID for the current page")
        portal_problem_id(required: false, type: PropertyType.Numeric,
            description: "Indicates the problem ID for the current page (only in widget)")
        portal_has_channels_configured(required: true, type: PropertyType.Boolean,
            description: "Indicates if the current content has any channels configured")
        portal_form_id(required: true, type: PropertyType.Numeric, 
            description: "Indicates the id of the form shown")
        user_type(required: true, 
            description: "The type of User that opened the page", 
            values: ["car_dealer", "normal", "real_estate_agency", "branch", "franchise", "brand", "unknown"])
        reputation_level(required: false, type: PropertyType.String,
            values: ["1_red", "2_orange", "3_yellow", "4_light_green", "5_green"],
            description: "Seller's reputation level")
        seller_profile(required: true, type: PropertyType.String, 
            description: "Type of seller")
        loyalty_level(required:true, 
            description:"The loyalty level of the buyer")
        user_profile(required:false, 
            description:"CX Channel's user profile")
    }

    propertyGroups {
        portal_default(portal_contact,portal_content_id, portal_form_id, portal_has_channels_configured, portal_problem_id, portal_source_id)
        portal_source_id(portal_source_id)
        portal_contact(portal_contact)
        portal_content_id(portal_content_id)
        portal_problem_id(portal_problem_id)
        portal_has_channels_configured(portal_has_channels_configured)
        portal_form_id(portal_form_id)
        user_type(user_type)
        reputation_level(reputation_level)
        seller_profile(seller_profile)
        loyalty_level(loyalty_level)
        user_profile(user_profile)
    }

    "/portal"(platform: "/", isAbstract:  true) {}

    // ML Portal

    "/portal/faq"(platform: "/", business: "mercadolibre", type: TrackType.View) {
        portal_contact
        user_type
        reputation_level
        seller_profile
        portal_has_channels_configured
        loyalty_level
        portal_content_id
        portal_source_id(required: false, type: PropertyType.Numeric,
            description: "Indicates the source ID for the current page. Required false because some faqs are contact points and most are not")
    }
    "/portal/hub"(platform: "/", business: "mercadolibre", type: TrackType.View) {
        portal_contact
        user_type
        reputation_level
        seller_profile
        loyalty_level
        user_profile   
        portal_content_id
        portal_has_channels_configured(required: true, type: PropertyType.Boolean,
            description: "Indicates if the current content has any channels configured")
    }
    "/portal/form"(platform: "/", business: "mercadolibre", type: TrackType.View) {
        portal_contact
        user_type
        reputation_level
        portal_form_id
        seller_profile
        loyalty_level
        portal_content_id
        portal_has_channels_configured(required: true, type: PropertyType.Boolean,
            description: "Indicates if the current content has any channels configured")
    }
    "/portal/folder"(platform: "/", business: "mercadolibre", type: TrackType.View) {
        portal_content_id(required: false, type: PropertyType.Numeric, description: "Indicates the id of the content shown on the page, in case its not the home page")
        portal_contact
        user_type
        reputation_level
        seller_profile
        loyalty_level
        user_profile
        portal_source_id(required: false, type: PropertyType.Numeric,
            description: "Indicates the source ID for the current page. Required false because some folders with exclusive attention are contact points and most are not")
        portal_has_channels_configured(required: false, type: PropertyType.Boolean,
            description: "Indicates if the current content has any channels configured, not required for home page")
    }
    "/portal/create_case"(platform: "/", business: "mercadolibre", type: TrackType.View) {
        user_type
        seller_profile
        reputation_level
        portal_contact
        loyalty_level
    }
    "/portal/search"(platform: "/", business: "mercadolibre", isAbstract:  true) {}
    "/portal/folder_rules"(platform: "/", business: "mercadolibre", type: TrackType.View) {}
    "/portal/search/empty"(platform: "/", business: "mercadolibre", type: TrackType.View) {
        user_type
        seller_profile
        reputation_level
        portal_contact
        portal_has_channels_configured
        loyalty_level
    }
    "/portal/search/result"(platform: "/", business: "mercadolibre", type: TrackType.View) {
        user_type
        seller_profile
        reputation_level
        portal_contact
        portal_has_channels_configured
        loyalty_level
    }

    // MP Portal

    "/portal/faq"(platform: "/", business: "mercadopago", type: TrackType.View) {
        portal_contact
        portal_has_channels_configured
        portal_content_id
        portal_source_id(required: false, type: PropertyType.Numeric,
            description: "Indicates the source ID for the current page. Required false because some faqs are contact points and most are not")
    }
    "/portal/hub"(platform: "/", business: "mercadopago", type: TrackType.View) {
        portal_contact
        user_profile   
        portal_content_id
        portal_has_channels_configured(required: true, type: PropertyType.Boolean,
            description: "Indicates if the current content has any channels configured")
    }
    "/portal/form"(platform: "/", business: "mercadopago", type: TrackType.View) {
        portal_contact
        portal_form_id
        portal_content_id
        portal_has_channels_configured(required: true, type: PropertyType.Boolean,
            description: "Indicates if the current content has any channels configured")
    }
    "/portal/folder"(platform: "/", business: "mercadopago", type: TrackType.View) {
        portal_content_id(required: false, type: PropertyType.Numeric, description: "Indicates the id of the content shown on the page, in case its not the home page")
        portal_contact
        user_profile
        portal_has_channels_configured(required: false, type: PropertyType.Boolean,
            description: "Indicates if the current content has any channels configured, not required for home page")
    }
    "/portal/create_case"(platform: "/", business: "mercadopago", type: TrackType.View) {
        portal_contact
    }
    "/portal/search"(platform: "/", business: "mercadopago", isAbstract:  true) {}
    "/portal/folder_rules"(platform: "/", business: "mercadopago", type: TrackType.View) {}
    "/portal/search/empty"(platform: "/", business: "mercadopago", type: TrackType.View) {
        portal_contact
        portal_has_channels_configured
    }
    "/portal/search/result"(platform: "/", business: "mercadopago", type: TrackType.View) {
        portal_contact
        portal_has_channels_configured
    }

    // Support Widget

    "/support"(platform: "/", isAbstract:  true) {}
    "/support/widget"(platform: "/", isAbstract:  true) {}

    "/support/widget/folder"(platform: "/", type: TrackType.View) {
        portal_source_id
    }

    "/support/widget/faq"(platform: "/", type: TrackType.View) {
        portal_content_id
        portal_source_id
        portal_has_channels_configured
        portal_problem_id
        portal_contact(required: false, type: PropertyType.Map,
                description: "Indicates if the current hub has channels enabled and why it hasn't")
    }

    "/support/widget/problem"(platform: "/", type: TrackType.View) {
        portal_content_id
        portal_source_id
        portal_problem_id
        portal_contact
        portal_has_channels_configured(required: false, type: PropertyType.Boolean,
                description: "Indicates if the current content has any channels configured")
    }

    "/support/widget/form"(platform: "/", type: TrackType.View) {
        portal_content_id
        portal_source_id
        portal_form_id
        portal_problem_id
    }

    // Mis Consultas

    "/support/cases"(platform: "/", isAbstract: true) {}

    "/support/cases/detail"(platform: "/", type: TrackType.View) {
        case_status(required: true, type: PropertyType.String,
            values: ["pending", "waiting_for_info", "waiting_for_external", "waiting_for_fix", "fixed", "final_answer", "finished_no_answer", "duplicated", "finished", "final_greetings"],
            description: "Case status")
        case_id(required: true, type: PropertyType.Numeric,
            description: "CX case id")
        has_parent(required: true, type: PropertyType.Boolean,
            description: "If current case has parent")
        parent_id(required: false, type: PropertyType.Numeric,
            description: "If it has a parent, this is my parent id")
        expired(required: true, type: PropertyType.Boolean,
            description: "Case has SLA expired")
    }

    "/support/cases/new_contact"(platform: "/", type: TrackType.Event) {
        case_id(required: true, type: PropertyType.Numeric,
            description: "CX case id")
        type(required: true, type: PropertyType.String, 
            values: ["more_information", "greetings", "recontact"],
            description: "Contact type")
    }
}
