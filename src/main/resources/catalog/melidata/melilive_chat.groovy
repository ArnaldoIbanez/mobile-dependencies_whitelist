package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    //Definitions

    //Broadcast response object format definition
    def chat_stream_info_definition = objectSchemaDefinitions {
        broadcast_id(required: true, type: PropertyType.String, description: "Broadcast ID")
    }

    //Tracks

    "/melilive/stream/chat/first_message"(platform: "/", type: TrackType.Event) {
        stream(required: true, type: PropertyType.Map(chat_stream_info_definition), description: "Broadcast object")
        room_id(required: true, type: PropertyType.String, description: "Room ID where chat belongs")
    }

    "/melilive/stream/chat/message_error"(platform: "/", type: TrackType.Event) {
        stream(required: true, type: PropertyType.Map(chat_stream_info_definition), description: "Broadcast object")
        room_id(required: true, type: PropertyType.String, description: "Room ID where chat belongs")
    }

    "/melilive/stream/chat/chat_scroll"(platform: "/", type: TrackType.Event) {
        stream(required: true, type: PropertyType.Map(chat_stream_info_definition), description: "Broadcast object")
        room_id(required: true, type: PropertyType.String, description: "Room ID where chat belongs")
    }

    "/melilive/creator/chat/moderation"(platform: "/", type: TrackType.Event) {
        stream(required: true, type: PropertyType.Map(chat_stream_info_definition), description: "Broadcast object")
        room_id(required: true, type: PropertyType.String, description: "Room ID where chat belongs")
    }

    "/melilive/creator/chat/ban"(platform: "/", type: TrackType.Event) {
        stream(required: true, type: PropertyType.Map(chat_stream_info_definition), description: "Broadcast object")
        room_id(required: true, type: PropertyType.String, description: "Room ID where chat belongs")
    }

}