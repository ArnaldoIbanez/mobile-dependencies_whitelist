package catalog.melidata
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    // Payments - Point - Online Growth
    initiative = "1262"

    /* ---------------------
    --- Abstract path's ----
    --------------------- */

    "/my_business" (platform: "/", isAbstract: true) {}

    /* ---------------------
    ------ Pageviews -------
    --------------------- */

    "/my_business/challenges" (platform: "/", type: TrackType.View) {
      challenges (required: true, inheritable: false, type: PropertyType.ArrayList, description: "Array of challenges")
    }

    "/my_business/challenges/in_game" (platform: "/", type: TrackType.View) {
      challenge_id (required: true, type: PropertyType.String, description: "ID of the challenge, example: tpv-challenge-1")
    }

    "/my_business/challenges/congrats_success" (platform: "/", type: TrackType.View) {
      challenge_id (required: true, type: PropertyType.String, description: "ID of the challenge, example: tpv-challenge-1")
    }

    "/my_business/challenges/congrats_failed" (platform: "/", type: TrackType.View) {
      challenge_id (required: true, type: PropertyType.String, description: "ID of the challenge, example: tpv-challenge-1")
    }

    "/my_business/challenges/error" (platform: "/", type: TrackType.View) {}

    /* ---------------------
    -------- Events --------
    --------------------- */

    // HUB
    "/my_business/challenges/subscribe" (platform: "/", type: TrackType.Event) {
      challenge_id (required: true, type: PropertyType.String, description: "ID of the challenge, example: tpv-challenge-1")
    }
    
    "/my_business/challenges/progress" (platform: "/", type: TrackType.Event) {
      challenge_id (required: true, type: PropertyType.String, description: "ID of the challenge, example: tpv-challenge-1")
    }

    "/my_business/challenges/terms_and_conditions" (platform: "/", type: TrackType.Event) {
      challenge_id (required: false, type: PropertyType.String, description: "ID of the challenge, example: tpv-challenge-1")
    }

    // IN GAME
    "/my_business/challenges/in_game/terms_and_conditions" (platform: "/", type: TrackType.Event) {
      challenge_id (required: true, type: PropertyType.String, description: "ID of the challenge, example: tpv-challenge-1")
    }

    // CONGRATS SUCCESS
    "/my_business/challenges/congrats_success/go_to_hub" (platform: "/", type: TrackType.Event) {
      challenge_id (required: true, type: PropertyType.String, description: "ID of the challenge, example: tpv-challenge-1")
    }

    // CONGRATS FAILED
    "/my_business/challenges/congrats_failed/submit_survey" (platform: "/", type: TrackType.Event) {
      challenge_id (required: true, type: PropertyType.String, description: "ID of the challenge, example: tpv-challenge-1")
    }

    "/my_business/challenges/congrats_failed/go_to_hub" (platform: "/", type: TrackType.Event) {
      challenge_id (required: true, type: PropertyType.String, description: "ID of the challenge, example: tpv-challenge-1")
    }

    "/my_business/challenges/congrats_failed/terms_and_conditions" (platform: "/", type: TrackType.Event) {
      challenge_id (required: true, type: PropertyType.String, description: "ID of the challenge, example: tpv-challenge-1")
    }

    // ERROR
    "/my_business/challenges/error/go_to_hub" (platform: "/", type: TrackType.Event) {}
}
