import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/fiscal_data"(platform: "/", isAbstract: true) {}
    "/fiscal_data/companies"(platform: "/", isAbstract: true) {}
    "/fiscal_data/companies/registration"(platform: "/", isAbstract: true) {}
    "/fiscal_data/companies/registration/form"(platform: "/", type: TrackType.View) {}
    "/fiscal_data/companies/registration/congrats"(platform: "/", type: TrackType.View) {}

    "/fiscal_data"(platform: "/", isAbstract: true) {}
    "/fiscal_data/companies"(platform: "/", isAbstract: true) {}
    "/fiscal_data/companies/fiscal_data_flow"(platform: "/", isAbstract: true) {}
    "/fiscal_data/companies/fiscal_data_flow/tax_payer"(platform: "/", type: TrackType.View) {}
    "/fiscal_data/companies/fiscal_data_flow/iva"(platform: "/", type: TrackType.View) {}
    "/fiscal_data/companies/fiscal_data_flow/load_iva"(platform: "/", type: TrackType.View) {}
    "/fiscal_data/companies/fiscal_data_flow/iibb"(platform: "/", type: TrackType.View) {}
    "/fiscal_data/companies/fiscal_data_flow/load_iibb"(platform: "/", type: TrackType.View) {}
    "/fiscal_data/companies/fiscal_data_flow/province_iibb"(platform: "/", type: TrackType.View) {}
    "/fiscal_data/companies/fiscal_data_flow/address"(platform: "/", type: TrackType.View) {}
    "/fiscal_data/companies/fiscal_data_flow/summary"(platform: "/", type: TrackType.View) {}
    "/fiscal_data/companies/fiscal_data_flow/congrats"(platform: "/", type: TrackType.View) {}

}
