package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  defaultBusiness = "mercadopago"

  // ----- Reservation stage -----
  test("Reservation view") {
    "/instore/coupon_reservation/reservation" (platform: "/", type: TrackType.View) {
      event_id = 12333
      coupons = [
        [
          id: 2,
          image: "https://mobile.mercadolibre.com/remote_resources/image/banner-cross-link?density3X",
          title: "Domino\u0027s",
          amount: "\$ 18",
        ],
        [
          id: 3,
          image: "https://mobile.mercadolibre.com/remote_resources/image/banner-cross-link?density3X",
          title: "Domino\u0027s",
          amount: "\$ 18",
        ]
      ]
    }
  }

  test("Reservation event cta") {
    "/instore/coupon_reservation/reservation/reserve" (platform: "/", type: TrackType.Event) {}
  }
  test("Reservation event cta") {
    "/instore/coupon_reservation/reservation/tyc" (platform: "/", type: TrackType.Event) {}
  }
  
  test("Reservation event congrats") {
    "/instore/coupon_reservation/reservation/congrats" (platform: "/", type: TrackType.Event) {
      result = "success"
    }
  }
  test("Reservation event congrats") {
    "/instore/coupon_reservation/reservation/congrats" (platform: "/", type: TrackType.Event) {
      result = "error"
    }
  }
  test("Reservation event congrats") {
    "/instore/coupon_reservation/reservation/congrats" (platform: "/", type: TrackType.Event) {
      result = "sold_out"
    }
  }
  test("Reservation event congrats back") {
    "/instore/coupon_reservation/reservation/congrats/back" (platform: "/", type: TrackType.Event) {
      result = "success"
    }
  }
  test("Reservation event congrats back") {
    "/instore/coupon_reservation/reservation/congrats/others_discounts" (platform: "/", type: TrackType.Event) {
      result = "sold_out"
    }
  }
  // -----------------------------

  // ----- exchange stage -----
  test("Exchange view") {
    "/instore/coupon_reservation/redeem" (platform: "/", type: TrackType.View) {
      coupons_status = [
        [id: 2, available: true],
        [id: 3, available: false]
      ]
    }
  }

  test("Exchange event cta") {
    "/instore/coupon_reservation/redeem/tyc" (platform: "/", type: TrackType.Event) {}
  }
  test("Exchange event cta") {
    "/instore/coupon_reservation/redeem/how_to_use" (platform: "/", type: TrackType.Event) {}
  }
  // --------------------------

  // ----- FTU pages -----
  // -- Reservation KYC --
  test("FTU KYC view") {
    "/instore/coupon_reservation/ftu/know_your_customer" (platform: "/", type: TrackType.View) {}
  }
  test("FTU KYC event cta") {
    "/instore/coupon_reservation/ftu/know_your_customer/start" (platform: "/", type: TrackType.Event) {}
  }
  // -- Reservation Reserved --
  test("FTU Reserved view") {
    "/instore/coupon_reservation/ftu/reserved" (platform: "/", type: TrackType.View) {}
  }
  test("FTU Reserved event cta") {
    "/instore/coupon_reservation/ftu/reserved/agree" (platform: "/", type: TrackType.Event) {}
  }
  // -- Reservation Sold out --
  test("FTU Sold out view") {
    "/instore/coupon_reservation/ftu/sold_out" (platform: "/", type: TrackType.View) {}
  }
  test("FTU Sold out event cta") {
    "/instore/coupon_reservation/ftu/sold_out/more_discounts" (platform: "/", type: TrackType.Event) {}
  }
  test("FTU Sold out event cta") {
    "/instore/coupon_reservation/ftu/sold_out/go_home" (platform: "/", type: TrackType.Event) {}
  }
  // -- Exchange How to use --
  test("FTU How tu use view") {
    "/instore/coupon_reservation/ftu/how_to" (platform: "/", type: TrackType.View) {}
  }
  test("FTU How tu use event cta") {
    "/instore/coupon_reservation/ftu/how_to/pay_qr" (platform: "/", type: TrackType.Event) {}
  }
  test("FTU How tu use event cta") {
    "/instore/coupon_reservation/ftu/how_to/find_stores" (platform: "/", type: TrackType.Event) {}
  }
  // -- Exchange Used --
  test("FTU Used view") {
    "/instore/coupon_reservation/ftu/used" (platform: "/", type: TrackType.View) {}
  }
  test("FTU Used event cta") {
    "/instore/coupon_reservation/ftu/used/more_discounts" (platform: "/", type: TrackType.Event) {}
  }
  test("FTU Used event cta") {
    "/instore/coupon_reservation/ftu/used/go_home" (platform: "/", type: TrackType.Event) {}
  }
  test("error view") {
    "/instore/coupon_reservation/error" (platform: "/", type: TrackType.View) {}
  }
  test("error event cta") {
    "/instore/coupon_reservation/error/exit" (platform: "/", type: TrackType.Event) {}
  }
}