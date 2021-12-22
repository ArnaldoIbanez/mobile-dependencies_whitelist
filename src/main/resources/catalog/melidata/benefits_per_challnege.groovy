package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

  initiative="1322"

  "/instore/challenge" (platform: "/", isAbstract: true) {
    session_id(required: true, type: PropertyType.String, description: "Session identifier")
    traffic_from(required: false, type: PropertyType.String, description: "Traffic identifier")
  }

    // ----- HUB page -----
  "/instore/challenge/summary" (platform: "/", type: TrackType.View) {
    suscribed(required: true, type: PropertyType.Numeric, description: "Suscribed amount")
    not_suscribed(required: true, type: PropertyType.Numeric, description: "Not suscribed amount")
    total_challenges(required: true, type: PropertyType.Numeric, description: "Total challenge amount")
  }

  "/instore/challenge/summary/how_to_use" (platform: "/", type: TrackType.View) {
    suscribed(required: true, type: PropertyType.Numeric, description: "Suscribed amount")
    not_suscribed(required: true, type: PropertyType.Numeric, description: "Not suscribed amount")
    total_challenges(required: true, type: PropertyType.Numeric, description: "Total challenge amount")
  }

  // ----- Detail page -----
  "/instore/challenge/detail" (platform: "/", type: TrackType.View) {
    challenge_id(required: true, type: PropertyType.String, description: "Challenge id")
    user_payments(required: true, type: PropertyType.Numeric, description: "User payments amount")
    challenge_stages(required: true, type: PropertyType.Numeric, description: "Challenge stages amount")
    payments_left(required: true, type: PropertyType.Numeric, description: "Payments left amount")
    days_left(required: true, type: PropertyType.Numeric, description: "Days left amount")
    optin_status(required: true, type: PropertyType.String, values:['ACCEPTED','PENDING'], description: "Optin status")
  }
  
  "/instore/challenge/detail/find_stores" (platform: "/", type: TrackType.Event) {}
  
  "/instore/challenge/detail/join/success" (platform: "/", type: TrackType.Event) {}

  "/instore/challenge/detail/join/fail" (platform: "/", type: TrackType.Event) {}

  "/instore/challenge/detail/other_discounts" (platform: "/", type: TrackType.Event) {}

  "/instore/challenge/detail/terms_and_conditions" (platform: "/", type: TrackType.Event) {}

  
  // ----- FTU pages -----
  "/instore/challenge/onboarding" (platform: "/", type: TrackType.View) {}

  "/instore/challenge/onboarding/start" (platform: "/", type: TrackType.Event) {}
  
  // ----- Error pages -----
  "/instore/challenge/error" (platform: "/", type: TrackType.View) {}
 
}