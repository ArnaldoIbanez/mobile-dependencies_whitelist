import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {
  "wallet_shortcut.pay"(description: "Counts when a user enters a Pay Shortcut") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/instore/scan_qr",
              "/bill_payments/scan",
              "/bill_payments/home",
              "/cellphone_recharge/recents",
              "/recharge_sube/select_recharge_card",
              "/manual_code",
              "/single_player/antenna/manual_input",
              "/transport/companies",
              "/digital_goods/list",
              "/instore/shell/pump_code")
        equals("application.business", "mercadopago")
      }
    }
  }

  "wallet_shortcut.charge"(description: "Counts when a user enters a Charge Shortcut") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/pos_seller/new_payment")
        and(
          or(
            equals("event_data.payment_channel", "point"),
            equals("event_data.payment_channel", "qr"),
            equals("event_data.payment_channel", "share_social"),
            equals("event_data.payment_channel", "cash")
          ),
          equals("application.business", "mercadopago")
        )
      }
    }
  }

  "wallet_shortcut.friends"(description: "Counts when a user enters a Friends Shortcut") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/mplayer/money_split/activities_selection",
              "/mplayer/closed_request/contact_picker",
              "/mplayer/send_money/contact_picker",
              "/mplayer/tracing/event_list")
        equals("application.business", "mercadopago")
      }
    }
  }

  "wallet_shortcut.benefits"(description: "Counts when a user enters a Benefits Shortcut") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/discount_center/payers/list",
              "/coupon/input",
              "/loyalty/hub")
        equals("application.business", "mercadopago")
      }
    }
  }

  "wallet_shortcut.mgm"(description: "Counts when a user enters a MGM Shortcut") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/mgm_seller/referal")
        equals("application.business", "mercadopago")
      }
    }
  }

  "wallet_shortcut.business"(description: "Counts when a user enters a Business Shortcut") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/catalog_abm/bifurcator",
              "/stores/list",
              "/pos_setup/opt_in",
              "/collaborators_admin",
              "/tfs_dashboard/home",
              "/settings/point",
              "/settings/pricing",
              "/settings/cost_calculator/chooser")
        equals("application.business", "mercadopago")
      }
    }
  }

  "wallet_shortcut.money"(description: "Counts when a user enters a Money Shortcut") {
    startWith {
      experiment(regex("wallet/.*"))
    }

    countsOn {
      condition {
        path("/money_in/payment_methods",
              "/withdraw/main",
              "/money_out/calculator")
        equals("application.business", "mercadopago")
      }
    }
  }
}