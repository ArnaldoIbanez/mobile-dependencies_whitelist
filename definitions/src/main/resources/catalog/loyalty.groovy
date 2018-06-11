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
        autoselected_filters(required: true)
        available_subscriptions(required: true)
        backend_data(required: true)
        banner(required: true)
        billboards(required: true)
        buying_mode(required: true)
        canonical(required: true)
        cart_content(required: true)
        category_id(required: true)
        category_path(required: true)
        comparator_available(required: true)
        config_version(required: true)
        contract_available(required: true)
        currency_id(required: true)
        deal_ids(required: true)
        default_tab(required: true)
        description_type(required: true)
        filters(required: true)
        free_shipping(required: true)
        free_shipping_benefit(required: true)
        gallery_pattern(required: true)
        has_logos(required: true)
        item_condition(required: true)
        item_id(required: true)
        item_status(required: true)
        landing(required: true)
        layout(required: true)
        layout_forced(required: true)
        limit(required: true)
        listing_type_id(required: true)
        local_pick_up(required: true)
        logistic_type(required: true)
        loyalty_level(required: true)
        max_size_gallery(required: true)
        offset(required: true)
        original_price(required: true)
        pads(required: true)
        power_seller_status(required: true)
        price(required: true)
        promise_items(required: true)
        quantity(required: true)
        query(required: true)
        related_searches_info(required: true)
        reputation_level(required: true)
        results(required: true)
        return_available(required: true)
        review_rate(required: true)
        reviews_attributes(required: true)
        seller_id(required: true)
        shipping_mode(required: true)
        shipping_preference(required: true)
        shipping_promise(required: true)
        shown_as_product(required: true)
        sort_id(required: true)
        specifications_size(required: true)
        subscription_discount(required: true)
        total(required: true)
        upper_funnel(required: true)
        vertical(required: true)
        visual_id(required: true)
   }

}
