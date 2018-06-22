import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/wms"(platform: "/mobile", isAbstract: true) {
        warehouse_id(required: false, type: PropertyType.String)
        user_id(required: false, type: PropertyType.String)
        email(required: false, type: PropertyType.String)
        first_name(required: false, type: PropertyType.String)
        last_name(required: false, type: PropertyType.String)
        error_type(values: ["SERVER", "NETWORK", "ZRP", "TIMEOUT"],
        	type: PropertyType.String,
            description: "Type of error event")
        feedback_type(values: ["SUCCESS", "ERROR", "WARNING", "LOCKED"],
        	type: PropertyType.String,
            description: "Type of feedback event")
    }

	"/wms/receiving"(platform: "/mobile", type: TrackType.View) {}
	"/wms/put_away"(platform: "/mobile", type: TrackType.View) {}
	"/wms/inbound_audit"(platform: "/mobile", type: TrackType.View) {}
	"/wms/transfer"(platform: "/mobile", type: TrackType.View) {}
	"/wms/found"(platform: "/mobile", type: TrackType.View) {}
	"/wms/restock"(platform: "/mobile", type: TrackType.View) {}
	"/wms/picking"(platform: "/mobile", type: TrackType.View) {}
	"/wms/return"(platform: "/mobile", type: TrackType.View) {}

}