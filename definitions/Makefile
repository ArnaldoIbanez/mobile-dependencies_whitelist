CATALOG=Melidata
help:
	@echo "run make test for running Melidata Catalog tests, or make test CATALOG=Melidata/Shipping/All for running Melidata, Shipping or both Catalog tests"
test:
	./gradlew test$(CATALOG)
productionTest:
	./gradlew -Dhttp.proxyHost=172.16.0.89 -Dhttps.proxyHost=172.16.0.89 -Dhttp.proxyPort=80 -Dhttps.proxyPort=80 -DMaxPermSize=4g  test$(CATALOG)

.PHONY: test
