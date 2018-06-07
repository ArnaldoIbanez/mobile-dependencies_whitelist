import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

    "/add_to_cart"(platform: "/", type: TrackType.Event) {
        items( required: true,description: "Item ids that are being added", type: PropertyType.ArrayList )
        //currency_id
        //item
            //id
            //category_id
        //quantity
        //unit_price

        context( required: true, values: ["/search","/myml","/cart","/recommendations","/bookmarks","/vip", "/loyalty", "cart/saved_for_later"] ,
                description: "The page or section where the add_to_cart action is taking place" )
    }

}
