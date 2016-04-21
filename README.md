# Melidata Catalog
[![Build Status](http://216.33.196.24/drone/api/badge/github.com/mercadolibre/melidata-catalog/status.svg?branch=master)](http://drone.melicloud.com/github.com/mercadolibre/melidata-catalog)

This repository contains all the definitions for the information tracked thru *melidata* platform

## Testing the catalog

If you want to run the tests, you should execute **```make test```**


## Add a new track

When you add a new track the most important thing to do is to add a test to validate the track we're adding. To do that we should add a new test case for our new track to **definitions/tests/marketplace.groovy**

To create a catalog, please look at  **marketplace.groovy** and check where your business name should be included.

In the file we should add a new test case with one or more tracks to test. When we run the tests each track will be checked to see if these are valid
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

## Validate Tracks 

To validate a single json track 

```
cd definitions
./gradlew validate -Dtrack=[JSON]
```

To validate a list of json tracks

```
cd definitions
./gradlew validate -Dtrack=[FILE_NAME]
```



## Types
  - String
  - Numeric
  - Timestamp: format yyyy-MM-ddTHH:mm:ss.ZZZ

## Validators
  - regex: a regular expresion to match the property
  - values: an array of valid values

## FAQ
  - Is it ok to define a child element (ex: ```'/reviews/form'```) without it's parent element?
 
 Yes, but you have to declare the parent track (ex: ```'/reviews'```) as abstract:
  ```
  "/reviews"(platform: "/mobile", isAbstract: true) {}
  
  "/reviews/form"(platform: "/mobile") {
  	item_id(required: true, description: "Item being reviewed")
  	is_product(required: true, type: TrackType.Boolean)
  }
  ```
  - I have this error, what do I do?
  
  ```Exception in thread "main" groovy.lang.MissingMethodException: No signature of method: java.util.LinkedHashMap.call() is applicable for argument types: () values: []```

  This might happen if you forgot to set a TrackType on your test ```"/reviews/form"(platform: "/mobile", type: TrackType.View)  ```


