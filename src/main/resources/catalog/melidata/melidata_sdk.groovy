package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1145"

    "/melidata"(platform: "/", isAbstract: true) {}

    "/melidata/statistics"(platform: "/mobile", isAbstract: true) {}

    "/melidata/statistics"(platform: "/mobile/android", type: TrackType.Event) {
        errors_counter(type: PropertyType.Map)
        last_send_timestamp(type: PropertyType.String, required: false, description: "Last time a track was sent")
        total_pending_tracks(type: PropertyType.Numeric, required: true, description: "Total number of pending tracks")
        stream_pending_tracks(type: PropertyType.Numeric, required: false, description: "Number of pending tracks for Private Stream")
        melidata_pending_tracks(type: PropertyType.Numeric, required: false, description: "Number of pending tracks for Melidata")
        send_counter(type: PropertyType.Numeric, required: true, description: "Number of shippings")
        database_size(type: PropertyType.Numeric, required: true, description: "Database size")
        tracks_counter(type: PropertyType.Numeric, required: true, description: "Number of sent tracks")
        stream_tracks_counter(type: PropertyType.Numeric, required: false, description: "Number of sent tracks for Private Stream")
        melidata_tracks_counter(type: PropertyType.Numeric, required: false, description: "Number of sent tracks for Melidata")
        average_ok_time(type: PropertyType.Numeric, required: true, description: "Average time without errors")
        average_error_time()
        last_statistics_timestamp(type: PropertyType.String, required: false, description: "Last time statistics was sent")
        melidata_complete_dispatch_counter(type: PropertyType.Numeric, required: false, description: "Number of dispatches with amount of tracks same as limit for Melidata")
        stream_complete_dispatch_counter(type: PropertyType.Numeric, required: false, description: "Number of dispatches with amount of tracks same as limit for Private Stream")
    }

    "/melidata/statistics"(platform: "/mobile/ios", type: TrackType.Event) {
        error_counter(type: PropertyType.Numeric, required: true, description: "Tracks numbers of errors")
        errors_array(type: PropertyType.ArrayList(PropertyType.String), required: false, description: "Track errors array")
        total_tracks_generated(type: PropertyType.Numeric, required: true, description: "Number of tracks generated")
        total_pending_tracks(type: PropertyType.Numeric, required: true, description: "Number of pending tracks")
        send_counter(type: PropertyType.Numeric, required: true, description: "Number of tracks sent")
        database_size(type: PropertyType.Numeric, required: true, description: "Database size")
        last_statistics_timestamp(type: PropertyType.String, required: false, description: "Last time statistics was sent")
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
        previous_size (type: PropertyType.Numeric, description: "Size of database before shrinking in bytes")
        current_size (type: PropertyType.Numeric , description: "Size of database after shrinking in bytes")
        most_common_path (type: PropertyType.String, required: false, description: "Most common path in the Database")
    }

    "/melidata/shrink_database"(platform: "/mobile/android", type: TrackType.Control ) {
        deleted_records( type: PropertyType.Numeric, description: "Number of records/tracks deleted when shrinking")
    }
    "/melidata/shrink_database"(platform: "/mobile/ios", type: TrackType.Event ) {
        delete_records( type: PropertyType.Numeric, description: "Number of records/tracks deleted when shrinking")
    }
    
    "/melidata/ab_split"(platform: "/", type: TrackType.Event ) {}
}

