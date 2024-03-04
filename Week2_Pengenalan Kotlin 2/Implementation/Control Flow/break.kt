fun main(){

    var myInt = 1..5 step 2

    print("myInt : ")
    for(num in myInt){
        if(num == 3) break
        print("$num ")
    }
    println()

}