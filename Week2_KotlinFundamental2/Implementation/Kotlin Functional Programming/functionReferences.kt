fun length(name: String): Int {
    return name.length
}

fun String.clength(): Int = this.length

fun main() {
    val names = listOf("John", "Alice", "Bob", "Charlie")

    // Function references
    val sortedNames = names.sortedBy(::length) 

    // Extension Function references
    val sortedNamesDesc = names.sortedByDescending(String::clength)

    println(sortedNames)
    println(sortedNamesDesc)
}