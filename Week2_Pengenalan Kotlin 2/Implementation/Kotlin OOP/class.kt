class Animal(){

    var name = "Kio"

    fun eat(){
        println("$name is Eating!")
    }

    fun sleep(){
        println("Sleepy...zzz")
    }

}

fun main(){

    var cat = Animal()

    cat.eat()
    cat.sleep()

}