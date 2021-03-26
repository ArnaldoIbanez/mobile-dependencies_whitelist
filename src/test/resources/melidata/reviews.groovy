package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    //Reviews
    test("Reviews tracks") {
        def dataSetForm = {
            item_id="MLA533657947"
            step="description"
        }

        def dataSet = {
            item_id="MLA533657947"
        }

        def seeMoreTrack = {
            item_id="MLA834078638"
            catalog_product_id="MLA15243603"
            context="PDP"
        }

        def dataSetCongrats = {
            item_id="MLA533657947"
            review_length=321
        }

        def vipTrack = {
            item_id = "MLA631609359"
            reviews_all_count = 3
            reviews_negative_count = 0
            vote_up = {
                reviews_id = [1,2]
                count = 2
            }
            vote_down = {
                reviews_id = [3,4]
                count = 2
            }
            reviews_positive_count = 0
            reviews_shown = [
                    {
                        filter = "all"
                        length = 300
                        position = 2
                        reviewId = "3581337"
                        time = 27364
                        words = 52
                    }
            ]
            time_ellapsed = 75211
            type = "detail"
        }

        def reviews_tab_track = {
            item_id="MLA533657947"
            catalog_product_id="MLA15243603"
            type = "all"
        }

        "/reviews/form"(platform:"/", dataSetForm)

        "/reviews/edit"(platform:"/", dataSet)

        "/reviews/congrats/delete"(platform:"/", dataSet)

        "/reviews/congrats/edit"(platform:"/", dataSetCongrats)

        "/reviews/error"(platform:"/", dataSet)

        "/reviews/congrats"(platform:"/", dataSetCongrats)

        "/reviews/email"(platform:"/email", dataSet)

        "/reviews"(platform:"/email", dataSet)

        "/reviews/show"(platform:"/", vipTrack)

        "/reviews/see_more"(platform: "/", seeMoreTrack)

        "/reviews/tab"(platform: "/", reviews_tab_track)
    }
}
