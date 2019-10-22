package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    //REVIEWS FRONTEND
    "/reviews/form"(platform: "/") {
        item_id()
        step()
        flow(required: false)
        action(required: false)
    }

    "/reviews/edit"(platform: "/") {
        item_id()
    }

    "/reviews/congrats/delete"(platform: "/") {
        item_id()
    }

    "/reviews/congrats/edit"(platform: "/") {
        item_id()
        review_length()
    }

    "/reviews/congrats"(platform: "/") {
        item_id()
        review_length(inheritable: false)
    }

    "/reviews/error"(platform: "/") {
        item_id()
    }

    "/reviews/email"(platform: "/email") {
        item_id()
    }

    "/reviews"(platform: "/") {
        item_id()
    }

    "/reviews/show"(platform: "/") {
        item_id(required: true)
        type(required: true)
        access(required: false)
        catalog_product_id(required: false)
        reviews_all_count(required: false)
        reviews_positive_count(required: false)
        reviews_negative_count(required: false)
        vote_up(required: false)
        vote_down(required: false)
        time_ellapsed(required: false)
        review_id(required: false)
        reviews_shown(required: false, type: PropertyType.ArrayList)
    }
}

