class Student(val name: String, val nim: String)

data class Mahasiswa(val name: String, val nim: String)

fun main(){
    val student = Student("Rui", "M0522007")
    val mahasiswa = Mahasiswa("Rui", "M0522007")
    val mahasiswa2 = Mahasiswa("Rui", "M0522007")
    val mahasiswa3 = Mahasiswa("Atya", "M0521003")

    println(student)
    println(mahasiswa)
    println(mahasiswa.equals(mahasiswa2))
    println(mahasiswa.equals(mahasiswa3))
    println(mahasiswa.copy(name = "Kio"))
    println(mahasiswa.copy(name = "Rhode", nim = "M0511065"))
}

