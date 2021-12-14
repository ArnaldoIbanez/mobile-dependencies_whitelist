package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Taxes Collected At Source (Percepciones Impositivas)") {
        "/taxes/collected_at_source"(platform: "/", type:TrackType.View) {}
    }

    test("User Tax File (Legajo Eletronico Unico)") {
        "/taxes/user_tax_file"(platform: "/", type:TrackType.View) {}
    }

    test("Taxes Collected At Source (Percepciones Impositivas)") {
        "/taxes/collected_at_source"(platform: "/", type:TrackType.View, business:"mercadopago") {}
    }

    test("User Tax File (Legajo Eletronico Unico)") {
        "/taxes/user_tax_file"(platform: "/", type:TrackType.View, business:"mercadopago") {}
    }
}
