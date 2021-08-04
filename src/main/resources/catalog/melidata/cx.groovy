package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1155"

    def helpCardContent = objectSchemaDefinitions {
        title(required: false, type: PropertyType.String, description: "Title of the content")
        redirect_url(required: false, type: PropertyType.String, description:  "Redirect url of the content")
        directAccess(required: false, type: PropertyType.Map, description: "Configuration to open a direct access to support widget")
    }

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
                    "SHOW_CONTACT", // Content that only has buttons to talk with CX
                    "FOLDER_DYNAMIC"  // Content that contains other dynamic contents
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
        portal_custom_order_id(required: false, type: PropertyType.Numeric, 
            description: "Indicates the order shown to the user according to the predicted problem")
        portal_custom_orders_ids(required: false, type: PropertyType.ArrayList(PropertyType.Numeric),
            description: "Indicates the cancelled orders shown to the user")
        portal_prediction_id(required: false, type: PropertyType.Numeric,
            description: "Indicates the id of the prediction for the user problem")        
        portal_content_destination_url(required: false, type: PropertyType.String, 
            description: "Indicates the destination url in an event track")
        portal_show_cancel_card(required: false, type: PropertyType.Boolean, 
            description: "Indicates if the cancelCard should be shown")
        portal_show_delay_cards(required: false, type: PropertyType.Boolean, 
            description: "Indicates if the delayCard should be shown")
        portal_has_one_click(required: true, type: PropertyType.Boolean,
            description: "Indicates if the user has oneclick enabled")
        portal_contact_predicted_team(required: false, type: PropertyType.String,
            description: "Indicates the team with which the user should contact")
        portal_contact_prediction_score(required: false, type: PropertyType.Numeric,
            description: "Indicates the score of the prediction for the contact")
        portal_contact_predicted_problem_id(required: false, type: PropertyType.Numeric,
            description: "Indicates the problem with which the user should contact")
        portal_predicted_features(required: false, type: PropertyType.Map,
            description: "Indicates the features used in the prediction")
        portal_predicted_contents(required: false, type: PropertyType.ArrayList(PropertyType.Numeric),
            description: "Indicates the ids of the contents predicted to a user")
        helpcard_contents(required: true, type: PropertyType.ArrayList(PropertyType.Map(helpCardContent)),
            description: "Indicates the contents viewed by the user in the help card")
        portal_contents_result(required: true, description: "Content ids result from search page", type: PropertyType.ArrayList)
        portal_delayed_pack_id(required: true, type: PropertyType.Numeric,
            description: "Indicates the single pack id of the card clicked by the user")
        portal_delayed_packs_ids(required: false, type: PropertyType.ArrayList(PropertyType.Numeric),
            description: "Indicates the delayed packs shown to the user")
        portal_oneclick_cluster_id(required: false, type: PropertyType.Numeric,
            description: "Indicates the cluster of the oneclick prediction for a user")
        portal_oneclick_contents_predicted(required: false, type: PropertyType.ArrayList(PropertyType.Numeric),
            description: "Indicates the contents of oneclick predicted for a user")
        portal_oneclick_features(required: false, type: PropertyType.Map,
            description: "Indicates the features used in the oneclick prediction")
        user_text(required: true, type: PropertyType.String,
            description: "Text entered by user in oneclick MP contact")
        team_name(required: true, type: PropertyType.String,
            description: "Team predicted by NLP algorithm")
        score(required: true, type: PropertyType.Numeric, description: "Score of NLP prediction")
        problem_id(required: true, type: PropertyType.Numeric, description: "ProblemId predicted by NLP algorithm")
        case_id(required: true, type: PropertyType.Numeric, description: "Id of case created")
        list_skip_button(required: true, type: PropertyType.Boolean, description: "Indicates if the list was skipped without selecting an item")
        list_type(required: true, type: PropertyType.String, description: "Indicates the content of the list")
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
        portal_custom_order_id(portal_custom_order_id)
        portal_custom_orders_ids(portal_custom_orders_ids)
        portal_prediction_id(portal_prediction_id)
        portal_content_destination_url(portal_content_destination_url)
        portal_show_cancel_card(portal_show_cancel_card)
        portal_show_delay_cards(portal_show_delay_cards)
        portal_has_one_click(portal_has_one_click)
        portal_contact_predicted_team(portal_contact_predicted_team)
        portal_contact_prediction_score(portal_contact_prediction_score)
        portal_contact_predicted_problem_id(portal_contact_predicted_problem_id)
        portal_predicted_features(portal_predicted_features)
        portal_predicted_contents(portal_predicted_contents)
        helpcard_data(portal_source_id, helpcard_contents)
        portal_contents_result(portal_contents_result)
        portal_delayed_pack_id(portal_delayed_pack_id)
        portal_delayed_packs_ids(portal_delayed_packs_ids)
        portal_oneclick_cluster_id(portal_oneclick_cluster_id)
        portal_oneclick_contents_predicted(portal_oneclick_contents_predicted)
        portal_oneclick_features(portal_oneclick_features)
        user_text(user_text)
        team_name(team_name)
        score(score)
        problem_id(problem_id)
        case_id(case_id)
        list_skip_button(list_skip_button)
        list_type(list_type)
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

    "/portal/faq/click"(platform: "/", type: TrackType.View) {
        portal_content_transactional_data
        portal_content_destination_url
    }

    "/portal/faq/effectivity_survey"(platform: "/", isAbstract:  true) {}
    "/portal/faq/effectivity_survey/click"(platform: "/", type: TrackType.Event) {
        portal_content_transactional_data
        portal_effectivity_survey_value
        portal_content_destination_url
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

    "/portal/folder/click"(platform: "/", type: TrackType.Event) {
        portal_content_transactional_data
        portal_content_destination_url
    }

    "/portal/action"(platform: "/", isAbstract:  true) {}

    "/portal/action/click"(platform: "/", type: TrackType.Event) {
        portal_content_id
        portal_content_destination_url
        portal_problem_id
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
        portal_contents_result
    }

    "/portal/search/click"(platform: "/", type: TrackType.Event) {
        portal_contents_result(required: false, type: PropertyType.ArrayList, description: "Content ids result from search page")
        portal_content_id
        portal_source_id
    }

    "/portal/folder_rules"(platform: "/", type: TrackType.View) {
        portal_source_id(required: false, type: PropertyType.Numeric,
                description: "Indicates the source ID for the current page. Required false because some folders with exclusive attention are contact points and most are not")
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/portal/folder_rules/click"(platform: "/", type: TrackType.Event) {
        portal_content_transactional_data
        portal_content_destination_url
    }

    "/portal/home"(platform: "/", type: TrackType.View) {
        portal_source_id(required: false, type: PropertyType.Numeric,
                description: "Indicates the source ID for the current page. Required false because some folders with exclusive attention are contact points and most are not")
        portal_predicted_label(required: false, type: PropertyType.String,
                description: "Field that sometimes is required in catalog, but not always. Indicates the predicted label of the user")
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
        portal_show_cancel_card
        portal_show_delay_cards
        portal_delayed_packs_ids
        portal_custom_orders_ids
        portal_prediction_id
        portal_has_one_click
        portal_predicted_contents
        portal_oneclick_cluster_id
        portal_oneclick_contents_predicted
        portal_oneclick_features
    }

    "/portal/zrp"(platform: "/", type: TrackType.View) {
        portal_source_id(required: false, type: PropertyType.Numeric,
                description: "Indicates the source ID for the current page. Required false because some folders with exclusive attention are contact points and most are not")
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }

    "/portal/validate_user"(platform: "/", type: TrackType.View) {}

    "/portal/cancel_card"(platform: "/", type: TrackType.Event) {
        portal_source_id
        portal_custom_order_id
        portal_prediction_id
        portal_predicted_label
    }

    "/portal/delay_card"(platform: "/", type: TrackType.Event) {
        portal_source_id
        portal_delayed_pack_id
    }

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
        portal_content_destination_url
    }

    "/support/widget/folder_rules"(platform: "/", type: TrackType.View) {
        portal_source_id
        portal_broken_link_error
        portal_broken_link_source_url
        portal_broken_link_destination_url
    }
    "/support/widget/folder_rules/click"(platform: "/", type: TrackType.Event) {
        portal_content_transactional_data
        portal_content_destination_url
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
        portal_content_destination_url
    }
    "/support/widget/faq/effectivity_survey"(platform: "/", isAbstract:  true) {}
    "/support/widget/faq/effectivity_survey/click"(platform: "/", type: TrackType.Event) {
        portal_content_transactional_data
        portal_effectivity_survey_value
        portal_content_destination_url
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
        portal_contact_predicted_team
        portal_contact_prediction_score
        portal_contact_predicted_problem_id
        portal_predicted_features
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

    "/support/widget/list"(platform: "/", isAbstract:  true) {}

    "/support/widget/list/click"(platform: "/", type: TrackType.Event) {
        list_skip_button
        list_type
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

    "/support/cases/nlp"(platform: "/", type: TrackType.Event) {
        user_text
        team_name
        score
        problem_id
        case_id
    }


    "/support/cases/new_contact"(platform: "/", type: TrackType.Event) {
        case_id(required: true, type: PropertyType.Numeric,
            description: "CX case id")
        type(required: true, type: PropertyType.String, 
            values: ["new_information", "greetings", "recontact"],
            description: "Contact type")
    }

    // Daisy
    "/support/helpcard"(platform: "/", type: TrackType.View) {} 

    "/support/helpcard/contents"(platform: "/", type: TrackType.View) {
        helpcard_data
    }
}
