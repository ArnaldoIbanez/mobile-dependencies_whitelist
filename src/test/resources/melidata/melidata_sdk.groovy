package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("melidata"){
        "/melidata/delete_old_tracks" (platform:"/mobile", type:TrackType.Event) {
            count = 10
        }

        "/melidata/null_track" (platform:"/mobile", type:TrackType.Event) {
            context = "DescriptionFragment"
        }

        "/melidata/statistics"(platform:"/mobile/android", type:TrackType.Event){
            errors_counter=["java.io.EOFException":2, "nullpointer":3]
            last_send_timestamp="2015-01-21T13:14:09.415-0300"
            total_pending_tracks=2
            stream_pending_tracks=10
            melidata_pending_tracks=20
            send_counter=6
            database_size=16384
            tracks_counter=12
            stream_tracks_counter=20
            melidata_tracks_counter=15
            average_ok_time=10
            average_error_time=11
            last_statistics_timestamp="2015-01-21T13:14:09.415-0300"
            melidata_complete_dispatch_counter=5
            stream_complete_dispatch_counter=2
        }

        "/melidata/statistics"(platform:"/mobile/ios", type:TrackType.Event){
            error_counter=5
            errors_array=["Error1","Error2"]
            total_tracks_generated=10
            total_pending_tracks=2
            send_counter=6
            database_size=16384
            last_statistics_timestamp="2015-01-21T13:14:09.415-0300"
        }

        "/melidata/statistics/experiments"(platform:"/mobile", type:TrackType.Control){
            start_time="2015-01-21T13:14:09.415-0300"
            duration=230
            experiments_amount=6
            persistence_enabled=true
            experiment_to_retrieve="ALL"
            execution_status="error"
            error="error_name"
        }

        "/melidata/shrink_database"(platform:"/mobile/android", type:TrackType.Control ) {
            current_size=69632
            previous_size=110592
            most_common_path="/search"
            deleted_records=40
        }

        "/melidata/shrink_database"(platform: "/mobile/ios", type: TrackType.Event ) {
            current_size=82322
            previous_size=122592
            delete_records=50
        }       
    }
    
    test("melidata AB URL Spliting "){
        "/melidata/ab_split"(platform:"/mobile/ios", type:TrackType.Event){}
        "/melidata/ab_split"(platform:"/mobile/android", type:TrackType.Event){}
        
        "/melidata/ab_split"(platform:"/mobile/ios", type:TrackType.Event, business:"mercadopago"){}
    }
}
