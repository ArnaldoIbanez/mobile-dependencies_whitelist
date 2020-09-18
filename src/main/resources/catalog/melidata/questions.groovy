package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

    initiative = "1171"

// Questions

    "/questions"(platform: "/", isAbstract: true) { // THIS IS A VIP MOBILE TRACK THAT TRACKS THE VIEW OF QUESTIONS LISTS FROM VIP
        item_id(required: false)
    }
    "/questions/ask"(platform: "/", isAbstract: true) {
        context(required:true ,description: "The page or section where the questions action is taking place" , values: ["/vip","/bookmarks","/questions","/notifications","/pdp", "/qadb", "/qadb-auto","/qadb/pdp","/qadb/vip", "/qadb-auto/pdp", "/qadb-auto/vip"])
        item_id( required: true, description: "Item id in which we are performing the question")
        catalog_product_id(required: false, description: "Id of the product", type: PropertyType.String)
    }

    "/questions/ask/post"(platform: "/", type: TrackType.Event) {       
        question_id(required: true, description: "it might have no value if failed is true, but's ok. If SLA just does not work because of this is the smallest problem. Something bigger is happening with question_id trackings")
        question_text(required:false, description: "The question ask by the user", type:PropertyType.String)
        failed( required: true, description: "whenever the post was succesful or not")
		error(required: false, description: "Contains the error code for the questions post api, should there be one",
		type: PropertyType.Numeric)
		error_cause(required: false, description: "Contains the cause of error for the questions post api, should there be one",
		type: PropertyType.String)
        vip_version(required: false, type: PropertyType.String, values: ["old", "new"], description: "VIP version that is sending the track")
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

    "/questions/input_focus"(platform: "/") {
        catalog_product_id(required: false, type: PropertyType.String, description: "Catalog product id")
        item_id(required: true, type: PropertyType.String, description: "Item ID in case of having a PDP with BBW")
        context(required:true ,description: "The page or section where the questions action is taking place" , values: ["PDP", "VIP"])
    }


}
