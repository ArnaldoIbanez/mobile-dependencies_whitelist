package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

  initiative="1218"

  "/instore/coupon_reservation" (platform: "/", isAbstract: true) {
    event_id(required: false, type: PropertyType.Numeric, description: "Event id")
  }

  // ----- reservation stage -----
  "/instore/coupon_reservation/reservation" (platform: "/", type: TrackType.View) {
    coupons(required: true, inheritable: false, type: PropertyType.ArrayList, description: "The cupons list to show")
    id(required: true, inheritable: false, type: PropertyType.Numeric, description: "Cupon id")
    image(required: true, inheritable: false, type: PropertyType.String, description: "Cupon image url")
    title(required: true, inheritable: false, type: PropertyType.String, description: "Cupon image title")
    description(required: false, inheritable: false, type: PropertyType.String, description: "Cupon description")
    amount_header(required: false, inheritable: false, type: PropertyType.String, description: "Cupon amount_header")
    amount(required: true, inheritable: false, type: PropertyType.String, description: "Cupon amount")
    amount_footer(required: false, inheritable: false, type: PropertyType.String, description: "Cupon amount_footer")
  }

  "/instore/coupon_reservation/reservation/cta" (platform: "/", type: TrackType.Event) {
    type(required: true, values:["reserve", "tyc"], type: PropertyType.String, description: "The call to action type")
  }

  "/instore/coupon_reservation/reservation/congrats" (platform: "/", type: TrackType.Event) {
    result(required: true, values:["success", "error", "sold_out"], type: PropertyType.String, description: "The congrats result: success, error, or sold_out")
  }

  "/instore/coupon_reservation/reservation/congrats/back" (platform: "/", type: TrackType.Event) {}

  // -----------------------------

  // ----- exchange stage -----
  "/instore/coupon_reservation/redeem" (platform: "/", type: TrackType.View) {
    coupons_status(required: true, inheritable: false, type: PropertyType.ArrayList, description: "The cupons list to show")
    id(required: true, inheritable: false, type: PropertyType.Numeric, description: "Cupon id")
    available(required: true, inheritable: false, type: PropertyType.Boolean, description: "Cupon amount_footer") 
  }

  "/instore/coupon_reservation/redeem/cta" (platform: "/", type: TrackType.Event) {
    type(required: true, type: PropertyType.String, values:["tyc", "how_to_use"], description: "The call to action type")
  }
  // --------------------------
  
  // ----- FTU pages -----
  "/instore/coupon_reservation/ftu" (platform: "/", type: TrackType.View, isAbstract: true) {}
  
  // -- Reservation KYC --
  "/instore/coupon_reservation/ftu/kyc" (platform: "/", type: TrackType.View) {}

  "/instore/coupon_reservation/ftu/kyc/cta" (platform: "/", type: TrackType.Event) {
    action(required: true, values:["start_kyc"], type: PropertyType.String, description: "The call to action type")
  }
  // -- Reservation Reserved --
  "/instore/coupon_reservation/ftu/reserved" (platform: "/", type: TrackType.View) {}

  "/instore/coupon_reservation/ftu/reserved/cta" (platform: "/", type: TrackType.Event) {
    action(required: true, values:["agree"], type: PropertyType.String, description: "The call to action type")
  }
  // -- Reservation Sold out --
  "/instore/coupon_reservation/ftu/sold_out" (platform: "/", type: TrackType.View) {}

  "/instore/coupon_reservation/ftu/sold_out/cta" (platform: "/", type: TrackType.Event) {
    action(required: true, values:["more_discounts", "home"], type: PropertyType.String, description: "The call to action type")
  }
  // -- Exchange How to use --
  "/instore/coupon_reservation/ftu/how_to" (platform: "/", type: TrackType.View) {}

  "/instore/coupon_reservation/ftu/how_to/cta" (platform: "/", type: TrackType.Event) {
    action(required: true, values:["pay_qr", "find_stores"], type: PropertyType.String, description: "The call to action type")
  }
  // -- Exchange Used --
  "/instore/coupon_reservation/ftu/used" (platform: "/", type: TrackType.View) {}

  "/instore/coupon_reservation/ftu/used/cta" (platform: "/", type: TrackType.Event) {
    action(required: true, values:["more_discounts", "home"], type: PropertyType.String, description: "The call to action type")
  }
  // --------------------------
  "/instore/coupon_reservation/error" (platform: "/", type: TrackType.View) {}

  "/instore/coupon_reservation/error/cta" (platform: "/", type: TrackType.Event) {
    action(required: true, values:["exit"], type: PropertyType.String, description: "The call to action type")
  }
}