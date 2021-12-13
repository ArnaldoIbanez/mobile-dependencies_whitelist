import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1237"

    propertyDefinitions {
        campaign_id(required: true, PropertyType.String, description: "Id of the campaign related to the notification sent.")
        communication_id(required: false, type: PropertyType.String, description: "Indicates if notification is for test")
        sent_date(required: false, type: PropertyType.String, description: "date of send notification.")
        batch_id(required: true, type: PropertyType.String, description: "Id of batch.")
        campaign_type(required: false, type: PropertyType.String, description: "Campaign type.")
        campaign_data(required: false, type: PropertyType.String, description: "Campaign data.")
    }

    propertyGroups {
        externalData(campaign_id, communication_id, sent_date, batch_id, campaign_type, campaign_data)
    }

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

    //Mercado envios Campaigns
    "/notification/me_campaigns_crowd_generic"(platform: "/") {
        externalData
    }
    "/notification/me_campaigns_flex_generic"(platform: "/") {
        externalData
    }
    "/notification/me_campaigns_logistics_generic"(platform: "/") {
        externalData
    }

    //Messages driver
    "/notification/messages_driver_extra"(platform: "/") {}
}