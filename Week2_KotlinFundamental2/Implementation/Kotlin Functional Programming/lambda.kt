// Lambda expression 
val morning = { println("Good Morning!") }

// Lambda expression with parameter
val printMsg = { msg: String -> println(msg) }

// Lambda expression with return value
val add = { a: Int, b: Int -> println(a + b) }

fun main(){
    morning()
    printMsg("Hello Future!")
    add(1,2)

    var ranges = 1..7 step 2

    // Perulangan Lambda (forEach)
    ranges.forEach{ print("$it ") }
    println()

    // Perulangan Lambda (forEachIndexed)
    ranges.forEachIndexed { idx, num -> 
        print("$idx - $num  ") 
    }
    println()

}