package com.ml.melidata;

/**
 * Created by mtencer on 18/8/15.
 */
public class TrackAdapterHelper {

	static com.ml.melidata.TrackType adaptType(TrackType t) {
		return t != null ? adaptType(t.name()) : null
	}

	static com.ml.melidata.TrackType adaptType(String t) {
		return t != null ? com.ml.melidata.TrackType.fromString(t) : null
	}

	static com.ml.melidata.Track adaptTrack(Map t) {
		com.ml.melidata.Track output = new com.ml.melidata.Track(t.path, adaptType(t.type), t.device.platform, t.application.business)

		output.setEvent_data(t.event_data)
		output.setTimestamp(t.user_timestamp)

		return output
	}
}

