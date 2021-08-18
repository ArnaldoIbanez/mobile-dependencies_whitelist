package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"
  
    test("View Lading Page FTU") {
        "/proximity_marketplace/ftu" (platform: "/", type: TrackType.View) {}
    }

    test("View Congrat post FTU And OU") {
        "/proximity_marketplace/shipping/conditions-acceptance" (platform: "/", type: TrackType.View) {}
    }

    test("View Edit Setting info") {
        "/proximity_marketplace/settings/coverage" (platform: "/", type: TrackType.View) {}
    }

    test("Event Redirect FTU to OU") {
        "/proximity_marketplace/ftu/ou" (platform: "/", type: TrackType.Event) {}
    }

    test("Event Open Modal example T&C") {
        "/proximity_marketplace/component/tap" (platform: "/", type: TrackType.Event) {
            component_id = "main_action"
            component_type = "action"
            value = "Open Modal"
        }
    }  
    
    test("Event Error Example API FLEX / ONBOARDING / ACCESSS") {
        "/proximity_marketplace/shipping/conditions-acceptance/error" (platform: "/", type: TrackType.Event) {
            value = "User dont have store"
        }
    }

    test("Event Error Example ACCESSS Error") {
        "/proximity_marketplace/ftu/error" (platform: "/", type: TrackType.Event) {
            value = "User Dont exist in audience"
        }
    }

    test("Event Error Example ACCESSS Error") {
        "/proximity_marketplace/settings/coverage/error" (platform: "/", type: TrackType.Event) {
            value = "error dont exist in audience"
        }
    }      
   
}
