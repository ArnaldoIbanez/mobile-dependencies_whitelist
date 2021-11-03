import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1300"

    /**
    * Point refunds section tracks
    */
    "/point_refunds"(platform: "/", isAbstract: true) {}
    /**
    * Views
    */
    "/point_refunds/amount"(platform: "/", type: TrackType.View) {}
    "/point_refunds/confirm"(platform: "/", type: TrackType.View) {}
    "/point_refunds/congrats"(platform: "/", type: TrackType.View) {}
    "/point_refunds/error"(platform: "/", type: TrackType.View) {}
    /**
    * Events
    */
    "/point_refunds/send_sms"(platform: "/", type: TrackType.Event) {}
    "/point_refunds/send_email"(platform: "/", type: TrackType.Event) {}
    "/point_refunds/print"(platform: "/", type: TrackType.Event) {}
}
