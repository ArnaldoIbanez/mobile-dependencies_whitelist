package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"

    test("1p TaxManager return success is OK"){
        "/1P_TAX_MANAGER/PROCESS/SAP/RETURN/SUCCESS"(platform: "/web", type: TrackType.Event) {
            sku = "699227"
            site_id = "MLB"
            sap_user_id = ""
        }
    }
    test("1p TaxManager return fail is OK"){
        "/1P_TAX_MANAGER/PROCESS/SAP/RETURN/FAIL"(platform: "/web", type: TrackType.Event) {
            sku = "699227"
            site_id = "MLB"
            sap_user_id = "9500000326"
        }
    }
    test("1p TaxManager conflict creation success is OK"){
        "/1P_TAX_MANAGER/PRE_PROCESS/CONFLICT_CREATION"(platform: "/web", type: TrackType.Event) {
            sku = "699227"
            site_id = "MLB"
            sap_user_id = "9500000326"
            site_conflict = true
            combination_conflict = true
        }
    }
    test("1p TaxManager return spreadsheet is OK"){
        "/1P_TAX_MANAGER/PROCESS/SAP/RETURN_SPREADSHEET/SUCCESS"(platform: "/web", type: TrackType.Event) {
            sku = "699227"
            site_id = "MLB"
            sap_user_id = "9500000326"
        }
    }
    test("1p TaxManager receive tax-combination is OK"){
        "/1P_TAX_MANAGER/PRE_PROCESS/TAX_COMBINATION"(platform: "/web", type: TrackType.Event) {
            sku = "699227"
            site_id = "MLB"
            sap_user_id = "9500000326"
        }
    }

}


