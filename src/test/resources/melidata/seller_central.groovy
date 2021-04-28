package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  defaultBusiness = "mercadolibre"

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central Listing
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("seller central listing main page") {
    "/seller_central/listings/list"(platform: "/", type: TrackType.View) {}
  }

  test("seller central listing differents tabs") {
    "/seller_central/listings/list/promos"(platform: "/", type: TrackType.Event) {}
  }

  test("seller central listing item_description") {
    "/seller_central/listings/list/item_description"(platform: "/", type: TrackType.Event) {}
  }

  test("seller central listing health") {
    "/seller_central/listings/list/health"(platform: "/", type: TrackType.Event) {
      health_id = "ID"
    }
  }

  test("seller central listing moderation") {
    "/seller_central/listings/list/moderation"(platform: "/", type: TrackType.Event) {
      moderation_id = "ID"
    }
  }

  test("seller central listing action") {
    "/seller_central/listings/action"(platform: "/", type: TrackType.Event) {
      action_id = "MODIFY"
    }
  }

  test("seller central listing action") {
    "/seller_central/listings/action/confirm"(platform: "/", type: TrackType.Event) {
      action_id = "MODIFY"
    }
  }

  test("seller central listing massive action") {
    "/seller_central/listings/massive_action"(platform: "/", type: TrackType.Event) {
      action_id = "MAKE_WITHDRAWAL"
      view_id = "aging"
      count = 10
    }
  }

  test("seller central listing secondary_actions") {
    "/seller_central/listings/list/secondary_actions"(platform: "/", type: TrackType.Event) {}
  }

  test("seller central hunting actions") {
      "/seller_central/listings/hunting/change_step"(platform: "/", type: TrackType.Event) {
          view_id = "fulfillment"
      }
      "/seller_central/listings/hunting/view_more"(platform: "/", type: TrackType.Event) {
          view_id = "fulfillment"
      }
      "/seller_central/listings/hunting/sell_with_full"(platform: "/", type: TrackType.Event) {
          view_id = "fulfillment"
      }
  }

  test("seller central listing filters view") {
    "/seller_central/listings/filters"(platform: "/mobile", type: TrackType.View) {}
  }

  test("seller central listing filters view") {
    "/seller_central/listings/filters/applied"(platform: "/", type: TrackType.Event) {
      checkedFilters = ["inactive", "premium"]
    }
  }

  test("seller central listing filters actions and search") {
    "/seller_central/listings/filters/action"(platform: "/", type: TrackType.Event) {
      action = "apply"
    }
    "/seller_central/listings/filters/action"(platform: "/", type: TrackType.Event) {
      action = "clear"
    }
    "/seller_central/listings/filters/action"(platform: "/", type: TrackType.Event) {
      action = "apply"
      checked_filters = ["WITH_FULFILLMENT_WITHOUT_STOCK", "WITH_FULFILLMENT_LOW_STOCK"]
    }

    "/seller_central/listings/search"(platform: "/", type: TrackType.Event) {}
  }



  test("seller central listing onboarding view mobile") {
    "/seller_central/listings/onboarding"(platform: "/mobile", type: TrackType.View) {}
  }

  test("seller central listing onboarding view desktop") {
    "/seller_central/listings/onboarding"(platform: "/", type: TrackType.View) {}
  }

  test("seller central listing onboarding actions") {
    "/seller_central/listings/onboarding/action"(platform: "/", type: TrackType.Event) {
      action = "close"
    }
    "/seller_central/listings/onboarding/action"(platform: "/", type: TrackType.Event) {
      action = "dismiss"
      viewId = "inventario"
    }
    "/seller_central/listings/onboarding/action"(platform: "/", type: TrackType.Event) {
      action = "start"
      page = 1
    }
  }

  test("seller central listing onboarding pdp") {
    "/seller_central/listings/onboarding/pdp"(platform: "/", type: TrackType.View) {}
  }

  test("seller central listing onboarding pdp action") {
    "/seller_central/listings/onboarding/pdp/action"(platform: "/", type: TrackType.Event) {
      action = "accept"
    }
    "/seller_central/listings/onboarding/pdp/action"(platform: "/", type: TrackType.Event) {
      action = "cancel"
    }
  }

  test("seller central listing communications") {
    "/seller_central/listings/communication"(platform: "/", type: TrackType.Event) {
      type = "news"
    }
    "/seller_central/listings/communication"(platform: "/", type: TrackType.Event) {
      type = "task"
      id = "MODIFY"
      action = "show"
    }
    "/seller_central/listings/communication"(platform: "/", type: TrackType.Event) {
      type = "task"
      id = "LOW_HEALTH"
      action = "edit"
    }
    "/seller_central/listings/communication/more_info"(platform: "/mobile", type: TrackType.Event) {
      type = "news"
    }
    "/seller_central/listings/communication/go"(platform: "/", type: TrackType.Event) {
      type = "news"
      id = "1"
      action = "click"
    }
    "/seller_central/listings/communication/hide"(platform: "/", type: TrackType.Event) {
      type = "news"
      id = "1"
      action = "click"
    }
  }

  test("seller central list to bulk editor") {
    "/seller_central/listings/editor"(platform: "/", type: TrackType.Event) {}
  }

  test("seller central show help me modal") {
    "/seller_central/listings/helpme"(platform: "/", type: TrackType.Event) {}
  }

  test("seller central listing preferences") {
    "/seller_central/listings/preferences"(platform: "/", type: TrackType.Event) {
      id = "shipping"
    }
  }

  test("seller central listing inventory moderation remedy") {
    "/seller_central/listings/inventory_status/remedy"(platform: "/", type: TrackType.Event) {
      id = "reactivate"
    }
  }

  test("seller central listing quantity +info") {
    "/seller_central/listings/quantity/info"(platform: "/", type: TrackType.Event) {}
  }

  test("Seller central banner go, hide, show") {
    "/seller_central/listings/go"(platform: "/", type: TrackType.Event) {
      placement = "publicidad_banner"
    }
    "/seller_central/listings/hide"(platform: "/", type: TrackType.Event) {
      placement = "publicidad_banner"
    }
    "/seller_central/listings/show"(platform: "/", type: TrackType.View) {
      placement = "publicidad_banner"
    }
  }

  test("seller central advertising") {
    "/seller_central/listings/communication/advertising"(platform: "/", type: TrackType.Event) {
      action = "show"
      id = "PADS_SADS_RECO"
      type = "task"
    }
  }

  test("seller central advertising landing") {
    "/seller_central/listings/advertising_sll_landing"(platform: "/", type: TrackType.View) {
      sll_total = 12
      campaign_id = "65555"
    }
  }

  test("seller central advertising click") {
    "/seller_central/listings/communication/advertising_click"(platform: "/", type: TrackType.Event) {
      action = "show"
      id = "PADS_SADS_RECO"
      type = "task"
    }
  }

  test("Advertising manager SLL") {
    "/seller_central/listings/advertising_sll_landing/activated"(platform: "/", type: TrackType.View) {
      campaign_id = "2222222"
      sll_total = "10"
    }

    "/seller_central/listings/communication/advertising/sll_landing/activated"(platform: "/", type: TrackType.Event) {
      campaign_id = "2222222"
      sll_total_activated = "10"
      sll_total = "10"
    }

    "/seller_central/listings/communication/advertising/sll_landing/breadcrum"(platform: "/", type: TrackType.Event) {
      campaign_id = "2222222"
      sll_total_activated = "10"
      sll_total = "10"
    }

    "/seller_central/listings/communication/advertising/sll_landing/tooltip"(platform: "/", type: TrackType.Event) {
      campaign_id = "2222222"
      sll_total_activated = "10"
      sll_total = "10"
    }
  }


  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central Central of News
  //------------------------------------------------------------------------------------------------------------------------------------------------------
  test("Seller central Central of News view") {
    "/seller_central/news"(platform: "/web", type: TrackType.View) {}
  }
  test("Seller central Central of News events") {
    "/seller_central/news/filter"(platform: "/web", type: TrackType.Event) {}
    "/seller_central/news/filter/primary"(platform: "/web", type: TrackType.Event) {}
    "/seller_central/news/filter/secondary"(platform: "/web", type: TrackType.Event) {}
    "/seller_central/news/tag"(platform: "/web", type: TrackType.Event) {
      tag = "FULL"
    }
    "/seller_central/news/expand"(platform: "/web", type: TrackType.Event) {
      notice_id = "2426"
      category = "NEW"
      sub_category = "CHANGE_IN_BUSINESS_RULES"
    }
    "/seller_central/news/primary"(platform: "/web", type: TrackType.Event) {
      notice_id = "2426"
      category = "NEW"
      sub_category = "CHANGE_IN_BUSINESS_RULES"
    }
    "/seller_central/news/secondary"(platform: "/web", type: TrackType.Event) {
      notice_id = "2426"
      category = "NEW"
      sub_category = "CHANGE_IN_BUSINESS_RULES"
    }
    "/seller_central/news/keep"(platform: "/web", type: TrackType.Event) {
      notice_id = "2426"
    }
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central Summary
  //------------------------------------------------------------------------------------------------------------------------------------------------------
  test("Seller central summary view") {
    "/seller_central/summary"(platform: "/web", type: TrackType.View) {}
  }

  test("Seller central summary view_mobile") {
    "/seller_central/summary"(platform: "/mobile", type: TrackType.View) {}
  }

  test("Seller central summary module") {
    "/seller_central/summary/modules_render"(platform: "/web", type: TrackType.Event) {
      modules = [
              [
                module_id: "sellerStatus",
                kind: "fallback"
              ], [
                module_id: "mercadoPago",
                kind: "normal"
              ]
      ]
      seller_experience = "ADVANCED"
    }
  }

  test("Seller central summary module_mobile") {
    "/seller_central/summary/modules_render"(platform: "/mobile", type: TrackType.Event) {
      modules = [
              [
                module_id: "publicityCard",
                kind: "normal"
              ], [
                module_id: "coronaNoticeCard",
                kind: "normal"
              ]
      ]
      seller_experience = "NEWBIE"
    }
  }

  test("Seller central summary pads show") {
    "/seller_central/summary/show_advertising"(platform: "/web", type: TrackType.View) {
      placement = "publicidad_banner"
      adv_segmentation = "winback"
      reputation_level="1_red"
      seller_experience = "ADVANCED"
    }
  }

  test("Seller central summary pads advertising click") {
    "/seller_central/summary/go_advertising"(platform: "/web", type: TrackType.Event) {
      placement = "publicidad_banner"
      adv_segmentation = "winback"
      reputation_level="1_red"
      seller_experience = "ADVANCED"
    }
  }

  test("Seller central summary notice click") {
    "/seller_central/summary/notice"(platform: "/web", type: TrackType.Event) {
      goal = "best_price"
      seller_experience = "ADVANCED"
    }
  }

  test("Seller central summary task click") {
    "/seller_central/summary/task"(platform: "/web", type: TrackType.Event) {
      module_id = "listing"
      task_id = "BEST_PRICE_ELIGIBLE"
      seller_experience = "ADVANCED"
    }
   }

  test("Seller central summary task click") {
    "/seller_central/summary/task"(platform: "/mobile", type: TrackType.Event) {
      module_id = "publicationsTasksCard"
      task_id = "CATALOG_PRIORITY"
      seller_experience = "ADVANCED"
    }
  }

  // Seller coach

  test("Seller coach card click") {
    "/seller_central/seller_coach/summary/card_click"(platform: "/web", type: TrackType.Event) {
      segment = "perfect_launch"
      power_seller_status = "4_light_green"
      reputation = "4_light_green"
      card = [
        type: "RECOMMENDATION",
        key: "LIGHTNING_OFFER"
      ]
      seller_experience = "ADVANCED"
    }
  }

  test("Seller coach card dismiss") {
    "/seller_central/seller_coach/summary/card_dismiss"(platform: "/web", type: TrackType.Event) {
      segment = "perfect_launch"
      power_seller_status = "4_light_green"
      reputation = "4_light_green"
      card = [
        type: "RECOMMENDATION",
        key: "LIGHTNING_OFFER"
      ]
      seller_experience = "ADVANCED"
    }
  }

  test("Seller coach cards view") {
    "/seller_central/seller_coach/summary/cards_view"(platform: "/web", type: TrackType.View) {
      segment = "perfect_launch"
      power_seller_status = "4_light_green"
      reputation = "4_light_green"
      cards = [
        [
          type: "RECOMMENDATION",
          key: "LIGHTNING_OFFER"
        ],
        [
          type: "CONTENT",
          key: "PB01"
        ]
      ]
      seller_experience = "ADVANCED"
    }
  }

    test("Seller coach carousel scroll") {
    "/seller_central/seller_coach/summary/carousel_scroll"(platform: "/web", type: TrackType.Event) {
      segment = "perfect_launch"
      power_seller_status = "4_light_green"
      reputation = "4_light_green"
      page = 2
      scroll_type = "next"
      seller_experience = "ADVANCED"
    }
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central Offline
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("seller central offline view") {
    "/seller_central/bulk/offline/home"(platform: "/", type: TrackType.View) {}
  }

  test("seller central offline download views") {
    "/seller_central/bulk/offline/download"(platform: "/", type: TrackType.View) {}
    "/seller_central/bulk/offline/download/congrats"(platform: "/", type: TrackType.View) {}
  }

  test("seller central offline upload views") {
    "/seller_central/bulk/offline/upload"(platform: "/", type: TrackType.View) {}
    "/seller_central/bulk/offline/upload/congrats"(platform: "/", type: TrackType.View) {}
  }

  test("seller central offline download apply user selected columns and domains") {
    "/seller_central/bulk/offline/download/user_selection"(platform: "/", type: TrackType.Event) {
      domains = ["Mochilas", "Banquetas", "Bicicletas"]
      columns = ["price", "status"]

    }
  }

  test("seller central offline warning and error") {
    "/seller_central/bulk/offline/download/warning"(platform: "/", type: TrackType.Event) {}
    "/seller_central/bulk/offline/download/error"(platform: "/", type: TrackType.Event) {}
  }

  test("seller central offline confirm download with filters") {
    "/seller_central/bulk/offline/download/confirm"(platform: "/", type: TrackType.Event) {
      selected_columns = ["TITLE", "QUANTITY", "PRICE"]
      type = "MARKETPLACE"
      categories = ["MLA-CELLPHONES", "MLA-MICROWAVES"]
      filters = "ACTIVE"
    }
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central Bulk - DISCOUNTS version
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("seller central bulk view") {
    "/seller_central/bulk/discounts/list"(platform: "/", type: TrackType.View) {}
  }

  test("seller central bulk onboarding") {
    "/seller_central/bulk/discounts/onboarding"(platform: "/", type: TrackType.Event) {
      action = "close"
    }
    "/seller_central/bulk/discounts/onboarding"(platform: "/", type: TrackType.Event) {
      action = "start"
    }
    "/seller_central/bulk/discounts/onboarding"(platform: "/", type: TrackType.Event) {
      action = "dismiss"
      page = 2
    }
    "/seller_central/bulk/discounts/onboarding"(platform: "/", type: TrackType.Event) {
      action = "rollback"
    }
  }

  test("seller central bulk filters and search") {
    "/seller_central/bulk/discounts/filters"(platform: "/", type: TrackType.Event) {
      filters = ["active", "inactive"]
    }
  }

  test("seller central bulk filters and search") {
    "/seller_central/bulk/discounts/undo_changes"(platform: "/", type: TrackType.Event) {}
    "/seller_central/bulk/discounts/search"(platform: "/", type: TrackType.Event) {}
  }


  test("seller central bulk columns") {
    "/seller_central/bulk/discounts/columns"(platform: "/", type: TrackType.Event) {
      columns = ["price", "quantity"]
    }
  }

  test("seller central bulk save") {
    "/seller_central/bulk/discounts/save"(platform: "/", type: TrackType.Event) {}
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central Offline - DISCOUNTS version
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("seller central offline view") {
    "/seller_central/bulk/discounts/offline/home"(platform: "/", type: TrackType.View) {}
  }

  test("seller central offline download views") {
    "/seller_central/bulk/discounts/offline/download"(platform: "/", type: TrackType.View) {}
    "/seller_central/bulk/discounts/offline/download/congrats"(platform: "/", type: TrackType.View) {}
  }

  test("seller central offline upload views") {
    "/seller_central/bulk/discounts/offline/upload"(platform: "/", type: TrackType.View) {}
    "/seller_central/bulk/discounts/offline/upload/congrats"(platform: "/", type: TrackType.View) {}
  }

  test("seller central offline download apply user selected columns and domains") {
    "/seller_central/bulk/discounts/offline/download/user_selection"(platform: "/", type: TrackType.Event) {
      domains = ["Mochilas", "Banquetas", "Bicicletas"]
      columns = ["price", "status"]

    }
  }

  test("seller central offline warning and error") {
    "/seller_central/bulk/discounts/offline/download/warning"(platform: "/", type: TrackType.Event) {}
    "/seller_central/bulk/discounts/offline/download/error"(platform: "/", type: TrackType.Event) {}
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central modify
  //------------------------------------------------------------------------------------------------------------------------------------------------------


  test("seller central render detail"){
    "/seller_central/modify/detail"(platform: "/", type: TrackType.View){
      item_type = "default"
      category_id = "MLA390784"
      item_id = "MLA682118081"
      session_id = "123-update-abc123"
      category_domain = "MLA-FRAGRANCES"
      category_path = ["MLA1234", "MLA12345"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold_pro"
      shipping_local_pickup = true
    }
  }

  test("seller central render detail for motors"){
    "/seller_central/modify/detail"(platform: "/", type: TrackType.View){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("seller central render detail quick_edit_standard for motors"){
    "/seller_central/modify/detail/quick_edit_standard/show"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("seller central showing detail modal consequences for motors"){
    "/seller_central/modify/detail/consequences_modal"(platform: "/", type: TrackType.Event){
      item_type = "default"
      item_id = "MLA123456789"
      listing_type = "gold"
      session_id = "123-update-abc123"
      category_id = "MLM27420"
      goal = "picture"
      action = "show"
    }
  }

  test("seller central confirm detail modal consequences for motors"){
    "/seller_central/modify/detail/consequences_modal"(platform: "/", type: TrackType.Event){
      item_type = "default"
      item_id = "MLA123456789"
      listing_type = "gold"
      session_id = "123-update-abc123"
      category_id = "MLM27420"
      goal = "picture"
      action = "confirm"
    }
  }

  test("seller central cancel detail modal consequences for motors"){
    "/seller_central/modify/detail/consequences_modal"(platform: "/", type: TrackType.Event){
      item_type = "default"
      item_id = "MLA123456789"
      listing_type = "gold"
      session_id = "123-update-abc123"
      category_id = "MLM27420"
      goal = "picture"
      action = "cancel"
    }
  }

  test("seller central render detail quick_edit_standard for motors"){
    "/seller_central/modify/detail/quick_edit_standard/confirm"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("seller central render detail technical_specifications for motors"){
    "/seller_central/modify/detail/technical_specifications/show"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("seller central render detail technical_specifications for motors"){
    "/seller_central/modify/detail/technical_specifications/confirm"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("SYI V4 RE Modificar - seller central detail try technical_specifications intent"){
    "/seller_central/modify/detail/technical_specifications/intent"(platform: "/", type: TrackType.Event){
      business = 'classified'
      category_domain = "MLC-HOUSES_FOR_RENT"
      category_id = "MLM27420"
      category_path = ["MLC1459", "MLC1466", "MLC6406", "MLC183184"]
      item_id = "MLC534088624"
      item_type = "default"
      listing_type = "silver"
      platform = "pi"
      seller_profile = "NEWBIE"
      seller_reputation = "NO_REPUTATION"
      session_id = "516954617-updateres-b5e3bdf5d0d7"
      vertical = "real_estate"
      intent_type = "valid_intent"
      field_intent_ids = ["TOTAL_AREA", "SURFACE_AREA", "BEDROOMS"]
    }
  }

  test("seller central render detail seller_contact for motors"){
    "/seller_central/modify/detail/seller_contact/show"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("seller central render detail seller_contact for motors"){
    "/seller_central/modify/detail/seller_contact/confirm"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("seller central modify technical_specifications completed attributes"){
    "/seller_central/modify/technical_specifications/completed_attributes"(platform: "/", type: TrackType.Event){
      item_type = "default"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      domain_id = "MLM-CELLPHONES"
      attributes_before_update = [
        [id: "BRAND", value_id: "206", value_name: "Samsung"]
      ]
      attributes_after_update = [
        [id: "BRAND", value_id: "206", value_name: "Samsung"],
        [id: "MODEL", value_id: "32902", value_name: "Galaxy"]
      ]
    }
  }

  test("seller central modify technical_specifications completed attributes without value_id and value_name"){
    "/seller_central/modify/technical_specifications/completed_attributes"(platform: "/", type: TrackType.Event){
      item_type = "default"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      domain_id = "MLM-CELLPHONES"
      attributes_before_update = [
        [id: "BRAND", value_id: null, value_name: "Samsung"]
      ]
      attributes_after_update = [
        [id: "BRAND", value_id: null, value_name: null],
        [id: "MODEL", value_id: "32902", value_name: "Galaxy"],
        [id: "COLOR", value_id: "32902", value_name: "Galaxy", variation_id: 23437248239]
      ]
    }
  }

  test("seller central render detail reservation_info for motors"){
    "/seller_central/modify/detail/reservation_info/show"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("seller central render detail location for motors"){
    "/seller_central/modify/detail/location/show"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("seller central render detail location for motors"){
    "/seller_central/modify/detail/location/confirm"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("SYI V4 RE Modificar - seller central detail try location intent"){
    "/seller_central/modify/detail/location/intent"(platform: "/", type: TrackType.Event){
      business = 'classified'
      category_domain = "MLC-HOUSES_FOR_RENT"
      category_id = "MLM27420"
      category_path = ["MLC1459", "MLC1466", "MLC6406", "MLC183184"]
      item_id = "MLC534088624"
      item_type = "default"
      listing_type = "silver"
      platform = "pi"
      seller_profile = "NEWBIE"
      seller_reputation = "NO_REPUTATION"
      session_id = "516954617-updateres-b5e3bdf5d0d7"
      vertical = "real_estate"
      intent_type = "valid_street_number"
      intent_value= "Las Condes 4488, Santiago, Chile"
    }

    "/seller_central/modify/detail/location/intent"(platform: "/", type: TrackType.Event){
      business = 'classified'
      category_domain = "MLC-HOUSES_FOR_RENT"
      category_id = "MLM27420"
      category_path = ["MLC1459", "MLC1466", "MLC6406", "MLC183184"]
      item_id = "MLC534088624"
      item_type = "default"
      listing_type = "silver"
      platform = "pi"
      seller_profile = "NEWBIE"
      seller_reputation = "NO_REPUTATION"
      session_id = "516954617-updateres-b5e3bdf5d0d7"
      vertical = "real_estate"
      intent_type = "invalid_street_number"
      intent_value= "Las Condes, Santiago, Chile"
    }

    "/seller_central/modify/detail/location/intent"(platform: "/", type: TrackType.Event){
      business = 'classified'
      category_domain = "MLC-HOUSES_FOR_RENT"
      category_id = "MLM27420"
      category_path = ["MLC1459", "MLC1466", "MLC6406", "MLC183184"]
      item_id = "MLC534088624"
      item_type = "default"
      listing_type = "silver"
      platform = "pi"
      seller_profile = "NEWBIE"
      seller_reputation = "NO_REPUTATION"
      session_id = "516954617-updateres-b5e3bdf5d0d7"
      vertical = "real_estate"
      intent_type = "drag"
    }
  }

  test("seller central render detail instant_pay_listings for motors"){
    "/seller_central/modify/detail/instant_pay_listings/show"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("seller central render detail instant_pay_listings for motors"){
    "/seller_central/modify/detail/instant_pay_listings/confirm"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("seller central render detail description for motors"){
    "/seller_central/modify/detail/description/show"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("seller central render detail description for motors"){
    "/seller_central/modify/detail/description/confirm"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("seller central render detail video for motors"){
    "/seller_central/modify/detail/video/show"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("seller central render detail video for motors"){
    "/seller_central/modify/detail/video/confirm"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("seller central render detail change_category for motors"){
    "/seller_central/modify/detail/change_category/show"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("seller central render detail change_category for motors"){
    "/seller_central/modify/detail/change_category/confirm"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLM27420"
      item_id = "MLM749509590"
      session_id = "123-update-abc123"
      category_domain = "MLM-CARS_AND_VANS"
      category_path = ["MLM1743", "MLM1744", "MLM5739", "MLM27420"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold"
      vertical = "motors"
    }
  }

  test("seller central render variations"){
    "/seller_central/modify/variations"(platform: "/", type: TrackType.View){
      item_type = "default"
      category_id = "MLA390784"
      item_id = "MLA682118081"
      session_id = "123-update-abc123"
      category_domain = "MLA-FRAGRANCES"
      category_path = ["MLA1234", "MLA12345"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold_pro"
      shipping_local_pickup = true
    }
  }

  test("seller central render custom variations"){
    "/seller_central/modify/variations_custom"(platform: "/", type: TrackType.View){
      item_type = "default"
      category_id = "MLA390784"
      item_id = "MLA682118081"
      session_id = "123-update-abc123"
      category_domain = "MLA-FRAGRANCES"
      category_path = ["MLA1234", "MLA12345"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold_pro"
      shipping_local_pickup = true
    }
  }

  test("seller central render listing_type"){
    "/seller_central/modify/listing_type"(platform: "/", type: TrackType.View){
      item_type = "default"
      category_id = "MLA390784"
      item_id = "MLA682118081"
      session_id = "123-update-abc123"
      category_domain = "MLA-FRAGRANCES"
      category_path = ["MLA1234", "MLA12345"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold_pro"
      shipping_local_pickup = true
    }
  }

  test("seller central render subflow"){
    "/seller_central/modify/subflow"(platform: "/", type: TrackType.View){
      item_type = "default"
      category_id = "MLA390784"
      item_id = "MLA682118081"
      session_id = "123-update-abc123"
      category_domain = "MLA-FRAGRANCES"
      category_path = ["MLA1234", "MLA12345"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold_pro"
      shipping_local_pickup = true
    }
  }

  test("seller central update salesChannel"){
    "/seller_central/modify/update_sales_channel"(platform: "/", type: TrackType.Event){
      item_type = "product"
      category_id = "MLA390784"
      item_id = "MLA682118081"
      session_id = "123-update-abc123"
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      listing_type = "gold_pro"
      shipping_local_pickup = true
      from = "true"
      to = "false"
      marketplace = true
      mshops = false
    }
  }

  test("seller central price value updated"){
    "/seller_central/modify/update_price"(platform: "/", type: TrackType.Event){
      item_type = "product"
      category_id = "MLA390784"
      item_id = "MLA682118081"
      session_id = "123-update-abc123"
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      from = "1200"
      to = "1500"
      listing_type = "gold_pro"
      shipping_local_pickup = true
    }
  }

  test("seller central quantity value updated"){
    "/seller_central/modify/update_quantity"(platform: "/", type: TrackType.Event){
      item_type = "product"
      category_id = "MLA390784"
      item_id = "MLA682118081"
      session_id = "123-update-abc123"
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      from = "3"
      to = "4"
      listing_type = "gold_pro"
      shipping_local_pickup = true
    }
  }

  test("seller central local pickup value updated"){
    "/seller_central/modify/update_localpickup_options"(platform: "/", type: TrackType.Event){
      item_type = "product"
      category_id = "MLA390784"
      item_id = "MLA682118081"
      session_id = "123-update-abc123"
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      from = "NO"
      to = "SI"
      listing_type = "gold_pro"
      shipping_local_pickup = true
    }
  }

  test("seller central warranty value updated"){
    "/seller_central/modify/update_warranty"(platform: "/", type: TrackType.Event){
      item_type = "product"
      category_id = "MLA390784"
      item_id = "MLA682118081"
      session_id = "123-update-abc123"
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      from = "WARRANTY_TYPE 6150835"
      to = "WARRANTY_TYPE 2230280"
      listing_type = "gold_pro"
      shipping_local_pickup = true
    }
  }

  test("seller central x3_capmaing value updated"){
    "/seller_central/modify/update_3x_campaign"(platform: "/", type: TrackType.Event){
      seller_reputation = "5_green"
      competition_status = "LOSING_BY_UNTRUSTED_SELLER"
      category_domain = "MLA-CELLPHONES"
      item_id = "MLA682118081"
      item_type = "product"
      shipping_local_pickup = true
      listing_type = "gold_pro"
      catalog_product_id = "MLA123"
      session_id = "123-update-abc123"
      category_id = "MLA390784"
      seller_profile = "ADVANCED"
      from = "false"
      to = "true"
    }
  }

   test("seller central x3_capmaing value updated"){
    "/seller_central/modify/update_ahora_12"(platform: "/", type: TrackType.Event){
      seller_reputation = "5_green"
      competition_status = "LOSING_BY_UNTRUSTED_SELLER"
      category_domain = "MLA-CELLPHONES"
      item_id = "MLA682118081"
      item_type = "product"
      shipping_local_pickup = true
      listing_type = "gold_pro"
      catalog_product_id = "MLA123"
      session_id = "123-update-abc123"
      category_id = "MLA390784"
      seller_profile = "ADVANCED"
      from = "false"
      to = "true"
    }
  }

  test("seller central listing type value updated"){
    "/seller_central/modify/update_listing_types"(platform: "/", type: TrackType.Event){
      item_type = "product"
      category_id = "MLA390784"
      item_id = "MLA682118081"
      session_id = "123-update-abc123"
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      from = "gold_special"
      to = "gold_pro"
      listing_type = "gold_pro"
      shipping_local_pickup = true
    }
  }

  test("seller central flex value updated"){
    "/seller_central/modify/update_shipping_flex"(platform: "/", type: TrackType.Event){
      item_type = "product"
      category_id = "MLA390784"
      item_id = "MLA682118081"
      session_id = "123-update-abc123"
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      from = "true"
      to = "false"
      listing_type = "gold_pro"
      shipping_local_pickup = true
    }
  }

  test("seller central item condition value updated"){
    "/seller_central/modify/update_item_condition"(platform: "/", type: TrackType.Event){
      item_type = "product"
      category_id = "MLA390784"
      item_id = "MLA682118081"
      session_id = "123-update-abc123"
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      from = "new"
      to = "used"
      listing_type = "gold_pro"
      shipping_local_pickup = true
    }
  }

  test("seller central item size_chart value updated"){
    "/seller_central/modify/update_size_chart"(platform: "/", type: TrackType.Event){
      item_type = "product"
      category_id = "MLA390784"
      item_id = "MLA682118081"
      session_id = "123-update-abc123"
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      from = "-1"
      to = "6270"
      listing_type = "gold_pro"
      shipping_local_pickup = true
    }
  }

  test("seller central item price push winner was updated"){
    "/seller_central/modify/update_price_push_winner_pdp"(platform: "/", type: TrackType.Event) {
      item_type = "product"
      category_id = "MLA390784"
      item_id = "MLA682118081"
      session_id = "123-update-abc123"
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      from = "-1"
      to = "6270"
      listing_type = "gold_pro"
      shipping_local_pickup = true
    }
  }

  test("seller central rebate chosen"){
    "/seller_central/modify/update_rebate"(platform: "/", type: TrackType.Event) {
      item_type = "product"
      category_id = "MLA390784"
      item_id = "MLA682118081"
      session_id = "123-update-abc123"
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      from = "-1"
      to = "6270"
      listing_type = "gold_pro"
      shipping_local_pickup = true
    }
  }

  test("seller central track to measure health changes"){
    "/seller_central/modify/success"(platform: "/web", type: TrackType.Event){
      item_type = "default"
      item_id = "MLA12345"
      session_id = "123-update-abc123"
      goals_achieved = ["mercado_envios"]
      original_goals_not_completed = ["mercado_envios", "pictures"]
      original_goals_completed = ["technical_specifications"]
      original_goals_not_applied = ["price_parity"]
      goal_order = "random"
      original_price = 123.4
      original_currency = "ARS"
      original_listing_type = "gold_special"
      original_quantity = 2
      original_condition = "used"
      original_shipping = "ME_BUYER"
      original_local_pickup = true
      domain = "cellphones"
      is_fbm = true
      is_catalog_product = true
      technical_specifications_attributes_empty = 0
      technical_specifications_attributes_loaded = 5
      seller_experience = "ADVANCED"
      is_official_store = true
    }
  }

  test("seller central flex subflow"){
    "/seller_central/modify/optin_flex_subflow"(platform: "/", type: TrackType.View){
      item_type = "default"
      category_id = "MLA12812"
      item_id = "MLA776923789"
      session_id = "416163910-update-79c25d849574"
      seller_profile = "NEWBIE"
      seller_reputation = "5_green"
      listing_type = "gold_pro"
      shipping_local_pickup = true
    }
  }

  test("seller central modify catalog boost card show"){
    "/seller_central/modify/catalog_boost"(platform: "/", type: TrackType.View){
      item_type = "default"
      category_id = "MLA12812"
      item_id = "MLA776923789"
      session_id = "416163910-update-79c25d849574"
      seller_profile = "NEWBIE"
      seller_reputation = "5_green"
      listing_type = "gold_pro"
      shipping_local_pickup = true
      item_attributes = [
              [ id:"COLOR", value_id:"3434" ],
              [ id:"MODEL", value_id:"1234" ]
      ]
      catalog_product_attributes= [
              [ id:"COLOR", value_id:"3434" ],
              [ id:"MODEL", value_id:"1234" ]
      ]
      item_title= "celular"
      catalog_product_title= "iphone X 64 GB NEGRO"
      catalog_product_id= "MLA123455"
    }
  }

  test("seller central modify catalog boost seller click original_item action"){
    "/seller_central/modify/catalog_boost/original_item"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLA12812"
      item_id = "MLA776923789"
      session_id = "416163910-update-79c25d849574"
      seller_profile = "NEWBIE"
      seller_reputation = "5_green"
      listing_type = "gold_pro"
      shipping_local_pickup = true
      item_attributes = [
              [ id:"COLOR", value_id:"3434" ],
              [ id:"MODEL", value_id:"1234" ]
      ]
      catalog_product_attributes= [
              [ id:"COLOR", value_id:"3434" ],
              [ id:"MODEL", value_id:"1234" ]
      ]
      item_title= "celular"
      catalog_product_title= "iphone X 64 GB NEGRO"
      catalog_product_id= "MLA123455"
    }
  }

  test("seller central modify catalog boost seller click activate product item"){
    "/seller_central/modify/catalog_boost/activate"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLA12812"
      item_id = "MLA776923789"
      session_id = "416163910-update-79c25d849574"
      seller_profile = "NEWBIE"
      seller_reputation = "5_green"
      listing_type = "gold_pro"
      shipping_local_pickup = true
      catalog_product_id= "MLA123455"
      item_attributes = [
              [ id:"COLOR", value_id:"3434" ],
              [ id:"MODEL", value_id:"1234" ]
      ]
      catalog_product_attributes= [
              [ id:"COLOR", value_id:"3434" ],
              [ id:"MODEL", value_id:"1234" ]
      ]
      item_title= "celular"
      catalog_product_title= "iphone X 64 GB NEGRO"
      catalog_product_id= "MLA123455"
    }
  }

  test("seller central modify catalog boost seller click not_my_product action"){
    "/seller_central/modify/catalog_boost/not_my_product"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLA12812"
      item_id = "MLA776923789"
      session_id = "416163910-update-79c25d849574"
      seller_profile = "NEWBIE"
      seller_reputation = "5_green"
      listing_type = "gold_pro"
      shipping_local_pickup = true
      catalog_product_id= "MLA123455"
      item_attributes = [
              [ id:"COLOR", value_id:"3434" ],
              [ id:"MODEL", value_id:"1234" ]
      ]
      catalog_product_attributes= [
              [ id:"COLOR", value_id:"3434" ],
              [ id:"MODEL", value_id:"1234" ]
      ]
      item_title= "celular"
      catalog_product_title= "iphone X 64 GB NEGRO"
      catalog_product_id= "MLA123455"
    }
  }

  test("seller central modify catalog boost seller click not_my_product action"){
    "/seller_central/modify/catalog_boost/modal/confirm"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLA12812"
      item_id = "MLA776923789"
      session_id = "416163910-update-79c25d849574"
      seller_profile = "NEWBIE"
      seller_reputation = "5_green"
      listing_type = "gold_pro"
      shipping_local_pickup = true
      catalog_product_id= "MLA123455"
      seller_reasons= "modelo iphone 11 blanco"
      item_attributes = [
              [ id:"COLOR", value_id:"3434" ],
              [ id:"MODEL", value_id:"1234" ]
      ]
      catalog_product_attributes= [
              [ id:"COLOR", value_id:"3434" ],
              [ id:"MODEL", value_id:"1234" ]
      ]
      item_title= "celular"
      catalog_product_title= "iphone X 64 GB NEGRO"
      catalog_product_id= "MLA123455"
    }
  }

  test("seller central modify catalog boost seller click not_my_product action"){
    "/seller_central/modify/catalog_boost/modal/cancel"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_id = "MLA12812"
      item_id = "MLA776923789"
      session_id = "416163910-update-79c25d849574"
      seller_profile = "NEWBIE"
      seller_reputation = "5_green"
      listing_type = "gold_pro"
      shipping_local_pickup = true
      catalog_product_id= "MLA123455"
      item_attributes = [
              [ id:"COLOR", value_id:"3434" ],
              [ id:"MODEL", value_id:"1234" ]
      ]
      catalog_product_attributes= [
              [ id:"COLOR", value_id:"3434" ],
              [ id:"MODEL", value_id:"1234" ]
      ]
      item_title= "celular"
      catalog_product_title= "iphone X 64 GB NEGRO"
      catalog_product_id= "MLA123455"
    }
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central Structured Data
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("structured data hint available"){
    "/seller_central/modify/technical_specifications/hints/available"(platform: "/", type: TrackType.Event){
      item_type = "default"
      type = "actionable"
      attribute = "BRAND"
      category_domain= "MLA-CAMERAS"
      item_id= "MLA682118081"
      session_id = "123-update-abc123"
      hint_id = "REPEATED_ATTRIBUTE"
    }
  }

  test("structured data hint showed"){
    "/seller_central/modify/technical_specifications/hints/showed"(platform: "/", type: TrackType.Event){
      item_type = "default"
      type = "info"
      attribute = "BRAND"
      category_domain= "MLA-CAMERAS"
      item_id= "MLA682118081"
      session_id = "123-update-abc123"
      hint_id = "REPEATED_ATTRIBUTE"
    }
  }

  test("structured data hint completed"){
    "/seller_central/modify/technical_specifications/hints/completed"(platform: "/", type: TrackType.Event){
      item_type = "default"
      type = "actionable"
      user_action = "click"
      attribute = "BRAND"
      category_domain= "MLA-CAMERAS"
      item_id= "MLA682118081"
      session_id = "123-update-abc123"
      hint_id = "REPEATED_ATTRIBUTE"
    }
  }

  test("structured data hint available"){
    "/seller_central/bulk/technical_specifications/hints/available"(platform: "/", type: TrackType.Event){
      type = "actionable"
      attribute = "BRAND"
      category_domain= "MLA-CAMERAS"
      item_id= "MLA682118081"
      session_id = "123-update-abc123"
      hint_id = "REPEATED_ATTRIBUTE"
    }
  }

  test("structured data hint showed"){
    "/seller_central/bulk/technical_specifications/hints/showed"(platform: "/", type: TrackType.Event){
      type = "info"
      attribute = "BRAND"
      category_domain= "MLA-CAMERAS"
      item_id= "MLA682118081"
      session_id = "123-update-abc123"
      hint_id = "REPEATED_ATTRIBUTE"
    }
  }


  test("structured data hint completed"){
    "/seller_central/bulk/technical_specifications/hints/completed"(platform: "/", type: TrackType.Event){
      type = "actionable"
      user_action = "click"
      attribute = "BRAND"
      category_domain= "MLA-CAMERAS"
      item_id= "MLA682118081"
      session_id = "123-update-abc123"
      hint_id = "REPEATED_ATTRIBUTE"
    }
  }

  test("structured data multivalue"){
    "/seller_central/modify/technical_specifications/multivalue"(platform: "/", type: TrackType.Event){
      item_type = "default"
      quantity = 3
      previous_quantity = 0
      category_domain = "MLA-SHORTS"
      hierarchy = "PRODUCT_IDENTIFIER"
      item_id= "MLA682118081"
      session_id = "123-update-abc123"
      attribute= "BRAND"
    }
  }

  test("structured data suggested values"){
    "/seller_central/modify/technical_specifications/suggested"(platform: "/", type: TrackType.Event){
      item_type = "default"
      type = "dynamic"
      category_domain = "MLA-CAMERAS"
      item_id= "MLA682118081"
      session_id = "123-update-abc123"
      hierarchy = "PRODUCT_IDENTIFIER"
      attribute = "BRAND"
    }
  }

  test("structured data change category"){
    "/seller_central/modify/update_change_category"(platform: "/", type: TrackType.Event){
      item_type = "default"
      category_domain = "MLA-CAMERAS"
      item_id= "MLA682118081"
      session_id = "123-update-abc123"
    }
  }

  test("structured data hidden attributes (open)"){
    "/seller_central/modify/technical_specifications/hidden_attributes/open"(platform: "/", type: TrackType.Event){
      session_id = "123-update-abc123"
      seller_id = 415920446
      item_id = "MLA682118081"
      item_type = "default"
      category_domain = "MLA-CAMERAS"
      times_showed = 1
      attributes = 3
      type = "CONFIRM"
    }
  }

  test("structured data hidden attributes (add)"){
    "/seller_central/modify/technical_specifications/hidden_attributes/add"(platform: "/", type: TrackType.Event){
      session_id = "123-update-abc123"
      seller_id = 415920446
      item_id = "MLA682118081"
      item_type = "default"
      category_domain = "MLA-CAMERAS"
      attribute = "BRAND"
      type = "CONFIRM"
    }
  }

  test("structured data hidden attributes (change)"){
    "/seller_central/modify/technical_specifications/hidden_attributes/change"(platform: "/", type: TrackType.Event){
      session_id = "123-update-abc123"
      seller_id = 415920446
      item_id = "MLA682118081"
      item_type = "default"
      category_domain = "MLA-CAMERAS"
      attribute = "BRAND"
      value = "Sony"
      type = "CONFIRM"
    }
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central settings
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("seller central settings view"){
    "/seller_central/settings"(platform: "/", type: TrackType.View){
      reputation_level = "5_green"
      seller_profile = "advanced"
    }
  }


  test("seller central empty settings view"){
    "/seller_central/empty_settings"(platform: "/", type: TrackType.View){
      seller_profile = "newbie"
    }
  }

  test("seller central settings view event when a row is displayed"){
    "/seller_central/settings/show_row"(platform: "/", type: TrackType.Event){
      row_id = "row_shipping_address"
      ui_type = "row"
      section = "shipping"
    }
  }

  test("seller central settings view event when a row is updated"){
    "/seller_central/settings/update_row"(platform: "/", type: TrackType.Event){
      to = "DEFAULT"
      from = "THERMAL"
      row_id = "row_printer_method"
      section_id = "shipping"
    }
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central Sales
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("seller central sales list view for web") {
    "/seller_central/sales/list"(platform: "/", type: TrackType.View) {
        seller_profile = "ADVANCED"
        seller_reputation = "5_green"
        seller_segment = "MEDIUM_SELLERS_III"
        mercado_lider = false
    }
  }

  test("seller central sales list view for mobile") {
    "/seller_central/sales/list"(platform: "/web/mobile", type: TrackType.View) {}
  }

  test("seller central sales onboarding action") {
    "/seller_central/sales/list/onboarding/action"(platform: "/", type: TrackType.Event) {
      id = "start"
      page = 1
    }
    "/seller_central/sales/list/onboarding/action"(platform: "/", type: TrackType.Event) {
      id = "dismiss"
      page = 2
    }
    "/seller_central/sales/list/onboarding/action"(platform: "/", type: TrackType.Event) {
      id = "close"
      page = 3
    }
  }

  test("seller central sales onboarding massive invoice emission") {
      "/seller_central/sales/list/onboarding/massive"(platform: "/") {}
  }

  test("seller central sales onboarding massive invoice emission modal confirm") {
      "/seller_central/sales/list/onboarding/massive/confirm"(platform: "/", type: TrackType.Event) {}
  }

  test("seller central sales onboarding massive invoice emission modal close") {
      "/seller_central/sales/list/onboarding/massive/close"(platform: "/", type: TrackType.Event) {}
  }

  test("seller central sales nfe onboarding action") {
    "/seller_central/sales/list/nfe_onboarding/action"(platform: "/", type: TrackType.Event) {
      id = "start"
      page = 1
    }
    "/seller_central/sales/list/nfe_onboarding/action"(platform: "/", type: TrackType.Event) {
      id = "dismiss"
      page = 2
    }
    "/seller_central/sales/list/nfe_onboarding/action"(platform: "/", type: TrackType.Event) {
      id = "close"
      page = 3
    }
  }

  test("seller central sales search") {
    "/seller_central/sales/list/search"(platform: "/", type: TrackType.Event) {}
  }

  test("seller central sales pagination") {
    "/seller_central/sales/list/pagination"(platform: "/web", type: TrackType.Event) {
      page = 2
      total = 10
    }
  }

  test("seller central sales list action modal open") {
    "/seller_central/sales/list/modal_action/open"(platform: "/web", type: TrackType.Event) {
      id = "action_modal_id"
    }
  }

  test("seller central sales list action modal close") {
    "/seller_central/sales/list/modal_action/close"(platform: "/web", type: TrackType.Event) {
      id = "action_modal_id"
    }
  }

  test("seller central sales list action modal apply") {
    "/seller_central/sales/list/modal_action/apply"(platform: "/web", type: TrackType.Event) {
      id = "action_modal_id"
      option = "option_id"
    }
  }

  test("seller central sales widget action") {
    "/seller_central/sales/list/widget/header"(platform: "/web", type: TrackType.Event) {
      collapsed = true
    }
  }

  test("seller central sales widget action") {
    "/seller_central/sales/list/widget/dismiss"(platform: "/web", type: TrackType.Event) {
      batch_id = "128390"
    }
  }

  test("seller central sales widget action") {
    "/seller_central/sales/list/widget/close"(platform: "/web", type: TrackType.Event) {
      processing = true
      batch_ids = ["128390", "128390"]
    }
  }

  test("seller central sales widget action") {
    "/seller_central/sales/list/widget/action"(platform: "/web", type: TrackType.Event) {
      action = "dynamic_action"
      type = "download"
      date_created = "01/01/2021"
      date_finished = "01/01/2021"
      date_executed = "01/01/2021"
    }
  }

  test("seller central sales web dashboard open") {
    "/seller_central/sales/list/dashboard/open"(platform: "/web", type: TrackType.Event) {
      substates = ["card_id_1", "card_id_2"]
    }
  }

  test("seller central sales mobile dashboard open") {
    "/seller_central/sales/list/dashboard/open"(platform: "/mobile", type: TrackType.Event) {
      state = "state_id"
      substates = ["card_id_1", "card_id_2"]
    }
  }

  test("seller central sales dashboard close") {
    "/seller_central/sales/list/dashboard/close"(platform: "/web", type: TrackType.Event) {}
  }

  test("seller central sales dashboard task") {
    "/seller_central/sales/list/dashboard/apply"(platform: "/", type: TrackType.Event) {
      state = "column_id"
      substate = "card_id"
      count = 5
    }
  }

  test("seller central sales list filters view") {
    "/seller_central/sales/list/filters"(platform: "/mobile", type: TrackType.View) {}
  }

  test("seller central sales filters open") {
    "/seller_central/sales/list/filters/open"(platform: "/web", type: TrackType.Event) {}
  }

  test("seller central sales filters action") {
    "/seller_central/sales/list/filters/action"(platform: "/", type: TrackType.Event) {
      id = "apply"
      filters = ["filter_id_1", "filter_id_2"]
      sort = "ASC"
    }
    "/seller_central/sales/list/filters/action"(platform: "/", type: TrackType.Event) {
      id = "clear"
      filters = ["filter_id_1", "filter_id_2"]
      sort = "DESC"
    }
  }

  test("seller central sales massive action") {
    "/seller_central/sales/list/massive"(platform: "/web", type: TrackType.Event) {
      id = "massive_action_id"
      count = 20
    }
  }

  test("Seller central sales excel snackbar") {
    "/seller_central/sales/list/excel/snackbar"(platform: "/web", type: TrackType.Event) {
      id = "ERROR"
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      seller_segment = "MEDIUM_SELLERS_III"
      mercado_lider = false
    }
  }


  test("Seller Central sale excel generation") {
    "/seller_central/sales/list/excel/generation"(platform: "/web", type: TrackType.Event) {
      id = "SUCCESS"
      time = 200
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      seller_segment = "MEDIUM_SELLERS_III"
      mercado_lider = false
    }
  }

  test("Seller Central sale excel packs") {
    "/seller_central/sales/list/excel/packs"(platform: "/web", type: TrackType.Event) {
      total_sales = 150
      total_rows = 200
      total_error_rows = 5
      total_error_cells = 5
      total_packs = 2
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      seller_segment = "MEDIUM_SELLERS_III"
      mercado_lider = false
    }
  }


  test("seller central sales row open") {
    "/seller_central/sales/list/row/open"(platform: "/web", type: TrackType.Event) {}
  }

  test("seller central sales messages actions") {
    "/seller_central/sales/list/row/messages_action"(platform: "/mobile", type: TrackType.Event) {
      type = "view_new_messages"
    }
  }

  test("seller central sales claims actions") {
    "/seller_central/sales/list/row/claims_action"(platform: "/mobile", type: TrackType.Event) {
      type = "answer_claim"
    }
  }

  test("seller central sales list primary action show") {
    "/seller_central/sales/list/action/primary/show"(platform: "/web", type: TrackType.Event) {
      id = "action_id"
    }
  }

  test("seller central sales list primary action") {
    "/seller_central/sales/list/action/primary"(platform: "/web", type: TrackType.Event) {
      id = "action_id"
      filters = ["active", "inactive"]
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      seller_segment = "MEDIUM_SELLERS_III"
      mercado_lider = false
    }
  }

  test("seller central sales list secondary secondary") {
    "/seller_central/sales/list/action/secondary"(platform: "/web", type: TrackType.Event) {
      id = "action_id"
    }
  }

  test("seller central sales detail view") {
    "/seller_central/sales/detail"(platform: "/", type: TrackType.View) {}
  }

  test("seller central sales detail row close") {
    "/seller_central/sales/detail/row/close"(platform: "/web", type: TrackType.Event) {}
  }

  test("seller central sales detail primary action show") {
    "/seller_central/sales/detail/action/primary/show"(platform: "/web", type: TrackType.Event) {
      id = "action_id"
    }
  }

  test("seller central sales detail primary action") {
    "/seller_central/sales/detail/action/primary"(platform: "/web", type: TrackType.Event) {
      id = "action_id"
    }
  }

  test("seller central sales detail secondary action") {
    "/seller_central/sales/detail/action/secondary"(platform: "/web", type: TrackType.Event) {
      id = "action_id"
    }
  }

  test("seller central sales detail message action") {
    "/seller_central/sales/detail/message/action"(platform: "/web", type: TrackType.Event) {
      id = "action_id"
    }
  }

  test("seller central sales print action") {
    "/seller_central/sales/detail/action/print"(platform: "/web", type: TrackType.Event) {}
  }

  test("seller central sales detail action modal open") {
    "/seller_central/sales/detail/modal_action/open"(platform: "/web", type: TrackType.Event) {
      id = "action_modal_id"
    }
  }

  test("seller central sales detail action modal close") {
    "/seller_central/sales/detail/modal_action/close"(platform: "/web", type: TrackType.Event) {
      id = "action_modal_id"
    }
  }

  test("seller central sales detail action modal apply") {
    "/seller_central/sales/detail/modal_action/apply"(platform: "/web", type: TrackType.Event) {
      id = "action_modal_id"
      option = "option_id"
    }
  }

  test("seller central sales widget action") {
    "/seller_central/sales/detail/widget/header"(platform: "/web", type: TrackType.Event) {
      collapsed = true
    }
  }

  test("seller central sales widget action") {
    "/seller_central/sales/detail/widget/dismiss"(platform: "/web", type: TrackType.Event) {
      batch_id = "128390"
    }
  }

  test("seller central sales widget action") {
    "/seller_central/sales/detail/widget/close"(platform: "/web", type: TrackType.Event) {
      processing = true
      batch_ids = ["128390", "128390"]
    }
  }

  test("seller central sales widget action") {
    "/seller_central/sales/detail/widget/action"(platform: "/web", type: TrackType.Event) {
      action = "dynamic_action"
      type = "download"
      date_created = "01/01/2021"
      date_finished = "01/01/2021"
      date_executed = "01/01/2021"
    }
  }

  test("seller central sales detail main action") {
    "/seller_central/sales/detail/main_action"(platform: "/mobile", type: TrackType.Event) {
      id = "PRODUCT_DELIVERED"
    }
  }

  test("seller central sales detail messages action") {
    "/seller_central/sales/detail/messages_action"(platform: "/mobile", type: TrackType.Event) {
      type = "view_new_messages"
    }
  }

  test("seller central sales detail claim action") {
    "/seller_central/sales/detail/claims_action"(platform: "/mobile", type: TrackType.Event) {
      type = "answer_claim"
    }
  }

  test("seller central sales detail secondary action") {
    "/seller_central/sales/detail/secondary_action"(platform: "/mobile", type: TrackType.Event) {
      id = "HELP_ACTION"
    }
  }

  test("seller central sales detail payment") {
    "/seller_central/sales/detail/payment"(platform: "/mobile", type: TrackType.View) {}
  }

  test("seller central sales detail shipping") {
    "/seller_central/sales/detail/shipping"(platform: "/mobile", type: TrackType.View) {}
  }

  test("seller central sales detail shipping action") {
    "/seller_central/sales/detail/shipping/action"(platform: "/mobile", type: TrackType.Event) {
      id = "FOLLOW_SHIPPING"
    }
  }

  test("seller central sales detail invoice information") {
    "/seller_central/sales/detail/invoice_info"(platform: "/mobile", type: TrackType.View) {}
  }

  test("seller central sales detail buyer information") {
    "/seller_central/sales/detail/buyer_info"(platform: "/mobile", type: TrackType.View) {}
  }

  test("seller central sales detail buyer information action") {
    "/seller_central/sales/detail/buyer_info/action"(platform: "/mobile", type: TrackType.Event) {
      id = "CALL"
    }
  }

  test("seller central sales detail driver information") {
    "/seller_central/sales/detail/driver_info"(platform: "/mobile", type: TrackType.View) {}
  }

  // TODO actor info

  test("seller central sales detail congrats") {
    "/seller_central/sales/detail/congrats"(platform: "/mobile", type: TrackType.View) {}
  }

  test("seller central sales detail cancellation flow") {
    "/seller_central/sales/detail/cancellation/landing"(platform: "/mobile", type: TrackType.View) {}
    "/seller_central/sales/detail/cancellation/order_selection"(platform: "/mobile", type: TrackType.View) {}
    "/seller_central/sales/detail/cancellation/reason_selection"(platform: "/mobile", type: TrackType.View) {}
    "/seller_central/sales/detail/cancellation/reason_input"(platform: "/mobile", type: TrackType.View) {}
  }

  test("upload invoices view secondary actions") {
    "/seller_central/sales/fiscal_document/action/secondary"(platform: "/web", type: TrackType.Event) {
      id = "fiscal_document_go_back"
    }
  }

  test("upload invoices view primary actions") {
    "/seller_central/sales/fiscal_document/action/primary"(platform: "/web", type: TrackType.Event) {
      id = "save_fiscal_document"
    }
  }

  test("upload invoices view actions") {
    "/seller_central/sales/fiscal_document/action"(platform: "/web", type: TrackType.Event) {}
  }

  test("upload invoices view actions") {
    "/seller_central/sales/fiscal_document"(platform: "/web", type: TrackType.Event) {}
  }

  test("upload invoices view") {
    "/seller_central/sales/fiscal-document"(platform: "/web", type: TrackType.View) {}
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central METRICS SECTION
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("metrics section view for web") {
    "/seller_central/metrics"(platform: "/web", type: TrackType.View) {
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      seller_segment = "MEDIUM_SELLERS_III"
      mercado_lider = false
      user_type = "real_estate_agency"
    }
  }

  test("metrics section view for web mobile") {
    "/seller_central/metrics"(platform: "/web/mobile", type: TrackType.View) {}
  }

  test("metrics section view for mobile") {
    "/seller_central/metrics"(platform: "/mobile", type: TrackType.View) {
      fragment_from_webview = "summary"
    }
  }

  test("metrics section view for web") {
    "/seller_central/metrics/show_filters"(platform: "/web", type: TrackType.Event) {
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      seller_segment = "MEDIUM_SELLERS_III"
      mercado_lider = false
      user_type = "real_estate_agency"
      applied_filters = []
      finish_period = "lastPeriod"
      start_period = "today"
      from_previous = "02/01/2020"
      from_current = "02/01/2020"
      to_previous = "01/01/2020"
      to_current = "01/01/2020"
    }
  }

  test("metrics section view for web") {
    "/seller_central/metrics/clear_filters"(platform: "/web", type: TrackType.Event) {
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      seller_segment = "MEDIUM_SELLERS_III"
      mercado_lider = false
      user_type = "real_estate_agency"
      applied_filters = []
      finish_period = "lastPeriod"
      start_period = "today"
      from_previous = "02/01/2020"
      from_current = "02/01/2020"
      to_previous = "01/01/2020"
      to_current = "01/01/2020"
    }
  }

  test("metrics section view for web") {
    "/seller_central/metrics/apply_filters"(platform: "/web", type: TrackType.Event) {
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      seller_segment = "MEDIUM_SELLERS_III"
      mercado_lider = false
      user_type = "real_estate_agency"
      applied_filters = []
      finish_period = "lastPeriod"
      start_period = "today"
      from_previous = "02/01/2020"
      from_current = "02/01/2020"
      to_previous = "01/01/2020"
      to_current = "01/01/2020"
    }
  }

  test("metrics section view for web") {
    "/seller_central/metrics/close_filters"(platform: "/web", type: TrackType.Event) {
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      seller_segment = "MEDIUM_SELLERS_III"
      mercado_lider = false
      user_type = "real_estate_agency"
      applied_filters = []
      finish_period = "lastPeriod"
      start_period = "today"
      from_previous = "02/01/2020"
      from_current = "02/01/2020"
      to_previous = "01/01/2020"
      to_current = "01/01/2020"
    }
  }

  test("metrics section view for web") {
    "/seller_central/metrics/chart_render"(platform: "/web", type: TrackType.Event) {
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      seller_segment = "MEDIUM_SELLERS_III"
      mercado_lider = false
      user_type = "real_estate_agency"
      applied_filters = []
      finish_period = "lastPeriod"
      start_period = "today"
      from_previous = "02/01/2020"
      from_current = "02/01/2020"
      to_previous = "01/01/2020"
      to_current = "01/01/2020"
      metric = "GMV"
      value = "2000"
      badget_type = "up"
    }
  }

  test("metrics section view for web") {
    "/seller_central/metrics/date_picker_show"(platform: "/web", type: TrackType.Event) {
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      seller_segment = "MEDIUM_SELLERS_III"
      mercado_lider = false
      user_type = "real_estate_agency"
      applied_filters = []
      finish_period = "lastPeriod"
      start_period = "today"
      from_previous = "02/01/2020"
      from_current = "02/01/2020"
      to_previous = "01/01/2020"
      to_current = "01/01/2020"
      period_type = "primary"
    }
  }

  test("metrics section view for web") {
    "/seller_central/metrics/date_picker_apply"(platform: "/web", type: TrackType.Event) {
      seller_profile = "ADVANCED"
      seller_reputation = "5_green"
      seller_segment = "MEDIUM_SELLERS_III"
      mercado_lider = false
      user_type = "real_estate_agency"
      applied_filters = []
      finish_period = "lastPeriod"
      start_period = "today"
      from_previous = "02/01/2020"
      from_current = "02/01/2020"
      to_previous = "01/01/2020"
      to_current = "01/01/2020"
      period_type = "primary"
    }
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central Catalog Optin
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("seller central catalog optin") {
    "/seller_central/catalog"(platform: "/web", type: TrackType.View) {}
  }

  test("seller central catalog optin variation selection page view") {
    "/seller_central/catalog/optin/variation_selection"(platform: "/web", type: TrackType.View) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN"
    }
  }

  test("seller central catalog optin page view") {
    "/seller_central/catalog/optin"(platform: "/web", type: TrackType.View) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN"
    }
  }

  test("seller central catalog optin product comparator view") {
    "/seller_central/catalog/optin/product_comparator/show"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      categorization_flow_successful = true
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
    }
  }

  test("seller central catalog optin product comparator confirm") {
    "/seller_central/catalog/optin/product_comparator/confirm"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      categorization_flow_successful = true
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN"
      attribute_id = "COLOR"
      task_id = "product_comparator"
      attribute_values = [
        [
          "name": "test",
          "id": "TEST",
          "value_id": "123",
          "value_name": "TEST"
        ]
      ]
    }
  }

  test("seller central catalog optin category confirm") {
    "/seller_central/catalog/optin/category/confirm"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      categorization_flow_successful = true
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN"
      attribute_id = "COLOR"
      task_id = "product_comparator"
      attribute_values = [
        [
          "name": "test",
          "id": "TEST",
          "value_id": "123",
          "value_name": "TEST"
        ]
      ]
    }
  }

  test("seller central catalog optin product problem show") {
    "/seller_central/catalog/optin/product_problem/show"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
    }
  }

  test("seller central catalog optin product problem return") {
    "/seller_central/catalog/optin/product_problem/return"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
    }
  }

  test("seller central catalog optin product problem confirm") {
    "/seller_central/catalog/optin/product_problem/confirm"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
      reason = "OTHER"
    }
  }

  test("seller central catalog optin item plus card show") {
    "/seller_central/catalog/optin/item_plus_card/show"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
    }
  }

  test("seller central catalog optin item plus card show") {
    "/seller_central/catalog/optin/item_plus_card/return"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
    }
  }

  test("seller central catalog optin item plus card confirm") {
    "/seller_central/catalog/optin/item_plus_card/confirm"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
      reason = "OTHER"
    }
  }

  test("seller central catalog optin invoice confirm") {
    "/seller_central/catalog/optin/invoice/confirm"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      categorization_flow_successful = true
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      task_id = "invoice"
      to = "https://www.mercadolibre.com.ar"
      from = "congrats_page"
    }
  }

  test("seller central catalog optin page view") {
    "/seller_central/catalog/optin/category_breadcrumb/mount"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      categorization_flow_successful = true
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN"
      attribute_id = "COLOR"
      attribute_values = [
        [
          "name": "test",
          "id": "TEST",
          "value_id": "123",
          "value_name": "TEST"
        ]
      ]
    }
  }

  test("seller central catalog optin page view") {
    "/seller_central/catalog/optin/category_breadcrumb/update"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      categorization_flow_successful = true
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN"
      attribute_id = "COLOR"
      attribute_values = [
              [
                      "name": "test",
                      "id": "TEST",
                      "value_id": "123",
                      "value_name": "TEST"
              ]
      ]
    }
  }

  test("seller central catalog optin product resume card showed"){
    "/seller_central/catalog/optin/product_bullet_resume/show"(platform: "/web", type: TrackType.Event){
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN"
      attribute_id = "COLOR"
      attribute_values = [
              [
                      "name": "test",
                      "id": "TEST",
                      "value_id": "123",
                      "value_name": "TEST"
              ]
      ]
      product_title = "Iphone X"
    }
  }

   test("seller central catalog optin product v0 resume card showed"){
    "/seller_central/catalog/optin/v0_product_bullet_resume/show"(platform: "/web", type: TrackType.Event){
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN_V0_PRODUCT"
      attribute_id = "COLOR"
      attribute_values = [
              [
                      "name": "test",
                      "id": "TEST",
                      "value_id": "123",
                      "value_name": "TEST"
              ]
      ]
      product_title = "Iphone X"
    }
  }

  test("seller central catalog invalid product page view") {
    "/seller_central/catalog/optin/invalid_product"(platform: "/web", type: TrackType.View) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN"
    }
  }

  test("seller central catalog congrats page view") {
    "/seller_central/catalog/optin/congrats"(platform: "/web", type: TrackType.View) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN"
    }
  }

  test("seller central catalog optin_moderated page view") {
    "/seller_central/catalog/optin/optin_moderated"(platform: "/web", type: TrackType.View) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "NONE"
      list_mode = "OPTIN"
    }
  }

    test("seller central catalog optin product comparator view") {
    "/seller_central/catalog/optin/optin_moderated/product_comparator/show"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      categorization_flow_successful = true
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
    }
  }

  test("seller central catalog optin product comparator confirm") {
    "/seller_central/catalog/optin/optin_moderated/product_comparator/confirm"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      categorization_flow_successful = true
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN"
      attribute_id = "COLOR"
      task_id = "product_comparator"
      attribute_values = [
        [
          "name": "test",
          "id": "TEST",
          "value_id": "123",
          "value_name": "TEST"
        ]
      ]
    }
  }

  test("seller central catalog optin category confirm") {
    "/seller_central/catalog/optin/optin_moderated/category/confirm"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      categorization_flow_successful = true
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN"
      attribute_id = "COLOR"
      task_id = "product_comparator"
      attribute_values = [
        [
          "name": "test",
          "id": "TEST",
          "value_id": "123",
          "value_name": "TEST"
        ]
      ]
    }
  }

  test("seller central catalog optin product problem show") {
    "/seller_central/catalog/optin/optin_moderated/product_problem/show"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
    }
  }

  test("seller central catalog optin product problem return") {
    "/seller_central/catalog/optin/optin_moderated/product_problem/return"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
    }
  }

  test("seller central catalog optin product problem confirm") {
    "/seller_central/catalog/optin/optin_moderated/product_problem/confirm"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
      reason = "OTHER"
    }
  }

  test("seller central catalog optin invoice confirm") {
    "/seller_central/catalog/optin/optin_moderated/invoice/confirm"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      categorization_flow_successful = true
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      task_id = "invoice"
      to = "https://www.mercadolibre.com.ar"
      from = "congrats_page"
    }
  }

  test("seller central catalog optin item plus card show") {
    "/seller_central/catalog/optin/optin_moderated/item_plus_card/show"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
    }
  }

  test("seller central catalog optin item plus card return") {
    "/seller_central/catalog/optin/optin_moderated/item_plus_card/return"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
    }
  }

  test("seller central catalog optin item plus card confirm") {
    "/seller_central/catalog/optin/optin_moderated/item_plus_card/confirm"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
      reason = "OTHER"
    }
  }

  test("seller central catalog optin page view") {
    "/seller_central/catalog/optin/optin_moderated/category_breadcrumb/mount"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN"
      attribute_id = "COLOR"
      attribute_values = [
              [
                      "name": "test",
                      "id": "TEST",
                      "value_id": "123",
                      "value_name": "TEST"
              ]
      ]
    }
  }

  test("seller central catalog optin page view") {
    "/seller_central/catalog/optin/optin_moderated/category_breadcrumb/update"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN"
      attribute_id = "COLOR"
      attribute_values = [
              [
                      "name": "test",
                      "id": "TEST",
                      "value_id": "123",
                      "value_name": "TEST"
              ]
      ]
    }
  }

  test("seller central catalog optin moderated product resume card showed"){
    "/seller_central/catalog/optin/optin_moderated/product_bullet_resume/show"(platform: "/web", type: TrackType.Event){
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN"
      attribute_id = "COLOR"
      attribute_values = [
              [
                      "name": "test",
                      "id": "TEST",
                      "value_id": "123",
                      "value_name": "TEST"
              ]
      ]
      product_title = "Iphone X"
    }
  }

  test("seller central catalog optin moderated product resume card showed"){
    "/seller_central/catalog/optin/optin_moderated/v0_product_bullet_resume/show"(platform: "/web", type: TrackType.Event){
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN_V0_PRODUCT"
      attribute_id = "COLOR"
      attribute_values = [
              [
                      "name": "test",
                      "id": "TEST",
                      "value_id": "123",
                      "value_name": "TEST"
              ]
      ]
      product_title = "Iphone X"
    }
  }

 test("seller central show leave suggesiton task "){
    "/seller_central/catalog/optin/leave_suggestion/show"(platform: "/web", type: TrackType.View) {
      reputation_level= "yellow"
      moderated = "moderated"
      has_variations = true
      original_catalog_product_id = "MLA1055"
      selected_catalog_product_id = "MLA1055"
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      has_variations_already_opt_in = true
      opt_in_item_id = "MLA234567"
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA390784"
      variation_id = 1234567
      rejected_products = ["MLA1055"]
      seller_profile = "ADVANCED"
      invalid_product_cause = "NONE"
      list_mode = "OPTIN"
    }
  }

 test("seller central confirm leave suggestion task") {
    "/seller_central/catalog/optin/leave_suggestion/confirm"(platform: "/web", type: TrackType.View) {
      reputation_level= "yellow"
      moderated = "moderated"
      has_variations = true
      original_catalog_product_id = "MLA1055"
      selected_catalog_product_id = "MLA1055"
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      has_variations_already_opt_in = true
      opt_in_item_id = "MLA234567"
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA390784"
      variation_id = 1234567
      rejected_products = ["MLA1055"]
      seller_profile = "ADVANCED"
      invalid_product_cause = "NONE"
      value = "MLA123"
      list_mode = "OPTIN"
    }
  }

  test("seller central show catalog decision task ") {
    "/seller_central/catalog/optin/catalog_decision/show"(platform: "/web", type: TrackType.View) {
      reputation_level= "yellow"
      moderated = "moderated"
      has_variations = true
      original_catalog_product_id = "MLA1055"
      selected_catalog_product_id = "MLA1055"
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      has_variations_already_opt_in = true
      opt_in_item_id = "MLA234567"
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA390784"
      variation_id = 1234567
      rejected_products = ["MLA1055"]
      seller_profile = "ADVANCED"
      invalid_product_cause = "NONE"
      list_mode = "OPTIN"
    }
  }

   test("seller central confirm catalog decision task ") {
    "/seller_central/catalog/optin/catalog_decision/confirm"(platform: "/web", type: TrackType.View) {
      reputation_level= "yellow"
      moderated = "moderated"
      has_variations = true
      original_catalog_product_id = "MLA1055"
      selected_catalog_product_id = "MLA1055"
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      has_variations_already_opt_in = true
      opt_in_item_id = "MLA234567"
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA390784"
      variation_id = 1234567
      rejected_products = ["MLA1055"]
      seller_profile = "ADVANCED"
      invalid_product_cause = "NONE"
      list_mode = "OPTIN"
      value = "option_a"
    }
  }

