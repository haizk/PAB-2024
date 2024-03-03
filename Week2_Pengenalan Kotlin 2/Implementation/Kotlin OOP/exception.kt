fun divide(a: Int, b: Int): Int {
    return a / b
}

fun main() {
    try {
        val result = divide(10, 0)
        println("Hasil pembagian: $result") // Baris ini tidak akan pernah dijalankan
    } catch (e: ArithmeticException) {
        println("Terjadi kesalahan: ${e.message}") // Menampilkan pesan kesalahan
    } finally {
        println("Proses selesai") // Selalu dijalankan, terlepas dari exception atau tidak
    }
}
