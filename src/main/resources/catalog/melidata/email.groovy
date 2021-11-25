package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType

tracks {

    initiative = "1034"

    "/email"(platform: "/", isAbstract: true) {
        email_template(required: true)
        event_type(required: true,
                values: ["send", "open", "cancel", "cancel_old_emails", "processed", "dropped", "delivered", "deferred",
                         "bounce", "open", "click", "spam_report", "unsubscribe", "group_unsubscribe", "group_resubscribe"],
                description: "Type of email event")
        email_id(required: false)
        subject(required: false)
        sent_date(required: false)
        mailbox_provider(required: false, type: PropertyType.String, description: "Recipient mailbox provider, e.g. gmail.com, hotmail.com, etc")
        email_client(required: false, type: PropertyType.String, description: "Recipient email client, e.g. Gmail Webmail, Gmail App, etc")
        provider(required: false,
                values: ["ironport","sendgrid","sparkpost"],
                type: PropertyType.String, description: "Email Service Provider which generated this track event")
        communication_id(required: false, type: PropertyType.String, description: "Email campaign id")
        communication_version(required: false, type: PropertyType.String, description: "Email campaign version")
        segment_id(required: false, type: PropertyType.String, description: "Identifies a user segment within a communication (e.g. communication_id=remarketing, communication_version=1.0.0, segment_id=loyals")
        experiment_id(required: false, type: PropertyType.String, description: "Identifies an experiment within a communication (e.g. communication_id=remarketing, communication_version=1.0.0, segment_id=loyals, experiment_id=layout1")
        provider_feedback(required: false, type: PropertyType.Boolean, description: "Used to identify events reported by the " +
                "Email Service Provider (e.g. Sendgrid), in particular send and open, which might be reported by the provider " +
                "and also by the emails-api")
        click_link_id(required: false, type: PropertyType.String, description: "Identifies which link was clicked in the email, in the case of event_type=click")
    }

    "/email/orders"(platform: "/email") {
        order_id(required: true)
        order_date_created(required: true)
        order_status(required: true)
        seller_id(required: true)
        is_risk_user(required: false)
        total_amount(required: true)
        payments(required: true, type:PropertyType.ArrayList, description: "Array of payments in the purchase with following data")
             // id
             // status
             // status_detail
             // type
             // method_id
             // date_approved
             // date_created
             // date_last_modified
        shipping_type(required: false, description: "tipo de shipping por ejemplo: custom_shipping")
        buy_equals_pay(required: false, description: "Indica si la compra es B=P")
    }

    "/email/shipping_backoffice"(platform: "/email") {
        campaign_name(required: true,
                description: "Name of the current mail campaign in which is included the email")
        campaign_date(required: true,
                description: "The date of current email sent")
        is_test(required: true,
                description: "Represent if the email is a real email or a test email (which is sent to validate the correct content)")
    }

    "/email/generic"(platform: "/email"){}

    "/email/question"(platform: "/email"){}

    "/email/reputation"(platform: "/email"){}

    "/email/access"(platform: "/email"){}

    "/email/sale"(platform: "/email"){}

    "/email/mediation"(platform: "/email"){}

    "/email/auction_end"(platform: "/email"){}

    "/email/withdrawal"(platform: "/email"){}

    "/email/fup_feedback"(platform: "/email"){}

    "/email/message"(platform: "/email"){}

    "/email/checkout"(platform: "/email", isAbstract: true, initiative: "1104"){
        purchase_id(required: true)
        purchase_status(required:false, type: PropertyType.String, description: "Purchase status based on its payments statuses")
        shipping_type(required:true, type: PropertyType.String, description: "First purchase's shipping option type.")
        payments(required: true, type:PropertyType.ArrayList, description: "Array of payments in the purchase with following data")
//            // id,
//            // status,
//            // status_detail,
//            // type,
//            // method_id,
//            // date_created,
//            // date_approved,
//            // date_last_modified,
        buy_equals_pay(required: false, type: PropertyType.Boolean)
    }

    // mails for: purchases with all its payments approved or authorized
    "/email/checkout/ok"(platform: "/email"){}

    // mails for: purchases with some of its payments rejected
    "/email/checkout/error"(platform: "/email"){}

    // mails for: purchases with some of its payments in process
    "/email/checkout/in_process"(platform: "/email"){}

    // mails for: purchases with some of its payments pending
    "/email/checkout/pending"(platform: "/email"){}

    // mails for: purchases with some of its payments cancelled
    "/email/checkout/cancelled"(platform: "/email"){}

    // mails for: purchases with some of its payments refunded
    "/email/checkout/refunded"(platform: "/email"){}

    // mails for: showing unsubscribe view
    "/email/form_optout"(platform: "/"){}

    // mails for: unsubscribe from emails reception
    "/email/form_optout/unsubscribe"(platform: "/", type: TrackType.Event){
        selected_option(required: true, description: "Selected option in unsubscribe view as cause of unsubscription")
    }

    "/email/chargebacks"(platform: "/email") {
        case_id(required: true, type: PropertyType.String)
        receiver_id(required: true, type: PropertyType.Numeric)
    }
}
