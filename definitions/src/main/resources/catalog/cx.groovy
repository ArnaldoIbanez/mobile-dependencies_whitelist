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
        portal_contact(required: false, type: PropertyType.String,
                description: "Indicates if the current hub has channels enabled and why it hasn't")
        portal_content_id(required: false, type: PropertyType.Numeric,
                description: "Indicates the id of the content shown on the page")
        portal_source_id(required: false, type: PropertyType.Numeric,
                description: "Indicates the source ID for the current page")
        portal_problem_id(required: false, type: PropertyType.Numeric,
                description: "Indicates the problem ID for the current page (only in widget)")
        portal_has_channels_configured(required: false, type: PropertyType.Boolean,
                description: "Indicates if the current content has any channels configured")
        portal_form_id(required: false, type: PropertyType.Numeric, 
                description: "Indicates the id of the form shown")
    }

    propertyGroups {
        portal_default(portal_contact,portal_content_id, portal_form_id, portal_has_channels_configured, portal_problem_id, portal_source_id)
        portal_source_id(portal_source_id)
        portal_contact(portal_contact)
        portal_content_id(portal_content_id)
        portal_problem_id(portal_problem_id)
        portal_has_channels_configured(portal_has_channels_configured)
        portal_form_id(portal_form_id)
    }

    "/portal"(platform: "/", isAbstract:  true) {}

    "/portal/faq"(platform: "/", type: TrackType.View) {
        portal_default
    }
    "/portal/hub"(platform: "/", type: TrackType.View) {
        portal_default
        portal_form_id    
    }
    "/portal/form"(platform: "/", type: TrackType.View) {
        portal_default
        portal_form_id
    }
    "/portal/folder"(platform: "/", type: TrackType.View) {
        portal_default
    }
    "/portal/create_case"(platform: "/", type: TrackType.View) {
        portal_default
    }

    "/support"(platform: "/", isAbstract:  true) {}
    "/support/widget"(platform: "/", isAbstract:  true) {}

    "/support/widget/folder"(platform: "/", type: TrackType.View) {
        portal_source_id
    }

    "/support/widget/faq"(platform: "/", type: TrackType.View) {
        portal_content_id
        portal_source_id
        portal_has_channels_configured
    }

    "/support/widget/problem"(platform: "/", type: TrackType.View) {
        portal_content_id
        portal_source_id
        portal_problem_id
    }

    "/support/widget/form"(platform: "/", type: TrackType.View) {
        portal_content_id
        portal_source_id
        portal_form_id
        portal_problem_id
    }
}
