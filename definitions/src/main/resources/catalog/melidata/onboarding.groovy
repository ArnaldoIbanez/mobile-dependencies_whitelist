import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/onboarding"(platform: "/mobile", isAbstract: true) {}

    "/onboarding/step"(platform: "/mobile", isAbstract: true) {}

    "/onboarding/step/chooser"(platform: "/mobile", type: TrackType.View) {}

    "/onboarding/cancel"(platform: "/mobile", type: TrackType.Event) {}

    "/onboarding/skip"(platform: "/mobile", type: TrackType.Event) {}

    "/onboarding/login"(platform: "/mobile", type: TrackType.Event) {}

    "/onboarding/registration"(platform: "/mobile", type: TrackType.Event) {
        type(type: PropertyType.String, required: true)
    }
    
    "/onboarding/step"(platform: "/mobile", type: TrackType.View) {
        onboarding_close_status(required: true, type: PropertyType.String, 
                                values: ["DEFAULT", "HIDDEN", "SHOWN"],
                                description: "Indicates if the close button is being shown, hidden or using its default state")
        onboarding_fb_login_on(required: true, type: PropertyType.Boolean,
                               description: "Indicates if the Facebook Login button is shown or not")
    }

    "/onboarding/flow"(platform: "/mobile", type: TrackType.View) {}

}
