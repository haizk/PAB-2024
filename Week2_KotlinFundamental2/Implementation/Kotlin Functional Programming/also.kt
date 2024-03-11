fun main() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)
    
    val result = numbers.also {
        it.add(6)
        println("List after adding element: $it")
    }

    println("Original list: $numbers")
    println("Result: $result")
}
