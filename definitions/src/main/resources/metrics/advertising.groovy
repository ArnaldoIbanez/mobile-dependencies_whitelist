import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {

//	Advertising experiments

	"mclics/ads-from-search-backend-native-mla_full-match"(description: "Experiment subsegmentation by BS full match") {
		startWith {
			experiment("mclics/ads-from-search-backend-native-mla")
			condition {
				like('event_data.backend_data.fms', '^((?!S).)*$')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-native-mla"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-native-mla_soft-match"(description: "Experiment subsegmentation by BS soft match") {
		startWith {
			experiment("mclics/ads-from-search-backend-native-mla")
			condition {
				like('event_data.backend_data.fms', '.+(?:S)')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-native-mla"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-desktop-mla_full-match"(description: "Experiment subsegmentation by BS full match") {
		startWith {
			experiment("mclics/ads-from-search-backend-desktop-mla ")
			condition {
				like('event_data.backend_data.fms', '^((?!S).)*$')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-desktop-mla"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-desktop-mla_soft-match"(description: "Experiment subsegmentation by BS soft match") {
		startWith {
			experiment("mclics/ads-from-search-backend-desktop-mla ")
			condition {
				like('event_data.backend_data.fms', '.+(?:S)')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-desktop-mla"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-webmobile-mla_full-match"(description: "Experiment subsegmentation by BS full match") {
		startWith {
			experiment("mclics/ads-from-search-backend-webmobile-mla")
			condition {
				like('event_data.backend_data.fms', '^((?!S).)*$')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-webmobile-mla"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-webmobile-mla_soft-match"(description: "Experiment subsegmentation by BS soft match") {
		startWith {
			experiment("mclics/ads-from-search-backend-webmobile-mla")
			condition {
				like('event_data.backend_data.fms', '.+(?:S)')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-webmobile-mla"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-native-mlb_full-match"(description: "Experiment subsegmentation by BS full match") {
		startWith {
			experiment("mclics/ads-from-search-backend-native-mlb")
			condition {
				like('event_data.backend_data.fms', '^((?!S).)*$')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-native-mlb"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-native-mlb_soft-match"(description: "Experiment subsegmentation by BS soft match") {
		startWith {
			experiment("mclics/ads-from-search-backend-native-mlb")
			condition {
				like('event_data.backend_data.fms', '.+(?:S)')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-native-mlb"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-desktop-mlb_full-match"(description: "Experiment subsegmentation by BS full match") {
		startWith {
			experiment("mclics/ads-from-search-backend-desktop-mlb")
			condition {
				like('event_data.backend_data.fms', '^((?!S).)*$')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-desktop-mlb"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-desktop-mlb_soft-match"(description: "Experiment subsegmentation by BS soft match") {
		startWith {
			experiment("mclics/ads-from-search-backend-desktop-mlb")
			condition {
				like('event_data.backend_data.fms', '.+(?:S)')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-desktop-mlb"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-webmobile-mlb_full-match"(description: "Experiment subsegmentation by BS full match") {
		startWith {
			experiment("mclics/ads-from-search-backend-webmobile-mlb")
			condition {
				like('event_data.backend_data.fms', '^((?!S).)*$')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-webmobile-mlb"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-webmobile-mlb_soft-match"(description: "Experiment subsegmentation by BS soft match") {
		startWith {
			experiment("mclics/ads-from-search-backend-webmobile-mlb")
			condition {
				like('event_data.backend_data.fms', '.+(?:S)')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-webmobile-mlb"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-native-mlm_full-match"(description: "Experiment subsegmentation by BS full match") {
		startWith {
			experiment("mclics/ads-from-search-backend-native-mlm")
			condition {
				like('event_data.backend_data.fms', '^((?!S).)*$')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-native-mlm"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-native-mlm_soft-match"(description: "Experiment subsegmentation by BS soft match") {
		startWith {
			experiment("mclics/ads-from-search-backend-native-mlm")
			condition {
				like('event_data.backend_data.fms', '.+(?:S)')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-native-mlm"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-desktop-mlm_full-match"(description: "Experiment subsegmentation by BS full match") {
		startWith {
			experiment("mclics/ads-from-search-backend-desktop-mlm")
			condition {
				like('event_data.backend_data.fms', '^((?!S).)*$')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-desktop-mlm"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-desktop-mlm_soft-match"(description: "Experiment subsegmentation by BS soft match") {
		startWith {
			experiment("mclics/ads-from-search-backend-desktop-mlm")
			condition {
				like('event_data.backend_data.fms', '.+(?:S)')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-desktop-mlm"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-webmobile-mlm_full-match"(description: "Experiment subsegmentation by BS full match") {
		startWith {
			experiment("mclics/ads-from-search-backend-webmobile-mlm")
			condition {
				like('event_data.backend_data.fms', '^((?!S).)*$')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-webmobile-mlm"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-webmobile-mlm_soft-match"(description: "Experiment subsegmentation by BS soft match") {
		startWith {
			experiment("mclics/ads-from-search-backend-webmobile-mlm")
			condition {
				like('event_data.backend_data.fms', '.+(?:S)')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-webmobile-mlm"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-native-resto_full-match"(description: "Experiment subsegmentation by BS full match") {
		startWith {
			experiment("mclics/ads-from-search-backend-native-resto")
			condition {
				like('event_data.backend_data.fms', '^((?!S).)*$')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-native-resto"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-native-resto_soft-match"(description: "Experiment subsegmentation by BS soft match") {
		startWith {
			experiment("mclics/ads-from-search-backend-native-resto")
			condition {
				like('event_data.backend_data.fms', '.+(?:S)')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-native-resto"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-desktop-resto_full-match"(description: "Experiment subsegmentation by BS full match") {
		startWith {
			experiment("mclics/ads-from-search-backend-desktop-resto")
			condition {
				like('event_data.backend_data.fms', '^((?!S).)*$')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-desktop-resto"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-desktop-resto_soft-match"(description: "Experiment subsegmentation by BS soft match") {
		startWith {
			experiment("mclics/ads-from-search-backend-desktop-resto")
			condition {
				like('event_data.backend_data.fms', '.+(?:S)')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-desktop-resto"(default: "DEFAULT")
			}
		}
	}

	"mclics/ads-from-search-backend-webmobile-resto_full-match"(description: "Experiment subsegmentation by BS full match") {
		startWith {
			experiment("mclics/ads-from-search-backend-webmobile-resto")
			condition {
				like('event_data.backend_data.fms', '^((?!S).)*$')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-webmobile-resto"(default: "DEFAULT")
			}
		}
	}
	"mclics/ads-from-search-backend-webmobile-resto_soft-match"(description: "Experiment subsegmentation by BS soft match") {
		startWith {
			experiment("mclics/ads-from-search-backend-webmobile-resto")
			condition {
				like('event_data.backend_data.fms', '.+(?:S)')
			}
			openBy {
				"experiment.mclics/ads-from-search-backend-webmobile-resto"(default: "DEFAULT")
			}
		}
	}
}




