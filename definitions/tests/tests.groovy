

trackTests {

  test("Search gallery with 50 items, first page" ) {
      "/search"(platform:"/mobile") {
          limit = 10
          offset = 0
      }
      "/search/refine" {
          limit = 10
          offset = 0
      }
  } 

  test("Search gallery with 50 items, first page" ) {
      "/search"(platform:"/mobile") {
          limit = 10
          offset = 0
      }
      "/search/refine" {
          limit: 10
          offset: 0
      }
  }  
}
