package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Fbm inbound views") {
        "/fbm/panel/inbound/units"(platform: "/", type: TrackType.View) {}
        "/fbm/panel/inbound/labeling"(platform: "/", type: TrackType.View) {}
        "/fbm/panel/inbound/identifiers"(platform: "/", type: TrackType.View) {}
        "/fbm/panel/inbound/offline"(platform: "/", type: TrackType.View) {}
    }

    test("Fbm landing views") {
      "/full/landing/buyer"(platform: "/", type: TrackType.View) {}
    }

    test("Inbound units events") {
        "/fbm/panel/inbound/units/input_change"(platform: "/", type: TrackType.Event) {
            warning_type = 'show_incentive'
            warning_value = 51
            inbound_id = 2649
            inventory_id = 'YWGV00053'
            input_value = 6
        }

        "/fbm/panel/inbound/units/submit_error"(platform: "/", type: TrackType.Event) {
             warnings = [
                [
                    warning_type: 'show_restriction',
                    warning_value : 100, 
                    inbound_id : 2649, 
                    inventory_id : 'YWGV00053',
                    input_value : 300
                ]
            ]
        }

        "/fbm/panel/inbound/units/input_delete"(platform: "/", type: TrackType.Event) {
            inbound_id = 2649
            inventory_id = 'YWGV00053'
        }
    }

    test("Inbound offline event") {
        "/fbm/panel/inbound/offline/product_selection"(platform: "/", type: TrackType.Event) {
            seller_id = 123456
            was_recovered = true
            inbound_id = 200000
            document_status = "OK"
            amount_of_rows = 100
            amount_of_errors = 10
            detailed_errors = [
                inventory_id_not_created : 0,
                invalid_product_identifier : 0,
                invalid_sku : 0,
                invalid_inventory_id : 0,
                invalid_variation_id : 0,
                invalid_quantity : 1,
                missing_quantity : 1,
                invalid_status : 1,
                max_quantity_exceeded : 0,
                max_quantity_reached : 0,
                variation_not_found : 0,
                item_not_found : 0,
                item_duplicated : 0,
                multiple_items_found : 0,
                multiple_variations_found : 0,
                forbidden : 0,
                categories : 0,
                dimensions : 0,
                pdd : 0,
                pppi : 0,
                under_review : 0,
                catalog_attributes : 0,
                seller_blacklist : 1,
                non_fiscal_data : 1,
                item_condition_used : 1,
                item_status_closed : 1,
                invalid_shipping_mode : 1,
                item_listing_type_free : 1,
                failure : 1
            ]
            amount_of_items = 100
            amount_of_units = 500
        }    
    }
}
