
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

/**
*
* The events means actions that happens without launch a View,
* as example of that we can consider Bookmark an item in a VIP page
* Every event is an action, so the verbs available are:
*
* - back:  the event of back from a page, specially in mobile
* - abort: the user abort the action (e.g: back pressed before api response)
* - delete: when something is deleted
* - apply: when a criteria is applied
* - post: create a new entity
*/

tracks {

    "/"(platform: "/mobile", isAbstract: true) {
        sent_again(required: false)
    }

    "/"(platform: "/web", isAbstract: true) {
    }

    "/melidata"(platform: "/mobile", isAbstract: true) {}

    "/melidata/statistics"(platform: "/mobile", type: TrackType.Event) {
        errors_counter(type: PropertyType.Map)
        last_send_timestamp()
        total_pending_tracks()
        send_counter()
        database_size()
        tracks_counter()
        average_ok_time()
        average_error_time()
        last_statistics_timestamp(required: false)
    }

    "/melidata/delete_old_tracks"(platform: "/mobile") {
        count()
    }

    "/melidata/shrink_database"(platform: "/mobile", isAbstract: true) {
        delete_records( type: PropertyType.Numeric, description: "Number of records/tracks deleted when shrinking")
        previous_size (type: PropertyType.Numeric, description: "Size of database before shrinking in bytes")
        current_size (type: PropertyType.Numeric , description: "Size of database after shrinking in bytes")
    }

}

