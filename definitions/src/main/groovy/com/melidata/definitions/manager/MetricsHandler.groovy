package com.melidata.definitions.manager

import com.amazonaws.services.s3.model.GetObjectRequest
import com.amazonaws.services.s3.model.S3ObjectInputStream
import org.json.simple.parser.JSONParser

/**
 * Created by mtencer on 5/4/16.
 */
class MetricsHandler {

	private static final String AWS_KEY = 'AKIAIRJ4DFA72UDCX7QA'//'AKIAI2AFLMRLNMSP3IJA'
	private static final String AWS_SECRET = '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'//'BZUVcUw7CfLgoJVr06w15sJ308Tnxv+c42Hhul6G'

	public static String LOCAL_FOLDER = "/data/metrics/";
	public static String S3_METRICS_FILE = "metrics.json";
	public static String BUCKET = "melidata-jobs"

	private S3Controller cli
	private String lastEtag
	private metrics
	private int version

	def MetricsHandler() {
		cli = new S3Controller(BUCKET, AWS_KEY, AWS_SECRET)
	}

	def boolean reload() {

		GetObjectRequest g = new GetObjectRequest(BUCKET, S3_METRICS_FILE);
		if(lastEtag != null) {
			g.withNonmatchingETagConstraint(lastEtag);
		}

		def object = cli.getObject(g);

		//Integer newVersion = Integer.parseInt(object.getObjectMetadata().getUserMetaDataOf("metrics-version"));
		//if (metrics == null || !newVersion.equals(version)) {
		if ( object != null ) {
			JSONParser parser = new JSONParser();
			try {
				def file = downloadMetrics(object)
				if ( file != null ) {
					this.metrics = parser.parse(file.text)
					this.lastEtag = object.getObjectMetadata().getETag();
					println(String.format("New metrics [version: %s] [etag: %s] has been loaded", this.version, this.lastEtag));

				    return true
				} else {
					println("Error writing metrics definitions to local file")
				}
			} catch (e) {
				println("Error reading metrics definitions. Message: ${e.getMessage()}")
			}
		}

		return false
	}

	private File downloadMetrics(object) throws IOException {

		S3ObjectInputStream objectContent = object.getObjectContent();

		BufferedWriter writer = null;
		BufferedReader reader = null;
		try {
			def output = new File(LOCAL_FOLDER, S3_METRICS_FILE)
			output.getParentFile().mkdirs()
			writer = new BufferedWriter(new FileWriter(output));
			reader = new BufferedReader(new InputStreamReader(objectContent));
			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(line + "\n");
			}

			return output
		} finally {
			if ( reader != null )
				reader.close();
			if ( writer != null )
				writer.close();
		}

		return null
	}

	def getMetrics() {
		return metrics
	}

	def int getVersion() {
		version
	}

	def String getLastEtag() {
		lastEtag
	}

}
