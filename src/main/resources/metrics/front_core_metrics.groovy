import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

  "wallet_home.taps"(description: "Counts when an user taps any section ") {
    experiment(regex("wallet/.*"))

    countsOn {
      condition {
        path("/wallet_home/section/tap/banking_v2-balance",
                "/wallet_home/section/tap/banking_v2-actions",
                "/wallet_home/section/tap/banking_v2-assets",
                "/wallet_home/section/tap/banking_v2-cards",
                "/wallet_home/section/tap/banking_v2-mpcard",
                "/wallet_home/section/tap/shortcuts",
                "/wallet_home/section/tap/ads_top_banner",
                "/wallet_home/section/tap/cross_selling",
                "/wallet_home/section/tap/benefits",
                "/wallet_home/section/tap/activities",
                "/wallet_home/section/tap/prepaid_banner",
                "/wallet_home/section/tap/credits",
                "/wallet_home/section/tap/discount_center",
                "/wallet_home/section/tap/qr_fab"
        )
      }
    }
  }

  "wallet_home.banking_v2.components"(description: "Counts when an user taps on the components for the banking v2 section") {
    experiment(regex("wallet/.*"))

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
    experiment(regex("wallet/.*"))

    countsOn {
      condition {
        path("/wallet_home/section/tap/discount_center")
      }
    }
  }

  "wallet_home.shortcuts"(description: "Counts when an user taps the Shortcuts Section in the Home") {
    experiment(regex("wallet/.*"))

    countsOn {
      condition {
        path("/wallet_home/section/tap/shortcuts")
      }
    }
  }

  "wallet_home.ads_top_banner"(description: "Counts when an user taps on the advertising section") {
    experiment(regex("wallet/.*"))

    countsOn {
      condition {
        path("/wallet_home/section/tap/ads_top_banner", 
             "/wallet_home/section/tap/cross_selling")
      }
    }
  }

  "wallet_home.ads_top_banner.cross_sell"(description: "Counts when an user taps the Cross Selling Cards in the advertising section in the Wallet Home") {
    experiment(regex("wallet/.*"))
    countsOn {
      condition {
        path("/wallet_home/section/tap/ads_top_banner")
        like("event_data.component_id", "cross_selling_home_mp")
      }
    }
  }

  "wallet_home.cross_selling"(description: "Counts when an user taps the Cross Selling section in the Home") {
    experiment(regex("wallet/.*"))

    countsOn {
      condition {
        path("/wallet_home/section/tap/cross_selling")
      }
    }
  }

  "wallet_home.benefits"(description: "Counts when an user taps the Benefits section in the Home") {
    experiment(regex("wallet/.*"))

    countsOn {
      condition {
        path("/wallet_home/section/tap/benefits")
      }
    }
  }

  "wallet_home.activities"(description: "Counts when an user taps the Activities section in the Home") {
    experiment(regex("wallet/.*"))

    countsOn {
      condition {
        path("/wallet_home/section/tap/activities")
      }
    }
  }

  "wallet_home.activities.operations"(description: "Counts when an user taps the operations on the activities section") {
    experiment(regex("wallet/.*"))

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
    experiment(regex("wallet/.*"))

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
    experiment(regex("wallet/.*"))

    countsOn {
      condition {
        path("/wallet_home/section/tap/prepaid_banner")
      }
    }
  }

  "wallet_home.credits"(description: "Counts when an user taps the credits section in the Home") {
    experiment(regex("wallet/.*"))

    countsOn {
      condition {
        path("/wallet_home/section/tap/credits")
      }
    }
  }

  "wallet_home.qr"(description: "Counts when an user taps the QR button in the Home") {
    experiment(regex("wallet/.*"))

    countsOn {
      condition {
        path("/wallet_home/section/tap/qr_fab")
      }
    }
  }




  "wallet_home.header.profile"(description: "Counts when an user taps the header profile on the navbar", deprecation_date:"2022/02/28") {
    experiment(regex("wallet/home_navbar_avatar"))

    countsOn {
      condition {
        path("/wallet_home/header_profile/tap")
      }
    }
  }

  "wallet_home.header.buttons.help"(description: "Counts when an user taps the header button ayuda", deprecation_date:"2022/02/28") {
    experiment(regex("wallet/home_navbar_avatar"))

    countsOn {
      condition {
        path("/wallet_home/header_buttons/tap")
        and(
                equals("event_data.id", "help"),
        )
      }
    }
  }

  "wallet_home.header.buttons.data"(description: "Counts when an user taps the header button datos de cuenta", deprecation_date:"2022/02/28") {
    experiment(regex("wallet/home_navbar_avatar"))

    countsOn {
      condition {
        path("/wallet_home/header_buttons/tap")
        and(
                equals("event_data.id", "data"),
        )
      }
    }
  }

  "navigation_sections.navigation_menu_mp.loyalty_row"(description: "Counts when an user taps the header loyalty", deprecation_date:"2022/02/28") {
    experiment(regex("wallet/home_navbar_avatar"))

    countsOn {
      condition {
        path("/navigation_sections/navigation_menu_mp/tap")
        and(
                equals("event_data.id", "loyalty_row"),
        )
      }
    }
  }

  "navigation_sections.navigation_menu_mp.loyalty_avatar"(description: "Counts when an user taps the header tu perfil", deprecation_date:"2022/02/28") {
    experiment(regex("wallet/home_navbar_avatar"))

    countsOn {
      condition {
        path("/navigation_sections/navigation_menu_mp/tap")
        and(
                equals("event_data.id", "loyalty_avatar"),
        )
      }
    }
  }

  "navigation_sections.navigation_menu_mp.your_profile"(description: "Counts when an user taps the header l1 tu perfil", deprecation_date:"2022/02/28") {
    experiment(regex("wallet/home_navbar_avatar"))

    countsOn {
      condition {
        path("/navigation_sections/navigation_menu_mp/tap")
        and(
                equals("event_data.id", "your_profile"),
        )
      }
    }
  }

}