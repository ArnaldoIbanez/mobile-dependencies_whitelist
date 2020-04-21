package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test('Insurtech - test garex tacking on checkout') {

        "/garex/checkout"(platform:"/web", type: TrackType.View) {}
        "/garex/checkout/more_info"(platform:"/web", type: TrackType.Event) {}
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
                "domain_id": "MLA-TELEVISIONS",
                "category_path": [ 'MLA1055', 'MLA1055'],
                "financing_type": [
                    "no_interest_allowed" : true,
                    "installments": 12
                ]
            ]

        }
        "/garex/checkout/not_selected_garex"(platform:"/web", type: TrackType.Event) {}

        //Mobile
        "/garex/checkout"(platform:"/mobile", type: TrackType.View) {}
        "/garex/checkout/more_info"(platform:"/mobile", type: TrackType.Event) {}
        "/garex/checkout/selected_garex"(platform:"/mobile", type: TrackType.Event) {
            "id": "MLA390289_GAR16001",
            "period": 24,
            "cost": 1234,
            "revenue_share_fee": 70,
            "revenue": 863.80,
            "currency_id": "ARS"
        }
        "/garex/checkout/not_selected_garex"(platform:"/web", type: TrackType.Event) {}
        "/garex/checkout/delete"(platform:"/mobile", type: TrackType.Event) {
            "id": "MLA390289_GAR16001",
            "cost": 1234,
            "currency_id": "ARS"
        }
    }
}
