package main.hw3

enum class Daypart {
    MORNING, AFTERNOON, EVENING
}

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val duration: Int
)

fun main() {
    val events = mutableListOf(
        Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, duration = 0),
        Event(title = "Eat breakfast", daypart = Daypart.MORNING, duration = 15),
        Event(title = "Eat breakfast", daypart = Daypart.MORNING, duration = 15),
        Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, duration = 60),
        Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, duration = 10),
        Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, duration = 45)
    )

    val eventsByDaypart = events.groupBy {
        it.daypart
    }
    eventsByDaypart.forEach {(daypart, events) ->
        val capitalizedDaypart = daypart.name.lowercase().replaceFirstChar {
            if (it.isLowerCase())
                it.titlecase()
            else
                it.toString()
        }
        println("$capitalizedDaypart: ${events.size} events")
    }
}