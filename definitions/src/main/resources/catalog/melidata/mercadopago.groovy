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
/**/
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

    "/application"(platform:"/mobile", isAbstract: true) {}
    "/application/open"(platform:"/mobile", type: TrackType.Event) { }

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

    // MP Sellers Merchant Services
    "/landing/sellers/mss"(platform: "/web"){
        page_name (type: PropertyType.String, required: true, description: "Landing page unique name")
    }

    "/landing/sellers/mss/click"(platform:"/", type: TrackType.Event) {
        id (type: PropertyType.String, required: false, description: "ID from clicked element")
        label (type: PropertyType.String, required: false, description: "Element text")
        page_name (type: PropertyType.String, required: true, description: "Landing page unique name")
        fixed_fee (type: PropertyType.String, required: false, description: "Fixed Fee")
        advance (type: PropertyType.String, required: false, description: "Advance days")
        advance_fee (type: PropertyType.String, required: false, description: "Advance days fee")
        advance_value (type: PropertyType.String, required: false, description: "Advance fee final value")
        installments (type: PropertyType.String, required: false, description: "Total installments")
        installments_fee (type: PropertyType.String, required: false, description: "Installments fee")
        installments_value (type: PropertyType.String, required: false, description: "Installments final value")
        initial_sale_value (type: PropertyType.String, required: false, description: "Initial sale value")
        final_sale_value (type: PropertyType.String, required: false, description: "Final sale value (with fees)")
    }

    // MP Buyers
    "/landing/buyers"(platform: "/web"){}

    // MP Promotions
    "/landing/promotions"(platform: "/web"){}

    "/landing/formcomercial"(platform: "/", type: TrackType.View) {}

    "/landing/formcomercial/send_email"(platform:"/", type: TrackType.Event) {
      email (type: PropertyType.String, required: true, description: "Email from user")
    }

    // MP Alliance BancoColombioa
    "/alliance"(platform: "/web", isAbstract: true) {}
    "/alliance/landing"(platform: "/", type: TrackType.View) {
           company_name (required:true, description: "name of the allied company")
    }

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

    "/point/buyingflow/shipping_options"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
    }

    "/point/buyingflow/new_address"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
    }

    "/point/buyingflow/payment_methods"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
    }

    "/point/buyingflow/payment_ticket_info"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
    }
    
    "/point/buyingflow/payment_installments"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
    }

    "/point/buyingflow/payment_installments/installments"(platform: "/", type: TrackType.Event) {
      groupCheckoutProperties
    }

    "/point/buyingflow/payment_bank_selector"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
    }

    "/point/buyingflow/payment_new_card"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
    }

    "/point/buyingflow/payment_card_security_code"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
    }

    "/point/buyingflow/payment_review"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
      selected_payment_method_id (type: PropertyType.String, required: false, description: "Selected payment method ID")
      selected_payment_method_type (type: PropertyType.String, required: false, description: "Selected payment method type, ex: credit card")
      installments (type: PropertyType.Numeric, required: false, description: "Selected installments")
    }

    "/point/buyingflow/error"(platform: "/", type: TrackType.View) {
      flow_id (type: PropertyType.String, required: true, description: "Flow ID")
      type (type: PropertyType.String, required: true, description: "Error type")
    }

    "/point/buyingflow/payment_rejected"(platform: "/", type: TrackType.View) {
      groupCheckoutProperties
      selected_payment_method_id (type: PropertyType.String, required: true, description: "Selected payment method ID")
      selected_payment_method_type (type: PropertyType.String, required: false, description: "Selected payment method type, ex: credit card")
      installments (type: PropertyType.Numeric, required: false, description: "Selected installments")
    }

    "/point/buyingflow/payment_review/confirm_purchase"(platform: "/", type: TrackType.Event) {
      groupCheckoutProperties
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

    // Bobinas > Pageviews
    "/merchant_acquisition/flows/paper_rolls"(platform: "/", type: TrackType.View) {
      view (
        type: PropertyType.String,
        required: true, description: "Type of view",
        values: ["order", "registration", "congrats_waiting", "congrats_success", "congrats_registration", "access_denied", "error"]
      )
    }
    "/merchant_acquisition/flows/paper_rolls/modal"(platform: "/", isAbstract: true) {}

    // Bobinas > Events
    "/merchant_acquisition/flows/paper_rolls/complete_form"(platform: "/", type: TrackType.Event) {}
    "/merchant_acquisition/flows/paper_rolls/modal/update_address"(platform: "/", type: TrackType.Event) {}
    "/merchant_acquisition/flows/paper_rolls/modal/add_address"(platform: "/", type: TrackType.Event) {}

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
    "/merchant_acquisition/flows/qr-queue/amount/pos-changed"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/flows/qr-queue/amount/store-changed"(platform:"/", type: TrackType.Event) {}

    "/merchant_acquisition/flows/qr-queue/waiting-payment/retry"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/flows/qr-queue/waiting-payment/extend-time"(platform:"/", type: TrackType.Event) {}

    // Point Transfer
    "/merchant_acquisition/flows/transfer-device"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/transfer-device/success"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/transfer-device/empty"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/transfer-device/error"(platform:"/", type: TrackType.View) {}

    // Point Register
    "/merchant_acquisition/flows/register-device"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/register-device/success"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/register-device/error"(platform:"/", type: TrackType.View) {}

    // Release Options
    "/merchant_acquisition/flows/release-options"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/release-options/success"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/release-options/error"(platform:"/", type: TrackType.View) {}

    // Micrositio - reseller
    "/merchant_acquisition/flows/resellers"(platform:"/", type: TrackType.View) {}
    //bundles
    "/merchant_acquisition/flows/resellers/bundles"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/bundles/click"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/bundles/share"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/bundles/open"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/bundles/close"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    //mgm
    "/merchant_acquisition/flows/resellers/mgm"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/mgm/click"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/mgm/share"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/mgm/open"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/mgm/close"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    //dashboard
    "/merchant_acquisition/flows/resellers/dashboard"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/dashboard/click"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/dashboard/share"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/dashboard/open"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/dashboard/close"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    //benefits
    "/merchant_acquisition/flows/resellers/benefits"(platform:"/", type: TrackType.View) {}
    //metrics
    "/merchant_acquisition/flows/resellers/metrics"(platform:"/", type: TrackType.View) {}
    //associate_device
    "/merchant_acquisition/flows/resellers/associate_device"(platform:"/", type: TrackType.View) {}
    //register_device
    "/merchant_acquisition/flows/resellers/register_device"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/register_device/individual"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/register_device/bundle"(platform:"/", type: TrackType.View) {}
    
    // Share MGM Web > Pageviews
    "/merchant_acquisition/flows"(platform: "/", isAbstract: true) {}
    "/merchant_acquisition/flows/share_mgm"(platform: "/", type: TrackType.View) {}
    "/merchant_acquisition/flows/share_mgm/device"(platform: "/", isAbstract: true) {}

    // Share MGM Web > Events
    "/merchant_acquisition/flows/share_mgm/about_share"(platform: "/", type: TrackType.Event) {}

    "/merchant_acquisition/flows/share_mgm/share_device_button"(platform: "/", type: TrackType.Event) {
      product (type: PropertyType.String, required: true, description: "Name of device, example: 'point-h'")
    }

    "/merchant_acquisition/flows/share_mgm/more_info_device"(platform: "/", type: TrackType.Event) {
      product (type: PropertyType.String, required: true, description: "Name of device, example: 'point-h'")
    }

    "/merchant_acquisition/flows/share_mgm/device/invite"(platform: "/", type: TrackType.Event) {
      media (type: PropertyType.String, required: true, description: "In which channel did the user shared the coupon (ex: Whatsapp)")
      product (type: PropertyType.String, required: true, description: "Name of device, example: 'point-h'")
    }

    "/merchant_acquisition/flows/share_mgm/device/invite/send_email"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {}

    "/merchant_acquisition/flows/share_mgm/banner"(platform: "/", type: TrackType.Event) {
      banner_name (type: PropertyType.String, required: true, description: "Name of banner (ex: Kit promotional)")
    }

    // Associar Point - Micrositio - reseller
    "/merchant_acquisition/flows/resellers/point_register"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/point_register/associate"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/point_register/success"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/point_register/no_account"(platform:"/", type: TrackType.View) {}

    // Envio proactivo QR - Associar QR + Point - qr-point-assignment
    "/merchant_acquisition/flows/qr-point-assignment"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-point-assignment/qr"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-point-assignment/store"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-point-assignment/congrats"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-point-assignment/error"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-point-assignment/unauthorized"(platform:"/", type: TrackType.View) {}

    // Fluxo de reversa Point - autogeração de etiqueta
    "/merchant_acquisition/flows/point_reverse"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/point_reverse/info"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/point_reverse/address"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/point_reverse/success"(platform:"/", type: TrackType.View) {}

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

    //Merchant Acqusition - widgets
    "/merchant_acquisition/widget"(platform:"/", type: TrackType.View) {
        type (type: PropertyType.String, required: true, values: ["reverse-label", "reset-chip"], description: "Widget name, could be reverse-label, bobinas, shipping & more")
    }

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

    // Merchant Acquisition Point Landings: Resellers Form
    "/point/landings/reseller"(platform:"/", type: TrackType.Event) {}

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

    // Services landings
    "/services"(platform: "/", isAbstract: true) {}
    "/services/mkt_landing"(platform: "/web", type: TrackType.View) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
    }
    "/services/mkt_landing/sms"(platform: "/web", type: TrackType.Event) { 
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
    }
    "/services/mkt_landing/copy-clipboard"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
        position (require: true, type: PropertyType.String, values: ["coupon", "steps"], description: "Indicates position of copy button")
    }
    "/services/mkt_landing/button"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
        position (require: true, type: PropertyType.String, values: ["hero", "fixed", "footer"], description: "Indicates position of button in landing")
    }

    // QR Payers Landings
    "/qr_payers"(platform: "/", isAbstract: true) {}
    "/qr_payers/mkt_landing"(platform: "/web", type: TrackType.View) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
    }
    "/qr_payers/mkt_landing/sms"(platform: "/web", type: TrackType.Event) { 
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
    }
    "/qr_payers/mkt_landing/copy-clipboard"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
        position (require: true, type: PropertyType.String, values: ["coupon", "steps"], description: "Indicates position of copy button")
    }
    "/qr_payers/mkt_landing/button"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
        position (require: true, type: PropertyType.String, values: ["hero", "fixed", "footer"], description: "Indicates position of button in landing")
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
    "/point_payment/result/sms"(platform: "/mobile", type: TrackType.View) {}
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
    "/point_payment/ftu_qr"(platform: "/mobile", type: TrackType.View) {}
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
    "/point_payment/onboarding_how_to_charge"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/onboarding_brandname"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/onboarding_chooser"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/push_mcc"(platform: "/mobile", type: TrackType.View) {}

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
    "/point_payment/flow_tracker/flow_error"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/card_tokens_request"(platform: "/mobile", type: TrackType.Event) {}
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
    "/point_payment/flow_tracker/flow_notification_sms_request"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_notification_sms_response"(platform: "/mobile", type: TrackType.Event) {}
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
    "/point_payment/write_concept"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/customer_care"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/start_refund"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/customer_care_success"(platform: "/mobile", type: TrackType.View) {}

    "/point_payment_test"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}
    "/point_payment_test/test_payment"(platform: "/mobile", type: TrackType.View) {}


    "/point_payment/cash"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}
    "/point_payment/cash/ftu"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/cash/congrats"(platform: "/mobile", type: TrackType.View) {}


    "/shortcuts"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}

    "/shortcuts/point"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/scan_qr"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/cellphone_recharge"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/sube_recharge"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/pay_services"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/send_money"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/member_get_member"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/sell_qr"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/open_request"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/credit_enrollment"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/credit_admin"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/techo"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/antenna_tv"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/money_request_with_qr"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/buy_credit"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/gas_station"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/transport"(platform: "/mobile", type: TrackType.Event) {}
    "/shortcuts/coupon"(platform: "/mobile", type: TrackType.Event) {}

    "/get_member/point"(platform: "/mobile", type: TrackType.View) {}

    "/ftu_release"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}
    "/ftu_release/point_app"(platform: "/mobile", type: TrackType.View) {}
    "/ftu_release/point_&_mp_app"(platform: "/mobile", type: TrackType.View) {}

    "/company_info"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}
    "/company_info/on_boarding"(platform: "/mobile", type: TrackType.View) {}
    "/company_info/main"(platform: "/mobile", type: TrackType.View) {}
    "/company_info/brand_name"(platform: "/mobile", type: TrackType.View) {}
    "/company_info/mcc"(platform: "/mobile", type: TrackType.View) {}
    "/company_info/push_soft_descriptor"(platform: "/mobile", type: TrackType.View) {}

    "/point_payment/dashboard"(platform: "/mobile", type: TrackType.View) {}

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

    //MGM Navigation (Android Drawer or iOS Settings)
    def realestate = objectSchemaDefinitions {
        realestate_id(type: PropertyType.String, required: true, description: "The container where we show contents")
        content_id(type: PropertyType.String, required: true, description: "The identification of shown content")
        origin(type: PropertyType.String, required: false, description: "The application that returns the content")
    }

    "/mgm/navigation"(platform: "/mobile", type: TrackType.Event) {
        realestates(required: false, type: PropertyType.ArrayList(PropertyType.Map(realestate)), description: "The realestate information")
    }

    "/bill_payments"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
        session_id (required:false, type: PropertyType.String, description: "Session Id of flow")
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
    "/bill_payments/generic_paybills_screen"(platform: "/mobile") {}
    "/bill_payments/categories"(platform: "/mobile") {}
    "/bill_payments/barcode_scanner"(platform: "/mobile") {}
    "/bill_payments/products"(platform: "/mobile") {
        type (required:true, type: PropertyType.String, description: "Type of product")
    }
    "/bill_payments/shopping"(platform: "/mobile") {}
    "/bill_payments/input_validation_error"(platform: "/mobile", type: TrackType.Event) {}


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
    "/tfs_dashboard/home/general"(platform: "/", type: TrackType.View) {}
    "/tfs_dashboard/home/offline"(platform: "/", type: TrackType.View) {}
    "/tfs_dashboard/home/online"(platform: "/", type: TrackType.View) {}
    "/tfs_dashboard/home/meli"(platform: "/", type: TrackType.View) {}
    "/tfs_dashboard/detail"(platform: "/", type: TrackType.View) {
        chart_id (required: true, type: PropertyType.String, description: "The chart ID of the detail")
        section (required: true, type: PropertyType.String, description: "The section owner of the chart")
    }
    "/tfs_dashboard/compare"(platform: "/", type: TrackType.View) {}
    "/tfs_dashboard/filters"(platform: "/", type: TrackType.View) {}
 
    // Events for dashboard section
    "/tfs_dashboard/tab_selection"(platform: "/", type: TrackType.Event) {
        section (required: true, type: PropertyType.String, description: "The selected section")
    }
    "/tfs_dashboard/hint"(platform: "/", type: TrackType.Event) {
        chart_id (required: true, type: PropertyType.String, description: "The chart ID of the hint")
        section (required: true, type: PropertyType.String, description: "The section owner of the hint")
    }
    "/tfs_dashboard/home/delta"(platform: "/", type: TrackType.Event) {
        chart_id (required: true, type: PropertyType.String, description: "The chart ID of the delta")
        section (required: true, type: PropertyType.String, description: "The section owner of the delta")
    }
    "/tfs_dashboard/detail/delta"(platform: "/", type: TrackType.Event) {
        chart_id (required: true, type: PropertyType.String, description: "The chart ID of the delta")
        section (required: true, type: PropertyType.String, description: "The section owner of the delta")
    }

    //filter definition
    def filter_definition = objectSchemaDefinitions {
        filter_id (type: PropertyType.String, required: true)
        filter_value (type: PropertyType.String, required: true)
    }

    "/tfs_dashboard/home/filters_apply"(platform: "/", type: TrackType.Event) {
        section (required: true, type: PropertyType.String, description: "The section when filter")
        filters (required: true, type: PropertyType.ArrayList(PropertyType.Map(filter_definition)), description: "Filters")
    }
    "/tfs_dashboard/detail/filters_apply"(platform: "/", type: TrackType.Event) {
        chart_id (required: true, type: PropertyType.String, description: "The chart ID when filter")
        section (required: true, type: PropertyType.String, description: "The section when filter")
        filters (required: true, type: PropertyType.ArrayList(PropertyType.Map(filter_definition)), description: "Filters")
    }
    "/tfs_dashboard/compare"(platform: "/", type: TrackType.Event) {
        chart_id (required: false, type: PropertyType.String, description: "The chart ID when compare")
        section (required: false, type: PropertyType.String, description: "The section when compare")
    }

    // Errors for dashboard section
    "/tfs_dashboard/home/error"(platform: "/", type: TrackType.Event) {
        status_code (required: false, type: PropertyType.Numeric, description: "Error status code")
    }
    "/tfs_dashboard/detail/error"(platform: "/", type: TrackType.Event) {
        chart_id (required: true, type: PropertyType.String, description: "The chart ID when error")
        section (required: true, type: PropertyType.String, description: "The section when error")
        status_code (required: false, type: PropertyType.Numeric, description: "Error status code")
    }

    "/tfs_dashboard/home/card"(platform: "/", isAbstract: true) {}
    "/tfs_dashboard/home/card/error"(platform: "/", type: TrackType.Event) {
        chart_id (required: true, type: PropertyType.String, description: "The chart ID when error")
        section (required: true, type: PropertyType.String, description: "The section when error")
        status_code (required: false, type: PropertyType.Numeric, description: "Error status code")
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
    "/withdraw/bacen/ok"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/bacen/cancel"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/bacen/error"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/bacen/open"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/bacen/close"(platform: "/mobile", type: TrackType.View) {}

    "/withdraw/select_bank"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/select_bank/delete_account_modal"(platform:"/mobile", type: TrackType.Event){}    
    "/withdraw/select_bank/delete_account_modal/confirm"(platform:"/mobile", type: TrackType.Event){
        bank_account_id (required: true, description: "Bank account selected to be deleted")
    } 
    "/withdraw/select_bank/delete_account_modal/cancel"(platform:"/mobile", type: TrackType.Event){} 

    "/withdraw/main"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/confirmation"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/make_withdraw"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/add_account"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/congrats"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/error"(platform: "/mobile", isAbstract: true) {}
    "/withdraw/error/generic_error"(platform: "/mobile", type : TrackType.View) {}
    "/withdraw/error/withdraw_failed"(platform: "/mobile", type : TrackType.View) {}
    "/withdraw/error/high_risk"(platform: "/mobile", type : TrackType.View) {}
    "/withdraw/error/uif"(platform: "/mobile", type : TrackType.View) {}
    "/withdraw/delay"(platform: "/mobile", isAbstract : true) {}
    "/withdraw/delay/manual_review"(platform: "/mobile",   type : TrackType.View) {}
    "/withdraw/delay/offline"(platform: "/mobile",   type : TrackType.View) {}
    "/withdraw/uif_change_account"(platform: "/mobile",   type : TrackType.View) {}
    "/withdraw/restriction"(platform: "/mobile", type: TrackType.View) {}

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
    "/settings/cost_calculator"(platform: "/mobile", type: TrackType.View, isAbstract: true, parentPropertiesInherited: false) {}
    "/settings/my_profile"(platform: "/mobile") {}
    "/settings/balance"(platform: "/mobile") {}
    "/settings/my_cards"(platform: "/mobile") {}
    "/settings/my_cards_detail"(platform: "/mobile") {}
    "/settings/pin_status"(platform: "/mobile") {}
    "/settings/verify_pin"(platform: "/mobile") {}
    "/settings/set_pin_code"(platform: "/mobile") {}
    "/settings/about"(platform: "/mobile") {}
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
    "/settings/cost_calculator/detail"(platform: "/mobile", type: TrackType.View) {}
    "/settings/cost_calculator/chooser"(platform: "/mobile", type: TrackType.View) {}
    "/settings/cost_calculator/input"(platform: "/mobile", type: TrackType.View) {}

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

    //Digital Goods
     "/digital_goods"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
        session_id (required:false, type: PropertyType.String, description: "Session Id of flow")
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
    "/digital_goods/recommended_click"(platform: "/mobile", type: TrackType.Event) {}


    "/money_detail"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/money_detail/balance"(platform: "/mobile") {}
    "/money_detail/help_modal"(platform: "/mobile") {}

    //Withdraw
    "/money_detail/withdraw/main"(platform: "/mobile", type: TrackType.View) {}
    "/money_detail/withdraw/confirmation"(platform: "/mobile", type: TrackType.View) {}
    "/money_detail/withdraw/congrats"(platform: "/mobile", type: TrackType.View) {}
    "/money_detail/withdraw/add_account"(platform: "/mobile", type: TrackType.View) {}
    "/money_detail/withdraw/select_bank"(platform: "/mobile", type: TrackType.View) {}    
    "/money_detail/withdraw"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/daily_detail"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/money_advance"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/restrictions"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/point_home"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/manual_code"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/confirmation"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/withdraw/error"(platform: "/mobile", isAbstract: true) {}
    "/money_detail/withdraw/error/high_risk"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/withdraw/error/generic_error"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/withdraw/uif_change_account"(platform: "/mobile",   type : TrackType.View) {}
    "/money_detail/withdraw/delay"(platform: "/mobile", isAbstract: true) {}
    "/money_detail/withdraw/delay/offline"(platform: "/mobile",   type : TrackType.View) {}
    "/money_detail/shopping"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/withdraw/delay/manual_review"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/credits"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/activities"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail"(platform: "/mobile", isAbstract: true) {}

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

    "/my_business"(platform: "/", type: TrackType.View){}
    "/my_business/how_it_works_ME"(platform: "/", type: TrackType.Event){
        how_it_works_me(required: true, type: PropertyType.String, values: ["click", "tap"], description: "Indicates how works the track")
    }
    "/my_business/enable_ME"(platform: "/", type: TrackType.Event){
        mercado_envios(required: true, type: PropertyType.String, values: ["enable", "disable"],description: "Indicates if mercado envios is enabled")
    }
    "/my_business/disable_ME"(platform: "/", type: TrackType.Event){
        mercado_envios(required: true, type: PropertyType.String, values: ["enable", "disable"],description: "Indicates if mercado envios is enabled")
    }

    "/my_business/split_payment"(platform: "/", type: TrackType.Event){
        split_payment(required: true, type: PropertyType.String, values: ["enabled", "disabled"],description: "Indicates if split payment is enabled")
    }
    "/my_business/recovery_mails"(platform: "/", type: TrackType.Event){
        recovery_mails(required: true, type: PropertyType.String, values: ["enabled", "disabled"],description: "Indicates if recovery mail is enabled")
    }
    "/my_business/cost_absorption"(platform: "/", type: TrackType.Event){
        cost_absorption(required: true, type: PropertyType.String, values: ["deactivate", "activate", "modificate"],description: "Indicates cost absorption status")
    }

    //END -- MP personalFrontend

    //MP frontend

    "/fund_account/confirm"(platform: "/web"){}
    "/send_money/confirm"(platform: "/web", type: TrackType.Event){
        flow(required: true, PropertyType.String, description: "The flow of the track")
    }
    "/money_request/confirm"(platform: "/web", type: TrackType.Event){
        flow(required: true, PropertyType.String, description: "The flow of the track")
    }
    "/money_request/congrats"(platform: "/web"){}

    "/campaigns"(platform: "/web", isAbstract: true){}
    "/campaigns/create"(platform: "/web", type: TrackType.View){}
    "/campaigns/confirm_create"(platform: "/web"){}

    "/subscription_plan"(platform: "/web", isAbstract: true){}
    "/subscription_plan/create"(platform: "/web", type: TrackType.View){}
    "/subscription_plan/confirm_create"(platform: "/web"){
        flow(required: true, PropertyType.String, description: "The flow of the track")
        confirmButton(required: true, PropertyType.String, description: "detail of action")
    }
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

    "/stores"(platform: "/", isAbstract: true) {}
    "/stores/create"(platform: "/", type: TrackType.View) {}
    "/stores/link_operators"(platform: "/", type: TrackType.View) {}
    "/stores/list"(platform: "/", type: TrackType.View) {}
    "/stores/update"(platform: "/", type: TrackType.View) {}
    "/stores/details"(platform: "/", type: TrackType.View) {}
    "/stores/pos"(platform: "/", type: TrackType.View, isAbstract:true) {}
    "/stores/pos/create"(platform: "/", type: TrackType.View) {}
    "/stores/pos/update"(platform: "/", type: TrackType.View) {}
    "/stores/standalone_pos"(platform: "/", type: TrackType.View) {}
    "/stores/move_pos"(platform: "/", type: TrackType.View) {}

    //Account mydata
    "/account"(platform: "/web", isAbstract: true) {}
    "/account/mydata"(platform: "/web", isAbstract: true) {}
    "/account/mydata/email"(platform: "/", type: TrackType.View) {}
    "/account/mydata/email/congrats"(platform: "/web", type: TrackType.View) {}

    //Tu negocio
    "/your_business"(platform: "/web", isAbstract: true) {}
    "/your_business/home"(platform: "/web", type: TrackType.View) {}
    "/your_business/image_upload"(platform:"/web", type: TrackType.Event) {}
    "/your_business/mydata_edit"(platform:"/web", type: TrackType.Event) {}
    "/your_business/confirm_action"(platform:"/web", type: TrackType.Event) {
        card_name(required: true, description: "the name of the card that triggered the event", type: PropertyType.String)
    }
    "/your_business/link"(platform:"/web", type: TrackType.Event) {
        card_name(required: true, description: "the name of the card that triggered the event", type: PropertyType.String)
        path(required: true, description: "path of the next page", type: PropertyType.String)
    }

}
