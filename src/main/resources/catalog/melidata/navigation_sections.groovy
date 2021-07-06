package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


tracks {
    
    initiative = '1074'
    // View

    "/navigation_sections"(platform: "/mobile", isAbstract: true){}

    "/navigation_sections/navigation_menu_mp"(platform: "/mobile", type: TrackType.View) {}
    "/navigation_sections/navigation_menu_ml"(platform: "/mobile", type: TrackType.View) {}

    "/navigation_sections/your_profile"(platform: "/mobile", type: TrackType.View) {}
    "/navigation_sections/your_business"(platform: "/mobile", type: TrackType.View) {}
    "/navigation_sections/your_business_v2"(platform: "/mobile", type: TrackType.View) {}

    // Events

    "/navigation_sections/navigation_menu_mp/tap"(platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Section id tapped")
    }
    "/navigation_sections/navigation_menu_ml/tap"(platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Section id tapped")
    }

    "/navigation_sections/your_profile/tap"(platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Section tapped")
    }
    "/navigation_sections/your_business/tap"(platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Section tapped")
    }
    "/navigation_sections/your_business_v2/tap"(platform: "/mobile", type: TrackType.Event) {
        id(required: true, type: PropertyType.String, description: "Section tapped")
    }

}