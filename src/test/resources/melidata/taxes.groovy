package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Taxes Collected At Source (Percepciones Impositivas)") {
        "/taxes/collected_at_source"(platform: "/") {}
    }

    test("User Tax File (Legajo Eletronico Unico)") {
        "/taxes/user_tax_file"(platform: "/") {}
    }
}
