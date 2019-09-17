
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
    "/collaborators_admin"(platform:"/web", type: TrackType.View) {
        from(required: true, values: ['unknown', 'mail', 'banner'], description: 'Indicates from which CTA was redirected. Unknown means that it did not come from any CTA.')
        source(required: true, type: PropertyType.String, description: 'Indicates the type of origin')
        have_operators(required: true, type: PropertyType.Boolean, description: 'Indicates if you have operators in the new version')
        segmentation(required: true, type: PropertyType.String, description: 'Indicates to which migration stage it belongs.')
    }

    "/collaborators_admin/invite"(platform:"/web", type: TrackType.View, parentPropertiesInherited: false) {
        segmentation(required: true, type: PropertyType.String, description: 'Indicates to which migration stage it belongs.')
        email_already_exists(required: true, type: PropertyType.Boolean, description: 'Email already exists.')
    }

    "/collaborators_admin/link_stores"(platform:"/web", type: TrackType.View, parentPropertiesInherited: false) {}

    "/collaborators_admin/roles/"(platform:"/web", isAbstract: true, parentPropertiesInherited: false) {}

    "/collaborators_admin/roles/create"(platform:"/web", type: TrackType.View, parentPropertiesInherited: false) {
        email(required: true, type: PropertyType.String, description: 'Email of the new operator.')
        segmentation(required: true, type: PropertyType.String, description: 'Indicates to which migration stage it belongs.')
    }

    "/collaborators_admin/congrats"(platform:"/web", type: TrackType.View, parentPropertiesInherited: false) {
        type(required: true, type: PropertyType.String, description: 'Indicates the result of the creation of the operator.')
        segmentation(required: true, type: PropertyType.String, description: 'Indicates to which migration stage it belongs.')
    }

    "/collaborators"(platform:"/web", isAbstract: true) {
        type(required: true, type: PropertyType.String, description: 'Indicates the source of the tracking, i.e. form')
        segmentation(required: true, type: PropertyType.String, description: 'Indicates to which migration stage it belongs.')
    }

    "/collaborators/select_role"(platform:"/web", type: TrackType.View) {}

    "/collaborators/transform_account"(platform:"/web", type: TrackType.View) {}

    "/collaborators/deadline"(platform:"/web", type: TrackType.View) {}

    "/collaborators/deadline/form"(platform:"/web", type: TrackType.View) {}

    "/collaborators/contact_owner"(platform:"/web", type: TrackType.View) {}

}
