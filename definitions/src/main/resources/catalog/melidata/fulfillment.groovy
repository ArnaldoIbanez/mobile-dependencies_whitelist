import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/fbm"(platform: "/", isAbstract: true) {}
    "/fbm/panel"(platform: "/", isAbstract: true) {}
    "/fbm/panel/inbound"(platform: "/", isAbstract: true) {}
    "/full"(platform: "/", isAbstract: true) {}
    "/full/landing"(platform: "/", isAbstract: true) {}

    //Views
    "/fbm/panel/inbound/units"(platform: "/", type: TrackType.View) {}
    "/fbm/panel/inbound/labeling"(platform: "/", type: TrackType.View) {}
    "/fbm/panel/inbound/identifiers"(platform: "/", type: TrackType.View) {}
    "/full/landing/buyer"(platform: "/", type: TrackType.View) {}

    // Events
    //Change value input in units page
    "/fbm/panel/inbound/units/input_change"(platform: "/", type: TrackType.Event) {
        warning_type(
            required: true,
            type: PropertyType.String,
            description: "Type of warning showed after change value",
            values: ["show_restriction", "show_incentive"]
        )
        warning_value(
            required: true,
            type: PropertyType.Numeric,
            description: "Value max or min allowed",
        )
        inbound_id(
            required: true,
            type: PropertyType.Numeric,
            description: "Id of the inbound being edited",
        )
        inventory_id(
            required: true,
            type: PropertyType.String,
            description: "Id of the unit being edited",
        )
        input_value(
            required: true,
            type: PropertyType.Numeric,
            description: "New value entered by the user",
        )
    }

    //Submit units with error
    "/fbm/panel/inbound/units/submit_error"(platform: "/", type: TrackType.Event) {
        warnings(
            required: true,
            type:PropertyType.ArrayList,
            description: "List of errors showed",
        )
    }

    //Delete a unit on units page
    "/fbm/panel/inbound/units/input_delete"(platform: "/", type: TrackType.Event) {
        inbound_id(
            required: true,
            type: PropertyType.Numeric,
            description: "Id of the inbound being edited",
        )
        inventory_id(
            required: true,
            type: PropertyType.String,
            description: "Id of the unit being edited",
        )
    }
}
