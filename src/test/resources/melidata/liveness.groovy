package src.test.resources.melidata


import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"

    test("Liveness mobile android ml") {

		"/liveness/enrollment"(platform: "/mobile/android") {
            params = "test=true"
        }
	
		"/liveness/authentication"(platform: "/mobile/android") {
            params = "test=true"
        }

		"/liveness/initialization"(platform: "/mobile/android") {
            initialization_result = true
        }

		"/liveness/challenge_time"(platform: "/mobile/android") {
			time = 1241
			challenge_result = 0
	    }

		"/liveness/result"(platform: "/mobile/android") {
			upload_time = 1413
			liveness_result = 0 
	    }

	    "/liveness/redirect"(platform: "/mobile/android") {
	        deeplink = "meli:/home"
	    }

	    "/liveness/bussines_error"(platform: "/mobile/android") {
	        error_message = "error 200"
	    }

	    "/liveness/generic_error"(platform: "/mobile/android") {
	        error_type = "test"
	        error_cause = "true"
	    }

		"/liveness/landing"(platform: "/mobile/android") {}

		"/liveness/fallback"(platform: "/mobile/android") {
			type = "timeout"
		}

		"/liveness/unsupported"(platform: "/mobile/android") {}
	}

	test("Liveness mobile ios ml") {

		"/liveness/enrollment"(platform: "/mobile/ios") {
            params = "test=true"
        }
	
		"/liveness/authentication"(platform: "/mobile/ios") {
            params = "test=true"
        }

		"/liveness/initialization"(platform: "/mobile/ios") {
            initialization_result = true
        }

		"/liveness/challenge_time"(platform: "/mobile/ios") {
			time = 1241
			challenge_result = 0
	    }

		"/liveness/result"(platform: "/mobile/ios") {
			upload_time = 1413
			liveness_result = 0 
	    }

	    "/liveness/redirect"(platform: "/mobile/ios") {
	        deeplink = "meli:/home"
	    }

	    "/liveness/bussines_error"(platform: "/mobile/ios") {
	        error_message = "error 200"
	    }

	    "/liveness/generic_error"(platform: "/mobile/ios") {
	        error_type = "test"
	        error_cause = "true"
	    }

		"/liveness/landing"(platform: "/mobile/ios") {}

		"/liveness/fallback"(platform: "/mobile/ios") {
			type = "timeout"
		}

		"/liveness/unsupported"(platform: "/mobile/ios") {}
	}

	test("Liveness mobile web ml") {

		"/liveness/enrollment"(platform: "/web") {
            params = "test=true"
        }
	
		"/liveness/authentication"(platform: "/web") {
            params = "test=true"
        }

		"/liveness/initialization"(platform: "/web") {
            initialization_result = true
        }

		"/liveness/challenge_time"(platform: "/web") {
			time = 1241
			challenge_result = 0
	    }

		"/liveness/result"(platform: "/web") {
			upload_time = 1413
			liveness_result = 0 
	    }

	    "/liveness/redirect"(platform: "/web") {
	        url = "www.mercadolibre.com"
	    }

	    "/liveness/bussines_error"(platform: "/web") {
	        error_message = "error 200"
	    }

	    "/liveness/generic_error"(platform: "/web") {
	        error_type = "test"
	        error_cause = "true"
	    }

		"/liveness/landing"(platform: "/web") {}

		"/liveness/fallback"(platform: "/web") {
			type = "timeout"
		}

		"/liveness/unsupported"(platform: "/web") {}
	}

	defaultBusiness = "mercadopago"

	test("Liveness mobile android mp") {

		"/liveness/enrollment"(platform: "/mobile/android") {
            params = "test=true"
        }
	
		"/liveness/authentication"(platform: "/mobile/android") {
            params = "test=true"
        }

		"/liveness/initialization"(platform: "/mobile/android") {
            initialization_result = true
        }

		"/liveness/challenge_time"(platform: "/mobile/android") {
			time = 1241
			challenge_result = 0
	    }

		"/liveness/result"(platform: "/mobile/android") {
			upload_time = 1413
			liveness_result = 0 
	    }

	    "/liveness/redirect"(platform: "/mobile/android") {
	        deeplink = "mercadopago:/home"
	    }

	    "/liveness/bussines_error"(platform: "/mobile/android") {
	        error_message = "error 200"
	    }

	    "/liveness/generic_error"(platform: "/mobile/android") {
	        error_type = "test"
	        error_cause = "true"
	    }

		"/liveness/landing"(platform: "/mobile/android") {}

		"/liveness/fallback"(platform: "/mobile/android") {
			type = "cancel"
		}

		"/liveness/unsupported"(platform: "/mobile/android") {}
	}

	test("Liveness mobile ios mp") {

		"/liveness/enrollment"(platform: "/mobile/ios") {
            params = "test=true"
        }
	
		"/liveness/authentication"(platform: "/mobile/ios") {
            params = "test=true"
        }

		"/liveness/initialization"(platform: "/mobile/ios") {
            initialization_result = true
        }

		"/liveness/challenge_time"(platform: "/mobile/ios") {
			time = 1241
			challenge_result = 0
	    }

		"/liveness/result"(platform: "/mobile/ios") {
			upload_time = 1413
			liveness_result = 0 
	    }

	    "/liveness/redirect"(platform: "/mobile/ios") {
	        deeplink = "mercadopago:/home"
	    }

	    "/liveness/bussines_error"(platform: "/mobile/ios") {
	        error_message = "error 200"
	    }

	    "/liveness/generic_error"(platform: "/mobile/ios") {
	        error_type = "test"
	        error_cause = "true"
	    }

		"/liveness/landing"(platform: "/mobile/ios") {}

		"/liveness/fallback"(platform: "/mobile/ios") {
			type = "cancel"
		}

		"/liveness/unsupported"(platform: "/mobile/ios") {}
	}

	test("Liveness mobile web mp") {

		"/liveness/enrollment"(platform: "/web") {
            params = "test=true"
        }
	
		"/liveness/authentication"(platform: "/web") {
            params = "test=true"
        }

		"/liveness/initialization"(platform: "/web") {
            initialization_result = true
        }

		"/liveness/challenge_time"(platform: "/web") {
			time = 1241
			challenge_result = 0
	    }

		"/liveness/result"(platform: "/web") {
			upload_time = 1413
			liveness_result = 0 
	    }

	    "/liveness/redirect"(platform: "/web") {
	        url = "www.mercadopago.com"
	    }

	    "/liveness/bussines_error"(platform: "/web") {
	        error_message = "error 200"
	    }

	    "/liveness/generic_error"(platform: "/web") {
	        error_type = "test"
	        error_cause = "true"
	    }

		"/liveness/landing"(platform: "/web") {}

		"/liveness/fallback"(platform: "/web") {
			type = "timeout"
		}

		"/liveness/unsupported"(platform: "/web") {}
	}
}