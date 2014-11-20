import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
  test("Search gallery with 10 items, first page" ) {
      "/search"(platform: "/") {
          limit = 10
          offset = 0
      }
  }
  test("Search gallery with 10 items, second page" ) {
      "/search"(platform: "/") {
          limit = 10
          offset = "2"
      }
  }
  test("Search gallery with 50 items" ) {

      "/search"(platform:"/mobile") {
          limit = "50"
          offset = 10
      }
  }
  test("Search refine"){
    "/checkout"(platform:"/"){
      category = "MLA333"
    }
  }
    test("/pepito1"){
        "/pepito1"(platform:"/"){
            category = "MLA333"
        }
    }
    test("/pepito2"){
        "/search"(platform:"/"){
            nana = "leader"
        }
    }
}
