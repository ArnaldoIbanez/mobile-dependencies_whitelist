package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoenvios"

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS PREPARATION APP GENERAL
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Preparation App - Melidata Tracks Tests") {

        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // DATA SET
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        def errorDataSet = {
            seller = [
                    meli_id: 123456
            ]
            context = "auth"
            error = "no_permission"
        }

        def homeDataSet = {
            seller = [
                    meli_id: 123456
            ]
            available_sections = [
                    "picking",
                    "stagein"
            ]
        }

        def eventLabelData = {
            label = "prepapp/label/path"
        }

        def contextDataSet = {
            context = "auth"
            seller = [
                    meli_id: 123456
            ]
        }

        def pickingDataSet = {
            pickup = [
                    id: 123456,
                    wave_id: 123456
            ]
            seller = [
                    meli_id: 123456
            ]
        }

        def pickupListDataSet = {
            pickup = [
                    id: 123456,
                    wave_id: 123456
            ]
            finish_enabled = false
            items_total = 10
            items_found = 8
            items_not_found = 2
            seller = [
                    meli_id: 123456
            ]
        }

        def pickedListDataSet = {
            pickup = [
                    id: 123456,
                    wave_id: 123456
            ]
            items_total = 10
            items_found = 8
            items_not_found = 2
            seller = [
                    meli_id: 123456
            ]
        }

        def productScanDataSet = {
            pickup = [
                    id: 123456,
                    wave_id: 123456
            ]
            item_id = "ID123456"
            variation_id = "VAR123456"
            scan_mode = "handheld"
            items_total = 10
            items_found = 8
            seller = [
                    meli_id: 123456
            ]
        }

        def scanModeDataSet = {
            pickup = [
                    id: 123456,
                    wave_id: 123456
            ]
            scan_mode = "handheld"
            seller = [
                    meli_id: 123456
            ]
        }

        def productWeightUnitDataSet = {
            pickup = [
                    id: 123456,
                    wave_id: 123456
            ]
            item_id = "ID123456"
            variation_id = "VAR123456"
            scan_mode = "handheld"
            measure = "g"
            items_total = 10
            seller = [
                    meli_id: 123456
            ]
        }

        def productQuantityDataSet = {
            pickup = [
                    id: 123456,
                    wave_id: 123456
            ]
            item_id = "ID123456"
            variation_id = "VAR123456"
            measure = "g"
            items_total = 10
            seller = [
                    meli_id: 123456
            ]
        }

        def productNotFoundOrLessDataSet = {
            pickup = [
                    id: 123456,
                    wave_id: 123456
            ]
            item_id = "ID123456"
            variation_id = "VAR123456"
            seller = [
                    meli_id: 123456
            ]
        }

        def sellerDataSet = {
            seller = [
                    meli_id: 123456
            ]
        }

        def stageinDataSet = {
            seller = [
                    meli_id: 123456
            ]
            scan_mode = "handheld"
        }

        def omsListDataSet = {
            seller = [
                    meli_id: 123456
            ]
            page = 1
            page_count = 12
            filters = [
                    "status:ready_to_pick",
                    "route:pending"
            ]
        }

        def overrideTemperatureDataSet = {
            pickup = [
                    id: 123456,
                    wave_id: 123456
            ]
            item_id = "ID123456"
            variation_id = "VAR123456"
            item_temperature = "DRY"
            parcel_temperature = "FROZEN"
            seller = [
                    meli_id: 123456
            ]
        }

        def itemIdsDataSet = {
            pickup = [
                    id: 123456,
                    wave_id: 123456
            ]
            item_id = "ID123456"
            variation_id = "VAR123456"
            seller = [
                    meli_id: 123456
            ]
        }

        def packsDownloadDataSet = {
            seller = [
                    meli_id: 123456
            ]
            page = 1
            page_count = 12
            filters = [
                    "status:ready_to_pick",
                    "route:pending"
            ]
            packs = [
                    2000002751055068,
                    2000002751041421
            ]
        }

        def packDetailsDataSet = {
            order_number = 2000001892783456
            status = "read_to_pic"
        }


        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TEST TRACKS PREPARATION APP - GENERAL
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        "/prepapp/splash"(platform:"/", type: TrackType.View) {
        }

        "/prepapp/enter"(platform:"/", type: TrackType.View) {
        }

        "/prepapp/auth"(platform:"/", type: TrackType.View) {
        }

        "/prepapp/error"(platform:"/", type: TrackType.View) {
            errorDataSet()
        }

        "/prepapp/home"(platform:"/", type: TrackType.View) {
            homeDataSet()
        }

        "/prepapp/navigation/open"(platform:"/", type: TrackType.Event) {
            eventLabelData()
        }

        "/prepapp/navigation/log_out"(platform:"/", type: TrackType.Event) {
            eventLabelData()
        }

        "/prepapp/success"(platform:"/", type: TrackType.View) {
            contextDataSet()
        }

        "/prepapp/cancelled"(platform:"/", type: TrackType.View) {
            contextDataSet()
        }

        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TEST TRACKS PREPARATION APP - PICKING SECTION
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        "/prepapp/picking"(platform:"/", type: TrackType.View) {
            pickingDataSet()
        }

        "/prepapp/picking/get_pickup"(platform:"/", type: TrackType.View) {
            pickingDataSet()
        }

        "/prepapp/picking/summary"(platform:"/", type: TrackType.View) {
            pickingDataSet()
        }

        "/prepapp/picking/pickup_list"(platform:"/", type: TrackType.View) {
            pickupListDataSet()
        }

        "/prepapp/picking/pickup_list/filter_pending"(platform:"/", type: TrackType.Event) {
            sellerDataSet()
        }

        "/prepapp/picking/pickup_list/filter_not_found"(platform:"/", type: TrackType.Event) {
            sellerDataSet()
        }

        "/prepapp/picking/picked_list"(platform:"/", type: TrackType.View) {
            pickedListDataSet()
        }

        "/prepapp/picking/product/scan"(platform:"/", type: TrackType.View) {
            productScanDataSet()
        }

        "/prepapp/picking/product/input"(platform:"/", type: TrackType.View) {
            scanModeDataSet()
        }

        "/prepapp/picking/product/weight"(platform:"/", type: TrackType.View) {
            productWeightUnitDataSet()
        }

        "/prepapp/picking/product/unit"(platform:"/", type: TrackType.View) {
            productWeightUnitDataSet()
        }

        "/prepapp/picking/product/quantity"(platform:"/", type: TrackType.View) {
            productQuantityDataSet()
        }

        "/prepapp/picking/parcel/scan"(platform:"/", type: TrackType.View) {
            scanModeDataSet()
        }

        "/prepapp/picking/parcel/input"(platform:"/", type: TrackType.View) {
            scanModeDataSet()
        }

        "/prepapp/picking/parcel/wrong_temperature"(platform: "/", type: TrackType.View) {
            overrideTemperatureDataSet()
        }

        "/prepapp/picking/parcel/conservation_change"(platform: "/", type: TrackType.View) {
            itemIdsDataSet()
        }

        "/prepapp/picking/product/not_found"(platform:"/", type: TrackType.View) {
            productNotFoundOrLessDataSet()
        }

        "/prepapp/picking/product/less_units"(platform:"/", type: TrackType.View) {
            productNotFoundOrLessDataSet()
        }

        "/prepapp/picking/no_pickup"(platform:"/", type: TrackType.View) {
            sellerDataSet()
        }

        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TEST TRACKS PREPARATION APP - STAGE IN SECTION
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        "/prepapp/stagein"(platform:"/", type: TrackType.View) {
            sellerDataSet()
        }

        "/prepapp/stagein/parcel/scan"(platform:"/", type: TrackType.View) {
            stageinDataSet()
        }

        "/prepapp/stagein/parcel/input"(platform:"/", type: TrackType.View) {
            stageinDataSet()
        }

        "/prepapp/stagein/location/scan"(platform:"/", type: TrackType.View) {
            stageinDataSet()
        }

        "/prepapp/stagein/location/input"(platform:"/", type: TrackType.View) {
            stageinDataSet()
        }

        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TEST TRACKS PREPARATION APP - ORDER MANAGEMENT SYSTEM
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        "/prepapp/oms"(platform:"/", type: TrackType.View) {
            sellerDataSet()
        }

        "/prepapp/oms/backlog"(platform:"/", type: TrackType.View) {
            sellerDataSet()
            omsListDataSet()
        }

        "/prepapp/oms/backlog/filter"(platform:"/", type: TrackType.Event) {
            omsListDataSet()
        }

        "/prepapp/oms/backlog/download"(platform:"/", type: TrackType.Event) {
            packsDownloadDataSet()
        }

        "/prepapp/oms/backlog/prioritize"(platform:"/", type: TrackType.Event) {
            omsListDataSet()
        }

        "/prepapp/oms/backlog/unbind"(platform:"/", type: TrackType.Event) {
            omsListDataSet()
        }

        "/prepapp/oms/backlog/detail"(platform:"/", type: TrackType.View) {
            sellerDataSet()
            packDetailsDataSet()
        }

        "/prepapp/oms/routes"(platform:"/", type: TrackType.View) {
            sellerDataSet()
            omsListDataSet()
        }

        "/prepapp/oms/routes/delete"(platform:"/", type: TrackType.Event) {
            omsListDataSet()
        }

        "/prepapp/oms/routes/filter"(platform:"/", type: TrackType.Event) {
            omsListDataSet()
        }

        "/prepapp/oms/routes/print"(platform:"/", type: TrackType.Event) {
            eventLabelData()
            omsListDataSet()
        }

        "/prepapp/oms/routes/upload"(platform:"/", type: TrackType.View) {
            sellerDataSet()
        }
    }
}