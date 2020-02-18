package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1196"

    def offline_error_msg_structure = objectSchemaDefinitions {
        inventory_id_not_created(required: true, type: PropertyType.Numeric)
        invalid_product_identifier(required: true, type: PropertyType.Numeric)
        invalid_sku(required: true, type: PropertyType.Numeric)
        invalid_inventory_id(required: true, type: PropertyType.Numeric)
        invalid_variation_id(required: true, type: PropertyType.Numeric)
        invalid_quantity(required: true, type: PropertyType.Numeric)
        missing_quantity(required: true, type: PropertyType.Numeric)
        invalid_status(required: true, type: PropertyType.Numeric)
        max_quantity_exceeded(required: true, type: PropertyType.Numeric)
        max_quantity_reached(required: true, type: PropertyType.Numeric)
        variation_not_found(required: true, type: PropertyType.Numeric)
        item_not_found(required: true, type: PropertyType.Numeric)
        item_duplicated(required: true, type: PropertyType.Numeric)
        multiple_items_found(required: true, type: PropertyType.Numeric)
        multiple_variations_found(required: true, type: PropertyType.Numeric)
        forbidden(required: true, type: PropertyType.Numeric)
        categories(required: true, type: PropertyType.Numeric)
        dimensions(required: true, type: PropertyType.Numeric)
        pdd(required: true, type: PropertyType.Numeric)
        pppi(required: true, type: PropertyType.Numeric)
        under_review(required: true, type: PropertyType.Numeric)
        catalog_attributes(required: true, type: PropertyType.Numeric)
        seller_blacklist(required: true, type: PropertyType.Numeric)
        non_fiscal_data(required: true, type: PropertyType.Numeric)
        item_condition_used(required: true, type: PropertyType.Numeric)
        item_status_closed(required: true, type: PropertyType.Numeric)
        invalid_shipping_mode(required: true, type: PropertyType.Numeric)
        item_listing_type_free(required: true, type: PropertyType.Numeric)
        failure(required: true, type: PropertyType.Numeric)
    }

    "/fbm"(platform: "/", isAbstract: true) {}
    "/fbm/panel"(platform: "/", isAbstract: true) {}
    "/fbm/panel/inbound"(platform: "/", isAbstract: true) {}


    //Views
    "/fbm/panel/inbound/units"(platform: "/", type: TrackType.View) {}
    "/fbm/panel/inbound/labeling"(platform: "/", type: TrackType.View) {}
    "/fbm/panel/inbound/identifiers"(platform: "/", type: TrackType.View) {}
    "/fbm/panel/inbound/offline"(platform: "/", type: TrackType.View) {}

    // Events
    //Change value input in units page
    "/fbm/panel/inbound/units/input_change"(platform: "/", type: TrackType.Event) {
        warning_type(
            required: true,
            type: PropertyType.String,
            description: "Type of warning showed after change value",
            values: ["show_restriction", "show_incentive", "units_ok"]
        )
        warning_value(
            required: true,
            type: PropertyType.Numeric,
            description: "Value max or min allowed",
        )
        inbound_id(
            required: true,
            type: PropertyType.Numeric,
            description: "Id of the inbound being edited",
        )
        inventory_id(
            required: true,
            type: PropertyType.String,
            description: "Id of the unit being edited",
        )
        input_value(
            required: true,
            type: PropertyType.Numeric,
            description: "New value entered by the user",
        )
    }

    //Submit units with error
    "/fbm/panel/inbound/units/submit_error"(platform: "/", type: TrackType.Event) {
        warnings(
            required: true,
            type:PropertyType.ArrayList,
            description: "List of errors showed",
        )
    }

    //Delete a unit on units page
    "/fbm/panel/inbound/units/input_delete"(platform: "/", type: TrackType.Event) {
        inbound_id(
            required: true,
            type: PropertyType.Numeric,
            description: "Id of the inbound being edited",
        )
        inventory_id(
            required: true,
            type: PropertyType.String,
            description: "Id of the unit being edited",
        )
    }

    //Track inbound offline product selection
    "/fbm/panel/inbound/offline/product_selection"(platform: "/", type: TrackType.Event) {
        seller_id(
            required: true,
            type: PropertyType.Numeric,
            description: "Id of user"
        )
        inbound_id(
            required: false,
            type: PropertyType.Boolean,
            description: "Indicate id of generated inbound"
        )
        was_recovered(
            required: true,
            type: PropertyType.Boolean,
            description: "Indicate if inbound was recovered"
        )
        document_status(
            required: true,
            type: PropertyType.String,
            description: "Indicate the status of the document processed",
            values: ["OK", "EMPTY", "RECOVERABLE", "NON_RECOVERABLE"]
        )
        amount_of_rows(
            required: true,
            type: PropertyType.Numeric,
            description: "Amount of rows in file"
        )
        amount_of_errors(
            required: true,
            type: PropertyType.Numeric,
            description: "Amount of rows in file with errors"
        )
        detailed_errors(
            required: true,
            type: PropertyType.Map(offline_error_msg_structure),
            description: 'Detailed errors in file'
        )
        amount_of_items(
            required: true,
            type: PropertyType.Numeric,
            description: "Amount of items declared"
        )
        amount_of_units(
            required: true,
            type: PropertyType.Numeric,
            description: "Sum of quantity declared"
        )
    }

    "/full"(platform: "/", isAbstract: true, initiative: "1025") {}
    "/full/landing"(platform: "/", isAbstract: true) {}
    "/full/landing/buyer"(platform: "/", type: TrackType.View) {}
}
