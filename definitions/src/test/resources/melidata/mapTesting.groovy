import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    test("Map testing") {
        "/mapTesting"(platform: "/", type: TrackType.View) {
            recommended_item = [
                    item_id : "321421",
                    price: 200,
                    shipping: ["Argentina", "Brasil", "Mexico"]
            ]

            purchased_item = [
                    item : [item_id: "432321", price: 200, shipping: ["Argentina", "Brasil", "Mexico"]],
                    quantity: 200
            ]

        }

        "/mapTesting/subdir"(platform: "/", type: TrackType.View) {
            recommended_item = [
                    item_id : "321421",
                    price: "200",
                    shipping: ["Argentina", "Brasil", "Mexico"]
            ]

            purchased_item = [
                    item : [item_id: "432321", price: 200, shipping: ["Argentina", "Brasil", "Mexico"]],
                    quantity: 200
            ]

        }

        "/mapTesting/websubdir"(platform: "/web", type: TrackType.View) {
            recommended_item = [
                    item_id : "321421",
                    price: "200",
                    shipping: ["Argentina", "Brasil", "Mexico"]
            ]

            purchased_item = [
                    item : [item_id: "432321", price: 200, shipping: ["Argentina", "Brasil", "Mexico"]],
                    quantity: 200
            ]
        }

        "/mapManual"(platform: "/", type: TrackType.View) {
            item_id = "321421"
            price = 200
            shipping = ["Argentina", "Brasil", "Mexico"]
        }
    }
}
