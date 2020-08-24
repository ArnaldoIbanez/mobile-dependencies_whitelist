package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("Came into new version" ) {
        "/collaborators/home"(platform:"/web", type: TrackType.View) {
            type = 'form'
            from = 'mail'
            source = 'seven_day'
            have_operators = true
        }
    }

    test("Start of creation of a new operator" ) {
        "/collaborators/invite"(platform:"/web", type: TrackType.View) {
            email_already_exists = false
        }
    }

    test("Start of creation of a role for the new operator" ) {
        "/collaborators/scopes"(platform:"/", type: TrackType.View) {}
        "/collaborators/link_stores"(platform:"/", type: TrackType.View) {}
    }

    test("Detail of a created role") {
        "/collaborators/detail"(platform:"/", type: TrackType.View) {
            type = 'role'
        }
    }

    test("Detail of a created operator") {
        "/collaborators/detail"(platform:"/", type: TrackType.View) {
            type = 'operator'
        }
    }

    test("Detail of a created invitation") {
        "/collaborators/detail"(platform:"/", type: TrackType.View) {
            type = 'invitation'
        }
    }

    test("Collaborators") {
        "/collaborators"(platform:"/web", type: TrackType.View) {}
    }

    test("Select role") {
        "/collaborators/select_role"(platform:"/", type: TrackType.View) {
            type = 'form'
        }
    }

    test("Transform account") {
        "/collaborators/transform_account"(platform:"/web", type: TrackType.View) {
            type = 'form'
        }
    }

    test("Deadline") {
        "/collaborators/deadline"(platform:"/web", type: TrackType.View) {
            type = 'form'
        }
    }

    test("Deadline form") {
        "/collaborators/deadline/form"(platform:"/web", type: TrackType.View) {
            type = 'form'
        }
    }

    test("Contact owner") {
        "/collaborators/contact_owner"(platform:"/web", type: TrackType.View) {
            type = 'form'
        }
    }

    test("Show scopes") {
        "/collaborators/scopes"(platform:"/", type: TrackType.View) {}
    }

    test("Show scope detail") {
        "/collaborators/scopes/detail"(platform:"/mobile", type: TrackType.View) {
            scope = 'test_scope'
        }
    }

    test("Tap continue") {
        "/collaborators/scopes/continue"(platform:"/mobile", type: TrackType.Event) {}
    }

    test("Tap save") {
        "/collaborators/scopes/save"(platform:"/mobile", type: TrackType.Event) {}
    }
 
    test("Show congrats in create role") {
        "/collaborators/role/congrats"(platform:"/mobile", type: TrackType.View) {
            type = "success"
        }
    }

    test("Finish of creation of the new operator" ) {
        "/collaborators/congrats"(platform:"/", type: TrackType.View) {
            type = 'success'
        }
    }

    test("Enter role name") {
        "/collaborators/role/name"(platform:"/mobile", type: TrackType.View) {}
    }

    test("Show shield view") {
        "/collaborators/shield"(platform:"/mobile", type: TrackType.View) {
            screen_name = 'NameViewController'
            scopes_requested = ['pay_qr', 'collect_on_site']
            scopes_missing = ['pay_qr']
            entry_method = 'required_scope'
       }
    }

    defaultBusiness = "mercadolibre"

    test("Came into new version" ) {
        "/collaborators/home"(platform:"/web", type: TrackType.View) {
            type = 'form'
            from = 'mail'
            source = 'seven_day'
            have_operators = true
        }
    }

    test("Start of creation of a new operator" ) {
        "/collaborators/invite"(platform:"/web", type: TrackType.View) {
            email_already_exists = false
        }
    }

    test("Start of creation of a role for the new operator" ) {
        "/collaborators/scopes"(platform:"/", type: TrackType.View) {}
        "/collaborators/link_stores"(platform:"/web", type: TrackType.View) {}
    }

    test("Finish of creation of the new operator" ) {
        "/collaborators/congrats"(platform:"/web", type: TrackType.View) {
            type = 'success'
        }
    }

        test("Detail of a created role") {
        "/collaborators/detail"(platform:"/web", type: TrackType.View) {
            type = 'role'
        }
    }

    test("Detail of a created operator") {
        "/collaborators/detail"(platform:"/web", type: TrackType.View) {
            type = 'operator'
        }
    }

    test("Detail of a created invitation") {
        "/collaborators/detail"(platform:"/web", type: TrackType.View) {
            type = 'invitation'
        }
    }

    test("Collaborators") {
        "/collaborators"(platform:"/web", type: TrackType.View) {
        }
    }

    test("Select role") {
        "/collaborators/select_role"(platform:"/web", type: TrackType.View) {
            type = 'form'
        }
    }

    test("Transform account") {
        "/collaborators/transform_account"(platform:"/web", type: TrackType.View) {
            type = 'form'
        }
    }

    test("Deadline") {
        "/collaborators/deadline"(platform:"/web", type: TrackType.View) {
            type = 'form'
        }
    }

    test("Deadline form") {
        "/collaborators/deadline/form"(platform:"/web", type: TrackType.View) {
            type = 'form'
        }
    }

    test("Contact owner") {
        "/collaborators/contact_owner"(platform:"/web", type: TrackType.View) {
            type = 'form'
        }
    }

    test("Show scopes") {
        "/collaborators/scopes"(platform:"/", type: TrackType.View) {}
    }

    test("Show scope detail") {
        "/collaborators/scopes/detail"(platform:"/mobile", type: TrackType.View) {
            scope = 'test_scope'
        }
    }

    test("Tap continue") {
        "/collaborators/scopes/continue"(platform:"/mobile", type: TrackType.Event) {}
    }

    test("Tap save") {
        "/collaborators/scopes/save"(platform:"/mobile", type: TrackType.Event) {}
    }

    test("Show congrats in create role") {
        "/collaborators/role/congrats"(platform:"/mobile", type: TrackType.View) {
            type = "success"
        }
    }

    test("Enter role name") {
        "/collaborators/role/name"(platform:"/mobile", type: TrackType.View) {}
    }

    test("Show shield view") {
        "/collaborators/shield"(platform:"/mobile", type: TrackType.View) {
            screen_name = 'NameViewController'
            scopes_requested = ['pay_qr', 'collect_on_site']
            scopes_missing = ['pay_qr']
            entry_method = 'required_scope'
       }
    }
}