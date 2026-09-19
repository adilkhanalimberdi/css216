package main.hw2

class Song(
    val title: String,
    val artist: String,
    val yearPublished: Int,
    val playCount: Int = 0
) {
    fun isPopular(): Boolean = playCount >= 1000

    override fun toString(): String {
        return "$title, performed by $artist, was released in $yearPublished"
    }
}

fun main() {
    val song1 = Song("5 Minutes Alone", "Pantera", 1994, 1500)
    val song2 = Song("Money Trees", "Kendrick Lamar", 2012, 800)

    println(song1)
    println("is popular: ${song1.isPopular()}")

    println(song2)
    println("is popular: ${song2.isPopular()}")
}