data class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    cookies.forEach {
        println("Menu Item: ${it.name}")
    }
    println()

    val fullMenu = cookies.map {
        "${it.name} - $${it.price}"
    }
    println("Full Menu:")
    fullMenu.forEach {
        println(it)
    }
    println()

    val cookieMapper: (Cookie) -> String = {
        "${it.name} - $${it.price}"
    }

    val softCookies = cookies.filter {
        it.softBaked
    }
    val hasFilling = cookies.filter {
        it.hasFilling
    }

    println("Soft Cookies:")
    softCookies.forEach {
        println(cookieMapper(it))
    }
    println()

    println("Cookies with fillings:")
    hasFilling.forEach {
        println(cookieMapper(it))
    }
    println()

    println("Cookies grouped by price:")
    val cookiesByPrice = cookies.groupBy {
        it.price
    }
    cookiesByPrice.forEach { (price, cookies) ->
        print("$$price: ")
        for (index in 1..cookies.size) {
            print(cookies[index - 1].name)
            if (index != cookies.size) {
                print(", ")
            }
        }
        println()
    }
    println()

    println("Cookies sorted by price:")
    val sortedCookies = cookies.sortedBy {
        it.price
    }
    sortedCookies.forEach {
        println(cookieMapper.invoke(it))
    }
    println()

    val totalPrice = cookies.fold(0.0) {total, cookie ->
        total + cookie.price
    }
    println("Total price: $${totalPrice}")
}