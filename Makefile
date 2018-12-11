CATALOG=Melidata
help:
	@echo "run make test for running Melidata Catalog tests, or make test CATALOG=Melidata/Shipping/All for running Melidata, Shipping or both Catalog tests"
test:
	echo "Starting tests..."
	cd definitions/; make test CATALOG=$(CATALOG)

.PHONY: test
