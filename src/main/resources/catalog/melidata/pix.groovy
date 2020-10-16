import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = '1176'

    "/pix_flows"(platform: "/", isAbstract: true) {}
    "/pix_flows/landing"(platform: "/", type: TrackType.View) {}
    "/pix_flows/landing/tap" (platform: "/", type: TrackType.Event) {
        action (type: PropertyType.String, required: true, values: ["home", "faqs", "pix_key", "money_in", "money_out", "qr", "copy_key"], description: "Indicate type of action tapped in pix landing")
    }
}