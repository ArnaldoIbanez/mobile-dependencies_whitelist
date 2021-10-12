package melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBuisiness = "mercadolibre"

    test("Chat messages") {
        "/melilive/stream/chat/first_message"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe"
            ]
            room_id = "room-v3-03"
        }

        "/melilive/stream/chat/message_error"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe"
            ]
            room_id = "room-v3-03"
        }

        "/melilive/stream/chat/chat_scroll"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe"
            ]
            room_id = "room-v3-03"
        }
    }

    test("Creator / Moderator chat") {
        "/melilive/creator/chat/ban"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe"
            ]
            room_id = "room-v3-03"
        }

        "/melilive/creator/chat/moderation"(platform: "/") {
            stream = [
                    "broadcast_id": "ede1ad69-c277-4f60-90c8-b845ca804fbe"
            ]
            room_id = "room-v3-03"
        }
    }
}
