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
                        deal_ids: [
                          "MLA1234",
                          "MLA1235",
                          "MLA1236"
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
                        dispatching_normally: true,
                        pos: 1
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
                        tags: [
                          "brand_verified",
                          "good_quality_picture",
                          "good_quality_thumbnail",
                          "loyalty_discount_eligible",
                          "immediate_payment",
                          "cart_eligible"
                        ],
                        deal_ids: [
                          "MLA2234",
                          "MLA2235",
                          "MLA2236"
                        ],
                        accepts_mercadopago: true,
                        rebate: 1,
                        one_p: 0,
                        private_label: 1,
                        promotion_type: "DEAL_OF_THE_DAY",
                        lightning_deal_configuration: null,
                        deal_of_the_day_configuration: null,
                        pos: 2
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
                        deal_ids: [
                          "MLA3234",
                          "MLA3235",
                          "MLA3236"
                        ],
                        warranty: "",
                        accepts_mercadopago: true,
                        rebate: 1,
                        one_p: 0,
                        private_label: 1,
                        promotion_type: "LIGHTNING_DEAL",
                        lightning_deal_configuration: null,
                        deal_of_the_day_configuration: null,
                        pos: 3
                      ]
                    ]
            // algorithms = [scoring: "threshold", selection: "bci_v1", sorting: "max_10pct_l2"]
            page = [limit: 52, total: "200", offset: 0]
            selected_filters = [price: "0.0-2000.0"] 
            origin = "scut"
            filter_applied = "price"
            filter_position = "3"
            displayed_shortcuts =[
              [
                filter: [
                  price: "0.0-2000.0"
                ],
                is_recommended_domain: false,
                position: 1
              ],
              [
                filter: [
                  domain_id: "MLA-SNEAKERS"
                ],
                is_recommended_domain: true,
                position: 2
              ]
            ]
            items_extra = [
              component_name: "offers_for_user",
              type_content: "domain_id",
              row: 4,
              items: [
                [
                  id: "MLA123",
                  title: "Notebook Hp Intel Core I3 4gb 1tb Pantalla 14 Hdmi Wifi Gtia Oficial",
                  image_id: "683598-MLA42907993112_072020",
                  image_src: "https://http2.mlstatic.com/D_683598-MLA42907993112_072020-T.jpg",
                  free_shipping: true,
                  fulfillment: false,
                  deal_ids: [
                          "MLA1234",
                          "MLA1235",
                          "MLA1236"
                  ],
                  link: [
                    url: "https://articulo.mercadolibre.com.ar/MLA-689581949-notebook-hp-intel-core-i3-4gb-1tb-pantalla"
                  ],
                  price: [
                    price: "68.999",
                    original_price: "106.649",
                    discount: 35,
                    currency: "\$",
                    decimals: "00",
                    has_loyalty_discount: false
                  ],
                  installments: [
                    quantity: 12,
                    amount: 9784.63,
                    no_interest: false,
                    currency_id: "ARS",
                    decimals: "63",
                    price: "9.784"
                  ]
                ]
              ]
            ]
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
