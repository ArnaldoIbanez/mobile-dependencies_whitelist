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

  "payment"(description: "Counts when a user pays in any flow", categorization:"important") {
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

  "payment.instore"(description: "Counts when a user pays in In Store", categorization:"important") {
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

  "payment.cellphone_recharge"(description: "Counts when a user pays in Cellphone Recharge", categorization:"important") {
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

  "payment.transport"(description: "Counts when a user pays in Transport", categorization:"important") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        and(
          equals("event_data.flow", "transport"),
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  "payment.moneyin"(description: "Counts when a user inserts money into his/her account", categorization:"important") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        and(
          or(
            equals("event_data.flow", "account_fund"),
            equals("event_data.flow", "/account_fund"),
            equals("event_data.flow", "/moneyin")
          ),
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  "payment.money_transfer"(description: "Counts when a user sends Money", categorization:"important") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        and(
          equals("application.business", "mercadopago"),
          or(
            equals("event_data.flow", "money_transfer"),
            equals("event_data.flow", "/money_transfer")
          )
        )
      }
    }
  }

  "payment.services"(description: "Counts when a user pays a Service", categorization:"important") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        and(
          equals("event_data.flow", "services"),
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  "payment.pay_preference"(description: "Counts when a user pays a Preference", categorization:"important") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        and(
          equals("event_data.flow", "/pay_preference"),
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  "payment.starbucks"(description: "Counts when a user recharges Starbucks card", categorization:"important") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/px_checkout/result/success")
        and(
          equals("event_data.flow", "/miniapps/starbucks"),
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  "wallet_active_investor"(description: "Counts when a user opts in for Asset Management") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/asset_management/result_investing")
        equals("application.business", "mercadopago")
      }
    }
  }
}
