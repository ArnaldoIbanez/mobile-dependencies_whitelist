import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

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

  "payment"(description: "Counts when a user pays in any flow in any business", categorization:"important") {
      startWith {
        experiment(regex("wallet/.*"))
      }

      countsOn {
        condition {
          path("/px_checkout/result/success")
        }
      }
    }

  "payment.mp"(description: "Counts when a user pays in any flow in mercadopago business") {
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

  "payment.ml"(description: "Counts when a user pays in any flow in mercadolibre business") {
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

  "payment.instore"(description: "Counts when a user pays in In Store in any business", categorization:"important") {
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

  "payment.instore.mp"(description: "Counts when a user pays in In Store in mercadopago business") {
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

  "payment.instore.ml"(description: "Counts when a user pays in In Store in mercadolibre business") {
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

  "payment.cellphone_recharge"(description: "Counts when a user pays in Cellphone Recharge in any business") {
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

  "payment.cellphone_recharge.mp"(description: "Counts when a user pays in Cellphone Recharge in mercadopago business") {
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

  "payment.cellphone_recharge.ml"(description: "Counts when a user pays in Cellphone Recharge in mercadolibre business") {
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

  "payment.transport"(description: "Counts when a user pays in Transport in any business") {
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

  "payment.moneyin"(description: "Counts when a user inserts money into his/her account in any business") {
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

  "payment.money_transfer"(description: "Counts when a user sends Money in any business") {
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

  "payment.services"(description: "Counts when a user pays a Service in any business") {
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

  "payment.pay_preference"(description: "Counts when a user pays a Preference in any business") {
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

  "payment.starbucks"(description: "Counts when a user recharges Starbucks card in any business") {
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

  "discount_center.view_marketplace_from_home_mp"(description: "Counts a user access to the discount center from home mp") {
    startWith {
      experiment(regex("cdd/.*"))
    }

    countsOn {
      condition {
        path(regex("/discount_center/payers/marketplace(/components)?"))
        equals("platform.fragment.from", "/home_wallet/discount_center")
      }
    }
  }

  "discount_center.view_detail_from_home_mp"(description: "Counts a user access to the discount detail from home mp") {
    startWith {
      experiment(regex("cdd/.*"))
    }

    countsOn {
      condition {
        path("/discount_center/payers/detail")
        equals("platform.fragment.from", "/home_wallet/discount_center")
      }
    }
  }

  "discount_center.view_detail_from_marketplace"(description: "Counts a user access to the discount detail from the marketplace") {
    startWith {
      experiment(regex("cdd/.*"))
    }

    countsOn {
      condition {
        path("/discount_center/payers/detail")
        equals("platform.fragment.from", "/discount_center_payers/list")
      }
    }
  }

  "charge"(description: "Counts when a user makes a Charge in Wallet") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/pos_seller/congrats")
      }
    }
  }

  "charge.point"(description: "Counts when a user makes a Charge with Point") {
      startWith {
        experiment(regex("wallet/.*"))
      }

      countsOn {
        condition {
          path("/pos_seller/congrats")
          equals("event_data.payment_channel", "point")
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
        path("/pos_seller/congrats")
        equals("event_data.payment_channel", "qr")
      }
    }
  }

  "charge.cash"(description: "Counts when a user makes a Charge with Cash") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/pos_seller/congrats")
        equals("event_data.payment_channel", "cash")
      }
    }
  }
}
