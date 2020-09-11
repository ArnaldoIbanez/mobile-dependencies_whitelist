#!/usr/bin/env bash

apt-get install jq -y
if [ $(echo "${BUILD_CONTEXT}" | jq -r '.git_base_branch') == "master" ] && [ $(echo "${BUILD_CONTEXT}" | jq -r '.git_is_merge') = true ]
then
    ./gradlew uploadAll
else
    ./gradlew testAll
fi