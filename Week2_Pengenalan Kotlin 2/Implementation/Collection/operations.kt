data class Person(val name: String, val age: Int)

fun main() {
    // filter()
    val numbers = listOf(1, 2, 3, 4, 5)
    val evenNumbers = numbers.filter { it % 2 == 0 } 
    println("Even numbers: $evenNumbers")
    // Output : Even numbers: [2, 4]

    // filterNot()
    val oddNumbers = numbers.filterNot { it % 2 == 0 } 
    println("Odd numbers: $oddNumbers")
    // Output : Odd numbers: [1, 3, 5]

    // map()
    val squaredNumbers = numbers.map { it * it } 
    println("Squared numbers: $squaredNumbers")
    // Output : Squared numbers: [1, 4, 9, 16, 25]

    // count()
    val countOfNumbers = numbers.count() 
    println("Count of numbers: $countOfNumbers")
    // Output : Count of numbers: 5

    // find()
    val firstEvenNumber = numbers.find { it % 2 == 0 } 
    println("First even number: $firstEvenNumber")
    // Output : First even number: 2

    // firstOrNull()
    val firstNumber = numbers.firstOrNull() 
    println("First number: $firstNumber")
    // Output : First number: 1

    // lastOrNull()
    val lastNumber = numbers.lastOrNull() 
    println("Last number: $lastNumber")
    // Output : Last number: 5

    // first()
    val firstElement = numbers.first() 
    println("First element: $firstElement")
    // Output : First element: 1

    // last()
    val lastElement = numbers.last() 
    println("Last element: $lastElement")
    // Output : Last element: 5

    // sum()
    val total = numbers.sum() 
    println("Total sum: $total")
    // Output : Total sum: 15

    // sorted()
    val sortedNumbers = numbers.sorted() 
    println("Sorted numbers: $sortedNumbers")
    // Output : Sorted numbers: [1, 2, 3, 4, 5]

    // fold()
    val numbersToSum = listOf(1, 2, 3, 4, 5)
    val sum = numbersToSum.fold(0) { acc, num -> acc + num } 
    println("Sum of numbers: $sum")
    // Output : Sum of numbers: 15

    // foldRight()
    val sumRight = numbersToSum.foldRight(0) { num, acc -> acc + num } 
    println("Sum of numbers (foldRight): $sumRight")
    // Output : Sum of numbers (foldRight): 15

    // drop()
    val numbersToDrop = listOf(1, 2, 3, 4, 5)
    val remainingNumbers = numbersToDrop.drop(3) 
    println("Remaining numbers after drop: $remainingNumbers")
    // Output : Remaining numbers after drop: [4, 5]

    // dropLast()
    val remainingNumbersLast = numbersToDrop.dropLast(2) 
    println("Remaining numbers after dropLast: $remainingNumbersLast")
    // Output : Remaining numbers after dropLast: [1, 2, 3]

    // slice()
    val slicedNumbers = numbersToDrop.slice(listOf(1, 3, 4))
    println("Sliced numbers: $slicedNumbers")
    // Output : Sliced numbers: [2, 4, 5]

    // distinct()
    val duplicateNumbers = listOf(1, 2, 3, 1, 4, 2, 5)
    val uniqueNumbers = duplicateNumbers.distinct() 
    println("Unique numbers: $uniqueNumbers")
    // Output : Unique numbers: [1, 2, 3, 4, 5]

    // distinctBy()
    val people = listOf(Person("Alice", 30), Person("Bob", 25), Person("Alice", 30))
    val uniquePeople = people.distinctBy { it.name } 
    println("Unique people: $uniquePeople")
    // Output : Unique people: [Person(name=Alice, age=30), Person(name=Bob, age=25)]

    // chunked()
    val numbersToChunk = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val chunkedNumbers = numbersToChunk.chunked(3) 
    println("Chunked numbers: $chunkedNumbers")
    // Output : Chunked numbers: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
}
