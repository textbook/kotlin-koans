package i_introduction._9_Extension_Functions

import kotlin.math.absoluteValue

fun String.lastChar() = this[this.length - 1]

data class RationalNumber(val numerator: Int, val denominator: Int)

fun Int.r(): RationalNumber = RationalNumber(absoluteValue, 1)
fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)
