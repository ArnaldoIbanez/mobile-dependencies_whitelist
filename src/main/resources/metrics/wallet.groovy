import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics
import com.ml.melidata.metrics.TagType

def instoreMarketplaceExperiments = "(wallet/)?cdd/.*"

metrics {
  "wallet_user"(description: "Counts when a user starts using Mercado Pago app") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/home")
        equals("application.business", "mercadopago")
      }
    }
  }

  "payment"(description: "Counts when a user pays in any flow in any business", compute_payment: true, tags:[TagType.Important]) {
      startWith {
        experiment(regex("wallet/.*"))
      }

      countsOn {
        condition {
          path("/px_checkout/result/success")
        }
      }
    }

  "payment.mp"(description: "Counts when a user pays in any flow in mercadopago business", compute_payment: true) {
      startWith {
        experiment(regex("wallet/.*"))
      }

      countsOn {
        condition {
          path("/px_checkout/result/success")
          equals("application.business", "mercadopago")
        }
      }
    }

  "payment.ml"(description: "Counts when a user pays in any flow in mercadolibre business", compute_payment: true) {
      startWith {
        experiment(regex("wallet/.*"))
      }

      countsOn {
        condition {
          path("/px_checkout/result/success")
          equals("application.business", "mercadolibre")
        }
      }
    }

  "payment.instore"(description: "Counts when a user pays in In Store in any business" , compute_payment: true, tags:[TagType.Important]) {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        equals("event_data.flow", "/instore")
      }
    }
  }

  "payment.instore.mp"(description: "Counts when a user pays in In Store in mercadopago business", compute_payment: true) {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        and(
          equals("event_data.flow", "/instore"),
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  "payment.instore.ml"(description: "Counts when a user pays in In Store in mercadolibre business", compute_payment: true) {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        and(
          equals("event_data.flow", "/instore"),
          equals("application.business", "mercadolibre")
        )
      }
    }
  }

  "payment.cellphone_recharge"(description: "Counts when a user pays in Cellphone Recharge in any business", compute_payment: true) {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        equals("event_data.flow", "cellphone_recharge")
      }
    }
  }

  "payment.cellphone_recharge.mp"(description: "Counts when a user pays in Cellphone Recharge in mercadopago business", compute_payment: true) {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        and(
          equals("event_data.flow", "cellphone_recharge"),
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  "payment.cellphone_recharge.ml"(description: "Counts when a user pays in Cellphone Recharge in mercadolibre business", compute_payment: true) {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        and(
          equals("event_data.flow", "cellphone_recharge"),
          equals("application.business", "mercadolibre")
        )
      }
    }
  }

  "payment.transport"(description: "Counts when a user pays in Transport in any business", compute_payment: true) {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        equals("event_data.flow", "transport")
      }
    }
  }

  "payment.moneyin"(description: "Counts when a user inserts money into his/her account in any business", compute_payment: true) {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        or(
          equals("event_data.flow", "account_fund"),
          equals("event_data.flow", "/account_fund"),
          equals("event_data.flow", "/moneyin")
        )
      }
    }
  }

  "payment.money_transfer"(description: "Counts when a user sends Money in any business", compute_payment: true) {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        or(
          equals("event_data.flow", "money_transfer"),
          equals("event_data.flow", "/money_transfer")
        )
      }
    }
  }

  "payment.services"(description: "Counts when a user pays a Service in any business", compute_payment: true) {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        equals("event_data.flow", "services")
      }
    }
  }

  "payment.pay_preference"(description: "Counts when a user pays a Preference in any business", compute_payment: true) {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        equals("event_data.flow", "/pay_preference")
      }
    }
  }

  "payment.starbucks"(description: "Counts when a user recharges Starbucks card in any business", compute_payment: true) {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        equals("event_data.flow", "/miniapps/starbucks")
      }
    }
  }

  "wallet_active_investor"(description: "Counts when a user opts in for Asset Management in any business") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/asset_management/result_investing")
      }
    }
  }

"discount_center"(description: "Counts a user access to the any instance of the marketplace") {
    startWith {
      experiment(regex(instoreMarketplaceExperiments))
    }

    countsOn {
      condition {
        path("/discount_center/payers/marketplace", "/discount_center/payers/marketplace/components", "/discount_center/payers/detail")
      }
    }
  }

  "discount_center.detail"(description: "Counts a user access to the detail") {
    startWith {
      experiment(regex(instoreMarketplaceExperiments))
    }

    countsOn {
      condition {
        path("/discount_center/payers/detail")
      }
    }
  }

