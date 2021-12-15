import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

tracks {

    initiative = "1015"

    def listingsPerCategoryStructure = objectSchemaDefinitions {
        quantity(required: true, type: PropertyType.Numeric)
        category(required: true, type: PropertyType.String)
    }

    def notPublishedCategoryDataStructure = objectSchemaDefinitions {
        category_id(required: true, type: PropertyType.String)
        total_failed(required: true, type: PropertyType.String)
        errors(required: true, type: PropertyType.ArrayList(PropertyType.Map(errorOccurrencesStructure)))
    }

    def errorOccurrencesStructure = objectSchemaDefinitions {
        code(required: true, type: PropertyType.Numeric)
        occurrences(required: true, type: PropertyType.Numeric)
    }

    //BULK SECTION
    "/vendor_central"(platform: "/", isAbstract: true) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Vendor Central Summary
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    "/vendor_central/summary"(platform: "/", isAbstract: true) {}

    "/vendor_central/summary/hub"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/summary/discount"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/summary/discount_congrats"(platform: "/web", type: TrackType.View) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Vendor central Offerings Listing
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/vendor_central/offerings_listing"(platform: "/", isAbstract: true) {}
    "/vendor_central/offerings_listing/list"(platform: "/", type: TrackType.View) {}
    "/vendor_central/bulk/offerings_listing/filter"(platform: "/", type: TrackType.Event) {
        type(required: true, type: PropertyType.String, description: "Type of filtering criteria")
        values(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "Applied filters value")
        criteria(required: false, type: PropertyType.String, description: "Applied filter criteria type value on single search type filter")
    }

    // TRACKS Vendor central BULK Offering offline editor
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/vendor_central/bulk/offline"(platform: "/", isAbstract: true) {}

    "/vendor_central/bulk/offline/hub"(platform: "/", type: TrackType.View) {}

    "/vendor_central/bulk/offline/download"(platform: "/", type: TrackType.View) {}

    "/vendor_central/bulk/offline/upload"(platform: "/", type: TrackType.View) {}

    "/vendor_central/bulk/offline/download/confirm"(platform: "/", type: TrackType.Event) {
        items(required: true, type: PropertyType.Numeric, description: "Amount of downloaded items")
        filters(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "List of applied filters")
        categories(required: true, type: PropertyType.ArrayList(PropertyType.String), description: "List of applied categories")
        type(required: true, type: PropertyType.String, description: "Selected type of excel editing process")
        selected_columns(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "List of selected sheet columns to edit")
        branches(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "List of applied branches")
    }

    "/vendor_central/bulk/offline/download/congrats"(platform: "/", type: TrackType.View) {
        type(required: true, type: PropertyType.String, description: "Which congrats is the user redirected", values: ["success", "failed", "partial", "no changes", "mail"])
    }

    "/vendor_central/bulk/offline/upload/congrats"(platform: "/", type: TrackType.View) {
        type(required: true, type: PropertyType.String, description: "Which congrats is the user redirected", values: ["SUCCESS", "WARNING"])
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Vendor Central BULK Offering Publish
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    "/vendor_central/bulk"(platform: "/", isAbstract: true) {}

    "/vendor_central/bulk/publish"(platform: "/web", isAbstract: true) {}

    "/vendor_central/bulk/publish/hub"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/bulk/publish/categories"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/bulk/publish/download"(platform: "/web", isAbstract: true) {}

    "/vendor_central/bulk/publish/download/congrats"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/bulk/publish/upload"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/bulk/publish/upload/congrats"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/bulk/publish/categories/download_excel"(platform: "/web", type: TrackType.Event) {
        total(required: true, type: PropertyType.Numeric, description: "The total number of categories that were downloaded")
        last_published(required: true, type: PropertyType.Numeric, description: "The total number of categories that were downloaded from last published section")
        most_used(required: true, type: PropertyType.Numeric, description: "The total number of categories that were downloaded from most used section")
        search_list(required: true, type: PropertyType.Numeric, description: "The total number of categories that were downloaded from search section")
        modal(required: true, type: PropertyType.Numeric, description: "The total number of categories that were downloaded from modal")
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Vendor Central Purchase order listing
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    "/vendor_central/inbound"(platform: "/", isAbstract: true) {}

    "/vendor_central/inbound/listing"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/inbound/detail"(platform: "/web", type: TrackType.View) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------ 
    // TRACKS Vendor Central Branches
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/vendor_central/branches"(platform: "/", isAbstract: true) {}

    "/vendor_central/branches/listing"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/branches/detail"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/branches/create"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/branches/accounts"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/branches/congrats"(platform: "/web", type: TrackType.Event) {
        collaborators_updated(required: true, type: PropertyType.Boolean, description: "this property describes what is shown on the congrats page")
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Vendor Central Contra COGS
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/vendor_central/contra_cogs"(platform: "/", isAbstract: true) {}

    "/vendor_central/contra_cogs/list"(platform: "/", isAbstract: true) {}

    "/vendor_central/contra_cogs/list/search"(platform: "/web", type: TrackType.Event) {
        filters(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "this property describes the filters ids applied to the search")
        sorts(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "this property describes the sorts ids applied the search")
        search_terms(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "this property describes the search terms applied for the search")
        task(required: false, type: PropertyType.String, description: "this property describes the task id applied for the search")
    }

    "/vendor_central/contra_cogs/listing"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/contra_cogs/detail"(platform: "/web", type: TrackType.View) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Vendor Central Invoices
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/vendor_central/invoices"(platform: "/", isAbstract: true) {}

    "/vendor_central/invoices/upload"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/invoices/upload/error"(platform: "/web", type: TrackType.View) {
        error_type(required: true, type: PropertyType.String, description: "Type of the error the user received when trying to upload a file", values: ["fileInvalidType", "fileTooLarge", "tooManyFiles", "unexpectedError"])
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Vendor Central Inbound creator
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/vendor_central/inbound-shipment"(platform: "/", isAbstract: true) {}

    "/vendor_central/inbound_shipment/creator"(platform: "/", isAbstract: true) {}

    "/vendor_central/inbound_shipment/creator/download"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/inbound_shipment/creator/download/congrats"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/inbound_shipment/creator/download/error"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/inbound_shipment/creator/upload"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/inbound_shipment/creator/upload/congrats"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/inbound_shipment/creator/upload/error"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/inbound_shipment/creator/upload/email"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/inbound_shipment/editor/download"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/inbound_shipment/editor/download/congrats"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/inbound_shipment/editor/upload"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/inbound_shipment/editor/upload/congrats"(platform: "/web", type: TrackType.View) {}

    "/vendor_central/inbound_shipment/editor/upload/error"(platform: "/web", type: TrackType.View) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Vendor Central Fiscal Documents Template Mappings
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/vendor_central/fiscal_documents"(platform: "/", isAbstract: true) {}

    "/vendor_central/fiscal_documents/template_mappings"(platform: "/", isAbstract: true) {}

    "/vendor_central/fiscal_documents/template_mappings/delete"(platform: "/web", type: TrackType.Event) {
        entity(required: true, type: PropertyType.String, description: "this property indicates the entity")
        is_valid_entity(required: true, type: PropertyType.Boolean, description: "this property indicates if the entity is valid")
    }

    "/vendor_central/fiscal_documents/template_mappings/get"(platform: "/web", type: TrackType.Event) {
        entity(required: true, type: PropertyType.String, description: "this property indicates the entity")
        is_valid_entity(required: true, type: PropertyType.Boolean, description: "this property indicates if the entity is valid")
    }

    "/vendor_central/fiscal_documents/template_mappings/modify"(platform: "/web", type: TrackType.Event) {
        entity(required: true, type: PropertyType.String, description: "this property indicates the entity")
        is_valid_entity(required: true, type: PropertyType.Boolean, description: "this property indicates if the entity is valid")
        template_id(required: false, type: PropertyType.String, description: "this property indicates the template id")
        is_valid_template(required: false, type: PropertyType.Boolean, description: "this property indicates if the template is valid")
    }

    "/vendor_central/fiscal_documents/template_mappings/save"(platform: "/web", type: TrackType.Event) {
        entity(required: true, type: PropertyType.String, description: "this property indicates the entity")
        is_valid_entity(required: true, type: PropertyType.Boolean, description: "this property indicates if the entity is valid")
        template_id(required: false, type: PropertyType.String, description: "this property indicates the template id")
        is_valid_template(required: false, type: PropertyType.Boolean, description: "this property indicates if the template is valid")
    }

    "/vendor_central/bulk/publish/document/upload"(platform: "/web", type: TrackType.Event) {
        listings(required: false, type: PropertyType.Numeric, description: "indicates listings number to upload")
        fail_categories(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "indicates failed upload categories to upload")
        ok_categories(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "indicates uploaded categories to upload")
        variation_categories(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "indicates uploaded variation categories to upload")
        catalog_categories(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "indicates uploaded product categories to upload")
        document_size(required: false, type: PropertyType.Numeric, description: "indicates total size of document to upload")
        variation_listings(required: false, type: PropertyType.Numeric, description: "indicates total listings with variation to upload")
        catalog_listings(required: false, type: PropertyType.Numeric, description: "indicates total listings with products to upload")
        listings_per_category(required: false, type: PropertyType.ArrayList(PropertyType.Map(listingsPerCategoryStructure)), description: "indicates listings per category to upload")
        session_id(required: true, type: PropertyType.String, description: "indicates session id for file")
    }

    "/vendor_central/bulk/publish/publish-callback"(platform: "/web", type: TrackType.Event) {
        listings_not_published(required: false, type: PropertyType.ArrayList(PropertyType.Map(notPublishedCategoryDataStructure)), description: "indicates listings not published")
        listings_ok(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "indicates listings with ok result")
        listings_timeout(required: false, type: PropertyType.Numeric, description: "indicates listings with timeout result")
        session_id(required: true, type: PropertyType.String, description: "indicates session id for file")
    }

    "/vendor_central/bulk/publish/document/generate"(platform: "/web", type: TrackType.Event) {
        listings(required: false, type: PropertyType.Numeric, description: "indicates listings number to generate")
        fail_categories(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "indicates failed upload categories to generate")
        ok_categories(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "indicates uploaded categories to generate")
        variation_categories(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "indicates uploaded variation categories to generate")
        catalog_categories(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "indicates uploaded product categories to generate")
        document_size(required: false, type: PropertyType.Numeric, description: "indicates total size of document to generate")
        variation_listings(required: false, type: PropertyType.Numeric, description: "indicates total listings with variation to generate")
        catalog_listings(required: false, type: PropertyType.Numeric, description: "indicates total listings with products to generate")
        listings_per_category(required: false, type: PropertyType.ArrayList(PropertyType.Map(listingsPerCategoryStructure)), description: "indicates listings per category to generate")
        session_id(required: true, type: PropertyType.String, description: "indicates session id for file")
    }
}
