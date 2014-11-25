#!/bin/bash

IS_MAIN_REPO= $(echo $DRONE_BUILD_DIR | grep -e "github.com/mercadolibre/melidata-catalog$")
if [[ $DRONE_BRANCH == "master" && $DRONE_BUILD_DIR != "" ]]; then
  echo "Do deploy"
else
  echo "This branch / fork doesn't deploy"
fi
