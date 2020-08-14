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



  test("seller central listing onboarding view") {
    "/seller_central/listings/onboarding"(platform: "/mobile", type: TrackType.View) {}
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

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central Summary
  //------------------------------------------------------------------------------------------------------------------------------------------------------
  test("Seller central summary view") {
    "/seller_central/summary"(platform: "/web", type: TrackType.View) {}
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

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central Bulk
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("seller central bulk view") {
    "/seller_central/bulk/list"(platform: "/", type: TrackType.View) {}
  }

  test("seller central bulk onboarding") {
    "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
      action = "close"
    }
    "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
      action = "start"
      viewId = "fulfillment"
    }
    "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
      action = "dismiss"
      page = 2
    }
    "/seller_central/bulk/onboarding"(platform: "/", type: TrackType.Event) {
      action = "rollback"
    }
  }

  test("seller central bulk view") {
    "/seller_central/bulk/domain"(platform: "/", type: TrackType.Event) {
      id = "technical_specification"
    }
  }

  test("seller central bulk filters and search") {
    "/seller_central/bulk/filters"(platform: "/", type: TrackType.Event) {
      filters = ["active", "inactive"]
    }
  }

  test("seller central bulk filters and search") {
    "/seller_central/bulk/undo_changes"(platform: "/", type: TrackType.Event) {}
    "/seller_central/bulk/search"(platform: "/", type: TrackType.Event) {}
  }


  test("seller central bulk columns") {
    "/seller_central/bulk/columns"(platform: "/", type: TrackType.Event) {
      columns = ["price", "quantity"]
    }
  }

  test("seller central bulk changes price") {
    "/seller_central/bulk/changes/price"(platform: "/", type: TrackType.Event) {
      oldValue = "20"
      newValue = "25"
      item_id = "MLB341920"
    }
  }

  test("seller central bulk shipping tooltip") {
    "/seller_central/bulk/shipping/tooltip"(platform: "/", type: TrackType.Event) {
      item_id = "MLB341920"
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

    test("seller central open tooltip view") {
    "/seller_central/bulk/open_tooltip"(platform: "/", type: TrackType.View) {}
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central Bulk Offline Cbt
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("seller central offline bulk hub") {
    "/seller_central/bulk/offline/cbt/hub"(platform: "/", type: TrackType.View) {}
  }

  test("seller central offline bulk download") {
    "/seller_central/bulk/offline/cbt/download"(platform: "/", type: TrackType.View) {}
  }

  test("seller central offline bulk upload") {
    "/seller_central/bulk/offline/cbt/upload"(platform: "/", type: TrackType.View) {}
  }



  test("seller central offline bulk download confirm") {
    "/seller_central/bulk/offline/cbt/download/confirm"(platform: "/", type: TrackType.Event) {
      categories = ["Mochilas", "Banquetas", "Bicicletas"]
      filters = ["active", "status"]
      items = 3
    }
  }

  test("seller central offline bulk download congrats") {
    "/seller_central/bulk/offline/cbt/download/congrats"(platform: "/", type: TrackType.View) {
    type = "success"
    }
  }

  test("seller central offline bulk upload congrats") {
    "/seller_central/bulk/offline/cbt/upload/congrats"(platform: "/", type: TrackType.View) {
      type = "failed"
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
  // TRACKS Seller Central BULK Publish
  //------------------------------------------------------------------------------------------------------------------------------------------------------
  test("seller central bulk publish hub view") {
    "/seller_central/bulk/publish/hub"(platform: "/web", type: TrackType.View) {}
  }

  test("seller central bulk publish categories view") {
    "/seller_central/bulk/publish/categories"(platform: "/web", type: TrackType.View) {}
  }

  test("seller central bulk publish upload view") {
    "/seller_central/bulk/publish/upload"(platform: "/web", type: TrackType.View) {}
  }

  test("seller central bulk publish show email") {
    "/seller_central/bulk/publish/upload/show_custom_mail_box"(platform: "/web", type: TrackType.Event) {
      show_custom_mail_box = true
    }
  }

  test("seller central bulk publish send custom email") {
    "/seller_central/bulk/publish/upload/send_custom_mail_box"(platform: "/web", type: TrackType.Event) {
      show_custom_mail_box = true
      custom_mail = false
      invalid_mail = false
    }
  }

  test("seller central bulk publish download congrats view") {
    "/seller_central/bulk/publish/download/congrats"(platform: "/web", type: TrackType.View) {}
  }

  test("seller central bulk publish upload congrats view") {
    "/seller_central/bulk/publish/upload/congrats"(platform: "/web", type: TrackType.View) {}
  }

  test("seller central bulk publish download categories event") {
    "/seller_central/bulk/publish/categories/download_excel"(platform: "/web", type: TrackType.Event) {
      total = 10
      last_published = 5
      most_used = 1
      search_list = 4
      modal = 0
    }
  }

  test("seller central bulk publish show adults modal") {
    "/seller_central/bulk/publish/categories/adult/modal/show"(platform: "/web", type: TrackType.View) {
      adult = false
    }
  }

  test("seller central bulk publish cancel adults modal") {
    "/seller_central/bulk/publish/categories/adult/modal"(platform: "/web", type: TrackType.Event) {
      action = "cancel"
      adult = false
    }
  }

  test("seller central bulk publish confirm adults modal") {
    "/seller_central/bulk/publish/categories/adult/modal"(platform: "/web", type: TrackType.Event) {
      action = "confirm"
      adult = false
    }
  }

  test("seller central bulk publish confirm adult task") {
    "/seller_central/bulk/publish/categories/adult/confirm"(platform: "/web", type: TrackType.Event) {
      adult = true
    }
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

  test("seller central sales list view") {
    "/seller_central/sales/list"(platform: "/", type: TrackType.View) {
        seller_profile = "ADVANCED"
        seller_reputation = "5_green"
        seller_segment = "MEDIUM_SELLERS_III"
        mercado_lider = false
    }
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

  test("seller central sales detail main action") {
    "/seller_central/sales/detail/main_action"(platform: "/mobile", type: TrackType.Event) {
      id = "PRODUCT_DELIVERED"
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
    "/seller_central/sales/fiscal_document/action/secondary"(platform: "/web", type: TrackType.Event) {}
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
  // TRACKS Seller central Catalog Optin
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("seller central catalog optin") {
    "/seller_central/catalog"(platform: "/web", type: TrackType.View) {}
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
      children_catalog_products_ids = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
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
      children_catalog_products_ids = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
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
      children_catalog_products_ids = ["MLA1055"]
      has_variations = true
      seller_profile = "ADVANCED"
      reputation_level= "yellow"
      selected_catalog_product_id = "MLA1055"
      opt_in_item_id = "MLA234567"
      invalid_product_cause = "INVALID_CARRIER"
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
      children_catalog_products_ids = ["MLA1055"]
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
      children_catalog_products_ids = ["MLA1055"]
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
      children_catalog_products_ids = ["MLA1055"]
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

  test("seller central catalog optin product problem confirm") {
    "/seller_central/catalog/optin/product_problem/confirm"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = false
      children_catalog_products_ids = []
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

  test("seller central catalog optin other product problem page view") {
    "/seller_central/catalog/optin/other_product_problem"(platform: "/web", type: TrackType.View) {
      reputation_level = "5_green"
      moderated = "true"
      children_catalog_products_ids = []
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
    }
  }

  test("seller central catalog optin other product problem") {
    "/seller_central/catalog/optin/other_product_problem/product_problem_description_task/confirm"(platform: "/web", type: TrackType.Event) {
      reputation_level = "5_green"
      moderated = true
      children_catalog_products_ids = []
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

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Seller central - Promotions
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("Seller Central Promotions - View event sending original promotion data"){
    "/seller_central/promotions"(platform: "/web", type: TrackType.View){
      original_promotion = [
              id: "MLA808249210",
              seller_id: 450981020,
              buying_mode: "buy_it_now",
              sale_terms: [
                      [
                              id: "LOYALTY_LEVEL_4",
                              value_id: null,
                              value_struct: [
                                      number: 400,
                                      unit: "ARS"
                              ]
                      ],
                      [
                              id: "LOYALTY_LEVEL_5",
                              value_id: null,
                              value_struct: [
                                      number: 400,
                                      unit: "ARS"
                              ]
                      ],
                      [
                              id: "LOYALTY_LEVEL_3",
                              value_id: null,
                              value_struct: [
                                      number: 400,
                                      unit: "ARS"
                              ]
                      ],
                      [
                              id: "LOYALTY_LEVEL_6",
                              value_id: null,
                              value_struct: [
                                      number: 400,
                                      unit: "ARS"
                              ]
                      ]
              ],
              campaigns: [],
              best_offer: null,
              price: 500,
              original_price: 1000,
              promotion: [
                      status: "started",
                      price: 500,
                      start_date: "2019-09-18T03:00:00.000Z",
                      finish_date: "2019-10-05T02:59:00.000Z",
                      list_price: 1000,
                      prime_price: 400
              ],
              visits: 27,
              available_quantity: 97,
              title: "Item De Testeo, Por Favor No Ofertar --kc:off",
              sold_quantity: 3,
              secure_thumbnail: "https://http2.mlstatic.com/resources/frontend/statics/processing-image/1.0.0/I-ES.jpg",
              currency: [
                      id: "ARS",
                      decimal_places: 2,
                      symbol: "\$"
              ],
              tags: [
                      "loyalty_discount_eligible",
                      "test_item",
                      "immediate_payment"
              ],
              validations: [],
              campaign_offers: [
                      [
                              offer_mode: "LONG_TAIL",
                              offer: null,
                              campaign: [
                                      name: "campanianueva",
                                      identifier: "MLA626",
                                      start_date: "2018-10-26T16:10:00.000Z",
                                      finish_date: "2019-12-12T13:17:21.000Z",
                                      dead_line: "2019-03-03T00:57:00.000Z",
                                      type: "discounts",
                                      status: "started",
                                      is_active: false,
                                      is_available: false,
                                      applied_offer: false
                              ]
                      ]
              ]
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
              type: "always_on",
      ]
      promotion_duration = 17
    }

    // TESTS FOR NEW PATHS
    "/seller_central/promotions/list"(platform: "/web", type: TrackType.View){
      original_promotion = [
              id: "MLA808249210",
              seller_id: 450981020,
              buying_mode: "buy_it_now",
              sale_terms: [
                      [
                              id: "LOYALTY_LEVEL_4",
                              value_id: null,
                              value_struct: [
                                      number: 400,
                                      unit: "ARS"
                              ]
                      ],
                      [
                              id: "LOYALTY_LEVEL_5",
                              value_id: null,
                              value_struct: [
                                      number: 400,
                                      unit: "ARS"
                              ]
                      ],
                      [
                              id: "LOYALTY_LEVEL_3",
                              value_id: null,
                              value_struct: [
                                      number: 400,
                                      unit: "ARS"
                              ]
                      ],
                      [
                              id: "LOYALTY_LEVEL_6",
                              value_id: null,
                              value_struct: [
                                      number: 400,
                                      unit: "ARS"
                              ]
                      ]
              ],
              campaigns: [],
              best_offer: null,
              price: 500,
              original_price: 1000,
              promotion: [
                      status: "started",
                      price: 500,
                      start_date: "2019-09-18T03:00:00.000Z",
                      finish_date: "2019-10-05T02:59:00.000Z",
                      list_price: 1000,
                      prime_price: 400
              ],
              visits: 27,
              available_quantity: 97,
              title: "Item De Testeo, Por Favor No Ofertar --kc:off",
              sold_quantity: 3,
              secure_thumbnail: "https://http2.mlstatic.com/resources/frontend/statics/processing-image/1.0.0/I-ES.jpg",
              currency: [
                      id: "ARS",
                      decimal_places: 2,
                      symbol: "\$"
              ],
              tags: [
                      "loyalty_discount_eligible",
                      "test_item",
                      "immediate_payment"
              ],
              validations: [],
              campaign_offers: [
                      [
                              offer_mode: "LONG_TAIL",
                              offer: null,
                              campaign: [
                                      name: "campanianueva",
                                      identifier: "MLA626",
                                      start_date: "2018-10-26T16:10:00.000Z",
                                      finish_date: "2019-12-12T13:17:21.000Z",
                                      dead_line: "2019-03-03T00:57:00.000Z",
                                      type: "discounts",
                                      status: "started",
                                      is_active: false,
                                      is_available: false,
                                      applied_offer: false
                              ]
                      ]
              ]
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
              type: "always_on",
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
              type: "always_on",
      ]
      promotion_duration = 17
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
              type: "always_on",
      ]
      promotion_duration = 17
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
              type: "always_on",
      ]
      promotion_duration = 17
      error = "net::ERR_ABORTED 404"
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

  test("seller central listing action") {
    "/seller_central/promotions/action"(platform: "/", type: TrackType.Event) {
      action_id = "MODIFY"
    }
  }

  test("seller central listing action") {
    "/seller_central/promotions/action/confirm"(platform: "/", type: TrackType.Event) {
      action_id = "MODIFY"
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
}