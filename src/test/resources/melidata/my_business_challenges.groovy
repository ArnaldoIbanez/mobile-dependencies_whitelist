import com.ml.melidata.catalog.PropertyType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadopago"

    test("Mercado Pago - Engagement Games Challenges") {
        /* ---------------------
        ------ Pageviews -------
        --------------------- */

        "/my_business/challenges" (platform: "/", type: TrackType.View) {
          challenges = []
        }

        "/my_business/challenges/in_game" (platform: "/", type: TrackType.View) {
          challenge_id = "tpv-challenge-1"
        }

        "/my_business/challenges/congrats_success" (platform: "/", type: TrackType.View) {
          challenge_id = "tpv-challenge-1"
        }

        "/my_business/challenges/congrats_failed" (platform: "/", type: TrackType.View) {
          challenge_id = "tpv-challenge-1"
        }

        "/my_business/challenges/error" (platform: "/", type: TrackType.View) {}

        /* ---------------------
        -------- Events --------
        --------------------- */

        "/my_business/challenges/subscribe" (platform: "/", type: TrackType.Event) {
          challenge_id = "tpv-challenge-1"
        }

        "/my_business/challenges/progress" (platform: "/", type: TrackType.Event) {
          challenge_id = "tpv-challenge-1"
        }

        "/my_business/challenges/terms_and_conditions" (platform: "/", type: TrackType.Event) {
          challenge_id = "tpv-challenge-1"
        }

        "/my_business/challenges/in_game/terms_and_conditions" (platform: "/", type: TrackType.Event) {
          challenge_id = "tpv-challenge-1"
        }

        "/my_business/challenges/congrats_success/go_to_hub" (platform: "/", type: TrackType.Event) {
          challenge_id = "tpv-challenge-1"
        }

        "/my_business/challenges/congrats_failed/submit_survey" (platform: "/", type: TrackType.Event) {
          challenge_id = "tpv-challenge-1"
        }

        "/my_business/challenges/congrats_failed/go_to_hub" (platform: "/", type: TrackType.Event) {
          challenge_id = "tpv-challenge-1"
        }

        "/my_business/challenges/congrats_failed/terms_and_conditions" (platform: "/", type: TrackType.Event) {
          challenge_id = "tpv-challenge-1"
        }

        "/my_business/challenges/error/go_to_hub" (platform: "/", type: TrackType.Event) {}
    }
}
