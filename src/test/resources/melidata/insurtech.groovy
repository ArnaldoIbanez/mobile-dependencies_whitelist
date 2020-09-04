package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test('Insurtech - test garex tacking on checkout') {

        // Web
        "/garex/checkout"(platform:"/web", type: TrackType.View) {
            item = [
                    "id": "MLA824281356",
                    "domain_id": "MLA-TELEVISIONS",
                    "category_path": [ 'MLA1055', 'MLA1055'],
                    "financing_type": [
                            "no_interest_allowed" : true,
                            "installments": 12
                    ]
            ]
            options_has_discount = false
        }
        "/garex/checkout"(platform:"/web", type: TrackType.View) {
            item = [
                    "id": "MLA824281356",
                    "domain_id": "MLA-TELEVISIONS",
                    "category_path": [ 'MLA1055', 'MLA1055'],
                    "financing_type": [
                            "no_interest_allowed" : true,
                            "installments": 12
                    ]
            ]
            options_has_discount = true
        }
        "/garex/checkout/more_info"(platform:"/web", type: TrackType.Event) {
            item = [
                    "id": "MLA824281356",
                    "domain_id": "MLA-TELEVISIONS",
                    "category_path": [ 'MLA1055', 'MLA1055'],
                    "financing_type": [
                            "no_interest_allowed" : true,
                            "installments": 12
                    ]
            ]
            options_has_discount = false
        }
        "/garex/checkout/more_info"(platform:"/web", type: TrackType.Event) {
            item = [
                    "id": "MLA824281356",
                    "domain_id": "MLA-TELEVISIONS",
                    "category_path": [ 'MLA1055', 'MLA1055'],
                    "financing_type": [
                            "no_interest_allowed" : true,
                            "installments": 12
                    ]
            ]
            options_has_discount = true
        }
        "/garex/checkout/selected_garex"(platform:"/web", type: TrackType.Event) {
            garex = [
                "id": "MLA390289_GAR16001",
                "period": 24,
                "cost": 1234,
                "revenue_share_fee": 70,
                "revenue": 863.80,
                "currency_id": "ARS"
            ]
            item = [
                "id": "MLA824281356",
                "domain_id": "MLA-TELEVISIONS",
                "category_path": [ 'MLA1055', 'MLA1055'],
                "financing_type": [
                    "no_interest_allowed" : true,
                    "installments": 12
                ]
            ]
            options_has_discount = false
        }
        "/garex/checkout/selected_garex"(platform:"/web", type: TrackType.Event) {
            garex = [
                "id": "MLA390289_GAR16001",
                "period": 24,
                "cost": 1234,
                "revenue_share_fee": 70,
                "revenue": 863.80,
                "currency_id": "ARS",
                "discount_rate": 30
            ]
            item = [
                "id": "MLA824281356",
                "domain_id": "MLA-TELEVISIONS",
                "category_path": [ 'MLA1055', 'MLA1055'],
                "financing_type": [
                    "no_interest_allowed" : true,
                    "installments": 12
                ]
            ]
            options_has_discount = true
        }
        "/garex/checkout/selected_garex"(platform:"/web", type: TrackType.Event) {
            garex = [
                "id": "MLA390289_GAR16001",
                "period": 24,
                "cost": 1234,
                "revenue_share_fee": 70,
                "revenue": 863.80,
                "currency_id": "ARS",
                "discount_rate": null
            ]
            item = [
                "id": "MLA824281356",
                "domain_id": "MLA-TELEVISIONS",
                "category_path": [ 'MLA1055', 'MLA1055'],
                "financing_type": [
                    "no_interest_allowed" : true,
                    "installments": 12
                ]
            ]
            options_has_discount = false
        }
        "/garex/checkout/not_selected_garex"(platform:"/web", type: TrackType.Event) {
            item = [
                    "id": "MLA824281356",
                    "domain_id": "MLA-TELEVISIONS",
                    "category_path": [ 'MLA1055', 'MLA1055'],
                    "financing_type": [
                            "no_interest_allowed" : true,
                            "installments": 12
                    ]
            ]
            options_has_discount = true
        }
        "/garex/checkout/not_selected_garex"(platform:"/web", type: TrackType.Event) {
            item = [
                    "id": "MLA824281356",
                    "domain_id": "MLA-TELEVISIONS",
                    "category_path": [ 'MLA1055', 'MLA1055'],
                    "financing_type": [
                            "no_interest_allowed" : true,
                            "installments": 12
                    ]
            ]
            options_has_discount = false
        }
        "/garex/checkout/delete"(platform:"/web", type: TrackType.Event) {
            garex = [
                    "id": "MLA390289_GAR16001",
                    "period": 24,
                    "cost": 1234,
                    "revenue_share_fee": 70,
                    "revenue": 863.80,
                    "currency_id": "ARS"
            ]
        }

        //Mobile
        "/garex/checkout"(platform:"/mobile", type: TrackType.View) {}
        "/garex/checkout/more_info"(platform:"/mobile", type: TrackType.Event) {}
        "/garex/checkout/selected_garex"(platform:"/mobile", type: TrackType.Event) {
            garex_id = "MLA390289_GAR16001"
            period = 24
            cost = 1234
            revenue_share_fee = 71.3
            revenue = 863.80
            currency_id = "ARS"
        }
        "/garex/checkout/not_selected_garex"(platform:"/mobile", type: TrackType.Event) {}
        "/garex/checkout/delete"(platform:"/mobile", type: TrackType.Event) {
            garex_id = "MLA390289_GAR16001"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            cost = 1234
            currency_id = "ARS"
        }
    }

    defaultBusiness = "mercadopago"

    test('Insurtech - test roda tacking') {

        "/insurtech/roda/qpage"(platform:"/mobile", type: TrackType.View) {
            device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            options = [
                [
                    coverage: "theft_break",
                    price: 123.33,
                    deductible: 30.44
                ],
                [
                    coverage: "theft_break",
                    price: 100.33,
                    deductible: 20.44
                ]
            ]
            financing_type = null
        }

        "/insurtech/roda/qpage"(platform:"/mobile", type: TrackType.View) {
            device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            options = [
                [
                    coverage: "total",
                    price: 123.33,
                    deductible: 30.44
                ],
            ]
            financing_type = [
                no_interest_allowed : true,
                installments: 12
            ]
        }

        "/insurtech/roda/qpage/error"(platform:"/mobile", type: TrackType.View) {
            device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
        }

        "/insurtech/roda/qpage/error"(platform:"/web", type: TrackType.View) {
        }

        "/insurtech/roda/qpage/fallback"(platform:"/mobile", type: TrackType.View) {
            device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
        }

        "/insurtech/roda/qpage/fallback"(platform:"/web", type: TrackType.View) {
        }

        "/insurtech/roda/qpage/deductible"(platform:"/mobile", type: TrackType.View) {
            device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
        }

        "/insurtech/roda/qpage/faq"(platform:"/mobile", type: TrackType.View) {
            device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            faq = "protection-cancel"
        }

        "/insurtech/roda/qpage/buy"(platform:"/mobile", type: TrackType.View) {
            device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            option = [
                id: "123123-asdad",
                coverage: "theft_break",
                price: 123.44,
                monthly_price: 15.44,
                fee_price: 10.44,
                currency_id: "BRL",
                deductible: 10.25,
                deductible_amount: 20.00,
                check: "total"
            ]
            financing_type = [
                no_interest_allowed : true,
                installments: 12
            ]
        }

        "/insurtech/roda/qpage/buy"(platform:"/mobile", type: TrackType.View) {
            device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            option = [
                id: "123123-asdad",
                coverage: "theft_break",
                price: 123.44,
                monthly_price: 15.44,
                fee_price: 10.44,
                currency_id: "BRL",
                deductible: 10.25,
                deductible_amount: 20.00,
                check: "total"
            ]
            financing_type = null
        }

        //Mobile

        // INSURTECH RODA Hardware Check

        "/insurtech/hardware_check/onboarding"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/onboarding/exit"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/onboarding/start_tests"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/onboarding/permission_allow"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/onboarding/permission_deny"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/onboarding/permission_dont_ask_again"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/onboarding/permission_application_information"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/permission_denied"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/permission_denied/exit"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/permission_denied/accept"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/checkups"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/checkups/exit"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            check_id = "HEADPHONES"
            cycle = 2
            time_assigned = 60
        }

        "/insurtech/hardware_check/checkups/exit_cancel"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            check_id = "BACK_BUTTON"
            cycle = 1
            time_assigned = 60
        }

        "/insurtech/hardware_check/checkups/time_ended"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            check_id = "VOLUME_UP"
            cycle = 1
            time_assigned = 30
        }

        "/insurtech/hardware_check/checkups/try_again"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            check_id = "BACK_BUTTON"
            cycle = 2
        }

        "/insurtech/hardware_check/checkups/skip_check"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            check_id = "SCREEN"
        }

        "/insurtech/hardware_check/checkups/ready"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            check_id = "VOLUME_UP"
            cycle = 1
            time_success = 12
        }

        "/insurtech/hardware_check/checkups/failed"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            check_id = "VOLUME_DOWN"
        }

        "/insurtech/hardware_check/congrats_success"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/congrats_success/exit"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/congrats_success/main_action"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            action_description = "Continuar para o pagamento"
        }

        "/insurtech/hardware_check/congrats_success/secondary_action"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            action_description = "Continuar para o pagamento"
        }

        "/insurtech/hardware_check/congrats_failed"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/congrats_failed/exit"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/congrats_failed/main_action"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            action_description = "Tentar novamente"
        }

        "/insurtech/hardware_check/congrats_failed/secondary_action"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            action_description = "Tentar novamente"
        }

        "/insurtech/hardware_check/generic_error"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            step = "ONBOARDING"
            context = "Unable to resolve host : No address associated with hostname"
        }

        "/insurtech/hardware_check/generic_error/back"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            step = "ONBOARDING"
            context = "Unable to resolve host : No address associated with hostname"
        }

        "/insurtech/hardware_check/generic_error/try_again"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            step = "ONBOARDING"
            context = "Unable to resolve host : No address associated with hostname"
        }

        // INSURTECH RODA Payments

        "/insurtech/payments/loading"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
        }

        "/insurtech/payments/generic_error"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
        }

        "/insurtech/payments/px_checkout"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
        }

        "/insurtech/payments/px_checkout/back"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
        }

        "/insurtech/payments/px_checkout/pay"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
        }

        "/insurtech/payments/congrats_approved"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
        }

        "/insurtech/payments/congrats_approved/go_to_insurance"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
            action_description = "Administrar mis seguros"
        }

        "/insurtech/payments/congrats_approved/go_to_home"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
            action_description = "Ir al inicio"
        }

        "/insurtech/payments/congrats_rejected"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
        }

        "/insurtech/payments/congrats_rejected/go_to_home"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
            action_description = "Ir al inicio"
        }

        "/insurtech/payments/congrats_pending"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
        }

        "/insurtech/payments/congrats_pending/go_to_home"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
            action_description = "Ir al inicio"
        }

        "/insurtech/protections"(platform:"/mobile", type: TrackType.View) {
            device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            protections = [
                [
                    product_id: "roda",
                    insurance_purchase_key: "roda-ABC123",
                ],
                [
                    product_id: "garex",
                    insurance_purchase_key: "garex-ABC125",
                ]
            ]
            roda = [
                has_protections: true,
                is_current_device_protected: false,
                is_current_device_quotable: false,
                offered: false
            ]
            garex = [
                has_protections: true,
                offered: false
            ]
        }

        "/insurtech/protections"(platform:"/mobile", type: TrackType.View) {
            device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            protections = [
                [
                    product_id: "roda",
                    insurance_purchase_key: "roda-ABC123",
                ],
            ]
            roda = [
                has_protections: true,
                is_current_device_protected: false,
                is_current_device_quotable: true,
                offered: true
            ]
            garex = [
                has_protections: false,
                offered: false
            ]
        }

        "/insurtech/protections"(platform:"/mobile", type: TrackType.View) {
            device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            protections = [
                [
                    product_id: "garex",
                    insurance_purchase_key: "garex-ABC125",
                ]
            ]
            roda = [
                has_protections: false,
                is_current_device_protected: false,
                is_current_device_quotable: true,
                offered: true
            ]
            garex = [
                has_protections: true,
                offered: false
            ]
        }

        "/insurtech/protections"(platform:"/web", type: TrackType.View) {
            roda = [
                has_protections: false,
                is_current_device_protected: false,
                is_current_device_quotable: false,
                offered: false
            ]
            garex = [
                has_protections: false,
                offered: false
            ]
        }


        "/insurtech/protections"(platform:"/web", type: TrackType.View) {
            protections = [
                [
                    product_id: "roda",
                    insurance_purchase_key: "roda-ABC123",
                ],
            ]
            roda = [
                has_protections: true,
                is_current_device_protected: false,
                is_current_device_quotable: false,
                offered: false
            ]
            garex = [
                has_protections: false,
                offered: false
            ]
        }

        "/insurtech/protections/quote-me"(platform:"/mobile", type: TrackType.Event) {
            device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            protections = [
                [
                    product_id: "garex",
                    insurance_purchase_key: "garex-ABC125",
                ]
            ]
        }

        "/insurtech/protections/doubts"(platform:"/web", type: TrackType.Event) {
            protections = [
                [
                    product_id: "garex",
                    insurance_purchase_key: "garex-ABC125",
                ]
            ]
        }


        "/insurtech/protections/doubts"(platform:"/mobile", type: TrackType.Event) {
            device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            protections = [
                [
                    product_id: "garex",
                    insurance_purchase_key: "garex-ABC125",
                ]
            ]
        }

        "/insurtech/protections/error"(platform:"/mobile", type: TrackType.View) {
            device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
        }

        "/insurtech/protections/error"(platform:"/web", type: TrackType.View) {
        }

        "/insurtech/protections/fallback"(platform:"/mobile", type: TrackType.View) {
            device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
        }

        "/insurtech/protections/fallback"(platform:"/web", type: TrackType.View) {
        }

        "/insurtech/protections/finished"(platform:"/mobile", type: TrackType.View) {
            device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            protections = [
                [
                    product_id: "roda",
                    insurance_purchase_key: "roda-ABC125",
                ]
            ]
        }

        "/insurtech/protections/finished"(platform:"/web", type: TrackType.View) {
            protections = [
                [
                    product_id: "garex",
                    insurance_purchase_key: "garex-ABC125",
                ]
            ]
        }
    }
}
