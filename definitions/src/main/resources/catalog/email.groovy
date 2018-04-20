import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

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

    "/email/shipping_backoffice/generic"(platform: "/email") {
        campaign_name(required: true,
                description: "Name of the current mail campaign in which is included the email")
        campaign_date(required: true,
                description: "The date of current email sent")
        is_test(required: true,
                description: "represent if the email is a real email or a test email (wich es sent to validate the correct content)")
    }

    "/email/generic"(platform: "/email"){}

    "/email/question"(platform: "/email"){}

    "/email/checkout"(platform: "/email"){}

    "/email/reputation"(platform: "/email"){}

    "/email/access"(platform: "/email"){}

    "/email/sale"(platform: "/email"){}

    "/email/mediation"(platform: "/email"){}

    "/email/auction_end"(platform: "/email"){}

    "/email/withdrawal"(platform: "/email"){}

    "/email/fup_feedback"(platform: "/email"){}

    "/email/message"(platform: "/email"){}
}
