// diberi "open" agar dapat dilakukan inheritance/pewarisan
open class Fish(){

    var name = "Kio"

    open fun eat(){
        println("$name is Eating!")
    }

    open fun sleep(){
        println("Sleepy...zzz")
    }

}

class Shark(name: String) : Fish() {

    init {
        super.name = name
    }

    override fun eat(){
        println("Yumm... $name is eating lots of fishes")
    }

    override fun sleep(){
        println("$name is sleeping underwater...")
    }

    fun swim(){
        println("$name is exploring the sea!!")
    }

}

fun main() {
    val shark = Shark("Rhoa")
    shark.eat()  
    shark.sleep()  
    shark.swim()
}