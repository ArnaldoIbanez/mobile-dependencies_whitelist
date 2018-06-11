import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //Loyalty

    "/loyalty"(platform: "/", isAbstract: true) {
        level(type: PropertyType.Numeric, required: false)
        points(type: PropertyType.Numeric, required: false)
        percentage(type: PropertyType.Numeric, required: false)
    }

    "/loyalty/score"(type: TrackType.View) {}

    "/loyalty/score/milestones"(type: TrackType.View) {} //Milestones tab
    "/loyalty/score/benefits"(type: TrackType.View) {} //Benefits tab
    "/loyalty/score/achievements"(type: TrackType.View) {} //Achievements tab

    "/loyalty/score/benefit"(platform: "/", type: TrackType.View) {
        benefit(required: true, description: "Indicates which benefit was viewed")
    }

    //Loyalty Program User Tracking
    "/loyalty/user"(platform: "/", type: TrackType.Event) {
        in_loyalty_program(
                required: true,
                type: PropertyType.Boolean,
                description: "Indicates if the user is in or out of the loyalty program"
        )
    }

    "/loyalty/user/change_level"(platform: "/", type: TrackType.Event) {
        old_level(type: PropertyType.Numeric, required: true, description: "Indicates previews user level"
        )
    }


    "/loyalty/user/benefit"(platform: "/", type: TrackType.Event) {
        benefit(required: true, description: "Indicates which benefit was used")
        consumable(required: true,
                type: PropertyType.Boolean,
                description: "Indicates if the benefit is consumable"
        )
        reference(required: true, description: "Reference to the order")
    }

    "/loyalty/user/expire_points"(platform: "/", type: TrackType.Event) {
        expired_points(required: true, description: "Points expired")
        due_date(required: true, description: "Due date for expiration")
    }

    "/loyalty/user/float_notification"(platform: "/", type: TrackType.Event) {
        event_type(required: true, description: "Description of loyalty notification event")
        notification_ids(required: true, description: "List of notification ids" )
    }

    "/loyalty/landing"(platform: "/", type: TrackType.Event) {
        landing_id(required: true, description: "id of landing") 
    }

    "/loyalty/notification"(type: TrackType.Event) {
        event_type(required: true,
                values: ["received", "dismiss", "open", "shown", "delayed"],
                description: "Type of loyalty notification event")
        autoselected_filters(required: false)
        available_subscriptions(required: false)
        backend_data(required: false)
        banner(required: false)
        billboards(required: false)
        buying_mode(required: false)
        canonical(required: false)
        cart_content(required: false)
        category_id(required: false)
        category_path(required: false)
        comparator_available(required: false)
        config_version(required: false)
        contract_available(required: false)
        currency_id(required: false)
        deal_ids(required: false)
        default_tab(required: false)
        description_type(required: false)
        filters(required: false)
        free_shipping(required: false)
        free_shipping_benefit(required: false)
        gallery_pattern(required: false)
        has_logos(required: false)
        item_condition(required: false)
        item_id(required: false)
        item_status(required: false)
        landing(required: false)
        layout(required: false)
        layout_forced(required: false)
        limit(required: false)
        listing_type_id(required: false)
        local_pick_up(required: false)
        logistic_type(required: false)
        loyalty_level(required: false)
        max_size_gallery(required: false)
        offset(required: false)
        original_price(required: false)
        pads(required: false)
        power_seller_status(required: false)
        price(required: false)
        promise_items(required: false)
        quantity(required: false)
        query(required: false)
        related_searches_info(required: false)
        reputation_level(required: false)
        results(required: false)
        return_available(required: false)
        review_rate(required: false)
        reviews_attributes(required: false)
        seller_id(required: false)
        shipping_mode(required: false)
        shipping_preference(required: false)
        shipping_promise(required: false)
        shown_as_product(required: false)
        sort_id(required: false)
        specifications_size(required: false)
        subscription_discount(required: false)
        total(required: false)
        upper_funnel(required: false)
        vertical(required: false)
        visual_id(required: false)
   }

}
