package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadolibre"

    test("orders feed from commons tracker cards"){
        def defaultOrderinformation = {
            order_id = 99999999
            status = "paid"
            status_detail = ""
            total_amount = 100
            total_amount_with_shipping = 120
            is_carrito = true
            reservation = true
            subscription = true

            seller = [[ id: 135201044, nickname: "XXXXXX" ]]
            buyer = [ id: 75961818, nickname: "YYYYYY" ]

            shipping = [
                    cost: 20,
                    id : 21524852258,
                    shipping_mode : "me2",
                    shipping_option : [ id : 509341546, name : "Retiro en sucursal OCA", shipping_method_id : 501045]
            ]

            payments = [
                    [
                            id: 5672342343,
                            method: "rapipago",
                            type: "ticket",
                            installments: 1,
                            paid_amount: 60,
                            without_fee : true,
                            status: "approved",
                            status_detail: "accredited"
                    ],
                    [
                            id: 5672342344,
                            payment_method: "visa",
                            paymet_type: "credit_card",
                            installments: 3,
                            paid_amount: 60,
                            installment_amount: 20,
                            without_fee : true,
                            status: "approved",
                            status_detail: "accredited"
                    ],
            ]

            items = [
                    [
                            currency_id: "BRL",
                            item:[
                                    id: "MLB683236263",
                                    title: "Conector 12 Vias Baquelite - 1,5/6,0mm² - Caixa Com 10",
                                    variation_attributes: [],
                                    category_id: "MLB30216",
                                    variation_id: null ],
                            quantity: 1,
                            unit_price: 70
                    ]
            ]
        }

        "/orders/ordercreated" (platform:"/mobile/ios", type: TrackType.View,  ) {defaultOrderinformation()}
        "/orders/ordercreated" (platform:"/mobile/android", type: TrackType.View) {defaultOrderinformation()}
        "/orders/ordercreated" (platform:"/web/desktop", type: TrackType.View) {defaultOrderinformation()}
        "/orders/ordercreated" (platform:"/web/mobile", type: TrackType.View) {defaultOrderinformation()}

    }

    test("purchases feed from commons tracker"){


        def defaultPurchaseinformation = {
            purchase_id= 1000000015087185
            orders = [ "2523973546", "2523973553"]
            packs = ["2000000610762786", "2000000610762785"]
            
            status = "payment_required"
            status_detail = null
            total_amount = 101.36
            total_amount_with_shipping = 101.36
            total_amount_usd = 29.76
            total_amount_local = 101.36

            seller = [[ id: 135201044, nickname: "XXXXXX" ]]
            buyer = [ id: 156492602, nickname: "YYYYYY" ]

            shipping = [
                    "id":21524852258,
                    "shipping_option":["id":27577997,"shipping_method_id":100009],
                    "cost":0
            ]

            payments = [

            ]
            
            orders = ['1234', '12345521']

            items = [
                    [
                            
                            currency_id: "BRL",
                            item:[
                                    id:"MLB927524306",
                                    review_rate:4.3,
                                    differential_pricing_id:null,
                                    seller_custom_field:"E010005",
                                    condition:"new",
                                    deal_ids:[],
                                    category_path:"[MLB1574,MLB1582,MLB8462,MLB189197,MLB202366,MLB249938]",
                                    listing_type_id:"gold_special",
                                    buying_mode:"buy_it_now",
                                    category_id:"MLB249938",
                                    sale_fee:"1.17",
                                    warranty:null
                             ],
                            quantity: 1,
                            unit_price: 10.68,
                            unit_price_usd:3.14
                    ],
                    [
                            unit_price_usd:4.19,
                            currency_id:"BRL",
                            item:[
                                    id:"MLB975827202",
                                    review_rate:5,
                                    differential_pricing_id:null,
                                    seller_custom_field:"B020012",
                                    condition:"new",
                                    deal_ids:[],
                                    category_path:"[MLB1246,MLB264787,MLB264776,MLB264786]",
                                    listing_type_id:"gold_special",
                                    buying_mode:"buy_it_now",
                                    category_id:"MLB264786",
                                    sale_fee:1.57,
                                    warranty:null],
                            quantity:4,
                            unit_price:14.28
                    ],
                    [
                            unit_price_usd:2.46,
                            currency_id:"BRL",
                            item:[
                                    review_rate:3.5,
                                    condition:"new",
                                    listing_type_id:"gold_pro",
                                    category_id:"MLB264139",
                                    sale_fee:1.34,
                                    id:"MLB911621845",
                                    differential_pricing_id:"31499179",
                                    seller_custom_field:"A050013",
                                    deal_ids:[],
                                    category_path:"[MLB1051,MLB3813,MLB5098,MLB264139]",
                                    buying_mode:"buy_it_now",
                                    variation_id:17759774167,
                                    warranty:null
                            ],
                            quantity:2,
                            unit_price:8.39
                    ]
            ]
        }

        "/purchases/purchasecreated" (platform:"/mobile/ios", type: TrackType.View) {defaultPurchaseinformation()}
        "/purchases/purchasecreated" (platform:"/mobile/android", type: TrackType.View) {defaultPurchaseinformation()}
        "/purchases/purchasecreated" (platform:"/web/desktop", type: TrackType.View) {defaultPurchaseinformation()}
        "/purchases/purchasecreated" (platform:"/web/mobile", type: TrackType.View) {defaultPurchaseinformation()}

    }



}
