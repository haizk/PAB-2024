// Membuat fungsi ekstensi generik untuk List yang mengambil elemen pada indeks yang diberikan
fun <T> List<T>.getElementAt(indices: Iterable<Int>): List<T> {
    val result = mutableListOf<T>() // Membuat list untung menyimpan hasil
    // Melakukan iterasi terhadap semua index dalam List
    for (index in indices) {
        // Mengecek apakah index berada dalam range index List
        if (index in 0 until size) { 
            result.add(this[index]) // Memasukkan nilai pada index yang diminta
        }
    }
    return result
}

fun main() {
    val numbers = listOf(10, 20, 30, 40, 50)

    // Mengambil elemen di indeks 1 dan 3
    val result = numbers.getElementAt(listOf(1, 3))

    println("Selected elements: $result") 
}
