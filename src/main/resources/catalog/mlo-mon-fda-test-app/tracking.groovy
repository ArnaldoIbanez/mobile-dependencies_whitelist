package src.main.resources.catalog.advertising

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    
    "/"(platform: "/") {}

    "/input"(platform: "/api") { 
	    record(type: PropertyType.Map(record_info), required:true)
    }

    def record_info = objectSchemaDefinitions {
        data(type: PropertyType.Map(record_data), required:true)
    }

    def record_data = objectSchemaDefinitions {
        user_id(type: PropertyType.Numeric, required: true)
        is_payer(type: PropertyType.Boolean, required: false)
        status(type: PropertyType.String, values: ["OK", "ERROR"], required: true)
    }

}