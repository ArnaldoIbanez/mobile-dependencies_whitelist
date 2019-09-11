package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS PayersGrowth
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("PayersGrowth ML track") {

    	// Shake It Screens
	    "/payers_growth/shake_it/onboarding"(platform: "/mobile", type: TrackType.View) {}
	    "/payers_growth/shake_it/begin_game"(platform: "/mobile", type: TrackType.View) {}
	    "/payers_growth/shake_it/game_result"(platform: "/mobile", type: TrackType.View) {
	    	status = "win"
	    }
	    "/payers_growth/shake_it/how_to"(platform: "/mobile", type: TrackType.View) {}
	    "/payers_growth/shake_it/pending"(platform: "/mobile", type: TrackType.View) {
	    	status = "pending_extend"
	    }
	    "/payers_growth/shake_it/rejected"(platform: "/mobile", type: TrackType.View) {
	    	status = "rejected_expired"
	    }
	    "/payers_growth/shake_it/router"(platform: "/mobile", type: TrackType.View) {}
	    "/payers_growth/shake_it/couchmark"(platform: "/mobile", type: TrackType.View) {}

	    // Shake It Events
	    "/payers_growth/shake_it/terms"(platform: "/mobile", type: TrackType.Event) {}
	    "/payers_growth/shake_it/route"(platform: "/mobile", type: TrackType.Event) {
	    	status = "onboarding"
	    }
	    "/payers_growth/shake_it/shake"(platform: "/mobile", type: TrackType.Event) {}

	    //Modal Events
    	"/payers_growth/modal/cta"(platform: "/mobile", type: TrackType.Event) {
			id = "ftu_recarga_discount"
		}
    	"/payers_growth/modal/show"(platform: "/mobile", type: TrackType.Event) {
			id = "ftu_recarga_discount"
		}
    	"/payers_growth/modal/dismiss"(platform: "/mobile", type: TrackType.Event) {
			id = "ftu_recarga_discount"
		}
    }

    defaultBusiness = "mercadopago"
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS PayersGrowth
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("PayersGrowth MP tracks") {

    	// Shake It Screens
	    "/payers_growth/shake_it/onboarding"(platform: "/mobile", type: TrackType.View) {}
	    "/payers_growth/shake_it/begin_game"(platform: "/mobile", type: TrackType.View) {}
	    "/payers_growth/shake_it/game_result"(platform: "/mobile", type: TrackType.View) {
	    	status = "win"
	    }
	    "/payers_growth/shake_it/how_to"(platform: "/mobile", type: TrackType.View) {}
	    "/payers_growth/shake_it/pending"(platform: "/mobile", type: TrackType.View) {
	    	status = "pending_extend"
	    }
	    "/payers_growth/shake_it/rejected"(platform: "/mobile", type: TrackType.View) {
	    	status = "rejected_expired"
	    }
	    "/payers_growth/shake_it/router"(platform: "/mobile", type: TrackType.View) {}
	    "/payers_growth/shake_it/couchmark"(platform: "/mobile", type: TrackType.View) {}

	    // Shake It Events
	    "/payers_growth/shake_it/terms"(platform: "/mobile", type: TrackType.Event) {}
	    "/payers_growth/shake_it/route"(platform: "/mobile", type: TrackType.Event) {
	    	status = "onboarding"
	    }
	    "/payers_growth/shake_it/shake"(platform: "/mobile", type: TrackType.Event) {}

	    //Modal Events
    	"/payers_growth/modal/cta"(platform: "/mobile", type: TrackType.Event) {
			id = "ftu_recarga_discount"
		}
    	"/payers_growth/modal/show"(platform: "/mobile", type: TrackType.Event) {
			id = "ftu_recarga_discount"
		}
    	"/payers_growth/modal/dismiss"(platform: "/mobile", type: TrackType.Event) {
			id = "ftu_recarga_discount"
		}
    }
}
