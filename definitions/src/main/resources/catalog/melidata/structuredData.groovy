import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType


tracks {

    propertyDefinitions {
        category_id(required: true, description: "Category ID")
        page(required: true, description: "Page")
        item_id(required: true, description: "Item ID")
        officialstore(required: true, description: "Seller is offical store")
        domain_id(required: false, description: "Domain ID")
        seller_id(required: true, description: "Seller ID")
        completeness_level(required: false, description: "Completeness level from [total, partial, total_pi, none]")
        items_left(required: true, description: "Items left on widget")
        missing_attributes(required: false, description: "Attributes left on item")
        pi(required:false, description: "Item has a Product Identifier")
        inferred_attributes(required: false, description: "Inferred attributes")
        condition(required: false, description: "Item condition")
        category_path(required: true, description: "Category path for the item", type: PropertyType.ArrayList)
        label(required: false, description: "Tab from listings page", type: PropertyType.String, values: ["paused", "active", "closed","pending"])
        attribute_type(required: true, description:"If its an item_attribute, a variation_attribute or an allow_variation_attribute", type:PropertyType.String, values: ["item_attribute","variation_attribute","allow_variation_attribute"])
        attributes_showed(required: false, description:"Number of attributes showed", type: PropertyType.Numeric)
        attributes_submitted(required: false, description:"Number of attributes submitted", type: PropertyType.Numeric)
    }

    propertyGroups {
        catalogWidgetGroup(category_id, page, item_id, officialstore, domain_id, seller_id, pi, condition, category_path, label,attribute_type, attributes_showed)
        catalogWidgetCompletenessGroup(completeness_level, attributes_submitted, items_left, missing_attributes, inferred_attributes)
    }

    "/catalogwidget"(platform: "/", isAbstract: true, type: TrackType.Event) {}

    "/catalogwidget/show"(platform: "/", type: TrackType.Event) {
        catalogWidgetGroup
    }

    "/catalogwidget/showitem"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
    }

    "/catalogwidget/save"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
        catalogWidgetCompletenessGroup
    }

    "/catalogwidget/cancel"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
        catalogWidgetCompletenessGroup
    }

    "/catalogwidget/cancel/forced"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
        catalogWidgetCompletenessGroup
    }

    "/catalogwidget/minimize"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
    }

    "/catalogwidget/maximize"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
    }

    "/catalogwidget/omit"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
    }

    "/catalogwidget/omit_save"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
        items_left(required: false, description: "Items left on widget")
    }

    "/catalogwidget/discover"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
    }

    "/catalogwidget/pi"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
    }

    "/catalogwidget/pi_save"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
    }

    "/catalogwidget/pi_cancel"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
    }

    "/catalogwidget/next"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
        catalogWidgetCompletenessGroup
    }

    "/catalogwidget/save_again"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
        status_code(required: true, description: "Error code")
        error(required: true, description: "Error")
    }

    "/catalogwidget/redo"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
        status_code(required: true, description: "Error code")
        error(required: true, description: "Error")
    }

    "/catalogwidget/middle_congrats"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
        catalogWidgetCompletenessGroup
    }

    "/catalogwidget/final_congrats"(platform: "/",type: TrackType.Event) {}

    "/catalogwidget/coachmark"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
    }

    "/catalogwidget/omit_attributes"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
        empty_attrs_not_pk(required: false, description: "Quantity of attributes PK")
        empty_attrs_pk(required: false, description: "Quantity of attributes not PK")
    }

    "/catalogwidget/omit_attributes/submit"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
        attribute_id(required: true, description: "Attribute id submitted")
        hierarchy(required: true, description: "Hierarchy attribute", values:["CHILD_DEPENDENT", "CHILD_PK", "FAMILY", "ITEM", "PARENT_PK", "PRODUCT_IDENTIFIER"], PropertyType.String)
        option_selected(required: true, description: "Radio option selected", values:["completed", "no_data", "not_possible", "other"], PropertyType.String)
        value(required: false, description: "Value submitted on feedback or value for attribute", PropertyType.String)
        domain_id(required: true, description: "Domain ID from attribute", PropertyType.String)
        category_path(required: true, description: "Category path", type: PropertyType.ArrayList)
    }

    "/catalogwidget/welcome"(platform: "/",isAbstract: true) {}

    "/catalogwidget/welcome/leaders"(platform: "/",isAbstract: true) {}

    "/catalogwidget/welcome/leaders/show"(platform: "/",type: TrackType.View) {}

    "/catalogwidget/welcome/leaders/continue"(platform: "/",type: TrackType.Event) {}

    "/catalogwidget/welcome/leaders/omit"(platform: "/",type: TrackType.Event) {}

    "/catalogwidget/welcome/leaders/close"(platform: "/",type: TrackType.Event) {}




    //Tracks for Massive Attribute Editor
    "/bulk_attributes"(platform: "/",isAbstract: true) {}
    "/bulk_attributes/incomplete"(platform: "/",isAbstract: true) {}

    "/bulk_attributes/incomplete/save" (platform: "/web",type: TrackType.Event) {
        campaignId(required: true, description: "Campaign id to know from where the user came")
        totalItems(required: true, description: "Total of items that the user could update")
        updatedItems(required: true, description: "Total of updated items in Massive Attribute Editor")
        badItems(required: false, description:"True if the user has items with few attributes completed.", PropertyType.Boolean)
    }

    "/structure_data"(platform: "/", isAbstract: true) {}
    "/structure_data/product_creator"(platform: "/",isAbstract: true) {}
    "/structure_data/product_creator/other_domain"(platform: "/", type: TrackType.Event) {
        bs_user_email(required: true, description: "Email of brightsector user")
        score(required: true, description: "Score of zordon api")
        is_same_domain(required: true, description:"Must keep or not in this domain", PropertyType.Boolean)
        domain_id(required: true, description: "Current domain")
        suggested_domain(required: true, description: "Suggested domain")
        item_id(required: true, description: "Item Id")
        user_action(required: true, description: "Action taken by user")
    }
    "/structure_data/product_creator/ignored_hints"(platform: "/", type: TrackType.Event) {
        bs_user(required: true, description: "Brightsector user")
        domain_id(required: true, description: "Current domain")
        hint_id(required: true, description: "Hint Id")
        attribute(required: true, description: "Attribute Id")
        lang(required: true, description: "Language")
        suggested_value_id(required: true, description: "Suggested hint value Id")
        suggested_value_name(required: true, description: "Suggested hint value name")
        written_value(required: true, description: "Written attribute value")
        final_value(required: true, description: "Final attribute value")
    }
    "/structure_data/product_reviewer"(platform: "/",isAbstract: true) {}
    "/structure_data/product_reviewer/review"(platform: "/", type: TrackType.Event) {
         review_id(required: true, description: "Review Id", type: PropertyType.String)
         review_version(required: true, description: "Reviews version", type: PropertyType.Numeric)
         sheet_id(required: true, description: "Sheet reviewed", type: PropertyType.String)
         domain_id(required: true, description: "Sheets domain reviewed", type: PropertyType.String)
         publication_id(required: true, description: "Item reviewed", type: PropertyType.String)
         review_status(required: true, description: "Reviews result", values: ["APPROVED", "REJECTED", "PENDING"], type: PropertyType.String) 
         action_tag(required: true, description: "Publications tag", values: ["ADD", "REP", "NPP"], type: PropertyType.String) 
         time(required: true, description: "Time reviewing the item", type: PropertyType.Numeric)
         date(required: true, description: "Reviews date", type: PropertyType.String)
         user_id(required: true, description: "User id", type: PropertyType.String)
         user_initials(required: true, description: "User initials", type: PropertyType.String)
         sections_comments(required: true, description: "Reviews comments", type: PropertyType.String)
         errors_codes(required: true, description: "Reviews errors codes", type: PropertyType.String)
     }
}