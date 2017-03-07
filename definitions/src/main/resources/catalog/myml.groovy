import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

"/myml"(platform: "/", isAbstract: true) {
    cartContent(required:false, type: PropertyType.String)
    purchase_status(required:false, type: PropertyType.String)
    connection_type(required:false, type: PropertyType.String)

    mercado_lider(required:false, type: PropertyType.String)
    reputation_level(required:false, type: PropertyType.String)
    resolution(required:false, type: PropertyType.String)
    loyalty_level(required:false, type: PropertyType.Numeric)
}

"/myml/sales"(platform: "/", isAbstract: true) {}

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

"/myml/purchases"(platform: "/", isAbstract: true) {}

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

}