CATALOG=Melidata
help:
	@echo "run make test for running Melidata Catalog tests, or make test CATALOG=Melidata/Shipping/All for running Melidata, Shipping or both Catalog tests"
test:
	./gradlew test$(CATALOG)
productionTest:
	./gradlew test$(CATALOG)

.PHONY: test
