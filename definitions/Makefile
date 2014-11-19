test:
	cp ./catalog/catalog.groovy ./src/main/groovy/
	cp ./tests/tests.groovy ./src/main/groovy/
	./gradlew validateTracks
	rm ./src/main/groovy/catalog.groovy
	rm ./src/main/groovy/tests.groovy

.PHONY: test
