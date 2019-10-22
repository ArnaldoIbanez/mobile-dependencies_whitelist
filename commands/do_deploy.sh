#!/bin/bash

P=`dirname $0`

IS_MAIN_REPO=$(echo $DRONE_BUILD_DIR | grep -e "github.com/mercadolibre/melidata-catalog$")
if [[ $DRONE_BRANCH == "master" && $DRONE_BUILD_DIR != "" ]]; then
  cd $P
  echo "Uploading path script: $P"
  echo "Starting upload of all catalogs"
  ../gradlew uploadAllCatalog

  echo "Starting upload metrics"
  ../gradlew uploadMetrics

  echo "Starting upload json for batch queries"
  ../gradlew uploadBatchQueries

  echo "Starting upload json for whitelisted paths"
  ../gradlew uploadWhitelist

else
  echo "This branch / fork doesn't deploy"
fi
