fun main() {
    // Mutable List
    val mutableList = mutableListOf(1, 2, 3, 4, 5)
    println("Mutable List: $mutableList")

    mutableList.add(6)
    mutableList.removeAt(1)
    mutableList[2] = 10

    println("Modified Mutable List: $mutableList")

    // Immutable List
    val immutableList = listOf(1, 2, 3, 4, 5)
    println("Immutable List: $immutableList")
}
