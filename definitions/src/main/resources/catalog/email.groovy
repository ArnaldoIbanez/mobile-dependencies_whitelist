import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType

tracks {

    "/email"(platform: "/email", isAbstract: true) {
        email_template(required: true)
        event_type(required: true,
                values: ["send", "open", "cancel"],
                description: "Type of email event")
        email_id(required: false)
        subject(required: false)
        sent_date(required: false)
    }

    "/email/orders"(platform: "/email") {
        order_id(required: true)
        order_date_created(required: true)
        order_status(required: true)
        seller_id(required: true)
        is_risk_user(required: false)
        total_amount(required: true)
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

    "/email/checkout"(platform: "/email", isAbstract: true){
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
        buy_equals_pay(required: true, type: PropertyType.Boolean)
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
}
