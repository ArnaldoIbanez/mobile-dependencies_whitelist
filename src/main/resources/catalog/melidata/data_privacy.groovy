package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

  initiative = "1208"

  "/landing_data_privacy"(platform: "/", isAbstract: true) {}
  "/landing_data_privacy/event"(platform: "/", isAbstract: true) {}

  "/landing_data_privacy"(platform: "/", type: TrackType.View) {}

  "/landing_data_privacy/event/click"(platform: "/", type: TrackType.Event) {
    text (required: true, type: PropertyType.String, description: "The text clicked")
    component (required: true, type: PropertyType.String, description: "The component type (quick_access, link, sidebar)")
  }
  "/landing_data_privacy/event/scroll"(platform: "/", type: TrackType.Event) {
    text (required: true, type: PropertyType.String, description: "The active section in view")
    component (required: false, type: PropertyType.String, description: "The component type")
  }
  "/landing_data_privacy/event/hover"(platform: "/", type: TrackType.Event) {
    text (required: true, type: PropertyType.String, description: "The tooltip id hovered")
    component (required: false, type: PropertyType.String, description: "The component type")
  }
}