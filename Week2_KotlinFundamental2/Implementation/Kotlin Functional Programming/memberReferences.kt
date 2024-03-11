fun add(a: Int, b: Int): Int = a+b

val sum: (Int, Int) -> Int = ::add

fun main(){
    println(sum(3,4))
}