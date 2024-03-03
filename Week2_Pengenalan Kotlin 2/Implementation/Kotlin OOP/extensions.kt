// Extension function untuk mengonversi Double menjadi Rupiah
fun Int.dollarToRupiah(): String {
    val rupiah = this * 15700
    return "Rp.$rupiah"
}

// Extension property untuk menghitung panjang string
val String.lengthWithSpaces: Int
    get() = this.length + this.count { it == ' ' }

fun main() {
    val price = 15
    println("Harga dalam Rupiah: ${price.dollarToRupiah()}") 

    val text = "Hello World"
    println("Panjang string termasuk spasi: ${text.lengthWithSpaces}")
}
