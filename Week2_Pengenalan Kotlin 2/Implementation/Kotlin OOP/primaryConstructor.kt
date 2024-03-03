class Movie(genre: String = "Action", duration: Int){

    val genre: String
    val duration: Int

    init {
        this.genre = genre
        this.duration = if(duration < 0) 0 else duration
    }

}

fun main(){

    val mov = Movie(duration = -1)

    println("${mov.genre} - ${mov.duration} hour(s)")

}