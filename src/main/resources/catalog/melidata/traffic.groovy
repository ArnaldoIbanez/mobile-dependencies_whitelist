package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1034"

    "/traffic"(platform: "/", isAbstract: true) {}

    "/traffic/inbound"(platform: "/", isAbstract: true) {}

    "/traffic/inbound/matt"(platform: "/") {
        tool(type: PropertyType.Numeric, description: "Referrer's ID, this could identify Google, Facebook or any other channel")
        word(required: false, type: PropertyType.String, description: "This is the name of the marketing campaign.")
        go(type: PropertyType.String, description: "Destination URL of the marketing campaign.")
    }

    "/traffic/inbound/organic"(platform: "/") {
        referrer(required: true, type: PropertyType.String, description: "Browser used before getting to us.")
    }

    "/traffic/inbound/notification"(platform: "/") {
        news_id(required: true, type: PropertyType.String, description: "news_id from the notification that opened the app.")
    }
}