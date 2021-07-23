package src.test.resources.melidata
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests


trackTests {

    defaultBusiness = "mercadopago"

    /**
    * Point refunds section tracks
    */
    test("Point refunds views") {
        //Refunds funnel
        "/point_refunds/amount"(platform: "/", type: TrackType.View) {}
        "/point_refunds/confirm"(platform: "/", type: TrackType.View) {}
        "/point_refunds/congrats"(platform: "/", type: TrackType.View) {}
        "/point_refunds/error"(platform: "/", type: TrackType.View) {}              
    }

    test("Point refunds events") {
        //Receipt send actions
        "/point_refunds/send_sms"(platform: "/", type: TrackType.Event) {}
        "/point_refunds/send_email"(platform: "/", type: TrackType.Event) {}        
        "/point_refunds/print"(platform: "/", type: TrackType.Event) {}                 
    }
}
