package catalog.melidata

import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType


tracks {


    initiative = "1163"

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

        // Catalog search properties

        // Query
        site_filter(required: false, description: "Site selected by the user", type: PropertyType.String)
        query_filter(required: false, description: "Search query input by the user", type: PropertyType.String)
        domain_filter(required: false, description: "Domain selected by the user", type: PropertyType.String)
        is_gtin(required: false, description: "Indicates if the search is for GTIN (true) or products (false)", type: PropertyType.Boolean)
        displayed_sources(required: false, description: "List of sources that initially appeared in the result list", type: PropertyType.ArrayList(PropertyType.String))

        // Metadata
        has_results(required: false, description: "Indicates if the search has any results or not", type: PropertyType.Boolean)
        unknown_info_sources(required: false, description: "List of sources that could not be reached when presenting the results", type: PropertyType.ArrayList(PropertyType.String))

        // Product
        product_id(required: false, description: "Product ID", type: PropertyType.String)
        product_source(required: true, description: "Product external source", type: PropertyType.String)
        product_external_id(required: false, description: "Product external ID or Marketplace attribute primary key", type: PropertyType.String)

        // Domain
        external_domain(required: false, description: "Product external domain", type: PropertyType.String)
        predicted_domain(required: false, description: "Product predicted domain", type: PropertyType.String)
        selected_domain(required: false, description: "Product domain based on user selection", type: PropertyType.String)

        // Attribute
        external_attribute_key(required: true, description: "Product external attribute key", type: PropertyType.String)
        external_attribute_value(required: true, description: "Product external attribute value", type: PropertyType.String)
    }

    propertyGroups {
        catalogWidgetGroup(category_id, page, item_id, officialstore, domain_id, seller_id, pi, condition, category_path, label,attribute_type, attributes_showed)
        catalogWidgetCompletenessGroup(completeness_level, attributes_submitted, items_left, missing_attributes, inferred_attributes)

        // Catalog search property groups
        catalogSearchQuery(site_filter, query_filter, domain_filter, is_gtin, displayed_sources)
        catalogSearchMetadataQuery(has_results, unknown_info_sources)
        catalogSearchWrongDomainPrediction(product_id, product_source, product_external_id, external_domain, predicted_domain, selected_domain)
        catalogSearchWrongExternalDomain(product_id, product_source, product_external_id, external_domain)
        catalogSearchWrongExternalAttribute(product_id, product_source, product_external_id, external_domain, external_attribute_key, external_attribute_value)
        catalogSearchCopiedExternalAttribute(product_id, product_source, product_external_id, external_domain, external_attribute_key, external_attribute_value)
    }

    "/catalogwidget"(platform: "/", isAbstract: true, type: TrackType.Event, initiative: "1033") {}

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
    "/bulk_attributes"(platform: "/",isAbstract: true, initiative: "1033") {}
    "/bulk_attributes/incomplete"(platform: "/",isAbstract: true) {}

    "/bulk_attributes/incomplete/save" (platform: "/web",type: TrackType.Event) {
        campaignId(required: true, description: "Campaign id to know from where the user came")
        totalItems(required: true, description: "Total of items that the user could update")
        updatedItems(required: true, description: "Total of updated items in Massive Attribute Editor")
        badItems(required: false, description:"True if the user has items with few attributes completed.", PropertyType.Boolean)
    }

    "/structure_data"(platform: "/", isAbstract: true, initiative: "1024") {}

    "/structure_data/product_creator"(platform: "/",isAbstract: true) {}
    "/structure_data/product_creator/other_domain"(platform: "/", type: TrackType.Event) {
        score(required: true, description: "Score of zordon api")
        is_same_domain(required: true, description:"Must keep or not in this domain", PropertyType.Boolean)
        domain_id(required: true, description: "Current domain")
        suggested_domain(required: true, description: "Suggested domain")
        item_id(required: true, description: "Item Id")
        user_action(required: true, description: "Action taken by user")
        user_initials(required: true, description: "Bs user initials", type: PropertyType.String)
    }
    "/structure_data/product_creator/taken-action-with-product-data"(platform: "/", type: TrackType.Event) {
        item_id(required: true, description: "Item Id", type: PropertyType.String)
        user_action(required: true, description: "Action taken by user", type: PropertyType.String)
        user_initials(required: true, description: "Bs user initials", type: PropertyType.String)
    }
    "/structure_data/product_creator/ignored_hints"(platform: "/", type: TrackType.Event) {
        domain_id(required: true, description: "Current domain")
        hint_id(required: true, description: "Hint Id")
        attribute(required: true, description: "Attribute Id")
        lang(required: true, description: "Language")
        suggested_value_id(required: true, description: "Suggested hint value Id")
        suggested_value_name(required: true, description: "Suggested hint value name")
        written_value(required: true, description: "Written attribute value")
        final_value(required: true, description: "Final attribute value")
        user_initials(required: true, description: "Bs user initials", type: PropertyType.String)
    }
    "/structure_data/product_reviewer"(platform: "/",isAbstract: true) {}
    "/structure_data/product_reviewer/review"(platform: "/", type: TrackType.Event) {
         review_id(required: true, description: "Review Id", type: PropertyType.String)
         review_version(required: true, description: "Reviews version", type: PropertyType.Numeric)
         sheet_id(required: true, description: "Sheet reviewed", type: PropertyType.String)
         domain_id(required: true, description: "Sheets domain ID reviewed", type: PropertyType.String)
         publication_id(required: true, description: "Item ID reviewed", type: PropertyType.String)
         review_status(required: true, description: "Reviews result", values: ["APPROVED", "REJECTED", "PENDING"], type: PropertyType.String) 
         action_tag(required: true, description: "Publications tag", values: ["ADD", "REP", "NPP"], type: PropertyType.String) 
         time(required: true, description: "Time reviewing the item", type: PropertyType.Numeric)
         sections_comments(required: true, description: "Reviews comments", type: PropertyType.ArrayList(PropertyType.String))
         errors_codes(required: true, description: "Reviews errors codes", type: PropertyType.ArrayList(PropertyType.String))
         user_initials(required: true, description: "Bs user initials", type: PropertyType.String)
    }
    "/structure_data/product_modificator"(platform: "/",isAbstract: true) {}
    "/structure_data/product_modificator/quality-reports"(platform: "/", type:TrackType.Event){
        domain_id(required: true, description: "Domain ID", type: PropertyType.String)
        parent_id(required: true, description: "Parent product ID", type: PropertyType.String)
        product_id(required: true, description: "Product ID", type: PropertyType.String)
        errors(required: true, description: "Error collection", type: PropertyType.ArrayList(PropertyType.String))
        warnings(required: true, description: "Warnings collection", type: PropertyType.ArrayList(PropertyType.String))
        errors_quantity(required: true, description: "Errors quantity", type: PropertyType.Numeric)
        warning_quantity(required: true, description: "Warning quantity", type: PropertyType.Numeric)
        step(required: true, description: "Analysis step", values: ["INITIAL", "PARENT", "CHILD"], type: PropertyType.String)
    }

        // Tracks borrado por repetido
    "/structure_data/product_merge"(platform: "/",isAbstract: true) {}

    "/structure_data/product_merge/parent_analysis"(platform: "/", type:TrackType.View){
        session_id(required: true, description: "Merge session Id", type: PropertyType.String)
        sheet_id(required: true, description: "Sheet ID", type: PropertyType.String)
        is_retake(required: true, description: "Indica si es retoma o no", type: PropertyType.Boolean)
    }

    "/structure_data/product_merge/children_analysis"(platform: "/", type:TrackType.View){
        session_id(required: true, description: "Merge session Id", type: PropertyType.String)
        sheet_id(required: true, description: "Sheet ID", type: PropertyType.String)
        is_retake(required: true, description: "Indica si es retoma o no", type: PropertyType.Boolean)
    }

    "/structure_data/product_merge/congrats"(platform: "/", type:TrackType.View){
        session_id(required: true, description: "Merge session Id", type: PropertyType.String)
        sheet_id(required: true, description: "Sheet ID", type: PropertyType.String)
        is_retake(required: true, description: "Indica si es retoma o no", type: PropertyType.Boolean)
    }

    "/structure_data/product_merge/available_products"(platform: "/", type:TrackType.Event){
        products_ids(required: true, description: "ProductsID collection", type: PropertyType.ArrayList(PropertyType.Numeric))
    }

    // Catalog search tracks
    "/structure_data/catalog_search"(platform: "/web/desktop",isAbstract: true) {}

    "/structure_data/catalog_search/query"(platform: "/web/desktop", type: TrackType.Event) {
        catalogSearchQuery
        catalogSearchMetadataQuery
    }

    "/structure_data/catalog_search/wrong_domain_prediction"(platform: "/web/desktop", type:TrackType.Event) {
        catalogSearchWrongDomainPrediction
    }

    "/structure_data/catalog_search/wrong_external_domain"(platform: "/web/desktop", type:TrackType.Event) {
        catalogSearchWrongExternalDomain
    }

    "/structure_data/catalog_search/wrong_external_attribute"(platform: "/web/desktop", type:TrackType.Event) {
        catalogSearchWrongExternalAttribute
    }

    "/structure_data/catalog_search/copied_external_attribute"(platform: "/web/desktop", type:TrackType.Event) {
        catalogSearchQuery
        catalogSearchCopiedExternalAttribute
    }
}