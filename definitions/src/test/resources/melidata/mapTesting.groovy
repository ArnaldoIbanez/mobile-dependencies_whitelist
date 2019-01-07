import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    test("Map testing") {

        "/mapTestingIterated"(platform: "/", type: TrackType.View) {
            recommendeds_item = [[
                    item_id : "321420",
                    price   : 200,
                    shipping: ["Argentina", "Brasil", "Mexico"],
                    currency: "USD",
                    op_id   : 1,
                    stars   : 4
            ],[
                    item_id : "321421",
                    price   : 200,
                    shipping: ["Argentina", "Brasil", "Mexico"],
                    currency: "USD",
                    op_id   : 1,
                    stars   : 4
            ],[
                    item_id : "321422",
                    price   : 200,
                    shipping: ["Argentina", "Brasil", "Mexico"],
                    currency: "USD",
                    op_id   : 1,
                    stars   : 4,
            ],[
                    item_id : "321423",
                    price   : 200,
                    shipping: ["Argentina", "Brasil", "Mexico"],
                    currency: "USD",
                    op_id   : 1,
                    stars   : 4
            ]]
        }

        "/mapTesting"(platform: "/", type: TrackType.View) {
            recommended_item = [
                    item_id : "321424",
                    price: 200,
                    shipping: ["Argentina", "Brasil", "Mexico"],
                    currency: "USD",
                    op_id: 1,
                    stars: 4
            ]

            purchased_item = [
                    item : [item_id: "432325", price: 200, shipping: ["Argentina", "Brasil", "Mexico"], currency: "USD", op_id: 1, stars: 5, opinion : "hello"],
                    quantity: 200
            ]

        }

        "/mapTesting/subdir"(platform: "/", type: TrackType.View) {
            recommended_item = [
                    item_id : "321426",
                    price: 200,
                    shipping: ["Argentina", "Brasil", "Mexico"],
                    currency: "USD",
                    op_id: 1,
                    stars: 4
            ]

            purchased_item = [
                    item : [item_id: "432327", price: 200, shipping: ["Argentina", "Brasil", "Mexico"], currency: "USD", op_id: 1, stars: 5],
                    quantity: 200
            ]

        }

        "/mapTesting/websubdir"(platform: "/web", type: TrackType.View) {
            recommended_item = [
                    item_id : "321428",
                    price: 200,
                    shipping: ["Argentina", "Brasil", "Mexico"],
                    currency: "USD",
                    op_id: 1,
                    stars: 4
            ]

            purchased_item = [
                    item : [item_id: "432329", price: 200, shipping: ["Argentina", "Brasil", "Mexico"], currency: "USD", op_id: 1, stars: 5],
                    quantity: 200
            ]
        }

        "/mapManual"(platform: "/", type: TrackType.View) {
            item_id = "321430"
            price = 200
            shipping = ["Argentina", "Brasil", "Mexico"]
        }
    }
}
