package catalog.melidata

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

    "/"(platform: "/", isAbstract: true) {
    }

    "/"(platform: "/mobile", isAbstract: true) {
        sent_again(required: false)
    }

    "/blog"(platform: "/web", isAbstract: true, initiative: "1145") {
    }

    "/blog/home"(platform: "/web") {
    }

    "/application"(platform:"/mobile", isAbstract: true, initiative: "1096") {}
    "/application/open"(platform:"/mobile", type: TrackType.Event) { }

    "/point"(platform: "/", isAbstract: true, initiative: "1175") {}

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

    // [POG] Landings Point > Multipricing experiment
    "/point/landings/buy/low_price" (platform:"/", type: TrackType.Event) {}
    "/point/landings/buy/low_tax" (platform:"/", type: TrackType.Event) {}

    // [Merchants Growth] Multiproduct
    "/point/landings/multiproduct"(platform:"/", type: TrackType.View) {}

    // [Merchants Growth] Landing Multiproduct > Events
    "/point/landings/multiproduct/buy"(platform:"/", type: TrackType.Event) {}
    "/point/landings/multiproduct/compare"(platform:"/", type: TrackType.Event) {}
    "/point/landings/multiproduct/go"(platform:"/", type: TrackType.Event) {}

    // [Merchants Growth] Landings Navigation > Events
    "/point/landings/navigation"(platform:"/", type: TrackType.Event) {}
    
    // [Merchants Growth] Landings Navigation > Calculator link
    "/point/landings/calculator"(platform:"/", type: TrackType.Event) {}

    // [Merchants Growth] Landings Navigation > Security module link
    "/point/landings/security"(platform:"/", type: TrackType.Event) {}

    // [Merchants Growth] Landing compare
    "/point/landings/compare"(platform:"/", type: TrackType.View) {}

    // [Merchants Growth] Landing compare > Events
    "/point/landings/compare/buy"(platform:"/", type: TrackType.Event) {}
    "/point/landings/compare/go"(platform:"/", type: TrackType.Event) {}

    // Merchant Acquisition Point Landings: MGM > Events
    "/point/landings/mgm"(platform: "/", isAbstract: true) {}
    "/point/landings/mgm/share"(platform:"/", type: TrackType.Event) {}
    "/point/landings/mgm/ios"(platform:"/", type: TrackType.Event) {}
    "/point/landings/mgm/android"(platform:"/", type: TrackType.Event) {}
    "/point/landings/mgm/prepago"(platform:"/", type: TrackType.Event) {}
    "/point/landings/mgm/tyc"(platform:"/", type: TrackType.Event) {}

    // Merchant Acquisition Point Landings: Resellers Form
    "/point/landings/reseller"(platform:"/", type: TrackType.Event) {}
    "/point/landings/reseller/congrats"(platform:"/", type: TrackType.Event) {}

    // [POG] Landings Point > Click to call experiment
    "/point/landings/click_to_call" (platform:"/", isAbstract: true) {}
    "/point/landings/click_to_call/open_form" (platform:"/", type: TrackType.Event) {}
    "/point/landings/click_to_call/submit_form" (platform:"/", type: TrackType.Event) {}
    "/point/landings/click_to_call/resubmit_form" (platform:"/", type: TrackType.Event) {}
    "/point/landings/click_to_call/congrats" (platform:"/", type: TrackType.Event) {
        type (required: true, type: PropertyType.String, description: "success")
        action (required: true, type: PropertyType.String, description: "open")
    }


    //Point Devices
    "/point/landings/landing_bundles_buy"(platform:"/", type: TrackType.Event) {
        quantity (required:true, type: PropertyType.Numeric, description: "bundle quantity")
    }
    
    "/pos_mobile"(platform: "/mobile", type: TrackType.Event, initiative: "1175") {}
    "/pos_mobile/friction"(platform: "/mobile", type: TrackType.Event) {
        flow_id(required: false, type: PropertyType.String, description: "Flow id.")
        id(required: true, type: PropertyType.String, description: "Flow id.")
        context(required: true, type: PropertyType.String, description: "Context friction")
        style(required: true, type: PropertyType.String, description: "Style showed, window, dialog, toast.. ", values: ["dialog", "window", "snackbar", "toast"])
        message(required: true, type: PropertyType.String, description: "Message showed ")
        attributable_to(required: true, type: PropertyType.String, description: "User, Phone, Device, network or card", values: ["user", "reader", "network", "device", "card"])
        extra_info(required: false, type: PropertyType.String, description: "Extra info")
    }

    "/shortcuts"(platform: "/mobile", type: TrackType.View, isAbstract: true, initiative: "1125" ) {}

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

    "/ftu_release"(platform: "/mobile", type: TrackType.View, isAbstract: true, initiative: "1159") {}
    "/ftu_release/point_app"(platform: "/mobile", type: TrackType.View) {}
    "/ftu_release/point_&_mp_app"(platform: "/mobile", type: TrackType.View) {}

    "/company_info"(platform: "/mobile", type: TrackType.View, isAbstract: true, initiative: "1046") {}
    "/company_info/on_boarding"(platform: "/mobile", type: TrackType.View) {}
    "/company_info/main"(platform: "/mobile", type: TrackType.View) {}
    "/company_info/brand_name"(platform: "/mobile", type: TrackType.View) {}
    "/company_info/mcc"(platform: "/mobile", type: TrackType.View) {}
    "/company_info/push_soft_descriptor"(platform: "/mobile", type: TrackType.View) {}

    // MP Point Standalone (a eliminar cuando inhabilitemos la app de point)

    "/card"(platform: "/mobile", type: TrackType.View, initiative: "1046") {}
    "/card_number"(platform: "/mobile", type: TrackType.View, initiative: "1046") {}
    "/card_type"(platform: "/mobile", type: TrackType.View, initiative: "1046") {}
    "/card_name"(platform: "/mobile", type: TrackType.View, initiative: "1046") {}
    "/help_web_view"(platform: "/mobile", type: TrackType.View, initiative: "1046") {}

    // MP Mobile Point Catalog

    "/catalog"(platform: "/mobile", type: TrackType.View, initiative: "1029") {}
    "/catalog/create_product"(platform: "/mobile", type: TrackType.View) {}
    "/catalog/create_product/picture"(platform: "/mobile", type: TrackType.View) {}
    "/catalog/discount"(platform: "/mobile", type: TrackType.View) {}

    // MPMOBILE
    "/account_summary"(platform: "/mobile", initiative: "1074") {
        from (required:false, type: PropertyType.String, description: "Where the flow start", values:["/deep_link_ml","/deep_link","push"])
    }
    "/account_summary/filters"(platform: "/mobile") {}
    "/account_summary/filtered_list"(platform: "/mobile") {}


    "/transaction_detail"(platform: "/mobile", initiative: "1100") { }
    "/social_detail"(platform: "/mobile", initiative: "1100") { }
    "/event_detail"(platform: "/mobile", initiative: "1100") { }


    "/crop_image"(platform: "/mobile", initiative: "1100") { }

    "/checkout"(platform: "/mobile", isAbstract: true, initiative: "1142") {
        flow (required:false, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/checkout/pay"(platform: "/mobile",initiative: "1142") {}
    "/checkout/deals"(platform: "/mobile",initiative: "1142") {}
    "/checkout/deals/terms"(platform: "/mobile",initiative: "1142") {}
    "/checkout/payment_methods"(platform: "/mobile",initiative: "1142") {}
    "/checkout/other_payment_methods"(platform: "/mobile",initiative: "1142") {}
    "/checkout/cards"(platform: "/mobile",initiative: "1142") {}
    "/checkout/add_card"(platform: "/mobile",initiative: "1142") {}
    "/checkout/issuers"(platform: "/mobile",initiative: "1142") {}
    "/checkout/result"(platform: "/mobile",initiative: "1142") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }


    "/px_result"(platform: "/mobile", initiative: "1142") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/pay_preference"(platform: "/mobile", isAbstract: true,initiative: "1142") {
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


    "/scheduled_recharge"(platform: "/mobile", isAbstract: true, initiative: "1142") {
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

    "/get_member"(platform: "/mobile", isAbstract: true, initiative: "1046") {
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

    "/get_member/point"(platform: "/mobile", type: TrackType.View, initiative: "1159") {}

    "/settings"(platform: "/mobile", isAbstract: true,initiative: "1074" ) {
        flow (required:false, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/settings/cost_calculator"(platform: "/mobile", type: TrackType.View, isAbstract: true, parentPropertiesInherited: false,initiative: "1125") {
        sent_again (required: false)
        flow (required:false, type: PropertyType.String, description: "Use case that has been executed")
        cost_type (required:false, type: PropertyType.String, description: "Cost type receive/charge")
    }
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

    "/settings/cost_calculator/detail/action_button"(platform: "/mobile", type: TrackType.Event) {
        amount(required: true, type: PropertyType.Numeric, description: "Amount calculated by cost_calculator")
        method(required: true, type: PropertyType.String, values: ["point", "qr", "share_social"], description: "Method simulated by seller")
        payment_financing(required: true, type: PropertyType.String, values: ["credit", "debit", "account_money"], description: "Payment financing selected by seller")
        installments(required: true, type: PropertyType.Numeric, description: "Installments simulated by seller")
    }

    "/settings/cost_calculator/chooser"(platform: "/mobile", type: TrackType.View) {}
    "/settings/cost_calculator/input"(platform: "/mobile", type: TrackType.View) {}
    "/settings/help"(platform: "/mobile", type: TrackType.View) {}

    "/settings/pricing"(platform: "/mobile", type: TrackType.Event) {
        channel (required: true, type: PropertyType.String, description: "The channel that was modified")
        payment_method (required: true, type: PropertyType.String, description: "The payment method that was modified")
        old_release_days (required: true, type: PropertyType.Numeric, description: "The old release day configuration")
        new_release_days (required: true, type: PropertyType.Numeric, description: "The new release day configuration")
    }

    /**
     * END NOTIFICATIONS
     **/

    // END -- MPMOBILE

    //MP listings
    "/listings"(platform: "/web", isAbstract: true,initiative: "1074"){}
    "/listings/movements"(platform: "/web", type: TrackType.View){}
    "/listings/with_holdings"(platform: "/web", type: TrackType.View){}

    //MP frontend

    "/campaigns"(platform: "/web", isAbstract: true, initiative: "1175"){}
    "/campaigns/create"(platform: "/web", type: TrackType.View){}
    "/campaigns/confirm_create"(platform: "/web"){}

    "/subscription_plan"(platform: "/web", isAbstract: true, initiative: "1036"){}
    "/subscription_plan/create"(platform: "/web", type: TrackType.View){}
    "/subscription_plan/confirm_create"(platform: "/web"){
        flow(required: true, PropertyType.String, description: "The flow of the track")
        confirmButton(required: true, PropertyType.String, description: "detail of action")
    }
    //END -- MP frontend

    "/device_settings/"(platform: "/", isAbstract: true,initiative: "1096" ){}

    "/device_settings/notifications"(platform: "/mobile/android", type:TrackType.Event) {
        device_id(required: true, description: "The real device_id, may differ from device field")
        enable(required:true, type:PropertyType.Boolean, description: "Indicates if settings are enabled")
        registration_id(required: false, description: "The registration id", type: PropertyType.String)
    }

    // Single Player Frontend Views
    "/single_player"(platform: "/", isAbstract: true, initiative: "1131") {}
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

    // About events
    "/about"(platform: "/mobile", isAbstract: true) {}
    "/about/rate_app"(platform:"/mobile", type:TrackType.Event, initiative: "1074") {}

    /**
    * Register Point Devices
    */
    "/point/register"(platform: "/", isAbstract: true, initiative : "1300") {}

    // Register device
    "/point/register/start"(platform: "/", type: TrackType.View) {}
    "/point/register/start/insert_code"(platform: "/", type: TrackType.Event) {}

    // Store crate
    "/point/register/store_create"(platform: "/", type: TrackType.View) {}
    "/point/register/store_create/done"(platform: "/", type: TrackType.Event) {}

    // Point of sale create
    "/point/register/pos_create"(platform: "/", type: TrackType.View) {}
    "/point/register/pos_create/done"(platform: "/", type: TrackType.Event) {}
    "/point/register/pos_create/cancel"(platform: "/", type: TrackType.Event) {}

    // Point of sale select
    "/point/register/pos_select"(platform: "/", type: TrackType.View) {}
    "/point/register/pos_create"(platform: "/", type: TrackType.Event) {}
    "/point/register/pos_select/done"(platform: "/", type: TrackType.Event) {}

    // Store select
    "/point/register/store_select"(platform: "/", type: TrackType.View) {}
    "/point/register/store_create"(platform: "/", type: TrackType.Event) {}
    "/point/register/store_select/done"(platform: "/", type: TrackType.Event) {}

    // Congrats
    "/point/register/end"(platform: "/", type: TrackType.View) {}

    // Access denied
    "/point/register/access_denied"(platform: "/", type: TrackType.View) {}

}
