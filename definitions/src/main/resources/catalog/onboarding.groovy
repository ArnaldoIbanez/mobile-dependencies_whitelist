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

    "/onboarding/flow"(platform: "/mobile", type: TrackType.View) {}

}