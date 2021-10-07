package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  defaultBusiness = "mercadopago"

  // ----- Reservation stage -----
  test("Summary view") {
    "/instore/challenge/summary" (platform: "/", type: TrackType.View) {
      challenge_id = "wqejwej1-111"
      session_id = "11"
      payment_status = [
        challenge_status : 'ongoing',
        challenge_stages : 5,
        payments : 3
      ]
    }
  }
  test("button find_stores") {
    "/instore/challenge/summary/find_stores" (platform: "/", type: TrackType.Event) {
      session_id = "11"
      challenge_id = "wqejwej1-111"
      payment_status = [
        challenge_status : 'ongoing',
        challenge_stages : 5,
        payments : 3
      ]
    }
  }
  test("button use_benefit") {
    "/instore/challenge/summary/use_benefit" (platform: "/", type: TrackType.Event) {
      session_id = "11"
      challenge_id = "wqejwej1-111"
      payment_status = [
        challenge_status : 'ongoing',
        challenge_stages : 5,
        payments : 3
      ]
    }
  }
  test("button other_discounts") {
    "/instore/challenge/summary/other_discounts" (platform: "/", type: TrackType.Event) {
      session_id = "11"
      challenge_id = "wqejwej1-111"
      payment_status = [
        challenge_status : 'ongoing',
        challenge_stages : 5,
        payments : 3
      ]
    }
  }
  test("button tyc") {
    "/instore/challenge/summary/terms_and_conditions" (platform: "/", type: TrackType.Event) {
      session_id = "11"
      challenge_id = "wqejwej1-111"
      payment_status = [
        challenge_status : 'ongoing',
        challenge_stages : 5,
        payments : 3
      ]
    }
  }
  test("How to use view") {
    "/instore/challenge/first_time_user/how_to_use" (platform: "/", type: TrackType.View) {
      session_id = "11"
      challenge_id = "wqejwej1-111"
    }
  }
  test("Error Page") {
    "/instore/challenge/error" (platform: "/", type: TrackType.View) {
      session_id = "11"
      challenge_id = "wqejwej1-111"
    }
  }
}