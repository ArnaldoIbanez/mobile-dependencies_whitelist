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

  "payment.mercadopago"(description: "Counts when a user pays in any flow in mercadopago business", categorization:"important") {
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

  "payment.mercadolibre"(description: "Counts when a user pays in any flow in mercadolibre business", categorization:"important") {
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

  "payment.instore.mercadopago"(description: "Counts when a user pays in In Store in mercadopago business", categorization:"important") {
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

  "payment.instore.mercadolibre"(description: "Counts when a user pays in In Store in mercadolibre business", categorization:"important") {
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

  "payment.cellphone_recharge.mercadopago"(description: "Counts when a user pays in Cellphone Recharge in mercadopago business") {
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

  "payment.cellphone_recharge.mercadolibre"(description: "Counts when a user pays in Cellphone Recharge in mercadolibre business") {
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

  "payment.transport.mercadopago"(description: "Counts when a user pays in Transport in mercadopago business") {
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

  "payment.moneyin.mercadopago"(description: "Counts when a user inserts money into his/her account in mercadopago business") {
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

  "payment.money_transfer.mercadopago"(description: "Counts when a user sends Money in mercadopago business") {
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

  "payment.services.mercadopago"(description: "Counts when a user pays a Service in mercadopago business") {
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

  "payment.pay_preference.mercadopago"(description: "Counts when a user pays a Preference in mercadopago business") {
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

  "payment.starbucks.mercadopago"(description: "Counts when a user recharges Starbucks card in mercadopago business") {
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

  "wallet_active_investor.mercadopago"(description: "Counts when a user opts in for Asset Management in mercadopago business") {
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