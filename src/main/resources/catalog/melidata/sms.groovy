package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType

tracks {

    initiative = "1034"
    
    "/sms"(platform: "/", isAbstract: true) {
        sent_date(required: false)
        text_message(required: false)
        communication_id(required: false, type: PropertyType.String, description: "Sms campaign id")
        communication_version(required: false, type: PropertyType.String, description: "Sms campaign version")
        segment_id(required: false, type: PropertyType.String, description: "Identifies a user segment within a communication (e.g. communication_id=remarketing, communication_version=1.0.0, segment_id=loyals")
        experiment_id(required: false, type: PropertyType.String, description: "Identifies an experiment within a communication (e.g. communication_id=remarketing, communication_version=1.0.0, segment_id=loyals, experiment_id=layout1")
    }

    "/sms/generic"(platform: "/"){}

}
