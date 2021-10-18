import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1171"

    //Messages
    "/notification/messages_new"(platform: "/") {}
    "/notification/messages_read"(platform: "/") {}
    "/notification/messages_driver_logistics"(platform: "/") {}
    "/notification/messages_driver_flex"(platform: "/") {}
    "/notification/messages_flex"(platform: "/") {}
    "/notification/messages_quotes"(platform: "/") {}

    //Drive Logistics
    "/notification/driver_logistics_changed_address"(platform: "/") {}
    "/notification/driver_logistics_driver_with_route"(platform: "/") {}
    "/notification/driver_logistics_retry_collect"(platform: "/") {}
    "/notification/driver_logistics_retry_delivery"(platform: "/") {}
    "/notification/driver_logistics_send_returns"(platform: "/") {}

    //Crowdsourcing driver
    "/notification/me_crowd_cnh_registration"(platform: "/") {}
    "/notification/me_crowd_tutorial_registration"(platform: "/") {}
    "/notification/me_crowd_geo_city_registration"(platform: "/") {}
    "/notification/me_crowd_city_registration"(platform: "/") {}
    "/notification/me_crowd_select_service_center_registration"(platform: "/") {}
    "/notification/me_crowd_registration_incomplete"(platform: "/") {}
    "/notification/me_crowd_registration_complete"(platform: "/") {}
    "/notification/me_crowd_cnh_validation"(platform: "/") {}

    //Messages driver
    "/notification/messages_driver_extra"(platform: "/") {}
}