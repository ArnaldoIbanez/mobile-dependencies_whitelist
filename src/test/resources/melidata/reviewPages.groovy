package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    test("Traffic from reviewpages") {
        "/products-review-page"(platform: "/") {
            search_query = "nikon"
        }
    }
    test("Event from reviewpages") {
        "/products-review-page/link"(platform: "/") {
            search_query = "nikon"
            product_url = "https://www.mercadolivre.com.br/nikon-coolpix-p1000-compacta-avancada-cor-preto/p/MLB12715439"
        }
    }
}