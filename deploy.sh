
#before run this script to deploy new jar, change definitions/build.gradle and commons/build.gradle to update jar version

cd commons && ./gradlew test && cd ../definitions && ./gradlew test && ./gradlew uploadArchives && cd ..
