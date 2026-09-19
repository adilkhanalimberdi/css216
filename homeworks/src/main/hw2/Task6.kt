package main.hw2

open class Phone(private var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(isScreenLightOn: Boolean, var isFolded: Boolean = false) : Phone(isScreenLightOn) {
    fun fold() {
        isFolded = true
    }

    fun unfold() {
        isFolded = false
    }

    override fun switchOn() {
        if (!isFolded) {
            super.switchOn()
        }
    }
}

fun main() {
    val foldable = FoldablePhone(isScreenLightOn = false, isFolded = true)
    foldable.checkPhoneScreenLight()

    foldable.unfold()
    foldable.checkPhoneScreenLight()

    foldable.switchOn()
    foldable.checkPhoneScreenLight()

    foldable.fold()
    foldable.switchOff()
}