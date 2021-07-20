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
        "/garex/checkout"(platform:"/mobile", type: TrackType.View) {
            session_id = "B1955F95-8C0C-4585-B970-DA6DBF0CEADE"
        }
        "/garex/checkout/more_info"(platform:"/mobile", type: TrackType.Event) {
            session_id = "B1955F95-8C0C-4585-B970-DA6DBF0CEADE"
        }
        "/garex/checkout/selected_garex"(platform:"/mobile", type: TrackType.Event) {
            garex_id = "MLA390289_GAR16001"
            period = 24
            cost = 1234
            revenue_share_fee = 71.3
            revenue = 863.80
            currency_id = "ARS"
            session_id = "B1955F95-8C0C-4585-B970-DA6DBF0CEADE"
        }
        "/garex/checkout/not_selected_garex"(platform:"/mobile", type: TrackType.Event) {
            session_id = "B1955F95-8C0C-4585-B970-DA6DBF0CEADE"
        }
        "/garex/checkout/delete"(platform:"/mobile", type: TrackType.Event) {
            garex_id = "MLA390289_GAR16001"
            cost = 1234
            currency_id = "ARS"
            session_id = "B1955F95-8C0C-4585-B970-DA6DBF0CEADE"
        }

        "/garex/checkout/back"(platform:"/mobile", type: TrackType.Event) {
            session_id = "B1955F95-8C0C-4585-B970-DA6DBF0CEADE"
        }

        "/garex/checkout/tap_selector"(platform:"/mobile", type: TrackType.Event) {
            session_id = "B1955F95-8C0C-4585-B970-DA6DBF0CEADE"
            garex_id = "MLA390289_GAR16001"
            period = 24
            cost = 1234
            revenue_share_fee = 71.3
            revenue = 863.80
            currency_id = "ARS"
        }

        "/garex/checkout/selected_warranty_option"(platform:"/mobile", type: TrackType.Event) {
            session_id = "B1955F95-8C0C-4585-B970-DA6DBF0CEADE"
            garex_id = "MLA390289_GAR16001"
            period = 24
            cost = 1234
            revenue_share_fee = 71.3
            revenue = 863.80
            currency_id = "ARS"
        }

        "/garex/checkout/conditions_disclaimer"(platform: "/mobile", type: TrackType.Event) {
            session_id = "B1955F95-8C0C-4585-B970-DA6DBF0CEADE"
        }

        "/garex/checkout/terms_disclaimer"(platform: "/mobile", type: TrackType.Event) {
            session_id = "B1955F95-8C0C-4585-B970-DA6DBF0CEADE"
        }

        "/garex/skeleton"(platform:"/mobile", type: TrackType.View) {
            session_id = "B1955F95-8C0C-4585-B970-DA6DBF0CEADE"
        }

        "/garex/skeleton/back"(platform:"/mobile", type: TrackType.Event) {
            session_id = "B1955F95-8C0C-4585-B970-DA6DBF0CEADE"
        }

        "/garex/checkout/quote_creation_success"(platform:"/mobile", type: TrackType.Event) {
            session_id = "B1955F95-8C0C-4585-B970-DA6DBF0CEADE"
            quote_id = "ed3506b2-b41c-442d-9981-b49eb65d57a4"
        }

        "/garex/checkout/quote_creation_error"(platform:"/mobile", type: TrackType.Event) {
            session_id = "B1955F95-8C0C-4585-B970-DA6DBF0CEADE"
            garex_id = "MLA390289_GAR16001"
            period = 24
            cost = 1234
            revenue_share_fee = 71.3
            revenue = 863.80
            currency_id = "ARS"
        }
    }

    defaultBusiness = "mercadolibre"

    test('Insurtech - test qpage_on tacking on checkout') {

        //Mobile
        "/insurtech/qpage_on/skeleton"(platform:"/mobile", type: TrackType.View) {
            session_id = "F5KDDRSA-ARR3-8C0C-4585-455AGAFCEADE"
        }
        "/insurtech/qpage_on/skeleton/back"(platform:"/mobile", type: TrackType.Event) {
            session_id = "F5KDDRSA-ARR3-8C0C-4585-455AGAFCEADE"
        }

        "/insurtech/qpage_on"(platform:"/mobile", type: TrackType.View) {
            session_id = "F5KDDRSA-ARR3-8C0C-4585-455AGAFCEADE"
        }

        "/insurtech/qpage_on/select"(platform:"/mobile", type: TrackType.Event) {
            session_id = "F5KDDRSA-ARR3-8C0C-4585-455AGAFCEADE"
            flow_id = "RODA"
            option_id = "mlb-9a85a2f9-116b-4a10-8ac4-979c4e1fae4a-option_middle_high"
            period = 12
            cost = 270
            original_cost = 300
            discount_rate = 10
            revenue_share_fee = 30
            revenue = 78
            currency_id = "BR"
        }

        "/insurtech/qpage_on/help"(platform:"/mobile", type: TrackType.Event) {
            session_id = "F5KDDRSA-ARR3-8C0C-4585-455AGAFCEADE"
            flow_id = "RODA"
        }

        "/insurtech/qpage_on/add"(platform:"/mobile", type: TrackType.Event) {
            session_id = "F5KDDRSA-ARR3-8C0C-4585-455AGAFCEADE"
            flow_id = "RODA"
            option_id = "mlb-9a85a2f9-116b-4a10-8ac4-979c4e1fae4a-option_middle_high"
            period = 12
            cost = 270
            original_cost = 300
            discount_rate = 10
            revenue_share_fee = 30
            revenue = 78
            currency_id = "BR"
        }

        "/insurtech/qpage_on/skip"(platform:"/mobile", type: TrackType.Event) {
            session_id = "F5KDDRSA-ARR3-8C0C-4585-455AGAFCEADE"
        }

        "/insurtech/qpage_on/quote_fail"(platform:"/mobile", type: TrackType.Event) {
            session_id = "F5KDDRSA-ARR3-8C0C-4585-455AGAFCEADE"
            flow_id = "RODA"
            option_id = "mlb-9a85a2f9-116b-4a10-8ac4-979c4e1fae4a-option_middle_high"
            period = 12
            cost = 270
            original_cost = 300
            discount_rate = 10
            revenue = 78
            currency_id = "BR"
        }

        "/insurtech/qpage_on/quote_success"(platform:"/mobile", type: TrackType.Event) {
            session_id = "F5KDDRSA-ARR3-8C0C-4585-455AGAFCEADE"
            flow_id = "RODA"
            quote_id = "343cae11-d2ef-4115-b284-96c7e69fb1d8"
        }

        "/insurtech/qpage_on/back"(platform:"/mobile", type: TrackType.Event) {
            session_id = "F5KDDRSA-ARR3-8C0C-4585-455AGAFCEADE"
        }


        "/insurtech/qpage_on/error"(platform:"/mobile", type: TrackType.Event) {
            session_id = "F5KDDRSA-ARR3-8C0C-4585-455AGAFCEADE"
            error_type = "timeout"
        }

        "/insurtech/qpage_on/error"(platform:"/mobile", type: TrackType.Event) {
            session_id = "F5KDDRSA-ARR3-8C0C-4585-455AGAdaA4124a"
        }

        "/insurtech/qpage_on/delete"(platform:"/mobile", type: TrackType.Event) {
            session_id = "F5KDDRSA-ARR3-8C0C-4585-455AGAFCEADE"
            flow_id = "RODA"
            option_id = "mlb-9a85a2f9-116b-4a10-8ac4-979c4e1fae4a-option_middle_high"
            quote_id = "343cae11-d2ef-4115-b284-96c7e69fb1d8"
            cost = 270
            currency_id = "BR"
        }
    }

    defaultBusiness = "mercadolibre"

    test('Insurtech - test hub-on tacking on checkout'){
        "/insurtech/qpage_on"(platform:"/web", type: TrackType.View) {
            item = [
               id: "MLB1539246793",
               domain_id: "MLB-FREEZERS",
               price: 2300.0,
            ]
            options = [
            [
                product_id: "GAREX",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    manufacturer_warranty: 12
                ],
            ],
            [
                product_id: "RODA",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    brand: "Samsung",
                    coverage: "screen",
                    deductible_amount: 279.9,
                    model: "Galaxy A70",
                    size: "128GB"
                ],
            ]
           ]
           has_roda = false
           has_garex = true
        }
        "/insurtech/qpage_on/select"(platform:"/web", type: TrackType.Event) {
            item = [
                id: "MLB1539246793",
                domain_id: "MLB-FREEZERS",
                price: 2300.0,
            ]
            option_selected = [
                product_id: "GAREX",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    manufacturer_warranty: 12
                ],
           ]
           has_roda = true
           has_garex = true
        }
        "/insurtech/qpage_on/add"(platform:"/web", type: TrackType.Event) {
            item = [
                id: "MLB1539246793",
                domain_id: "MLB-FREEZERS",
                price: 2300.0,
            ]
            options = [
            [
                product_id: "GAREX",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    manufacturer_warranty: 12
                ],
            ],
            [
                product_id: "RODA",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    brand: "Samsung",
                    coverage: "screen",
                    deductible_amount: 279.9,
                    model: "Galaxy A70",
                    size: "128GB"
                ],
            ],
            ]
            option_selected = [
                product_id: "RODA",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    brand: "Samsung",
                    coverage: "screen",
                    deductible_amount: 279.9,
                    model: "Galaxy A70",
                    size: "128GB"
                ]
            ]
            has_roda = true
            has_garex = true
        }
        "/insurtech/qpage_on/quote_success"(platform:"/web", type: TrackType.Event) {
            item = [
                id: "MLB1539246793",
                domain_id: "MLB-FREEZERS",
                price: 2300.0,
            ]
            options = [
            [
                product_id: "GAREX",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    manufacturer_warranty: 12
                ],
            ],
            [
                product_id: "RODA",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    brand: "Samsung",
                    coverage: "screen",
                    deductible_amount: 279.9,
                    model: "Galaxy A70",
                    size: "128GB"
                ],
            ],
            ]
            option_selected = [
                product_id: "RODA",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    brand: "Samsung",
                    coverage: "screen",
                    deductible_amount: 279.9,
                    model: "Galaxy A70",
                    size: "128GB"
                ]
            ]
            has_roda = true
            has_garex = true
        }
        "/insurtech/qpage_on/quote_fail"(platform:"/web", type: TrackType.Event) {
            item = [
                id: "MLB1539246793",
                domain_id: "MLB-FREEZERS",
                price: 2300.0,
            ]
            options = [
            [
                product_id: "GAREX",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    manufacturer_warranty: 12
                ],
            ],
            [
                product_id: "RODA",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    brand: "Samsung",
                    coverage: "screen",
                    deductible_amount: 279.9,
                    model: "Galaxy A70",
                    size: "128GB"
                ],
            ],
            ]
            option_selected = [
                product_id: "RODA",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    brand: "Samsung",
                    coverage: "screen",
                    deductible_amount: 279.9,
                    model: "Galaxy A70",
                    size: "128GB"
                ]
            ]
            has_roda = true
            has_garex = true
        }
        "/insurtech/qpage_on/skip"(platform:"/web", type: TrackType.Event) {
           item = [
               id: "MLB1539246793",
               domain_id: "MLB-FREEZERS",
               price: 2300.0,
           ]
           options = [
            [
                product_id: "GAREX",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    manufacturer_warranty: 12
                ],
            ],
            [
                product_id: "RODA",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    brand: "Samsung",
                    coverage: "screen",
                    deductible_amount: 279.9,
                    model: "Galaxy A70",
                    size: "128GB"
                ],
            ]
           ]
           has_roda = true
           has_garex = true
        }
        "/insurtech/qpage_on/help"(platform:"/web", type: TrackType.Event) {
            item = [
                id: "MLB1539246793",
                domain_id: "MLB-FREEZERS",
                price: 2300.0,
            ]
            option_selected = [
                product_id: "GAREX",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    manufacturer_warranty: 12
                ],
           ]
           has_roda = true
           has_garex = false
         }
        "/insurtech/qpage_on/faq"(platform:"/web", type: TrackType.View) {
            product_id = "RODA"
            coverage = "screen"
            manufacturer_warranty = null
            period = null
         }
         "/insurtech/qpage_on/terms"(platform:"/web", type: TrackType.View) {
            product_id = "RODA"
            from = "insurance-fe-hub-off"
         }
         "/insurtech/qpage_on/particular_conditions"(platform:"/web", type: TrackType.View) {
            product_id = "GAREX"
            from = "insurance-fe-hub-off"
         }
        "/insurtech/marketplace/checkout/garex_flow"(platform:"/", type: TrackType.View) {
            item = [
                    id: "MLB1539246793",
                    domain_id: "MLB-FREEZERS",
                    price: 2300.0,
            ]
            options = [
                    [
                            product_id: "GAREX",
                            price: [
                                    final_amount: 242.73,
                                    discount_rate: null,
                            ],
                            period: 12,
                            option_data: [
                                    manufacturer_warranty: 12
                            ],
                    ],
                    [
                            product_id: "RODA",
                            price: [
                                    final_amount: 242.73,
                                    discount_rate: null,
                            ],
                            period: 12,
                            option_data: [
                                    brand: "Samsung",
                                    coverage: "screen",
                                    deductible_amount: 279.9,
                                    model: "Galaxy A70",
                                    size: "128GB"
                            ],
                    ]
            ]
        }
    }

    defaultBusiness = "mercadolibre"
    test('Insurtech - test hub-off tacking on checkout'){
        "/insurtech/qpage_off"(platform:"/", type: TrackType.View) {
            item = [
               id: "MLB1539246793",
               domain_id: "MLB-FREEZERS",
               price: 2300.0,
            ]
            options = [
            [
                product_id: "GAREX",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    manufacturer_warranty: 12
                ],
            ],
            [
                product_id: "RODA",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    brand: "Samsung",
                    coverage: "screen",
                    deductible_amount: 279.9,
                    model: "Galaxy A70",
                    size: "128GB"
                ],
            ]
            ]
            has_roda = false
            has_garex = true
            order_id = '12345'
        }
        "/insurtech/qpage_off/select"(platform:"/", type: TrackType.Event) {
            item = [
                id: "MLB1539246793",
                domain_id: "MLB-FREEZERS",
                price: 2300.0,
            ]
            option_selected = [
                product_id: "GAREX",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    manufacturer_warranty: 12
                ],
            ]
            has_roda = true
            has_garex = true
            order_id = '12345'
        }
        "/insurtech/qpage_off/add"(platform:"/", type: TrackType.Event) {
            item = [
                id: "MLB1539246793",
                domain_id: "MLB-FREEZERS",
                price: 2300.0,
            ]
            options = [
            [
                product_id: "GAREX",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    manufacturer_warranty: 12
                ],
            ],
            [
                product_id: "RODA",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    brand: "Samsung",
                    coverage: "screen",
                    deductible_amount: 279.9,
                    model: "Galaxy A70",
                    size: "128GB"
                ],
            ],
            ]
            option_selected = [
                product_id: "RODA",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    brand: "Samsung",
                    coverage: "screen",
                    deductible_amount: 279.9,
                    model: "Galaxy A70",
                    size: "128GB"
                ]
            ]
            has_roda = true
            has_garex = true
            order_id = '12345'
        }
        "/insurtech/qpage_off/quote_success"(platform:"/", type: TrackType.Event) {
            item = [
                id: "MLB1539246793",
                domain_id: "MLB-FREEZERS",
                price: 2300.0,
            ]
            options = [
            [
                product_id: "GAREX",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    manufacturer_warranty: 12
                ],
            ],
            [
                product_id: "RODA",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    brand: "Samsung",
                    coverage: "screen",
                    deductible_amount: 279.9,
                    model: "Galaxy A70",
                    size: "128GB"
                ],
            ],
            ]
            option_selected = [
                product_id: "RODA",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    brand: "Samsung",
                    coverage: "screen",
                    deductible_amount: 279.9,
                    model: "Galaxy A70",
                    size: "128GB"
                ]
            ]
            has_roda = true
            has_garex = true
            order_id = '12345'
        }
        "/insurtech/qpage_off/quote_fail"(platform:"/", type: TrackType.Event) {
            item = [
                id: "MLB1539246793",
                domain_id: "MLB-FREEZERS",
                price: 2300.0,
            ]
            options = [
            [
                product_id: "GAREX",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    manufacturer_warranty: 12
                ],
            ],
            [
                product_id: "RODA",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    brand: "Samsung",
                    coverage: "screen",
                    deductible_amount: 279.9,
                    model: "Galaxy A70",
                    size: "128GB"
                ],
            ],
            ]
            option_selected = [
                product_id: "RODA",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    brand: "Samsung",
                    coverage: "screen",
                    deductible_amount: 279.9,
                    model: "Galaxy A70",
                    size: "128GB"
                ]
            ]
            has_roda = true
            has_garex = true
            order_id = '12345'
        }
        "/insurtech/qpage_off/help"(platform:"/", type: TrackType.Event) {
            item = [
                id: "MLB1539246793",
                domain_id: "MLB-FREEZERS",
                price: 2300.0,
            ]
            option_selected = [
                product_id: "GAREX",
                price: [
                    final_amount: 242.73,
                    discount_rate: null,
                ],
                period: 12,
                option_data: [
                    manufacturer_warranty: 12
                ],
            ]
            has_roda = true
            has_garex = false
            order_id = '12345'
         }
        "/insurtech/qpage_off/faq"(platform:"/", type: TrackType.View) {
            product_id = "RODA"
            coverage = "screen"
            manufacturer_warranty = null
            period = null
        }
        "/insurtech/qpage_off/error"(platform:"/", type: TrackType.View) {
        }
        "/insurtech/qpage_off/fallback"(platform:"/", type: TrackType.View) {
        }
        "/insurtech/qpage_off/congrats"(platform:"/", type: TrackType.View) {
            order_id = '12345'
            product_id = 'GAREX'
            item = [
                id: "MLB1539246793",
                domain_id: "MLB-FREEZERS",
                price: 2300.0,
            ]
            payment = [
                id: 12345,
                payment_type_id: 'credit_card',
                transaction_amount: 2330.0,
                status: 'approved',
            ]
        }
        "/insurtech/qpage_off/congrats/go_to_protections_page"(platform:"/", type: TrackType.Event) {
            order_id = '12345'
            product_id = 'GAREX'
            item = [
                id: "MLB1539246793",
                domain_id: "MLB-FREEZERS",
                price: 2300.0,
            ]
            payment = [
                id: 12345,
                payment_type_id: 'credit_card',
                transaction_amount: 2330.0,
                status: 'approved',
            ]
        }
        "/insurtech/qpage_off/congrats/go_to_my_protections_page"(platform:"/", type: TrackType.Event) {
            order_id = '12345'
            product_id = 'GAREX'
            item = [
                id: "MLB1539246793",
                domain_id: "MLB-FREEZERS",
                price: 2300.0,
            ]
            payment = [
                id: 12345,
                payment_type_id: 'credit_card',
                transaction_amount: 2330.0,
                status: 'approved',
            ]
        }
    }

    defaultBusiness = "mercadopago"

    test('Insurtech - test roda tacking') {

        "/insurtech/roda/qpage"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            order_device = [
                brand: "Sony",
                model: "Xperia",
                model_code: "Xa1",
                size: "32GB",
                device_code: "diw387_1u1",
            ]
            options = [
                [
                    coverage: "theft_break",
                    price: 123.33,
                    deductible_amount: 12.33,
                    gtin:[
                        "7899403636915",
                        "7893299910425"
                    ],
                    discount_rate: 10,
                    insured_amount: 30000,
                    item_cost: 15000,
                    franchise_type: "PREV_OPEN_CLAIM",
                    available_resolution_types:[
                        "repair",
                        "compensation"
                    ],
                    allowed_opening: 2,
                    compensation_money_amount: 10000,
                ],
                [
                    coverage: "theft_break",
                    price: 100.33,
                    deductible_amount: 12.33,
                    gtin:[
                        "7899403636915",
                        "7893299910425"
                    ],
                    discount_rate: 0,
                    insured_amount: 30000,
                    item_cost: 15000,
                    franchise_type: "PREV_OPEN_CLAIM",
                    available_resolution_types:[
                        "repair",
                        "compensation"
                    ],
                    allowed_opening: 2,
                    compensation_money_amount: 10000,
                ]
            ]
            entity_type = "order"
            entity_id = "MLB789078907890"
            item_id = "MLB123124"
            buying_mode = 'buy_it_now'
        }

        "/insurtech/roda/qpage"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            order_device = [
                brand: "Sony",
                model: "Xperia",
                model_code: "Xa1",
                size: "32GB",
                device_code: "diw387_1u1",
            ]
            options = [
                [
                    coverage: "total",
                    price: 123.33,
                    deductible_amount: 12.33,
                    gtin:[
                        "7899403636915",
                        "7893299910425"
                    ],
                    discount_rate: 0,
                    insured_amount: 30000,
                    item_cost: 15000,
                    franchise_type: "PREV_OPEN_CLAIM",
                    available_resolution_types:[
                        "repair",
                        "compensation"
                    ],
                    allowed_opening: 2,
                    compensation_money_amount: 10000,
                ],
            ]
            entity_type = "order"
            entity_id = "MLB789078907890"
            item_id = "MLB123124"
            buying_mode = 'buy_it_now'
            discount_code = 'CODE TEST'
        }

        "/insurtech/roda/qpage/error"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            buying_mode = 'buy_it_now'
        }

        "/insurtech/roda/qpage/error"(platform:"/web", type: TrackType.View) {
            buying_mode = 'subscription'
        }

        "/insurtech/roda/qpage/fallback/default"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            fallback_type= "default"
            buying_mode = 'buy_it_now'
        }

        "/insurtech/roda/qpage/fallback/default"(platform:"/web", type: TrackType.View) {
            buying_mode = 'subscription'
        }

        "/insurtech/roda/qpage/fallback/skip_expired"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            fallback_type = "skip_hardware_check_expired"
            buying_mode = 'buy_it_now'
        }

        "/insurtech/roda/qpage/fallback/skip_expired"(platform:"/web", type: TrackType.View) {
            buying_mode = 'subscription'
        }

        "/insurtech/roda/qpage/quoting_fallback/default/quotable"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            fallback_type= "default"
            quotable= true
            buying_mode = 'buy_it_now'
        }

        "/insurtech/roda/qpage/quoting_fallback/default/quotable"(platform:"/web", type: TrackType.View) {
            buying_mode = 'subscription'
            quotable= true
        }

        "/insurtech/roda/qpage/quoting_fallback/default/not_quotable"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            fallback_type= "default"
            quotable= false
            buying_mode = 'buy_it_now'
        }

        "/insurtech/roda/qpage/quoting_fallback/default/not_quotable"(platform:"/web", type: TrackType.View) {
            buying_mode = 'subscription'
            quotable = false
        }

        "/insurtech/roda/qpage/quoting_fallback/order_cancelled/quotable"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            fallback_type= "order_cancelled"
            quotable= true
            buying_mode = 'buy_it_now'
        }

        "/insurtech/roda/qpage/quoting_fallback/order_cancelled/quotable"(platform:"/web", type: TrackType.View) {
            buying_mode = 'subscription'
            quotable= true
        }

        "/insurtech/roda/qpage/quoting_fallback/order_cancelled/not_quotable"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            fallback_type= "order_cancelled"
            quotable= false
            buying_mode = 'buy_it_now'
        }

        "/insurtech/roda/qpage/quoting_fallback/order_cancelled/not_quotable"(platform:"/web", type: TrackType.View) {
            buying_mode = 'subscription'
            quotable= false
        }

        "/insurtech/roda/qpage/deductible"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            order_device = [
                brand: "Sony",
                model: "Xperia",
                model_code: "Xa1",
                size: "32GB",
            ]
            entity_type = "order"
            entity_id = "MLB789078907890"
            item_id = "MLB123124"
            buying_mode = 'buy_it_now'
            discount_code = 'CODE TEST'
        }
         "/insurtech/roda/qpage/deductible"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            order_device = [
                brand: "Sony",
                model: "Xperia",
                model_code: "Xa1",
                size: "32GB",
            ]
            entity_type = "order"
            entity_id = "MLB789078907890"
            item_id = "MLB123124"
            buying_mode = 'buy_it_now'
        }

        "/insurtech/roda/qpage/faq"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            order_device = [
                brand: "Sony",
                model: "Xperia",
                model_code: "Xa1",
                size: "32GB",
                device_code: "diw387_1u1",
            ]
            entity_type = "order"
            entity_id = "789078907890"
            item_id = "MLB123124"
            faq = "protection-cancel"
            buying_mode = 'buy_it_now'
            discount_code = 'CODE TEST'
        }

        "/insurtech/roda/qpage/faq"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            order_device = [
                brand: "Sony",
                model: "Xperia",
                model_code: "Xa1",
                size: "32GB",
                device_code: "diw387_1u1",
            ]
            entity_type = "order"
            entity_id = "789078907890"
            item_id = "MLB123124"
            faq = "protection-cancel"
            buying_mode = 'buy_it_now'
        }

        "/insurtech/roda/qpage/buy"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            order_device = [
                brand: "Sony",
                model: "Xperia",
                model_code: "Xa1",
                size: "32GB",
                device_code: "diw387_1u1",
            ]
            option = [
                id: "123123-asdad",
                coverage: "theft_break",
                price: 123.44,
                monthly_price: 15.44,
                fee_price: 10.44,
                currency_id: "BRL",
                deductible_amount: 20.00,
                check: "total",
                gtin:[
                    "7899403636915",
                    "7893299910425"
                ],
                discount_rate: 30,
                insured_amount: 30000,
                item_cost: 15000,
                franchise_type: "PREV_OPEN_CLAIM",
                available_resolution_types:[
                    "repair",
                    "compensation"
                ],
                allowed_opening: 2,
                compensation_money_amount: 10000,
            ]
            entity_type = "order"
            entity_id = "789078907890"
            item_id = "MLB123124"
            hardware_check = false
            buying_mode = 'buy_it_now'
            discount_code = 'CODE TEST'
        }

        "/insurtech/roda/qpage/buy"(platform:"/mobile", type: TrackType.View) {
            client_device = [
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
                deductible_amount: 20.00,
                check: "total",
                gtin:[
                    "7899403636915",
                    "7893299910425"
                ],
                discount_rate: 0,
            ]
            order_device = [
                brand: "Sony",
                model: "Xperia",
                model_code: "Xa1",
                size: "32GB",
                device_code: "diw387_1u1",
            ]
            entity_type = "order"
            entity_id = "789078907890"
            item_id = "MLB123124"
            hardware_check = true
            buying_mode = 'subscription'
        }

        "/insurtech/roda/qpage/option_selected"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            order_device = [
                brand: "Sony",
                model: "Xperia",
                model_code: "Xa1",
                size: "32GB",
                device_code: "diw387_1u1",
            ]
            option = [
                id: "123123-asdad",
                coverage: "theft_break",
                price: 123.44,
                monthly_price: 15.44,
                fee_price: 10.44,
                currency_id: "BRL",
                deductible_amount: 20.00,
                check: "total",
                gtin:[
                    "7899403636915",
                    "7893299910425"
                ],
                discount_rate: 20,
                insured_amount: 30000,
                item_cost: 15000,
                franchise_type: "PREV_OPEN_CLAIM",
                available_resolution_types:[
                    "repair",
                    "compensation"
                ],
                allowed_opening: 2,
                compensation_money_amount: 10000,
            ]
            entity_type = "order"
            entity_id = "789078907890"
            item_id = "MLB123124"
            buying_mode = 'subscription'
            discount_code = 'CODE TEST'
        }

        "/insurtech/roda/qpage/quoting_fallback/default/quotable/select"(platform:"/", type: TrackType.Event) {
            client_device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            fallback_type= "default"
            quotable= true
            buying_mode = 'buy_it_now'
        }

        "/insurtech/roda/qpage/quoting_fallback/order_cancelled/quotable/select"(platform:"/", type: TrackType.Event) {
            client_device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            fallback_type= "order_cancelled"
            quotable= true
            buying_mode = 'buy_it_now'
        }

        "/insurtech/roda/qpage/congrats_subscription"(platform:"/", type: TrackType.View) {
            purchase_id='quote-13aeab9c-70af-43a7-91da-2013ae66b750-test'
            preference_id='593032277-5f9f2c52-b5f9-41c7-b95e-761ff7f2fd97'
            payment_id=10341173315
            status='approved'
        }

        "/insurtech/roda/qpage/congrats_subscription/go_to_protections"(platform:"/", type: TrackType.Event) {
            purchase_id='quote-13aeab9c-70af-43a7-91da-2013ae66b750-test'
            preference_id='593032277-5f9f2c52-b5f9-41c7-b95e-761ff7f2fd97'
            payment_id=10341173315
            status='approved'
        }

        "/insurtech/roda/qpage/congrats_subscription/go_to_protection_detail"(platform:"/", type: TrackType.Event) {
            purchase_id='quote-13aeab9c-70af-43a7-91da-2013ae66b750-test'
            preference_id='593032277-5f9f2c52-b5f9-41c7-b95e-761ff7f2fd97'
            payment_id=10341173315
            status='pending'
        }

        "/insurtech/roda/qpage/onboarding_kyc"(platform:"/", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            buying_mode = 'subscription'
            quote_intention_id = '253D824dd923-3713-4720-8928-UUID-test'
        }

        "/insurtech/roda/qpage/onboarding_kyc/go_to_kyc"(platform:"/", type: TrackType.Event) {
            client_device = [
                brand: "Samsung",
                model: "J7",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            buying_mode = 'subscription'
            quote_intention_id = '253D824dd923-3713-4720-8928-UUID-test'
        }

        //Mobile

        // INSURTECH RODA Hardware Check

        "/insurtech/hardware_check/onboarding"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/onboarding/exit"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            session_id = "348536772342324"
            view_time = 234578
        }

        "/insurtech/hardware_check/onboarding/back"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            session_id = "348536772342324"
            view_time = 284578
        }

        "/insurtech/hardware_check/onboarding/start_tests"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/onboarding/device_info_error"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            error_description = "illegal State Exception on get information()"
            view_time = 24578
        }

        "/insurtech/hardware_check/onboarding/permission_allow"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            session_id = "348536772342324"
            view_time = 24578
        }

        "/insurtech/hardware_check/onboarding/permission_deny"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/onboarding/permission_dont_ask_again"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            session_id = "348536772342324"
            view_time = 2345782
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

        "/insurtech/hardware_check/permission_denied/back"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            session_id = "348536772342324"
            view_time = 134578
        }

        "/insurtech/hardware_check/permission_denied/accept"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            session_id = "348536772342324"
            view_time = 664578
        }

        "/insurtech/hardware_check/checkups"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            session_id = "348536772342324"
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
            session_id = "348536772342324"
            view_time = 204578
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
            session_id = "348536772342324"
            view_time = 14578
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
            session_id = "348536772342324"
            view_time = 1094578
        }

        "/insurtech/hardware_check/checkups/failed"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            check_id = "VOLUME_DOWN"
            session_id = "348536772342324"
            view_time = 604578
        }

        "/insurtech/hardware_check/checkups/first_touch"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            time_elapsed = 4
            view_time = 604575
        }

        "/insurtech/hardware_check/checkups/redirect"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            deep_link = "mercadopago://insurance/webview?url=https%3A%2F%2mercadopago.com.br%2F%26param%3Dvalue%"
            view_time = 604575
        }

        "/insurtech/hardware_check/congrats_success"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            session_id = "348536772342324"
        }

        "/insurtech/hardware_check/congrats_success/exit"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/congrats_success/main_action"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            action_description = "Continuar para o pagamento"
            session_id = "348536772342324"
            view_time = 64578
        }

        "/insurtech/hardware_check/congrats_success/secondary_action"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            action_description = "Continuar para o pagamento"
            session_id = "348536772342324"
            view_time = 214578
        }

        "/insurtech/hardware_check/congrats_failed"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
        }

        "/insurtech/hardware_check/congrats_failed/exit"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            session_id = "348536772342324"
            view_time = 94578
        }

        "/insurtech/hardware_check/congrats_failed/main_action"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            action_description = "Tentar novamente"
        }

        "/insurtech/hardware_check/congrats_failed/secondary_action"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            action_description = "Tentar novamente"
            session_id = "348536772342324"
            view_time =294578
        }

        "/insurtech/hardware_check/generic_error"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            step = "ONBOARDING"
            context = "Unable to resolve host : No address associated with hostname"
            session_id = "348536772342324"
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
            session_id = "348536772342324"
            view_time = 964578
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

        "/insurtech/payments/px_checkout/congrats_in_process"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
        }

        "/insurtech/payments/px_checkout/congrats_approved"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
        }

        "/insurtech/payments/px_checkout/congrats_approved/go_to_insurance"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
            action_description = "Administrar mis seguros"
        }

        "/insurtech/payments/px_checkout/congrats_approved/go_to_home"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
            action_description = "Ir al inicio"
        }

        "/insurtech/payments/px_checkout/congrats_rejected"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
        }

        "/insurtech/payments/px_checkout/congrats_rejected/go_to_home"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
            action_description = "Ir al inicio"
        }

        "/insurtech/payments/px_checkout/congrats_pending"(platform:"/mobile", type: TrackType.View) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
        }

        "/insurtech/payments/px_checkout/congrats_pending/go_to_home"(platform:"/mobile", type: TrackType.Event) {
            quote_id = "56202953-4195-432c-bb0b-8f204f8c97b1"
            flow = "RODA"
            preference_id = "555872442-f4ae3371-b640-45cc-9be8-6ei627f18f599"
            purchase_id = "1e149d2f-f6ff-4693-8e63-a85c12b32358"
            action_description = "Ir al inicio"
        }

        // INSURTECH Protections - my-fe
        "/insurtech/protections"(platform:"/mobile", type: TrackType.View) {}

        "/insurtech/protections/dataLoaded"(platform:"/mobile", type: TrackType.Event) {
            client_device = [
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
            claims = [
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
                has_claims: false,
                is_current_device_protected: false,
                is_current_device_quotable: false,
                offered: false
            ]
            garex = [
                has_protections: true,
                has_claims: false,
                offered: false
            ]
        }

        "/insurtech/protections/dataLoaded"(platform:"/mobile", type: TrackType.Event) {
            client_device = [
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
            claims = [
                [
                    product_id: "roda",
                    insurance_purchase_key: "roda-ABC123",
                ],
            ]
            roda = [
                has_protections: true,
                has_claims: false,
                is_current_device_protected: false,
                is_current_device_quotable: true,
                offered: true
            ]
            garex = [
                has_protections: false,
                has_claims: false,
                offered: false
            ]
        }

        "/insurtech/protections/dataLoaded"(platform:"/mobile", type: TrackType.Event) {
            client_device = [
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
            claims = [
                [
                    product_id: "garex",
                    insurance_purchase_key: "garex-ABC125",
                ]
            ]
            roda = [
                has_protections: false,
                has_claims: false,
                is_current_device_protected: false,
                is_current_device_quotable: true,
                offered: true
            ]
            garex = [
                has_protections: true,
                has_claims: false,
                offered: false
            ]
        }

        "/insurtech/protections/dataLoaded"(platform:"/web", type: TrackType.Event) {
            roda = [
                has_protections: false,
                has_claims: false,
                is_current_device_protected: false,
                is_current_device_quotable: false,
                offered: false
            ]
            garex = [
                has_protections: false,
                has_claims: false,
                offered: false
            ]
        }


        "/insurtech/protections/dataLoaded"(platform:"/web", type: TrackType.Event) {
            protections = [
                [
                    product_id: "roda",
                    insurance_purchase_key: "roda-ABC123",
                ],
            ]
            claims = [
                [
                    product_id: "roda",
                    insurance_purchase_key: "roda-ABC123",
                ],
            ]
            roda = [
                has_protections: true,
                has_claims: false,
                is_current_device_protected: false,
                is_current_device_quotable: false,
                offered: false
            ]
            garex = [
                has_protections: false,
                has_claims: false,
                offered: false
            ]
        }

        "/insurtech/protections/quote-me"(platform:"/mobile", type: TrackType.Event) {
            client_device = [
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
            client_device = [
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
            selected_faq = 2
        }

        "/insurtech/protections/tabs"(platform:"/mobile", type: TrackType.Event) {
            client_device = [
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
            tab_name = 'protections'
        }

        "/insurtech/protections/tabs"(platform:"/mobile", type: TrackType.Event) {
            client_device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            claims = [
                [
                    product_id: "garex",
                    insurance_purchase_key: "garex-ABC125",
                ]
            ]
            tab_name = 'losses'
        }

        "/insurtech/protections/error"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
        }

        "/insurtech/protections/error"(platform:"/web", type: TrackType.View) {
        }

        "/insurtech/protections/fallback"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
        }

        "/insurtech/protections/fallback"(platform:"/web", type: TrackType.View) {
        }

        "/insurtech/protections/finished"(platform:"/mobile", type: TrackType.View) {
            client_device = [
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

        // INSURTECH Protections Detail - my-detail-fe
        //RODA
        "/insurtech/protections/detail/roda"(platform:"/mobile", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: false,
                is_current_device_protection: false,
            ]
        }
        "/insurtech/protections/detail/roda"(platform:"/web", type: TrackType.View) {
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: false,
                is_current_device_protection: false,
            ]
        }

        "/insurtech/protections/detail/roda/begin_claim"(platform:"/web", type: TrackType.Event) {
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: false,
                is_current_device_protection: false,
            ]
        }

        "/insurtech/protections/detail/roda/download_policy"(platform:"/web", type: TrackType.Event) {
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: false,
                is_current_device_protection: false,
            ]
        }

        "/insurtech/protections/detail/roda/pay"(platform:"/web", type: TrackType.Event) {
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: false,
                is_current_device_protection: false,
            ]
            type = 'pending_payment'
        }

        "/insurtech/protections/detail/roda/recommendations"(platform:"/web", type: TrackType.Event) {
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: false,
                is_current_device_protection: false,
            ]
        }

        "/insurtech/protections/detail/roda/cancel"(platform:"/web", type: TrackType.Event) {
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: false,
                is_current_device_protection: false,
            ]
        }

        "/insurtech/protections/detail/roda/help"(platform:"/web", type: TrackType.Event) {
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: false,
                is_current_device_protection: false,
            ]
        }

         "/insurtech/protections/detail/roda/imei_help"(platform:"/web", type: TrackType.Event) {
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: false,
                is_current_device_protection: false,
            ]
        }

        "/insurtech/protections/detail/roda/imei_activation"(platform:"/", type: TrackType.Event) {
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: false,
                is_current_device_protection: false,
            ]
            is_imei_valid = true
            protection_status = 'pending_activation'
            days_taken_for_imei_activation = 5
            retries_number = 4
            modal_imei_retries = 2
        }

        "/insurtech/protections/detail/roda/change_protection"(platform:"/mobile", type: TrackType.Event) {
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: false,
                is_current_device_protection: false,
            ]
        }


        "/insurtech/protections/detail/roda/continue_kyc"(platform:"/mobile", type: TrackType.Event) {
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: false,
                is_current_device_protection: false,
            ]
        }

        "/insurtech/protections/detail/roda/feedback"(platform:"/", type: TrackType.Event) {
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: true,
                is_current_device_protection: true,
            ]
            claim = [
                id: "ABC125-DEEF",
                franchise_payment_id: 10021312312,
                franchise_payment_amount:  10.72,
                status_detail: "PENDING_SEND_PROVIDER"
            ]
        }


        "/insurtech/protections/detail/roda/payment_ticket_instructions"(platform:"/web", type: TrackType.View) {
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: false,
                is_current_device_protection: false,
            ]
            type = 'deductible'
        }

        "/insurtech/protections/detail/roda/claim_detail"(platform:"/web", type: TrackType.View) {
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: false,
                is_current_device_protection: false,
            ]
            claim = [
                id: "ABC125-DEEF",
                franchise_payment_id: 10021312312,
                franchise_payment_amount:  10.72,
            ]
        }

        "/insurtech/protections/detail/roda/claim_detail"(platform:"/web", type: TrackType.View) {
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: false,
                is_current_device_protection: false,
            ]
            claim = [
                id: "ABC125-DEEF",
            ]
        }

        "/insurtech/protections/detail/roda/claim_detail/insurer_response"(platform:"/web", type: TrackType.Event) {
            protection = [
                insurance_purchase_key: "roda-ABC125",
                amount_total: 100.72,
                amount_fee:  10.72,
                option_check: "total",
                option_coverage: "theft_break",
                deductible_amount: 10.72,
                has_open_claim: false,
                is_current_device_protection: false,
            ]
            claim = [
                id: "ABC125-DEEF",
                franchise_payment_id: 10021312312,
                franchise_payment_amount:  10.72,
            ]
        }

        "/insurtech/protections/detail/roda/phone_activation"(platform:"/web", type: TrackType.View) {}

        "/insurtech/protections/detail/roda/shipping_instructions"(platform:"/web", type: TrackType.View) {}

        "/insurtech/protections/detail/roda/error"(platform:"/web", type: TrackType.View) {
            client_device = [
                brand: "Samsung",
                model_code: "SM-J700M",
                size: "64GB",
            ]
        }
        "/insurtech/protections/detail/roda/error"(platform:"/web", type: TrackType.View) {}

        //GAREX
         "/insurtech/protections/detail/garex"(platform:"/", type: TrackType.View) {
             product_data =[
                entity_type:"quote",
                entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                product_type:"roda",
                product_id:"MLB_RD00000000000065134TEST"
            ]
        }
            "/insurtech/protections/detail/garex/use_service"(platform:"/", type: TrackType.Event) {
             product_data =[
                entity_type:"quote",
                entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                product_type:"roda",
                product_id:"MLB_RD00000000000065134TEST"
            ]
        }
               "/insurtech/protections/detail/garex/use_service_certificate"(platform:"/", type: TrackType.Event) {
             product_data =[
                entity_type:"quote",
                entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                product_type:"roda",
                product_id:"MLB_RD00000000000065134TEST"
            ]
        }
               "/insurtech/protections/detail/garex/cancel_protection"(platform:"/", type: TrackType.Event) {
             product_data =[
                entity_type:"quote",
                entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                product_type:"roda",
                product_id:"MLB_RD00000000000065134TEST"
            ]
        }
               "/insurtech/protections/detail/garex/help"(platform:"/", type: TrackType.Event) {
             product_data =[
                entity_type:"quote",
                entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                product_type:"roda",
                product_id:"MLB_RD00000000000065134TEST"
            ]
        }

        "/insurtech/protections/detail/garex/activities"(platform:"/", type: TrackType.Event) {
             product_data =[
                entity_type:"quote",
                entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                product_type:"roda",
                product_id:"MLB_RD00000000000065134TEST"
            ]
        }
        "/insurtech/protections/detail/garex/detail_payment"(platform:"/", type: TrackType.Event) {
             product_data =[
                entity_type:"quote",
                entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                product_type:"roda",
                product_id:"MLB_RD00000000000065134TEST"
            ]
        }

        //landing-fe
        "/insurtech/protections/landings_fe"(platform:"/", type: TrackType.View) {
           type = "desktop"
           os_name = "ios"
           os_version = "9"
           discount_type = "fixed"
           is_generic = false
           site = "MLB"
        }
        "/insurtech/protections/landings_fe/go_to_store"(platform:"/", type: TrackType.Event) {
            type = "desktop"
           os_name = "ios"
           os_version = "9"
           discount_type = "fixed"
           is_generic = false
           site = "MLB"
        }
        "/insurtech/protections/landings_fe/go_to_qpage"(platform:"/", type: TrackType.Event) {
            type = "desktop"
           os_name = "ios"
           os_version = "9"
           discount_type = "fixed"
           is_generic = false
           site = "MLB"
        }
    }

    ["mercadolibre", "mercadopago"].each { business ->
		defaultBusiness = business
        test("Insurtech - ${business} tests roda claims tacking ") {
            // INSURTECH Claims

            "/insurtech/protections/claims"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/cancel"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/execute"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/use_service"(platform:"/", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                ]
            }

            "/insurtech/protections/claims/use_service_certificate"(platform:"/web", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                ]
            }

            "/insurtech/protections/claims/use_service_not_certificate"(platform:"/", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                ]
            }

            "/insurtech/protections/claims/cancel_protection"(platform:"/", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                ]
            }

            "/insurtech/protections/claims/help"(platform:"/", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                ]
            }

            "/insurtech/protections/claims/read_certificate"(platform:"/", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                ]
            }

            "/insurtech/protections/claims/feedback"(platform:"/", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                ]
            }

            "/insurtech/protections/claims/need_help"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                ]
            }

            "/insurtech/protections/claims/need_help/select"(platform:"/", type: TrackType.Event) {
                help_id = '1234'
            }

            "/insurtech/protections/claims/cancel/reasons"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/cancel/reasons/select"(platform:"/", type: TrackType.Event) {
                reason_id = '1234'
            }

            "/insurtech/protections/claims/cancel/reasons/other"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/cancel/reasons/other/confirm"(platform:"/", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/cancel/review"(platform:"/", type: TrackType.View){
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/cancel/review/confirm"(platform:"/", type: TrackType.Event){
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/cancel/review/keep_protection"(platform:"/", type: TrackType.Event){
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/cancel/congrats"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
                type_congrats= 'success'
            }

            "/insurtech/protections/claims/cancel/congrats"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
                type_congrats= 'error'
            }
            "/insurtech/protections/claims/execute/item"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/execute/item/confirm"(platform:"/", type: TrackType.Event){
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/execute/description"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/execute/description/confirm"(platform:"/", type: TrackType.Event){
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/execute/questions"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/execute/questions/select_reasons"(platform:"/", type: TrackType.Event){
                reason_id='123123'
            }
            "/insurtech/protections/claims/execute/questions/select_police_report"(platform:"/", type: TrackType.Event){
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }
            "/insurtech/protections/claims/execute/questions/select_not_police_report"(platform:"/", type: TrackType.Event){
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }


            "/insurtech/protections/claims/execute/address"(platform:"/", type: TrackType.View){
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/execute/address/check"(platform:"/", type: TrackType.Event){
                address_id= 123123
            }
            "/insurtech/protections/claims/execute/address/confirm"(platform:"/", type: TrackType.Event){
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }


            "/insurtech/protections/claims/execute/imei_lock_code"(platform:"/", type: TrackType.View){
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }
            "/insurtech/protections/claims/execute/imei_lock_code/confirm"(platform:"/", type: TrackType.Event){
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/execute/review"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/execute/review/confirm"(platform:"/", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/execute/congrats"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
                type_congrats= 'success'
            }

            "/insurtech/protections/claims/execute/congrats"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
                type_congrats= 'success'
            }

            "/insurtech/protections/claims/execute/congrats/feedback"(platform:"/", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
                type_congrats= 'success'
            }

            "/insurtech/protections/claims/execute/certificate_update"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }
            "/insurtech/protections/claims/execute/certificate_update/confirm"(platform:"/", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/execute/franchise"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }
            "/insurtech/protections/claims/execute/franchise/confirm"(platform:"/", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }
            "/insurtech/protections/claims/execute/franchise/cancel"(platform:"/", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }
            "/insurtech/protections/claims/execute/help/police_report"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST",
                    insurance_purchase_key: "quote-d612d476-c1de-4fb2-a9bd-1e549c123456"
                ]
            }

            "/insurtech/protections/claims/execute/help/police_report/confirm"(platform:"/", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST",
                    insurance_purchase_key: "quote-d612d476-c1de-4fb2-a9bd-1e549c123456"
                ]
            }


            "/insurtech/protections/claims/execute/wipe_data"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/execute/wipe_data/confirm"(platform:"/", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/execute/document/request"(platform:"/", type: TrackType.View) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/execute/document/request/select_continue"(platform:"/", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            "/insurtech/protections/claims/execute/document/request/select_police_report"(platform:"/", type: TrackType.Event) {
                product_data =[
                    entity_type:"quote",
                    entity_id:"f834aea8-8be2-4b7c-ba0e-7b4d6b432d5a",
                    product_type:"roda",
                    product_id:"MLB_RD00000000000065134TEST"
                ]
            }

            // INSURTECH Webview
            "/insurtech/webview/generic-error"(platform:"/mobile", type: TrackType.Event) {
                deeplink = "mercadopago://insurtech/webview?url=https%3A%2F%2Fmercadopago.com.br%2Fprotections%2Froda%2Fqpage&toolbar=true"
                device = [
                    brand: "Samsung",
                    model: "J7",
                    model_code: "SM-J700M",
                    size: "64GB",
                ]
            }
        }
    }
}
