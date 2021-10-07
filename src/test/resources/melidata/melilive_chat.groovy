package melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBuisiness = "mercadolibre"

    test("Chat messages") {
        "melilive/stream/chat/first_message"(platform: "/") {
            broadcast = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe"
            ]
            user_role: ""
            room_id: "room-v3-03"
        }

        "melilive/stream/chat/message_error"(platform: "/") {
            broadcast = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe"
            ]
            user_role: ""
            room_id: "room-v3-03"
        }

        "melilive/stream/chat/chat_scroll"(platform: "/") {
            broadcast = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe"
            ]
            user_role: ""
            room_id: "room-v3-03"
        }
    }
}
