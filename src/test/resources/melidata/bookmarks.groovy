package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Bookmark tracking in android") {
        "/bookmarks/action/post" (platform:"/mobile", type: TrackType.Event) {
            item_id = "MLA533657947"
            action_location = "maininfo"
            context = "/vip"
        }

        "/bookmarks/action/delete" (platform:"/mobile", type: TrackType.Event) {
            item_id = "MLA533657947"
            action_location = "maininfo"
            context = "/myml"
        }
    }

    test("Bookmark tracking in web") {
        "/bookmarks/action/post" (platform:"/web", type: TrackType.Event) {
            item_id = "MLA533657947"
            context = "/search"
        }

        "/bookmarks/action/post" (platform:"/web", type: TrackType.Event) {
            item_id = "MLA533657947"
            context = "/vip"
        }
    }

    test("Bookmarks tracking add to cart") {
        "/bookmarks/add_to_cart" (type: TrackType.Event) {
            item_id = "MLA533657947"
            context = "/search"
        }
    }

    test("Bookmarks tracking in all platforms") {

        "/bookmarks/show_bookmarks" (type: TrackType.Event) {
            item_id = "MLA533657947"
            context = "/search"
        }

        "/bookmarks/load_more" (type: TrackType.Event) {
            item_id = "MLA533657947"
            context = "/search"
        }

        "/bookmarks/refresh" (type: TrackType.Event) {
            item_id = "MLA533657947"
            context = "/search"
        }

        "/bookmarks/show_server_error" (type: TrackType.Event) {
            item_id = "MLA533657947"
            context = "/search"
        }

        "/bookmarks/retry_after_error" (type: TrackType.Event) {
            item_id = "MLA533657947"
            context = "/search"
        }

        "/bookmarks/show_not_logged_in_feedback" (type: TrackType.Event) {
            item_id = "MLA533657947"
            context = "/search"
        }

        "/bookmarks/go_to_login" (type: TrackType.Event) {
            item_id = "MLA533657947"
            context = "/search"
        }

        "/bookmarks/show_ZRP" (type: TrackType.Event) {
            item_id = "MLA533657947"
            context = "/search"
        }

    }
}