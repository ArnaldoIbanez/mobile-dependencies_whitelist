package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1212"

    // INSURTECH RODA QPage Abstract
    "/insurtech"(platform: "/", isAbstract: true) {}
    "/insurtech/roda"(platform: "/", isAbstract: true) {}
    "/insurtech/roda/qpage"(platform: "/", isAbstract: true) {}

    // INSURTECH RODA QPage Structures
    def roda_device = objectSchemaDefinitions {
        brand(required: true, type: PropertyType.String, description: "Brand of device. For ex: Samsung.")
        model(required: false, type: PropertyType.String, description: "Model of the device. For ex: J7.")
        model_code(required: true, type: PropertyType.String, description: "Model code of the device. For ex: SM-J700M.")
        size(required: true, type: PropertyType.String, description: "Size of the device. For ex: 64GB.")
    }

    def roda_option = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "ID of RODA option plan to purchase.")
        category(required: true, type: PropertyType.String, description: "Category of the option. For ex: total, screen, accident.")
        price(required: true, type: PropertyType.Numeric, description: "Price of the option.")
        monthly_price(required: true, type: PropertyType.Numeric, description: "Monthly price of the option.")
        fee_price(required: true, type: PropertyType.Numeric, description: "Fee price for meli of the option.")
        currency_id(required: true, type: PropertyType.String, description: "Currency id of the option. For ex: BRL.")
        deductible(required: true, type: PropertyType.Numeric, description: "Deductible percentage of the option.")
        deductible_amount(required: true, type: PropertyType.Numeric, description: "Deductible amount of the option.")
        check(required: true, type: PropertyType.String, description: "Check HW required. For ex: total.")
    }

    def roda_option_short = objectSchemaDefinitions {
        category(required: true, type: PropertyType.String, description: "Category of the option. For ex: total, screen, accident.")
        price(required: true, type: PropertyType.Numeric, description: "Price of the option.")
        deductible(required: true, type: PropertyType.Numeric, description: "Deductible percentage of the option.")
    }

    "/insurtech/roda/qpage"(platform:"/", type: TrackType.View) {
        device(required: true, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        options(required: false, type: PropertyType.ArrayList(PropertyType.Map(roda_option_short)), description: "Options presented in the qpage for quotation")
        financing_type(required: false, type: PropertyType.Map(financing_type_track_structure), description: "Financing data of item if it has")
    }

    "/insurtech/roda/qpage/deductible"(platform:"/", type: TrackType.Event) {
        device(required: true, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
    }

    "/insurtech/roda/qpage/faq"(platform:"/", type: TrackType.Event) {
        device(required: true, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        faq(required: true, type: PropertyType.String, description: "Name of the FAQ viewed. For ex: protection-cancel, deductible-fee")
    }

    "/insurtech/roda/qpage/buy"(platform:"/", type: TrackType.Event) {
        device(required: true, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        option(required: true, type: PropertyType.Map(roda_option), description: "Option plan selected on purchase.")
        financing_type(required: false, type: PropertyType.Map(financing_type_track_structure), description: "Financing data of item if it has")
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

    "/insurtech/payments/congrats_pending"(platform:"/mobile", type: TrackType.View) {
        quote_id(required: true, type: PropertyType.String, description: "Unique identifier of the quote selected in QPage.")
        flow(required: true, type: PropertyType.String, description: "Indicate which initiative you belong to.")
        preference_id(required: true, type: PropertyType.String, description: "Payment preference.")
        purchase_id(required: true, type: PropertyType.String, description: "Payment entity id")
    }
}
