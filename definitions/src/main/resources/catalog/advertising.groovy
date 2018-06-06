import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    //ADVERTISING FLOW

    "/advertising"(platform: "/", isAbstract: true) {}

    "/advertising/pads2"(platform: "/", isAbstract: true) {}

    "/advertising/pads2/manager"(platform: "/web", type: TrackType.View) {
        campaign_id(required: true)
        status(required: true)
        budget(required: true)
    }

    "/advertising/pads2/manager/update_campaign_status"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true)
        status(required: true)
        budget(required: true)
        previous_status (required: true)
    }

    "/advertising/pads2/manager/update_campaign_budget"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true)
        status(required: true)
        budget(required: true)
        previous_budget (required: true)
    }

    "/advertising/pads2/manager/update_ads_status"(platform: "/web", type: TrackType.Event) {
        campaign_id(required: true)
        status(required: true)
        budget(required: true)
        ad_status(required: true)
        item_id(required:true)
        previous_ad_status (required: true)
    }
}
