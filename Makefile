test:
	echo "Starting tests..."
	env
	cd definitions/; make test

.PHONY: test
