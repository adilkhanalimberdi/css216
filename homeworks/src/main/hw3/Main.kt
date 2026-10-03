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

val Event.durationOfEvent: String
    get() = if (this.duration < 60) "short" else "long"

fun main() {
    val events = mutableListOf(
        Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, duration = 0),
        Event(title = "Eat breakfast", daypart = Daypart.MORNING, duration = 15),
        Event(title = "Eat breakfast", daypart = Daypart.MORNING, duration = 15),
        Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, duration = 60),
        Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, duration = 10),
        Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, duration = 45)
    )

    println("Duration of first event of the day: ${events[0].durationOfEvent}")
}