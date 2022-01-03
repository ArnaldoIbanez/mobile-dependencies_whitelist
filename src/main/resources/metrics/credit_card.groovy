import com.ml.melidata.metrics.BuType
import com.ml.melidata.metrics.ExtentType

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


def cards_hybrid_actions_path = "/cards/hybrid/dashboard/(.*)/(tap|swipe)"
def credit_card_actions_path = "/credits/credit_card/dashboard/(.*)_action"

metrics {

    /**
     * Credit Card Dashboard Async Load Metrics
     */

    "credit_card.dashboard_async_load.debit_actions"(description: "Track user actions on Debit dashboard while Async Load experiment", ttl: 1, bu: BuType.MercadoLibre, extent: ExtentType.Feature) {
        experiment("credit-card/dashboard_async_load")

        countsOn {
            condition {
                path(regex(cards_hybrid_actions_path))
            }
        }

        divisionBy {
            divisionMetric("credit_card.dashboard_async_load")
        }
    }

    "credit_card.dashboard_async_load.credit_card_actions"(description: "Track user actions on Credit Card dashboard while Async Load experiment", ttl: 1, bu: BuType.MercadoLibre, extent: ExtentType.Feature) {
        experiment("credit-card/dashboard_async_load")

        countsOn {
            condition {
                path(regex(credit_card_actions_path))
            }
        }

        divisionBy {
            divisionMetric("credit_card.dashboard_async_load")
        }
    }

    "credit_card.dashboard_async_load"(description: "Track user actions on Debit and Credit Card dashboard while Async Load experiment", ttl: 1, bu: BuType.MercadoLibre, extent: ExtentType.Feature) {
        experiment("credit-card/dashboard_async_load")

        countsOn {
            condition {
                path(regex(cards_hybrid_actions_path),
                     regex(credit_card_actions_path))
            }
        }
    }

    /**
     * Credit Card Upgrade Adoption Metrics for Onboarding Order and Date Picker mode experimets
     */

    "credits_credit_card_upgrade_adoption"(description: "Conversion under Upgrade process with variation on basic flow", bu: BuType.MercadoLibre, extent: ExtentType.Feature) {
        experiment("credits-card/upgrade_onboarding_order", "credits-card/upgrade_date_picker_mode")

        countsOn {
            condition {
                path("/credits/credit_card/upgrade/congrats", "/credits/credit_card/upgrade/error")
            }
        }
    }
}