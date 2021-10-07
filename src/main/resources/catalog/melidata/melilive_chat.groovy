package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    //Definitions

    def broadcast = objectSchemaDefinitions {
        broadcast_id(required: true, PropertyType.String, description: "Broadcast ID")
    }

    //Tracks

    "/melilive/stream/chat/first_message"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        broadcast(required: true, type: PropertyType.Map(broadcast), description: "Broadcast object")
        room_id(required: true, type: PropertyType.String, description: "Room ID where chat belongs")
        user_role(required: true, type: PropertyType.String, description: "User associated with the action")
    }

    "/melilive/stream/chat/message_error"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        broadcast(required: true, type: PropertyType.Map(broadcast), description: "Broadcast object")
        room_id(required: true, type: PropertyType.String, description: "Room ID where chat belongs")
        user_role(required: true, type: PropertyType.String, description: "User associated with the action")
    }

    "/melilive/stream/chat/chat_scroll"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        broadcast(required: true, type: PropertyType.Map(broadcast), description: "Broadcast object")
        room_id(required: true, type: PropertyType.String, description: "Room ID where chat belongs")
        user_role(required: true, type: PropertyType.String, description: "User associated with the action")
    }


}