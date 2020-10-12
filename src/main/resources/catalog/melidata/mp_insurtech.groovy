package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1212"

    // INSURTECH RODA Structures
    def roda_device = objectSchemaDefinitions {
        brand(required: true, type: PropertyType.String, description: "Brand of device. For ex: Samsung.")
        model(required: false, type: PropertyType.String, description: "Model of the device. For ex: J7.")
        model_code(required: true, type: PropertyType.String, description: "Model code of the device. For ex: SM-J700M.")
        size(required: true, type: PropertyType.String, description: "Size of the device. For ex: 64GB.")
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
    }

    def roda_option_short = objectSchemaDefinitions {
        coverage(required: true, type: PropertyType.String, description: "Coverage of the option. For ex: theft_break, theft, break, accident.")
        price(required: true, type: PropertyType.Numeric, description: "Price of the option.")
        deductible_amount(required: true, type: PropertyType.Numeric, description: "Deductible amount of the option.")
    }

    def protection_short = objectSchemaDefinitions {
        product_id(required: true, type: PropertyType.String, values: ['garex', 'roda'], description: "Product id of the protection.")
        insurance_purchase_key(required: true, type: PropertyType.String, description: "Insurance purchase key associated to the protection.")
    }

    def my_protections_roda = objectSchemaDefinitions {
        has_protections(required: true, type: PropertyType.Boolean, description: "This is true if the user has RODA protections")
        is_current_device_protected(required: true, type: PropertyType.Boolean, description: "This is true if the current device of the track is already protected for RODA")
        is_current_device_quotable(required: true, type: PropertyType.Boolean, description: "This is true if the current device is quotable for RODA")
        offered(required: true, type: PropertyType.Boolean, description: "This is true if the RODA protection has been offered to the user")
    }

    def my_protections_garex = objectSchemaDefinitions {
        has_protections(required: true, type: PropertyType.Boolean, description: "This is true if the user has GAREX protections")
        offered(required: true, type: PropertyType.Boolean, description: "This is true if the GAREX protection has been offered to the user")
    }

    def protection_roda = objectSchemaDefinitions {
        insurance_purchase_key(required: true, type: PropertyType.String, description: "Insurance purchase key associated to the RODA protection.")
        amount_total(required: true, type: PropertyType.Numeric, description: "Total Price of the purchased option plan.")
        amount_fee(required: true, type: PropertyType.Numeric, description: "Fee amount obtained by meli for the purchased option plan.")
        option_check(required: true, type: PropertyType.String, values: ['total', 'screen'], description: "Level of the hardware check. For ex: total, screen.")
        option_coverage(required: true, type: PropertyType.String, values: ['theft_break', 'theft', 'break', 'screen'], description: "Coverage of the acquired protection. For ex: theft, break, screen, theft_break.")
        deductible_amount(required: true, type: PropertyType.Numeric, description: "Deductible amount of the option.")
        has_open_claim(required: true, type: PropertyType.Boolean, description: "This is true if the protection has an open claim.")
        is_current_device_protection(required: true, type: PropertyType.Boolean, description: "This is true if the current device of the track is the one related to this protection.")
    }

    def claim_roda = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "ID of claim associated to the RODA protection.")
        franchise_payment_id(required: false, type: PropertyType.Numeric, description: "ID of payment associated to the franchise.")
        franchise_payment_amount(required: false, type: PropertyType.Numeric, description: "Amount associated to the franchise payment.")
    }

    // INSURTECH RODA QPage Abstract
    "/insurtech"(platform: "/", isAbstract: true) {}

    "/insurtech/roda"(platform: "/", isAbstract: true) {}
    "/insurtech/roda/qpage"(platform: "/", isAbstract: true) {}

    "/insurtech/roda/qpage"(platform:"/", type: TrackType.View) {
        client_device(required: true, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        options(required: false, type: PropertyType.ArrayList(PropertyType.Map(roda_option_short)), description: "Options presented in the qpage for quotation")
        financing_type(required: false, type: PropertyType.Map(financing_type_track_structure), description: "Financing data of item if it has")
    }

    "/insurtech/roda/qpage/error"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
    }

    "/insurtech/roda/qpage/fallback"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
    }

    "/insurtech/roda/qpage/deductible"(platform:"/", type: TrackType.Event) {
        client_device(required: true, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
    }

    "/insurtech/roda/qpage/faq"(platform:"/", type: TrackType.Event) {
        client_device(required: true, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        faq(required: true, type: PropertyType.String, description: "Name of the FAQ viewed. For ex: protection-cancel, deductible-fee")
    }

    "/insurtech/roda/qpage/buy"(platform:"/", type: TrackType.Event) {
        client_device(required: true, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        option(required: true, type: PropertyType.Map(roda_option), description: "Option plan selected on purchase.")
        financing_type(required: false, type: PropertyType.Map(financing_type_track_structure), description: "Financing data of item if it has")
    }

    "/insurtech/roda/qpage/option_selected"(platform:"/", type: TrackType.Event) {
        client_device(required: true, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        option(required: true, type: PropertyType.Map(roda_option), description: "Option plan selected.")
    }

    // INSURTECH RODA Hardware Check

    "/insurtech/hardware_check"(platform: "/", isAbstract: true) {}

    "/insurtech/hardware_check/onboarding"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
    }

    "/insurtech/hardware_check/onboarding/exit"(platform:"/mobile", type: TrackType.Event) {}

    "/insurtech/hardware_check/onboarding/start_tests"(platform:"/mobile", type: TrackType.Event) {}

    "/insurtech/hardware_check/onboarding/permission_allow"(platform:"/mobile", type: TrackType.Event) {}

    "/insurtech/hardware_check/onboarding/permission_deny"(platform:"/mobile", type: TrackType.Event) {}

    "/insurtech/hardware_check/onboarding/permission_dont_ask_again"(platform:"/mobile", type: TrackType.Event) {}

    "/insurtech/hardware_check/onboarding/permission_application_information"(platform:"/mobile", type: TrackType.Event) {}

    "/insurtech/hardware_check/permission_denied"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
    }

    "/insurtech/hardware_check/permission_denied/exit"(platform:"/mobile", type: TrackType.Event) {}

    "/insurtech/hardware_check/permission_denied/accept"(platform:"/mobile", type: TrackType.Event) {}

    "/insurtech/hardware_check/checkups"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
    }

    "/insurtech/hardware_check/checkups/exit"(platform:"/mobile", type: TrackType.Event) {
        check_id(required: true, type: PropertyType.String, description: "check ID.")
        cycle(required: true, type: PropertyType.Numeric, description: "Cycle within the check to which the event corresponds.")
        time_assigned(required: true, type: PropertyType.Numeric, description: "Allotted time for checking.")
    }

    "/insurtech/hardware_check/checkups/exit_cancel"(platform:"/mobile", type: TrackType.Event) {
        check_id(required: true, type: PropertyType.String, description: "check ID.")
        cycle(required: true, type: PropertyType.Numeric, description: "Cycle within the check to which the event corresponds.")
        time_assigned(required: true, type: PropertyType.Numeric, description: "Allotted time for checking.")
    }

    "/insurtech/hardware_check/checkups/time_ended"(platform:"/mobile", type: TrackType.Event) {
        check_id(required: true, type: PropertyType.String, description: "check ID.")
        cycle(required: true, type: PropertyType.Numeric, description: "Cycle within the check to which the event corresponds.")
        time_assigned(required: true, type: PropertyType.Numeric, description: "Allotted time for checking.")
    }

    "/insurtech/hardware_check/checkups/try_again"(platform:"/mobile", type: TrackType.Event) {
        check_id(required: true, type: PropertyType.String, description: "check ID.")
        cycle(required: true, type: PropertyType.Numeric, description: "Cycle within the check to which the event corresponds.")
    }

    "/insurtech/hardware_check/checkups/skip_check"(platform:"/mobile", type: TrackType.Event) {
        check_id(required: true, type: PropertyType.String, description: "check ID.")
    }

    "/insurtech/hardware_check/checkups/ready"(platform:"/mobile", type: TrackType.Event) {
        check_id(required: true, type: PropertyType.String, description: "check ID.")
        cycle(required: true, type: PropertyType.Numeric, description: "Cycle within the check to which the event corresponds.")
        time_success(required: true, type: PropertyType.Numeric, description: "Time it took to perform the checkup.")
    }

    "/insurtech/hardware_check/checkups/failed"(platform:"/mobile", type: TrackType.Event) {
        check_id(required: true, type: PropertyType.String, description: "check ID.")
    }

    "/insurtech/hardware_check/congrats_success"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
    }

    "/insurtech/hardware_check/congrats_success/exit"(platform:"/mobile", type: TrackType.Event) {}

    "/insurtech/hardware_check/congrats_success/main_action"(platform:"/mobile", type: TrackType.Event) {
        action_description(required: true, type: PropertyType.String, description: "Description of the main action shown in the congrats.")
    }

    "/insurtech/hardware_check/congrats_success/secondary_action"(platform:"/mobile", type: TrackType.Event) {
        action_description(required: true, type: PropertyType.String, description: "Description of the main action shown in the congrats.")
    }

    "/insurtech/hardware_check/congrats_failed"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
    }

    "/insurtech/hardware_check/congrats_failed/exit"(platform:"/mobile", type: TrackType.Event) {}

    "/insurtech/hardware_check/congrats_failed/main_action"(platform:"/mobile", type: TrackType.Event) {
        action_description(required: true, type: PropertyType.String, description: "Description of the main action shown in the congrats.")
    }

    "/insurtech/hardware_check/congrats_failed/secondary_action"(platform:"/mobile", type: TrackType.Event) {
        action_description(required: true, type: PropertyType.String, description: "Description of the main action shown in the congrats.")
    }

    "/insurtech/hardware_check/generic_error"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
        step(required: true, type: PropertyType.String, description: "Indicates which step of the flow occurred.", values: ["ONBOARDING", "CONGRATS"])
        context(required: true, type: PropertyType.String, description: "Information on what was the problem causing the error.")
    }

    "/insurtech/hardware_check/generic_error/back"(platform:"/mobile", type: TrackType.Event) {}

    "/insurtech/hardware_check/generic_error/try_again"(platform:"/mobile", type: TrackType.Event) {}

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

    "/insurtech/payments/congrats_approved"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
        flow(required: true, type: PropertyType.String, description: "Indicate which initiative you belong to.")
        preference_id(required: true, type: PropertyType.String, description: "Payment preference.")
        purchase_id(required: true, type: PropertyType.String, description: "Payment entity id")
    }

    "/insurtech/payments/congrats_approved/go_to_insurance"(platform:"/mobile", type: TrackType.Event) {
        action_description(required: true, type: PropertyType.String, description: "Description of the main action shown in the fragment.")
    }

    "/insurtech/payments/congrats_approved/go_to_home"(platform:"/mobile", type: TrackType.Event) {
        action_description(required: true, type: PropertyType.String, description: "Description of the button that appears at the end of the congrats.")
    }

    "/insurtech/payments/congrats_rejected"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
        flow(required: true, type: PropertyType.String, description: "Indicate which initiative you belong to.")
        preference_id(required: true, type: PropertyType.String, description: "Payment preference.")
        purchase_id(required: true, type: PropertyType.String, description: "Payment entity id")
    }

    "/insurtech/payments/congrats_rejected/go_to_home"(platform:"/mobile", type: TrackType.Event) {
        action_description(required: true, type: PropertyType.String, description: "Description of the button that appears at the end of the congrats.")
    }

    "/insurtech/payments/congrats_pending"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
        flow(required: true, type: PropertyType.String, description: "Indicate which initiative you belong to.")
        preference_id(required: true, type: PropertyType.String, description: "Payment preference.")
        purchase_id(required: true, type: PropertyType.String, description: "Payment entity id")
    }

    "/insurtech/payments/congrats_pending/go_to_home"(platform:"/mobile", type: TrackType.Event) {
        action_description(required: true, type: PropertyType.String, description: "Description of the button that appears at the end of the congrats.")
    }

    // INSURTECH MyFe
    "/insurtech/protections"(platform: "/", isAbstract: true) {}

    "/insurtech/protections"(platform:"/", type: TrackType.View) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page. This will be non empty when accessing from mobile")
        protections(required: false, type: PropertyType.ArrayList(PropertyType.Map(protection_short)), description: "List of current user Protections")
        roda(required: true, type: PropertyType.Map(my_protections_roda), description: "RODA product data recovered in protections list")
        garex(required: true, type: PropertyType.Map(my_protections_garex), description: "GAREX product data recovered in protections list")
    }

    "/insurtech/protections/quote-me"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        client_device(required: true, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page.")
        protections(required: false, type: PropertyType.ArrayList(PropertyType.Map(protection_short)), description: "List of current user Protections")
    }

    "/insurtech/protections/doubts"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page. This will be non empty when accessing from mobile")
        protections(required: false, type: PropertyType.ArrayList(PropertyType.Map(protection_short)), description: "List of current user Protections")
    }

    "/insurtech/protections/finished"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page. This will be non empty when accessing from mobile")
        protections(required: false, type: PropertyType.ArrayList(PropertyType.Map(protection_short)), description: "List of current user Protections")
    }

    "/insurtech/protections/error"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page. This will be non empty when accessing from mobile")
    }

    "/insurtech/protections/fallback"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page. This will be non empty when accessing from mobile")
    }

    // INSURTECH MyDetailFe
    "/insurtech/protections/detail"(platform: "/", isAbstract: true, parentPropertiesInherited:false) {}

    "/insurtech/protections/detail/roda"(platform: "/", isAbstract: true, parentPropertiesInherited:false) {}

    "/insurtech/protections/detail/roda"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page. This will be non empty when accessing from mobile")
        protection(required: true, type: PropertyType.Map(protection_roda), description: "RODA Protection data")
    }

    "/insurtech/protections/detail/roda/begin_claim"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_roda), description: "RODA Protection data")
    }

    "/insurtech/protections/detail/roda/download_policy"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_roda), description: "RODA Protection data")
    }

    "/insurtech/protections/detail/roda/pay"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_roda), description: "RODA Protection data")
        type(required: true, type: PropertyType.String, values: ['pending_payment', 'pending_payment_ticket', 'pending_franchise_payment'], description: "Type of payment or payment method change to be executed on protection.")
    }

    "/insurtech/protections/detail/roda/recommendations"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_roda), description: "RODA Protection data")
    }

    "/insurtech/protections/detail/roda/cancel"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_roda), description: "RODA Protection data")
    }

    "/insurtech/protections/detail/roda/help"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_roda), description: "RODA Protection data")
    }

    "/insurtech/protections/detail/roda/payment_ticket_instructions"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_roda), description: "RODA Protection data")
        type(required: true, type: PropertyType.String, values: ['deductible', 'protection'], description: "This is deductible if the payment ticket instructions are for the franchise. Protection other way.")
    }

    "/insurtech/protections/detail/roda/claim_detail"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        protection(required: true, type: PropertyType.Map(protection_roda), description: "RODA Protection data")
        claim(required: true, type: PropertyType.Map(claim_roda), description: "RODA Protection claim data")
    }

    "/insurtech/protections/detail/roda/phone_activation"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {}

    "/insurtech/protections/detail/roda/shipping_instructions"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) { }

    "/insurtech/protections/detail/roda/error"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        client_device(required: false, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the my-fe page. This will be non empty when accessing from mobile")
    }
}