test("seller central show leave suggestion task - optin moderated") {
    "/seller_central/catalog/optin/optin_moderated/leave_suggestion/show"(platform: "/web", type: TrackType.View) {
      reputation_level= "yellow"
      moderated = "moderated"
      has_variations = true
      original_catalog_product_id = "MLA1055"
      selected_catalog_product_id = "MLA1055"
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      has_variations_already_opt_in = true
      opt_in_item_id = "MLA234567"
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA390784"
      variation_id = 1234567
      rejected_products = ["MLA1055"]
      seller_profile = "ADVANCED"
      invalid_product_cause = "NONE"
      list_mode = "OPTIN"
    }
  }

test("seller central confirm leave suggestion task - optin moderated") {
    "/seller_central/catalog/optin/optin_moderated/leave_suggestion/confirm"(platform: "/web", type: TrackType.View) {
      reputation_level= "yellow"
      moderated = "moderated"
      has_variations = true
      original_catalog_product_id = "MLA1055"
      selected_catalog_product_id = "MLA1055"
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      has_variations_already_opt_in = true
      opt_in_item_id = "MLA234567"
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA390784"
      variation_id = 1234567
      rejected_products = ["MLA1055"]
      seller_profile = "ADVANCED"
      invalid_product_cause = "NONE"
      value = "MLA123"
      list_mode = "OPTIN"
    }
  }

  test("seller central show catalog decision task - optin moderated ") {
    "/seller_central/catalog/optin/optin_moderated/catalog_decision/show"(platform: "/web", type: TrackType.View) {
      reputation_level= "yellow"
      moderated = "moderated"
      has_variations = true
      original_catalog_product_id = "MLA1055"
      selected_catalog_product_id = "MLA1055"
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      has_variations_already_opt_in = true
      opt_in_item_id = "MLA234567"
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA390784"
      variation_id = 1234567
      rejected_products = ["MLA1055"]
      seller_profile = "ADVANCED"
      invalid_product_cause = "NONE"
      list_mode = "OPTIN"
    }
  }

  test("seller central confirm catalog decision task - optin moderated") {
    "/seller_central/catalog/optin/optin_moderated/catalog_decision/confirm"(platform: "/web", type: TrackType.View) {
      reputation_level= "yellow"
      moderated = "moderated"
      has_variations = true
      original_catalog_product_id = "MLA1055"
      selected_catalog_product_id = "MLA1055"
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      has_variations_already_opt_in = true
      opt_in_item_id = "MLA234567"
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA390784"
      variation_id = 1234567
      rejected_products = ["MLA1055"]
      seller_profile = "ADVANCED"
      invalid_product_cause = "NONE"
      value = "MLA123"
      list_mode = "OPTIN"
    }
  }

  test("seller central catalog optin_moderated congrats page view") {
    "/seller_central/catalog/optin/optin_moderated/congrats"(platform: "/web", type: TrackType.View) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      moderated = "moderated"
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "NONE"
      list_mode = "OPTIN"
    }
  }

  test("seller central catalog optin item_plus page view") {
    "/seller_central/catalog/optin/item_plus"(platform: "/web", type: TrackType.View) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      moderated = "moderated"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "NONE"
      list_mode = "OPTIN"
    }
  }

  test("seller central catalog optin product comparator view") {
    "/seller_central/catalog/optin/item_plus/product_comparator/show"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      categorization_flow_successful = true
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
    }
  }

  test("seller central catalog optin product comparator confirm") {
    "/seller_central/catalog/optin/item_plus/product_comparator/confirm"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      categorization_flow_successful = true
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN"
      attribute_id = "COLOR"
      task_id = "product_comparator"
      attribute_values = [
        [
          "name": "test",
          "id": "TEST",
          "value_id": "123",
          "value_name": "TEST"
        ]
      ]
    }
  }

  test("seller central catalog optin category confirm") {
    "/seller_central/catalog/optin/item_plus/category/confirm"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      categorization_flow_successful = true
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      list_mode = "OPTIN"
      attribute_id = "COLOR"
      task_id = "product_comparator"
      attribute_values = [
        [
          "name": "test",
          "id": "TEST",
          "value_id": "123",
          "value_name": "TEST"
        ]
      ]
    }
  }

  test("seller central catalog optin product problem show") {
    "/seller_central/catalog/optin/item_plus/product_problem/show"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
    }
  }

  test("seller central catalog optin product problem return") {
    "/seller_central/catalog/optin/item_plus/product_problem/return"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
    }
  }

  test("seller central catalog optin product problem confirm") {
    "/seller_central/catalog/optin/item_plus/product_problem/confirm"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
      reason = "OTHER"
    }
  }

  test("seller central catalog optin item plus card show") {
    "/seller_central/catalog/optin/item_plus/item_plus_card/show"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
    }
  }

  test("seller central catalog optin item plus card show") {
    "/seller_central/catalog/optin/item_plus/item_plus_card/return"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
    }
  }

  test("seller central catalog optin item plus card confirm") {
    "/seller_central/catalog/optin/item_plus/item_plus_card/confirm"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
      reason = "OTHER"
    }
  }

  test("seller central catalog optin invoice confirm") {
    "/seller_central/catalog/optin/item_plus/invoice/confirm"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      categorization_flow_successful = true
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      task_id = "invoice"
      to = "https://www.mercadolibre.com.ar"
      from = "congrats_page"
    }
  }

  test("seller central catalog optin page view") {
    "/seller_central/catalog/optin/item_plus/category_breadcrumb/mount"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      moderated = "moderated"
      list_mode = "OPTIN"
      attribute_id = "COLOR"
      attribute_values = [
              [
                      "name": "test",
                      "id": "TEST",
                      "value_id": "123",
                      "value_name": "TEST"
              ]
      ]
    }
  }

  test("seller central catalog optin page view") {
    "/seller_central/catalog/optin/item_plus/category_breadcrumb/update"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      moderated = "moderated"
      list_mode = "OPTIN"
      attribute_id = "COLOR"
      attribute_values = [
              [
                      "name": "test",
                      "id": "TEST",
                      "value_id": "123",
                      "value_name": "TEST"
              ]
      ]
    }
  }

  test("seller central catalog optin item_plus congrats page view") {
    "/seller_central/catalog/optin/item_plus/congrats"(platform: "/web", type: TrackType.View) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      moderated = "moderated"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "NONE"
      list_mode = "OPTIN"
    }
  }

  test("seller central catalog optin confirm card event") {
    "/seller_central/catalog/optin/confirm"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      task_id = "product_picker"
      to = "MLA1074"
    }
  }

  test("seller central catalog optin Click on any primary action button") {
    "/seller_central/catalog/optin/congrats/redirect"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      task_id = "button"
      to = "https://www.mercadolibre.com.ar/publicaciones/MLA850809023/modificar/387581743-update-4339aff8b69c/product_detail"
      from = "congrats_page"
    }
  }

  test("seller central catalog optin Click on any secondary action link") {
    "/seller_central/catalog/optin/congrats/redirect"(platform: "/web", type: TrackType.Event) {
      item_id = "MLA123"
      session_id = "123-product_optin-abc123"
      category_id = "MLA390784"
      category_domain = "MLA-FRAGRANCES"
      original_catalog_product_id = "MLA1055"
      variation_id = 1234567
      has_variations_already_opt_in = true
      rejected_products = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
      task_id = "link"
      to = "https://www.mercadolibre.com.ar/publicaciones/listado?filters=BUYBOX_STATUS"
      from = "congrats_page"
    }
  }

  test("seller central catalog optin other product problem page view") {
    "/seller_central/catalog/optin/other_product_problem"(platform: "/web", type: TrackType.View) {
      reputation_level = "5_green"
      moderated = "true"
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = null
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-39de2f6b6b49"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
      list_mode = "OPTIN"
    }
  }

  test("seller central catalog optin other product problem") {
    "/seller_central/catalog/optin/other_product_problem/product_problem_description_task/confirm"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = true
      rejected_products = []
      has_variations = true
      original_catalog_product_id = "MLA7979515"
      selected_catalog_product_id = false
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA1055"
      variation_id = 49478478975
      seller_profile = "INTERMEDIATE"
      invalid_product_cause = null
      product_problem_reason = "text"
    }
  }

  // + Test for seller-central prodcut suggestion

  test("seller-central catalog suggestion suggest view") {
    "/seller_central/catalog/suggestion/suggest"(platform: "/web", type: TrackType.View) {
      reputation_level = "5_green"
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      seller_segment = "MEDIUM_SELLERS_III"
      user_type = "real_estate_agency"
      seller_profile = "INTERMEDIATE"
      category_domain = "MLA-CELLPHONES"
      catalog_product_id = "MLA15149561"
    }
  }

  test("seller-central catalog suggestion sent suggestion event") {
    "/seller_central/catalog/suggestion/suggest/sent_suggestion"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      seller_segment = "MEDIUM_SELLERS_III"
      user_type = "real_estate_agency"
      seller_profile = "INTERMEDIATE"
      category_domain = "MLA-CELLPHONES"
      catalog_product_id = "MLA15149561"
    }
  }

  test("seller-central catalog sent invalid suggestion event") {
    "/seller_central/catalog/suggestion/suggest/invalid_suggestion"(platform: "/web", type: TrackType.View) {
      reputation_level = "5_green"
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      seller_segment = "MEDIUM_SELLERS_III"
      user_type = "real_estate_agency"
      seller_profile = "INTERMEDIATE"
      category_domain = "MLA-CELLPHONES"
      catalog_product_id = "MLA15149561"
    }
  }

  test("seller-central catalog suggestion congrats view") {
    "/seller_central/catalog/suggestion/congrats"(platform: "/web", type: TrackType.View) {
      reputation_level = "5_green"
      item_id = "MLA835425554"
      session_id = "474103756-product_optin-104b09b1a800"
      seller_segment = "MEDIUM_SELLERS_III"
      user_type = "real_estate_agency"
      seller_profile = "INTERMEDIATE"
      category_domain = "MLA-CELLPHONES"
      catalog_product_id = "MLA15149561"
    }
  }

  // - Test for seller-central prodcut suggestion





