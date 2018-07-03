package i_introduction._3_Default_Arguments

fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false): String {
    val result = "$name$number"
    return if (toUpperCase) result.toUpperCase() else result
}

fun task3(): String {
    return (foo("a") +
            foo("b", number = 1) +
            foo("c", toUpperCase = true) +
            foo(name = "d", number = 2, toUpperCase = true))
}
