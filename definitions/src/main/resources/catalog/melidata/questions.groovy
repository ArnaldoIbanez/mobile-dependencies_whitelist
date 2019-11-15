import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

// Questions

    "/questions"(platform: "/", isAbstract: true) { // THIS IS A VIP MOBILE TRACK THAT TRACKS THE VIEW OF QUESTIONS LISTS FROM VIP
        item_id(required: false)
    }
    "/questions/ask"(platform: "/", isAbstract: true) {
        context(required:true ,description: "The page or section where the questions action is taking place" , values: ["/vip","/bookmarks","/questions","/notifications","/pdp", "/qadb"])
        item_id( required: true, description: "Item id in which we are performing the question")
        catalog_product_id(required: false, description: "Id of the product", type: PropertyType.String)
    }

    "/questions/ask/post"(platform: "/", type: TrackType.Event) {
        //TODO revisar si no conviene pasar failed() a otro path "/questions/ask/post/failed"
        question_id(required: false, description: "it has no value if failed is true")
        question_text(required:false, description: "The question ask by the user", type:PropertyType.String)
        failed( required: true, description: "whenever the post was succesful or not")
    }

    "/questions/ask/post" (platform: "/web", type: TrackType.Event) {
        action_location(required:false, type: PropertyType.String)
    }

    "/questions/ask/back"(platform: "/mobile", type: TrackType.Event) {
    }

    "/questions/answer"(platform: "/", isAbstract: true) {
        context(required:true ,description: "The page or section where the questions action is taking place" , values: ["/questions","/notifications"])
        item_id( required: true, description: "Item id in which we are performing the question")
    }

    "/questions/answer"(platform: "/mobile") {
        from_deeplink(required: false, description: "True, when it access from deeplink, otherwise not")
    }

    "/questions/answer/post"(platform: "/", type: TrackType.Event) {
        question_id(required: false, description: "it has no value if failed is true")
    }

    "/questions/answer/post"(platform: "/mobile", type: TrackType.Event) {
        //TODO revisar si no conviene pasar failed() a otro path "/questions/answer/post/failed"
        failed( required: true, description: "whenever the post was succesful or not")
        attach_id(required: false, description: "Attached Item id")
    }

    "/questions/back"(platform: "/mobile") {
        context(required:true ,description: "The page or section where the questions action is taking place" , values: ["/vip"])
    }


}
