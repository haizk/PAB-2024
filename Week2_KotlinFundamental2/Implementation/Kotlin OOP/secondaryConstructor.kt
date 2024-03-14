class Book(name: String, year: Int){

    var name: String
    var year: Int
    var isSelfPublished: Boolean

    init {
        this.name = name
        this.year = if(year < 0) 2021 else year
        this.isSelfPublished = false
    }

    constructor(name: String, year: Int, isSelfPublished: Boolean) : this(name, year) {
        this.isSelfPublished = isSelfPublished
    }

}

fun main() {

    var book1 = Book(name = "Kotlin Programming", year = 2020)
    var book2 = Book(name = "Android Development", year = 2022, isSelfPublished = true)

    println("Book 1 : ${book1.name} - ${book1.year} - ${book1.isSelfPublished}")
    println("Book 2 : ${book2.name} - ${book2.year} - ${book2.isSelfPublished}")

}