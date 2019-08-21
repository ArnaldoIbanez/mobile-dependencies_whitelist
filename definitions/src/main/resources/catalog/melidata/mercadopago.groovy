import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


/**
*
* The events means actions that happens without launch a View,
* as example of that we can consider Bookmark an item in a VIP page
* Every event is an action, so the verbs available are:
*
* - back:  the event of back from a page, specially in mobile
* - abort: the user abort the action (e.g: back pressed before api response)
* - delete: when something is deleted
* - apply: when a criteria is applied
* - post: create a new entity
*/

tracks {

    propertyDefinitions {
      flow_id (type: PropertyType.String, required: true, description: "Flow ID")
      product (type: PropertyType.String, required: true, description: "Product identifier")
      currency (type: PropertyType.String, required: true, description: "ISO Currency")
      price (type: PropertyType.Numeric, required: true, description: "Price of device")
      is_guest (type: PropertyType.Boolean, required: true, description: "User logged as guest")
    }

    propertyGroups {
      groupCheckoutProperties(flow_id, product, currency, price, is_guest)
    }

    "/"(platform: "/", isAbstract: true) {
    }

    "/"(platform: "/mobile", isAbstract: true) {
        sent_again(required: false)
    }

    "/blog"(platform: "/web", isAbstract: true) {
    }

    "/blog/home"(platform: "/web") {
    }

    // MP Landings Scope
    "/landing"(platform: "/web", isAbstract: true) {}

    // MP Home
    "/landing/home"(platform: "/web"){}

    // MP Sellers
    "/landing/sellers"(platform: "/web"){}

    // MP Sellers Websites
    "/landing/sellers/websites"(platform: "/web"){}

    // MP Sellers Social
    "/landing/sellers/social"(platform: "/web"){}

    // MP Buyers
    "/landing/buyers"(platform: "/web"){}

    // MP Promotions
    "/landing/promotions"(platform: "/web"){}

    "/growth"(platform: "/", isAbstract: true) {}
    "/growth/login"(platform: "/", type: TrackType.View) {
      view (type: PropertyType.String, required: true, description: "Name of view", values: ["split", "guest"])
    }

    "/point/buyingflow"(platform: "/", isAbstract: true) {}

    "/point/buyingflow/start"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
      has_coupon (type: PropertyType.Boolean, required: false, description: "Flag to detect if a sell has coupon")
      coupon_code (type: PropertyType.String, required: false, description: "MGM CuponCode")
    }

    "/point/buyingflow/shippingOptions"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
    }

    "/point/buyingflow/newAddress"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
    }

    "/point/buyingflow/paymentMethods"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
    }
    
    "/point/buyingflow/paymentInstallments"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
    }

    "/point/buyingflow/paymentInstallments/installments"(platform: "/", type: TrackType.Event) {
      groupCheckoutProperties
      installments (type: PropertyType.Numeric, required: false, description: "Selected installments")
    }

    "/point/buyingflow/paymentNewCard"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
    }

    "/point/buyingflow/paymentCardSecurityCode"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
    }

    "/point/buyingflow/paymentReview"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
      selected_payment_method_id (type: PropertyType.String, required: true, description: "Selected payment method ID")
      selected_payment_method_type (type: PropertyType.String, required: false, description: "Selected payment method type, ex: credit card")
      installments (type: PropertyType.Numeric, required: false, description: "Selected installments")
    }

    "/point/buyingflow/error"(platform: "/", type: TrackType.View) {
      flow_id (type: PropertyType.String, required: true, description: "Flow ID")
      type (type: PropertyType.String, required: true, description: "Error type")
    }

    "/point/buyingflow/paymentRejected"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
      selected_payment_method_id (type: PropertyType.String, required: true, description: "Selected payment method ID")
      selected_payment_method_type (type: PropertyType.String, required: false, description: "Selected payment method type, ex: credit card")
      installments (type: PropertyType.Numeric, required: false, description: "Selected installments")
    }

    "/point/buyingflow/paymentReview/confirmPurchase"(platform: "/", type: TrackType.Event) {
      groupCheckoutProperties
      selected_payment_method_id (type: PropertyType.String, required: true, description: "Selected payment method ID")
      selected_payment_method_type (type: PropertyType.String, required: false, description: "Selected payment method type, ex: credit card")
      installments (type: PropertyType.Numeric, required: false, description: "Selected installments")
    }

    "/point"(platform: "/", isAbstract: true) {}

    // Merchant Acquisition
    "/merchant_acquisition"(platform: "/", isAbstract: true) {}
    "/merchant_acquisition/qr"(platform: "/", isAbstract: true) {}
    "/merchant_acquisition/flows"(platform: "/", isAbstract: true) {}

    // QR Assignment > Pageviews
    "/merchant_acquisition/flows/qr-assignment"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-assignment/success"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-assignment/error"(platform:"/", type: TrackType.View) {
       status (type: PropertyType.String, required: true, description: "Error Status, ex: invalidAccess, error")
    }

    // QR Assignment > Events
    "/merchant_acquisition/flows/qr-assignment/validate_email"(platform:"/", type: TrackType.Event) {
      valid (type: PropertyType.Boolean, required: true, description: "Ex: true or false")
    }
    "/merchant_acquisition/flows/qr-assignment/qr_scan"(platform:"/", type: TrackType.Event) {
      qr_content (type: PropertyType.String, required: true, description: "Ex: http://qrContent")
    }

    // Point Pro Solicitud Bobinas > Pageviews
    "/merchant_acquisition/flows/paper_rolls"(platform: "/", type: TrackType.View) {
      view (type: PropertyType.String, required: true, description: "Type of view", values: ["order", "registration", "congrats_waiting", "congrats_success", "congrats_registration", "access_denied", "error"])
    }

    // QR Queue Web > Pageviews
    "/merchant_acquisition/flows/qr-queue"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-queue/amount"(platform:"/", type: TrackType.View) {
        onboarding (type: PropertyType.Boolean, required: true, description: "Flag that determines if onboarding was shown. Ex: true / false")
    }
    "/merchant_acquisition/flows/qr-queue/waiting-payment"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-queue/congrats"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-queue/error"(platform:"/", type: TrackType.View) {}

    // QR Queue Web > Events
    "/merchant_acquisition/flows/qr-queue/amount/download"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/flows/qr-queue/amount/print"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/flows/qr-queue/amount/replace-amount"(platform:"/", type: TrackType.Event) {}

    "/merchant_acquisition/flows/qr-queue/waiting-payment/retry"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/flows/qr-queue/waiting-payment/extend-time"(platform:"/", type: TrackType.Event) {}

    // QR Landing > Pageviews
    "/merchant_acquisition/qr/landing"(platform:"/", type: TrackType.View) {}

    // QR Landing > Events
    "/merchant_acquisition/qr/landing/promotions"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/qr/landing/video"(platform:"/", type: TrackType.Event) {
        value (values: ["hero", "afterhero"], type: PropertyType.String, required: true, description: "Section where the trigger it is placed. Could be hero/afterHero")
        trigger (type: PropertyType.String, required: true, description: "button that triggers the qr video")
    }
    "/merchant_acquisition/qr/landing/landing-get-qr-code"(platform:"/", type: TrackType.Event) {}

    // QR Flow > Pageviews
    "/merchant_acquisition/qr/onboarding"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/qr/qr-code"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/qr/pending"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/qr/error"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/qr/settings"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/qr/permission-denied"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/qr/web-mobile"(platform:"/", type: TrackType.View) {}

    // QR Flow > Events
    "/merchant_acquisition/qr/qr-code/download"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/qr/qr-code/print"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/qr/qr-code/faqs"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/qr/qr-code/help"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/qr/qr-code/rates"(platform:"/", type: TrackType.Event) {}

    // MMC Flow > PageViews
    "/merchant_acquisition/mydata"(platform: "/", isAbstract: true) {}
    "/merchant_acquisition/mydata/edit"(platform: "/", type: TrackType.View) {}
    "/merchant_acquisition/mydata/success"(platform: "/", type: TrackType.View) {}

    // Merchant Acqusition Point Landings - Set Language In Chinese
    // "/merchant_acquisition"(platform: "/", isAbstract: true) {}
    "/merchant_acquisition/point-landings"(platform: "/", isAbstract: true) {}
    "/merchant_acquisition/point-landings/app-chinese"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/point-landings/app-chinese/error"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/point-landings/app-chinese/success"(platform:"/", type: TrackType.View) {}

    // Merchant Acquisition Point Landings
    "/point/landings"(platform: "/") {
        product (type: PropertyType.String, required: true, description: "Name of device, example: 'point-h'")
        currency (type: PropertyType.String, required: false, description: "Currency")
        price (type: PropertyType.Numeric, required: false, description: "Price of device")
        has_coupon (type: PropertyType.Boolean, required: false, description: "Flag to detect if a sell has coupon")
        coupon_code (type: PropertyType.String, required: false, description: "MGM CuponCode")
        coupon_type (type: PropertyType.String, required: false, values: ["default", "mgm", "campaign"], description: "Kind of MGM Coupon: default | mgm | campaign")
        discount (type: PropertyType.Numeric, required: false, description: "Discount in price")
        price_with_discount (type: PropertyType.Numeric, required: false, description: "Total price")
    }
    
    "/point/landings/buy"(platform:"/", type: TrackType.Event) {}

    // Merchant Acquisition Point Landings: MGM > Events
    "/point/landings/mgm"(platform: "/", isAbstract: true) {}
    "/point/landings/mgm/share"(platform:"/", type: TrackType.Event) {}
    "/point/landings/mgm/ios"(platform:"/", type: TrackType.Event) {}
    "/point/landings/mgm/android"(platform:"/", type: TrackType.Event) {}
    "/point/landings/mgm/prepago"(platform:"/", type: TrackType.Event) {}
    "/point/landings/mgm/tyc"(platform:"/", type: TrackType.Event) {}

    // Point Flows
    "/point/flows"(platform: "/", isAbstract: true) {}
    "/point/flows/congrats"(platform:"/", type: TrackType.View) {
        payment_id (required: true, type: PropertyType.Numeric, description: "ID of payment")
        payment_method (required: true, type: PropertyType.String, description: "Method of payment")
        device_id (required: true, type: PropertyType.String, description: "ID of Point device")
        amount (required: true, type: PropertyType.Numeric, description: "Ticket amount")
        is_guest (required: true, type: PropertyType.Boolean, description: "Guest user flag")
    }

    "/point/flows/congrats/instructions"(platform:"/", type: TrackType.View) {}

    // Point Flows Events
    //Congrats ON
    "/point/flows/congrats/print"(platform:"/", type: TrackType.Event) {}
    "/point/flows/congrats/copy"(platform:"/", type: TrackType.Event) {}
    "/point/flows/congrats/map"(platform:"/", type: TrackType.Event) {}
    "/point/flows/congrats/prepaid_offer_refuse"(platform:"/", type: TrackType.Event) {}
    "/point/flows/congrats/prepaid_offer_register"(platform:"/", type: TrackType.Event) {}
    "/point/flows/congrats/prepaid_offer_accept"(platform:"/", type: TrackType.Event) {}
    "/point/flows/congrats/continue"(platform:"/", type: TrackType.Event) {}
    "/point/flows/congrats/unlockprepaid"(platform:"/", type: TrackType.Event) {}
    "/point/flows/congrats/followprepaid"(platform:"/", type: TrackType.Event) {}

    //congrats OFF
    "/point/flows/congrats/instructions/prepaid_offer_refuse"(platform:"/", type: TrackType.Event) {}
    "/point/flows/congrats/instructions/prepaid_offer_register"(platform:"/", type: TrackType.Event) {}
    "/point/flows/congrats/instructions/prepaid_offer_accept"(platform:"/", type: TrackType.Event) {}
    "/point/flows/congrats/instructions/continue"(platform:"/", type: TrackType.Event) {}
    "/point/flows/congrats/instructions/unlockprepaid"(platform:"/", type: TrackType.Event) {}
    "/point/flows/congrats/instructions/followprepaid"(platform:"/", type: TrackType.Event) {}
    "/point/flows/congrats/instructions/print"(platform:"/", type: TrackType.Event) {}
    "/point/flows/congrats/instructions/copy"(platform:"/", type: TrackType.Event) {}
    "/point/flows/congrats/instructions/map"(platform:"/", type: TrackType.Event) {}


    //Point Devices
    "/point/landings/landing_bundles_buy"(platform:"/", type: TrackType.Event) {
        quantity (required:true, type: PropertyType.Numeric, description: "bundle quantity")
    }

    // Payers Growth Landings
    "/payers_growth"(platform: "/", isAbstract: true) {}
    "/payers_growth/landings"(platform: "/") {
        product (type: PropertyType.String, required: true, description: "Product name, example: 'mkt-combustibles'")
    }

    // MP Mobile Point
    "/point_payment"(platform: "/mobile", type: TrackType.View) {
        flow_id (required: false, type: PropertyType.String, description: "Flow id.")
        from (required: false, type: PropertyType.String, description: "Where the flow start")
        method (required: false, type: PropertyType.String, description: "Card reading method swipe/dip/tap", values: ["swipe", "dip", "tap", "chip"])
        currency (required: false, type: PropertyType.String, description: "Transaction currency")
        amount (required: false, type: PropertyType.String, description: "Transaction amount")
        installments (required: false, type: PropertyType.String, description: "Installments amount")
        payment_status (required: false, type: PropertyType.String, description: "Payment result status")
        payment_detail (required: false, type: PropertyType.String, description: "Payment result detail")
        reason (required: false, type: PropertyType.String, description: "Payment reason")
        poi (required: false, type: PropertyType.String, description: "Device serial number")
        poi_type (required: false, type: PropertyType.String, description: "Type of device")
        payment_method_id (required: false, type: PropertyType.String, description: "Payment Method used")
        operator_id (required: false, type: PropertyType.String, description: "Operator identification")
        flow (required: false, type: PropertyType.String, description: "Flow")
        error_msg (required:false, type: PropertyType.String, description: "Error shown to seller")
    }

    "/pos_mobile"(platform: "/mobile", type: TrackType.Event) {}
    "/pos_mobile/friction"(platform: "/mobile", type: TrackType.Event) {
        flow_id(required: false, type: PropertyType.String, description: "Flow id.")
        id(required: true, type: PropertyType.String, description: "Flow id.")
        context(required: true, type: PropertyType.String, description: "Context friction")
        style(required: true, type: PropertyType.String, description: "Style showed, window, dialog, toast.. ", values: ["dialog", "window", "snackbar", "toast"])
        message(required: true, type: PropertyType.String, description: "Message showed ")
        attributable_to(required: true, type: PropertyType.String, description: "User, Phone, Device, network or card", values: ["user", "reader", "network", "device", "card"])
        extra_info(required: false, type: PropertyType.String, description: "Extra info")
    }

    def PosSellerFrictionMessage = objectSchemaDefinitions {
        style(type: PropertyType.String, required: true)
        title(type: PropertyType.String, required: true)
        content(type: PropertyType.String, required: true)
        primary_button(type: PropertyType.String, required: false)
        secondary_button(type: PropertyType.String, required: false)
    }

    def PosSellerFrictionExtraInfo = objectSchemaDefinitions {
        poi(type: PropertyType.String, required: false)
        progress(type: PropertyType.Numeric, required: false)
    }

    "/pos_seller"(platform: "/mobile", type: TrackType.Event, isAbstract: true) {}
    "/pos_seller/friction"(platform: "/mobile", type: TrackType.Event, isAbstract: true) {
        context (required: true, type: PropertyType.String, description: "Friction context")
        message (required: true, type: PropertyType.Map(PosSellerFrictionMessage), description: "Message shown map")
        attributable_to(required: true, type: PropertyType.String, values: ["user", "reader", "network", "device", "card", "unknown"], description: "Friction main category reason")
        extra_info (required: false, type: PropertyType.Map(PosSellerFrictionExtraInfo), description: "Friction extra data map")
    }
    "/pos_seller/friction/device_comm_error"(platform: "/mobile", type: TrackType.Event) {}
    "/pos_seller/friction/server_comm_error"(platform: "/mobile", type: TrackType.Event) {}
    "/pos_seller/friction/battery_low_error"(platform: "/mobile", type: TrackType.Event) {}
    "/pos_seller/friction/reader_update_failed"(platform: "/mobile", type: TrackType.Event) {}

    //TODO: The flow_origin field must be changed to mandatory, when all the productive versions send this information
    "/point_payment/main"(platform: "/mobile", type: TrackType.View) {
        flow_origin (required: false, type: PropertyType.String, values: ["point", "qr", "chooser","share_social"])
    }
    "/point_payment/card"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/installments"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/card_type"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/signature"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/security_code"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/identification_number"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/result"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/error"(platform: "/mobile", type: TrackType.View) {
        from (required:false, type: PropertyType.String, description: "Where the flow start")
        error_msg (required:false, type: PropertyType.String, description: "Error shown to seller")
    }
    "/point_payment/new_payment_entry_point"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/send_bill_congrats"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/send_sms"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/error_i_have_an_issue"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/error/generic"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/error/rejected"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/request_bluetooth"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/ftu_preorder_pax"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing_chooser"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/selector"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/send_bill"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/point_ftu_newland"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/idempotency"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/point"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/qr_ftu"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/bank_selection"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/select_connected_device"(platform: "/mobile", type: TrackType.View) {
         devices (required:false, type: PropertyType.String, description: "paired devices")
    }
    "/point_payment/link_share"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/link"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/qr"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/device_selection"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/qr_show_code"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/request_location"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/user_identification"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/ftu_preorder_bbpos"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/ftu_preorder_newland"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing_pax_turn_on"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing_bbposbt_device_selection"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing_bbposbt_turn_on"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/cart"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/permission_screen"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/deals"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing_newland_device_selection"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing_newland_turn_on"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/error/ownership"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/error/low_battery"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/web_view"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing/problem"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing/problem/help"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/bbpos_connectivity_help_web_view"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/qr_congrats"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/qr_congrats_nofee"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/bank_detail"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing_ftu"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/new_payment"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/new_payment/deals"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/new_payment/deals/finantial_costs"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/buyer_email"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/discount"(platform: "/mobile", type: TrackType.View) {}

    "/point_payment/flow_tracker"(platform: "/mobile", type: TrackType.Event, isAbstract: true) {
        flow_id (required: true, type: PropertyType.String, description: "Flow id.")
        user_id (required: false, type: PropertyType.String, description: "User id.")
        level (required: true, type: PropertyType.String, description: "Log level (error|info)", values: ["error", "info"])
        message(required: false, type:  PropertyType.String, description: "message to log")
        data (required: false, type:  PropertyType.String, description: "data to log")
    }

    "/point_payment/flow_tracker/pairing"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/configuration"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/payment_methods_get"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/payment_methods_response"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/card_token_results"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/start"(platform: "/mobile", type: TrackType.Event) {
        description (required: false, type: PropertyType.String, description: "payment description.")
        amount (required: false, type: PropertyType.String, description: "payment amount.")
        discount (required: false, type: PropertyType.String, description: "payment discount")
    }
    "/point_payment/flow_tracker/card_tokens_result"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/payment_methods_request"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/payment_methods_response"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/end"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_next_step_after_payment"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_payment_card_tokens_request_put"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_payment_card_tokens_response_put"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_payment_request"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_payment_response"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_pos_sending_online_process"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_notification_request"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_notification_response"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_pos_error_message"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/select_qr"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/select_point"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/select_link"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/waiting_card"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/select_connected_device"(platform: "/mobile", type: TrackType.Event) {
         devices (required:false, type: PropertyType.String, description: "paired devices")
    }
    "/point_payment/flow_tracker/cancel_qr_charge"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/auto_reverse_off"(platform: "/mobile", type: TrackType.Event) {
        trx_id (required: true, type: PropertyType.String, description: "trx1234567")
    }

    "/settings/point"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}
    "/settings/point/settings"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}
    "/settings/point/costs_calculator"(platform: "/mobile", type: TrackType.View) {}
    "/settings/point/settings/pricing"(platform: "/mobile", type: TrackType.View) {}
    "/settings/point/installment_cost"(platform: "/mobile", type: TrackType.View) {}
    "/settings/point/device_mlb"(platform: "/mobile", type: TrackType.View) {}
    "/settings/pairing"(platform: "/mobile", type: TrackType.View) {}

    "/settings/reader_update"(platform: "/mobile", type: TrackType.View) {
        poi (required: true, type: PropertyType.String, description: "Poi (reader serial number)")
    }
    "/settings/reader_update/onboarding"(platform: "/mobile", type: TrackType.View) {}
    "/settings/reader_update/result"(platform: "/mobile", type: TrackType.View) {}
    "/settings/reader_update/process_completed"(platform: "/mobile", type: TrackType.Event) {
        duration (required: true, type: PropertyType.Numeric, description: "Process duration in seconds")
        previous_version (required: true, type: PropertyType.String, description: "Reader previous firmware version")
        previous_config (required: true, type: PropertyType.String, description: "Reader previous config version")
        new_version (required: true, type: PropertyType.String, description: "Reader firmware version updated")
        new_config (required: true, type: PropertyType.String, description: "Reader config version updated")
    }
    "/settings/reader_update/cancel"(platform: "/mobile", type: TrackType.Event) {
        duration (required: true, type: PropertyType.Numeric, description: "Process duration in seconds before cancel")
        time_remaining (required: true, type: PropertyType.Numeric, description: "Estimated time remaining before cancel")
        progress (required: true, type: PropertyType.Numeric, description: "Update progress at cancel")
    }

    "/shortcuts"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}
    "/shortcuts/point"(platform: "/mobile", type: TrackType.Event) {}

    "/get_member/point"(platform: "/mobile", type: TrackType.View) {}

    "/ftu_release"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}
    "/ftu_release/point_app"(platform: "/mobile", type: TrackType.View) {}
    "/ftu_release/point_&_mp_app"(platform: "/mobile", type: TrackType.View) {}

    "/company_info"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}
    "/company_info/on_boarding"(platform: "/mobile", type: TrackType.View) {}

    "/dashboard"(platform: "/mobile", type: TrackType.View) {}

    // MP Point Standalone (a eliminar cuando inhabilitemos la app de point)

    "/card"(platform: "/mobile", type: TrackType.View) {}
    "/card_number"(platform: "/mobile", type: TrackType.View) {}
    "/card_type"(platform: "/mobile", type: TrackType.View) {}
    "/card_name"(platform: "/mobile", type: TrackType.View) {}
    "/help_web_view"(platform: "/mobile", type: TrackType.View) {}

    // MP Mobile Point Catalog

    "/catalog"(platform: "/mobile", type: TrackType.View) {}
    "/catalog/create_product"(platform: "/mobile", type: TrackType.View) {}
    "/catalog/create_product/picture"(platform: "/mobile", type: TrackType.View) {}
    "/catalog/discount"(platform: "/mobile", type: TrackType.View) {}

    // MPMOBILE
    "/account_summary"(platform: "/mobile") {
        from (required:false, type: PropertyType.String, description: "Where the flow start", values:["/deep_link_ml","/deep_link","push"])
    }
    "/account_summary/filters"(platform: "/mobile") {}
    "/account_summary/filtered_list"(platform: "/mobile") {}

    "/activity_detail"(platform: "/mobile") { }
    "/transaction_detail"(platform: "/mobile") { }
    "/social_detail"(platform: "/mobile") { }
    "/event_detail"(platform: "/mobile") { }

    "/shopping"(platform: "/mobile") {
        from (required:false, type: PropertyType.String, description: "Where the flow start") }
    "/crop_image"(platform: "/mobile") { }

    "/login"(platform: "/mobile", isAbstract: true) {
        flow (required:false, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/login/splitter"(platform: "/mobile", type: TrackType.View) {}
    "/login/sign_in"(platform: "/mobile", type: TrackType.View) {}
    "/login/sign_up"(platform: "/mobile", type: TrackType.View) {}
    "/login/identification"(platform: "/mobile") {}

    "/sign_in"(platform: "/mobile", type: TrackType.View) {
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/sign_in/sso"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
    }
    "/sign_in/smart_lock"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
        description (required:false, type: PropertyType.String, description: "Status description")
    }
    "/sign_in/recovery_account_button"(platform: "/mobile", type: TrackType.Event) {
        label (required:false, type: PropertyType.String, description: "Status")
    }
    "/sign_in/facebook"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
        description (required:false, type: PropertyType.String, description: "Status description")
    }
    "/sign_in/google"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
        description (required:false, type: PropertyType.String, description: "Status description")
    }
    "/sign_in/mail"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
        description (required:false, type: PropertyType.String, description: "Status description")
    }
    "/sign_up"(platform: "/mobile", isAbstract: true) {
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/sign_up/facebook"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
    }
    "/sign_up/google"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
    }
    "/sign_up/mail"(platform: "/mobile", type: TrackType.Event) {
        label (required:true, type: PropertyType.String, description: "Status")
        description (required:false, type: PropertyType.String, description: "Status description")
    }

    "/camera"(platform: "/mobile/android", type: TrackType.View) {
        from (required:false, type: PropertyType.String, description: "Where the Camera start in picture profile or person validataion in android")
    }

    "/login_success"(platform: "/mobile/ios", type: TrackType.View) {
        from (required:false, type: PropertyType.String, description: "When user login success in ios")
    }

    "/send_money"(platform: "/", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/send_money/fill_transaction_data"(platform: "/mobile") {}
    "/send_money/pay"(platform: "/mobile") {}
    "/send_money/deals"(platform: "/mobile") {}
    "/send_money/deals/terms"(platform: "/mobile") {}
    "/send_money/payment_methods"(platform: "/mobile") {}
    "/send_money/other_payment_methods"(platform: "/mobile") {}
    "/send_money/cards"(platform: "/mobile") {}
    "/send_money/add_card"(platform: "/mobile") {}
    "/send_money/issuers"(platform: "/mobile") {}
    "/send_money/my_cards"(platform: "/mobile") {}
    "/send_money/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }
    "/send_money/bacen"(platform: "/mobile", isAbstract: true) {}
    "/send_money/bacen/ok"(platform: "/mobile") {}
    "/send_money/bacen/cancel"(platform: "/mobile") {}
    "/send_money/bacen/error"(platform: "/mobile") {}
    "/send_money/bacen/open"(platform: "/mobile") {}
    "/send_money/bacen/close"(platform: "/mobile") {}


    "/checkout"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/checkout/pay"(platform: "/mobile") {}
    "/checkout/deals"(platform: "/mobile") {}
    "/checkout/deals/terms"(platform: "/mobile") {}
    "/checkout/payment_methods"(platform: "/mobile") {}
    "/checkout/other_payment_methods"(platform: "/mobile") {}
    "/checkout/cards"(platform: "/mobile") {}
    "/checkout/add_card"(platform: "/mobile") {}
    "/checkout/issuers"(platform: "/mobile") {}
    "/checkout/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/qr_code"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/qr_code/qr_reader"(platform: "/mobile") {}
    "/qr_code/fill_transaction_data"(platform: "/mobile") {}
    "/qr_code/pay"(platform: "/mobile") {}
    "/qr_code/deals"(platform: "/mobile") {}
    "/qr_code/deals/terms"(platform: "/mobile") {}
    "/qr_code/payment_methods"(platform: "/mobile") {}
    "/qr_code/other_payment_methods"(platform: "/mobile") {}
    "/qr_code/cards"(platform: "/mobile") {}
    "/qr_code/add_card"(platform: "/mobile") {}
    "/qr_code/issuers"(platform: "/mobile") {}
    "/qr_code/my_cards"(platform: "/mobile") {}
    "/qr_code/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }
    "/qr_code/px_payment_method_search"(platform: "/mobile") {}
    "/qr_code/px_discount_summary"(platform: "/mobile") {}
    "/qr_code/px_card_vault"(platform: "/mobile") {}
    "/qr_code/px_card_number"(platform: "/mobile") {}
    "/qr_code/px_card_holder_name"(platform: "/mobile") {}
    "/qr_code/px_card_expiry_date"(platform: "/mobile") {}
    "/qr_code/px_card_security_code"(platform: "/mobile") {}
    "/qr_code/px_identification_number"(platform: "/mobile") {}
    "/qr_code/px_card_issuers"(platform: "/mobile") {}
    "/qr_code/px_card_installments"(platform: "/mobile") {}
    "/qr_code/px_review_and_confirm"(platform: "/mobile") {}
    "/qr_code/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/qr_read"(platform: "/mobile", isAbstract: true) {}
    "/qr_read/store"(platform: "/mobile") {
        _label (required:true, type: PropertyType.String, description: "Operation status")
        deep_link (required:false, type: PropertyType.String, description: "Navigation info")
        qr_info (required:false, type: PropertyType.String, description: "Data read")
        additional_info (required:false, description: "Extra info")
    }

    "/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/pay_preference"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/pay_preference/fetch_preference_info"(platform: "/mobile") {}
    "/pay_preference/px_payment_method_search"(platform: "/mobile") {}
    "/pay_preference/px_payer_cost"(platform: "/mobile") {}
    "/pay_preference/px_card_number"(platform: "/mobile") {}
    "/pay_preference/px_card_vault"(platform: "/mobile") {}
    "/pay_preference/px_card_holder"(platform: "/mobile") {}
    "/pay_preference/px_card_holder_name"(platform: "/mobile") {}
    "/pay_preference/px_card_issuers"(platform: "/mobile") {}
    "/pay_preference/px_card_installments"(platform: "/mobile") {}
    "/pay_preference/px_card_expiry_date"(platform: "/mobile") {}
    "/pay_preference/px_card_security_code"(platform: "/mobile") {}
    "/pay_preference/px_identification_number"(platform: "/mobile") {}
    "/pay_preference/px_review_and_confirm"(platform: "/mobile") {}
    "/pay_preference/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }


    "/scheduled_recharge"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/scheduled_recharge/detail"(platform: "/mobile") {}
    "/scheduled_recharge/empty_recharges"(platform: "/mobile") {}
    "/scheduled_recharge/all_scheduled"(platform: "/mobile") {}
    "/scheduled_recharge/frequency"(platform: "/mobile") {}
    "/scheduled_recharge/weekly_option"(platform: "/mobile") {}
    "/scheduled_recharge/monthly_option"(platform: "/mobile") {}
    "/scheduled_recharge/suggested_recent_recharges"(platform: "/mobile") {}
    "/scheduled_recharge/carries"(platform: "/mobile") {}
    "/scheduled_recharge/recommended"(platform: "/mobile") {}
    "/scheduled_recharge/packages"(platform: "/mobile") {}
    "/scheduled_recharge/manual_amount"(platform: "/mobile") {}
    "/scheduled_recharge/px_payment_method_search"(platform: "/mobile") {}
    "/scheduled_recharge/px_discount_summary"(platform: "/mobile") {}
    "/scheduled_recharge/px_card_vault"(platform: "/mobile") {}
    "/scheduled_recharge/px_card_number"(platform: "/mobile") {}
    "/scheduled_recharge/px_card_holder_name"(platform: "/mobile") {}
    "/scheduled_recharge/px_card_expiry_date"(platform: "/mobile") {}
    "/scheduled_recharge/px_card_security_code"(platform: "/mobile") {}
    "/scheduled_recharge/px_identification_number"(platform: "/mobile") {}
    "/scheduled_recharge/px_card_issuers"(platform: "/mobile") {}
    "/scheduled_recharge/px_card_installments"(platform: "/mobile") {}
    "/scheduled_recharge/px_review_and_confirm"(platform: "/mobile") {}
    "/scheduled_recharge/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/get_member"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/get_member/invite"(platform: "/mobile") {
        scope(required: true, type: PropertyType.String, description: "The scope from where it has been executed")
    }
    "/get_member/invite/invite"(platform: "/mobile", type: TrackType.Event) {}
    "/get_member/redeem"(platform: "/mobile") {}

    "/get_member/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/bill_payments"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/bill_payments/help"(platform: "/mobile") {}
    "/bill_payments/associated_entities"(platform: "/mobile") {}
    "/bill_payments/no_money"(platform: "/mobile") {}
    "/bill_payments/permissions_rationale"(platform: "/mobile") {}
    "/bill_payments/scan"(platform: "/mobile") {}
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


    "/money_request"(platform: "/", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/money_request/picker"(platform: "/mobile") {}
    "/money_request/fill_transaction_data"(platform: "/mobile") {}
    "/money_request/social_share"(platform: "/mobile") {}
    "/money_request/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    // Traks for dashboard section
    "/tfs_dashboard"(platform: "/", isAbstract: true) {}
    "/tfs_dashboard/home"(platform: "/", type: TrackType.View) {}
    "/tfs_dashboard/detail"(platform: "/", type: TrackType.View) {
        chart (required: true, type: PropertyType.String, description: "The chart ID of the detail")
        section (required: true, type: PropertyType.String, description: "The section owner of the chart")
    }

    //tracks for new flow (withdraw and new account)
    "/new-withdraw"(platform: "/", type: TrackType.View) {}
    "/new-withdraw/confirm"(platform: "/", type: TrackType.View) {
        type (required: true, type: PropertyType.String, description: "tipo de confirm")
        type_detail (required: true, type: PropertyType.String, description: "detalle de confirm")
    }
    "/new-withdraw/account-select"(platform: "/", type: TrackType.View) {}
    "/new-withdraw/second-password"(platform: "/", type: TrackType.View) {}
    "/new-withdraw/congrats"(platform: "/", type: TrackType.View) {}
    "/new-withdraw/congrats-advance"(platform: "/", type: TrackType.View) {}
    "/new-account"(platform: "/", type: TrackType.View) {}

    "/withdraw"(platform: "/", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/withdraw/take_money_out"(platform: "/") {}
    "/withdraw/withdrawable_money"(platform: "/mobile") {}
    "/withdraw/select_bank"(platform: "/mobile") {}
    "/withdraw/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/withdraw_advance"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/withdraw_advance/take_money_out"(platform: "/mobile") {}
    "/withdraw_advance/select_bank"(platform: "/mobile") {}
    "/withdraw_advance/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }
    "/withdraw/bacen"(platform: "/mobile", isAbstract: true) {}
    "/withdraw/bacen/ok"(platform: "/mobile") {}
    "/withdraw/bacen/cancel"(platform: "/mobile") {}
    "/withdraw/bacen/error"(platform: "/mobile") {}
    "/withdraw/bacen/open"(platform: "/mobile") {}
    "/withdraw/bacen/close"(platform: "/mobile") {}

    "/fund_account"(platform: "/", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/fund_account/fund_amount"(platform: "/mobile") {}
    "/fund_account/other_payment_methods"(platform: "/mobile") {}
    "/fund_account/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/settings"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/settings/my_profile"(platform: "/mobile") {}
    "/settings/balance"(platform: "/mobile") {}
    "/settings/my_cards"(platform: "/mobile") {}
    "/settings/my_cards_detail"(platform: "/mobile") {}
    "/settings/pin_status"(platform: "/mobile") {}
    "/settings/verify_pin"(platform: "/mobile") {}
    "/settings/set_pin_code"(platform: "/mobile") {}
    "/settings/about"(platform: "/mobile") {}

    "/settings/pricing"(platform: "/mobile", type: TrackType.Event) {
        channel (required: true, type: PropertyType.String, description: "The channel that was modified")
        payment_method (required: true, type: PropertyType.String, description: "The payment method that was modified")
        old_release_days (required: true, type: PropertyType.Numeric, description: "The old release day configuration")
        new_release_days (required: true, type: PropertyType.Numeric, description: "The new release day configuration")
    }

    "/associate_phone"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/associate_phone/sync_phone"(platform: "/mobile") {}
    "/associate_phone/verify_pin"(platform: "/mobile") {}
    "/associate_phone/synced_phone"(platform: "/mobile") {}

    /**
     * NOTIFICATIONS
     * disclaimer: when the action_type is set, the event_type should be always 'open'
     **/
    "/notification"(platform: "/mobile") {
        event_type(required: true,
                values: ["sent", "arrived", "received", "dismiss", "discarded", "open", "auto_dismiss", "shown", "purged_token"],
        description: "Type of notification event")

        notification_type(required: false,
                values: ["deep_linking", "directions", "favorite", "reply", "ask", "postpone", "twitter_bar", "picture", "answer", "messages", "vop", "claims", "received", "tracking", "shipping_print_label", "feedback", "buy"])

        news_id(required: false, description: "Identifier of the notification generated")

        notification_created_error(required: false, description: "The notification created error", type: PropertyType.String)

        device_id(required: false, description: "The real device_id, may differ from device field")

        //For event_type:autodismiss, indicates why the notification was dismissed
        source(required: false, values: ["notification_center","logout","overwrite","dismiss_notification"])

        context(required: false, type: PropertyType.String)

        notification_style(required: false, description: "The notification style used when displaying the notification to the user.")

        discard_reason(required: false, description: "The discarded reason of the notification", values: ["invalid_payload","invalid_user", "settings_disabled"], type: PropertyType.String)
    }

    //Asset Management
    "/notification/asset_management_warm_up"(platform: "/mobile") {}

    //Account
    "/notification/account_fund_approved_ml"(platform: "/mobile") {}
    "/notification/account_fund_approved_mp"(platform: "/mobile") {}
    "/notification/account_fund_salary"(platform: "/mobile") {}
    "/notification/account_balance_approved_mp"(platform: "/mobile") {}
    "/notification/account_balance_approved_ml"(platform: "/mobile") {}

    //Campañas
    "/notification/mpcampaigns_campaigns"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
    }
    "/notification/mpcampaigns_control_group"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        deal_id(required: true, type: PropertyType.String, description: "Id of deal.")
        sent_date(required: true, type: PropertyType.String, description: "Date of send notification.")
    }
    "/notification/mpcampaigns_mpcampaignspromo"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        deal_id(required: true, type: PropertyType.String, description: "Id of deal.")
        sent_date(required: true, type: PropertyType.String, description: "Date of send notification.")
    }
    "/notification/mpcampaigns_mpcampaignsinfo"(platform: "/mobile") {
        campaign_id(required: true, description: "Id of the campaign related to the notification sent.")
        deal_id(required: true, type: PropertyType.String, description: "Id of deal.")
        sent_date(required: true, type: PropertyType.String, description: "Date of send notification.")
    }

    //Credits Merchants
    "/notification/credits_merchants_expired_first_notice"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_merchants_expired_second_notice"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_merchants_expired_third_notice"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_merchants_about_to_expire_first_notice"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_merchants_expired_no_charges"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_merchants_to_expire"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_merchants_expired_near_to_fixed_charges"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_merchants_expired_near_to_daily_charges"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric, description: "Id of installment.")
    }
    "/notification/credits_merchants_to_expire_standard"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_to_expire_not_standard"(platform: "/mobile") {
        installment_id(required: true, type: PropertyType.Numeric)
    }
    "/notification/credits_merchants_educational"(platform: "/mobile") {
        loan_id(required: true, type: PropertyType.Numeric)
    }

    //Compliance Support
    "/notification/compliance_support_validations"(platform: "/mobile") {}

    //Fraud
    "/notification/fraud_cash_release_iv"(platform: "/mobile") {}

    //Health Check
    "/notification/health_check"(platform: "/mobile") {
        original_news_id( required: false, type: PropertyType.String, description: "Original identifier of the notification generated" )
    }

    //Inivite Gift
    "/notification/invite_gift"(platform: "/mobile") {}

    //Messages New
    "/notification/messages_new"(platform: "/mobile") {}

    //Money
    "/notification/money_transfer_received"(platform: "/mobile") {}
    "/notification/money_transfer_request"(platform: "/mobile") {}

    //Loyalty
    "/notification/loyalty_milestone"(platform: "/mobile") {}

    //Prepaid
    "/notification/prepaid_card_shipped"(platform: "/mobile") {}
    "/notification/prepaid_card_waiting_for_withdrawal"(platform: "/mobile") {}
    "/notification/prepaid_card_delivered"(platform: "/mobile") {}
    "/notification/prepaid_card_delayed_p1"(platform: "/mobile") {}
    "/notification/prepaid_card_not_delivered"(platform: "/mobile") {}
    "/notification/prepaid_card_third_activation_reminder"(platform: "/mobile") {}
    "/notification/prepaid_card_second_activation_reminder"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_activation_reminder"(platform: "/mobile") {}
    "/notification/prepaid_card_transaction_rejected_invalid_pin"(platform: "/mobile") {}

    //Point
    "/notification/point_shipping_ready_to_ship"(platform: "/mobile") {}
    "/notification/point_shipping_shipped"(platform: "/mobile") {}
    "/notification/point_shipping_not_delivered"(platform: "/mobile") {}
    "/notification/point_shipping_waiting_for_withdrawal"(platform: "/mobile") {}
    "/notification/point_shipping_delayed_p1"(platform: "/mobile") {}
    "/notification/point_shipping_delayed_p4_p8"(platform: "/mobile") {}
    "/notification/point_shipping_ready_to_ship_delayed"(platform: "/mobile") {}

    //Recurring Recharge
    "/notification/recurring_recharge_insufficient_balance_error"(platform: "/mobile") {}

    //Security
    "/notification/security_event_feedback"(platform: "/mobile") {}

    //Questions
    "/notification/questions_new"(platform: "/mobile") {
        question_id(required: true, type: PropertyType.Numeric)
    }

    //Seller QR
    "/notification/seller_qr_payment_received"(platform: "/mobile") {}
    "/notification/seller_integrations_new_payment"(platform: "/mobile") {}
    "/notification/seller_integrations_erase_name"(platform: "/mobile") {}

    //Orders New
    "/notification/orders_new"(platform: "/mobile") {
        order_id(required: true, type: PropertyType.Numeric)
    }

    //Wallet
    "/notification/wallet_integrator_insufficient_amount"(platform: "/mobile") {}

    //Withdraw
    "/notification/withdraw_approved_contingency"(platform: "/mobile") {}

    //Digital Goods
     "/digital_goods"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/digital_goods/list"(platform: "/mobile") {}
    "/digital_goods/no_money"(platform: "/mobile") {}
    "/digital_goods/search_entities"(platform: "/mobile") {}
    "/digital_goods/products"(platform: "/mobile") {
        type (required:true, type: PropertyType.String, description: "Option")
    }
    "/digital_goods/px_payment_method_search"(platform: "/mobile") {}
    "/digital_goods/px_discount_summary"(platform: "/mobile") {}
    "/digital_goods/px_card_vault"(platform: "/mobile") {}
    "/digital_goods/px_card_number"(platform: "/mobile") {}
    "/digital_goods/px_card_holder_name"(platform: "/mobile") {}
    "/digital_goods/px_card_expiry_date"(platform: "/mobile") {}
    "/digital_goods/px_card_security_code"(platform: "/mobile") {}
    "/digital_goods/px_identification_number"(platform: "/mobile") {}
    "/digital_goods/px_card_issuers"(platform: "/mobile") {}
    "/digital_goods/px_card_installments"(platform: "/mobile") {}
    "/digital_goods/px_review_and_confirm"(platform: "/mobile") {}
    "/digital_goods/px_result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }
    "/digital_goods/terms_and_conditions"(platform: "/mobile") {}


    "/money_detail"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/money_detail/balance"(platform: "/mobile") {}
    "/money_detail/help_modal"(platform: "/mobile") {}

    /**
     * END NOTIFICATIONS
     **/

    // END -- MPMOBILE

    //MP listings
    "/listings"(platform: "/web", isAbstract: true){}
    "/listings/movements"(platform: "/web", type: TrackType.View){}
    "/listings/with_holdings"(platform: "/web", type: TrackType.View){}

    //MP personalFrontend
    "/tools"(platform: "/web", isAbstract: true){}

    "/tools/list"(platform: "/web", type: TrackType.View){}
    "/tools/list/button_create"(platform: "/web"){}

    "/tools/create"(platform: "/web", type: TrackType.View){}
    "/tools/confirm_create_edit"(platform: "/web"){}

    "/charts"(platform: "/web", isAbstract: true){}
    "/charts/show"(platform: "/web", type: TrackType.View){}

    "/balance"(platform: "/web", isAbstract: true){}
    "/balance/reports"(platform: "/web", type: TrackType.View){}

    "/my_business"(platform: "/web", type: TrackType.View){}
    "/my_business/how_it_works_ME"(platform: "/web"){}
    "/my_business/enable_ME"(platform: "/web"){}
    "/my_business/disable_ME"(platform: "/web"){}

    "/my_business/split_payment"(platform: "/web"){}
    "/my_business/recovery_mails"(platform: "/web"){}
    "/my_business/cost_absorption"(platform: "/web"){}

    //END -- MP personalFrontend

    //MP frontend

    "/fund_account/confirm"(platform: "/web"){}
    "/send_money/confirm"(platform: "/web"){}
    "/money_request/confirm"(platform: "/web"){}
    "/money_request/congrats"(platform: "/web"){}

    "/campaigns"(platform: "/web", isAbstract: true){}
    "/campaigns/create"(platform: "/web", type: TrackType.View){}
    "/campaigns/confirm_create"(platform: "/web"){}

    "/subscription_plan"(platform: "/web", isAbstract: true){}
    "/subscription_plan/create"(platform: "/web", type: TrackType.View){}
    "/subscription_plan/confirm_create"(platform: "/web"){}
    //END -- MP frontend

    "/free_navigation"(platform:"/mobile", isAbstract: true) {}

    "/free_navigation/not_available"(platform:"/mobile", type:TrackType.Event) {}

    "/free_navigation/wifi"(platform:"/mobile", type:TrackType.Event) {}

    "/device_settings/"(platform: "/", isAbstract: true){}

    "/device_settings/notifications"(platform: "/mobile/android", type:TrackType.Event) {
        device_id(required: true, description: "The real device_id, may differ from device field")
        enable(required:true, type:PropertyType.Boolean, description: "Indicates if settings are enabled")
        registration_id(required: false, description: "The registration id", type: PropertyType.String)
    }

    // Single Player Frontend Views
    "/single_player"(platform: "/", isAbstract: true) {}
    "/single_player/entertainment"(platform: "/web", type: TrackType.View) {}
    "/single_player/services"(platform: "/web", type: TrackType.View) {}
    "/single_player/sube"(platform: "/web", type: TrackType.View) {}
    "/single_player/transport"(platform: "/web", type: TrackType.View) {}

    // Single Player Frontend Events
    "/single_player/send_sms"(platform:"/web", type: TrackType.Event) {
        activity (type: PropertyType.String, required: true, values: ["entertainment", "services", "sube", "transport"], description: "Activity type when send sms")
        status (type: PropertyType.String, required: true, values: ["OK", "ERROR"], description: "Indicate if SMS was send")
    }

    "/single_player/open_deep_link"(platform:"/web/mobile", type: TrackType.Event) {
        activity (type: PropertyType.String, required: true, values: ["entertainment", "services", "sube", "transport"], description: "where open link from sms")
    }

    "/stores"(platform: "/web", isAbstract: true) {}
    "/stores/create"(platform: "/web", type: TrackType.View) {}
    "/stores/link_operators"(platform: "/web", type: TrackType.View) {}
    "/stores/list"(platform: "/web", type: TrackType.View) {}
    "/stores/update"(platform: "/web", type: TrackType.View) {}
    "/stores/details"(platform: "/web", type: TrackType.View) {}
    "/stores/pos"(platform: "/web", type: TrackType.View, isAbstract:true) {}
    "/stores/pos/create"(platform: "/web", type: TrackType.View) {}
    "/stores/pos/update"(platform: "/web", type: TrackType.View) {}

}



