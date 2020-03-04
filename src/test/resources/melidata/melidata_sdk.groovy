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

        "/melidata/statistics"(platform:"/mobile", type:TrackType.Event){
            errors_counter = ["java.io.EOFException":2, "nullpointer":3]
            last_send_timestamp="2015-01-21T13:14:09.415-0300"
            total_pending_tracks=2
            send_counter=6
            database_size=16384
            tracks_counter=12
            average_ok_time=10
            average_error_time=11
        }

        "/melidata/shrink_database"(platform:"/mobile/android", type:TrackType.Control){
            delete_records=40
            current_size=69632
            previous_size=110592
        }

        "/melidata/shrink_database"(platform:"/mobile/ios", type:TrackType.Event){
            delete_records=50
            current_size=82322
            previous_size=122592
        }       
    }
    
    test("melidata AB URL Spliting "){
        "/melidata/ab_split"(platform:"/mobile/ios", type:TrackType.Event){}
        "/melidata/ab_split"(platform:"/mobile/android", type:TrackType.Event){}
        
        "/melidata/ab_split"(platform:"/mobile/ios", type:TrackType.Event, business:"mercadopago"){}
    }
}
