import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    propertyDefinitions {
	    cartContent(required:false, type: PropertyType.Boolean)
	    status(required:false, type: PropertyType.String)
	    
	    seller(required: false, type:PropertyType.ArrayList, description: "Array of sellers with their data")
	    //id
	    //nickname
	    //mercado_lider
	    //reputation_level

	    buyer(required: false, type:PropertyType.ArrayList, description: "Array of buyers with their data")
	    //id
	    //nickname
	    //loyalty_level
    }

    propertyGroups {
        mymlGroup(cartContent, status, seller, buyer)
    }


"/myml/sales"(platform: "/", isAbstract: true) {
    mymlGroup
}

"/myml/sales/list"(platform: "/") {}

"/myml/sales/status"(platform: "/") {}

"/myml/sales/status/call_to_carrier"(platform: "/", type: TrackType.Event) {
	carrier(required:false, type: PropertyType.String)
}

"/myml/sales/status/pack_tutorial"(platform: "/", type: TrackType.Event) {}

"/myml/sales/detail/pack_tutorial"(platform: "/", type: TrackType.Event) {}

"/myml/sales/detail"(platform: "/") {}

"/myml/sales/detail/refund_money"(platform: "/", type: TrackType.Event) {}

"/myml/sales/detail/print_label"(platform: "/", type: TrackType.Event) {}

"/myml/sales/order"(platform: "/") {}

"/myml/sales/shipping_detail"(platform: "/") {}

"/myml/sales/messages"(platform: "/") {}

"/myml/sales/questions"(platform: "/") {}

"/myml/purchases"(platform: "/", isAbstract: true) {
	mymlGroup
}

"/myml/purchases/list"(platform: "/") {}

"/myml/purchases/detail"(platform: "/") {}

"/myml/purchases/detail/delete_purchase"(platform: "/", type: TrackType.Event) {}

"/myml/purchases/detail/what_do_if_i_pay"(platform: "/", type: TrackType.Event) {}

"/myml/purchases/detail/call_to_carrier"(platform: "/", type: TrackType.Event) {
	carrier(required:false, type: PropertyType.String)
}

"/myml/purchases/print_label"(platform: "/") {}

"/myml/purchases/print_label/show_stores_map"(platform: "/", type: TrackType.Event) {}

"/myml/purchases/shipping_detail"(platform: "/") {}

"/myml/purchases/shipping_detail/refund_details"(platform: "/", type: TrackType.Event) {}

"/myml/purchases/messages"(platform: "/") {}

"/myml/purchases/questions"(platform: "/") {}

"/myml/purchases/canceled"(platform:"/", type: TrackType.View) {}

"/myml/purchases/order"(platform:"/", type: TrackType.View) {}

"/myml/purchases/detail/history"(platform:"/", type: TrackType.View) {}

"/myml/purchases/feedback"(platform: "/mobile", isAbstract: true) {}

"/myml/purchases/feedback/rating"(platform: "/mobile", type: TrackType.View) {}

"/myml/purchases/feedback/message"(platform: "/mobile", type: TrackType.View) {}

"/myml/purchases/feedback/congrats"(platform: "/mobile", type: TrackType.View) {}

"/myml/purchases/feedback/congrats#action"(platform: "/mobile", type: TrackType.Event) {
	target(required: true, type: PropertyType.String)
}

"/myml/purchases/feedback/error"(platform: "/mobile", type: TrackType.View) {}

}