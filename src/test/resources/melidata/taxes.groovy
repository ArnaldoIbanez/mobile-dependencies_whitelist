package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Taxes Collected At Source (Percepciones Impositivas)") {
        "/taxes/collected-at-source"(platform: "/") {}
    }

    test("User Tax File (Legajo Eletronico Unico)") {
        "/billing/summary"(platform: "/") {}
    }
}
