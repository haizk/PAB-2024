class Number {
    private var angkaPrivate: Int = 10 // Variabel dengan hak akses private
    var angkaPublic: Int = 20 // Variabel dengan hak akses public
    protected var angkaProtected: Int = 30 // Variabel dengan hak akses protected
    internal var angkaInternal: Int = 40 // Variabel dengan hak akses internal

    // Fungsi untuk menampilkan nilai
    fun tampilkanNilai() {
        println("Nilai angkaPrivate (private): $angkaPrivate")
        println("Nilai angkaPublic (public): $angkaPublic")
        println("Nilai angkaProtected (protected): $angkaProtected")
        println("Nilai angkaInternal (internal): $angkaInternal")
    }
}

fun main() {
    val contoh = Number()

    // Kita bisa mengakses angkaPublic dan angkaInternal dari luar kelas
    println("Dari luar kelas:")
    println("Nilai angkaPublic (public): ${contoh.angkaPublic}")
    // println("Nilai angkaPrivate (private): ${contoh.angkaPrivate}") // Ini akan menghasilkan error karena angkaPrivate adalah private
    // println("Nilai angkaProtected (protected): ${contoh.angkaProtected}") // Ini akan menghasilkan error karena angkaProtected tidak dapat diakses secara langsung dari luar kelas
    println("Nilai angkaInternal (internal): ${contoh.angkaInternal}")

    // Kita juga bisa memanggil method yang menggunakan angkaPrivate, angkaPublic, angkaProtected, dan angkaInternal di dalamnya
    println("\nMemanggil method tampilkanNilai() dari luar kelas:")
    contoh.tampilkanNilai()
}
