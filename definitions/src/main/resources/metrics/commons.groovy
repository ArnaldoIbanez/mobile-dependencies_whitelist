import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {
	"vip"(description: "vip count") {
		countsOn {
			condition {
				path("/vip", "/vip/abort", "/vip/failure")
			}
		}
	}

	"search"(description: "search count") {
		countsOn {
			condition {
				path("/search", "/search/abort", "/search/failure")
			}
		}
	}

	"questions"(description: "questions count") {
		countsOn {
			condition {
				path("/questions/ask/post")
			}
		}
	}

	"bookmarks"(description: "bookmarsk count") {
		countsOn {
			condition {
				path("/bookmarks/post", "/bookmarks/action/post")
			}
		}
	}

	"registrations"(description: "registrations count") {
		countsOn {
			condition {
				path("/register/success")
			}
		}
	}
	
	"checkout.loading"(description: "The checkout V5 first-page after performing a buy_intention ") {
		countsOn {
			condition {
				path("/checkout/loading")
			}
		}
	}
	
	"checkout.login"(description: "path: /checkout/login/confirm_authenticated or /checkout/login/first_purchase_not_authenticated or /checkout/login/confirm_not_authenticated") {
		countsOn {
			condition {
				path("/checkout/login/confirm_authenticated", "/checkout/login/first_purchase_not_authenticated", "/checkout/login/confirm_not_authenticated")
			}
		}
	}
	
	"publish_congrats"(description: "Selling flow new item published - Does not track congrats view") {	
		startWith {
      experiment(regex("sell/.*"))
		}
		
		countsOn {
			condition {
				path("/item/create")
			}
		}
	}

	"email.open"(description: "path: /email/orders and event_type: open") {
		countsOn {
			condition {
				path("/email/orders")

				and(
					equals("event_data.event_type", "open"),
					equals("event_data.order_id", property("order_id"))
				)
			}
		}
	}

	"sell_upgrade_intention"(description: "Intention for upgrading - Selling flow") {	
		startWith {
	            experiment(regex("sell/.*"))
		}
		
		countsOn {
			condition {
				path("/sell/change_listing_type/upgrade_intention")
			}
		}
	}
	
	"sell_list_congrats"(description: "Arrival to congrats page - Selling flow") {	
		startWith {
	    experiment(regex("sell/.*"))
		}
		
		countsOn {
			condition {
				path("/sell/list/congrats")
			}
		}
	}

	"logins"(description: "logins count") {
		startWith {
			experiment(regex("login/.*"))
		}
		countsOn {
			condition {
				path("/login/auth/success")
			}
		}
	}

  "point_congrats"(description: "Arrival to congrats page from Point landings") {
		startWith {
			experiment(regex("mpos/.*"))
		}
		
		countsOn {
			condition {
			  	path("/checkout_off/v1/checkout_confirmed")
          		or(
				equals("event_data.collector_id", "228415881"),
				equals("event_data.collector_id", "179504451"),
				equals("event_data.collector_id", "193054976")
			)
			}
		}
	}
}
