import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

tracks {

    initiative = "1029"

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
    }

    "/vendor_central/bulk/offline/download/congrats"(platform: "/", type: TrackType.View) {
        type(required: true, type: PropertyType.String, description: "Which congrats is the user redirected", values:["success","failed", "partial", "no changes", "mail"])
    }

    "/vendor_central/bulk/offline/upload/congrats"(platform: "/", type: TrackType.View) {
        type(required: true, type: PropertyType.String, description: "Which congrats is the user redirected", values:["SUCCESS","WARNING"])
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
    // TRACKS Vendor Central Fiscal Documents Template Mappings
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/vendor_central/fiscal_documents"(platform: "/", isAbstract: true) {}

    "/vendor_central/fiscal_documents/template_mappings"(platform: "/", isAbstract: true) {}

    "/vendor_central/fiscal_documents/template_mappings/delete"(platform: "/web", type: TrackType.Event) {
        template_id(required: false, type: PropertyType.String, description: "this property this property indicates the template id")
        user_id(required: false, type: PropertyType.Numeric, description: "this property indicates the user")
        entity(required: false, type: PropertyType.String, description: "this property this property indicates the entity")
        site_id(required: false, type: PropertyType.String, description: "this property this property indicates the site id")
    }

    "/vendor_central/fiscal_documents/template_mappings/get"(platform: "/web", type: TrackType.Event) {
        template_id(required: false, type: PropertyType.String, description: "this property this property indicates the template id")
        user_id(required: false, type: PropertyType.Numeric, description: "this property indicates the user")
        entity(required: false, type: PropertyType.String, description: "this property this property indicates the entity")
        site_id(required: false, type: PropertyType.String, description: "this property this property indicates the site id")
    }

    "/vendor_central/fiscal_documents/template_mappings/modify"(platform: "/web", type: TrackType.Event) {
        template_id(required: false, type: PropertyType.String, description: "this property this property indicates the template id")
        user_id(required: false, type: PropertyType.Numeric, description: "this property indicates the user")
        entity(required: false, type: PropertyType.String, description: "this property this property indicates the entity")
        site_id(required: false, type: PropertyType.String, description: "this property this property indicates the site id")
    }

    "/vendor_central/fiscal_documents/template_mappings/save"(platform: "/web", type: TrackType.Event) {
        template_id(required: false, type: PropertyType.String, description: "this property this property indicates the template id")
        user_id(required: false, type: PropertyType.Numeric, description: "this property indicates the user")
        entity(required: false, type: PropertyType.String, description: "this property this property indicates the entity")
        site_id(required: false, type: PropertyType.String, description: "this property this property indicates the site id")
    }

}
