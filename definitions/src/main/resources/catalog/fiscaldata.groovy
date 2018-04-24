import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/registration_company"(platform: "/", isAbstract: true) {}
    "/registration_company/form"(platform: "/", type: TrackType.View) {}
    "/registration_company/congrats"(platform: "/", type: TrackType.View) {}

    "/flow_ddff"(platform: "/", isAbstract: true) {}
    "/flow_ddff/tax_payer"(platform: "/", type: TrackType.View) {}
    "/flow_ddff/iva"(platform: "/", type: TrackType.View) {}
    "/flow_ddff/load_iva"(platform: "/", type: TrackType.View) {}
    "/flow_ddff/iibb"(platform: "/", type: TrackType.View) {}
    "/flow_ddff/load_iibb"(platform: "/", type: TrackType.View) {}
    "/flow_ddff/province_iibb"(platform: "/", type: TrackType.View) {}
    "/flow_ddff/address"(platform: "/", type: TrackType.View) {}
    "/flow_ddff/summary"(platform: "/", type: TrackType.View) {}
    "/flow_ddff/congrats"(platform: "/", type: TrackType.View) {}

}
