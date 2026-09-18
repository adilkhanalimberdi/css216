package main.hw1

/*
Given:
The first parameter holds the number of minutes that you spent today and the second parameter holds the number of minutes that you spent yesterday.
The function returns a true value if you spent more time on the phone today compared to yesterday. Otherwise, it returns a false value.
*/

fun compareScreenTime(today: Int, yesterday: Int): Boolean {
    return today > yesterday
}

fun main() {
    println(compareScreenTime(today = 300, yesterday = 250))
    println(compareScreenTime(today = 300, yesterday = 300))
    println(compareScreenTime(today = 200, yesterday = 220))
}