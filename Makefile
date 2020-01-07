CATALOG=All
help:
	@echo "run make test for running Melidata Catalog tests, or make test CATALOG=Melidata/Shipping/All for running Melidata, Shipping or both Catalog tests"
test:
	echo "Starting tests... "
	./gradlew test$(CATALOG)
productionTest:
	echo "Starting tests... "
	./gradlew test$(CATALOG)

.PHONY: test
