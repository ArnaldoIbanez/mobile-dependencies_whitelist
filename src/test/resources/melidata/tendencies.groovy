
package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    //Tendencies Landing
    test("Tendencies landing") {
        def general= {
            tendency_print_id = "fce4b1d0-cf45-11e9-8e9d-c5fad1dc1dc5"
            origin = "vip"
            tendency_type = "best_seller"
            items = [
                    [
                            id: "MLA611663121",
                            position: 1
                    ],
                    [
                            id: "MLA611663122",
                            position: 2
                    ],
                    [
                            id: "MLA611663126",
                            position: 3
                    ]
            ]
            selected_filters = [category_id: "MLA1055"]
        }

        "/tendencies"(platform:"/web/desktop", type: TrackType.Event, {
            general()
        })
    }
}
