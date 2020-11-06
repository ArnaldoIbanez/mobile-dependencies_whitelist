import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1223"

    propertyDefinitions {
        from (required:false, type: PropertyType.String, description: "Where the flow start")
        session_id (required:true, type: PropertyType.String, description: "Session Id of flow")
        uuid (required:false, type: PropertyType.String, description: "device uuid")
        category (required:false, type: PropertyType.String, description: "Chosen category")
        label (required:false, type: PropertyType.String, description: "Chosen label")
    }

    propertyGroups { 
        mandatory(session_id)
        categoryProperties(uuid, category, label)
    }
    
    /**
    * Bill Payments V2 Tracks  
    */

    "/bill_payments"(platform: "/mobile", isAbstract: true) {
        from (required:false, type: PropertyType.String, description: "Where the flow start")
        mandatory
        categoryProperties
    }

    // Home
    "/bill_payments/home"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/home/info_hour"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/home/type_barcode"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/home/scan_barcode"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/home/pay"(platform: "/mobile", type: TrackType.Event) {
        barcode(required: true, type: PropertyType.String, description: "the barcode used to pay")
    }
    "/bill_payments/home/call_to_action"(platform: "/mobile", type: TrackType.Event) {
        item (required:false, type: PropertyType.String, description: "The chosen item label")
    }

    // Invoice
    "/bill_payments/invoices"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/invoices/info_hour"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/invoices/pay"(platform: "/mobile", type: TrackType.Event) {
        barcode(required: true, type: PropertyType.String, description: "the barcode used to pay")
    }

    // Input amount
    "/bill_payments/input_amount"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/input_amount/back"(platform: "/mobile", type: TrackType.Event) {}

    // Input data
    "/bill_payments/input_data"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/input_data/back"(platform: "/mobile", type: TrackType.Event) {}

    // Input debt id
    "/bill_payments/input_option_debt"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/input_option_debt/back"(platform: "/mobile", type: TrackType.Event) {}

    // Info screen
    "/bill_payments/info_screen"(platform: "/mobile", type: TrackType.View) {}

    // FTU
    "/bill_payments/ftu"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/ftu/close"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/ftu/pay"(platform: "/mobile", type: TrackType.Event) {}

    // Opt in
    "/bill_payments/opt_in"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/opt_in/close"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/opt_in/activate"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/opt_in/terms"(platform: "/mobile", type: TrackType.Event) {}

    // Opt out
    "/bill_payments/opt_out"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/opt_out/close"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/opt_out/click"(platform: "/mobile", type: TrackType.Event) {}

    // Barcode manual input
    "/bill_payments/barcode_manual_input"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/barcode_manual_input/info_hour"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/barcode_manual_input/open_scanner"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/barcode_manual_input/continue"(platform: "/mobile", type: TrackType.Event) {
        barcode(required: true, type: PropertyType.String, description: "the barcode used to pay")
    }

    // Payment receipt
    "/bill_payments/receipt"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/receipt/share"(platform: "/mobile", type: TrackType.Event) {}

    // Scanner
    "/bill_payments/permission_camera"(platform: "/mobile") {}
    "/bill_payments/enable_camera"(platform: "/mobile") {}
    "/bill_payments/scan"(platform: "/mobile") {}
    "/bill_payments/read"(platform: "/mobile", type: TrackType.Event) {
        barcode(required: true, type: PropertyType.String, description: "the barcode used to pay")
    }

    // Entities and categories
    "/bill_payments/main_category"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/category_details"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/main_category/item"(platform: "/mobile", type: TrackType.Event) {
        entity (required:false, type: PropertyType.String, description: "The chosen entitie label")
        item (required:false, type: PropertyType.String, description: "The chosen item label")
    }

    "/bill_payments/category_details/item"(platform: "/mobile", type: TrackType.Event) {
        entity (required:true, type: PropertyType.String, description: "The chosen entitie label")
        item (required:false, type: PropertyType.String, description: "The chosen item label")
    }

    "/bill_payments/main_category/result_search"(platform: "/mobile", type: TrackType.Event) {
        search (required:true, type: PropertyType.String, description: "The searched string")
    }

     "/bill_payments/category_details/result_search"(platform: "/mobile", type: TrackType.Event) {
        search (required:true, type: PropertyType.String, description: "The searched string")
    }

     "/bill_payments/main_category/empty_search"(platform: "/mobile", type: TrackType.Event) {
        search (required:true, type: PropertyType.String, description: "The searched string")
    }

    "/bill_payments/category_details/empty_search"(platform: "/mobile", type: TrackType.Event) {
        search (required:true, type: PropertyType.String, description: "The searched string")
    }

    "/bill_payments/main_category/close"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/main_category/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/category_details/close"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/category_details/back"(platform: "/mobile", type: TrackType.Event) {}

    "/bill_payments/help"(platform: "/mobile") {}
    "/bill_payments/associated_entities"(platform: "/mobile") {}
    "/bill_payments/no_money"(platform: "/mobile") {}
    "/bill_payments/permissions_rationale"(platform: "/mobile") {}
    
    "/bill_payments/manual_code"(platform: "/mobile") {}
    "/bill_payments/confirmation"(platform: "/mobile") {}
    "/bill_payments/add_info"(platform: "/mobile") {
        type (required: true, type: PropertyType.String, description: "Additional info type")
    }
    "/bill_payments/second_password"(platform: "/mobile") {}
    "/bill_payments/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    // PX related tracks
    "/bill_payments/px_payment_method_search"(platform: "/mobile") {}
    "/bill_payments/px_discount_summary"(platform: "/mobile") {}
    "/bill_payments/px_card_vault"(platform: "/mobile") {}
    "/bill_payments/px_card_number"(platform: "/mobile") {}
    "/bill_payments/px_card_holder_name"(platform: "/mobile") {}
    "/bill_payments/px_card_expiry_date"(platform: "/mobile") {}
    "/bill_payments/px_card_security_code"(platform: "/mobile") {}
    "/bill_payments/px_identification_number"(platform: "/mobile") {}
    "/bill_payments/px_card_issuers"(platform: "/mobile") {}
    "/bill_payments/px_card_installments"(platform: "/mobile") {}
    "/bill_payments/px_review_and_confirm"(platform: "/mobile") {}
    "/bill_payments/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }
    "/bill_payments/fixed_amount"(platform: "/mobile") {}
    "/bill_payments/ticket_data"(platform: "/mobile") {}
    "/bill_payments/fee"(platform: "/mobile"){}
    "/bill_payments/generic_paybills_screen"(platform: "/mobile") {}
    "/bill_payments/categories"(platform: "/mobile") {
        categoryProperties
    }
    "/bill_payments/barcode_scanner"(platform: "/mobile") {}
    "/bill_payments/products"(platform: "/mobile") {
        type (required:true, type: PropertyType.String, description: "Type of product")
        categoryProperties
    }
    "/bill_payments/shopping"(platform: "/mobile") {}
    "/bill_payments/input_validation_error"(platform: "/mobile", type: TrackType.Event) {}

    // congrats
    "/bill_payments/congrats"(platform: "/mobile", type: TrackType.View) {}

    "/bill_payments/congrats/receipt"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/congrats/dda"(platform: "/mobile", type: TrackType.Event) {}

}
