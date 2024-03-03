fun main() {
    // Mutable Set
    val mutableSet = mutableSetOf(1, 2, 3, 4, 5)
    println("Mutable Set: $mutableSet")

    mutableSet.add(6)
    mutableSet.remove(3)

    println("Modified Mutable Set: $mutableSet")

    // Immutable Set
    val immutableSet = setOf(1, 2, 3, 4, 5)
    println("Immutable Set: $immutableSet")
}
