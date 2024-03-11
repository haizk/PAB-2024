class Cat(name: String){

    var name = name
        get() {
            println("Fungsi Getter")
            return field
        }
        set(value) {
            println("Fungsi Setter")
            field = value
        }

    fun eat(){
        println("$name is Eating!")
    }

    fun sleep(){
        println("Sleepy...zzz")
    }

}

fun main(){

    var cat = Cat("Kio")

    cat.name
    cat.eat()
    cat.sleep()

}