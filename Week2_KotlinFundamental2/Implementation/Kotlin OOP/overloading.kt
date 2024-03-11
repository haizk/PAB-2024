class MathOperations {
    // Fungsi untuk menjumlahkan dua bilangan bulat
    fun jumlah(a: Int, b: Int): Int {
        return a + b
    }

    // Overloaded function to add three integers
    // Fungsi overload untuk menjumlahkan tiga bilangan bulat
    fun jumlah(a: Int, b: Int, c: Int): Int {
        return a + b + c
    }

    // Overloaded function to add two doubles
    // Fungsi overload untuk menjumlahkan dua bilangan double
    fun jumlah(a: Double, b: Double): Double {
        return a + b
    }
}

fun main() {
    val operasi = MathOperations()

    // Memanggil fungsi jumlah dengan dua argumen integer
    val hasil1 = operasi.jumlah(5, 3)
    println("Hasil penjumlahan dari dua bilangan integer: $hasil1")

    // Memanggil fungsi jumlah dengan tiga argumen integer
    val hasil2 = operasi.jumlah(2, 4, 6)
    println("Hasil penjumlahan dari tiga bilangan integer: $hasil2")

    // Memanggil fungsi jumlah dengan dua argumen double
    val hasil3 = operasi.jumlah(2.5, 3.5)
    println("Hasil penjumlahan dari dua bilangan double: $hasil3")
}
