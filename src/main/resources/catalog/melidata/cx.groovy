package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1155"

    propertyDefinitions {
        portal_contact(required: true, type: PropertyType.Map,
            description: "Indicates if the current hub has channels enabled and why it hasn't")
        portal_content_id(required: true, type: PropertyType.Numeric,
            description: "Indicates the id of the content shown on the page")
        portal_content_type(
            required: false,
            type: PropertyType.String,
            values: [
                    "HOME", // Initial view with contentes rendered by the current context
                    "FOLDER", // Content that contains another contents
                    "RENDER", // Content that shows information, and maybe buttons to another contents or to talk with CX
                    "REDIRECT", // Content that allows to go outside the cx help
                    "SHOW_CONTACT" // Content that only has buttons to talk with CX
                ],
            description: "Indicates if it's a a simple content, a content with contact links to CX, etc. It's optional just because the migration to the new cx portal has several iterative steps, it's just starting. It we'll be mandatory in the future")
        portal_source_id(required: true, type: PropertyType.Numeric,
            description: "Indicates the source ID for the current page")
        portal_problem_id(required: false, type: PropertyType.Numeric,
            description: "Indicates the problem ID for the current page (only in widget)")
        portal_has_channels_configured(required: true, type: PropertyType.Boolean,
            description: "Indicates if the current content has any channels configured")
        portal_form_id(required: true, type: PropertyType.Numeric, 
            description: "Indicates the id of the form shown")
        portal_broken_link_error(required: false, type: PropertyType.Boolean,
            description: "Indicates if the link used is broken")
        portal_broken_link_source_url(required: false, type: PropertyType.String, 
            description: "Indicates the source url if when found a broken link")
        portal_broken_link_destination_url(required: false, type: PropertyType.String, 
            description: "Indicates the destination url if when found a broken link")
        portal_content_transactional_data(required: false, type: PropertyType.String, 
            description: "Indicates the transactional data include in a url")
        portal_effectivity_survey_value(required: false, type: PropertyType.Numeric,
            description: "Indicates the value of the effectivity survey given by a user to a certain faq")
        portal_search_criteria(required: false, type: PropertyType.String, 
            description: "Indicates the criteria used in the search in the help portal")
    }

    propertyGroups {
        portal_source_id(portal_source_id)
        portalContentTypeOptionalGroup(portal_content_type)
        portal_contact(portal_contact)
        portal_content_id(portal_content_id)
        portal_problem_id(portal_problem_id)
        portal_has_channels_configured(portal_has_channels_configured)
        portal_form_id(portal_form_id)
        portal_broken_link_error(portal_broken_link_error)
        portal_broken_link_source_url(portal_broken_link_source_url)
        portal_broken_link_destination_url(portal_broken_link_destination_url)
        portal_content_transactional_data(portal_content_transactional_data)
        portal_effectivity_survey_value(portal_effectivity_survey_value)
        portal_search_criteria(portal_search_criteria)
    }

    "/portal"(platform: "/", isAbstract:  true) {}

    "/portal/faq"(platform: "/", type: TrackType.View) {
        portal_has_channels_configured
        portal_content_id
        portal_source_id(required: false, type: PropertyType.Numeric,
            description: "Indicates the source ID for the current page. Required false because some faqs are contact points and most are not")
        portalContentTypeOptionalGroup
        portal_problem_id
        portal_contact(required: false, type: PropertyType.Map,
                description: "Indicates if the current hub has channels enabled and why it hasn't")
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/portal/faq/effectivity_survey/click"(platform: "/", type: TrackType.Event) {
        portal_effectivity_survey_value
    }

    "/portal/hub"(platform: "/", type: TrackType.View) {
        portal_contact
        portal_has_channels_configured(required: true, type: PropertyType.Boolean,
                description: "Indicates if the current content has any channels configured")
        portal_content_id(required: false, type: PropertyType.Numeric,
                description: "Indicates the content ID from where the user created a contact. Required false because some contacts do not come from contents")
        portal_source_id
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/portal/problem"(platform: "/", type: TrackType.View) {
        portal_content_id
        portalContentTypeOptionalGroup
        portal_source_id
        portal_problem_id
        portal_contact
        portal_has_channels_configured(required: false, type: PropertyType.Boolean,
                description: "Indicates if the current content has any channels configured")
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/portal/form"(platform: "/", type: TrackType.View) {
        portal_form_id
        portal_content_id(required: false, type: PropertyType.Numeric,
                description: "Indicates the content ID from where the user created a contact. Required false because some contacts do not come from contents")
        portal_source_id
        portalContentTypeOptionalGroup
        portal_problem_id
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/portal/folder"(platform: "/", type: TrackType.View) {
        portal_content_id(required: false, type: PropertyType.Numeric, description: "Indicates the id of the content shown on the page, in case its not the home page")
        portal_source_id(required: false, type: PropertyType.Numeric,
            description: "Indicates the source ID for the current page. Required false because some folders with exclusive attention are contact points and most are not")
        portalContentTypeOptionalGroup
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/portal/create_case"(platform: "/", type: TrackType.Event) {
        portal_form_id
        portal_content_id(required: false, type: PropertyType.Numeric,
                description: "Indicates the content ID from where the user created a contact. Required false because some contacts do not come from contents")
        portal_source_id
        portalContentTypeOptionalGroup
        portal_problem_id
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/portal/search"(platform: "/", type: TrackType.View) {
        portal_source_id(required: false, type: PropertyType.Numeric,
                description: "Indicates the source ID for the current page. Required false because some folders with exclusive attention are contact points and most are not")
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
        portal_search_criteria
    }

    "/portal/folder_rules"(platform: "/", type: TrackType.View) {
        portal_source_id(required: false, type: PropertyType.Numeric,
                description: "Indicates the source ID for the current page. Required false because some folders with exclusive attention are contact points and most are not")
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/portal/home"(platform: "/", type: TrackType.View) {
        portal_source_id(required: false, type: PropertyType.Numeric,
                description: "Indicates the source ID for the current page. Required false because some folders with exclusive attention are contact points and most are not")
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/portal/zrp"(platform: "/", type: TrackType.View) {
        portal_source_id(required: false, type: PropertyType.Numeric,
                description: "Indicates the source ID for the current page. Required false because some folders with exclusive attention are contact points and most are not")
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/portal/validate_user"(platform: "/", type: TrackType.View) {}

    // Support Widget

    "/support"(platform: "/", isAbstract:  true) {}
    "/support/widget"(platform: "/", isAbstract:  true) {}

    "/support/widget/folder"(platform: "/", type: TrackType.View) {
        portal_content_id(required: false, type: PropertyType.Numeric, description: "Indicates the id of the content shown on the page, in case its not the home page")
        portalContentTypeOptionalGroup
        portal_source_id
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/support/widget/folder/click"(platform: "/", type: TrackType.Event) {
        portal_content_transactional_data
    }

    "/support/widget/folder_rules"(platform: "/", type: TrackType.View) {
        portal_source_id
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }
    "/support/widget/folder_rules/click"(platform: "/", type: TrackType.Event) {
        portal_content_transactional_data
    }

    "/support/widget/home"(platform: "/", type: TrackType.View) {
        portal_source_id(required: false, type: PropertyType.Numeric, description: "Indicates the source ID for the current page. Required false because some folders with exclusive attention are contact points and most are not")
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/support/widget/zrp"(platform: "/", type: TrackType.View) {
        portal_source_id(required: false, type: PropertyType.Numeric, description: "Indicates the source ID for the current page. Required false because some folders with exclusive attention are contact points and most are not")
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/support/widget/faq"(platform: "/", type: TrackType.View) {
        portal_content_id
        portalContentTypeOptionalGroup
        portal_source_id
        portal_has_channels_configured
        portal_problem_id
        portal_contact(required: false, type: PropertyType.Map,
                description: "Indicates if the current hub has channels enabled and why it hasn't")
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/support/widget/faq/click"(platform: "/", type: TrackType.Event) {
        portal_content_transactional_data
    }

    "/support/widget/faq/effectivity_survey/click"(platform: "/", type: TrackType.Event) {
        portal_effectivity_survey_value
    }

    "/support/widget/problem"(platform: "/", type: TrackType.View) {
        portal_content_id
        portalContentTypeOptionalGroup
        portal_source_id
        portal_problem_id
        portal_contact
        portal_has_channels_configured(required: false, type: PropertyType.Boolean,
                description: "Indicates if the current content has any channels configured")
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/support/widget/form"(platform: "/", type: TrackType.View) {
        portal_content_id
        portalContentTypeOptionalGroup
        portal_source_id
        portal_form_id
        portal_problem_id
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/support/widget/create_case"(platform: "/", type: TrackType.Event) {
        portal_content_id
        portalContentTypeOptionalGroup
        portal_source_id
        portal_form_id
        portal_problem_id
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/support/widget/search"(platform: "/", type: TrackType.View) {
        portal_source_id
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    // Mis Consultas

    "/support/cases"(platform: "/", type: TrackType.View) {}

    "/support/cases/detail"(platform: "/", type: TrackType.View) {
        case_status(required: true, type: PropertyType.String,
            values: ["pending", "waiting_for_info", "waiting_for_external", "waiting_for_fix", "fixed", "final_answer", "finished_no_answer", "duplicated", "finished", "final_greetings", "final_closed"],
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
            values: ["new_information", "greetings", "recontact"],
            description: "Contact type")
    }
}
