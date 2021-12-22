package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  defaultBusiness = "mercadopago"

  test("Summary view") {
    "/instore/challenge/summary" (platform: "/", type: TrackType.View) {
      session_id = "11"
      suscribed = 4
      not_suscribed = 2
      total_challenges = 6
    }
  }

  test("Summary how to use button") {
    "/instore/challenge/summary/how_to_use" (platform: "/", type: TrackType.View) {
      session_id = "11"
      suscribed = 4
      not_suscribed = 2
      total_challenges = 6
    }
  }

  // ----- Reservation stage -----
  test("Detail view") {
    "/instore/challenge/detail" (platform: "/", type: TrackType.View) {
      challenge_id = "wqejwej1-111"
      session_id = "11"
      user_payments = 2
      challenge_stages = 3
      payments_left = 1
      days_left = 2
      optin_status = "ACCEPTED"
    }
  }

  test("Find_stores button") {
    "/instore/challenge/detail/find_stores" (platform: "/", type: TrackType.Event) {
      challenge_id = "wqejwej1-111"
      session_id = "11"
      user_payments = 2
      challenge_stages = 3
      payments_left = 1
      days_left = 2
      optin_status = "ACCEPTED"
    }
  }

  test("Join button") {
    "/instore/challenge/detail/join/success" (platform: "/", type: TrackType.Event) {
      challenge_id = "wqejwej1-111"
      session_id = "11"
      user_payments = 2
      challenge_stages  = 3
      payments_left = 1
      days_left = 2
      optin_status = "PENDING"
    }
  }
  test("Join button") {
    "/instore/challenge/detail/join/fail" (platform: "/", type: TrackType.Event) {
      challenge_id = "wqejwej1-111"
      session_id = "11"
      user_payments = 0
      challenge_stages = 5
      payments_left = 5
      days_left = 20
      optin_status = "PENDING"
    }
  }
  test("Other_discounts button") {
    "/instore/challenge/detail/other_discounts" (platform: "/", type: TrackType.Event) {
     challenge_id = "wqejwej1-111"
      session_id = "11"
      user_payments = 2
      challenge_stages = 3
      payments_left = 1
      days_left = 2
      optin_status = "ACCEPTED"
    }
  }

  test("Terms and conditions button") {
    "/instore/challenge/detail/terms_and_conditions" (platform: "/", type: TrackType.Event) {
      challenge_id = "wqejwej1-111"
      session_id = "11"
      user_payments = 2
      challenge_stages = 3
      payments_left = 1
      days_left = 2
      optin_status = "ACCEPTED"
    }
  }

  test("Onboarding view") {
    "/instore/challenge/onboarding" (platform: "/", type: TrackType.View) {
      session_id = "11"
      traffic_from = "mercadopago"
    }
  }

  test("Start button") {
    "/instore/challenge/onboarding/start" (platform: "/", type: TrackType.Event) {
      session_id = "11"
      traffic_from = "mercadopago"
    }
  }

  test("Error Page") {
    "/instore/challenge/error" (platform: "/", type: TrackType.View) {
      session_id = "11"
      traffic_from = "mercadopago"
    }
  }
}