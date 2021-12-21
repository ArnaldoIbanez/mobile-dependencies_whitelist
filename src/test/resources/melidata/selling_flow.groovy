package src.test.resources.melidata
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"

    test("SELLING_FLOW views") {
        "/selling_flow/catalog/start"(platform: "/", type: TrackType.View) {
        flow_id='mplink'
        empty_state=true
    }
    }

    test("SELLING_FLOW events") {
        "/selling_flow/catalog/add_product"(platform: "/", type: TrackType.Event) {}
        "/selling_flow/catalog/edit_products"(platform: "/", type: TrackType.Event) {}

        //SEARCH
        "/selling_flow/catalog/search"(platform: "/", type: TrackType.Event) {}
        "/selling_flow/catalog/exit_search"(platform: "/", type: TrackType.Event) {}

        //ITEMS
        "/selling_flow/catalog/select_section"(platform: "/", type: TrackType.Event) {}
        "/selling_flow/catalog/select_item"(platform: "/", type: TrackType.Event) {}
        "/selling_flow/catalog/deselect_item"(platform: "/", type: TrackType.Event) {}
        "/selling_flow/catalog/continue_flow"(platform: "/", type: TrackType.Event) {}
    }
}
