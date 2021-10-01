package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

  initiative="1322"

  def payment_status_object = objectSchemaDefinitions {
    challenge_status(required: true, type: PropertyType.String, values:['ongoing','completed','expired'], description: "Challenge status")
    payments(required: true, type: PropertyType.Numeric, description: "Payments amount")
    challenge_stages(required: true, type: PropertyType.Numeric, description: "Stages amount")
  }

  "/instore/challenge" (platform: "/", isAbstract: true) {
    challenge_id(required: true, type: PropertyType.String, description: "Challenge id")
    session_id(required: true, type: PropertyType.String, description: "Session identifier")
  }
  "/instore/challenge/summary" (platform: "/", type: TrackType.View) {
    payment_status(required: true, type:PropertyType.Map(payment_status_object), description: "state of payments")
  }
  
  "/instore/challenge/find_stores" (platform: "/", type: TrackType.Event) {}
  "/instore/challenge/use_benefit" (platform: "/", type: TrackType.Event) {}
  "/instore/challenge/other_discounts" (platform: "/", type: TrackType.Event) {}
  "/instore/challenge/terms_and_conditions" (platform: "/", type: TrackType.Event) {}

  
  // ----- FTU pages -----
  "/instore/challenge/first_time_user" (platform: "/", type: TrackType.View, isAbstract: true) {}

  "/instore/challenge/first_time_user/how_to_use" (platform: "/", type: TrackType.View) {}
  
  "/instore/challenge/error" (platform: "/", type: TrackType.View) {}
 
}