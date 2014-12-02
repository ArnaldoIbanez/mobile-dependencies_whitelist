import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  test("Search gallery with 10 items, first page" ) {
      "/search"(platform: "/mobile/android") {
          limit = 10
          offset = 0
          category_id="MLA32089"
          query="iphone"
      }
  }

  test("Search core tracking"){

      def defaultSearchInformation = {
          total=5876 
          limit=20
          query="iphone"
          category_path=["MLA1051", "MLA1055", "MLA32089"]
          category_id="MLA32089"
          filter_user_applied=[]
          offset=0
          sort_id="relevance"
      }

      "/search"(platform: "/mobile/android", defaultSearchInformation)
      "/search/refine"(platform: "/mobile/android", defaultSearchInformation)
      "/search/refine/apply"(platform: "/mobile/android", defaultSearchInformation)
      "/search/refine/cancel" (platform: "/mobile/android", defaultSearchInformation)  
      "/search/refine/select_filter" (platform: "/mobile/android"){
        defaultSearchInformation()
        filter_name = "sort"
      }
      "/search/refine/select_filter/choose"(platform: "/mobile/android"){
        defaultSearchInformation()
        filter_name = "sort"
        filter_value = "relevance"
      }
      "/search/change_view" (platform: "/mobile/android", defaultSearchInformation)
      "/search/change_view/choose" (platform: "/mobile/android"){
        defaultSearchInformation()
        list_mode = "mosaic"
      }
      "/search/bookmark" (platform: "/mobile/android"){
        defaultSearchInformation()
        item_id = "MLA32089"
      }
  }
}