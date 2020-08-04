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
        type(required: true, type: PropertyType.String, description: 'Indicates the source of the tracking, i.e. form')
    }

    "/collaborators/home"(platform:"/", type: TrackType.View) {
        from(required: true, values: ['unknown', 'mail', 'banner'], description: 'Indicates from which CTA was redirected. Unknown means that it did not come from any CTA.')
        source(required: true, type: PropertyType.String, description: 'Indicates the type of origin')
        have_operators(required: true, type: PropertyType.Boolean, description: 'Indicates if you have operators in the new version')
    }

    "/collaborators/invite"(platform:"/", type: TrackType.View, parentPropertiesInherited: false) {
        email_already_exists(required: true, type: PropertyType.Boolean, description: 'Email already exists.')
    }

    "/collaborators/link_stores"(platform:"/", type: TrackType.View, parentPropertiesInherited: false) {}

    "/collaborators/scopes"(platform:"/", type: TrackType.View, parentPropertiesInherited: false) {}

    "/collaborators/congrats"(platform:"/", type: TrackType.View, parentPropertiesInherited: false) {
        type(required: true, type: PropertyType.String, description: 'Indicates the result of the creation of the operator.')
    }

    "/collaborators/detail"(platform:"/", type: TrackType.View, parentPropertiesInherited: false) {
        type(required: true, values: ['role', 'operator', 'invitation'], type: PropertyType.String, description: 'Indicates the type of detail that is selected.')
    }

    "/collaborators/select_role"(platform:"/", type: TrackType.View) {}

    "/collaborators/transform_account"(platform:"/", type: TrackType.View) {}

    "/collaborators/deadline"(platform:"/", type: TrackType.View) {}

    "/collaborators/deadline/form"(platform:"/", type: TrackType.View) {}

    "/collaborators/contact_owner"(platform:"/", type: TrackType.View) {}

    "/collaborators/scopes"(platform:"/", type: TrackType.View, parentPropertiesInherited: false) {}

    "/collaborators/scopes/detail"(platform:"/mobile", type: TrackType.View, parentPropertiesInherited: false) {
        scope(required: true, type: PropertyType.String, description: 'Indicates the scope that this view must show.')
    }

    "/collaborators/scopes/continue"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/collaborators/scopes/save"(platform:"/mobile", type: TrackType.Event, parentPropertiesInherited: false) {}

    "/collaborators/role"(platform:"/", isAbstract: true, parentPropertiesInherited: false) {}

    "/collaborators/role/name"(platform:"/mobile", type: TrackType.View, parentPropertiesInherited: false) {}

    "/collaborators/role/congrats"(platform:"/mobile", type: TrackType.View, parentPropertiesInherited: false) {
    	type(required: true, type: PropertyType.String, description: 'Indicates the result of the congrats.')
    }

    "/collaborators/congrats"(platform:"/", type: TrackType.View, parentPropertiesInherited: false) {
    	type(required: true, type: PropertyType.String, description: 'Indicates the result of the congrats.')
    }
}