"discount_center.marketplace.from_touchpoints"(description: "Counts a user access to the discount center from any touchpoint") {
      startWith {
        experiment(regex(instoreMarketplaceExperiments))
      }

      countsOn {
        condition {
          path("/discount_center/payers/marketplace", "/discount_center/payers/marketplace/components")
          or (
              equals("platform.fragment.from", "/home_wallet/discount_center"),
              equals("platform.fragment.from", "/home_ml/discount_center"),
              equals("platform.fragment.from", "/loyalty/discount_center"),
              equals("platform.fragment.from", "/offers_ml/discount_center"),
              equals("platform.fragment.from", "/cho_on/congrats"),
              equals("platform.fragment.from", "/px/congrats")
          )
        }
      }
    }

  "discount_center.marketplace.from_home_mp"(description: "Counts a user access to the discount center from home mp") {
      startWith {
        experiment(regex(instoreMarketplaceExperiments))
      }

      countsOn {
        condition {
          path(regex("/discount_center/payers/marketplace(/components)?"))
          equals("platform.fragment.from", "/home_wallet/discount_center")
        }
      }
    }

  "discount_center.marketplace.from_marketplace"(description: "Counts a user access to the marketplace from the same marketplace") {
      startWith {
        experiment(regex(instoreMarketplaceExperiments))
      }

      countsOn {
        condition {
          path(regex("/discount_center/payers/marketplace(/components)?"))
          equals("platform.fragment.from", "/discount_center_payers/list")
        }
      }
    }

    "discount_center.detail.from_touchpoints"(description: "Counts a user access to the discount detail from any touchpoint") {
      startWith {
        experiment(regex(instoreMarketplaceExperiments))
      }

      countsOn {
        condition {
          path("/discount_center/payers/detail")
          or(
              equals("platform.fragment.from", "/home_wallet/discount_center"),
              equals("platform.fragment.from", "/home_ml/discount_center"),
              equals("platform.fragment.from", "/loyalty/discount_center"),
              equals("platform.fragment.from", "/offers_ml/discount_center"),
              equals("platform.fragment.from", "/cho_on/congrats"),
              equals("platform.fragment.from", "/px/congrats")
          )
        }
      }
    }

    "discount_center.detail.from_home_mp"(description: "Counts a user access to the discount detail from home mp") {
      startWith {
        experiment(regex(instoreMarketplaceExperiments))
      }

      countsOn {
        condition {
          path("/discount_center/payers/detail")
          equals("platform.fragment.from", "/home_wallet/discount_center")
        }
      }
    }

    "discount_center.detail.from_marketplace"(description: "Counts a user access to the discount detail from the marketplace") {
      startWith {
        experiment(regex(instoreMarketplaceExperiments))
      }

      countsOn {
        condition {
          path("/discount_center/payers/detail")
          equals("platform.fragment.from", "/discount_center_payers/list")
        }
      }
    }

    "discount_center.detail.from_detail"(description: "Counts a user access to the discount detail from another detail") {
      startWith {
        experiment(regex(instoreMarketplaceExperiments))
      }

      countsOn {
        condition {
          path("/discount_center/payers/detail")
          equals("platform.fragment.from", "/discount_center_payers/detail")
        }
      }
    }

  "charge"(description: "Counts when a user makes a Charge in Wallet") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/pos_seller/end", 
              "/point_payment/link_share", 
              "/point_payment/qr_congrats", 
              "/point_payment/qr_congrats_nofee", 
              "/point_payment/cash/congrats")
      }
    }
  }

  "charge.point"(description: "Counts when a user makes a Charge with Point") {
      startWith {
        experiment(regex("wallet/.*"))
      }

      countsOn {
        condition {
          path("/pos_seller/end")
        }
      }
  }

  "charge.link"(description: "Counts when a user makes a Charge with Link") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/point_payment/link_share")
      }
    }
  }

  "charge.qr"(description: "Counts when a user makes a Charge with QR") {
    startWith {
      experiment(regex("wallet/.*"))
    }
    
    countsOn {
      condition {
        path("/point_payment/qr_congrats", "/point_payment/qr_congrats_nofee")
      }
    }
  }

  "charge.cash"(description: "Counts when a user makes a Charge with Cash") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/point_payment/cash/congrats")
      }
    }
  }

  "payment_intent.first_payment_method"(description: "Counts when a user confirms pay with first suggested payment method", compute_payment: true) {
    startWith {
      experiment("px_nativo/payment_method_recommendation")
    }

    countsOn {
      condition {
        path("/px_checkout/review/confirm")
        equals("event_data.payment_method_selected_index", 0)
      }
    }
  }

  "payment_intent.second_payment_method"(description: "Counts when a user confirms pay with second suggested payment method", compute_payment: true) {
    startWith {
      experiment("px_nativo/payment_method_recommendation")
    }

    countsOn {
      condition {
        path("/px_checkout/review/confirm")
        equals("event_data.payment_method_selected_index", 1)
      }
    }
  }
}
