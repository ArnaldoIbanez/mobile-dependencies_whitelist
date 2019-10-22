# Internal

## Running Internal tests

    ./gradlew test [--debug-jvm]


## Running catalog tests => same as contributers do

    ./gradlew tests [--debug-jvm]


## Generating metrics ouput

    ./gradlew exportMetrics [--debug-jvm]


## Generating queries output

    ./gradlew exportCronQueries [--debug-jvm]
    

## Uploading the catalog ( Destination: s3://melidata-jobs )

    ./gradlew uploadCatalog [--debug-jvm]


## Uploading metrics file ( Destination: s3://melidata-jobs )

    ./gradlew uploadMetrics [--debug-jvm]


## Uploading batch queries file ( Destination: s3:///melidata-croned-queries )

    ./gradlew uploadBatchQueries [--debug-jvm]




