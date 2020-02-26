#!/usr/bin/env bash

apt-get install jq -y
./gradlew testAll

if [ $(echo "${BUILD_CONTEXT}" | jq -r '.git_base_branch') == "master" ] && [ $(echo "${BUILD_CONTEXT}" | jq -r '.git_is_merge') = true ]
then
      echo "Starting upload of all catalogs"
      ./gradlew uploadAllCatalog

      echo "Starting upload metrics"
      ./gradlew uploadMetrics

      echo "Starting upload json for batch queries"
      ./gradlew uploadBatchQueries

      echo "Starting upload json for whitelisted paths"
      ./gradlew uploadWhitelist
fi