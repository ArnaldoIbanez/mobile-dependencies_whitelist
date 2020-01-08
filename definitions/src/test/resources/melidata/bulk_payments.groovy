package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    /**
     * Bulk Payments Screen Tracks
     */

    test("Bulk Payments - views") {
        "/send_money/transfer_options"(platform: "/", type: TrackType.View) {
            flow = "/bulk_payments"
        }
        "/bulk_payments/suppliers/init"(platform: "/", type: TrackType.View) {
          available_contacts = [ 
            [user_id: 12345678, payment_amount:12300, payment_reference: "Proveedor 1"],
            [user_id: 58765432, payment_amount:10303, payment_reference: "Proveedor 2"],
            [user_id: 98765431, payment_amount:42345, payment_reference: "Proveedor 3"]
          ]
          available_balance = 432765
          type = "filled_list"
        }
        "/bulk_payments/suppliers/init"(platform: "/", type: TrackType.View) {
          type = "onboarding"
        }
        "/bulk_payments/suppliers/init"(platform: "/", type: TrackType.View) {
          available_balance = 432765
          type = "empty_list"
        }
        "/bulk_payments/suppliers/add"(platform: "/", type: TrackType.View) {}
        "/bulk_payments/suppliers/verify"(platform: "/", type: TrackType.View) {}
        "/bulk_payments/suppliers/payment_review"(platform: "/", type: TrackType.View) {
          available_balance = 438765
          users = [ 
            [user_id: 12345678, payment_amount:12300, payment_reference: "Proveedor 1"],
            [user_id: 58765432, payment_amount:10303, payment_reference: "Proveedor 2"],
            [user_id: 98765431, payment_amount:42345, payment_reference: "Proveedor 3"]
          ]
        }
        "/bulk_payments/suppliers/payment_result"(platform: "/", type: TrackType.View) {
          congrat_type = "approved"
        }
        "/bulk_payments/suppliers/payment_result"(platform: "/", type: TrackType.View) {
          congrat_type = "pending"
        }
        "/bulk_payments/suppliers/payment_result"(platform: "/", type: TrackType.View) {
          congrat_type = "rejected"
        }
        "/bulk_payments/suppliers/payment_result"(platform: "/", type: TrackType.View) {
          congrat_type = "mixed"
          payments = [
            [payment_id:"1234567", status: "pending", amount: "47372"],
            [payment_id:"4838492", status: "approved", amount: "383472"],
            [payment_id:"2494382", status: "rejected", amount: "18291823"]
          ]
        }
        
        "/bulk_payments/suppliers/contact_add"(platform: "/",type: TrackType.Event) {
          status = "success"
        }
        "/bulk_payments/suppliers/contact_add"(platform: "/",type: TrackType.Event) {
          status = "error"
          detail = "no se pudo agregar el contacto"
        }
        
        "/bulk_payments/suppliers/contact_delete"(platform: "/",type: TrackType.Event) {
          status = "success"
          supplier_id = 12345642
        }
        
        "/bulk_payments/suppliers/contact_delete"(platform: "/",type: TrackType.Event) {
          status = "error"
          supplier_id = 12345642
        }

        "/bulk_payments/suppliers/contact_select"(platform: "/",type: TrackType.Event) {
          supplier_id = 1234567
        }
        
        "/bulk_payments/suppliers/click_to_review"(platform: "/",type: TrackType.Event) {
          status = 'success'
          users = [ 
            [user_id: 12345678, payment_amount:12300, payment_reference: "Proveedor 1"],
            [user_id: 58765432, payment_amount:10303, payment_reference: "Proveedor 2"],
            [user_id: 98765431, payment_amount:42345, payment_reference: "Proveedor 3"]
          ]
        }

        "/bulk_payments/suppliers/click_to_modify"(platform: "/",type: TrackType.Event) {}
        "/bulk_payments/suppliers/send_invitation"(platform: "/",type: TrackType.Event) {
          status = "success"
        }
    }
}
