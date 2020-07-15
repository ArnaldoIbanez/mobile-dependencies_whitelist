package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1212"

    // INSURTECH RODA QPage Abstract
    "/insurtech"(platform: "/", isAbstract: true) {}
    "/insurtech/roda"(platform: "/", isAbstract: true) {}
    "/insurtech/roda/qpage"(platform: "/", isAbstract: true) {}

    // INSURTECH RODA QPage Structures
    def roda_device = objectSchemaDefinitions {
        brand(required: true, type: PropertyType.String, description: "Brand of device. For ex: Samsung.")
        model(required: false, type: PropertyType.String, description: "Model of the device. For ex: J7.")
        model_code(required: true, type: PropertyType.String, description: "Model code of the device. For ex: SM-J700M.")
        size(required: true, type: PropertyType.String, description: "Size of the device. For ex: 64GB.")
    }

    def roda_option = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "ID of RODA option plan to purchase.")
        category(required: true, type: PropertyType.String, description: "Category of the option. For ex: total, screen, accident.")
        price(required: true, type: PropertyType.Numeric, description: "Price of the option.")
        monthly_price(required: true, type: PropertyType.Numeric, description: "Monthly price of the option.")
        fee_price(required: true, type: PropertyType.Numeric, description: "Fee price for meli of the option.")
        currency_id(required: true, type: PropertyType.String, description: "Currency id of the option. For ex: BRL.")
        deductible(required: true, type: PropertyType.Numeric, description: "Deductible percentage of the option.")
        deductible_amount(required: true, type: PropertyType.Numeric, description: "Deductible amount of the option.")
        check(required: true, type: PropertyType.String, description: "Check HW required. For ex: total.")
    }

    def roda_option_short = objectSchemaDefinitions {
        category(required: true, type: PropertyType.String, description: "Category of the option. For ex: total, screen, accident.")
        price(required: true, type: PropertyType.Numeric, description: "Price of the option.")
        deductible(required: true, type: PropertyType.Numeric, description: "Deductible percentage of the option.")
    }

    "/insurtech/roda/qpage"(platform:"/", type: TrackType.View) {
        device(required: true, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        options(required: false, type: PropertyType.ArrayList(PropertyType.Map(roda_option_short)), description: "Options presented in the qpage for quotation")
        financing_type(required: false, type: PropertyType.Map(financing_type_track_structure), description: "Financing data of item if it has")
    }

    "/insurtech/roda/qpage/deductible"(platform:"/", type: TrackType.Event) {
        device(required: true, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
    }

    "/insurtech/roda/qpage/faq"(platform:"/", type: TrackType.Event) {
        device(required: true, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        faq(required: true, type: PropertyType.String, description: "Name of the FAQ viewed. For ex: protection-cancel, deductible-fee")
    }

    "/insurtech/roda/qpage/buy"(platform:"/", type: TrackType.Event) {
        device(required: true, type: PropertyType.Map(roda_device), description: "Device data of the track accessing the qpage for quotation")
        option(required: true, type: PropertyType.Map(roda_option), description: "Option plan selected on purchase.")
        financing_type(required: false, type: PropertyType.Map(financing_type_track_structure), description: "Financing data of item if it has")
    }
}
