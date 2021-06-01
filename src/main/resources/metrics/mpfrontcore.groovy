package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

  "digital_account/app_download_button"(description: "define which type of download app button shows to see which converts better", deprecation_date:"2021/07/01") {
    startWith {
      experiment("digital_account/stickyButton")
    }
  
    countsOn {
      condition {
        path("/landing/digital_account/click")
        and(
          equals("event_data.id", "sticky-button-register")
        )
      }
    }
  }

  "home/app_download_button"(description: "define if to show the download app button or not", deprecation_date:"2021/07/01") {
    startWith {
      experiment("home/stickyButton")
    }

	  countsOn {
	  	condition {
	  		path("/landing/home/click")
        and(
          equals("event_data.id", "sticky-button-register")
        )
	  	}
	  }
  }

}
