package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"

    test("1p TaxManager return success is OK"){
        "/1p_tax_manager/process/sap/return/success"(platform: "/web", type: TrackType.Event) {
            sku = "699227"
            site_id = "MLB"
            sap_user_id = ""
        }
    }
    test("1p TaxManager return fail is OK"){
        "/1p_tax_manager/process/sap/return/fail"(platform: "/web", type: TrackType.Event) {
            sku = "699227"
            site_id = "MLB"
            sap_user_id = "9500000326"
        }
    }
    test("1p TaxManager conflict creation success is OK"){
        "/1p_tax_manager/pre_process/conflict_creation"(platform: "/web", type: TrackType.Event) {
            sku = "699227"
            site_id = "MLB"
            sap_user_id = "9500000326"
            site_conflict = true
            combination_conflict = true
        }
    }
    test("1p TaxManager return spreadsheet is OK"){
        "/1p_tax_manager/process/sap/return_spreadsheet/success"(platform: "/web", type: TrackType.Event) {
            sku = "699227"
            site_id = "MLB"
            sap_user_id = "9500000326"
        }
    }
    test("1p TaxManager receive tax-combination is OK"){
        "/1p_tax_manager/pre_process/tax_combination"(platform: "/web", type: TrackType.Event) {
            sku = "699227"
            site_id = "MLB"
            sap_user_id = "9500000326"
        }
    }

}


