package vi_generics

import java.util.*

fun <T, C : MutableCollection<T>> Iterable<T>.partitionTo(left: C, right: C, predicate: (T) -> Boolean): Pair<C, C> {
    val (included, excluded) = this.partition { predicate(it) }
    return Pair(included.toCollection(left), excluded.toCollection(right))
}

fun List<String>.partitionWordsAndLines(): Pair<List<String>, List<String>> {
    return partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
}

fun Set<Char>.partitionLettersAndOtherSymbols(): Pair<Set<Char>, Set<Char>> {
    return partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
}
