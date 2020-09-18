import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics


/* This file is intended to declare the experiment that want to declare a specific property
to be detected and incorporated into melidata attribution model to take an attribution that depends on it.

Examples of this properties can be:
- Wanting to attribute if the order is made in the same item of experiment exposure
- Wanting to attribute if the order is made in the same domain of experiment exposure
- Wanting to attribute if the order is made in the same deal of experiment exposure

the name for the section must be the experiment name where the property will be set

*/

metrics {


    // =======================================================================
    //  Deprecated Properties
    // =======================================================================

    "buyingflow/accountmoney_not_bep"(description: "define properties for order_id", deprecation_date:"2020/08/12") {
        startWith {
            set_property("order_id", "event_data.order_id")
        }
    }

    "sell/full_relist_single_item"(description: "define properties for item_id at full_relist experiment", deprecation_date:"2020/08/12") {
        startWith {
            set_property("item_id", "event_data.item_id")
        }
    }

    "vip/plainText"(description: "define properties for item_id for vip description (html vs plain) experiment", deprecation_date:"2020/08/12") {
        startWith {
            set_property("item_id", "event_data.item_id")
        }
    }



    // =======================================================================
    //  Active Properties
    // =======================================================================

    "qadb/qadb-on-viewport"(description: "define properties for catalog_product_id qadb viewport experiment") {
        startWith {
            set_property("catalog_product_id", "event_data.catalog_product_id")
            set_property("catalog_parent_id", "event_data.catalog_parent_id")
            set_property("item_id", "event_data.item_id")
        }
    }

    "qadb/reduce-product-questions"(description: "define properties for qadb reduce-product-questions experiment") {
        startWith {
            set_property("catalog_product_id", "event_data.catalog_product_id")
            set_property("catalog_parent_id", "event_data.catalog_parent_id")
            set_property("item_id", "event_data.item_id")
        }
    }

    "qadb/qadb-on-viewport-vip"(description: "define properties for item_id qadb viewport for vip experiment") {
        startWith {
            set_property("item_id", "event_data.item_id")
        }
    }


    "search_properties"(description: "define properties for order_id") {
        startWith {
            set_property("item_ids", "event_data.results")
            experiment(regex("search/.*"))
        }
    }

    "pdp_properties"(description: "define properties for order_id") {
        startWith {
            set_property("catalog_product_id", "event_data.catalog_product_id")
            set_property("item_id", "event_data.item_id")
            experiment(regex("pdp/.*"))
        }
    }
    
    "qadb_properties"(description: "define properties for order_id") {
        startWith {
            set_property("catalog_product_id", "event_data.catalog_product_id")
            set_property("item_id", "event_data.item_id")
            experiment(regex("qadb/.*"))
        }
    }
    
    "qadb/qadb-input"(description: "define properties for catalog_product_id qadb input experiment") {
        startWith {
            set_property("catalog_product_id", "event_data.catalog_product_id")
            set_property("item_id", "event_data.item_id")
        }
    }

    "new_congrats_properties"(description: "define properties for order_id in new_congrats experiments") {
        startWith {
            set_property("order_id", "event_data.order_id")
            experiment(regex("buyingflow/new_congrats.*"))
        }
    }

}
