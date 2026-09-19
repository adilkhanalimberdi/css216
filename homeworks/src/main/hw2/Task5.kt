package main.hw2

fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}


class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        var result = ""

        if (hobby != null) {
            result += "Likes to $hobby. "
        }
        if (referrer != null) {
            result += "Has a referrer named ${referrer.name}"

            if (referrer.hobby != null) {
                result += ", who likes to ${referrer.hobby}"
            }

            result += "."
        } else {
            result += "Doesn't have a referrer."
        }

        println("Name: $name")
        println("Age: $age")
        println(result)
    }
}
