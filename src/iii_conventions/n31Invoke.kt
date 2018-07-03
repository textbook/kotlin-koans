package iii_conventions

class Invokable {

    private var invocations = 0

    operator fun invoke(): Invokable {
        invocations += 1
        return this
    }

    fun getNumberOfInvocations(): Int = invocations
}

fun task31(invokable: Invokable): Int {
    return invokable()()()().getNumberOfInvocations()
}
