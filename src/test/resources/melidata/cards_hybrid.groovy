package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    //-----------------
    // HYBRID MP
    //-----------------

    defaultBusiness = "mercadopago"

    // SHIPPING
    // --------

    //Shipping: Tracking
    test("cards hybrid shipping tracking") {
        "/cards/hybrid/shipping/tracking"(platform: "/", type: TrackType.View) {
            banner_is_present = false
            contact_is_present = true
        }
        "/cards/hybrid/shipping/tracking/tap"(platform:"/", type: TrackType.Event) {
            action = "contact"
        }
        "/cards/hybrid/shipping/tracking/show"(platform:"/", type: TrackType.Event) {
            component_id = "banner_unlock"
        }

    }

    // UNLOCK
    // ------

     // Unlock: Init point
    test("cards hybrid unlock init point") {
        "/cards/hybrid/unlock/init-point"(platform: "/", type: TrackType.View) {}
    }

    // Unlock: Scanner
    test("cards hybrid unlock scanner") {
        "/cards/hybrid/unlock/scanner"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/scanner/link"(platform:"/", type: TrackType.Event) {
            action = "qr"
        }
        "/cards/hybrid/unlock/scanner/link"(platform:"/", type: TrackType.Event) {
            action = "manual"
        }
        "/cards/hybrid/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
            action = "initializing"
        }
        "/cards/hybrid/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
            action = "scanning"
        }
        "/cards/hybrid/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
            action = "resolving"
        }
        "/cards/hybrid/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
            action = "failed"
        }
    }

    // Unlock: Manual Link
    test("cards hybrid unlock manual link") {
        "/cards/hybrid/unlock/manual-link"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/manual-link/tap"(platform:"/", type: TrackType.Event) {
            action = "link"
        }
    }

    // Unlock: Confirm Link
    test("cards hybrid unlock confirm link") {
        "/cards/hybrid/unlock/confirm-link"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/confirm-link/tap"(platform:"/", type: TrackType.Event) {
            action = "confirm"
        }
        "/cards/hybrid/unlock/confirm-link/tap"(platform:"/", type: TrackType.Event) {
            action = "logout"
        }
    }

    // Unlock: Camera Permissions
    test("cards hybrid unlock camera permissions") {
        "/cards/hybrid/unlock/camera-permissions"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/camera-permissions/tap"(platform:"/", type: TrackType.Event) {
            action = "qr"
        }
        "/cards/hybrid/unlock/camera-permissions/tap"(platform:"/", type: TrackType.Event) {
            action = "manual"
        }
    }

    // Unlock: Confirm Replacement
    test("cards hybrid unlock confirm replacement") {
        "/cards/hybrid/unlock/confirm-replacement"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/confirm-replacement/tap"(platform:"/", type: TrackType.Event) {
            action = "confirm"
        }
        "/cards/hybrid/unlock/confirm-replacement/tap"(platform:"/", type: TrackType.Event) {
            action = "exit"
        }
    }

    // Unlock: Set Pin
    test("cards hybrid unlock set pin") {
        "/cards/hybrid/unlock/set-pin"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/set-pin/tap"(platform:"/", type: TrackType.Event) {
            action = "confirm"
        }
    }

    // Unlock: Update App
    test("cards hybrid unlock update app") {
        "/cards/hybrid/unlock/update-app"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/update-app/tap"(platform:"/", type: TrackType.Event) {
            action = "update"
        }
        "/cards/hybrid/unlock/update-app/tap"(platform:"/", type: TrackType.Event) {
            action = "exit"
        }
    }

    //-----------------
    // HYBRID ML
    //-----------------

    defaultBusiness = "mercadolibre"

    // SHIPPING
    // --------

    //Shipping: Tracking
    test("cards hybrid shipping tracking") {
        "/cards/hybrid/shipping/tracking"(platform: "/", type: TrackType.View) {
            banner_is_present = false
            contact_is_present = true
        }
        "/cards/hybrid/shipping/tracking/tap"(platform:"/", type: TrackType.Event) {
            action = "contact"
        }
        "/cards/hybrid/shipping/tracking/show"(platform:"/", type: TrackType.Event) {
            component_id = "banner_unlock"
        }

    }

    // UNLOCK
    // ------

    // Unlock: Init point
    test("cards hybrid unlock init point") {
        "/cards/hybrid/unlock/init-point"(platform: "/", type: TrackType.View) {}
    }

    // Unlock: Scanner
    test("cards hybrid unlock scanner") {
        "/cards/hybrid/unlock/scanner"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/scanner/link"(platform:"/", type: TrackType.Event) {
            action = "qr"
        }
        "/cards/hybrid/unlock/scanner/link"(platform:"/", type: TrackType.Event) {
            action = "manual"
        }
        "/cards/hybrid/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
            action = "initializing"
        }
        "/cards/hybrid/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
            action = "scanning"
        }
        "/cards/hybrid/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
            action = "resolving"
        }
        "/cards/hybrid/unlock/scanner/link/status"(platform:"/", type: TrackType.Event) {
            action = "failed"
        }
    }

    // Unlock: Manual Link
    test("cards hybrid unlock manual link") {
        "/cards/hybrid/unlock/manual-link"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/manual-link/tap"(platform:"/", type: TrackType.Event) {
            action = "link"
        }
    }

    // Unlock: Confirm Link
    test("cards hybrid unlock confirm link") {
        "/cards/hybrid/unlock/confirm-link"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/confirm-link/tap"(platform:"/", type: TrackType.Event) {
            action = "confirm"
        }
        "/cards/hybrid/unlock/confirm-link/tap"(platform:"/", type: TrackType.Event) {
            action = "logout"
        }
    }

    // Unlock: Camera Permissions
    test("cards hybrid unlock camera permissions") {
        "/cards/hybrid/unlock/camera-permissions"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/camera-permissions/tap"(platform:"/", type: TrackType.Event) {
            action = "qr"
        }
        "/cards/hybrid/unlock/camera-permissions/tap"(platform:"/", type: TrackType.Event) {
            action = "manual"
        }
    }

    // Unlock: Confirm Replacement
    test("cards hybrid unlock confirm replacement") {
        "/cards/hybrid/unlock/confirm-replacement"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/confirm-replacement/tap"(platform:"/", type: TrackType.Event) {
            action = "confirm"
        }
        "/cards/hybrid/unlock/confirm-replacement/tap"(platform:"/", type: TrackType.Event) {
            action = "exit"
        }
    }

    // Unlock: Set Pin
    test("cards hybrid unlock set pin") {
        "/cards/hybrid/unlock/set-pin"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/set-pin/tap"(platform:"/", type: TrackType.Event) {
            action = "confirm"
        }
    }
  
    // Unlock: Update App
    test("cards hybrid unlock update app") {
        "/cards/hybrid/unlock/update-app"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/unlock/update-app/tap"(platform:"/", type: TrackType.Event) {
            action = "update"
        }
        "/cards/hybrid/unlock/update-app/tap"(platform:"/", type: TrackType.Event) {
            action = "exit"
        }
    }
    
    // DASHBOARD
    // --------
    test("cards hybrid dashboard") {
        "/cards/hybrid/dashboard"(platform: "/", type: TrackType.View) {}
    }
    
    //Mini card: Tracking
    test("cards hybrid dashboard mini card tracking") {
        "/cards/hybrid/dashboard/mini_card"(platform: "/", type: TrackType.View) {
            status = "virtual_only"
        }
        "/cards/hybrid/dashboard/mini_card/tap"(platform:"/", type: TrackType.Event) {
            action = "virtual_only"
        }
    }
    
    //Flap card: Tracking
    test("cards hybrid dashboard flap card tracking") {
        "/cards/hybrid/dashboard/flap"(platform: "/", type: TrackType.View) {
            status = "virtual_only"
        }
        "/cards/hybrid/dashboard/flap/tap"(platform:"/", type: TrackType.Event) {
            action = "virtual_only"
        }
    }
    
    //Activities: Tracking
    test("cards hybrid dashboard activities") {
        "/cards/hybrid/dashboard/activities"(platform: "/", type: TrackType.View) {}
    }
    
    //Account options: Tracking
    test("cards hybrid dashboard account options") {
        "/cards/hybrid/dashboard/account_options"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/dashboard/account_options/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
    }
    
    //Carousel: Tracking
    test("cards hybrid dashboard carousel") {
        "/cards/hybrid/dashboard/carousel"(platform: "/", type: TrackType.View) {}
    }
    
    //Linear buttons: Tracking
    test("cards hybrid dashboard linear buttons") {
        "/cards/hybrid/dashboard/linear_buttons"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/dashboard/linear_buttons/tap"(platform:"/", type: TrackType.Event) {
            action = "help"
        }
    }
    
    //Message: Tracking
    test("cards hybrid dashboard message") {
        "/cards/hybrid/dashboard/message"(platform: "/", type: TrackType.View) {
            type = "warning"
        }
        "/cards/hybrid/dashboard/message/tap"(platform:"/", type: TrackType.Event) {
            action = "change_pin"
        }
    }
    
    //Account info: Tracking
    test("cards hybrid dashboard account info") {
        "/cards/hybrid/dashboard/account_info"(platform: "/", type: TrackType.View) {}
        "/cards/hybrid/dashboard/account_info/tap"(platform:"/", type: TrackType.Event) {
            action = "money_in"
        }
    }
   
}
