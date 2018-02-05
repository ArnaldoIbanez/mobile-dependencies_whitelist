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
    }

    propertyGroups {
        catalogWidgetGroup(category_id, page, item_id, officialstore, domain_id, seller_id, pi)
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

    "/catalogwidget/minimize"(platform: "/") {
        catalogWidgetGroup
    }

    "/catalogwidget/maximize"(platform: "/") {
        catalogWidgetGroup
    }

    "/catalogwidget/omit"(platform: "/") {
        catalogWidgetGroup
        catalogWidgetCompletenessGroup
    }

    "/catalogwidget/omit_save"(platform: "/") {
        catalogWidgetGroup
        catalogWidgetCompletenessGroup
        motive(required: true, description: "Skip motive")
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
}