// --------------------------------------------------------------------------------
// TRACKS Seller central - Productization
// --------------------------------------------------------------------------------

  test("seller central productization page view") {
    "/seller_central/catalog/productization"(platform: "/web", type: TrackType.View) {
      list_mode = "PRODUCTIZATION"
      reputation_level = "yellow"
      moderated = false
      has_variations = false
      original_catalog_product_id = "MLA15793959"
      selected_catalog_product_id = "MLA15793958"
      item_id = "MLA123"
      item_type = "product"
      session_id = "123-productization-abc123"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA390784"
      variation_id = null
      rejected_products = ["MLA886745340:MLA15793959"]
      seller_profile = "ADVANCED"
      invalid_product_cause = null
    }
  }

  test("seller central reproductization page view") {
    "/seller_central/catalog/productization"(platform: "/web", type: TrackType.View) {
      list_mode = "PRODUCTIZATION"
      reputation_level = "yellow"
      moderated = false
      has_variations = false
      original_catalog_product_id = "MLA15793959"
      selected_catalog_product_id = "MLA15793958"
      item_id = "MLA123"
      item_type = "associated_products"
      session_id = "123-productization-abc123"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA390784"
      variation_id = null
      rejected_products = ["MLA886745340:MLA15793959"]
      seller_profile = "ADVANCED"
      invalid_product_cause = null
    }
  }

  test("seller central productization product finder bar confirmation") {
    "/seller_central/catalog/productization/products_finder_bar/confirm"(platform: "/web", type: TrackType.View) {
      reputation_level = "yellow"
      moderated = false
      has_variations = false
      original_catalog_product_id = "MLA15793959"
      selected_catalog_product_id = "MLA15793958"
      item_id = "MLA123"
      item_type = "product"
      session_id = "123-productization-abc123"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA390784"
      variation_id = null
      rejected_products = ["MLA886745340:MLA15793959"]
      seller_profile = "ADVANCED"
      invalid_product_cause = null
      task_id = "product_finder_bar"
    }
  }

  test("seller central productization product finder update") {
    "/seller_central/catalog/productization/products_finder/update"(platform: "/web", type: TrackType.View) {
      reputation_level = "yellow"
      moderated = false
      has_variations = false
      original_catalog_product_id = "MLA15793959"
      selected_catalog_product_id = "MLA15793958"
      item_id = "MLA123"
      item_type = "product"
      session_id = "123-productization-abc123"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA390784"
      variation_id = null
      rejected_products = ["MLA886745340:MLA15793959"]
      seller_profile = "ADVANCED"
      invalid_product_cause = null
    }
  }

  test("seller central productization product finder product selection") {
    "/seller_central/catalog/productization/products_finder/product_selection"(platform: "/web", type: TrackType.View) {
      reputation_level = "yellow"
      moderated = false
      has_variations = false
      original_catalog_product_id = "MLA15793959"
      selected_catalog_product_id = "MLA15793958"
      item_id = "MLA123"
      item_type = "product"
      session_id = "123-productization-abc123"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA390784"
      variation_id = null
      rejected_products = ["MLA886745340:MLA15793959"]
      seller_profile = "ADVANCED"
      invalid_product_cause = null
    }
  }

  test("seller central productization product bullet resume") {
    "/seller_central/catalog/productization/product_bullet_resume/show"(platform: "/web", type: TrackType.View) {
      list_mode = "PRODUCTIZATION"
      reputation_level = "yellow"
      moderated = false
      has_variations = false
      original_catalog_product_id = "MLA15793959"
      selected_catalog_product_id = "MLA15793958"
      item_id = "MLA123"
      item_type = "product"
      session_id = "123-productization-abc123"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA390784"
      variation_id = null
      rejected_products = ["MLA886745340:MLA15793959"]
      seller_profile = "ADVANCED"
      invalid_product_cause = null
      categorization_flow_successful = null
      attribute_id = "BRAND"
      attribute_values = [
        [
          "name": "test",
          "id": "TEST",
          "value_id": "123",
          "value_name": "TEST"
        ]
      ]
      product_title= "iphone X 64 GB NEGRO"
    }
  }

  test("seller central productization category confirm") {
    "/seller_central/catalog/productization/category/confirm"(platform: "/web", type: TrackType.Event) {
      list_mode = "PRODUCTIZATION"
      reputation_level = "yellow"
      moderated = false
      has_variations = false
      original_catalog_product_id = "MLA15793959"
      selected_catalog_product_id = "MLA15793958"
      item_id = "MLA123"
      item_type = "product"
      session_id = "123-productization-abc123"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA390784"
      variation_id = null
      rejected_products = ["MLA886745340:MLA15793959"]
      seller_profile = "ADVANCED"
      invalid_product_cause = null
      categorization_flow_successful = null
      attribute_id = "BRAND"
      attribute_values = [
        [
          "name": "test",
          "id": "TEST",
          "value_id": "123",
          "value_name": "TEST"
        ]
      ]
      task_id = "category"
    }
  }

  test("seller central productization category confirm when PDP item has one relation with a marketplace item") {
    "/seller_central/catalog/productization/category/confirm"(platform: "/web", type: TrackType.Event) {
      list_mode = "PRODUCTIZATION"
      reputation_level = "yellow"
      moderated = false
      has_variations = false
      original_catalog_product_id = "MLA15793959"
      selected_catalog_product_id = "MLA15793958"
      item_id = "MLA123"
      item_type = "associated_default"
      session_id = "123-productization-abc123"
      has_variations_already_opt_in = false
      opt_in_item_id = null
      domain_id = "MLA-CELLPHONES"
      category_id = "MLA390784"
      variation_id = null
      rejected_products = ["MLA886745340:MLA15793959"]
      seller_profile = "ADVANCED"
      invalid_product_cause = null
      categorization_flow_successful = null
      attribute_id = "BRAND"
      attribute_values = [
              [
                      "name": "test",
                      "id": "TEST",
                      "value_id": "123",
                      "value_name": "TEST"
              ]
      ]
      task_id = "category"
    }
  }


  // --------------------------------------------------------------------------------
  // TRACKS Seller central - Promotions
  // --------------------------------------------------------------------------------

  test("Seller Central Promotions - View event sending original promotion data"){
    "/seller_central/promotions"(platform: "/web", type: TrackType.View){
      original_promotion = [
              start_date: "2020-08-01T00:00:00",
              finish_date: "2020-08-01T23:59:59.999999999",
              seller_id: 472118157,
              item_id: "MLA870917274",
              price: 25500,
              list_price: 30000,
              prime_price: null,
              status: "pending",
              type: "price_discount",
              initial_orders: null,
              total_orders: 0,
              last_updated: "2020-07-30T20:00:37.787Z",
              created_date: "2020-07-30T20:00:37.787Z",
              involved_stock: null,
              discount_delta: null,
      ]
    }

    "/seller_central/promotions/actions"(platform: "/web", type: TrackType.Event){
      action = "SAVE_PROMOTION"
      promotion = [
              site_time_offset: 0,
              start_date: "2019-09-18T03:00:00.000Z",
              finish_date: "2019-10-05T02:59:00.000Z",
              state: "started",
              is_highlight: false,
              price: 500,
              prime_price: 400,
              list_price: 1000,
              error_price: null,
              error_prime: null,
              input_price: "500",
              input_prime_price: "400",
              type: "price_discount",
      ]
      promotion_duration = 17
    }

    // TESTS FOR NEW PATHS
    "/seller_central/promotions/list"(platform: "/web", type: TrackType.View){
      original_promotion = []
      original_lightning = []
      original_dod = [
              start_date: "2020-08-01T00:00:00",
              finish_date: "2020-08-01T23:59:59.999999999",
              seller_id: 472118157,
              item_id: "MLA870917274",
              price: 25500,
              list_price: 30000,
              prime_price: null,
              status: "pending",
              type: "deal_of_the_day",
              initial_orders: null,
              total_orders: 0,
              last_updated: "2020-07-30T20:00:37.787Z",
              created_date: "2020-07-30T20:00:37.787Z",
              involved_stock: 20,
              discount_delta: 0.05,
      ]
      context: "CREATE"
    }

    "/seller_central/promotions/list/confirm"(platform: "/web", type: TrackType.Event){
      action = "CONFIRM"
      promotion = [
              site_time_offset: 0,
              start_date: "2019-09-18T03:00:00.000Z",
              finish_date: "2019-10-05T02:59:00.000Z",
              state: "started",
              is_highlight: false,
              price: 500,
              prime_price: 400,
              list_price: 1000,
              error_price: null,
              error_prime: null,
              input_price: "500",
              input_prime_price: "400",
              type: "price_discount",
      ]
      promotion_duration = 17
      origin = "listing"
    }

    "/seller_central/promotions/list/update"(platform: "/web", type: TrackType.Event){
      action = "CONFIRM"
      promotion = [
              site_time_offset: 0,
              start_date: "2019-09-18T03:00:00.000Z",
              finish_date: "2019-10-05T02:59:00.000Z",
              state: "started",
              is_highlight: false,
              price: 500,
              prime_price: 400,
              list_price: 1000,
              error_price: null,
              error_prime: null,
              input_price: "500",
              input_prime_price: "400",
              type: "price_discount",
      ]
      promotion_duration = 17
      origin = "listing"
    }

    "/seller_central/promotions/list/delete"(platform: "/web", type: TrackType.Event){
      action = "DELETE"
      promotion = [
              site_time_offset: 0,
              start_date: "2019-09-18T03:00:00.000Z",
              finish_date: "2019-10-05T02:59:00.000Z",
              state: "started",
              is_highlight: false,
              price: 500,
              prime_price: 400,
              list_price: 1000,
              error_price: null,
              error_prime: null,
              input_price: "500",
              input_prime_price: "400",
              type: "price_discount",
      ]
      promotion_duration = 17
      origin = "listing"
    }

    "/seller_central/promotions/list/error"(platform: "/web", type: TrackType.Event){
      action = "CONFIRM"
      promotion = [
              site_time_offset: 0,
              start_date: "2019-09-18T03:00:00.000Z",
              finish_date: "2019-10-05T02:59:00.000Z",
              state: "started",
              is_highlight: false,
              price: 500,
              prime_price: 400,
              list_price: 1000,
              error_price: null,
              error_prime: null,
              input_price: "500",
              input_prime_price: "400",
              type: "price_discount",
      ]
      promotion_duration = 17
      error = "net::ERR_ABORTED 404"
      origin = "listing"
    }

    "/seller_central/promotions/list/actions"(platform: "/web", type: TrackType.Event){
      action = "DISABLE"
      context = "CREATE"
    }
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central Listing
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("seller central listing main page") {
    "/seller_central/promotions/list"(platform: "/", type: TrackType.View) {}
  }

  test("seller central listing promos render") {
    "/seller_central/promotions/list/info"(platform: "/", type: TrackType.Event) {
      candidates = ["CANDIDATE_DOD"]
    }
  }

  test("seller central listing promos render with no candidates") {
    "/seller_central/promotions/list/info"(platform: "/", type: TrackType.Event) {
      candidates = []
    }
  }

  test("seller central listing promos render with card filter") {
    "/seller_central/promotions/cards"(platform: "/", type: TrackType.Event) {}
  }

  test("seller central listing promos card filter action with elegible item") {
    "/seller_central/promotions/cards/apply"(platform: "/", type: TrackType.Event) {
      type = "lightning"
      total_actives_items = 0
      eligible_items = [
              {
                item_id = "MLB1861379548"
                meli__pct = 5.0
                seller_pct = 10.0
              }
      ]
      total_eligible_items = 1
      type = "meli_campaign"
      promo_id = "P-MLB430009"
      actives_items = []
    }
  }

  test("seller central listing promos card filter action with slide and pads") {
    "/seller_central/promotions/cards/apply"(platform: "/", type: TrackType.Event) {
      type = "lightning"
      slide = 2
      total_actives_items = 0
      eligible_items = [
              {
                item_id = "MLB1861379548"
                meli__pct = 5.0
                seller_pct = 10.0
                adv_pct = 18.5
              }
      ]
      total_eligible_items = 1
      type = "meli_campaign"
      promo_id = "P-MLB430009"
      actives_items = []
    }
  }

  test("seller central listing promos render with onboarding") {
    "/seller_central/promotions/onboarding"(platform: "/", type: TrackType.Event) {}
  }

  test("seller central listing promos render with onboarding action") {
    "/seller_central/promotions/onboarding/action"(platform: "/", type: TrackType.Event) {
      action = "start"
    }
  }

  test("seller central listing action") {
    "/seller_central/promotions/action"(platform: "/", type: TrackType.Event) {
      action_id = "CREATE_MARKETPLACE_CAMPAIGN"
      item_id = "MLB1834796998"
      meli_pct = 2.0
      promo_id = "P-MLB412005"
      seller_pct = 18.0
    }
  }
  test("seller central listing action with pads") {
    "/seller_central/promotions/action"(platform: "/", type: TrackType.Event) {
      action_id = "CREATE_MARKETPLACE_CAMPAIGN"
      item_id = "MLB1834796998"
      meli_pct = 2.0
      promo_id = "P-MLB412005"
      seller_pct = 18.0
      adv_pct = 18.5
    }
  }

  test("seller central listing action confirm ") {
    "/seller_central/promotions/action/confirm"(platform: "/", type: TrackType.Event) {
      action_id = "CREATE_MARKETPLACE_CAMPAIGN"
      item_id = "MLM896434921"
      promo_id = "P-MLM412004"
    }
  }

  test("seller central listing promos error action") {
    "/seller_central/promotions/action/error"(platform: "/", type: TrackType.Event) {
      action_id = "CREATE"
    }
  }
  test("seller central listing promos tooltip pads executed") {
    "/seller_central/promotions/action/tooltip_adv"(platform: "/", type: TrackType.Event) {
      item_id = "MLM896427737"
      promo_id = "P-MLM412004"
    }
  }

  test("seller central listing secondary_actions") {
    "/seller_central/promotions/list/secondary_actions"(platform: "/", type: TrackType.Event) {}
  }

  test("seller central listing filters view") {
    "/seller_central/promotions/filters"(platform: "/mobile", type: TrackType.View) {}
  }

  test("seller central listing filters view") {
    "/seller_central/promotions/filters/applied"(platform: "/", type: TrackType.Event) {
      checkedFilters = ["inactive", "premium"]
    }
  }

  test("seller central listing filters actions and search") {
    "/seller_central/promotions/filters/action"(platform: "/", type: TrackType.Event) {
      action = "apply"
    }
    "/seller_central/promotions/filters/action"(platform: "/", type: TrackType.Event) {
      action = "clear"
    }

    "/seller_central/promotions/search"(platform: "/", type: TrackType.Event) {}
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller Central Questions
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("Seller central render Questions") {
    "/seller_central/questions"(platform: "/", type: TrackType.View) {}
  }

  test("Seller central render Item Questions") {
    "/seller_central/questions/item"(platform: "/", type: TrackType.View) {}
  }

  test("Seller central response Questions") {
    "/seller_central/questions/response"(platform: "/", type: TrackType.Event) {
      seller_profile = "NEWBIE"
      seller_segment = "MEDIUM_SELLERS_III"
      question_id = "789456"
      item_id = "MLC529811446"
      site_id = "MCO"
      item_status = "inactivo"
      question_date_created = "2020-11-08T05:00:00"
      question_date_action = "2020-11-08T10:00:00"
    }
  }


  test("Seller central response Questions webmobile") {
    "/seller_central/questions/response"(platform: "/web", type: TrackType.Event) {
      seller_profile = "NEWBIE"
      seller_segment = "MEDIUM_SELLERS_III"
      question_id = "789456"
      item_id = "MLC529811446"
      site_id = "MCO"
      item_status = "inactivo"
      question_date_created = "2020-11-08T05:00:00"
      question_date_action = "2020-11-08T10:00:00"
    }
  }

  test("Seller central delete Questions") {
    "/seller_central/questions/delete"(platform: "/", type: TrackType.Event) {
      seller_profile = "NEWBIE"
      seller_segment = "MEDIUM_SELLERS_III"
      question_id = "789456"
      item_id = "MLC529811446"
      site_id = "MCO"
      item_status = "inactivo"
      question_date_created = "2020-11-08T05:00:00"
      question_date_action = "2020-11-08T10:00:00"
    }
  }

  test("Seller central denunciation Questions") {
    "/seller_central/questions/denunciation"(platform: "/", type: TrackType.Event) {
      seller_profile = "NEWBIE"
      seller_segment = "MEDIUM_SELLERS_III"
      question_id = "789456"
      item_id = "MLC529811446"
      site_id = "MCO"
      item_status = "inactivo"
      question_date_created = "2020-11-08T05:00:00"
      question_date_action = "2020-11-08T10:00:00"
    }
  }

  test("Seller central block buyer Questions") {
    "/seller_central/questions/block_buyer"(platform: "/", type: TrackType.Event) {
      seller_profile = "NEWBIE"
      seller_segment = "MEDIUM_SELLERS_III"
      question_id = "789456"
      item_id = "MLC529811446"
      site_id = "MCO"
      item_status = "inactivo"
      question_date_created = "2020-11-08T05:00:00"
      question_date_action = "2020-11-08T10:00:00"
    }
  }

  test("Seller central open modal advice Questions") {
    "/seller_central/questions/modal_advice"(platform: "/", type: TrackType.Event) {
      seller_profile = "NEWBIE"
      seller_segment = "MEDIUM_SELLERS_III"
      question_date_action = "2020-11-08T10:00:00"
    }
  }

   test("Seller central open modal stock Questions") {
    "/seller_central/questions/modal_stock"(platform: "/", type: TrackType.Event) {
      seller_profile = "NEWBIE"
      seller_segment = "MEDIUM_SELLERS_III"
      question_date_action = "2020-11-08T10:30:00"
    }
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller Central Buyer Questions
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("Seller central buyer question listing Items and its Questions") {
    "/seller_central/buyer_questions"(platform: "/", type: TrackType.View) {}
  }

  test("Seller central buyer question listing one item with its questions") {
    "/seller_central/buyer_questions/list_by_item"(platform: "/", type: TrackType.View) {}
  }

  test("Seller central buyer question listing one item with the question selected") {
    "/seller_central/buyer_questions/list_by_question"(platform: "/", type: TrackType.View) {}
  }

  test("Seller central buyer question attempt to create a new question") {
    "/seller_central/buyer_questions/make_question_intention"(platform: "/", type: TrackType.Event) {
      item_id = "MLA529811412"
    }
  }

  test("Seller central buyer question deleting all questions from the item") {
    "/seller_central/buyer_questions/delete_all_questions"(platform: "/", type: TrackType.Event) {
      item_id = "MLA529811412"
      failed = false
    }
  }

  test("Seller central buyer question attempt to delete all questions from the item") {
    "/seller_central/buyer_questions/delete_all_questions_intention"(platform: "/", type: TrackType.Event) {
      item_id = "MLA529811412"
    }
  }

  test("Seller central buyer question submit a denouncement based on any answer") {
    "/seller_central/buyer_questions/denounce_answer"(platform: "/", type: TrackType.Event) {
      item_id = "MLA529811412"
      question_id = 12345621
      failed = false
    }
  }

  test("Seller central buyer question attempt to submit a denouncement based on any answer") {
    "/seller_central/buyer_questions/denounce_answer_intention"(platform: "/", type: TrackType.Event) {
      item_id = "MLA529811412"
      question_id = 12345621
    }
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS SYI v4 - RealEstate - Modificar
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("SYI V4 RE Modificar - seller central render description card") {
    "/seller_central/modify/detail/title_and_description/show"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "real_estate"
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central - confirm  description card") {
    "/seller_central/modify/detail/title_and_description/confirm"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "real_estate"
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central - render detail technical_specifications card") {
    "/seller_central/modify/detail/technical_specifications/show"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "real_estate"
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central - confirm detail technical_specifications card") {
    "/seller_central/modify/detail/technical_specifications/confirm"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "real_estate"
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central - render seller_contact card") {
    "/seller_central/modify/detail/seller_contact/show"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "real_estate"
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central-  render  change_category card") {
    "/seller_central/modify/detail/change_category/show"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "real_estate"
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central - render detail instant_pay_listings card") {
    "/seller_central/modify/detail/instant_pay_listings_info/show"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "real_estate"
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central - confirm instant_pay_listings_info card") {
    "/seller_central/modify/detail/instant_pay_listings_info/confirm"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "real_estate"
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central - render listing_highlight_package_info card ") {
    "/seller_central/modify/detail/listing_highlight_package_info/show"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "real_estate"
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central - confirm listing_highlight_package_info card") {
    "/seller_central/modify/detail/listing_highlight_package_info/confirm"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "real_estate"
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central - confirm quick_edit_standard card ") {
    "/seller_central/modify/detail/quick_edit_standard/confirm"(platform: "/", type: TrackType.Event) {
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "real_estate"
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central - try quick_edit_standard photos intent") {
    "/seller_central/modify/detail/quick_edit_standard/intent"(platform: "/", type: TrackType.Event) {
      business = 'classified'
      category_domain = "MLC-HOUSES_FOR_RENT"
      category_id = "MLM27420"
      category_path = ["MLC1459", "MLC1466", "MLC6406", "MLC183184"]
      item_id = "MLC534088624"
      item_type = "default"
      listing_type = "silver"
      platform = "pi"
      seller_profile = "NEWBIE"
      seller_reputation = "NO_REPUTATION"
      session_id = "516954617-updateres-b5e3bdf5d0d7"
      vertical = "real_estate"
      intent_type = "pictures_upload"
      pictures_info = [
        [
          "width": 100,
          "height": 500,
          "size": 2048,
          "format": "image/jpeg",
          "valid": true
        ],
        [
          "width": 800,
          "height": 600,
          "size": 1024,
          "format": "image/png",
          "valid": false
        ],
        [
          "width": 800,
          "height": 600,
          "valid": false
        ],
      ]
    }
  }

  test("SYI V4 RE Modificar - seller central - render  video") {
    "/seller_central/modify/detail/video/show"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "real_estate"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"

    }
  }

  test("SYI V4 RE Modificar - seller central - confirm video") {
    "/seller_central/modify/detail/video/confirm"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "realEstate"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central - render location card") {
    "/seller_central/modify/detail/location/show"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "realEstate"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central - confirm  location card") {
    "/seller_central/modify/detail/location/confirm"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "realEstate"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central - render detail") {
    "/seller_central/modify/detail"(platform: "/", type: TrackType.View) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "realEstate"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central - confirm  seller_contact card") {
    "/seller_central/modify/detail/seller_contact/confirm"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "realEstate"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central- render instant_pay_listings card ") {
    "/seller_central/modify/detail/instant_pay_listings/show"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "realEstate"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }

  test("SYI V4 RE Modificar - seller central - confirm instant_pay_listings card") {
    "  /seller_central/modify/detail/instant_pay_listings/confirm"(platform: "/", type: TrackType.Event) {
      seller_reputation = "NO_REPUTATION"
      category_id = "MLC183186"
      category_domain = "MLC-APARTMENTS_FOR_RENT"
      item_id = "MLC529811446"
      item_type = "default"
      seller_profile = "NEWBIE"
      listing_type = "gold"
      session_id = "571359341-updateres-7c63145ea255"
      vertical = "realEstate"
      category_path = ["MLC1459", "MLC1472", "MLC6407", "MLC183186"]
      user_type = "real_estate_agency"
      business = "classified"
      platform = "pi"
    }
  }


  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller Central Optinator New Listing
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("Seller Central - Optinator - New Listing - Optined item") {
    "/seller_central/optinator/new_listing/end"(platform: "/web", type: TrackType.Event) {
      flow = "new_listing"
      domain_id = "MLA-CELLPHONES"
      item_mk_id = "MLA899085795"
      item_mk_status = "active"
      item_mk_sub_status = []
      item_mk_tags = ["test_item", "immediate_payment", "cart_eligible"]
      processing_data = [
              item_cat_id: "MLA899086757",
              catalog_product_id: "MLA15149561",
              match_type: "SELLER",
              safe_match: true,
              is_eligible: false,
              eligibility_status: "NOT_ELIGIBLE",
              eligibility_reason: "cellphone_not_unlocked",
              status: "success",
              is_already_optined: false
      ]
      variations = [
              [
                      id: "67914990318",
                      processing_data: [
                              item_cat_id: "MLA896825803",
                              catalog_product_id: "MLA10205674",
                              match_type: "SELLER",
                              safe_match: true,
                              is_eligible: false,
                              eligibility_status: "NOT_ELIGIBLE",
                              eligibility_reason: "cellphone_not_unlocked",
                              status: "success",
                              is_already_optined: false
                      ]
              ]
      ]
    }
  }


  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller Central - SYI ME1 Config
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("SYI ME1 Config - Hub page view") {
    "/seller_central/me1_transport_config/hub"(platform: "/web", type: TrackType.View) {}
  }

  test("SYI ME1 Config - Upload page view") {
    "/seller_central/me1_transport_config/upload"(platform: "/web", type: TrackType.View) {}
  }

  test("SYI ME1 Config - Congrats page view") {
    "/seller_central/me1_transport_config/congrats"(platform: "/web", type: TrackType.View) {}
  }

  test("SYI ME1 Config - User uploads files") {
    "/seller_central/me1_transport_config/upload/upload_files"(platform: "/web", type: TrackType.Event){
      number_of_files = 2
    }
  }

  test("SYI ME1 Config - User exceed characters limit in comment when uploading files") {
    "/seller_central/me1_transport_config/upload/exceed_characters_limit"(platform: "/web", type: TrackType.Event){}
  }


  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller Central - Split Orders
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("Split Orders - render splitter/prepare page view") {
    "/seller_central/split_orders/splitter/prepare"(platform: "/web", type: TrackType.View) {}
  }

  test("Split Orders - user clicks Continue button in splitter/prepare page view") {
    "/seller_central/split_orders/splitter/prepare/action"(platform: "/web", type: TrackType.Event) {
      action_id = "PREPARE"
      user_type = "NORMAL"
      seller_profile = "ADVANCED"
      reputation_level = "5_green"
      orders_quantity = 2
      orders = [
          [
              id: 1234,
              quantity: 4
          ],
          [
              id: 2345,
              quantity: 1
          ]
      ]
      selected_orders = [
          [
              id: 1234,
              quantity: 2
          ],
          [
              id: 2345,
              quantity: 1
          ]
      ]
      has_variations = true
      categories = [
          [
              category_id: "MLM27420",
              domain_id: "MLM-CARS_AND_VANS"
          ],
          [
              category_id: "MLA390784",
              domain_id: "MLA-CELLPHONES"
          ]
      ]
      logistic_type = "XD_DROP_OFF"
    }
  }

  test("Split Orders - render splitter/split page view") {
    "/seller_central/split_orders/splitter/split"(platform: "/web", type: TrackType.View) {}
  }

  test("Split Orders - user clicks Continue button in splitter/split page view") {
    "/seller_central/split_orders/splitter/split/action"(platform: "/web", type: TrackType.Event) {
      action_id = "SPLIT"
      user_type = "NORMAL"
      seller_profile = "ADVANCED"
      reputation_level = "5_green"
      orders_quantity = 1
      orders = [
          [
              id: 1234,
              quantity: 4
          ]
      ]
      packs = [
          [
              orders: [
                  [
                      id: 1234,
                      quantity: 2
                  ]
              ]
          ],
          [
              orders: [
                  [
                      id: 1234,
                      quantity: 2
                  ]
              ]
          ]
      ]
      has_variations = false
      categories = [
          [
              category_id: "MLM27420",
              domain_id: "MLM-CARS_AND_VANS"
          ]
      ]
      logistic_type = "DROP_OFF"
    }
  }

  test("Split Orders - render congrats page view") {
    "/seller_central/split_orders/congrats"(platform: "/web", type: TrackType.View) {}
  }


  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central Products Landing
  //------------------------------------------------------------------------------------------------------------------------------------------------------
  test("Products Landing - Home code help") {
      "/seller_central/products_landing/home/code_help"(platform: "/web", type: TrackType.Event) {}
  }

  test("Products Landing - Home show") {
      "/seller_central/products_landing/home/show"(platform: "/web", type: TrackType.View) {}
  }

  test("Products Landing - Results code help") {
      "/seller_central/products_landing/search/code_help"(platform: "/web", type: TrackType.Event) {}
  }

  test("Products Landing - Results show with PRODUCT_NAME SUGGESTED_PRODUCTS") {
      "/seller_central/products_landing/search/show"(platform: "/web", type: TrackType.View) {
        query = "Samsung"
        query_type = "PRODUCT_NAME"
        result_type = "SUGGESTED_PRODUCTS"
        results = [
            "MLA10335295",
            "MLA10335296",
            "MLA10335297",
            "MLA10335298",
            "MLA10663535",
            "MLA10663536",
            "MLA10663537",
            "MLA10663538",
            "MLA10663539",
            "MLA10663540"
        ]
        paging = [
            total: 100,
            limit: 10,
            offset: 0
        ]
        selected_filters = [
            [
                id: "LINE",
                name: "Linea",
                value_id: "249991",
                value_name: "Galaxy S"
            ],
            [
                id: "BRAND",
                name: "Marca",
                value_id: "206",
                value_name: "Samsung"
            ]
        ]
        selected_filters_quantity = 2
      }
  }

  test("Products Landing - Results show with PRODUCT_NAME SUGGESTED_DOMAINS") {
      "/seller_central/products_landing/search/show"(platform: "/web", type: TrackType.View) {
        query = "Samsung"
        query_type = "PRODUCT_NAME"
        result_type = "SUGGESTED_DOMAINS"
        results = [
            "MLA-CELLPONES",
            "MLA-TELEPHONES",
        ]
        paging = [
            total: 2,
            limit: 10,
            offset: 0
        ]
        selected_filters = []
        selected_filters_quantity = 0
      }
  }


  test("Products Landing - Results show GTIN") {
      "/seller_central/products_landing/search/show"(platform: "/web", type: TrackType.View) {
        query = "9912342124"
        query_type = "GTIN"
        result_type = "PRODUCT_ONE_SHOT"
        results = [
            "MLA10335295"
        ]
        paging = [
            total: 1,
            limit: 10,
            offset: 0
        ]
        selected_filters = []
        selected_filters_quantity = 0
      }
  }

  test("Products Landing - Results show with PRODUCT_ID") {
      "/seller_central/products_landing/search/show"(platform: "/web", type: TrackType.View) {
        query = "MLA10335295"
        query_type = "PRODUCT_ID"
        result_type = "PRODUCT_ONE_SHOT"
        results = [
            "MLA10335295"
        ]
        paging = [
            total: 100,
            limit: 1,
            offset: 0
        ]
        selected_filters = []
        selected_filters_quantity = 0
      }
  }

  test("Products Landing - Publish poroduct row") {
      "/seller_central/products_landing/search/publish"(platform: "/web", type: TrackType.Event) {
        query = "Samsung"
        query_type = "PRODUCT_NAME"
        result_type = "SUGGESTED_PRODUCTS"
        results = [
            "MLA10335295",
            "MLA10335296",
            "MLA10335297",
            "MLA10335298",
            "MLA10663535",
            "MLA10663536",
            "MLA10663537",
            "MLA10663538",
            "MLA10663539",
            "MLA10663540"
        ]
        paging = [
            total: 100,
            limit: 10,
            offset: 0
        ]
        selected_filters = [
            [
                id: "LINE",
                name: "Linea",
                value_id: "249991",
                value_name: "Galaxy S"
            ],
            [
                id: "BRAND",
                name: "Marca",
                value_id: "206",
                value_name: "Samsung"
            ]
        ]
        selected_filters_quantity = 2
        row_index = 1
        catalog_product_id = "MLA10335296"
      }
  }

  test("Products Landing - Copied code poroduct row") {
      "/seller_central/products_landing/search/copied_code"(platform: "/web", type: TrackType.Event) {
        query = "Samsung"
        query_type = "PRODUCT_NAME"
        result_type = "SUGGESTED_PRODUCTS"
        results = [
            "MLA10335295",
            "MLA10335296",
            "MLA10335297",
            "MLA10335298",
            "MLA10663535",
            "MLA10663536",
            "MLA10663537",
            "MLA10663538",
            "MLA10663539",
            "MLA10663540"
        ]
        paging = [
            total: 100,
            limit: 10,
            offset: 0
        ]
        selected_filters = [
            [
                id: "LINE",
                name: "Linea",
                value_id: "249991",
                value_name: "Galaxy S"
            ],
            [
                id: "BRAND",
                name: "Marca",
                value_id: "206",
                value_name: "Samsung"
            ]
        ]
        selected_filters_quantity = 2
        row_index = 0
        catalog_product_id = "MLA10335295"
      }
  }

  test("Products Landing - Tech spec show poroduct row") {
      "/seller_central/products_landing/search/tech_spec_show"(platform: "/web", type: TrackType.Event) {
        query = "Samsung"
        query_type = "PRODUCT_NAME"
        result_type = "SUGGESTED_PRODUCTS"
        results = [
            "MLA10335295",
            "MLA10335296",
            "MLA10335297",
            "MLA10335298",
            "MLA10663535",
            "MLA10663536",
            "MLA10663537",
            "MLA10663538",
            "MLA10663539",
            "MLA10663540"
        ]
        paging = [
            total: 100,
            limit: 10,
            offset: 0
        ]
        selected_filters = [
            [
                id: "LINE",
                name: "Linea",
                value_id: "249991",
                value_name: "Galaxy S"
            ],
            [
                id: "BRAND",
                name: "Marca",
                value_id: "206",
                value_name: "Samsung"
            ]
        ]
        selected_filters_quantity = 2
        row_index = 0
        catalog_product_id = "MLA10335295"
      }
  }

  test("Products Landing - Publish product resume") {
      "/seller_central/products_landing/search/publish"(platform: "/web", type: TrackType.Event) {
        query = "Samsung Galaxy s s10 negro prisma"
        query_type = "PRODUCT_NAME"
        result_type = "SUGGESTED_PRODUCTS"
        results = [
            "MLA10335295"
        ]
        paging = [
            total: 1,
            limit: 10,
            offset: 0
        ]
        selected_filters = []
        selected_filters_quantity = 0
        row_index = null
        catalog_product_id = "MLA10335295"
      }
  }

  test("Products Landing - Copied product row") {
    "/seller_central/products_landing/search/copied_product_row"(platform: "/web", type: TrackType.Event) {
      query = "Samsung Galaxy s s10 negro prisma"
      query_type = "PRODUCT_NAME"
      result_type = "SUGGESTED_PRODUCTS"
      results = [
          "MLA10335295"
      ]
      paging = [
          total: 1,
          limit: 10,
          offset: 0
      ]
      selected_filters = []
      selected_filters_quantity = 0
      row_index = 0
      catalog_product_id = "MLA10335295"
    }
  }

  test("Products Landing - Copied products multiples") {
    "/seller_central/products_landing/search/copied_products"(platform: "/web", type: TrackType.Event) {
      query = "Samsung Galaxy s s10 negro prisma"
      query_type = "PRODUCT_NAME"
      result_type = "SUGGESTED_PRODUCTS"
      results = [
          "MLA10335295"
      ]
      paging = [
          total: 1,
          limit: 10,
          offset: 0
      ]
      selected_filters = []
      selected_filters_quantity = 0
      copied_products = [[
          catalog_product_id: "MLA10335295",
          row_index: 0
        ],
        [
          catalog_product_id: "MLA10335296",
          row_index: 1
        ],
        [
          catalog_product_id: "MLA10335297",
           row_index: 2
        ]
      ]
    }
  }
}
