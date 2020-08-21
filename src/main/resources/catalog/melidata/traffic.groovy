package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1034"

    def third_party_data_definition = objectSchemaDefinitions {
        id(type: PropertyType.String, required: false)
        gclid(type: PropertyType.String, required: false)
        ad_id(type: PropertyType.String, required: false)
        adset_id(type: PropertyType.String, required: false)
        campaign_id(type: PropertyType.String, required: false)
        placement(type: PropertyType.String, required: false)
        site_source_name(type: PropertyType.String, required: false)
        ad_group_id(type: PropertyType.String, required: false)
        match_type(type: PropertyType.String, required: false)
        network(type: PropertyType.String, required: false)
        device(type: PropertyType.String, required: false)
        creative(type: PropertyType.String, required: false)
        keyword(type: PropertyType.String, required: false)
        adposition(type: PropertyType.String, required: false)
        adtype(type: PropertyType.String, required: false)
        merchant_id(type: PropertyType.String, required: false)
        product_id(type: PropertyType.String, required: false)
        product_partition_id(type: PropertyType.String, required: false)
        target_id(type: PropertyType.String, required: false)
        loc_interest_ms(type: PropertyType.String, required: false)
        loc_physical_ms(type: PropertyType.String, required: false)
        device_model(type: PropertyType.String, required: false)
        feed_item_id(type: PropertyType.String, required: false)
        campaign_name(type: PropertyType.String, required: false)
    }

    def third_party_definition = objectSchemaDefinitions {
        source(type: PropertyType.String, required: true)
        data(type: PropertyType.Map(third_party_data_definition), required: true)
    }

    "/traffic"(platform: "/", isAbstract: true) {}

    "/traffic/inbound"(platform: "/", isAbstract: true) {}

    "/traffic/inbound/matt"(platform: "/") {
        tool(type: PropertyType.Numeric, description: "Referrer's ID, this could identify Google, Facebook or any other channel")
        word(required: false, type: PropertyType.String, description: "This is the name of the marketing campaign.")
        go(type: PropertyType.String, description: "Destination URL of the marketing campaign.")
        third_party(required: false, type: PropertyType.Map(third_party_definition), description: "Third party data from ads")
    }

    "/traffic/inbound/organic"(platform: "/") {
        referrer(required: true, type: PropertyType.String, description: "URL where the traffic came from.")
        destination(required: false, type: PropertyType.String, description: "URL where the traffic is going to.")
    }

    "/traffic/inbound/notification"(platform: "/") {
        news_id(required: true, type: PropertyType.String, description: "news_id from the notification that opened the app.")
    }
}