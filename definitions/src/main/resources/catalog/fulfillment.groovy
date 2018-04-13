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

    //Contact me Button at the Top of the page
    "/fbm/landing/contact_me_button_top"(platform: "/", type: TrackType.Event) {}

    //Contact me Button at the Bottom of the page
    "/fbm/landing/contact_me_button_bottom"(platform: "/", type: TrackType.Event) {}

    //FAQs about Fulfillment
    "/fbm/landing/open_faq_opt_in"(platform: "/", type: TrackType.Event) {}
    "/fbm/landing/open_faq_dc_location"(platform: "/", type: TrackType.Event) {}
    "/fbm/landing/open_faq_send_my_inventory"(platform: "/", type: TrackType.Event) {}
    "/fbm/landing/open_faq_send_inventory_from_supplier"(platform: "/", type: TrackType.Event) {}
    "/fbm/landing/open_faq_fees"(platform: "/", type: TrackType.Event) {}
    "/fbm/landing/open_faq_manage_inventory"(platform: "/", type: TrackType.Event) {}

    //Hotjar
    "/fbm/landing/hotjar"(platform: "/", type: TrackType.Event) {
        hotjar_user_id(
            required: true,
            type: PropertyType.Numeric,
            description: "Recording id of hotjar."
        )
    }

}
