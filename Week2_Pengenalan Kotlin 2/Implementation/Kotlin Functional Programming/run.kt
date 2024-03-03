fun main() {
    val sentence = "I love programming"
    val result = sentence.run {
        val original = this
        val length = this.length
        "Length of text $original is $length"
    }
    println("Result: $result")
}
