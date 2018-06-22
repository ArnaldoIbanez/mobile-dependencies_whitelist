import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/wms"(platform: "/mobile/android", isAbstract: true) {
        warehouse_id(required: false, type: PropertyType.String,
        	description: "Id of the warehouse to track")
        email(required: false, type: PropertyType.String)
        first_name(required: false, type: PropertyType.String)
        last_name(required: false, type: PropertyType.String)
        error_type(
        	required: false,
        	values: ["SERVER", "NETWORK", "ZRP", "TIMEOUT"],
        	type: PropertyType.String,
            description: "Type of error event")
        feedback_type(
        	required: false,
        	values: ["SUCCESS", "ERROR", "WARNING", "LOCKED"],
        	type: PropertyType.String,
            description: "Type of feedback event")
    }

	"/wms/login"(platform: "/mobile/android", type: TrackType.View) {}
	"/wms/home"(platform: "/mobile/android", type: TrackType.View) {}
	"/wms/receiving"(platform: "/mobile/android", type: TrackType.View) {}
	"/wms/put_away"(platform: "/mobile/android", type: TrackType.View) {}
	"/wms/inbound_audit"(platform: "/mobile/android", type: TrackType.View) {}
	"/wms/transfer"(platform: "/mobile/android", type: TrackType.View) {}
	"/wms/found"(platform: "/mobile/android", type: TrackType.View) {}
	"/wms/restock"(platform: "/mobile/android", type: TrackType.View) {}
	"/wms/picking"(platform: "/mobile/android", type: TrackType.View) {}
	"/wms/return"(platform: "/mobile/android", type: TrackType.View) {}

}