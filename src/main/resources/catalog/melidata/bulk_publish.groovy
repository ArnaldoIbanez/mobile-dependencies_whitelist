package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1029"

    "/seller_central"(platform: "/web", isAbstract: true) {}

    "/seller_central/bulk"(platform: "/web", isAbstract: true) {}

    "/seller_central/bulk/publish"(platform: "/web", isAbstract: true) {}

    "/seller_central/bulk/publish/hub"(platform: "/web", type: TrackType.View) {}

    "/seller_central/bulk/publish/categories"(platform: "/web", type: TrackType.View) {}

    "/seller_central/bulk/publish/categories/tab_selection"(platform: "/web", type: TrackType.Event) {
        tab(required: true, type: PropertyType.String, description: "name of tab selected by user")
    }

    "/seller_central/bulk/publish/download"(platform: "/web", isAbstract: true) {}

    "/seller_central/bulk/publish/download/congrats"(platform: "/web", type: TrackType.View) {}

    "/seller_central/bulk/publish/upload"(platform: "/web", type: TrackType.View) {}

    "/seller_central/bulk/publish/upload/show_custom_mail_box"(platform: "/web", type: TrackType.Event) {
        show_custom_mail_box(required: true, type: PropertyType.Boolean, description: "Value to know if user has clicked on Add other email")
    }

    "/seller_central/bulk/publish/upload/send_custom_mail_box"(platform: "/web", type: TrackType.Event) {
        show_custom_mail_box(required: true, type: PropertyType.Boolean, description: "Value to know if user has clicked on Add other email")
        custom_mail(required: true, type: PropertyType.Boolean, description: "Value to know if user was completed the custom email field")
        invalid_mail(required: true, type: PropertyType.Boolean, description: "Value to know if email value is valid or invalid")
    }

    "/seller_central/bulk/publish/upload/congrats"(platform: "/web", type: TrackType.View) {}

    "/seller_central/bulk/publish/categories/download_excel"(platform: "/web", type: TrackType.Event) {
        total(required: true, type: PropertyType.Numeric, description: "The total number of categories that were downloaded")
        last_published(required: true, type: PropertyType.Numeric, description: "The total number of categories that were downloaded from last published section")
        most_used(required: true, type: PropertyType.Numeric, description: "The total number of categories that were downloaded from most used section")
        search_list(required: true, type: PropertyType.Numeric, description: "The total number of categories that were downloaded from search section")
        modal(required: true, type: PropertyType.Numeric, description: "The total number of categories that were downloaded from modal")
    }

    "/seller_central/bulk/publish/categories/adult"(platform: "/web", isAbstract: true) {}

    "/seller_central/bulk/publish/categories/adult/confirm"(platform: "/web", type: TrackType.Event) {
        adult(required: true, type: PropertyType.Boolean, description: "Value to know if user has select adult checkbox")
    }

    "/seller_central/bulk/publish/categories/adult/modal"(platform: "/web", type: TrackType.Event) {
        action(required: true, type: PropertyType.String, description: "Modal action", values: ['confirm', 'cancel', 'show'])
        adult(required: true, type: PropertyType.Boolean, description: "Value to know if user has select adult checkbox")
    }

    "/seller_central/bulk/publish/categories/adult/modal/show"(platform: "/web", parentPropertiesInherited: false, type: TrackType.View) {
        adult(required: true, type: PropertyType.Boolean, description: "Value to know if user has select adult checkbox")
    }

    "/seller_central/bulk/publish/categories/catalog_task"(platform: "/web", isAbstract: true) {}

    "/seller_central/bulk/publish/categories/catalog_task/show"(platform: "/web", type: TrackType.Event) {}

    "/seller_central/bulk/publish/upload/email"(platform: "/web", isAbstract: true) {}

    "/seller_central/bulk/publish/upload/email/congrats"(platform: "/web", type: TrackType.Event) {}
}
