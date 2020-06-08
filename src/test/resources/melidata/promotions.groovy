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
                        score_prior: 0.7,
                        position_prior: 1,
                        posterior_score: 0.6,
                        position_posterior: 1,
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
                        accepts_mercadopago: true,
                        boosted: true,
                        model_version: "0.0.1",
                        position: 1,
                        created_date: "2019-10-07T17:51:21Z",
                        promotion_type: "TODAY_PROMOTION",
                        lightning_deal_configuration: [
                          end_date: "2020-01-29T19:00:00-06:00",
                          initial_stock: 64,
                          remaining_stock: 2,
                          start_date: "2020-01-29T11:00:00-06:00"
                        ],
                        deal_of_the_day_configuration: null,
                        dispatching_normally: true
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
                          discount: null,
                          has_loyalty_discount: false
                        ],
                        free_shipping: false,
                        official_store: null,
                        listing_type_id: "gold_special",
                        score: 0.89,
                        score_prior: 0.7,
                        position_prior: 1,
                        posterior_score: 0.6,
                        position_posterior: 1,
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
                        accepts_mercadopago: true,
                        alpha: 0.7,
                        beta: 0.5,
                        gamma: 0.6,
                        rebate: 1,
                        one_p: 0,
                        private_label: 1,
                        promotion_type: "DEAL_OF_THE_DAY",
                        lightning_deal_configuration: null,
                        deal_of_the_day_configuration: null
                      ],
                      [
                        id: "MLA611663126",
                        title: "Some other title", 
                        free_shipping: true,
                        fulfillment: false,
                        price: [
                          currency: "\$",
                          price: "2.414",
                          decimals: "55",
                          discount: null,
                          has_loyalty_discount: false
                        ],
                        free_shipping: false,
                        official_store: null,
                        listing_type_id: "gold_special",
                        score: 0.89,
                        score_prior: 0.7,
                        position_prior: 1,
                        posterior_score: 0.6,
                        position_posterior: 1,
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
                        accepts_mercadopago: true,
                        alpha: 0.7,
                        beta: 0.5,
                        gamma: 0.6,
                        rebate: 1,
                        one_p: 0,
                        private_label: 1,
                        promotion_type: "LIGHTNING_DEAL",
                        lightning_deal_configuration: null,
                        deal_of_the_day_configuration: null
                      ]
                    ]
            // algorithms = [scoring: "threshold", selection: "bci_v1", sorting: "max_10pct_l2"]
            page = [limit: 52, total: "200", offset: 0]
            selected_filters = [price: "0.0-2000.0"]
            origin = "scut"
            filter_applied = "price"
            filter_position = "3"
        }
 
        "/promotions"(platform:"/web/desktop", type: TrackType.Event, {
            general()
        })
    }

    //Promotions Android Landing
    test("Mobile Landing") {
        "/promotions/landing"(platform: "/mobile") {
            url = "https://www.mercadolibre.com.ar/ofertas"
            is_main_url = true
        }
    }
}
