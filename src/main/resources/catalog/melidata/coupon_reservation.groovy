package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

  initiative="1322"

  def campaign = objectSchemaDefinitions {
    id(required: true, type: PropertyType.Numeric, description: "Cupon id")
    image(required: true, type: PropertyType.String, description: "Cupon image url")
    title(required: true, type: PropertyType.String, description: "Cupon image title")
    amount(required: true, type: PropertyType.String, description: "Cupon amount")
    phase(required: false, type: PropertyType.String, description: "Cupon phase")
    available(required: false, type: PropertyType.Boolean, description: "Cupon availability") 
  }
  def status = objectSchemaDefinitions {
    id(required: true, type: PropertyType.Numeric, description: "Cupon id")
    available(required: true, type: PropertyType.Boolean, description: "Cupon amount_footer")
  }

  "/instore/coupon_reservation" (platform: "/", isAbstract: true) {
    event_id(required: false, type: PropertyType.Numeric, description: "Event id")
    session_id(required: true, type: PropertyType.String, description: "Session identifier")
    traffic_from(required: false, values:["push", "modal", "banner", "pom", "mp"], type: PropertyType.String, description: "Traffic identifier")
  }

  // ----- reservation stage -----
  "/instore/coupon_reservation/reservation" (platform: "/", type: TrackType.View) {
    coupons(required: false, type: PropertyType.ArrayList(PropertyType.Map(campaign)), description: "The cupons list to show")
  }

  "/instore/coupon_reservation/reservation/reserve" (platform: "/", type: TrackType.Event) {}
  "/instore/coupon_reservation/reservation/how_to_use" (platform: "/", type: TrackType.Event) {}

  "/instore/coupon_reservation/reservation/is_waiting/how_to_use" (platform: "/", type: TrackType.Event) {}
  "/instore/coupon_reservation/reservation/is_waiting/find_stores" (platform: "/", type: TrackType.Event) {}

  "/instore/coupon_reservation/reservation/is_waiting/ftu/how_to_use/tyc" (platform: "/", type: TrackType.Event) {}

  "/instore/coupon_reservation/reservation/coupon_detail" (platform: "/", type: TrackType.Event) {}

  "/instore/coupon_reservation/reservation/congrats" (platform: "/", type: TrackType.Event) {
    result(required: true, values:["success", "error", "sold_out"], type: PropertyType.String, description: "The congrats result: success, error, or sold_out")
  }

  "/instore/coupon_reservation/reservation/congrats/back" (platform: "/", type: TrackType.Event) {}

  "/instore/coupon_reservation/reservation/congrats/others_discounts" (platform: "/", type: TrackType.Event) {}

  // -----------------------------

  // ----- exchange stage -----
  "/instore/coupon_reservation/redeem" (platform: "/", type: TrackType.View) {
    coupons_status(required: false, type: PropertyType.ArrayList(PropertyType.Map(status)), description: "The cupons list to show") 
  }

  "/instore/coupon_reservation/redeem/how_to_use" (platform: "/", type: TrackType.Event) {}

  "/instore/coupon_reservation/redeem/find_stores" (platform: "/", type: TrackType.Event) {}

  "/instore/coupon_reservation/redeem/coupon_detail" (platform: "/", type: TrackType.Event) {}

  // --------------------------
  
  // ----- FTU pages -----
  "/instore/coupon_reservation/ftu" (platform: "/", type: TrackType.View, isAbstract: true) {}
  
  // -- Reservation KYC --
  "/instore/coupon_reservation/ftu/know_your_customer" (platform: "/", type: TrackType.View) {}

  "/instore/coupon_reservation/ftu/know_your_customer/start" (platform: "/", type: TrackType.Event) {}
  // -- Reservation Reserved --
  "/instore/coupon_reservation/ftu/reserved" (platform: "/", type: TrackType.View) {}

  "/instore/coupon_reservation/ftu/reserved/agree" (platform: "/", type: TrackType.Event) {}
  // -- Reservation Sold out --
  "/instore/coupon_reservation/ftu/sold_out" (platform: "/", type: TrackType.View) {}

  "/instore/coupon_reservation/ftu/sold_out/more_discounts" (platform: "/", type: TrackType.Event) {}

  "/instore/coupon_reservation/ftu/sold_out/go_home" (platform: "/", type: TrackType.Event) {}

  // -- Exchange How to use --
  "/instore/coupon_reservation/ftu/how_to" (platform: "/", type: TrackType.View) {}

  "/instore/coupon_reservation/ftu/how_to/pay_qr" (platform: "/", type: TrackType.Event) {}

  "/instore/coupon_reservation/ftu/how_to/tyc" (platform: "/", type: TrackType.Event) {}

  // -- Exchange Used --
  "/instore/coupon_reservation/ftu/used" (platform: "/", type: TrackType.View) {}

  "/instore/coupon_reservation/ftu/used/more_discounts" (platform: "/", type: TrackType.Event) {}

  "/instore/coupon_reservation/ftu/used/go_home" (platform: "/", type: TrackType.Event) {}

  // --------------------------
  "/instore/coupon_reservation/error" (platform: "/", type: TrackType.View) {}

  "/instore/coupon_reservation/error/exit" (platform: "/", type: TrackType.Event) {}
}