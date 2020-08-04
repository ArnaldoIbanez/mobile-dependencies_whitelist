package src.test.resources.melidata
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"

    test("PDV views") {
        //Onboarding
        "/pdv/onboarding/start"(platform: "/", type: TrackType.View) {}
        "/pdv/onboarding/store_setup"(platform: "/", type: TrackType.View) {}
        "/pdv/onboarding/pos_setup"(platform: "/", type: TrackType.View) {}

        //Catalog - Product
        "/pdv/product/list"(platform: "/", type: TrackType.View) {}
        "/pdv/product/creation"(platform: "/", type: TrackType.View) {}
        "/pdv/product/edition"(platform: "/", type: TrackType.View) {}

        //Catalog - Category
        "/pdv/category/list"(platform: "/", type: TrackType.View) {}
        "/pdv/category/creation"(platform: "/", type: TrackType.View) {}
        "/pdv/category/edition"(platform: "/", type: TrackType.View) {}
    }

    test("PDV events") {
        //Onboarding
        "/pdv/onboarding/init_onboarding"(platform: "/", type: TrackType.Event) {}
        "/pdv/onboarding/create_store"(platform: "/", type: TrackType.Event) {}
        "/pdv/onboarding/pos_management"(platform: "/", type: TrackType.Event) {
            pos_management=true
            cash_management=true
            external_payments=true
        }
        "/pdv/onboarding/end"(platform: "/", type: TrackType.Event) {
            path="/collections/setup/onboarding"
        }
        "/pdv/onboarding/link"(platform: "/", type: TrackType.Event) {}
        "/pdv/onboarding/unlink"(platform: "/", type: TrackType.Event) {}
        "/pdv/onboarding/buy_pos"(platform: "/", type: TrackType.Event) {}
        "/pdv/onboarding/register"(platform: "/", type: TrackType.Event) {}

        //Catalog - Product
        "/pdv/product/search"(platform: "/", type: TrackType.Event) {
            key="cocacola"
            category_id="12345"
        }
        "/pdv/product/creation/done"(platform: "/", type: TrackType.Event) {
            has_image=true
            has_category=true
            has_variants=true
        }
        "/pdv/product/edition/done"(platform: "/", type: TrackType.Event) {
            has_image=true
            has_category=true
            has_variants=true
        }
        "/pdv/product/delete/start"(platform: "/", type: TrackType.Event) {}
        "/pdv/product/delete/end"(platform: "/", type: TrackType.Event) {
            catalog_context="/pdv/product/list"
        }
        "/pdv/product/edit_category/start"(platform: "/", type: TrackType.Event) {}
        "/pdv/product/edit_category/end"(platform: "/", type: TrackType.Event) {}
        "/pdv/product/discount/start"(platform: "/", type: TrackType.Event) {}
        "/pdv/product/discount/end"(platform: "/", type: TrackType.Event) {}

        //Catalog - Category
        "/pdv/category/creation/done"(platform: "/", type: TrackType.Event) {
            category_products=1
        }
        "/pdv/category/edition/done"(platform: "/", type: TrackType.Event) {
            category_products=1
        }
        "/pdv/category/delete/start"(platform: "/", type: TrackType.Event) {}
        "/pdv/category/delete/end"(platform: "/", type: TrackType.Event) {
            catalog_context="/pdv/category/edition"
        }
    }
}
