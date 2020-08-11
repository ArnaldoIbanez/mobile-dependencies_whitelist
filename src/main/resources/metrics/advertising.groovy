package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

//	Advertising experiments

	"mclics/ads-from-search-backend-native-mla2"(description: "Experiment testing for adv", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				empty("experiments.mclics/ads-from-search-backend-native-mla", false)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-native-mla"(default: "DEFAULT")
			}
		}
	}
	
	
	"mclics/ads-from-search-backend-native-mla_full-match"(description: "Experiment subsegmentation by BS full match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-native-mla", false),
					like('event_data.backend_data.fsm', '^((?!S).)*$')
				)

			}
			openBy {
				"experiments.mclics/ads-from-search-backend-native-mla"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-native-mla_soft-match"(description: "Experiment subsegmentation by BS soft match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-native-mla", false),
					like('event_data.backend_data.fsm', '.+(?:S)')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-native-mla"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-desktop-mla_full-match"(description: "Experiment subsegmentation by BS full match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-desktop-mla", false),
					like('event_data.backend_data.fsm', '^((?!S).)*$')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-desktop-mla"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-desktop-mla_soft-match"(description: "Experiment subsegmentation by BS soft match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-desktop-mla", false),
					like('event_data.backend_data.fsm', '.+(?:S)')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-desktop-mla"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-webmobile-mla_full-match"(description: "Experiment subsegmentation by BS full match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-webmobile-mla", false),
					like('event_data.backend_data.fsm', '^((?!S).)*$')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-webmobile-mla"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-webmobile-mla_soft-match"(description: "Experiment subsegmentation by BS soft match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-webmobile-mla", false),
					like('event_data.backend_data.fsm', '.+(?:S)')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-webmobile-mla"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-native-mlb_full-match"(description: "Experiment subsegmentation by BS full match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-native-mlb", false),
					like('event_data.backend_data.fsm', '^((?!S).)*$')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-native-mlb"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-native-mlb_soft-match"(description: "Experiment subsegmentation by BS soft match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-native-mlb", false),
					like('event_data.backend_data.fsm', '.+(?:S)')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-native-mlb"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-desktop-mlb_full-match"(description: "Experiment subsegmentation by BS full match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-desktop-mlb", false),
					like('event_data.backend_data.fsm', '^((?!S).)*$')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-desktop-mlb"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-desktop-mlb_soft-match"(description: "Experiment subsegmentation by BS soft match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-desktop-mlb", false),
					like('event_data.backend_data.fsm', '.+(?:S)')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-desktop-mlb"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-webmobile-mlb_full-match"(description: "Experiment subsegmentation by BS full match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-webmobile-mlb", false),
					like('event_data.backend_data.fsm', '^((?!S).)*$')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-webmobile-mlb"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-webmobile-mlb_soft-match"(description: "Experiment subsegmentation by BS soft match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-webmobile-mlb", false),
					like('event_data.backend_data.fsm', '.+(?:S)')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-webmobile-mlb"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-native-mlm_full-match"(description: "Experiment subsegmentation by BS full match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-native-mlm", false),
					like('event_data.backend_data.fsm', '^((?!S).)*$')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-native-mlm"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-native-mlm_soft-match"(description: "Experiment subsegmentation by BS soft match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-native-mlm", false),
					like('event_data.backend_data.fsm', '.+(?:S)')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-native-mlm"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-desktop-mlm_full-match"(description: "Experiment subsegmentation by BS full match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-desktop-mlm", false),
					like('event_data.backend_data.fsm', '^((?!S).)*$')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-desktop-mlm"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-desktop-mlm_soft-match"(description: "Experiment subsegmentation by BS soft match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-desktop-mlm", false),
					like('event_data.backend_data.fsm', '.+(?:S)')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-desktop-mlm"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-webmobile-mlm_full-match"(description: "Experiment subsegmentation by BS full match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-webmobile-mlm", false),
					like('event_data.backend_data.fsm', '^((?!S).)*$')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-webmobile-mlm"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-webmobile-mlm_soft-match"(description: "Experiment subsegmentation by BS soft match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-webmobile-mlm", false),
					like('event_data.backend_data.fsm', '.+(?:S)')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-webmobile-mlm"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-native-resto_full-match"(description: "Experiment subsegmentation by BS full match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-native-resto", false),
					like('event_data.backend_data.fsm', '^((?!S).)*$')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-native-resto"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-native-resto_soft-match"(description: "Experiment subsegmentation by BS soft match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-native-resto", false),
					like('event_data.backend_data.fsm', '.+(?:S)')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-native-resto"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-desktop-resto_full-match"(description: "Experiment subsegmentation by BS full match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-desktop-resto", false),
					like('event_data.backend_data.fsm', '^((?!S).)*$')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-desktop-resto"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-desktop-resto_soft-match"(description: "Experiment subsegmentation by BS soft match", deprecation_date:"2020/01/01") {
		startWith {
			condition {

				and(
					empty("experiments.mclics/ads-from-search-backend-desktop-resto", false),
					like('event_data.backend_data.fsm', '.+(?:S)')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-desktop-resto"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-webmobile-resto_full-match"(description: "Experiment subsegmentation by BS full match", deprecation_date:"2020/01/01") {

		startWith {
			condition {

				and(
					empty("experiments.mclics/ads-from-search-backend-webmobile-resto", false),
					like('event_data.backend_data.fsm', '^((?!S).)*$')
				)

			}
			openBy {
				"experiments.mclics/ads-from-search-backend-webmobile-resto"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-webmobile-resto_soft-match"(description: "Experiment subsegmentation by BS soft match", deprecation_date:"2020/01/01") {
		startWith {
			condition {
				and(
					empty("experiments.mclics/ads-from-search-backend-webmobile-resto", false),
					like('event_data.backend_data.fsm', '.+(?:S)')
				)
			}
			openBy {
				"experiments.mclics/ads-from-search-backend-webmobile-resto"(default: "DEFAULT")
			}
		}
	}
}




