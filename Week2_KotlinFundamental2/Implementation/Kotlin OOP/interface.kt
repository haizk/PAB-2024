interface Shape {
    val area: Double
    
    fun calculateArea(): Double
}

// Kelas Circle yang mewarisi dari interface Shape
class Circle(val radius: Double) : Shape {
    // Implementasi properti area dari interface Shape
    override val area: Double
        get() = Math.PI * radius * radius
    
    // Implementasi metode calculateArea dari interface Shape
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

fun main() {
    val circle = Circle(5.0)
    println("Area of the circle: ${circle.calculateArea()}")

}
