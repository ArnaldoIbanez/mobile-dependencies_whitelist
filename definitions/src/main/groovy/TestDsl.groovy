import com.ml.melidata.Track

/**
 * Created by apetalas on 19/11/14.
 */

class TestDsl{

    def ArrayList<Track> tracks = []
    def String name

    def propertyMissing(String name, value){
        this.tracks.last().event_data[name] = value
    }

    def methodMissing(String method, args) {

        def path = method;
        def trackArgs = ["path":path]
        for(def i =0; i < args.size() -1 ; i++) {
            trackArgs = trackArgs+args[i]
        }

        this.tracks.push(new Track(path))
        def closure = args[-1]
        closure()
    }
}

