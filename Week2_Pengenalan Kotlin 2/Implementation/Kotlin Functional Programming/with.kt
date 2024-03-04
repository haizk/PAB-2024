fun main() {
    val text = "Hello, Kotlin!"

    val result = with(text) {
        println("Original text: $this")
        val modifiedText = this.replace("Kotlin", "World")
        println("Modified text: $modifiedText")
        "Modified text length: ${modifiedText.length}"
    }

    println(result)
}