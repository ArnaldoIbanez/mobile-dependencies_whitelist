package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    //Promotions Landing
    test("Promotions landing") {
        def general= {
            deal_print_id = "fce4b1d0-cf45-11e9-8e9d-c5fad1dc1dc5"
            items = [
                      [
                        id: "MLA611663121",
                        title: "Some item title", 
                        free_shipping: true,
                        fulfillment: false,
                        price: [
                          currency: "\$",
                          price: "1.414",
                          decimals: "55",
                          original_price: "1.489",
                          discount: 5,
                          has_loyalty_discount: false
                        ],
                        free_shipping: false,
                        official_store: null,
                        listing_type_id: "gold_special",
                        score: 0.89,
                        benefit: 0.05,
                        credibility: 1,
                        interest: 0.98,
                        logistic_type: "xd_drop_off",
                        sold_quantity: 15,
                        available_quantity: 62,
                        health: 0.75,
                        tags: [
                          "brand_verified",
                          "good_quality_picture",
                          "good_quality_thumbnail",
                          "loyalty_discount_eligible",
                          "immediate_payment",
                          "cart_eligible"
                        ],
                        warranty: "",
                        accepts_mercadopago: true
                      ], 
                      [
                        id: "MLA611663122",
                        title: "Some other title", 
                        free_shipping: true,
                        fulfillment: false,
                        price: [
                          currency: "\$",
                          price: "2.414",
                          decimals: "55",
                          original_price: "1.489",
                          discount: 5,
                          has_loyalty_discount: false
                        ],
                        free_shipping: false,
                        official_store: null,
                        listing_type_id: "gold_special",
                        score: 0.89,
                        benefit: 0.05,
                        credibility: 1,
                        interest: 0.98,
                        logistic_type: "xd_drop_off",
                        sold_quantity: 15,
                        available_quantity: 62,
                        health: 0.75,
                        tags: [
                          "brand_verified",
                          "good_quality_picture",
                          "good_quality_thumbnail",
                          "loyalty_discount_eligible",
                          "immediate_payment",
                          "cart_eligible"
                        ],
                        warranty: "",
                        accepts_mercadopago: true
                      ]
                    ]
            // algorithms = [scoring: "threshold", selection: "bci_v1", sorting: "max_10pct_l2"]
            page = [limit: 52, total: 200, offset: 0]
        }
 
        "/promotions"(platform:"/web/desktop", type: TrackType.Event, {
            general()
        })
    }
}
