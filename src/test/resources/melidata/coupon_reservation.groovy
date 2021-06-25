package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  defaultBusiness = "mercadopago"

  // ----- Reservation stage -----
  test("Reservation view") {
    "/instore/coupon_reservation/reservation" (platform: "/", type: TrackType.View) {
      // coupons = [
      //   [
      //     id = 2,
      //     image = "https://mobile.mercadolibre.com/remote_resources/image/banner-cross-link?density =3X",
      //     title = "Domino\u0027s",
      //     description = "\u003cstrong\u003e1\u003c/strong\u003e Pizza Mediana",
      //     price_header = "A solo",
      //     price = "\$ 18",
      //     available = true,
      //     phase = "reservation"
      //   ],
      //   [
      //     id = 3,
      //     image = "https://mobile.mercadolibre.com/remote_resources/image/banner-cross-link?density =3X",
      //     title = "Domino\u0027s",
      //     description = "\u003cstrong\u003e1\u003c/strong\u003e Pizza Mediana",
      //     price_header = "A solo",
      //     price = "\$ 18",
      //     available = false,
      //     phase = "reservation"
      //   ],
      // ]
    }
  }

  test("Reservation event cta") {
    "/instore/coupon_reservation/reservation/cta" (platform: "/", type: TrackType.Event) {
      type = "reserve"
    }
  }
  test("Reservation event cta") {
    "/instore/coupon_reservation/reservation/cta" (platform: "/", type: TrackType.Event) {
      type = "tyc"
    }
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
  // -----------------------------

  // ----- exchange stage -----
  test("Exchange view") {
    "/instore/coupon_reservation/exchange" (platform: "/", type: TrackType.View) {
      // used_campaigns_status = [
      //   [brand_name = "Starbucks", cupon_status = false],
      //   [brand_name = "Burger King", cupon_status = false],
      //   [brand_name = "Domino’s", cupon_status = true],
      //   [brand_name = "Benavides", cupon_status = true],
      // ]
    }
  }

  test("Exchange event cta") {
    "/instore/coupon_reservation/exchange/cta" (platform: "/", type: TrackType.Event) {
      type = "tyc"
    }
  }
  test("Exchange event cta") {
    "/instore/coupon_reservation/exchange/cta" (platform: "/", type: TrackType.Event) {
      type = "how_to_use"
    }
  }
  // --------------------------

  // ----- FTU pages -----
  // -- Reservation KYC --
  test("FTU KYC view") {
    "/instore/coupon_reservation/ftu/kyc" (platform: "/", type: TrackType.View) {}
  }
  test("FTU KYC event cta") {
    "/instore/coupon_reservation/ftu/kyc/cta" (platform: "/", type: TrackType.Event) {
      action = "start_kyc"
    }
  }
  // -- Reservation Reserved --
  test("FTU Reserved view") {
    "/instore/coupon_reservation/ftu/reserved" (platform: "/", type: TrackType.View) {}
  }
  test("FTU Reserved event cta") {
    "/instore/coupon_reservation/ftu/reserved/cta" (platform: "/", type: TrackType.Event) {
      action = "agree"
    }
  }
  // -- Reservation Sold out --
  test("FTU Sold out view") {
    "/instore/coupon_reservation/ftu/sold_out" (platform: "/", type: TrackType.View) {}
  }
  test("FTU Sold out event cta") {
    "/instore/coupon_reservation/ftu/sold_out/cta" (platform: "/", type: TrackType.Event) {
      action = "more_discounts"
    }
  }
  test("FTU Sold out event cta") {
    "/instore/coupon_reservation/ftu/sold_out/cta" (platform: "/", type: TrackType.Event) {
      action = "home"
    }
  }
  // -- Exchange How to use --
  test("FTU How tu use view") {
    "/instore/coupon_reservation/ftu/how_to_use" (platform: "/", type: TrackType.View) {}
  }
  test("FTU How tu use event cta") {
    "/instore/coupon_reservation/ftu/how_to_use/cta" (platform: "/", type: TrackType.Event) {
      action = "pay_qr"
    }
  }
  test("FTU How tu use event cta") {
    "/instore/coupon_reservation/ftu/how_to_use/cta" (platform: "/", type: TrackType.Event) {
      action = "find_stores"
    }
  }
  // -- Exchange Used --
  test("FTU Used view") {
    "/instore/coupon_reservation/ftu/used" (platform: "/", type: TrackType.View) {}
  }
  test("FTU Used event cta") {
    "/instore/coupon_reservation/ftu/used/cta" (platform: "/", type: TrackType.Event) {
      action = "more_discounts"
    }
  }
  test("FTU Used event cta") {
    "/instore/coupon_reservation/ftu/used/cta" (platform: "/", type: TrackType.Event) {
      action = "home"
    }
  }

}
