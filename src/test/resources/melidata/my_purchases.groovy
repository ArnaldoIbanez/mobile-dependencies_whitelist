package src.test.resources.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

	defaultBusiness = "mercadolibre"

	//------------------------------------------------------------------------------------------------------------------------------------------------------
	// TRACKS MY PURCHASES STATUS
	//------------------------------------------------------------------------------------------------------------------------------------------------------

	test("My Purchases - Status Page") {

		def purchasesEventDataSet = {
			label = "faq_2"
			x_mc_request_id = "qwrqwr2-fa979tg-10hjcoi"
			vertical_case_id = "shipping"
			vertical_sub_case_id = "ready_to_ship_on_time"
		}

		def newPurchasesDataSet = {
			items = [
					[
							business: "mercadolibre",
							page_vertical: "CORE",
							domain: "MLM-SMARTPHONES",
							category_l1: "MLM1234",
							category_l2: "MLM568",
							listing_type: "gold_pro",
							item_id: "MLA12345678",
							quantity: 2,
							variation_id: 987298347,
							condition: "new"
					],
					[
							business: "mercadolibre",
							page_vertical: "CORE",
							domain: "MLM-SMARTPHONES",
							category_l1: "MLM1234",
							category_l2: "MLM568",
							category_l3: "MLM5444",
							category_l4: "MLM731",
							category_l5: "MLM0948",
							listing_type: "gold_pro",
							item_id: "MLA12345678",
							quantity: 2,
							condition: "new",
							product_id: "MLM5154108",
							deals: ["MLM1123", "MLM6534"]
					]
			]

			seller= [
					[
							id: 2,
							nickname: "Nombre del vendedor",
							messages_count: 0
					]
			]

			buyer= [
					[
							id: 12345,
							is_prime: "true"
					]
			]

			payments= [
					[
							payment_method_type: "credit_card",
							payment_method_id: "visa",
							payment_status: "approved",
							payment_status_detail: "success"
					]
			]

			shipping= [
					[
							shipping_method: "express",
							shipping_mode: "me2",
							logistic_type: "fulfillment",
							shipping_status: "ready_to_ship",
							shipping_sub_status: "ready_to_print"
					]
			]
			purchases_flow= "v2"
			purchase_status= "paid"
			checkout_flow= "order"
			garex= "no"
			vertical_case_id= "shipping"
			vertical_sub_case_id= "shipping_delivered_delivery_address"
			x_mc_request_id= "aaaaa-vvvvvv-cccc-ddd"
			purchase_id= 1234
			pack_id= 1234
			order_id= 1234
		}

		def newPurchasesDataFullSet = purchasesEventDataSet >> newPurchasesDataSet

		def repurchaseDataSet = {
			seller= [
					[
							messages_count: 0,
							nickname: "TETE9644122",
							id: 817130646
					],
					[
							messages_count: 0,
							nickname: "TETE9644122",
							id: 817130646
					],
					[
							messages_count: 0,
							nickname: "TETE9644122",
							id: 817130646
					],
					[
							messages_count: 0,
							nickname: "TETE9644122",
							id: 817130646
					],
					[
							messages_count: 0,
							nickname: "TETE9644122",
							id: 817130646
					],
					[
							messages_count: 0,
							nickname: "TETE9644122",
							id: 817130646
					]
			]
			garex= "no"
			shipping= [
					[
							shipping_mode: "me2",
							shipping_method: "standard",
							shipping_sub_status: "ready_to_print",
							logistic_type: "drop_off",
							shipping_status: "ready_to_ship"
					],
					[
							shipping_mode: "me2",
							shipping_method: "standard",
							shipping_sub_status: "ready_to_print",
							logistic_type: "drop_off",
							shipping_status: "ready_to_ship"
					],
					[
							shipping_mode: "me2",
							shipping_method: "standard",
							shipping_sub_status: "ready_to_print",
							logistic_type: "drop_off",
							shipping_status: "ready_to_ship"
					],
					[
							shipping_mode: "me2",
							shipping_method: "standard",
							shipping_sub_status: "ready_to_print",
							logistic_type: "drop_off",
							shipping_status: "ready_to_ship"
					],
					[
							shipping_mode: "me2",
							shipping_method: "standard",
							shipping_sub_status: "ready_to_print",
							logistic_type: "drop_off",
							shipping_status: "ready_to_ship"
					],
					[
							shipping_mode: "me2",
							shipping_method: "standard",
							shipping_sub_status: "ready_to_print",
							logistic_type: "drop_off",
							shipping_status: "ready_to_ship"
					]
			]
			purchases_flow= "v2"
			x_mc_request_id= ""
			purchase_status= "paid"
			payments= [
					[
							payment_method_type: "account_money",
							payment_method_id: "account_money",
							payment_status_detail: "accredited",
							payment_status: "approved"
					]
			]
			items= [
					[
							category_l3: "MLA438220",
							category_l4: "MLA1287",
							quantity: 18.0,
							business: "MARKETPLACE",
							item_id: "MLA1100871287",
							page_vertical: "CORE",
							listing_type: "gold_special",
							category_l1: "MLA1276",
							category_l2: "MLA1285",
							international_delivery_mode: "none",
							condition: "new",
							variation_id: 173566847391,
							domain: "MLA-FOOTBALL_BALLS",
							product_id: "MLA13994955"
					],
					[
							category_l3: "MLA438220",
							category_l4: "MLA1287",
							quantity: 18.0,
							business: "MARKETPLACE",
							item_id: "MLA1100871287",
							page_vertical: "CORE",
							listing_type: "gold_special",
							category_l1: "MLA1276",
							category_l2: "MLA1285",
							international_delivery_mode: "none",
							condition: "new",
							variation_id: 173566847391,
							domain: "MLA-FOOTBALL_BALLS",
							product_id: "MLA13994955"
					],
					[
							category_l3: "MLA438220",
							category_l4: "MLA1287",
							quantity: 18.0,
							business: "MARKETPLACE",
							item_id: "MLA1100871287",
							page_vertical: "CORE",
							listing_type: "gold_special",
							category_l1: "MLA1276",
							category_l2: "MLA1285",
							international_delivery_mode: "none",
							condition: "new",
							variation_id: 173566847391,
							domain: "MLA-FOOTBALL_BALLS",
							product_id: "MLA13994955"
					],
					[
							category_l3: "MLA438220",
							category_l4: "MLA1287",
							quantity: 18.0,
							business: "MARKETPLACE",
							item_id: "MLA1100871287",
							page_vertical: "CORE",
							listing_type: "gold_special",
							category_l1: "MLA1276",
							category_l2: "MLA1285",
							international_delivery_mode: "none",
							condition: "new",
							variation_id: 173566847391,
							domain: "MLA-FOOTBALL_BALLS",
							product_id: "MLA13994955"
					],
					[
							category_l3: "MLA438220",
							category_l4: "MLA1287",
							quantity: 10.0,
							business: "MARKETPLACE",
							item_id: "MLA1100871287",
							page_vertical: "CORE",
							listing_type: "gold_special",
							category_l1: "MLA1276",
							category_l2: "MLA1285",
							international_delivery_mode: "none",
							condition: "new",
							variation_id: 173566847391,
							domain: "MLA-FOOTBALL_BALLS",
							product_id: "MLA13994955"
					],
					[
							category_l3: "MLA438220",
							category_l4: "MLA1287",
							quantity: 18.0,
							business: "MARKETPLACE",
							item_id: "MLA1100871287",
							page_vertical: "CORE",
							listing_type: "gold_special",
							category_l1: "MLA1276",
							category_l2: "MLA1285",
							international_delivery_mode: "none",
							condition: "new",
							variation_id: 173566847391,
							domain: "MLA-FOOTBALL_BALLS",
							product_id: "MLA13994955"
					]
			]
			checkout_flow= "pack"
			buyer= [
					[
							id: 817129883,
							is_prime: "false"
					]
			]
		}

		//------------------------------------------------------------------------------------------------------------------------------------------------------
		// TEST TRACKS MY PURCHASES STATUS
		//------------------------------------------------------------------------------------------------------------------------------------------------------


		"/my_purchases/status"(platform: "/", type: TrackType.View) {
			newPurchasesDataSet()
		}

		"/my_purchases/status/show_action" (platform:"/", type: TrackType.Event) {
			newPurchasesDataFullSet()
		}

		"/my_purchases/status/show_help" (platform:"/", type: TrackType.Event) {
			newPurchasesDataFullSet()
		}

		"/my_purchases/status/show_faq" (platform:"/", type: TrackType.Event) {
			newPurchasesDataFullSet()
		}

		"/my_purchases/status/click_action" (platform:"/", type: TrackType.Event) {
			newPurchasesDataFullSet()
		}

		"/my_purchases/status/click_help" (platform:"/", type: TrackType.Event) {
			newPurchasesDataFullSet()
		}

		"/my_purchases/status/click_faq" (platform:"/", type: TrackType.Event) {
			newPurchasesDataFullSet()
		}

		"/my_purchases/status/click_view_item" (platform:"/", type: TrackType.Event) {
			newPurchasesDataFullSet()
		}

		"/my_purchases/status/click_view_messages" (platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		"/my_purchases/status/click_driver_messages" (platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		"/my_purchases/status/click_contact_us" (platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}


		//------------------------------------------------------------------------------------------------------------------------------------------------------
		// TEST TRACKS MY PURCHASES STATUS_DETAIL
		//------------------------------------------------------------------------------------------------------------------------------------------------------


		"/my_purchases/status_detail"(platform: "/", type: TrackType.View) {
			newPurchasesDataSet()
		}


		//------------------------------------------------------------------------------------------------------------------------------------------------------
		// TEST TRACKS MY PURCHASES STATUS ITEMS
		//------------------------------------------------------------------------------------------------------------------------------------------------------

		"/my_purchases/status/items" (platform:"/", type: TrackType.View) {
			newPurchasesDataSet()
		}

		"/my_purchases/status/items/click_view_item" (platform:"/", type: TrackType.Event) {
			newPurchasesDataFullSet()
		}


		//------------------------------------------------------------------------------------------------------------------------------------------------------
		// TEST TRACKS MY PURCHASES STATUS INSTRUCTIONS
		//------------------------------------------------------------------------------------------------------------------------------------------------------

		"/my_purchases/status/instructions" (platform:"/", type: TrackType.View) {
			newPurchasesDataSet()
		}

		"/my_purchases/status/instructions/click_view_item" (platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		"/my_purchases/status/instructions/click_action" (platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}


		//------------------------------------------------------------------------------------------------------------------------------------------------------
		// TEST TRACKS MY PURCHASES STATUS MESSAGES
		//------------------------------------------------------------------------------------------------------------------------------------------------------

		"/my_purchases/status/messages" (platform:"/", type: TrackType.View) {
			newPurchasesDataSet()
		}

		"/my_purchases/status/messages/click_view_messages" (platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}


		//------------------------------------------------------------------------------------------------------------------------------------------------------
		// TEST TRACKS MY PURCHASES STATUS MODALS
		//------------------------------------------------------------------------------------------------------------------------------------------------------

		"/my_purchases/status/return_purchase" (platform:"/", type: TrackType.View) {
			newPurchasesDataSet()
		}

		"/my_purchases/status/return_purchase/click_action" (platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		"/my_purchases/status/cancel_purchase" (platform:"/", type: TrackType.View) {
			newPurchasesDataSet()
		}

		"/my_purchases/status/cancel_purchase/click_action" (platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		//------------------------------------------------------------------------------------------------------------------------------------------------------
		// TEST TRACKS MY PURCHASES STATUS PLACES
		//------------------------------------------------------------------------------------------------------------------------------------------------------

		"/my_purchases/status/places" (platform:"/", type: TrackType.View) {
			newPurchasesDataSet()
		}

		"/my_purchases/status/places/show_action" (platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		"/my_purchases/status/places/click_action" (platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}


		//------------------------------------------------------------------------------------------------------------------------------------------------------
		// TEST TRACKS MY PURCHASES DETAIL
		//------------------------------------------------------------------------------------------------------------------------------------------------------


		"/my_purchases/detail"(platform: "/", type: TrackType.View) {
			newPurchasesDataSet()
		}

		"/my_purchases/detail/show_action" (platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		"/my_purchases/detail/click_action" (platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		"/my_purchases/detail/click_shipment_detail"(platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		"/my_purchases/detail/click_view_item"(platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		"/my_purchases/detail/click_download_invoice"(platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		"/my_purchases/detail/click_pack_link_modal"(platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		"/my_purchases/detail/click_go_to_insurance"(platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}
		"/my_purchases/detail/click_payment_link_modal"(platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		//------------------------------------------------------------------------------------------------------------------------------------------------------
		// TEST TRACKS MY PURCHASES REFUND DETAIL
		//------------------------------------------------------------------------------------------------------------------------------------------------------

		"/my_purchases/refund_detail"(platform:"/", type: TrackType.View) {
		}

		"/my_purchases/refund_detail/show_action"(platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		"/my_purchases/refund_detail/show_help"(platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		"/my_purchases/refund_detail/show_faq"(platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		"/my_purchases/refund_detail/click_action"(platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		"/my_purchases/refund_detail/click_help"(platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		"/my_purchases/refund_detail/click_faq"(platform:"/", type: TrackType.Event) {
			purchasesEventDataSet()
		}

		//------------------------------------------------------------------------------------------------------------------------------------------------------
		// TEST TRACKS MY PURCHASES LIST
		//------------------------------------------------------------------------------------------------------------------------------------------------------

		"/my_purchases/list"(platform:"/", type: TrackType.View) {
		}

		"/my_purchases/list/repurchase_action"(platform:"/", type: TrackType.Event) {
			repurchaseDataSet()
		}

		"/my_purchases/list/repurchase_drawing"(platform:"/", type:TrackType.View) {
		}
	}
}