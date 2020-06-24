package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = '1101'

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

    "/email/form_optout"(platform: "/"){
        email_template(required: true, type: PropertyType.String, description: "emails-api template")
        event_type(required: true, values: ["send", "open", "click", "unsubscribe"], description: "Type of email event")
        communication_id(required: false, type: PropertyType.String, description: "Email campaign id")
        communication_version(required: false, type: PropertyType.String, description: "Email campaign version")
        segment_id(required: false, type: PropertyType.String, description: "Identifies a user segment within a communication (e.g. communication_id=remarketing, communication_version=1.0.0, segment_id=loyals")
        experiment_id(required: false, type: PropertyType.String, description: "Identifies an experiment within a communication (e.g. communication_id=remarketing, communication_version=1.0.0, segment_id=loyals, experiment_id=layout1")
        sent_date(required: false, type: PropertyType.String, description: "Email sent date")
        provider(required: false, values: ["ironport","sendgrid"], type: PropertyType.String, description: "Email Service Provider which generated this track event")
        provider_feedback(required: false, type: PropertyType.Boolean, description: "Used to identify events reported by the " +
                "Email Service Provider (e.g. Sendgrid), in particular send and open, which might be reported by the provider " +
                "and also by the emails-api")
    }

    "/email/form_optout/unsubscribe"(platform: "/", type: TrackType.Event){
        selected_option(required: true, description: "Selected option in unsubscribe view as cause of unsubscription")
    }
}
