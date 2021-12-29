package melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    test("Price suggestion result") {
        "/vis/supply/price_suggestion/bands"(platform: "/", type: TrackType.Event) {
            app_name = "update-desktop"
            client_id = "3282472529718136"
            item_id = "MLA1106939454"
            attributes = [
                    [attribute_id: "BRAND", attribute_value: "Chevrolet", attribute_name: "Marca"],
                    [attribute_id: "MODEL", attribute_value: "Onix", attribute_name: "Modelo"],
                    [attribute_id: "TRIM", attribute_value: "1.0 Turbo Premier Ii At", attribute_name: "Version"]
            ]
            prices_bands = [lower_band: 1500000, lower_limit: 1000000, upper_band: 3500000, upper_limit: 4000000,
                            estimated_price: 2500000]
            price = 2500000
        }
    }
}
