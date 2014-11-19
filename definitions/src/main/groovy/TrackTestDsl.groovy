import com.ml.melidata.Track

/**
 * Created by apetalas on 19/11/14.
 */

class TrackTestDsl {

    def ArrayList<Track> tracksToValidate = [];
    def ArrayList<TestDsl> tests = [];

    def static trackTests(clousure) {
        TrackTestDsl dsl = new TrackTestDsl()
        clousure.delegate = dsl
        clousure.resolveStrategy = Closure.DELEGATE_FIRST
        clousure()
        return dsl.tests
    }


    def test(params, closure) {
        //println "test: ${params}"

        TestDsl dsl = new TestDsl()
        dsl.name = params
        closure.delegate = dsl
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure()
        //println "fin test:"
        this.tests.push(dsl)
        this.tracksToValidate = this.tracksToValidate + dsl.tracks
        return
    }
}

