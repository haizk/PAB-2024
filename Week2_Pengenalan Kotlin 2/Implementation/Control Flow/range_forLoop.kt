fun main(){

    var myInt = 1..5
    var myInt_2 = 1..5 step 2
    var myInt_3 = 1.rangeTo(7)

    // for loop menggunakan ranges
    print("myInt : ")
    for(num in myInt){
        print("$num ")
    }
    println()

    // for loop menggunakan withIndex()
    print("myInt_2 : ")
    for((idx, num) in myInt_2.withIndex()){
        print("$num - $idx  ")
    }
    println()

    // for loop menggunakan foreach
    print("myInt_3 : ")
    myInt_3.forEach { num -> 
        print("$num ")
    }
    println()

}