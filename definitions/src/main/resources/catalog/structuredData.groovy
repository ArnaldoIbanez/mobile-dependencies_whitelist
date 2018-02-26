import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    propertyDefinitions {
        category_id(required: true, description: "Category ID")
        page(required: true, description: "Page")
        item_id(required: true, description: "Item ID")
        officialstore(required: true, description: "Seller is offical store")
        domain_id(required: true, description: "Domain ID")
        seller_id(required: true, description: "Seller ID")
        completeness_level(required: false, description: "Completeness level from [total, partial, total_pi, none]")
        items_left(required: true, description: "Items left on widget")
        missing_attributes(required: false, description: "Attributes left on item")
        pi(required:false, description: "Item has a Product Identifier")
        inferred_attributes(required: false, description: "Inferred attributes")
        condition(required: false, description: "Item condition")
    }

    propertyGroups {
        catalogWidgetGroup(category_id, page, item_id, officialstore, domain_id, seller_id, pi, condition)
        catalogWidgetCompletenessGroup(completeness_level, items_left, missing_attributes, inferred_attributes)
    }

    "/catalogwidget"(platform: "/", isAbstract: true) {}

    "/catalogwidget/show"(platform: "/") {
        catalogWidgetGroup
    }

    "/catalogwidget/showItem"(platform: "/") {
        catalogWidgetGroup
    }

    "/catalogwidget/save"(platform: "/") {
        catalogWidgetGroup
        catalogWidgetCompletenessGroup
    }

    "/catalogwidget/cancel"(platform: "/") {
        catalogWidgetGroup
        catalogWidgetCompletenessGroup
    }

    "/catalogwidget/cancel/forced"(platform: "/") {
        catalogWidgetGroup
        catalogWidgetCompletenessGroup
    }

    "/catalogwidget/minimize"(platform: "/") {
        catalogWidgetGroup
    }

    "/catalogwidget/maximize"(platform: "/") {
        catalogWidgetGroup
    }

    "/catalogwidget/omit"(platform: "/") {
        catalogWidgetGroup
    }

    "/catalogwidget/omit_save"(platform: "/") {
        catalogWidgetGroup
        items_left(required: false, description: "Items left on widget")
    }

    "/catalogwidget/discover"(platform: "/") {
        catalogWidgetGroup
    }

    "/catalogwidget/pi"(platform: "/") {
        catalogWidgetGroup
    }

    "/catalogwidget/pi_save"(platform: "/") {
        catalogWidgetGroup
    }

    "/catalogwidget/pi_cancel"(platform: "/") {
        catalogWidgetGroup
    }

    "/catalogwidget/next"(platform: "/") {
        catalogWidgetGroup
        catalogWidgetCompletenessGroup
    }

    "/catalogwidget/save_again"(platform: "/") {
        catalogWidgetGroup
        status_code(required: true, description: "Error code")
        error(required: true, description: "Error")
    }

    "/catalogwidget/redo"(platform: "/") {
        catalogWidgetGroup
        status_code(required: true, description: "Error code")
        error(required: true, description: "Error")
    }

    "/catalogwidget/middle_congrats"(platform: "/") {
        catalogWidgetGroup
        catalogWidgetCompletenessGroup
    }

    "/catalogwidget/final_congrats"(platform: "/") {
        catalogWidgetGroup
    }

    "/catalogwidget/coachmark"(platform: "/") {
        catalogWidgetGroup
    }

    "/catalogwidget/omit_attributes"(platform: "/") {
        catalogWidgetGroup
        empty_attrs_not_pk(required: false, description: "Quantity of attributes PK")
        empty_attrs_pk(required: false, description: "Quantity of attributes not PK")
    }

    "/catalogwidget/omit_attributes/submit"(platform: "/") {
        catalogWidgetGroup
        attribute_id(required: true, description: "Attribute id")
        hierarchy(required: true, description: "Hierarchy attribute")
        option_selected(required: true, description: "Radio option selected")
        value(required: true, description: "Omit value")
    }
}
