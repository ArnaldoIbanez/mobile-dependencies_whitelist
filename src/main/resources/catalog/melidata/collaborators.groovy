package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

/**
*
* The events means actions that happens without launch a View,
* as example of that we can consider Bookmark an item in a VIP page
* Every event is an action, so the verbs available are:
*
* - back:  the event of back from a page, specially in mobile
* - abort: the user abort the action (e.g: back pressed before api response)
* - delete: when something is deleted
* - apply: when a criteria is applied
* - post: create a new entity
*/

tracks {

    initiative = "1148"

    "/collaborators"(platform:"/", isAbstract: true) {
    }

    "/collaborators/home"(platform:"/", type: TrackType.View) {
        type(required: true, type: PropertyType.String, description: 'Indicates the source of the tracking, i.e. form')
        from(required: true, values: ['unknown', 'mail', 'banner'], description: 'Indicates from which CTA was redirected. Unknown means that it did not come from any CTA.')
        source(required: true, type: PropertyType.String, description: 'Indicates the type of origin')
        have_operators(required: true, type: PropertyType.Boolean, description: 'Indicates if you have operators in the new version')
    }

    "/collaborators/invite"(platform:"/", type: TrackType.View) {
        email_already_exists(required: true, type: PropertyType.Boolean, description: 'Email already exists.')
    }

    "/collaborators/link_stores"(platform:"/", type: TrackType.View) {}

    "/collaborators/detail"(platform:"/", type: TrackType.View) {
        type(required: true, values: ['role', 'operator', 'invitation'], type: PropertyType.String, description: 'Indicates the type of detail that is selected.')
    }

    "/collaborators/select_role"(platform:"/", type: TrackType.View) {
        type(required: true, type: PropertyType.String, description: 'Indicates the source of the tracking, i.e. form')
    }

    "/collaborators/transform_account"(platform:"/", type: TrackType.View) {
        type(required: true, type: PropertyType.String, description: 'Indicates the source of the tracking, i.e. form')
    }

    "/collaborators/deadline"(platform:"/", type: TrackType.View) {
        type(required: true, type: PropertyType.String, description: 'Indicates the source of the tracking, i.e. form')
    }

    "/collaborators/deadline/form"(platform:"/", type: TrackType.View) {
        type(required: true, type: PropertyType.String, description: 'Indicates the source of the tracking, i.e. form')
    }

    "/collaborators/contact_owner"(platform:"/", type: TrackType.View) {
        type(required: true, type: PropertyType.String, description: 'Indicates the source of the tracking, i.e. form')
    }

    "/collaborators/scopes"(platform:"/", type: TrackType.View) {}

    "/collaborators/scopes/detail"(platform:"/mobile", type: TrackType.View) {
        scope(required: true, type: PropertyType.String, description: 'Indicates the scope that this view must show.')
    }

    "/collaborators/scopes/continue"(platform:"/mobile", type: TrackType.Event) {}

    "/collaborators/scopes/save"(platform:"/mobile", type: TrackType.Event) {}

    "/collaborators/role"(platform:"/", isAbstract: true) {}

    "/collaborators/role/name"(platform:"/mobile", type: TrackType.View) {}

    "/collaborators/role/congrats"(platform:"/mobile", type: TrackType.View) {
    	type(required: true, type: PropertyType.String, description: 'Indicates the result of the congrats.')
    }

    "/collaborators/congrats"(platform:"/", type: TrackType.View) {
    	type(required: true, type: PropertyType.String, description: 'Indicates the result of the congrats.')
    }

    "/collaborators/shield"(platform:"/mobile", type: TrackType.View) {
        screen_name(required: true, type: PropertyType.String, description: 'Indicates the view name that show the shield')
        scopes_requested(required: true, type: PropertyType.ArrayList(PropertyType.String), description: 'Indicates the scopes that the screen required')
        scopes_missing(required: true, type: PropertyType.ArrayList(PropertyType.String), description: 'Indicates the scopes that do not match those required on the screen')
        entry_method(required: true, values: ['no_conformed_protocol', 'required_scopes', 'supported_scopes', 'support_operators', 'show_shield', 'set_show_shield'], type: PropertyType.String, description: 'Indicates the entry method of the shield')
    }
}
