enum class DayOfWeek(val number: Int) {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    fun isWeekend(): Boolean {
        return this in listOf(SATURDAY,SUNDAY)
    }
}

fun printDayType(day: DayOfWeek) {
    if (day.isWeekend()) {
        println("$day is a weekend day.")
    } else {
        println("$day is a weekday.")
    }
    println("day:${day.number}")
}

internal fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }