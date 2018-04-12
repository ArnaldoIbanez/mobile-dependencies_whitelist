import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

// Questions
    "/questions"(platform: "/", isAbstract: true) {
        item_id(required: false)
    }
    "/questions/ask"(platform: "/", isAbstract: true) {
        context(required:true ,description: "The page or section where the questions action is taking place" , values: ["/vip","/bookmarks","/questions","/notifications"])
    }
    "/questions/answer"(platform: "/", isAbstract: true) {
        context(required:true ,description: "The page or section where the questions action is taking place" , values: ["/questions","/notifications"])
    }
    "/questions/ask/post"(platform: "/", type: TrackType.Event) {
        //TODO revisar si no conviene pasar failed() a otro path "/questions/ask/post/failed"
        failed()
        question_id(required: false, description: "it has no value if failed is true")
    }

    "/questions/ask/post" (platform: "/web", type: TrackType.Event) {
        item_id()
        action_location(required:false, type: PropertyType.String)
    }

    "/questions/ask/back"(platform: "/mobile", type: TrackType.Event) {
    }

    "/questions/answer"(platform: "/mobile") {
        from_deeplink(required: false, description: "True, when it access from deeplink, otherwise not")
    }

    "/questions/answer/post"(platform: "/mobile", type: TrackType.Event) {
        failed()
        question_id(required: false, description: "it has no value if failed is true")
        attach_id(required: false, description: "Attached Item id")
    }

    "/questions/answer/back"(platform: "/mobile", type: TrackType.Event) {
        context(required:true ,description: "The page or section where the questions action is taking place" , values: ["/vip"])
    }

    "/questions/back"(platform: "/mobile") {
        context(required:true ,description: "The page or section where the questions action is taking place" , values: ["/vip"])
    }


}
