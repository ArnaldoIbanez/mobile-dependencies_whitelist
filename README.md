# Melidata Catalog
[![Build Status](http://216.33.196.24/drone-test/api/badge/github.com/mercadolibre/melidata-catalog/status.svg?branch=master)](http://drone-test.melicloud.com/github.com/mercadolibre/melidata-catalog)

This repository contains a all the definitions about the information thacked thougth *melidata* platform

## Testing the catalog

If you want to run the tests, you should execute **```make test```**


## Add a new track

When you add a new track the most important thing to do it's add a test that validate the track that we are adding. To do that we should add a new test casse for our new track to **definitions/tests/tests.groovy**

In the file we should add a new test case whith one or more tracks to test. When we run the tests each track will be checked to see if these are valid
``` groovy
  test("Search gallery with 50 items" ) {  // <-- Test case definition (name)
      "/search"(platform:"/mobile") {  // <-- Track definition, path and platform
          limit = "50"      // <-- Property to track
          offset = 10       // <-- Property to track
      }   
  }
```


Then, to add a new track to the catalog you should add their definition to **definitions/catalog/catalog.groovy**

``` groovy
  "/search"(platform: "/") { // <-- Path and platform (use "/" for all)
      limit(description:"amount of search items returned") // <-- Property, by default are strings and content could be anything
      offset(type: PropertyType.Numeric, regex:".*") // <-- Property, type numeric and validated by regex
  } 
```

## Types
  - String
  - Numeric
  - Timestamp: format yyyy-MM-ddTHH:mm:ss.ZZZ

## Validators
  - regex: a regular expresion to match the property
  - values: an array of valid values

