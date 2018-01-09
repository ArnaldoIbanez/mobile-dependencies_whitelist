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

    "/loyalty/notification"(type: TrackType.Event) {
        event_type(required: true,
                values: ["received", "dismiss", "open", "shown", "delayed"],
                description: "Type of loyalty notification event")
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
    }

    "/loyalty/user/expire_points"(platform: "/", type: TrackType.Event) {
        expired_points(required: true, description: "Points expired")
        due_date(required: true, description: "Due date for expiration")
    }

    "/loyalty/user/float_notification"(platform: "/", type: TrackType.Event) {
        event_type(required: true, description: "Description of loyalty notification event")
        notification_ids(required: true, description: "List of notification ids" )
    }
}
