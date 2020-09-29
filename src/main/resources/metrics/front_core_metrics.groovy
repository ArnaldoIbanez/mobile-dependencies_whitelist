import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

  //Banking Taps

  "wallet_home.banking"(description: "Counts when an user taps any row on the banking section", deprecation_date:"2020/09/30") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/section/tap/banking")
        equals("application.business", "mercadopago")
      }
    }
  }

  "wallet_home.banking.balance"(description: "Counts when an user taps the balance row on the banking section") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/section/tap/banking")
        and(
          equals("event_data.component_id", "balance"),
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  "wallet_home.banking.assets"(description: "Counts when an user taps the assets row on the banking section") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/section/tap/banking")
        and(
          equals("event_data.component_id", "assets"),
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  "wallet_home.banking.credits"(description: "Counts when an user taps the credits row on the banking section") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/section/tap/banking")
        and(
          equals("event_data.component_id", "credits"),
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  "wallet_home.banking.cards"(description: "Counts when an user taps the cards row on the banking section") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/section/tap/banking")
        and(
          equals("event_data.component_id", "cards"),
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  //Main Payer Flow taps

  "wallet_home.discount_center"(description: "Counts when an user taps the Discount Center section in the Home", deprecation_date:"2020/09/30") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/section/tap/discount_center")
        equals("application.business", "mercadopago")
      }
    }
  }

  "wallet_home.main_actions"(description: "Counts when an user taps the Main Actions Section in the Home", deprecation_date:"2020/09/30") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/section/tap/main_actions")
        equals("application.business", "mercadopago")
      }
    }
  }

  "wallet_home.shortcuts"(description: "Counts when an user taps the Shortcuts Section in the Home", deprecation_date:"2020/09/30") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/section/tap/shortcuts")
        equals("application.business", "mercadopago")
      }
    }
  }

  //Banking Interactions

  "wallet_home.banking.toggle"(description: "Counts when a user expand or collapse the banking section", deprecation_date:"2020/09/30") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/banking/collapse", "/wallet_home/banking/expand")
        equals("application.business", "mercadopago")
      }
    }
  }

  "wallet_home.banking.collapse"(description: "Counts when an user collapse the banking section", deprecation_date:"2020/09/30") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/banking/collapse")
        equals("application.business", "mercadopago")
      }
    }
  }

  "wallet_home.banking.expand"(description: "Counts when an user expand banking section", deprecation_date:"2020/09/30") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/banking/expand")
        equals("application.business", "mercadopago")
      }
    }
  }
}
