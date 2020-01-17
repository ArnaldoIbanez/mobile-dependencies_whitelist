import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("CardForm - Views") {
	   	"/card_form/bin_number"(platform: "/mobile", type: TrackType.View) {
	   		site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	   	}

	    "/card_form/name"(platform: "/mobile", type: TrackType.View) {
    	  site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	    	  prepopulated = false
	    }

	    "/card_form/expiration_security"(platform: "/mobile", type: TrackType.View) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	    }

	    "/card_form/identification"(platform: "/mobile", type: TrackType.View) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	        prepopulated = false
	    }

	    "/card_form/issuers"(platform: "/mobile", type: TrackType.View) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	        issuers_quantity = 5
	    }
    }

    test("CardForm - Events") {
	    "/card_form/init"(platform: "/mobile", type: TrackType.Event) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	    }

	    "/card_form/success"(platform: "/mobile", type: TrackType.Event) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	    }

	    "/card_form/next"(platform: "/mobile", type: TrackType.Event) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	        current_step = "bin_number"
	    }

	    "/card_form/back"(platform: "/mobile", type: TrackType.Event) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	        current_step = "bin_number"
	    }

	    "/card_form/error"(platform: "/mobile", type: TrackType.Event) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	        error_step = "bin_number"
	        error_message = "Invalid bin"
	    }

	    "/card_form/bin_number/clear"(platform: "/mobile", type: TrackType.Event) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	    }

	    "/card_form/bin_number/invalid"(platform: "/mobile", type: TrackType.Event) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	        bin_number = "123456"
	    }

	    "/card_form/bin_number/valid"(platform: "/mobile", type: TrackType.Event) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	    }

	    "/card_form/bin_number/recognized"(platform: "/mobile", type: TrackType.Event) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	    }

	    "/card_form/bin_number/unknown"(platform: "/mobile", type: TrackType.Event) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	        bin_number = "123456"
	    }

	    "/card_form/name/clear"(platform: "/mobile", type: TrackType.Event) {
    	  site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	    }

	    "/card_form/name/valid"(platform: "/mobile", type: TrackType.Event) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	    }

	    "/card_form/expiration_security/date/valid"(platform: "/mobile", type: TrackType.Event) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	    }

	    "/card_form/expiration_security/date/invalid"(platform: "/mobile", type: TrackType.Event) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	    }

	    "/card_form/expiration_security/cvv/valid"(platform: "/mobile", type: TrackType.Event) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	    }

	    "/card_form/expiration_security/cvv/invalid"(platform: "/mobile", type: TrackType.Event) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	    }

	    "/card_form/identification/valid"(platform: "/mobile", type: TrackType.Event) {
	    	site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	    }

	    "/card_form/identification/invalid"(platform: "/mobile", type: TrackType.Event) {
    	  site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	        type = "dni"
	        value = "13456764"
	    }

	    "/card_form/issuers/selected"(platform: "/mobile", type: TrackType.Event) {
    	  site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	    	  issuer_id = 4
	    }

	    "/card_form/issuers/close"(platform: "/mobile", type: TrackType.Event) {
    	  site_id = "MLA"
        	flow_id = "instore"
        	session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        	session_time = 1234
	    }
    }
}
