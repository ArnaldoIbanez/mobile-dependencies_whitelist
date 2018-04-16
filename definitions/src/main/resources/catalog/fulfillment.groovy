import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/fbm"(platform: "/", isAbstract: true) {}

    /**
     *  Landing for Opt-IN into Fulfillment
     */

    //View
    "/fbm/landing"(platform: "/", type: TrackType.View) {}

    //Contact Me Button
    "/fbm/landing/contact_me"(platform: "/", type: TrackType.Event) {
        location(
            required: true,
            type: PropertyType.String,
            description: "Location of the CTA Button."
        )
    }

    //FAQs about Fulfillment
    "/fbm/landing/faq_opened"(platform: "/", type: TrackType.Event) {
        faq(
            required: true,
            type: PropertyType.String,
            description: "Wich FAQ has been opened."
        )
    }

}
