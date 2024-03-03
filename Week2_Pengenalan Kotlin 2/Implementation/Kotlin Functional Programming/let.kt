fun main(){

    val nim: String? = null
    nim?.let { 
        val length = it.length * 2
        val text = "nim length is $length"
        println(text)
    } ?: run{
        val text = "nim is null"
        println(text)
    }

    // Tanpa menggunakan fungsi let

    val length = nim?.length ?: 0 * 2
    val text = "nim length is $length"
    println(text)

}