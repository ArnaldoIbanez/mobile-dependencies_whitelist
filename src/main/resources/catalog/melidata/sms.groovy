package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType

tracks {

    initiative = "1034"

    "/sms"(platform: "/", isAbstract: true) {}

    "/sms/generic"(platform: "/"){
        sent_date(required: true)
        communication_id(required: true, type: PropertyType.String, description: "sms communication id")
        segment_name(required: false, type: PropertyType.String, description: "Identifies a user segment within a communication (e.g. communication_id=remarketing, communication_version=1.0.0, segment_name=loyals")
        experiment_name(required: false, type: PropertyType.String, description: "Identifies an experiment within a communication (e.g. communication_id=remarketing, communication_version=1.0.0, segment_name=loyals, experiment_name=layout1")
        communication_data(required: false, type: PropertyType.String, description: "Specific data for the campaign")
    }

}
