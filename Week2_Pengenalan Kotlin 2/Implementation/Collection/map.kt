fun main() {
    // Mutable Map
    val mutableMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
    println("Mutable Map: $mutableMap")

    mutableMap["four"] = 4
    mutableMap.remove("two")
    mutableMap["three"] = 30

    println("Modified Mutable Map: $mutableMap")

    // Immutable Map
    val immutableMap = mapOf("one" to 1, "two" to 2, "three" to 3)
    println("Immutable Map: $immutableMap")
}
