package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (year == other.year) {
            if (month == other.month) {
                return dayOfMonth - other.dayOfMonth
            }
            return month - other.month
        }
        return year - other.year
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) {
    operator fun contains(item: MyDate): Boolean {
        return start <= item && item <= endInclusive
    }
}
