import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("cards cobranded acquisition") {

        // View
        "/cobranded/acquisition/landing"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/landing"(platform: "/web/mobile", type: TrackType.View){}
    }


    test("cards cobranded acquisition flow") {

        // View
        "/cobranded/acquisition/maininfo"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/scoreinfo"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/additionalinfo"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/deliverymodeselectio"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/deliveryinfo"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/deliverybranchinfo"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/approvedpremium"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/premiumdetails"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/confirmedpremium"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/approved"(platform: "/", type: TrackType.View){}
    }


    test("cards cobranded error") {

        // View
        "/cobranded/acquisition/error"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/errornojs"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/notallowedaction"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/premiumtimeout"(platform: "/", type: TrackType.View){}
    }


    test("cards cobranded old pages") {

        // View
        "/cobranded/acquisition/masterinfo"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/masterrejected"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/readyapplicant"(platform: "/", type: TrackType.View){}
    }
}
