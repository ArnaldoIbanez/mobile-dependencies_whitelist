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

    // Generic Erros
    "/bill_payments/generic_error/retry"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/connection_error/retry"(platform: "/mobile", type: TrackType.Event) {}

    // Onboarding
    "/bill_payments/onboarding"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/onboarding/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/onboarding/back_to_home"(platform: "/mobile", type: TrackType.Event) {}

    // Home
    "/bill_payments/home"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/home/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/home/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/home/type_barcode"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/home/scan_barcode"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/home/search_entities"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/home/activity"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/home/activate_digital_invoices"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/home/pay"(platform: "/mobile", type: TrackType.Event) {
        barcode(required: false, type: PropertyType.String, description: "the barcode used to pay")
        product_id(required: false, type: PropertyType.String, description: "the product id used to pay")
    }
    "/bill_payments/home/pay/clipboard"(platform: "/mobile", type: TrackType.Event) {}

    // Invoice
    "/bill_payments/invoices"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/invoices/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/invoices/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/invoices/cancel_dda"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/invoices/pay"(platform: "/mobile", type: TrackType.Event) {
        barcode(required: false, type: PropertyType.String, description: "the barcode used to pay")
        product_id(required: false, type: PropertyType.String, description: "the product id used to pay")
    }

    //Invoice opt_out
    "/bill_payments/invoices/empty_state"(platform: "/mobile", type: TrackType.View) {}

    // Invoice delete
    "/bill_payments/invoices/delete"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/invoices/delete/dialog"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/invoices/delete/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/invoices/delete/cancel"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/invoices/delete/item"(platform: "/mobile", type: TrackType.Event) {
        item (required:false, type: PropertyType.String, description: "The chosen item id")
        entity (required:false, type: PropertyType.String, description: "The chosen item entity")
    }

    // Invoice delete success
    "/bill_payments/invoices/delete/success"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/invoices/delete/success/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/invoices/delete/success/back_to_home"(platform: "/mobile", type: TrackType.Event) {}

    // Invoice menu
    "/bill_payments/menu"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/menu/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/menu/delete_debt"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/menu/dda_optout"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/menu/notification_preference"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/menu/to_subscription_detail"(platform: "/mobile", type: TrackType.Event) {}

    //Invoices subscription
    "/bill_payments/invoices/subscription"(platform: "/mobile", type: TrackType.Event) {
        entity (required: true, type: PropertyType.String, description: "The chosen item entity")
    }

    // Input amount
    "/bill_payments/input_amount"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/input_amount/back"(platform: "/mobile", type: TrackType.Event) {}

    // Product picker
    "/bill_payments/product_picker"(platform: "/mobile", type: TrackType.View) {}

    // Input option
    "/bill_payments/input_option"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/input_option/back"(platform: "/mobile", type: TrackType.Event) {}

    // Input data
    "/bill_payments/input_data"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/input_data/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/input_data/continue"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/input_data/faq"(platform: "/mobile", type: TrackType.Event) {}

    // Input debt id
    "/bill_payments/input_option_debt"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/input_option_debt/back"(platform: "/mobile", type: TrackType.Event) {}

    // Info screen
    "/bill_payments/info_screen"(platform: "/mobile", type: TrackType.View) {
        label(required: false, type: PropertyType.String, description: "the label the info screen")
    }

    "/bill_payments/info_screen/pay_another_service"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/info_screen/back_to_home"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/info_screen/money_in"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/info_screen/continue_unsubscribe_services"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/info_screen/confirm_unsubscribe_services"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/info_screen/search_entities"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/info_screen/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/info_screen/revision_data"(platform: "/mobile", type: TrackType.Event) {}

    // Dialog
    "/bill_payments/dialog"(platform: "/mobile", type: TrackType.View) {
        label(required: false, type: PropertyType.String, description: "the label the dialog")
    }

    // FTU
    "/bill_payments/ftu"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/ftu/close"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/ftu/pay"(platform: "/mobile", type: TrackType.Event) {}

    // FTU digital receipts
    "/bill_payments/ftu_digital_receipts"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/ftu_digital_receipts/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/ftu_digital_receipts/digital_receipts_optin"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/ftu_digital_receipts/terms"(platform: "/mobile", type: TrackType.Event) {}

    // Opt in
    "/bill_payments/opt_in"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/opt_in/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/opt_in/close"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/opt_in/activate"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/opt_in/terms"(platform: "/mobile", type: TrackType.Event) {}

    // Opt out
    "/bill_payments/opt_out"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/opt_out/close"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/opt_out/click"(platform: "/mobile", type: TrackType.Event) {}

    // Barcode manual input
    "/bill_payments/barcode_manual_input"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/barcode_manual_input/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/barcode_manual_input/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/barcode_manual_input/open_scanner"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/barcode_manual_input/continue"(platform: "/mobile", type: TrackType.Event) {
        barcode(required: true, type: PropertyType.String, description: "the barcode used to pay")
    }

    // Payment receipt
    "/bill_payments/receipt"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/receipt/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/receipt/share"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, type: PropertyType.String, description: "provider collector id")
    }
    "/bill_payments/receipt/show"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, type: PropertyType.String, description: "provider collector id")
    }
    "/bill_payments/receipt/retry"(platform: "/mobile", type: TrackType.Event) {
        collector_id(required: false, type: PropertyType.String, description: "provider collector id")
    }
    "/bill_payments/receipt/error"(platform: "/mobile", type: TrackType.Event) {
        description(required: false, type: PropertyType.String, description: "description about scenario")
        collector_id(required: false, type: PropertyType.String, description: "provider collector id")
    }
    "/bill_payments/receipt/error/render"(platform: "/mobile", type: TrackType.Event) {
        description(required: false, type: PropertyType.String, description: "description about scenario")
        collector_id(required: false, type: PropertyType.String, description: "provider collector id")
    }
    "/bill_payments/receipt/error/download_share"(platform: "/mobile", type: TrackType.Event) {
        description(required: false, type: PropertyType.String, description: "description about scenario")
        collector_id(required: false, type: PropertyType.String, description: "provider collector id")
    }

    // Scanner Screen (Old)
    "/bill_payments/scan"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/scan/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/scan/flash"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/scan/type_barcode"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/scan/type_qr"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/scan/click"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/scan/read"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/scan/scan_barcode"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/scan/info_message"(platform: "/mobile", type: TrackType.View) {
        label(required: true, type: PropertyType.String, description: "the label the info message")
    }
    
    "/bill_payments/read"(platform: "/mobile", type: TrackType.Event) {
        barcode(required: true, type: PropertyType.String, description: "the barcode used to pay")
        camera_flash(required: true, type: PropertyType.Boolean, description: "the camera flash is active")
        timestamp(required: true, type: PropertyType.Numeric, description: "the time to scan")
        barcode_format(required: true, type: PropertyType.String, description: "barcode format")
    }

    "/bill_payments/scan/read"(platform: "/mobile", type: TrackType.Event) {
        barcode(required: true, type: PropertyType.String, description: "the barcode used to pay")
        camera_flash(required: true, type: PropertyType.Boolean, description: "the camera flash is active")
        timestamp(required: true, type: PropertyType.Numeric, description: "the time to scan")
        barcode_format(required: true, type: PropertyType.String, description: "barcode format")
    }

    // New Scanner Screen
        "/bill_payments/new_scan"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/new_scan/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/new_scan/flash"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/new_scan/type_barcode"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/new_scan/type_qr"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/new_scan/click"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/new_scan/read"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/new_scan/scan_barcode"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/new_scan/info_message"(platform: "/mobile", type: TrackType.View) {
        label(required: true, type: PropertyType.String, description: "the label the info message")
    }
    "/bill_payments/new_scan/read"(platform: "/mobile", type: TrackType.Event) {
        barcode(required: true, type: PropertyType.String, description: "the barcode used to pay")
        camera_flash(required: true, type: PropertyType.Boolean, description: "the camera flash is active")
        timestamp(required: true, type: PropertyType.Numeric, description: "the time to scan")
        barcode_format(required: true, type: PropertyType.String, description: "barcode format")
    }

    // Error Scanner Screen
    "/bill_payments/scan_error"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/scan_error/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/permission_camera"(platform: "/mobile") {}
    "/bill_payments/enable_camera"(platform: "/mobile") {}

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

    "/bill_payments/main_category/pay"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/category_details/pay"(platform: "/mobile", type: TrackType.Event) {}

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
    
    //checkout 
    "/bill_payments/checkout"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/checkout/lazy_init"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/checkout/utility"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/checkout/utility/error"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/checkout/lazy_init/run"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/checkout/lazy_init/success"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/checkout/lazy_init/error"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/checkout/lazy_init/cancel"(platform: "/mobile", type: TrackType.Event) {}

    // congrats success
    "/bill_payments/congrats"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/congrats/success"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/congrats/receipt"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/congrats/success/receipt"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/congrats/success/warning_pay_hour"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/congrats/success/activate_digital_invoices"(platform: "/mobile", type: TrackType.Event) {}

    // search
    "/bill_payments/search"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/search_error"(platform: "/mobile", type: TrackType.View) {}

    // Contingency screen
    "/bill_payments/contingency_screen"(platform: "/mobile", type: TrackType.View) {
        label(required: false, type: PropertyType.String, description: "the label of contingency screen")
    }

    "/bill_payments/contingency_screen/continue"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/contingency_screen/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/contingency_screen/back_to_home"(platform: "/mobile", type: TrackType.Event) {}

    // schedule payment
    "/bill_payments/schedule_payment"(platform: "/mobile", isAbstract: true) {}

    // schedule payment create
    "/bill_payments/schedule_payment/create"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/schedule_payment/create/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/schedule_payment/create/dialog"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/schedule_payment/create/continue"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/schedule_payment/create/confirm"(platform: "/mobile", type: TrackType.Event) {}

    "/bill_payments/schedule_payment/create/pix"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/schedule_payment/create/pix/continue"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/schedule_payment/create/pix/confirm"(platform: "/mobile", type: TrackType.Event) {}

    // schedule payment success
    "/bill_payments/schedule_payment/create/success"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/schedule_payment/create/success/receipt"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/schedule_payment/create/success/pay_another_service"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/schedule_payment/create/success/back_to_home"(platform: "/mobile", type: TrackType.Event) {}

    // schedule payment list
    "/bill_payments/schedule_payment/list"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/schedule_payment/list/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/schedule_payment/list/dialog"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/schedule_payment/list/selected_item"(platform: "/mobile", type: TrackType.Event) {
        item (required:false, type: PropertyType.String, description: "The chosen schedule id")
        entity (required:false, type: PropertyType.String, description: "The chosen schedule entity")
    }

    // schedule payment details
    "/bill_payments/schedule_payment/list/selected_item/details"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/schedule_payment/list/selected_item/details/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/schedule_payment/list/selected_item/details/dialog"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/schedule_payment/list/selected_item/details/receipt"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/schedule_payment/list/selected_item/details/pay"(platform: "/mobile", type: TrackType.Event) {}

    // schedule payment cancel
    "/bill_payments/schedule_payment/cancel"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/schedule_payment/cancel/pay_another_service"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/schedule_payment/cancel/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/schedule_payment/cancel/back_to_home"(platform: "/mobile", type: TrackType.Event) {}

    // schedule payment retry
    "/bill_payments/schedule_payment/retry"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/schedule_payment/retry/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/schedule_payment/retry/pay"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/schedule_payment/retry/back_to_home"(platform: "/mobile", type: TrackType.Event) {}

    //datail
    "/bill_payments/detail"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/detail/money_in"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/detail/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/detail/receipt"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/detail/cancel"(platform: "/mobile", type: TrackType.Event) {}

    // input
    "/bill_payments/input"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/input/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/input/continue"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/input/helper"(platform: "/mobile", type: TrackType.Event) {}

    // congrats
    "/bill_payments/congrats"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/congrats/receipt"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/congrats/pay_another_service"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/congrats/back_to_home"(platform: "/mobile", type: TrackType.Event) {}

    // home Adhesion/Invoices
    "/bill_payments/home/adhesion_search"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/home/invoices"(platform: "/mobile", type: TrackType.Event) {}

    // main category Scheduling
    "/bill_payments/main_category/scheduling"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/main_category/scheduling/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/main_category/scheduling/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/main_category/scheduling/item"(platform: "/mobile", type: TrackType.Event) {
        entity (required:false, type: PropertyType.String, description: "The chosen entitie label")
        item (required:false, type: PropertyType.String, description: "The chosen item label")
    }
    "/bill_payments/main_category/scheduling/empty_search"(platform: "/mobile", type: TrackType.Event) {
        search (required:true, type: PropertyType.String, description: "The searched string")
    }
    "/bill_payments/main_category/scheduling/result_search"(platform: "/mobile", type: TrackType.Event) {
        search (required:true, type: PropertyType.String, description: "The searched string")
    }

    // Scheduling
    // empty state ftu
    "/bill_payments/empty_state_ftu/scheduling"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/empty_state_ftu/scheduling/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/empty_state_ftu/scheduling/continue"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/empty_state_ftu/scheduling/back"(platform: "/mobile", type: TrackType.Event) {}

    // empty state
    "/bill_payments/empty_state/scheduling"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/empty_state/scheduling/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/empty_state/scheduling/continue"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/empty_state/scheduling/back"(platform: "/mobile", type: TrackType.Event) {}

    // ftu kyc
    "/bill_payments/ftu_kyc/scheduling"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/ftu_kyc/scheduling/continue"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/ftu_kyc/scheduling/back"(platform: "/mobile", type: TrackType.Event) {}

    // required data
    "/bill_payments/required_data/scheduling"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/required_data/scheduling/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/required_data/scheduling/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/required_data/scheduling/button_continue"(platform: "/mobile", type: TrackType.Event) {}

    // confirm optin
    "/bill_payments/confirm_optin/scheduling"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/confirm_optin/scheduling/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/confirm_optin/scheduling/checkbox_selected"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/confirm_optin/scheduling/checkbox_unselected"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/confirm_optin/scheduling/continue"(platform: "/mobile", type: TrackType.Event) {}

    // confirm dda optin
    "/bill_payments/confirm_digital_receipts_optin/scheduling"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/confirm_digital_receipts_optin/scheduling/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/confirm_digital_receipts_optin/scheduling/confirm"(platform: "/mobile", type: TrackType.Event) {}

    // optin list
    "/bill_payments/optin_list/scheduling"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/optin_list/scheduling/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/optin_list/scheduling/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/optin_list/scheduling/search_entities_scheduling"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/optin_list/scheduling"(platform: "/mobile", type: TrackType.Event) {
        entity (required:false, type: PropertyType.String, description: "The chosen entitie label")
    }

    // optout
    "/bill_payments/optout/scheduling"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/optout/scheduling/cancel"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/optout/scheduling/reject_cancel"(platform: "/mobile", type: TrackType.Event) {}

    // optout dda
    "/bill_payments/optout_dda/scheduling"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/optout_dda/scheduling/cancel"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/optout_dda/scheduling/reject_cancel"(platform: "/mobile", type: TrackType.Event) {}

    // adhesion detail
    "/bill_payments/adhesion_detail/scheduling"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/adhesion_detail/scheduling/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/adhesion_detail/scheduling/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/adhesion_detail/scheduling/message_button"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/adhesion_detail/scheduling/notification_preference"(platform: "/mobile", type: TrackType.Event) {}

    // adhesion detail dda
    "/bill_payments/adhesion_detail_dda/scheduling"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/adhesion_detail_dda/scheduling/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/adhesion_detail_dda/scheduling/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/adhesion_detail_dda/scheduling/cancel"(platform: "/mobile", type: TrackType.Event) {}

    // congrat optout
    "/bill_payments/congrats_optout/scheduling"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/congrats_optout/scheduling/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/congrats_optout/scheduling/back_to_home"(platform: "/mobile", type: TrackType.Event) {}

    // congrat optout dda
    "/bill_payments/congrats_optout_dda/scheduling"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/congrats_optout_dda/scheduling/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/congrats_optout_dda/scheduling/back_to_home"(platform: "/mobile", type: TrackType.Event) {}

    // congrat optin
    "/bill_payments/congrats_optin/scheduling"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/congrats_optin/scheduling/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/congrats_optin/scheduling/back_to_home"(platform: "/mobile", type: TrackType.Event) {}

    // congrat optin dda
    "/bill_payments/congrats_optin_dda/scheduling"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/congrats_optin_dda/scheduling/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/congrats_optin_dda/scheduling/back_to_home"(platform: "/mobile", type: TrackType.Event) {}

    // Automatic debits
    // empty state
    "/bill_payments/empty_state/automatic_debit"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/empty_state/automatic_debit/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/empty_state/automatic_debit/continue"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/empty_state/automatic_debit/back"(platform: "/mobile", type: TrackType.Event) {}

    // ftu kyc
    "/bill_payments/ftu_kyc/automatic_debit"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/ftu_kyc/automatic_debit/continue"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/ftu_kyc/automatic_debit/back"(platform: "/mobile", type: TrackType.Event) {}

    // main category Automatic debits
    "/bill_payments/main_category/automatic_debit"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/main_category/automatic_debit/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/main_category/automatic_debit/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/main_category/automatic_debit/item"(platform: "/mobile", type: TrackType.Event) {
        entity (required:false, type: PropertyType.String, description: "The chosen entitie label")
        item (required:false, type: PropertyType.String, description: "The chosen item label")
    }
    "/bill_payments/main_category/automatic_debit/empty_search"(platform: "/mobile", type: TrackType.Event) {
        search (required:true, type: PropertyType.String, description: "The searched string")
    }
    "/bill_payments/main_category/automatic_debit/result_search"(platform: "/mobile", type: TrackType.Event) {
        search (required:true, type: PropertyType.String, description: "The searched string")
    }

    // required data
    "/bill_payments/required_data/automatic_debit"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/required_data/automatic_debit/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/required_data/automatic_debit/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/required_data/automatic_debit/button_continue"(platform: "/mobile", type: TrackType.Event) {}

    // confirm optin
    "/bill_payments/confirm_optin/automatic_debit"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/confirm_optin/automatic_debit/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/confirm_optin/automatic_debit/checkbox_selected"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/confirm_optin/automatic_debit/checkbox_unselected"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/confirm_optin/automatic_debit/continue"(platform: "/mobile", type: TrackType.Event) {}

    // congrat optin
    "/bill_payments/congrats_optin/automatic_debit"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/congrats_optin/automatic_debit/scan_barcode"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/congrats_optin/automatic_debit/message_button"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/congrats_optin/automatic_debit/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/congrats_optin/automatic_debit/back_to_home"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/congrats_optin/automatic_debit/go_to_adhesions"(platform: "/mobile", type: TrackType.Event) {}

    // optin list
    "/bill_payments/optin_list/automatic_debit"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/optin_list/automatic_debit/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/optin_list/automatic_debit/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/optin_list/automatic_debit/search_entities_automatic_debit"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/optin_list/automatic_debit"(platform: "/mobile", type: TrackType.Event) {
        entity (required:false, type: PropertyType.String, description: "The chosen entitie label")
    }

    // adhesion detail
    "/bill_payments/adhesion_detail/automatic_debit"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/adhesion_detail/automatic_debit/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/adhesion_detail/automatic_debit/faq"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/adhesion_detail/automatic_debit/retry"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/adhesion_detail/automatic_debit/cancel"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/adhesion_detail/automatic_debit/to_subscription_detail"(platform: "/mobile", type: TrackType.Event) {}

    // optout
    "/bill_payments/optout/automatic_debit"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/optout/automatic_debit/reject_cancel"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/optout/automatic_debit/cancel"(platform: "/mobile", type: TrackType.Event) {}

    // congrat optout
    "/bill_payments/congrats_optout/automatic_debit"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/congrats_optout/automatic_debit/close"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/congrats_optout/automatic_debit/back"(platform: "/mobile", type: TrackType.Event) {}
    "/bill_payments/congrats_optout/automatic_debit/back_to_home"(platform: "/mobile", type: TrackType.Event) {}

    // Withoutbill
    "/bill_payments/withoutbill"(platform: "/mobile", type: TrackType.View) {}
    "/bill_payments/withoutbill/back"(platform: "/mobile", type: TrackType.Event) {}
}
