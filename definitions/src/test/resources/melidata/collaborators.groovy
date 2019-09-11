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
            email = 'colaborador@owner.io'
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
}