package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("Came into new version" ) {
        "/collaborators_admin"(platform:"/web", type: TrackType.View) {
            from = 'mail'
            source = 'seven_day'
            have_operators = true
            segmentation = 'first_stage'
        }
    }

    test("Start of creation of a new operator" ) {
        "/collaborators_admin/invite"(platform:"/web", type: TrackType.View) {
            segmentation = 'first_stage'
            email_already_exists = false
        }
    }

    test("Start of creation of a role for the new operator" ) {
        "/collaborators_admin/roles"(platform:"/web", type: TrackType.View) {}
        "/collaborators_admin/roles/create"(platform:"/web", type: TrackType.View) {
            segmentation = 'first_stage'
        }
        "/collaborators_admin/link_stores"(platform:"/web", type: TrackType.View) {}
    }

    test("Finish of creation of the new operator" ) {
        "/collaborators_admin/congrats"(platform:"/web", type: TrackType.View) {
            type = 'success'
            segmentation = 'first_stage'
        }
    }

    test("Collaborators") {
        "/collaborators"(platform:"/web", type: TrackType.View) {
            type = 'form'
            segmentation = 'first_stage'
        }
    }

    test("Select role") {
        "/collaborators/select_role"(platform:"/web", type: TrackType.View) {
            type = 'form'
            segmentation = 'first_stage'
        }
    }

    test("Transform account") {
        "/collaborators/transform_account"(platform:"/web", type: TrackType.View) {
            type = 'form'
            segmentation = 'first_stage'
        }
    }

    test("Deadline") {
        "/collaborators/deadline"(platform:"/web", type: TrackType.View) {
            type = 'form'
            segmentation = 'no-data'
        }
    }

    test("Deadline form") {
        "/collaborators/deadline/form"(platform:"/web", type: TrackType.View) {
            type = 'form'
            segmentation = 'no-data'
        }
    }

    test("Contact owner") {
        "/collaborators/contact_owner"(platform:"/web", type: TrackType.View) {
            type = 'form'
            segmentation = 'no-data'
        }
    }

    test("Show scopes") {
        "/collaborators/scopes"(platform:"/", type: TrackType.View) {}
    }

    test("Show scope detail") {
        "/collaborators/scopes/detail"(platform:"/", type: TrackType.View) {
            scope = 'test_scope'
        }
    }

    test("Tap continue") {
        "/collaborators/scopes/continue"(platform:"/", type: TrackType.Event) {}
    }

    defaultBusiness = "mercadolibre"

    test("Came into new version" ) {
        "/collaborators_admin"(platform:"/web", type: TrackType.View) {
            from = 'mail'
            source = 'seven_day'
            have_operators = true
            segmentation = 'first_stage'
        }
    }

    test("Start of creation of a new operator" ) {
        "/collaborators_admin/invite"(platform:"/web", type: TrackType.View) {
            segmentation = 'first_stage'
            email_already_exists = false
        }
    }

    test("Start of creation of a role for the new operator" ) {
        "/collaborators_admin/roles"(platform:"/web", type: TrackType.View) {}
        "/collaborators_admin/roles/create"(platform:"/web", type: TrackType.View) {
            segmentation = 'first_stage'
        }
        "/collaborators_admin/link_stores"(platform:"/web", type: TrackType.View) {}
    }

    test("Finish of creation of the new operator" ) {
        "/collaborators_admin/congrats"(platform:"/web", type: TrackType.View) {
            type = 'success'
            segmentation = 'first_stage'
        }
    }

    test("Collaborators") {
        "/collaborators"(platform:"/web", type: TrackType.View) {
            type = 'form'
            segmentation = 'first_stage'
        }
    }

    test("Select role") {
        "/collaborators/select_role"(platform:"/web", type: TrackType.View) {
            type = 'form'
            segmentation = 'first_stage'
        }
    }

    test("Transform account") {
        "/collaborators/transform_account"(platform:"/web", type: TrackType.View) {
            type = 'form'
            segmentation = 'first_stage'
        }
    }

    test("Deadline") {
        "/collaborators/deadline"(platform:"/web", type: TrackType.View) {
            type = 'form'
            segmentation = 'no-data'
        }
    }

    test("Deadline form") {
        "/collaborators/deadline/form"(platform:"/web", type: TrackType.View) {
            type = 'form'
            segmentation = 'no-data'
        }
    }

    test("Contact owner") {
        "/collaborators/contact_owner"(platform:"/web", type: TrackType.View) {
            type = 'form'
            segmentation = 'no-data'
        }
    }

    test("Show scopes") {
        "/collaborators/scopes"(platform:"/", type: TrackType.View) {}
    }

    test("Show scope detail") {
        "/collaborators/scopes/detail"(platform:"/", type: TrackType.View) {
            scope = 'test_scope'
        }
    }

    test("Tap continue") {
        "/collaborators/scopes/continue"(platform:"/", type: TrackType.Event) {}
    }

}