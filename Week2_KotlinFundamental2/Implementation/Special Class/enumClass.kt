enum class DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

fun printDay(day: DayOfWeek) {
    println("Today is $day")
}

fun main() {
    val today = DayOfWeek.MONDAY
    printDay(today) 
}
