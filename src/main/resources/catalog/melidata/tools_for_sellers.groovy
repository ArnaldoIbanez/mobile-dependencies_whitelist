import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1148"

    //filter definition
    def filter_definition = objectSchemaDefinitions {
        filter_id (type: PropertyType.String, required: true)
        filter_value (type: PropertyType.String, required: true)
    }

    //Account mydata
    "/account"(platform: "/web", isAbstract: true) {}
    "/account/mydata"(platform: "/web", isAbstract: true) {}
    "/account/mydata/email"(platform: "/", type: TrackType.View) {}
    "/account/mydata/email/congrats"(platform: "/web", type: TrackType.View) {}

    //My business
    "/my_business"(platform: "/", type: TrackType.View){}
    "/my_business/how_it_works_ME"(platform: "/", type: TrackType.Event){
        how_it_works_me(required: true, type: PropertyType.String, values: ["click", "tap"], description: "Indicates how works the track")
    }
    "/my_business/enable_ME"(platform: "/", type: TrackType.Event){
        mercado_envios(required: true, type: PropertyType.String, values: ["enable", "disable"],description: "Indicates if mercado envios is enabled")
    }
    "/my_business/disable_ME"(platform: "/", type: TrackType.Event){
        mercado_envios(required: true, type: PropertyType.String, values: ["enable", "disable"],description: "Indicates if mercado envios is enabled")
    }

    "/my_business/split_payment"(platform: "/", type: TrackType.Event){
        split_payment(required: true, type: PropertyType.String, values: ["enabled", "disabled"],description: "Indicates if split payment is enabled")
    }
    "/my_business/recovery_mails"(platform: "/", type: TrackType.Event){
        recovery_mails(required: true, type: PropertyType.String, values: ["enabled", "disabled"],description: "Indicates if recovery mail is enabled")
    }
    "/my_business/cost_absorption"(platform: "/", type: TrackType.Event){
        cost_absorption(required: true, type: PropertyType.String, values: ["deactivate", "activate", "modificate"],description: "Indicates cost absorption status")
    }

    //Stores
    "/stores"(platform: "/", isAbstract: true) {}
    "/stores/create"(platform: "/", type: TrackType.View) {}
    "/stores/link_operators"(platform: "/", type: TrackType.View) {}
    "/stores/list"(platform: "/", type: TrackType.View) {}
    "/stores/update"(platform: "/", type: TrackType.View) {}
    "/stores/details"(platform: "/", type: TrackType.View) {}
    "/stores/pos"(platform: "/", type: TrackType.View, isAbstract:true) {}
    "/stores/pos/create"(platform: "/", type: TrackType.View) {}
    "/stores/pos/update"(platform: "/", type: TrackType.View) {}
    "/stores/standalone_pos"(platform: "/", type: TrackType.View) {}
    "/stores/move_pos"(platform: "/", type: TrackType.View) {}


    //Tu negocio
    "/your_business"(platform: "/web", isAbstract: true) {}
    "/your_business/home"(platform: "/web", type: TrackType.View) {
        show_tax_warning(required: false, description: "the name of the tax card", type: PropertyType.String)
    }
    "/your_business/image_upload"(platform:"/web", type: TrackType.Event) {}
    "/your_business/mydata_edit"(platform:"/web", type: TrackType.Event) {}
    "/your_business/confirm_action"(platform:"/web", type: TrackType.Event) {
        card_name(required: true, description: "the name of the card that triggered the event", type: PropertyType.String)
    }
    "/your_business/link"(platform:"/web", type: TrackType.Event) {
        card_name(required: true, description: "the name of the card that triggered the event", type: PropertyType.String)
        path(required: true, description: "path of the next page", type: PropertyType.String)
    }


    // Traks for dashboard section
    "/tfs_dashboard"(platform: "/", isAbstract: true) {}
    "/tfs_dashboard/home"(platform: "/", type: TrackType.View) {}
    "/tfs_dashboard/home/general"(platform: "/", type: TrackType.View) {}
    "/tfs_dashboard/home/offline"(platform: "/", type: TrackType.View) {}
    "/tfs_dashboard/home/online"(platform: "/", type: TrackType.View) {}
    "/tfs_dashboard/home/meli"(platform: "/", type: TrackType.View) {}
    "/tfs_dashboard/detail"(platform: "/", type: TrackType.View) {
        chart_id (required: true, type: PropertyType.String, description: "The chart ID of the detail")
        section (required: true, type: PropertyType.String, description: "The section owner of the chart")
    }
    "/tfs_dashboard/compare"(platform: "/", type: TrackType.View) {}
    "/tfs_dashboard/filters"(platform: "/", type: TrackType.View) {}

    // Events for dashboard section
    "/tfs_dashboard/tab_selection"(platform: "/", type: TrackType.Event) {
        section (required: true, type: PropertyType.String, description: "The selected section")
    }
    "/tfs_dashboard/hint"(platform: "/", type: TrackType.Event) {
        chart_id (required: true, type: PropertyType.String, description: "The chart ID of the hint")
        section (required: true, type: PropertyType.String, description: "The section owner of the hint")
    }
    "/tfs_dashboard/home/delta"(platform: "/", type: TrackType.Event) {
        chart_id (required: true, type: PropertyType.String, description: "The chart ID of the delta")
        section (required: true, type: PropertyType.String, description: "The section owner of the delta")
    }
    "/tfs_dashboard/detail/delta"(platform: "/", type: TrackType.Event) {
        chart_id (required: true, type: PropertyType.String, description: "The chart ID of the delta")
        section (required: true, type: PropertyType.String, description: "The section owner of the delta")
    }

    "/tfs_dashboard/home/filters_apply"(platform: "/", type: TrackType.Event) {
        section (required: true, type: PropertyType.String, description: "The section when filter")
        filters (required: true, type: PropertyType.ArrayList(PropertyType.Map(filter_definition)), description: "Filters")
    }
    "/tfs_dashboard/detail/filters_apply"(platform: "/", type: TrackType.Event) {
        chart_id (required: true, type: PropertyType.String, description: "The chart ID when filter")
        section (required: true, type: PropertyType.String, description: "The section when filter")
        filters (required: true, type: PropertyType.ArrayList(PropertyType.Map(filter_definition)), description: "Filters")
    }
    "/tfs_dashboard/compare"(platform: "/", type: TrackType.Event) {
        chart_id (required: false, type: PropertyType.String, description: "The chart ID when compare")
        section (required: false, type: PropertyType.String, description: "The section when compare")
    }

    // Errors for dashboard section
    "/tfs_dashboard/home/error"(platform: "/", type: TrackType.Event) {
        status_code (required: false, type: PropertyType.Numeric, description: "Error status code")
    }
    "/tfs_dashboard/detail/error"(platform: "/", type: TrackType.Event) {
        chart_id (required: true, type: PropertyType.String, description: "The chart ID when error")
        section (required: true, type: PropertyType.String, description: "The section when error")
        status_code (required: false, type: PropertyType.Numeric, description: "Error status code")
    }

    "/tfs_dashboard/home/card"(platform: "/", isAbstract: true) {}
    "/tfs_dashboard/home/card/error"(platform: "/", type: TrackType.Event) {
        chart_id (required: true, type: PropertyType.String, description: "The chart ID when error")
        section (required: true, type: PropertyType.String, description: "The section when error")
        status_code (required: false, type: PropertyType.Numeric, description: "Error status code")
    }
}