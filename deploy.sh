#!/usr/bin/env bash

#before run this script to deploy new jar, change definitions/build.gradle to update jar version

cd definitions && ./gradlew test && ./gradlew uploadArchives && cd ..
