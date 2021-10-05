package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1145"

    "/melidata"(platform: "/", isAbstract: true) {}

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

    "/melidata/statistics/experiments"(platform: "/mobile", type: TrackType.Control, parentPropertiesInherited: false) {
        start_time()
        duration(type: PropertyType.Numeric)
        experiments_amount(type: PropertyType.Numeric)
        persistence_enabled(type:PropertyType.Boolean)
        experiment_to_retrieve()
        execution_status(values: ['successful', 'error'])
        error(required: false)
    }

    "/melidata/null_track"(platform: "/mobile") {
        context()
    }

    "/melidata/delete_old_tracks"(platform: "/mobile") {
        count()
    }

    "/melidata/shrink_database"(platform: "/mobile", isAbstract: true) {
        delete_records( type: PropertyType.Numeric, description: "Number of records/tracks deleted when shrinking")
        previous_size (type: PropertyType.Numeric, description: "Size of database before shrinking in bytes")
        current_size (type: PropertyType.Numeric , description: "Size of database after shrinking in bytes")
    }

    "/melidata/shrink_database"(platform: "/mobile/android", type: TrackType.Control ) {}
    "/melidata/shrink_database"(platform: "/mobile/ios", type: TrackType.Event ) {}
    
    "/melidata/ab_split"(platform: "/", type: TrackType.Event ) {}
}

