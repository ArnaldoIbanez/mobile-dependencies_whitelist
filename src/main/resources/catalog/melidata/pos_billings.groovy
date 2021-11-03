import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1300"

    propertyDefinitions {
        share_type(required: true, type: PropertyType.String, description: "export share type", values: ["download", "email"])
        context(required: true, type: PropertyType.String, description: "screen triggering the event", values: ["billings", "invoice"])
        masive(required: true, type: PropertyType.Boolean, description: 'indicates if more than one billing is being exported')
    }
 
    propertyGroups {
        export_props(share_type, context, masive)
    }

    "/pos_billings"(platform: "/", type: TrackType.View, isAbstract: true) {}

    "/pos_billings/billings"(platform: "/", type: TrackType.View) {
        certificate(required: true, type: PropertyType.String, description: "certificate status", values: ["ACTIVE", "INACTIVE", "WARNING"])
    }

    "/pos_billings/friction"(platform: "/", type: TrackType.View, isAbstract: true) {}

    "/pos_billings/friction/certificate_warning"(platform: "/", type: TrackType.Event) {}

    "/pos_billings/friction/certificate_expired"(platform: "/", type: TrackType.Event) {}

    "/pos_billings/search"(platform: "/", type: TrackType.Event) {
        creation_start_date(required: false, type: PropertyType.String, description: "start date filtered")
        creation_end_date(required: false, type: PropertyType.String, description: "end date filtered")
        store_ids(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "stores filtered")
        pos_ids(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "points of sale filtered")
        statuses(required: false, type: PropertyType.ArrayList(PropertyType.String), description: "status filtered")
        input(required: false, type: PropertyType.String, description: "input filtered")
        input_type(required: false, type: PropertyType.String, description: "input type filtered")
    }

    "/pos_billings/filters"(platform: "/", type: TrackType.View) {}

    "/pos_billings/export"(platform: "/", type: TrackType.View) { export_props }

    "/pos_billings/export/confirm"(platform: "/", type: TrackType.Event) { export_props }

    "/pos_billings/export/success"(platform: "/", type: TrackType.Event) { export_props }

    "/pos_billings/friction/export"(platform: "/", type: TrackType.Event) { export_props }

    "/pos_billings/invoice"(platform: "/", type: TrackType.View) {}
}
