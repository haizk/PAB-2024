lateinit var nim: String

fun main(){

    nim = "M0521062"

    println(nim)

    // cek inialisasi variabel
    if(::nim.isInitialized){
        println(nim)
    }
    else {
        println("Not initialized.")
    }

}