fun main(){
    var condition = 0

    when(condition){
        1 -> println("True")
        0 -> {
            println("False")
            condition += 1
            println(condition)
        }
        else -> println("Unknown")
    }
}