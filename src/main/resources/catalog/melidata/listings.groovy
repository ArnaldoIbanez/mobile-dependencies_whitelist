package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1151"

    propertyDefinitions {
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
        sub_view_id(required: false, type: PropertyType.String, description: "current subview", values: ["marketplace", "mshops", "only_marketplace", "legacy"])
    }

    propertyGroups {
        channelGroup(view_id, sub_view_id)
    }

    def rowItemStructure = objectSchemaDefinitions {
        item_id(type: PropertyType.String, required: true)
        reason(type: PropertyType.String, required: true)
    }

    def itemStructure = objectSchemaDefinitions {
        channels(type: PropertyType.ArrayList(PropertyType.String), description: "channel actives for publication")
        price(type: PropertyType.Numeric, description: "price adsolute")
        shipping_mode(type: PropertyType.String, description: "publication delivery method")
        shipping_logistic(type: PropertyType.String, description: "publication logistic method")
        listing_type(type: PropertyType.String, description: "publication type, change for site")
    }

    def applyFiltersStructure = objectSchemaDefinitions {
        filters(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "List of filters applied")
        sort(required: false, type: PropertyType.String, description: "Sorting applied")
    }

    "/seller_central/listings"(platform: "/", isAbstract: true) {}
    "/seller_central/listings/list"(platform: "/", type: TrackType.View) {
        channelGroup
        origin(required: false, type: PropertyType.String, description: "View where the event has been called", name: "origin")
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Listings empty states and publications to activate channel 
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    "/seller_central/listings/row_empty_state"(platform: "/", type: TrackType.Event) {
        sub_view_id(required: true, type: PropertyType.String, description: "View to activate", values: ["marketplace", "mshops"])
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(rowItemStructure)), description: "List of items with empty state action")
    }

    "/seller_central/listings/activate_row"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String, description: "Item to activate")
        sub_view_id(required: true, type: PropertyType.String, description: "View to activate", values: ["marketplace", "mshops"])
        reason(required: true, type: PropertyType.String, description: "Reason")
    }

    "/seller_central/listings/inactive_channel"(platform: "/", type: TrackType.Event) {
        sub_view_id(required: true, type: PropertyType.String, description: "Rendered or activated view id")
        action(required: true, type: PropertyType.String, values: ["render", "click"], description: "Action performed")
    }

    "/seller_central/listings/change_sub_view"(platform: "/", type: TrackType.Event) {
        selected_view(required: true, type: PropertyType.String, description: "Sub view selected")
        type(required: false, type: PropertyType.String, description: "Mshops shop state", values: ["optin", "admin"])
        url(required: false, type: PropertyType.String, description: "Shop url")
    }

    "/seller_central/listings/row"(platform: "/", isAbstract: true) {
        // TODO remove required: false after migration complete
        item_id(required: false, type: PropertyType.String, description: "Id of the publication")
        channelGroup
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS listings comparison tooltip
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    "/seller_central/listings/row/comparison_tooltip"(platform: "/", type: TrackType.Event) {
        open_time(type: PropertyType.Numeric, description: "time from opening the tooltip to closing in seconds")
        loading_time(type: PropertyType.Numeric, description: "time from opening the tooltip to load info in milliseconds")
        tooltip_type(type: PropertyType.String, description: "type of tooltip after load data", values: ["success", "empty_by_channel", "fallback", "abort"])
        item_state(type: PropertyType.String, description: "state of the item active | inactive | undefiend", values: ["active", "inactive", "undefined"])
    }

    "/seller_central/listings/row/comparison_tooltip_empty"(platform: "/", type: TrackType.Event) {
        action(type: PropertyType.String, description: "type of event", values: ["show", "click"])
        activation_channel(type: PropertyType.String, description: "channel to activate", values: ["marketplace", "mshops"])
        empty_type(type: PropertyType.String, description: "type of empty", values: ["empty_channel", "activate_mshops"])
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS listings item variations
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    "/seller_central/listings/row/variations"(platform: "/", type: TrackType.View) {
        success(type: PropertyType.Boolean, description: "result of request success=true, fail=false")
        loading_time(type: PropertyType.Numeric, description: "time of duration to load variations in milliseconds")
        variations_loaded(type: PropertyType.Numeric, description: "amount of variations loaded")
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS listings Secondary Actions Click
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    "/seller_central/listings/row/secondary_actions"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/row/secondary_actions/selected"(platform: "/", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "Action id")
        inventory_id(required: false, type: PropertyType.String, description: "Inventory id to which the action is executed")
        operator_id(required: false, type: PropertyType.String, description: "If it is an operator, operator id that executes the action")
        message(required: false, type: PropertyType.String, description: "Text input from actions with user feedback")
        option(required: false, type: PropertyType.String, description: "Option selected from actions with user feedback")
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS listings Link in the row cta
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    "/seller_central/listings/row/call_to_actions"(platform: "/", type: TrackType.Event) {
        item(type: PropertyType.Map(itemStructure), description: "publication data")
        action_id(type: PropertyType.String,
                description: "CTA clicked on item row",
                values: [
                        "MODIFY_PRICE",
                        "GO_TO_PROMOTIONS",
                        "MODIFY_LISTING_TYPE",
                        "UPGRADE_LISTING_TYPE",
                        "UPGRADE_SHIPPING",
                        "MODIFY_SHIPPING"
                ]
        )
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS listings Item Modify detail
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    "/seller_central/listings/row/item_description"(platform: "/", type: TrackType.Event) {
        channelGroup
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS listings situacional cell
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    //moderation_id will stay till legacy is deprecated
    "/seller_central/listings/row/moderation"(platform: "/", type: TrackType.Event) {
        moderation_id(required: false, type: PropertyType.String, description: "Moderation id")
        reason(required: false, type: PropertyType.String, description: "moderation reason")
    }

    "/seller_central/listings/row_moderation"(platform: "/", type: TrackType.Event) {
        sub_view_id(required: true, type: PropertyType.String, description: "View to activate", values: ["marketplace", "mshops", "only_marketplace"])
        items(required: true, type: PropertyType.ArrayList(PropertyType.Map(rowItemStructure)), description: "List of items with empty state action")
    }

    "/seller_central/listings/row/health"(platform: "/", type: TrackType.Event) {
        health_id(required: true, type: PropertyType.String, description: "Health id")
        channelGroup
    }

    "/seller_central/listings/row/win_catalog"(platform: "/", type: TrackType.Event) {
        push_id(required: true, type: PropertyType.String, description: "push for win or improve in catalog publications")
        item_state(required: true, type: PropertyType.String, description: "condition of item ")
        channelGroup
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS listings Filters
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    "/seller_central/listings/list/filters"(platform: "/", type: TrackType.View) {}

    "/seller_central/listings/filters/applied"(platform: "/", type: TrackType.Event) {
        // TODO remove checkedFilters when the rollout mshops finsh
        checkedFilters(required: false, type: PropertyType.ArrayList, description: "Id of the action")
        page(required: false, type: PropertyType.Numeric, description: "Number of the page")
        filters(required: false, type: PropertyType.ArrayList, description: "List with the Ids of every filter applied")
        sort(required: false, type: PropertyType.String, description: "Sorting applied")
        search(required: false, type: PropertyType.String, description: "Query for id or title")
        origin(required: false, type: PropertyType.String, description: "component that emit the action")
        channelGroup
    }

    "/seller_central/listings/filters/action"(platform: "/") {
        action(required: true, type: PropertyType.String, description: "Id of the action", values: ["apply", "clear"])
        before_apply_filters(required: false, type: PropertyType.Map(applyFiltersStructure), description: "Current list of filters and sort param before click action")
        after_apply_filters(required: false, type: PropertyType.Map(applyFiltersStructure), description: "List of filters and sort param applied after click action")
        channelGroup
    }

    "/seller_central/listings/sort"(platform: "/") {
        id(required: true, type: PropertyType.String, description: "Index of sort applied")
        channelGroup
    }

    "/seller_central/listings/search"(platform: "/", type: TrackType.Event) {
        channelGroup
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS listings dropdown modify massive
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    "/seller_central/listings/editor"(platform: "/", type: TrackType.Event) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS listings setup mercado shops
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    "/seller_central/listings/setup_mshop"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/landing_mshop"(platform: "/", type: TrackType.Event) {}

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS legacy remove after to deploy ROLA
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    "/seller_central/listings/list/item_description"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/list/moderation"(platform: "/", type: TrackType.Event) {
        moderation_id(required: true, type: PropertyType.String, description: "Moderation id")
    }

    "/seller_central/listings/list/health"(platform: "/", type: TrackType.Event) {
        health_id(required: true, type: PropertyType.String, description: "Health id")
    }

    "/seller_central/listings/list/secondary_actions"(platform: "/", type: TrackType.Event) {
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
    }

    "/seller_central/listings/action"(platform: "/", type: TrackType.Event) {
        action_id(required: true, type: PropertyType.String, description: "Action id")
        view_id(required: false, type: PropertyType.String, description: "View where the event has been called")
        item_id(required: false, type: PropertyType.String, description: "Item id to which the action is executed")
        inventory_id(required: false, type: PropertyType.String, description: "Inventory id to which the action is executed")
        operator_id(required: false, type: PropertyType.String, description: "If it is an operator, operator id that executes the action")
        message(required: false, type: PropertyType.String, description: "Text input from actions with user feedback")
        option(required: false, type: PropertyType.String, description: "Option selected from actions with user feedback")
        vertical(required: false, type: PropertyType.String, description: "Vertical of the item related to the action")

    }
}
