package main.hw2

fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}


fun printNotificationSummary(numberOfMessages: Int) {
    println(when (numberOfMessages) {
        in 0 .. 99 -> "You have $numberOfMessages notifications."
        else -> "Your phone is blowing up! You have 99+ notifications."
    })
}
