import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    // cada conjunto de valores de tasa y plazo que muestra un release option.
    def release_option_value = objectSchemaDefinitions {
        order(
            required: true, 
            type: PropertyType.Numeric,
            description: "Orden en que se muestran los valores de la tasas y plazos de un release option."
        )
        installment(
            required: true, 
            type: PropertyType.String, 
            description: "El plazo del release option."
            )
        fee(
            required: true, 
            PropertyType.String, 
            description: "La tasas del release option"
        )
    }

    // los datos asociados de un payment method.
    def payment_method = objectSchemaDefinitions {
        channel_id(
            required: true, 
            type: PropertyType.String, 
            description: "El id del canal al cual pertenece el payment method."
        )
        payment_method_id(
            required: true, 
            type: PropertyType.String, 
            description: "El id del payment method."
        )
        release_option_id(
            required: true, 
            type: PropertyType.String, 
            description: "El id del release option que actualmente tiene seleccionado el usuario para el payment method."
        )
        order(
            required: true, 
            type: PropertyType.Numeric, 
            description: "Orden en que se muestran los valores de la tasas y plazos de un payment method."
        )
        editable(
            required: true, 
            type: PropertyType.Boolean, 
            description: "Indica si los valores de las tasas pueden ser cambiados."
        )
        release_option_values(
            required: true, 
            type: PropertyType.ArrayList(PropertyType.Map(release_option_value)), 
            description: "El conjunto de valores de tasa y plazo que muestra un release option."
        )
    }

    // Contiene un conjunto de métodos de pagos para un canal dado.
    def payment = objectSchemaDefinitions {
        channel_id(
            required: true, 
            type: PropertyType.String, 
            description: "El id del canal al cual pertenece el payment method."
        )
        order(
            required: true, 
            type: PropertyType.Numeric, 
            description: "Orden en que se muestran los valores de la tasas y plazos de un release option."
        )
        payment_methods(
            required: true, 
            type: PropertyType.ArrayList(PropertyType.Map(payment_method)), 
            description: "El conjunto de los datos asociados de un payment method."
        )
    }

    propertyDefinitions {
        url(
            required: true, 
            type: PropertyType.String, 
            description: "La url completa de la faq."
        )
        message(
            required: true, 
            type: PropertyType.String, 
            description: "El mensaje de error."
        )
        deeplink(
            required: true, 
            type: PropertyType.String, 
            description: "La url del deeplink."
        )
    }

    propertyGroups {
        urlGroup(url)
        urlErrorGroup(url, message)
        erroGroup(message)
        deeplinkGroup(deeplink)
    }

    /* ----------------------------------------------------------------------------- */
    /* Componente de tasas y plazos.                                                 */
    /* ----------------------------------------------------------------------------- */

    "/fees_installment/payment_method/view"(platform: "/", type: TrackType.View) {}
    "/fees_installment/payment_method/success"(platform: "/", type: TrackType.Event) {
        payments(
            required: true, 
            type: PropertyType.ArrayList(PropertyType.Map(payment)), 
            description: "El conjunto de payments."
        )
    }
    "/fees_installment/payment_method/selection_action"(platform: "/", type: TrackType.Event) {
        payment(
            required: true, 
            type: PropertyType.Map(payment), 
            description: "El payment que se está por modificar."
        )
    }
    "/fees_installment/payment_method/error"(platform: "/", type: TrackType.Event) {
        erroGroup
    }
    "/fees_installment/payment_method/footer_action"(platform: "/", type: TrackType.Event) {
        urlGroup
    }

    /* ----------------------------------------------------------------------------- */
    /* Pantalla de seleción de tasas y plazos.                                       */
    /* ----------------------------------------------------------------------------- */

    "/fees_installment/release_option/view"(platform: "/", type: TrackType.View) {}
    "/fees_installment/release_option/footer_action"(platform: "/", type: TrackType.Event) {
        urlGroup
    }
    "/fees_installment/release_option/update"(platform: "/", type: TrackType.Event) {
        payment(
            required: true, 
            type: PropertyType.Map(payment), 
            description: "El payment que se está por modificar."
        )
    }
    "/fees_installment/release_option/error"(platform: "/", type: TrackType.Event) {
        erroGroup
    }
    "/fees_installment/release_option/back"(platform: "/", type: TrackType.Event) {}

    /* ----------------------------------------------------------------------------- */
    /* Pantalla de la Faq.                                                           */
    /* ----------------------------------------------------------------------------- */

    "/fees_installment/faq/view"(platform: "/", type: TrackType.View) {
        urlGroup
    }
    "/fees_installment/faq/error"(platform: "/", type: TrackType.Event) {
        urlErrorGroup
    }
    "/fees_installment/faq/success"(platform: "/", type: TrackType.Event) {
        urlGroup
    }
    "/fees_installment/faq/back"(platform: "/", type: TrackType.Event) {}


    /* ----------------------------------------------------------------------------- */
    /* Pantalla de tasas y plazos.                                                   */
    /* ----------------------------------------------------------------------------- */

    "/fees_installment/deeplink_usage"(platform: "/", type: TrackType.View) {
        deeplinkGroup
    }
}