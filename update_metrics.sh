
KEY=$1

if [ -z "$KEY" ]; then
	echo "Key parameter must be indicated. Usage: ./update_metrics.sh <KEY>"
	exit 1
fi

<<<<<<< HEAD
=======
echo "Updating metrics for temporal use in track storage with filter: $KEY"

>>>>>>> update metrics scripts
cd definitions && ./gradlew exportMetrics && curl -s "https://api.mercadolibre.com/melidata/track_storage/$KEY/definitions" -XPOST -d @metrics.json && cd ..
