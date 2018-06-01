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
    }

    propertyGroups {
        catalogWidgetGroup(category_id, page, item_id, officialstore, domain_id, seller_id, pi, condition, category_path, label)
        catalogWidgetCompletenessGroup(completeness_level, items_left, missing_attributes, inferred_attributes)
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

    "/catalogwidget/final_congrats"(platform: "/",type: TrackType.Event) {
        catalogWidgetGroup
    }

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
        badItems(required: true, description:"True if the user has items with few attributes completed.", PropertyType.Boolean)
    }


}
