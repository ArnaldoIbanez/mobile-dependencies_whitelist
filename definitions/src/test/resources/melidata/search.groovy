package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    test("Search core tracking"){

        def defaultSearchInformation = {
            total=5876
            limit=20
            query="iphone"
            category_path=["MLA1051", "MLA1055", "MLA32089"]
            category_id="MLA32089"
            filters=[]
            pads=[]
            pads_info={
                ids=[]
                printed_positions=[]
                printed_positions_size=0
            }
            billboards=[]
            offset=0
            sort_id="relevance"
            view_mode="MOSAIC"
            results=["232232000", "232232001", "232232002"]
            backend_data={
                sm="sm"
                ab="1"
                aa=["a1","a2"]
                ac=["ac1","ac2"]
                ap=["ap1","ap2"]
                fsm="fsm"
                ab_bucket="AB1"
                layout="stack"
                qas=["232232000", "232232001", "232232002"]
                cli_rel_qty_configured="12"
                canonical="http://home.mercadolibre.com.ar/telefonia/"
                cli_rel_qty_link_to_category="MLA123"
            }
            catalog_product_id="MLA123"
            show_supermarket_carousel=true
            items_with_logos=["MLA1234", "MLA12345"]
        }

        def defaultWebTrack = {
            total=0
            sort_id="relevance"
            view_mode="MOSAIC"
            filters = { seller_id = "47316577" }
            available_filters=[{shipping_time_sameday: "250"}]
            only_in_type="Seller"
            limit=20
            offset=0
            official_stores_carousel_shown=["224", "234", "255"]
            click_banner={
                exhibitors_id='12'
            }
            banner={
                deal_id='12'
                exhibitors_id='12'
            }
            click_banner={
                exhibitors_id='12'
            }
            related_searches={
                query= 'ipod'
                position=1
                quantity=2
                related_by_category=false
            }
            related_searches_info={
                quantity=2
                related_queries=['ipod', 'ipod nano']
            }
            canonical={
                url = "https://listado.mercadolibre.com.ar/zapatillas"
                no_follow_tag = true
                mirror_category_canonical = true
            }

            autosuggest={
                suggest_position=3
            }
            autosuggest={
                last_search_position=1
            }
            autosuggest={
                block_store_position=19
            }
            results=["232232000", "232232001", "232232002"]
            billboards = ["232232000"]
            geolocation="AR:CABA"

            layout_forced=true
            pads=[]
            pads_info={
                ids=[]
                printed_positions=[]
                printed_positions_size=0
            }
            user_zone = ""
        }

        "/search"(platform: "/web"){
            defaultWebTrack()
            landing="base"
        }

        "/search"(platform: "/web"){
            defaultWebTrack()
            landing="official_store"
        }

        "/search"(platform: "/web",{
            total=0
            sort_id="relevance"
            view_mode="MOSAIC"
            filters = { seller_id = "47316577" }
            available_filters = []
            only_in_type="Seller"
            limit=20
            offset=0
            official_stores_carousel_shown=["224", "234", "255"]
            click_banner={
                exhibitors_id='12'
            }
            banner={
                deal_id='12'
                exhibitors_id='12'
            }
            click_banner={
                exhibitors_id='12'
            }
            related_searches={
                query= 'ipod'
                position=1
                quantity=2
                related_by_category=false
            }
            related_searches_info={
                quantity=2
                related_queries=['ipod', 'ipod nano']
            }
            canonical={
                url = "https://listado.mercadolibre.com.ar/zapatillas"
                no_follow_tag = true
                mirror_category_canonical = true
            }

            autosuggest={
                suggest_position=3
            }
            autosuggest={
                last_search_position=1
            }
            autosuggest={
                block_store_position=19
            }
            results=["232232000", "232232001", "232232002"]
            billboards = ["232232000"]
            geolocation="AR:CABA"
            landing="cpg"
            layout_forced=true
            pads=[]
            pads_info={
                ids=[]
                printed_positions=[]
                printed_positions_size=0
            }
            geo_search = false
            user_zone = ""
            is_googlebot=true
        })

        "/search"(platform: "/mobile", defaultSearchInformation)

        "/search"(platform: "/mobile", {
            total = 258
            limit = 0
            view_mode="MOSAIC"
            results=[]
            billboards=[]
            category_path = []
            offset = 50.0
            sort_id = "relevance"
            filters = {official_store="140"}
            autoselected_filters = ["official_store"]
            geo_search = "false"
            filter_tags = "locationFromHistory"
            pads=[]
            pads_info={
                ids=[]
                printed_positions=[]
                printed_positions_size=0
            }
        })


        "/search/input"(platform: "/mobile") {}

        "/search/input/back"(platform: "/mobile") {}

        "/search/failure"(platform: "/mobile") {
            defaultSearchInformation()
            error_message = "No connection error"
        }

        "/search/filters"(platform: "/mobile", defaultSearchInformation)
        "/search/back"(platform: "/mobile", defaultSearchInformation)
        "/search/long_press"(platform: "/mobile"){
            item_id = "MLA170232"
        }
        "/search/share"(platform: "/mobile"){
            item_id = "MLA170232"
        }
        "/search/abort"(platform: "/mobile", defaultSearchInformation)
        "/search/refine"(platform: "/mobile", defaultSearchInformation)
        "/search/refine/apply"(platform: "/mobile", defaultSearchInformation)
        "/search/refine/back" (platform: "/mobile", defaultSearchInformation)
        "/search/refine/select_filter" (platform: "/mobile"){
            defaultSearchInformation()
            filter_id = "9997262-AMLA_7262_2"
        }
        "/search/refine/select_filter/apply"(platform: "/mobile"){
            defaultSearchInformation()
            filter_id = "9997262-AMLA_7262_2"
            filter_value_id = "9997262-AMLA_7262_1-MMLA6838"
            filter_value_name = "IPod touch"
        }
        "/search/change_view" (platform: "/mobile", defaultSearchInformation)
        "/search/change_view/apply" (platform: "/mobile", type: TrackType.Event){
            defaultSearchInformation()
            list_mode = "mosaic"
        }
        "/search/change_view/apply" (platform: "/web", type: TrackType.Event){
            defaultSearchInformation()
            list_mode = "mosaic"
            available_filters=[{shipping_time_sameday: "250"}]
            user_zone = ""
        }
        "/search/promoted_items"(platform: "/web") {
            defaultSearchInformation()
            available_filters = []
            user_zone = ""
        }
        "/search/promoted_items/show"(platform: "/web") {
            defaultSearchInformation()
            item_type = "projects"
            available_filters = []
            user_zone = ""
        }
        "/search/billboard"(platform: "/") {
            defaultSearchInformation()
            position_shown = 1
            move = "forward"
        }
        "/search/billboard/resize"(platform: "/web") {
            defaultSearchInformation()
            action = "expand"
            available_filters = []
            user_zone = ""
        }
        "/search/save"(platform: "/") {
            defaultSearchInformation()
        }
        "/search/official_stores_carousel"(platform: "/") {
            defaultSearchInformation()
        }
        "/search/official_stores_carousel/click"(platform: "/") {
            defaultSearchInformation()
            to_name="adidas"
            to_position=2
        }
    }

    test("Search gallery with 10 items, first page" ) {
        "/search"(platform: "/mobile") {
            limit = 10
            offset = 0
            total = 0
            sort_id = "relevance"
            filters = []
            pads=[]
            pads_info={
                ids=[]
                printed_positions=[]
                printed_positions_size=0
            }
            view_mode = "LIST"
            results = []
            billboards = []
            category_id="MLA32089"
            query="iphone"
        }
    }

    test("Search category_id ROOT" ) {
        "/search"(platform: "/mobile") {
            limit = 10
            offset = 0
            total = 0
            sort_id = "relevance"
            filters = []
            pads=[]
            pads_info={
                ids=[]
                printed_positions=[]
                printed_positions_size=0
            }
            view_mode = "LIST"
            results = []
            billboards = []
            category_id="ROOT"
            query="iphone"
        }
    }


    test("Search carousel next"){
        "/search/carousel"(platform: "/web") {
            carousel_used="next"
        }
    }

    test("Search go local"){
        "/search/golocal"(platform: "/web"){
            limit = 10
            offset = 0
            total = 0
            sort_id = "relevance"
            filters = []
            available_filters = []
            pads=[]
            pads_info={
                ids=[]
                printed_positions=[]
                printed_positions_size=0
            }
            view_mode = "LIST"
            results = []
            billboards = []
            category_id="MLA32089"
            query="iphone"
            user_zone = ""

        }
    }

    test("Search Recommendations "){
        "/search/category_recommendations"(platform: "/web"){
            item_id = "MLM1234"
            category_id = "MLM123456"
            category_path = ["MLM1234", "MLM12345", "MLM123456"]
            recommended_categories = [
                    "MLM4321",
                    "MLM54321"
            ]

        }
    }

}