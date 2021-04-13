import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = '1149'

    def structPrimaryActionWithdraw = objectSchemaDefinitions{
        disable(requerid:true, type: PropertyType.Boolean, description: "Indicate if button must be turn on or not")
        label(requerid:false, type: PropertyType.String)
        link(requerid:false, type: PropertyType.String, description: "Indicate if must be redirect or not")
    }

    def structDataMakeWithdraw = objectSchemaDefinitions {
        description(required:true, type: PropertyType.ArrayList, description: "Information to the user about withdrawal accreditation")
        id(required:false, type: PropertyType.String)
        primary_action(required:false, type: PropertyType.Map(structPrimaryActionWithdraw))
        result_type(required:false, type: PropertyType.String)
        title(required:true, type:PropertyType.String, description: "Resumen of withdraw")
    }

    def structDataAddAccount = objectSchemaDefinitions {
        bank_id(required:true, type: PropertyType.String, description: "Bank identificator")
        branch(required:true, type: PropertyType.String, description: "Agency of bank")
        holder(required:true, type: PropertyType.String, description: "Name of account")
        identification(required:false, type: PropertyType.String)
        number(required:true, type:PropertyType.String, description: "Number of account")
        type(required:true, type:PropertyType.String, description: "Type of account")
    }

    /**
     * Digital Wallet Screen Tracks
     */

    "/digital_wallet"(platform: "/", type: TrackType.View) {}

    /**
     * Digital Wallet Events Tracks
     */

    "/digital_wallet/click_show_video"(platform: "/", type: TrackType.Event) {
        section(required: true, description: "Section from which the event comes", type: PropertyType.String)
    }

    "/digital_wallet/click_download_app"(platform: "/", type: TrackType.Event) {
        section_store(required: true, description: "Section from which the event comes and Store (Google Play or App Store)", type: PropertyType.String)
    }

    "/fund_account"(platform: "/", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }

    "/fund_account/confirm"(platform: "/web", initiative: "1047"){}
    "/fund_account/fund_amount"(platform: "/mobile") {}
    "/fund_account/other_payment_methods"(platform: "/mobile") {}
    "/fund_account/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/money_detail"(platform: "/", isAbstract: true) {}
    "/money_detail"(platform: "/mobile", isAbstract: true) {
        flow (required:false, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/money_detail/balance"(platform: "/mobile") {}
    "/money_detail/help_modal"(platform: "/mobile") {}

    //Withdraw
    "/money_detail/withdraw/main"(platform: "/mobile", type: TrackType.View) {}
    "/money_detail/withdraw/confirmation"(platform: "/mobile", type: TrackType.View) {}
    "/money_detail/withdraw/congrats"(platform: "/mobile", type: TrackType.View) {}
    "/money_detail/withdraw/add_account"(platform: "/mobile", type: TrackType.View) {}
    "/money_detail/withdraw/select_bank"(platform: "/mobile", type: TrackType.View) {}
    "/money_detail/withdraw"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/daily_detail"(platform: "/mobile", type : TrackType.View) {}

    "/money_detail/money_advance"(platform: "/mobile", type : TrackType.Event) {}
    "/money_detail/money_out"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/scan"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/result"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/add_info"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/congrats"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/web_view"(platform: "/mobile", type : TrackType.View) {}

    "/money_detail/restrictions"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/point_home"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/manual_code"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/confirmation"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/withdraw/error"(platform: "/mobile", isAbstract: true) {}
    "/money_detail/withdraw/error/high_risk"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/withdraw/error/generic_error"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/withdraw/uif_change_account"(platform: "/mobile",   type : TrackType.View) {}
    "/money_detail/withdraw/delay"(platform: "/mobile", isAbstract: true) {}
    "/money_detail/withdraw/delay/offline"(platform: "/mobile",   type : TrackType.View) {}
    "/money_detail/shopping"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/withdraw/delay/manual_review"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/credits"(platform: "/mobile", type : TrackType.View) {}
    "/money_detail/activities"(platform: "/mobile", type : TrackType.View) {}

    "/money_detail/tecban"(platform: "/", type : TrackType.View) {}
    "/money_detail/credits_merchant_admin"(platform: "/mobile", type : TrackType.Event) {}
    "/money_detail/activities_v2_list"(platform: "/mobile", type : TrackType.View) {}


    "/new-account"(platform: "/", type: TrackType.View) {}

    //tracks for new flow (withdraw and new account)
    "/new-withdraw"(platform: "/", type: TrackType.View) {}
    "/new-withdraw/confirm"(platform: "/", type: TrackType.View) {
        type (required: true, type: PropertyType.String, description: "tipo de confirm")
        type_detail (required: true, type: PropertyType.String, description: "detalle de confirm")
    }
    "/new-withdraw/account-select"(platform: "/", type: TrackType.View) {}
    "/new-withdraw/second-password"(platform: "/", type: TrackType.View) {}
    "/new-withdraw/congrats"(platform: "/", type: TrackType.View) {}
    "/new-withdraw/congrats-advance"(platform: "/", type: TrackType.View) {}

    "/withdraw"(platform: "/", isAbstract: true) {
        flow (required:false, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/withdraw/take_money_out"(platform: "/") {}
    "/withdraw/withdrawable_money"(platform: "/mobile") {}
    "/withdraw/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }

    "/withdraw_advance"(platform: "/mobile", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/withdraw_advance/take_money_out"(platform: "/mobile") {}
    "/withdraw_advance/select_bank"(platform: "/mobile") {}
    "/withdraw_advance/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }
    "/withdraw/bacen"(platform: "/mobile", isAbstract: true) {}
    "/withdraw/bacen/ok"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/bacen/cancel"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/bacen/error"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/bacen/open"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/bacen/close"(platform: "/mobile", type: TrackType.View) {}

    "/withdraw/select_bank"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/select_bank/delete_account_modal"(platform:"/mobile", type: TrackType.Event){}
    "/withdraw/select_bank/delete_account_modal/confirm"(platform:"/mobile", type: TrackType.Event){
        bank_account_id (required: true, description: "Bank account selected to be deleted")
    }
    "/withdraw/select_bank/delete_account_modal/cancel"(platform:"/mobile", type: TrackType.Event){}

    "/withdraw/main"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/confirmation"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/make_withdraw"(platform: "/mobile", type: TrackType.Event) {
        data    (required:false, type: PropertyType.Map(structDataMakeWithdraw), description: "Contains information of windows show to user e.g title, disable or not button")
        label  (required:false, type: PropertyType.String, description: "Operation congrats")
    }
    "/withdraw/add_account"(platform: "/mobile", type: TrackType.Event) {
        data    (required:false, type: PropertyType.Map(structDataAddAccount), description: "Contains information of new account e.g holder name, bank name")
        label   (required:false, type: PropertyType.String, description: "Operation add")
    }
    "/withdraw/add_advance"(platform: "/mobile", type: TrackType.Event) {
        label   (required:false, type: PropertyType.String, description: "Operation add advance")
    }
    "/withdraw/add_bank_account"(platform: "/mobile", type: TrackType.Event) {
        label   (required:false, type: PropertyType.String, description: "Operation add bank account")
    }
    "/withdraw/edit_input"(platform: "/mobile", type: TrackType.Event) {
        label   (required:false, type: PropertyType.String, description: "Operation edit input")
    }
    "/withdraw/congrats"(platform: "/mobile", type: TrackType.View) {}
    "/withdraw/error"(platform: "/mobile", isAbstract: true) {}
    "/withdraw/error/generic_error"(platform: "/mobile", type : TrackType.View) {}
    "/withdraw/error/withdraw_failed"(platform: "/mobile", type : TrackType.View) {}
    "/withdraw/error/high_risk"(platform: "/mobile", type : TrackType.View) {}
    "/withdraw/error/uif"(platform: "/mobile", type : TrackType.View) {}
    "/withdraw/manual_code"(platform: "/mobile", type : TrackType.View) {}
    "/withdraw/delay"(platform: "/mobile", isAbstract : true) {}
    "/withdraw/delay/manual_review"(platform: "/mobile",   type : TrackType.View) {}
    "/withdraw/delay/offline"(platform: "/mobile",   type : TrackType.View) {}
    "/withdraw/uif_change_account"(platform: "/mobile",   type : TrackType.View) {}
    "/withdraw/restriction"(platform: "/mobile", type: TrackType.View) {}

}