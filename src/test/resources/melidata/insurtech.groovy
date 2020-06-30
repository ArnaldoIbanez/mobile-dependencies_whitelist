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
                    category: "total",
                    price: 123.33,
                    deductible: 30.44
                ],
                [
                    category: "screen",
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
                    category: "total",
                    price: 123.33,
                    deductible: 30.44
                ],
            ]
            financing_type = [
                no_interest_allowed : true,
                installments: 12
            ]
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
                category: "total",
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
                category: "total",
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
    }
}
