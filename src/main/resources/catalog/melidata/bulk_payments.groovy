package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    def userStructure = objectSchemaDefinitions {
      user_id(required: true, type: PropertyType.Numeric)
      payment_amount(required: true, type: PropertyType.Numeric)
      payment_reference(required: false, type: PropertyType.String)
    }

    def paymentStructure = objectSchemaDefinitions {
      payment_id(required: true, type: PropertyType.Numeric)
      amount(required: true, type: PropertyType.Numeric)
      status(required: true, type: PropertyType.String, values: ["pending", "approved", "rejected"])
    }

    /**
     * Bulk Payments Screen Tracks
     */
    "/send_money"(platform: "/", isAbstract: true) {}
    
    "/send_money/transfer_options"(platform: "/", type: TrackType.View) {}

    "/bulk_payments"(platform: "/", isAbstract: true) {}
    "/bulk_payments/suppliers"(platform: "/", isAbstract: true) {}

    "/bulk_payments/suppliers/init"(platform: "/", type: TrackType.View) {
      type(required: true, type:PropertyType.String, values:["onboarding", "filled_list", "empty_list"], description: "Type of screen that see the user. This path has 3 different possible views")
      available_contacts(required:false, type: PropertyType.ArrayList(PropertyType.Map(userStructure)), description: "Available contacts in this step ")
      available_balance(required:false, type:PropertyType.Numeric, description: "Available balance in this step to make payments")
    }
    "/bulk_payments/suppliers/add"(platform: "/", type: TrackType.View) {}
    "/bulk_payments/suppliers/verify"(platform: "/", type: TrackType.View) {}
    "/bulk_payments/suppliers/payment_review"(platform: "/", type: TrackType.View) {
      available_balance(required:true, type:PropertyType.Numeric, description: "Available balance in this step to make payments")
      users(required:true, type: PropertyType.ArrayList(PropertyType.Map(userStructure)), description: 'Users that has been checkd to receive a payment')
    }
    "/bulk_payments/suppliers/payment_result"(platform: "/", type: TrackType.View) {
      congrat_type(required:true, type: PropertyType.String, values: ["approved", "pending", "rejected", "mixed"])
      payments(required:false, type: PropertyType.ArrayList(PropertyType.Map(paymentStructure)))
    }
    
    //Events
    "/bulk_payments/suppliers/contact_add"(platform: "/",type: TrackType.Event) {
      status(required:true, type: PropertyType.String, values:["success", "error"], description:"Add Contact Event. Values possibles: Succes or Error")
      detail(required:false, type: PropertyType.String, description:"Detail of the type of track. Useful for error event, to put a detail of the error.")
    }
    "/bulk_payments/suppliers/contact_delete"(platform: "/",type: TrackType.Event) {
      status(required:true, type: PropertyType.String, values:["success", "error"], description:"Add Contact Event. Values possibles: Succes or Error")
      supplier_id(required: true, type: PropertyType.Numeric, description: "UserId deleted in this event")
    }
    "/bulk_payments/suppliers/contact_select"(platform: "/",type: TrackType.Event) {
      supplier_id(required: true, type: PropertyType.Numeric, description: "UserId selected in this event")
    }
    "/bulk_payments/suppliers/contact_add_reference"(platform: "/",type: TrackType.Event) {
      supplier_email(required: true, type:PropertyType.String, description: "Email from the supplier that is changing the reference")
      reference(required: true, type: PropertyType.String, description: "The reference added in this event")
    }
    "/bulk_payments/suppliers/click_to_review"(platform: "/",type: TrackType.Event) {
      status(required:true, type: PropertyType.String, values:["success", "error"], description:"Status for the review action. Values possibles: Succes or Error")
      users(required:false, type: PropertyType.ArrayList(PropertyType.Map(userStructure)), description: 'Users that has been checked to receive a payment')
    }
    "/bulk_payments/suppliers/click_to_modify"(platform: "/",type: TrackType.Event) {}
    "/bulk_payments/suppliers/send_invitation"(platform: "/",type: TrackType.Event) {
      status(required:true, type: PropertyType.String, values:["success", "error"], description:"Status for the send invitation action. Values possibles: Succes or Error")
    }
}





	 
	 
	 
