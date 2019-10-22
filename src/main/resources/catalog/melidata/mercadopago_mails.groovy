package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    defaultBusiness = "mercadopago"
    "/email"(platform: "/email", isAbstract: true) {
        email_template(required: true)
        event_type(required: true,
                values: ["send", "open", "cancel"],
                description: "Type of email event")
        email_id(required: false)
        subject(required: false)
        sent_date(required: false)
    }

    "/email/generic"(platform: "/email"){

    }

    "/email/congrats"(platform: "/email"){
        days(type: PropertyType.Numeric, required: true)
    }

    "/email/next_to_overdue"(platform: "/email"){
        days(type: PropertyType.Numeric, required: true)
    }

    "/email/late_fee"(platform: "/email"){
        days(type: PropertyType.Numeric, required: true)
    }

    "/email/new"(platform: "/email", isAbstract: true){
    }

    "/email/new/optout"(platform: "/email"){
    }
}
