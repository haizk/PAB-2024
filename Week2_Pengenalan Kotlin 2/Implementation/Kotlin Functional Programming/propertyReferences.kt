var num1 = 4
val num2 = 7

fun main(){

    println(::num1.get())
    println(::num1.name)

    ::num1.set(5)
    
    println(::num2.get())
    println(::num2.name)

    // Akan menampilkan error
    // ::num2.set(5)

}