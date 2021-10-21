package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
  defaultBusiness = "mercadolibre"

  test("seller central listing main page") {
    "/seller_central/listings/list"(platform: "/", type: TrackType.View) {}
  }
  test("seller central listing main page") {
    "/seller_central/listings/list"(platform: "/", type: TrackType.View) {
      view_id = "listing"
      sub_view_id = "mshops"
    }
  }

  test("seller central listing secondary actions") {
    "/seller_central/listings/row/secondary_actions"(platform: "/", type: TrackType.Event) {
      sub_view_id = "marketplace"
      item_id = "MLB32452342"
    }

    "/seller_central/listings/row/secondary_actions/selected"(platform: "/", type: TrackType.Event) {
      action_id = "MODIFY"
      sub_view_id = "marketplace"
      item_id = "MLB32452342"
    }
  }

  test("seller central listing filters") {
    "/seller_central/listings/filters/applied"(platform: "/", type: TrackType.Event) {
      checkedFilters = ["inactive", "premium"]
      page = 1
      filters = ["CHANNEL_ONLY_MARKETPLACE","CHANNEL_MARKETPLACE_MSHOPS"]
      sort = "finish_last"
    }
     "/seller_central/listings/filters/applied"(platform: "/", type: TrackType.Event) {
      page = 2
      filters = ["CHANNEL_ONLY_MARKETPLACE","CHANNEL_MARKETPLACE_MSHOPS"]
      sort = "finish_last"
    }
    "/seller_central/listings/filters/applied"(platform: "/", type: TrackType.Event) {
      page = 3
      filters = ["CHANNEL_ONLY_MARKETPLACE","CHANNEL_MARKETPLACE_MSHOPS"]
      sort = "finish_last"
      origin = "filters_modal"
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

  test("seller central listing sort") {
    "/seller_central/listings/sort"(platform: "/", type: TrackType.Event) {
      id = "stock_remaining_weeks_asc"
      view_id = "fulfillment"
    }
  }

  test("seller central list to bulk editor") {
    "/seller_central/listings/editor"(platform: "/", type: TrackType.Event) {}
  }

  test("Track empty state items") {
    "/seller_central/listings/row_empty_state"(platform: "/", type: TrackType.Event){
        sub_view_id = "mshops"
        items = [
            [
              item_id: "MLA10335297",
              reason: "VENDER_EN_MERCADOLIBRE"
            ],[
              item_id: "MLA10335297",
              reason: "VENDER_EN_MERCADOLIBRE"
            ],[
              item_id: "MLA10335297",
              reason: "VENDER_EN_MERCADOLIBRE"
            ]
        ]
    }
  }

  test("Click publish item in MShops from empty state row") {
    "/seller_central/listings/activate_row"(platform: "/", type: TrackType.Event){
      item_id = "MLA10335295"
      sub_view_id = "mshops"
      reason = "PUBLICAR_EN_MI_MERCADO_SHOP"
    }
  }


  test("Show MShops inactive channel card"){
    "/seller_central/listings/inactive_channel"(platform: "/", type: TrackType.Event){
      sub_view_id = "mshops"
      action = "render"
    }

    "/seller_central/listings/inactive_channel"(platform: "/", type: TrackType.Event){
      sub_view_id = "markeplace"
      action = "render"
    }

    "/seller_central/listings/inactive_channel"(platform: "/", type: TrackType.Event){
      sub_view_id = "markeplace"
      action = "click"
    }

    "/seller_central/listings/inactive_channel"(platform: "/", type: TrackType.Event){
      sub_view_id = "mshops"
      action = "click"
    }
  }

  test("Change sub view"){
    "/seller_central/listings/change_sub_view"(platform: "/", type: TrackType.Event){
      selected_view = "marketplace"
      type = "optin"
      url = "https://mishop.com"
    }
  }

  test("Seller central comparison tooltip"){
    "/seller_central/listings/row/comparison_tooltip"(platform: "/", type: TrackType.Event){
      open_time = 2.3
      loading_time = 1782.9313
      tooltip_type = "success"
      item_id = "MLA10335295"
      item_state = "inactive"
      sub_view_id = "marketplace"
    }

    "/seller_central/listings/row/comparison_tooltip"(platform: "/", type: TrackType.Event){
      open_time = 3.4
      loading_time = 1782.9313
      tooltip_type = "abort"
      item_id = "MLA10335295"
      item_state = "active"
      sub_view_id = "mshops"
    }

    "/seller_central/listings/row/comparison_tooltip_empty"(platform: "/", type: TrackType.Event){
      action = "show"
      activation_channel = "marketplace"
      sub_view_id = "mshops"
      item_id = "MLA10335295"
      empty_type = "empty_channel"
    }

    "/seller_central/listings/row/comparison_tooltip_empty"(platform: "/", type: TrackType.Event){
      action = "click"
      activation_channel = "mshops"
      sub_view_id = "marketplace"
      item_id = "MLA10335295"
      empty_type = "empty_channel"
    }

    "/seller_central/listings/row/comparison_tooltip_empty"(platform: "/", type: TrackType.Event){
      action = "click"
      activation_channel = "mshops"
      sub_view_id = "mshops"
      item_id = "MLA10335295"
      empty_type = "activate_mshops"
    }
  }

  test("/seller_central/listings/row/variations"){
    "/seller_central/listings/row/variations"(platform: "/", type: TrackType.Event){
      action = "show"
      item_id = "MLA10335295"
      sub_view_id = "mshops"
    }

    "/seller_central/listings/row/variations"(platform: "/", type: TrackType.Event){
      action = "hide"
      item_id = "MLA10335295"
      sub_view_id = "marketplace"
    }

    "/seller_central/listings/row/show_variations"(platform: "/", type: TrackType.Event){
      item_id = "MLA10335296"
      success = true
      loading_time = 1582.9313
      variations_loaded = 4
      sub_view_id = "mshops"
    }

    "/seller_central/listings/row/show_variations"(platform: "/", type: TrackType.Event){
      item_id = "MLA10335296"
      success = false
      loading_time = 1582.9313
      variations_loaded = 4
      sub_view_id = "marketplace"
    }
  }

  test("seller central listings row description") {
    "/seller_central/listings/row/item_description"(platform: "/", type: TrackType.Event) {}

    "/seller_central/listings/row/moderation"(platform: "/", type: TrackType.Event) {
      moderation_id = "ID"
    }

    "/seller_central/listings/row/health"(platform: "/", type: TrackType.Event) {
      health_id = "ID"
    }
  }

  test("seller central listings call to actions of row") {
    "/seller_central/listings/row/call_to_actions"(platform: "/", type: TrackType.Event) {
      item = [
        channels: ["marketplace"],
        price: 40322,
        shipping_mode: "self",
        shipping_logistic: "self",
        listing_type: "gold"
      ]
      action_id = "MODIFY_PRICE"
      item_id = "MLA23345252"
      sub_view_id = "marketplace"
    }

     "/seller_central/listings/row/call_to_actions"(platform: "/", type: TrackType.Event) {
      item = [
        channels: ["mshops"],
        price: 51422,
        shipping_mode: "self",
        shipping_logistic: "self",
        listing_type: "gold"
      ]
      action_id = "GO_TO_PROMOTIONS"
      item_id = "MLA23345252"
      sub_view_id = "marketplace"
    }

    "/seller_central/listings/row/call_to_actions"(platform: "/", type: TrackType.Event) {
      item = [
        channels: ["marketplace", "mshops"],
        price: 3364,
        shipping_mode: "self",
        shipping_logistic: "self",
        listing_type: "gold"
      ]
      action_id = "MODIFY_LISTING_TYPE"
      item_id = "MLA23345252"
      sub_view_id = "mshops"
    }

    "/seller_central/listings/row/call_to_actions"(platform: "/", type: TrackType.Event) {
      item = [
        channels: ["marketplace", "mshops"],
        price: 567544,
        shipping_mode: "self",
        shipping_logistic: "self",
        listing_type: "gold"
      ]
      action_id = "UPGRADE_LISTING_TYPE"
      item_id = "MLA23345252"
      sub_view_id = "marketplace"
    }

    "/seller_central/listings/row/call_to_actions"(platform: "/", type: TrackType.Event) {
      item = [
        channels: ["mshops"],
        price: 1345,
        shipping_mode: "self",
        shipping_logistic: "self",
        listing_type: "gold"
      ]
      action_id = "UPGRADE_SHIPPING"
      item_id = "MLA23345252"
      sub_view_id = "mshops"
    }

    "/seller_central/listings/row/call_to_actions"(platform: "/", type: TrackType.Event) {
      item = [
        channels: ["marketplace"],
        price: 89845,
        shipping_mode: "self",
        shipping_logistic: "self",
        listing_type: "gold"
      ]
      action_id = "MODIFY_SHIPPING"
      item_id = "MLA23345252"
      sub_view_id = "mshops"
    }
  }

}