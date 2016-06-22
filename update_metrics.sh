
KEY=$1

if [ -z "$KEY" ]; then
	echo "Key parameter must be indicated. Usage: ./update_metrics.sh <KEY>"
	exit 1
fi

cd definitions && ./gradlew exportMetrics && curl -s "https://api.mercadolibre.com/melidata/track_storage/$KEY/definitions" -XPOST -d @metrics.json && cd ..
