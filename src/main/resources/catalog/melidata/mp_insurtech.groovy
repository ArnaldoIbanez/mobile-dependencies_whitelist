package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1212"

    // INSURTECH RODA Structures

    def roda_device = objectSchemaDefinitions {
        brand(required: true, type: PropertyType.String, description: "Brand of device. For ex: Samsung.")
        model(required: false, type: PropertyType.String, description: "Model of the device. For ex: J7. Send by provider.")
        model_code(required: false, type: PropertyType.String, description: "Model code of the device. For ex: SM-J700M. Get from native.")
        size(required: true, type: PropertyType.String, description: "Size of the device. For ex: 64GB.")
        device_code(required: false, type: PropertyType.String, description: "device code to quote. For ex: diw387_1u1")
    }

    def roda_option = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "ID of RODA option plan to purchase.")
        coverage(required: true, type: PropertyType.String, description: "Coverage of the option. For ex: theft_break, theft, break, accident.")
        price(required: true, type: PropertyType.Numeric, description: "Price of the option.")
        monthly_price(required: true, type: PropertyType.Numeric, description: "Monthly price of the option.")
        fee_price(required: true, type: PropertyType.Numeric, description: "Fee price for meli of the option.")
        currency_id(required: true, type: PropertyType.String, description: "Currency id of the option. For ex: BRL.")
        deductible_amount(required: true, type: PropertyType.Numeric, description: "Deductible amount of the option.")
        check(required: true, type: PropertyType.String, description: "Check HW required. For ex: total.")
        gtin(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "GLobal Trade Item Numer")
        discount_rate(required: true, type: PropertyType.Numeric, description: "Discount rate applied to the option. If 0 then, no discount.")
        insured_amount(required: false, type: PropertyType.Numeric, description: "insured amount")
        item_cost(required: false, type: PropertyType.Numeric, description: "item cost")
        franchise_type(required: false, type: PropertyType.String, values: ["PREV_OPEN_CLAIM", "IN_COMPENSATION"], description: "franchise type")
        available_resolution_types(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "available resolution types")
        allowed_opening(required: false, type: PropertyType.Numeric, description: "allowed opening")
        compensation_money_amount(required: false, type: PropertyType.Numeric, description: "compensation money amount")
    }

    def roda_option_short = objectSchemaDefinitions {
        coverage(required: true, type: PropertyType.String, description: "Coverage of the option. For ex: theft_break, theft, break, accident.")
        price(required: true, type: PropertyType.Numeric, description: "Price of the option.")
        deductible_amount(required: true, type: PropertyType.Numeric, description: "Deductible amount of the option.")
        gtin(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "Global Trade Item Numer")
        discount_rate(required: true, type: PropertyType.Numeric, description: "Discount rate applied to the option. If 0 then, no discount.")
        insured_amount(required: false, type: PropertyType.Numeric, description: "insured amount")
        item_cost(required: false, type: PropertyType.Numeric, description: "item cost")
        franchise_type(required: false, type: PropertyType.String, values: ["PREV_OPEN_CLAIM", "IN_COMPENSATION"], description: "franchise type")
        available_resolution_types(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "available resolution types")
        allowed_opening(required: false, type: PropertyType.Numeric, description: "allowed opening")
        compensation_money_amount(required: false, type: PropertyType.Numeric, description: "compensation money amount")
    }

    def protection_short = objectSchemaDefinitions {
        product_id(required: true, type: PropertyType.String, values: ['garex', 'roda', 'cards'], description: "Product id of the protection.")
        insurance_purchase_key(required: true, type: PropertyType.String, description: "Insurance purchase key associated to the protection.")
    }

    def claim_short = objectSchemaDefinitions {
        product_id(required: true, type: PropertyType.String, values: ['garex', 'roda', 'cards'], description: "Product id of the claim.")
        insurance_purchase_key(required: true, type: PropertyType.String, description: "Insurance purchase key associated to the claim.")
    }

    def my_protections_roda = objectSchemaDefinitions {
        has_protections(required: true, type: PropertyType.Boolean, description: "This is true if the user has RODA protections")
        has_claims(required: true, type: PropertyType.Boolean, description: "This is true if the user has claims")
        is_current_device_protected(required: true, type: PropertyType.Boolean, description: "This is true if the current device of the track is already protected for RODA")
        is_current_device_quotable(required: true, type: PropertyType.Boolean, description: "This is true if the current device is quotable for RODA")
        offered(required: true, type: PropertyType.Boolean, description: "This is true if the RODA protection has been offered to the user")
    }

    def my_protections_garex = objectSchemaDefinitions {
        has_protections(required: true, type: PropertyType.Boolean, description: "This is true if the user has GAREX protections")
        has_claims(required: true, type: PropertyType.Boolean, description: "This is true if the user has claims")
        offered(required: true, type: PropertyType.Boolean, description: "This is true if the GAREX protection has been offered to the user")
    }

    def claim_roda = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "ID of claim associated to the RODA protection.")
        franchise_payment_id(required: false, type: PropertyType.Numeric, description: "ID of payment associated to the franchise.")
        franchise_payment_amount(required: false, type: PropertyType.Numeric, description: "Amount associated to the franchise payment.")
        status_detail(required: false, type: PropertyType.String, description: "Detailed status of the claim")
    }

    def my_protections_cards = objectSchemaDefinitions {
        has_protections(required: true, type: PropertyType.Boolean, description: "This is true if the user has GAREX protections")
        has_claims(required: true, type: PropertyType.Boolean, description: "This is true if the user has claims")
    }

    def protection_particular_roda = objectSchemaDefinitions {
        amount_total(required: true, type: PropertyType.Numeric, description: "Total Price of the purchased option plan.")
        amount_fee(required: true, type: PropertyType.Numeric, description: "Fee amount obtained by meli for the purchased option plan.")
        option_check(required: true, type: PropertyType.String, values: ['total', 'screen'], description: "Level of the hardware check. For ex: total, screen.")
        option_coverage(required: true, type: PropertyType.String, values: ['theft_break', 'theft', 'break', 'screen'], description: "Coverage of the acquired protection. For ex: theft, break, screen, theft_break.")
        deductible_amount(required: true, type: PropertyType.Numeric, description: "Deductible amount of the option.")
        is_current_device_protection(required: true, type: PropertyType.Boolean, description: "This is true if the current device of the track is the one related to this protection.")
    }

    def protection_particular_garex = objectSchemaDefinitions {
        amount_total(required: false, type: PropertyType.Numeric, description: "Total Price of the purchased option plan.")
        amount_fee(required: false, type: PropertyType.Numeric, description: "Fee amount obtained by meli for the purchased option plan.")
    }

    def protection_base = objectSchemaDefinitions {
        insurance_purchase_key(required: false, type: PropertyType.String, description: "Insurance purchase key associated to the RODA protection.")
        entity_type(required: false, type: PropertyType.String, description: "Entity type insurtech product ", values: ["quote", "order", "item_id"])
        entity_id(required: false, type: PropertyType.String, description: "Entity id of the insurtech product")
        product_type(required: false, type: PropertyType.String, description: "Insurtech product type", values: ["roda", "garex", "cards"])
        product_id(required: false, type: PropertyType.String, description: "Id insurtech product")
        has_open_claim(required: false, type: PropertyType.Boolean, description: "This is true if the protection has an open claim.")
    }

    // INSURTECH CARDS event_data defines
    def option_card_price = objectSchemaDefinitions {
        final_amount(required: true, type: PropertyType.Numeric, description: "final amout of the warranty option price")
        original_amount(required: false, type: PropertyType.Numeric, description: "original amount of the warranty option price")
        discount_rate(required: false, type: PropertyType.Numeric, description: "discount rate of the warranty option price")
        currency_id(required: false, type: PropertyType.String, description: "type of currency of the warranty option price")
        monthly(required: false, type: PropertyType.Numeric, description: "price monthly of the warranty option")
    }

    def option_card_provider = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "id of the warranty provider")
        name(required: false, type: PropertyType.String, description: "name of the warranty provider")
        renevue_share_rate(required: false, type: PropertyType.Numeric, description: "renevue share rate of the warranty option")
    }

    def option_card_coverage = objectSchemaDefinitions {
        name(required: true, type: PropertyType.String, description: "name of the coverage warranty option")
        amount(required: false, type: PropertyType.Numeric, description: "amount of the coverage warranty option")
        currency_id(required: true, type: PropertyType.String, description: "type of currency of the warranty option coverage")
    }

    def option_card_option_data = objectSchemaDefinitions {
        coverage(required: true, PropertyType.Map(option_card_coverage), description: "coverage of the warranty option")
    }

    def card_protection_option = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "id of the warranty option")
        price(required: true, type: PropertyType.Map(option_card_price), description: "price of the warranty option")
        provider(required: false, type: PropertyType.Map(option_card_provider), description: "provider of the warranty otion")
        option_data(required: false, type: PropertyType.Map(option_card_option_data), description: "extra information of the warranty option")
        product_id(required: true, type: PropertyType.String, description: "name/id of the warranty option")
        is_default(required: false, type: PropertyType.Boolean, description: "if option is the default")
    }

    // INSURTECH RODA QPage Abstract
    "/insurtech"(platform: "/", isAbstract: true) {}

    "/insurtech/roda"(platform: "/", isAbstract: true) {}
    "/insurtech/roda/qpage"(platform: "/", isAbstract: true) {}

    "/insurtech/roda/qpage"(platform:"/", type: TrackType.View) {
        client_device(required: true, type: PropertyType.Map(roda_device), description: "Device data entering qpage")
        order_device(required:false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        options(required: false, type: PropertyType.ArrayList(PropertyType.Map(roda_option_short)), description: "Options presented in the qpage for quotation")
        entity_type(required: true, type: PropertyType.String, description: "Entity type insurtech product", values: ['device', 'order'])
        entity_id(required: true, type:  PropertyType.String, description: "Entity id insurtech product")
        item_id(required: false, type: PropertyType.String, description: "id of the item that is offered protection")
        buying_mode(required: true, type: PropertyType.String, values:['buy_it_now', 'subscription'], description: "Type of payment method for purchase")
        discount_code(required: false, type: PropertyType.String, description: "Discount code")
    }

    "/insurtech/roda/qpage/error"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        buying_mode (required: true, type: PropertyType.String, values:['buy_it_now', 'subscription'], description: "type of purchase made")
    }

    "/insurtech/roda/qpage/fallback"(platform: "/", isAbstract: true) {}

    "/insurtech/roda/qpage/fallback/default"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        fallback_type(required: false, type: PropertyType.String, values: ['default', 'order_cancelled', 'skip_hardware_check_expired'], description: "Type of fallback with which I enter the view")
        buying_mode (required: true, type: PropertyType.String, values:['buy_it_now', 'subscription'], description: "type of purchase made")
    }

    "/insurtech/roda/qpage/fallback/skip_expired"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        fallback_type(required: false, type: PropertyType.String, values: ['default', 'order_cancelled', 'skip_hardware_check_expired'], description: "Type of fallback with which I enter the view")
        buying_mode (required: true, type: PropertyType.String, values:['buy_it_now', 'subscription'], description: "type of purchase made")
    }

    "/insurtech/roda/qpage/quoting_fallback"(platform: "/", isAbstract: true) {}
    "/insurtech/roda/qpage/quoting_fallback/default"(platform: "/", isAbstract: true) {}

    "/insurtech/roda/qpage/quoting_fallback/default/quotable"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        fallback_type(required: false, type: PropertyType.String, values: ['default', 'order_cancelled', 'skip_hardware_check_expired'], description: "Type of fallback with which I enter the view")
        quotable(required: true, type: PropertyType.Boolean, description:"If a device is tradable or not")
        buying_mode (required: true, type: PropertyType.String, values:['buy_it_now', 'subscription'], description: "type of purchase made")
    }

    "/insurtech/roda/qpage/quoting_fallback/default/not_quotable"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        fallback_type(required: false, type: PropertyType.String, values: ['default', 'order_cancelled', 'skip_hardware_check_expired'], description: "Type of fallback with which I enter the view")
        quotable(required: true, type: PropertyType.Boolean, description:"If a device is tradable or not")
        buying_mode (required: true, type: PropertyType.String, values:['buy_it_now', 'subscription'], description: "type of purchase made")
    }

    "/insurtech/roda/qpage/quoting_fallback/order_cancelled"(platform: "/", isAbstract: true) {}

    "/insurtech/roda/qpage/quoting_fallback/order_cancelled/quotable"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        fallback_type(required: false, type: PropertyType.String, values: ['default', 'order_cancelled', 'skip_hardware_check_expired'], description: "Type of fallback with which I enter the view")
        quotable(required: true, type: PropertyType.Boolean, description:"If a device is tradable or not")
        buying_mode (required: true, type: PropertyType.String, values:['buy_it_now', 'subscription'], description: "type of purchase made")
    }

    "/insurtech/roda/qpage/quoting_fallback/order_cancelled/not_quotable"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        fallback_type(required: false, type: PropertyType.String, values: ['default', 'order_cancelled', 'skip_hardware_check_expired'], description: "Type of fallback with which I enter the view")
        quotable(required: true, type: PropertyType.Boolean, description:"If a device is tradable or not")
        buying_mode (required: true, type: PropertyType.String, values:['buy_it_now', 'subscription'], description: "type of purchase made")
    }

    "/insurtech/roda/qpage/deductible"(platform:"/", type: TrackType.Event) {
        client_device(required: true, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        buying_mode(required: true, type: PropertyType.String, values:['buy_it_now', 'subscription'], description: "type of purchase made")
        discount_code(required: false, type: PropertyType.String, description: "Discount code")
    }

    "/insurtech/roda/qpage/faq"(platform:"/", type: TrackType.Event) {
        client_device(required: true, type: PropertyType.Map(roda_device), description: "Device data entering qpage")
        order_device(required:false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        entity_type (required: true, type: PropertyType.String, description: "Entity type insurtech product", values: ["device", "order"])
        entity_id (required: true, type:  PropertyType.String, description: "Entity id insurtech product")
        item_id (required: false, type: PropertyType.String, description: "id of the item that is offered protection")
        faq(required: true, type: PropertyType.String, description: "Name of the FAQ viewed. For ex: protection-cancel, deductible-fee")
        buying_mode(required: true, type: PropertyType.String, values:['buy_it_now', 'subscription'], description: "type of purchase made")
        discount_code(required: false, type: PropertyType.String, description: "Discount code")
    }

    "/insurtech/roda/qpage/buy"(platform:"/", type: TrackType.Event) {
        client_device(required: true, type: PropertyType.Map(roda_device), description: "Device data entering qpage")
        order_device(required:false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        option(required: true, type: PropertyType.Map(roda_option), description: "Option plan selected on purchase.")
        entity_type(required: true, type: PropertyType.String, description: "Entity type insurtech product", values: ["device", "order"])
        entity_id(required: true, type:  PropertyType.String, description: "Entity id insurtech product")
        item_id(required: false, type: PropertyType.String, description: "id of the item that is offered protection")
        hardware_check(required: true, type: PropertyType.Boolean, description: "If you require hardware check")
        buying_mode(required: true, type: PropertyType.String, values:['buy_it_now', 'subscription'], description: "type of purchase made")
        discount_code(required: false, type: PropertyType.String, description: "Discount code")
    }

    "/insurtech/roda/qpage/option_selected"(platform:"/", type: TrackType.Event) {
        client_device(required: true, type: PropertyType.Map(roda_device), description: "Device data entering qpage")
        order_device(required:false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        option(required: true, type: PropertyType.Map(roda_option), description: "Option plan selected.")
        entity_type(required: true, type: PropertyType.String, description: "Entity type insurtech product", values: ["device", "order"])
        entity_id(required: true, type:  PropertyType.String, description: "Entity id insurtech product")
        item_id(required: false, type: PropertyType.String, description: "id of the item that is offered protection")
        buying_mode(required: true, type: PropertyType.String, values:['buy_it_now', 'subscription'], description: "type of purchase made")
        discount_code(required: false, type: PropertyType.String, description: "Discount code")
    }

    "/insurtech/roda/qpage/quoting_fallback/default/quotable/select"(platform:"/", type: TrackType.Event) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        fallback_type(required: false, type: PropertyType.String, values: ['default', 'order_cancelled', 'skip_hardware_check_expired'], description: "Type of fallback with which I enter the view")
        quotable(required: true, type: PropertyType.Boolean, description:"If a device is tradable or not")
        buying_mode (required: true, type: PropertyType.String, values:['buy_it_now', 'subscription'], description: "type of purchase made")
    }

    "/insurtech/roda/qpage/quoting_fallback/order_cancelled/quotable/select"(platform:"/", type: TrackType.Event) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        fallback_type(required: false, type: PropertyType.String, values: ['default', 'order_cancelled', 'skip_hardware_check_expired'], description: "Type of fallback with which I enter the view")
        quotable(required: true, type: PropertyType.Boolean, description:"If a device is tradable or not")
        buying_mode (required: true, type: PropertyType.String, values:['buy_it_now', 'subscription'], description: "type of purchase made")
    }

    "/insurtech/roda/qpage/congrats_subscription"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        purchase_id(required: true, type: PropertyType.String, description: "Insurance purchase key id")
        preference_id(required: true, type: PropertyType.String, description: "Subscription payment preference id")
        payment_id(required: true, type: PropertyType.Numeric,  description: "Subscription payment id")
        status(required: true, type: PropertyType.String, values: ['approved', 'pending'], description:"Subscription payment status")
    }

     "/insurtech/roda/qpage/congrats_subscription/go_to_protections"(platform:"/", type: TrackType.Event) {
        purchase_id(required: true, type: PropertyType.String, description: "Insurance purchase key id")
        preference_id(required: true, type: PropertyType.String, description: "Subscription payment preference id")
        payment_id(required: true, type: PropertyType.Numeric,  description: "Subscription payment id")
        status(required: true, type: PropertyType.String, values: ['approved', 'pending'], description:"Subscription payment status")
    }

     "/insurtech/roda/qpage/congrats_subscription/go_to_protection_detail"(platform:"/", type: TrackType.Event) {
        purchase_id(required: true, type: PropertyType.String, description: "Insurance purchase key id")
        preference_id(required: true, type: PropertyType.String, description: "Subscription payment preference id")
        payment_id(required: true, type: PropertyType.Numeric,  description: "Subscription payment id")
        status(required: true, type: PropertyType.String, values: ['approved', 'pending'], description:"Subscription payment status")
    }

    "/insurtech/roda/qpage/onboarding_kyc"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data entering qpage")
        buying_mode(required: true, type: PropertyType.String, values:['buy_it_now', 'subscription'], description: "Type of payment method for purchase")
        quote_intention_id(required: true, type: PropertyType.String, description: "Quote intention id")
    }

    "/insurtech/roda/qpage/onboarding_kyc/go_to_kyc"(platform:"/", type: TrackType.Event) {
    }

    // INSURTECH RODA Hardware Check

    "/insurtech/hardware_check"(platform: "/", isAbstract: true) {}

    "/insurtech/hardware_check/onboarding"(platform:"/mobile", type: TrackType.View) {
        session_id(required: false, type: PropertyType.String, description: "Session id of the user")
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
    }

    "/insurtech/hardware_check/onboarding/exit"(platform:"/mobile", type: TrackType.Event) {
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/onboarding/back"(platform:"/mobile", type: TrackType.Event) {
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/onboarding/start_tests"(platform:"/mobile", type: TrackType.Event) {
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/onboarding/device_info_error"(platform:"/mobile", type: TrackType.Event) {
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
        error_description(required: true, type: PropertyType.String, description: "Error detail on getDeviceInfo() internal method.")
    }

    "/insurtech/hardware_check/onboarding/permission_allow"(platform:"/mobile", type: TrackType.Event) {
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/onboarding/permission_deny"(platform:"/mobile", type: TrackType.Event) {
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/onboarding/permission_dont_ask_again"(platform:"/mobile", type: TrackType.Event) {
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/onboarding/permission_application_information"(platform:"/mobile", type: TrackType.Event) {
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/permission_denied"(platform:"/mobile", type: TrackType.View) {
        session_id(required: false, type: PropertyType.String, description: "Session id of the user")
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
    }

    "/insurtech/hardware_check/permission_denied/exit"(platform:"/mobile", type: TrackType.Event) {
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/permission_denied/back"(platform:"/mobile", type: TrackType.Event) {
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/permission_denied/accept"(platform:"/mobile", type: TrackType.Event) {
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/checkups"(platform:"/mobile", type: TrackType.View) {
        session_id(required: false, type: PropertyType.String, description: "Session id of the user")
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
    }

    "/insurtech/hardware_check/checkups/exit"(platform:"/mobile", type: TrackType.Event) {
        check_id(required: true, type: PropertyType.String, description: "check ID.")
        cycle(required: true, type: PropertyType.Numeric, description: "Cycle within the check to which the event corresponds.")
        time_assigned(required: true, type: PropertyType.Numeric, description: "Allotted time for checking.")
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/checkups/exit_cancel"(platform:"/mobile", type: TrackType.Event) {
        check_id(required: true, type: PropertyType.String, description: "check ID.")
        cycle(required: true, type: PropertyType.Numeric, description: "Cycle within the check to which the event corresponds.")
        time_assigned(required: true, type: PropertyType.Numeric, description: "Allotted time for checking.")
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/checkups/time_ended"(platform:"/mobile", type: TrackType.Event) {
        check_id(required: true, type: PropertyType.String, description: "check ID.")
        cycle(required: true, type: PropertyType.Numeric, description: "Cycle within the check to which the event corresponds.")
        time_assigned(required: true, type: PropertyType.Numeric, description: "Allotted time for checking.")
        session_id(required: false, type: PropertyType.String, description: "Session id of the user")
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/checkups/try_again"(platform:"/mobile", type: TrackType.Event) {
        check_id(required: true, type: PropertyType.String, description: "check ID.")
        cycle(required: true, type: PropertyType.Numeric, description: "Cycle within the check to which the event corresponds.")
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/checkups/skip_check"(platform:"/mobile", type: TrackType.Event) {
        check_id(required: true, type: PropertyType.String, description: "check ID.")
        session_id(required: false, type: PropertyType.String, description: "Session id of the user")
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/checkups/ready"(platform:"/mobile", type: TrackType.Event) {
        check_id(required: true, type: PropertyType.String, description: "check ID.")
        cycle(required: true, type: PropertyType.Numeric, description: "Cycle within the check to which the event corresponds.")
        time_success(required: true, type: PropertyType.Numeric, description: "Time it took to perform the checkup.")
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/checkups/failed"(platform:"/mobile", type: TrackType.Event) {
        check_id(required: true, type: PropertyType.String, description: "check ID.")
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/checkups/first_touch"(platform:"/mobile", type: TrackType.Event) {
        time_elapsed(required: true, type: PropertyType.Numeric, description: "Time before first user touch")
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/checkups/redirect"(platform:"/mobile", type: TrackType.Event) {
        deep_link(required: true, type: PropertyType.String, description: "Redirect flow to the next step")
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/congrats_success"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
        session_id(required: false, type: PropertyType.String, description: "Session id of the user")
    }

    "/insurtech/hardware_check/congrats_success/exit"(platform:"/mobile", type: TrackType.Event) {
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/congrats_success/main_action"(platform:"/mobile", type: TrackType.Event) {
        action_description(required: true, type: PropertyType.String, description: "Description of the main action shown in the congrats.")
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/congrats_success/secondary_action"(platform:"/mobile", type: TrackType.Event) {
        action_description(required: true, type: PropertyType.String, description: "Description of the main action shown in the congrats.")
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/congrats_failed"(platform:"/mobile", type: TrackType.View) {
        session_id(required: false, type: PropertyType.String, description: "Session id of the user")
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
    }

    "/insurtech/hardware_check/congrats_failed/exit"(platform:"/mobile", type: TrackType.Event) {
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/congrats_failed/main_action"(platform:"/mobile", type: TrackType.Event) {
        action_description(required: true, type: PropertyType.String, description: "Description of the main action shown in the congrats.")
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/congrats_failed/secondary_action"(platform:"/mobile", type: TrackType.Event) {
        action_description(required: true, type: PropertyType.String, description: "Description of the main action shown in the congrats.")
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/generic_error"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
        step(required: true, type: PropertyType.String, description: "Indicates which step of the flow occurred.", values: ["ONBOARDING", "CONGRATS"])
        context(required: true, type: PropertyType.String, description: "Information on what was the problem causing the error.")
        session_id(required: false, type: PropertyType.String, description: "Session id of the user")
    }

    "/insurtech/hardware_check/generic_error/back"(platform:"/mobile", type: TrackType.Event) {
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    "/insurtech/hardware_check/generic_error/try_again"(platform:"/mobile", type: TrackType.Event) {
        view_time(required: false, type: PropertyType.Numeric, description: "Time since entering view.")
    }

    // INSURTECH Webview
    "/insurtech/webview"(platform: "/", isAbstract: true) {}
    "/insurtech/webview/generic-error"(platform:"/mobile", type: TrackType.Event) {
        deeplink(required: true, type: PropertyType.String, description: "Deeplink that enter on webview.")
        device(required: true, type: PropertyType.Map(roda_device), description: "Device data of user")
    }

    // INSURTECH RODA Payments

    "/insurtech/payments"(platform: "/", isAbstract: true) {}

    "/insurtech/payments/loading"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
        flow(required: true, type: PropertyType.String, description: "Indicate which initiative you belong to.")
    }

    "/insurtech/payments/generic_error"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
        flow(required: true, type: PropertyType.String, description: "Indicate which initiative you belong to.")
    }

    "/insurtech/payments/px_checkout"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
        flow(required: true, type: PropertyType.String, description: "Indicate which initiative you belong to.")
        preference_id(required: true, type: PropertyType.String, description: "Payment preference.")
        purchase_id(required: true, type: PropertyType.String, description: "Payment entity id")
    }

    "/insurtech/payments/px_checkout/back"(platform:"/mobile", type: TrackType.Event) {}

    "/insurtech/payments/px_checkout/pay"(platform:"/mobile", type: TrackType.Event) {}

    "/insurtech/payments/px_checkout/congrats_in_process"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
        flow(required: true, type: PropertyType.String, description: "Indicate which initiative you belong to.")
        preference_id(required: true, type: PropertyType.String, description: "Payment preference.")
        purchase_id(required: true, type: PropertyType.String, description: "Payment entity id")
    }

    "/insurtech/payments/px_checkout/congrats_approved"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
        flow(required: true, type: PropertyType.String, description: "Indicate which initiative you belong to.")
        preference_id(required: true, type: PropertyType.String, description: "Payment preference.")
        purchase_id(required: true, type: PropertyType.String, description: "Payment entity id")
    }

    "/insurtech/payments/px_checkout/congrats_approved/go_to_insurance"(platform:"/mobile", type: TrackType.Event) {
        action_description(required: true, type: PropertyType.String, description: "Description of the main action shown in the fragment.")
    }

    "/insurtech/payments/px_checkout/congrats_approved/go_to_home"(platform:"/mobile", type: TrackType.Event) {
        action_description(required: true, type: PropertyType.String, description: "Description of the button that appears at the end of the congrats.")
    }

    "/insurtech/payments/px_checkout/congrats_rejected"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
        flow(required: true, type: PropertyType.String, description: "Indicate which initiative you belong to.")
        preference_id(required: true, type: PropertyType.String, description: "Payment preference.")
        purchase_id(required: true, type: PropertyType.String, description: "Payment entity id")
    }

    "/insurtech/payments/px_checkout/congrats_rejected/go_to_home"(platform:"/mobile", type: TrackType.Event) {
        action_description(required: true, type: PropertyType.String, description: "Description of the button that appears at the end of the congrats.")
    }

    "/insurtech/payments/px_checkout/congrats_pending"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
        flow(required: true, type: PropertyType.String, description: "Indicate which initiative you belong to.")
        preference_id(required: true, type: PropertyType.String, description: "Payment preference.")
        purchase_id(required: true, type: PropertyType.String, description: "Payment entity id")
    }

    "/insurtech/payments/px_checkout/congrats_pending/go_to_home"(platform:"/mobile", type: TrackType.Event) {
        action_description(required: true, type: PropertyType.String, description: "Description of the button that appears at the end of the congrats.")
    }

    // INSURTECH MyFe
    "/insurtech/protections"(platform: "/", isAbstract: true) {}

    "/insurtech/protections"(platform:"/", type: TrackType.View) {}

    "/insurtech/protections/quote-me"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        client_device(required: true, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page.")
        protections(required: false, type: PropertyType.ArrayList(PropertyType.Map(protection_short)), description: "List of current user Protections")
    }

    "/insurtech/protections/doubts"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page. This will be non empty when accessing from mobile")
        protections(required: false, type: PropertyType.ArrayList(PropertyType.Map(protection_short)), description: "List of current user Protections")
        selected_faq(required: true, type: PropertyType.String, description: "Selected FAQ option by the user")
    }

    "/insurtech/protections/tabs"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page.")
        protections(required: false, type: PropertyType.ArrayList(PropertyType.Map(protection_short)), description: "List of current user Protections")
        claims(required: false, type: PropertyType.ArrayList(PropertyType.Map(claim_short)), description: "List of current user Claims")
        tab_name(required: true, type: PropertyType.String, values: ['protections', 'claims'], description: "Product id of the protection.");
    }

    "/insurtech/protections/data_loaded"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page.")
        protections(required: false, type: PropertyType.ArrayList(PropertyType.Map(protection_short)), description: "List of current user Protections")
        claims(required: false, type: PropertyType.ArrayList(PropertyType.Map(claim_short)), description: "List of current user Claims")
        roda(required: true, type: PropertyType.Map(my_protections_roda), description: "RODA product data recovered in protections list")
        garex(required: true, type: PropertyType.Map(my_protections_garex), description: "GAREX product data recovered in protections list")
        cards(required: true, type: PropertyType.Map(my_protections_cards), description: "CARDS product data recovered in protections list")
    }

    "/insurtech/protections/finished"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page. This will be non empty when accessing from mobile")
        protections(required: false, type: PropertyType.ArrayList(PropertyType.Map(protection_short)), description: "List of current user Protections")
    }

    "/insurtech/protections/finished_claims"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page. This will be non empty when accessing from mobile")
        claims(required: false, type: PropertyType.ArrayList(PropertyType.Map(claim_short)), description: "List of current user claims")
    }

    "/insurtech/protections/error"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page. This will be non empty when accessing from mobile")
    }

    "/insurtech/protections/fallback"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page. This will be non empty when accessing from mobile")
    }

    // INSURTECH MyDetailFe
    // RODA
    "/insurtech/protections/detail"(platform: "/", isAbstract: true, parentPropertiesInherited:false) {}

    "/insurtech/protections/detail/roda"(platform: "/", isAbstract: true, parentPropertiesInherited:false) {}

    "/insurtech/protections/detail/roda"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page. This will be non empty when accessing from mobile")
        protection(required: true, type: PropertyType.Map(protection_base), description: "RODA Protection data")
        product(required: false, type: PropertyType.Map(protection_particular_roda), description: "Particular information for Roda.")
    }

    "/insurtech/protections/detail/roda/begin_claim"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "RODA Protection data")
        product(required: false, type: PropertyType.Map(protection_particular_roda), description: "Particular information for Roda.")
    }

    "/insurtech/protections/detail/roda/download_policy"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "RODA Protection data")
        product(required: false, type: PropertyType.Map(protection_particular_roda), description: "Particular information for Roda.")
    }

    "/insurtech/protections/detail/roda/pay"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "RODA Protection data")
        product(required: false, type: PropertyType.Map(protection_particular_roda), description: "Particular information for Roda.")
        type(required: true, type: PropertyType.String, values: ['pending_payment', 'pending_payment_ticket', 'pending_franchise_payment', 'pending_recurring_payment'], description: "Type of payment or payment method change to be executed on protection.")
    }

    "/insurtech/protections/detail/roda/recommendations"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "RODA Protection data")
        product(required: false, type: PropertyType.Map(protection_particular_roda), description: "Particular information for Roda.")
    }

    "/insurtech/protections/detail/roda/cancel"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "RODA Protection data")
        product(required: false, type: PropertyType.Map(protection_particular_roda), description: "Particular information for Roda.")
    }

    "/insurtech/protections/detail/roda/cancel_claim"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "RODA Protection data")
        claim(required: true, type: PropertyType.Map(claim_roda), description: "RODA Protection claim data")
        product(required: false, type: PropertyType.Map(protection_particular_roda), description: "Particular information for Roda.")
    }

    "/insurtech/protections/detail/roda/help"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "RODA Protection data")
        product(required: false, type: PropertyType.Map(protection_particular_roda), description: "Particular information for Roda.")
    }

    "/insurtech/protections/detail/roda/imei_help"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "RODA Protection data")
        product(required: false, type: PropertyType.Map(protection_particular_roda), description: "Particular information for Roda.")
    }

    "/insurtech/protections/detail/roda/imei_activation"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "RODA Protection data")
        product(required: false, type: PropertyType.Map(protection_particular_roda), description: "Particular information for Roda.")
        is_imei_valid(required: true, type: PropertyType.Boolean, description: "Imei valid or invalid ")
        protection_status(required: true, type: PropertyType.String, values: ['pending_shipping_imei', 'pending_activation_imei'], description: "Status of protection when is going to be activated")
        days_taken_for_imei_activation(required: true, type: PropertyType.Numeric, description: "Days passed after protection was in pending_activation status")
        retries_number(required: true, type: PropertyType.Numeric, description: "Number of attempts before to activate with success")
        modal_imei_retries(required: true, type: PropertyType.Numeric, description: "Number of times that modal showed up")
   }
   
   "/insurtech/protections/detail/roda/change_protection"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "RODA Protection data")
        product(required: false, type: PropertyType.Map(protection_particular_roda), description: "Particular information for Roda.")
    }

   "/insurtech/protections/detail/roda/feedback"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "RODA Protection data")
        product(required: false, type: PropertyType.Map(protection_particular_roda), description: "Particular information for Roda.")
        claim(required: false, type: PropertyType.Map(claim_roda), description: "RODA Protection claim data")
    }

    "/insurtech/protections/detail/roda/insurer_response"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "RODA Protection data")
        product(required: false, type: PropertyType.Map(protection_particular_roda), description: "Particular information for Roda.")
    }

    "/insurtech/protections/detail/roda/payment_ticket_instructions"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "RODA Protection data")
        product(required: false, type: PropertyType.Map(protection_particular_roda), description: "Particular information for Roda.")
        type(required: true, type: PropertyType.String, values: ['deductible', 'protection'], description: "This is deductible if the payment ticket instructions are for the franchise. Protection other way.")
    }

    "/insurtech/protections/detail/roda/claim_detail"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        insurance_purchase_key(required: true, type: PropertyType.String, description: "Insurance purchase key associated to the RODA protection.")
        claim(required: true, type: PropertyType.Map(claim_roda), description: "RODA Protection claim data")
    }

    "/insurtech/protections/detail/roda/claim_detail/insurer_response"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "RODA Protection data")
        product(required: false, type: PropertyType.Map(protection_particular_roda), description: "Particular information for Roda.")
        claim(required: true, type: PropertyType.Map(claim_roda), description: "RODA Protection claim data")
    }

    "/insurtech/protections/detail/roda/claim_detail/cancel_claim"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        claim(required: true, type: PropertyType.Map(claim_roda), description: "RODA Protection claim data")
    }

    "/insurtech/protections/detail/roda/phone_activation"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {}

    "/insurtech/protections/detail/roda/shipping_instructions"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) { }

    "/insurtech/protections/detail/roda/error"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page. This will be non empty when accessing from mobile")
    }

    "/insurtech/protections/detail/roda/continue_kyc"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "RODA Protection data")
        product(required: false, type: PropertyType.Map(protection_particular_roda), description: "Particular information for Roda.")
    }

    "/insurtech/protections/detail/onboarding_kyc/roda"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        insurance_purchase_key(required: true, type: PropertyType.String, description: 'Insurance purchase key associated to the protection.')
        protection_status(required: true, type: PropertyType.String, values: ['pending_shipping_customer_data', 'pending_activation_customer_data', 'confirmed', 'executing'], description: 'Protection status to see onboardingKYC page correctly.' )
    }

    "/insurtech/protections/detail/onboarding_kyc/roda/go_to_kyc"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
    }

    // GAREX
    "/insurtech/protections/detail/garex"(platform: "/", isAbstract: true, parentPropertiesInherited:false) {}

    "/insurtech/protections/detail/garex"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "Product data")
        product(required: false, type: PropertyType.Map(protection_particular_garex), description: "Particular information for Garex.")
    }
    "/insurtech/protections/detail/garex/use_service"(platform:"/", type: TrackType.Event) {
    }
    "/insurtech/protections/detail/garex/use_service_certificate"(platform:"/", type: TrackType.Event) {
    }
    "/insurtech/protections/detail/garex/cancel_protection"(platform:"/", type: TrackType.Event) {
    }
    "/insurtech/protections/detail/garex/help"(platform:"/", type: TrackType.Event) {
    }
    "/insurtech/protections/detail/garex/activities"(platform:"/", type: TrackType.Event) {
    }
    "/insurtech/protections/detail/garex/detail_payment"(platform:"/", type: TrackType.Event) {
    }
    "/insurtech/protections/detail/garex/packaging_instructions"(platform:"/", type: TrackType.Event) {
    }
    "/insurtech/protections/detail/garex/feedback"(platform:"/", type: TrackType.Event) {
    }

    // CARDS
    "/insurtech/protections/detail/cards"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_base), description: "Cards Product data")
    }

    "/insurtech/protections/detail/cards/begin_claim"(platform:"/", type: TrackType.Event) {}

    "/insurtech/protections/detail/cards/download_policy"(platform:"/", type: TrackType.Event) {}

    "/insurtech/protections/detail/cards/pay"(platform:"/", type: TrackType.Event) {
        type(required: false, type: PropertyType.String, values: ['pending_recurring_payment'], description: "Type of payment to be executed on protection.")
    }

    "/insurtech/protections/detail/cards/cancel"(platform:"/", type: TrackType.Event) {}

    "/insurtech/protections/detail/cards/help"(platform:"/", type: TrackType.Event) {}

    "/insurtech/protections/detail/cards/full_coverage"(platform:"/", type: TrackType.Event) {}

    "/insurtech/protections/detail/begin_claim"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page. This will be non empty when accessing from mobile")
    }

    "/insurtech/protections/detail/begin_claim/go_to_call_action"(platform:"/", type: TrackType.Event) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page. This will be non empty when accessing from mobile")
        call_from(required: true, type: PropertyType.String, values: ['fromCapital', 'notFromCapital'], description: "Which of both phones was clicked.");
    }

    // Landing-fe
    "/insurtech/protections/landings_fe"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        type(required: true, type:PropertyType.String,values: ['mobile', 'desktop', 'tablet'], description: "Device type")
        os_name(required: true, type:PropertyType.String, description: "Operating system")
        os_version(required: true, type:PropertyType.String, description: "Operating system version")
        discount_type(required: true, type:PropertyType.String,values: ['percent', 'fixed', 'NA'], description: "Reseller discount type")
        is_generic(required: true, type:PropertyType.Boolean, description: "Landing from a campaign or not")
        site(required: true, type:PropertyType.String, description: "Operating system version")
    }
    "/insurtech/protections/landings_fe/go_to_store"(platform:"/", type: TrackType.Event) {
    }
    "/insurtech/protections/landings_fe/go_to_qpage"(platform:"/", type: TrackType.Event) {
    }

    // Insurtech CARDS
    "/insurtech/cards"(platform:"/", type: TrackType.View, parentPropertiesInherited:false){
        options(required: true, type: PropertyType.ArrayList(PropertyType.Map(card_protection_option)), description: "Options objects")
        flow_id(required: true, type: PropertyType.String, description: "Product id of insurtech")
    }
    "/insurtech/cards/help"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false){
        option_selected(required: true, type: PropertyType.Map(card_protection_option), description: "Option selected")
        flow_id(required: true, type: PropertyType.String, description: "Product id of insurtech")
    }
    "/insurtech/cards/select"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false){
        option_selected(required: true, type: PropertyType.Map(card_protection_option), description: "Option selected")
        flow_id(required: true, type: PropertyType.String, description: "Product id of insurtech")
    }
    "/insurtech/cards/skip"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false){
        flow_id(required: true, type: PropertyType.String, description: "Product id of insurtech")
    }
    "/insurtech/cards/add"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false){
        option_selected(required: true, type: PropertyType.Map(card_protection_option), description: "Option selected")
        flow_id(required: true, type: PropertyType.String, description: "Product id of insurtech")
    }
    "/insurtech/cards/quote_fail"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false){
        option_selected(required: true, type: PropertyType.Map(card_protection_option), description: "Option selected")
        flow_id(required: true, type: PropertyType.String, description: "Product id of insurtech")
    }
    "/insurtech/cards/quote_success"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false){
        option_selected(required: true, type: PropertyType.Map(card_protection_option), description: "Option selected")
        flow_id(required: true, type: PropertyType.String, description: "Product id of insurtech")
    }
    "/insurtech/cards/back"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false){
        flow_id(required: true, type: PropertyType.String, description: "Product id of insurtech")
    }
    "/insurtech/cards/retry"(platform:"/", type: TrackType.Event, parentPropertiesInherited: false){
        option_selected(required: true, type: PropertyType.Map(card_protection_option), description: "Option selected")
        flow_id(required: true, type: PropertyType.String, description: "Product id of insurtech")
    }
    
    // Congrats - Success View
    "/insurtech/cards/congrats_success"(platform:"/", type: TrackType.View, parentPropertiesInherited: false){
        purchase_key(required: true, type: PropertyType.String, description: "the id of the purchase generated")
    }
    "/insurtech/cards/congrats_success/go_cards"(platform: "/", type: TrackType.Event, parentPropertiesInherited: true){
    }
    "/insurtech/cards/congrats_success/go_protections"(platform: "/", type: TrackType.Event, parentPropertiesInherited: true){
    }
    "/insurtech/cards/congrats_success/close"(platform: "/", type: TrackType.Event, parentPropertiesInherited: true){
    }
}
