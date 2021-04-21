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

  ////BANKING V2//////////////////////////////////////////
  "wallet_home.banking_v2"(description: "Counts when an user taps any row on the banking v2 section") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        //Esta bien esta regex??
        path(regex("/wallet_home/section/tap/banking_v2-*"))
        and(
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  "wallet_home.banking_v2.balance"(description: "Counts when an user taps the balance row on the banking v2 section") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/section/tap/banking_v2-balance")
        and(
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  "wallet_home.banking_v2.actions"(description: "Counts when an user taps the actions row on the banking v2 section") {
    startWith {
      experiment(regex("wallet/.*"))
    }
    countsOn {
      condition {
        path("/wallet_home/section/tap/banking_v2-actions")
        and(
          equals("application.business", "mercadopago")
        )
      }
    }
  }

 "wallet_home.banking_v2.assets"(description: "Counts when an user taps the assets row on the banking v2 section") {
    startWith {
      experiment(regex("wallet/.*"))
    }
    countsOn {
      condition {
        path("/wallet_home/section/tap/banking_v2-assets")
        and(
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  "wallet_home.banking_v2.cards"(description: "Counts when an user taps the cards row on the banking v2 section") {
    startWith {
      experiment(regex("wallet/.*"))
    }
    countsOn {
      condition {
        path("/wallet_home/section/tap/banking_v2-cards")
        and(
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  "wallet_home.banking_v2.cards"(description: "Counts when an user taps the mpcards row on the banking v2 section") {
    startWith {
      experiment(regex("wallet/.*"))
    }
    countsOn {
      condition {
        path("/wallet_home/section/tap/banking_v2-mpcard")
        and(
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  //Main Payer Flow taps

  "wallet_home.discount_center"(description: "Counts when an user taps the Discount Center section in the Home") {
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

  "wallet_home.shortcuts"(description: "Counts when an user taps the Shortcuts Section in the Home") {
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

  "wallet_home.advertising"(description: "Counts when an user taps on the advertising section") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/section/tap/advertising")
        equals("application.business", "mercadopago")  
      }
    }
  }

  "wallet_home.cross_selling"(description: "Counts when an user taps the Cross Selling section in the Home") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
          path("/wallet_home/section/tap/cross_selling")
          equals("application.business", "mercadopago")
      }
    }
  }

  "wallet_home.activities"(description: "Counts when an user taps the Activities section in the Home") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/section/tap/activities")
        equals("application.business", "mercadopago")
      }
    }
  }

  "wallet_home.activities.operations"(description: "Counts when an user taps the operations on the activities section") {
    startWith {
      experiment(regex("wallet/.*"))
    }
    countsOn {
      condition {
          path("/wallet_home/section/tap/activities")
          and(
            equals("event_data.component_id", "user_activities"),
            equals("application.business", "mercadopago")
          )
      }
    }
  }

  "wallet_home.activities.footer"(description: "Counts when an user taps the footer on the activities section") {
    startWith {
      experiment(regex("wallet/.*"))
    }
    countsOn {
      condition {
        path("/wallet_home/section/tap/activities")
        and(
          equals("event_data.component_id", "user_activities_see_more_button"),
          equals("application.business", "mercadopago")
        )
      }
    }
  }

}
