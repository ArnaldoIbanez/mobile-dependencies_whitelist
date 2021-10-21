package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

  "digital_account/app_download_button"(description: "define which type of download app button shows to see which converts better", deprecation_date:"2021/09/01") {
    experiment("digital_account/stickyButton")
  
    countsOn {
      condition {
        path("/landing/digital_account/click")
        and(
          equals("event_data.id", "sticky-button-register")
        )
      }
    }
  }

  "app_download_intention"(description: "Measure the intention of downloading the App by clicking in several spots/buttons distributed in different sites", deprecation_date:"2021/11/01") {
    experiment("home-landing/appDownloadDesktop", "home-landing/appDownloadMobile", "business-landing/stickyButton", "digital-account-landing/appDownloadDesktop", "digital-account-landing/appDownloadMobile")
  
    countsOn {
      condition {
        path("/landing/home/click", "/business_site/click")
        or(
          equals("event_data.id", "sms-button"),
          equals("event_data.id", "incentive-button"),
          equals("event_data.item", "sticky-button")
        )
      }
    }
  }

}
