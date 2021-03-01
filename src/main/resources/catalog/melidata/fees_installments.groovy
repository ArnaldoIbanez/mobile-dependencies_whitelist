import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    initiative = "1148"

    propertyDefinitions {
        product_id(
            required: true,
            type: PropertyType.String,
            description: "Indicates the ID of the product"
        )
        payment_method_id(
            required: true,
            type: PropertyType.String,
            description: "Indicates the ID of the payment method"
        )
        release_option_id(
            required: true,
            type: PropertyType.String,
            description: "Indicates the ID of the release option"
        )
        installment(
            required: true,
            type: PropertyType.String,
            description: "Indicates the name of the installment"
        )
        fee(
            required: true,
            type: PropertyType.Numeric,
            description: "Indicates the value of the installment"
        )
        tooltip_id(
            required: true,
            type: PropertyType.String,
            description: "Indicates the ID of the tooltip"
        )
        url(
            required: true,
            type: PropertyType.String,
            description: "Indicates the url value"
        )
        footer_id(
            required: true,
            type: PropertyType.String,
            description: "Indicates the ID of the footer"
        )
        status(
            required: true,
            type: PropertyType.Numeric,
            description: "Indicates the status received"
        )
        message(
            required: true,
            type: PropertyType.String,
            description: "The message received"
        )
    }

    propertyGroups {
        product_id_group(product_id)
        payment_method_id_group(payment_method_id)
        release_option_id_group(release_option_id)
        reelase_option_value_group(installment, fee)
        error_group(status, message)
        error_group_release_options(product_id, status, message)
        release_option_value_group(installment, fee)
        tooltip_disabled_group(product_id, tooltip_id)
        tooltip_disabled_action_group(product_id, tooltip_id, url)
        footer_action_group(footer_id, url)
        footer_tooltip_group(footer_id, tooltip_id)
        footer_tooltip_action_group(footer_id, tooltip_id, url)
        url_group(url)
    }

    def release_option_value_type = objectSchemaDefinitions {
        release_option_value_group
    }

    def release_option_type = objectSchemaDefinitions {
        release_option_id_group
        values(
            required: true,
            type: PropertyType.ArrayList(PropertyType.Map(release_option_value_type)),
            description: "A group of release option values"
        )
    }

    def payment_method_type = objectSchemaDefinitions {
        payment_method_id_group
        release_options(
            required: true,
            type: PropertyType.ArrayList(PropertyType.Map(release_option_type)),
            description: "A group of release options"
        )
    }

    def value_type = objectSchemaDefinitions {
        product_id_group
        payment_methods(
            required: true,
            type: PropertyType.ArrayList(PropertyType.Map(payment_method_type)),
            description: "A group of payment methods"
        )
    }

    // Abstract paths
    "/fees_installments" (platform: "/", isAbstract: true) {}
    "/fees_installments/fees" (platform: "/", isAbstract: true) {}
    "/fees_installments/fees/product" (platform: "/", isAbstract: true) {}
    "/fees_installments/fees/product/configure" (platform: "/", isAbstract: true) {}
    "/fees_installments/fees/product/configure/disable/tooltip" (platform: "/", isAbstract: true) {}
    "/fees_installments/fees/product/configure/disable" (platform: "/", isAbstract: true) {}
    "/fees_installments/fees/product/footer" (platform: "/", isAbstract: true) {}
    "/fees_installments/fees/product/footer/tooltip" (platform: "/", isAbstract: true) {}
    "/fees_installments/fees_selection" (platform: "/", isAbstract: true) {}
    "/fees_installments/fees_selection/update" (platform: "/", isAbstract: true) {}
    "/fees_installments/faq" (platform: "/", isAbstract: true) {}

    // Paths

    // TASAS & PLAZOS //

    "/fees_installments/fees/view"(platform: "/", type: TrackType.View) { }

    "/fees_installments/fees/success"(platform: "/", type: TrackType.Event) {
        value(
            required: true,
            type: PropertyType.ArrayList(PropertyType.Map(value_type)),
            description: "Group of values"
        )
    }

    "/fees_installments/fees/error" (platform: "/", type: TrackType.Event) {
        error_group
    }

    "/fees_installments/fees/product/configure/action" (platform: "/", type: TrackType.Event) {
        product_id_group
    }

    "/fees_installments/fees/product/configure/disable/tooltip/show" (platform: "/", type: TrackType.Event) {
        tooltip_disabled_group
    }

    "/fees_installments/fees/product/configure/disable/tooltip/hide" (platform: "/", type: TrackType.Event) {
        tooltip_disabled_group
    }

    "/fees_installments/fees/product/configure/disable/tooltip/primary" (platform: "/", type: TrackType.Event) {
        tooltip_disabled_action_group
    }

    "/fees_installments/fees/product/configure/disable/tooltip/secondary" (platform: "/", type: TrackType.Event) {
        tooltip_disabled_action_group
    }

    "/fees_installments/fees/product/footer/action" (platform: "/", type: TrackType.Event) {
        footer_action_group
    }

    "/fees_installments/fees/product/footer/tooltip/show" (platform: "/", type: TrackType.Event) {
        footer_tooltip_group
    }

    "/fees_installments/fees/product/footer/tooltip/hide" (platform: "/", type: TrackType.Event) {
        footer_tooltip_group
    }

    "/fees_installments/fees/product/footer/tooltip/primary" (platform: "/", type: TrackType.Event) {
        footer_tooltip_action_group
    }

    "/fees_installments/fees/product/footer/tooltip/secondary" (platform: "/", type: TrackType.Event) {
        footer_tooltip_action_group
    }

    // RELEASE OPTIONS //

    "/fees_installments/fees_selection/view" (platform: "/", type: TrackType.View) {
        product_id_group
    }

    "/fees_installments/fees_selection/success" (platform: "/", type: TrackType.Event) {
        value(
            required: true,
            type: PropertyType.Map(value_type),
            description: "A single value"
        )
    }

    "/fees_installments/fees_selection/error" (platform: "/", type: TrackType.Event) {
        error_group_release_options
    }

    "/fees_installments/fees_selection/update/success" (platform: "/", type: TrackType.Event) {
        value(
            required: true,
            type: PropertyType.Map(value_type),
            description: "A single value"
        )
    }

    "/fees_installments/fees_selection/update/error" (platform: "/", type: TrackType.Event) {
        error_group_release_options
    }

    "/fees_installments/fees_selection/back" (platform: "/", type: TrackType.Event) {
        product_id_group
    }

    "/fees_installments/fees_selection/cancel" (platform: "/", type: TrackType.Event) {
        product_id_group
    }

    // FAQ WEB VIEW //

    "/fees_installments/faq/view" (platform: "/", type: TrackType.View) {
        url_group
    }

    "/fees_installments/faq/error" (platform: "/", type: TrackType.Event) {
        error_group
    }

    "/fees_installments/faq/back" (platform: "/", type: TrackType.Event) {}
}