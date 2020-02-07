
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1171"

    "/reviews"(platform: "/") {
        item_id()
    }

    //REVIEWS FRONTEND
    "/reviews/form"(platform: "/") {
        step()
        flow(required: false)
        action(required: false)
    }

    "/reviews/edit"(platform: "/") {}

    "/reviews/congrats/delete"(platform: "/") {}

    "/reviews/congrats/edit"(platform: "/") {
        review_length()
    }

    "/reviews/congrats"(platform: "/") {
        review_length(inheritable: false)
    }

    "/reviews/error"(platform: "/") {}

    "/reviews/email"(platform: "/email") {}

    "/reviews/show"(platform: "/") {
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

