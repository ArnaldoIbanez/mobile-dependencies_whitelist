import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

  "wallet_home.banking_v2.components"(description: "Counts when an user taps on the components for the banking v2 section") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/section/tap/banking_v2-balance",
             "/wallet_home/section/tap/banking_v2-actions",
             "/wallet_home/section/tap/banking_v2-assets",
             "/wallet_home/section/tap/banking_v2-cards",
             "/wallet_home/section/tap/banking_v2-mpcard"
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
        )
      }
    }
  }

  "wallet_home.banner"(description: "Counts when an user taps the banner section in the Home") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/section/tap/prepaid_banner")
      }
    }
  }

  "wallet_home.credits"(description: "Counts when an user taps the credits section in the Home") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/wallet_home/section/tap/credits")
      }
    }
  }

}
