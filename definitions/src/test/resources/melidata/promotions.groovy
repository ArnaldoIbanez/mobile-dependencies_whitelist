package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    //Promotions Landing
    test("Promotions landing") {
        def general= {
            origin = "deals_page"
            deal_print_id = "fce4b1d0-cf45-11e9-8e9d-c5fad1dc1dc5"
            items = [
                      [id: "MLA611663121", title: "Some item title", free_shipping: true], 
                      [id: "MLA611663122", title: "Another item title"]
                    ]
            algorithms = [scoring: "threshold", selection: "bci_v1", sorting: "max_10pct_l2"]
            page = [limit: 52, total: 200, offset: 0]
        }

        "/promotions"(platform:"/web/desktop", type: TrackType.Event, {
            general()
        })
    }
}