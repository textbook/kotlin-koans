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

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

operator fun MyDate.plus(interval: TimeInterval) = addTimeIntervals(interval, 1)
operator fun MyDate.plus(interval: RepeatedTimeInterval) = addTimeIntervals(interval.timeInterval, interval.number)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

operator fun TimeInterval.times(n: Int): RepeatedTimeInterval = RepeatedTimeInterval(this, n)

class DateRange(val start: MyDate, val endInclusive: MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> = object : Iterator<MyDate> {
        private var current = start

        override fun hasNext(): Boolean = current <= endInclusive

        override fun next(): MyDate {
            val next = current
            current = next.nextDay()
            return next
        }
    }

    operator fun contains(item: MyDate): Boolean {
        return start <= item && item <= endInclusive
    }
}
