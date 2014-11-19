import static TrackTestDsl.trackTests

trackTests {
  test("Search gallery with 50 items, first page" ) {
      "/search"(platform:"/") {
          limit = 10
          offset = 0
      }

      "/search"(platform:"/") {
          limit = 10
          offset = "0"
      }

      "/search"(platform:"/") {
          limit = 50
          offset = 10
      }
  } 
}
