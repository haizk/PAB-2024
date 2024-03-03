# Pengenalan Kotlin 2

Pada pertemuan kali ini, kita akan mempelajari beberapa konsep penting dalam pemrograman menggunakan bahasa Kotlin, diantaranya :

1. Control Flow
2. Kotlin Object-Oriented Programming
3. Special Class & Collections
4. Kotlin Functional Programming
5. Kotlin Generics
6. Coroutines

Cakupan masing-masing sub-materi cukup luas, sehingga terdapat beberapa konsep yang mungkin belum terdapat pada pembahasan ini. Untuk itu, kalian bisa belajar mandiri melalui link yang terlampir :)

<br/>
<br/>

## 1. Control Flow

Dalam melakukan pemrograman, kita perlu tau **alur** dari sebuah program yang kita buat, maka dari itu diperlukan adanya Control Flow. Control Flow merupakan sebuah cara seorang pemrogram **mengatur alur dari sebuah program berdasarkan kondisi yang terjadi** saat program tersebut berjalan. Terdapat berbagai macam Control Flow, yaitu :

- When Expression
- While & Do-While Expression
- Range & For Loop 
- Break & Continue

### When Expression
**When Expression** merupakan bentuk lain dari If Expression, dimana kita dapat **mengubah alur program melalui nilai** dari sebuah variabel/_expression_.

```kotlin
fun main(){
    var condition = 0;

    when(condition){
        1 -> println("True")
        0 -> {
            println("False")
            condition += 1
            println(condition)
        }
        else -> println("Unknown")
    }
}

// Output
// False
// 1
```

### While & Do-While Expression
While & Do-While merupakan sebuah bentuk ekspresi perulangan. Kedua _expression_ tersebut akan menjalankan blok kode yang sama berulang kali hingga kondisi sudah tidak terpenuhi atau menunjukkan nilai _false_.

#### While

Dalam perulangan While, pengecekan dilakukan terlebih dahulu baru blok kode dalam ekspresi _while_ dijalankan. 

```kotlin
fun main(){

    var num = 6

    while(num <= 5){
        println("Kotlin is fun!!")
        num++
    }

}

// Output : (Kosong)
```

#### Do-While

Dalam perulangan Do-While, blok kode dalam ekspresi _do-while_ dijalankan terlebih dahulu baru pengecekan dilakukan. 

```kotlin
fun main(){

    var num = 6

    do {
        println("Kotlin is fun!!")
        num++
    }
    while(num <= 5)

}

// Output
// Kotlin is fun!!
```

### Range 
Range digunakan untuk membuat sebuah variabel yang berisikan deretan angka tertentu. Penggunaan Range pada Kotlin mirip dengan penggunaan Range pada GNU Octave/Matlab.

```kotlin
fun main(){

    var myInt = 1..5            // 1 2 3 4 5
    var myInt_2 = 1..5 step 2   // 1 3 5
    var myInt_3 = 1.rangeTo(7)  // 1 2 3 4 5 6 7

}
```

### For Loop

For loop pada Kotlin dapat dilakukan dengan beberapa cara, yaitu for loop biasa, for loop dengan menampilkan index, dan for loop dengan menggunakan foreach. Foreach merupakan bentuk dari Lambda Expression yang akan dibahas pada materi selanjutnya. 

```kotlin
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

// Output 
// myInt : 1 2 3 4 5 
// myInt_2 : 1 - 0  3 - 1  5 - 2
// myInt_3 : 1 2 3 4 5 6 7
```

### Break 
Perintah _break_ digunakan untuk keluar dari perulangan jika suatu kondisi terpenuhi. Perintah ini sangat berguna ketika kita ingin melakukan pengecekan suatu kondisi yang berakibat pada berhentinya looping dan lanjut ke blok kode berikutnya.

```kotlin
fun main(){

    var myInt = 1..5 step 2

    print("myInt : ")
    for(num in myInt){
        if(num == 3) break
        print("$num ")
    }
    println()

}

// Output
// myInt : 1 
```

### Continue

Perintah _continue_ digunakan untuk melewatkan proses iterasi pada perulangan jika suatu kondisi terpenuhi dan berlanjut ke iterasi selanjutnya. 

```kotlin
fun main(){

    var myInt = 1..5 step 2

    print("myInt : ")
    for(num in myInt){
        if(num == 3) continue
        print("$num ")
    }
    println()

}

// Output 
// myInt : 1 5 
```

<br/>

## 2. Kotlin OOP (Object-Oriented Programming)

Sebagai hasil pengembangan bahasa dari Java, Kotlin memberi dukungan luas dalam pengembangan program berorientasi objek atau _object-oriented programming_ (OOP).  Beberapa hal yang akan kita pelajari pada materi Kotlin OOP ini yaitu : 

- Class
- Properties
- Lateinit & Lazy Property
- [Property Delegation](https://kotlinlang.org/docs/delegated-properties.html)
- Primary Constructor
- Secondary Constructor
- Visibility Modifiers
- Overloading
- Inheritances
- Abstract Class
- Interfaces
- Extensions
- Exception

Note : Untuk sub-materi yang diberi link tidak akan dijelaskan pada materi ini sehingga dapat dipelajari secara mandiri melalui link yang telah dilampirkan :)

### Class
Pendeklarasian _class_ pada Kotlin kurang lebih sama dengan pendeklarasian _class_ pada Java.

#### Pendeklarasian Class
```kotlin
class Animal(){

    var name = "Kio"

    fun eat(){
        println("$name is Eating!")
    }

    fun sleep(){
        println("Sleepy...zzz")
    }

}
```

#### Pemanggilan Class

```kotlin
fun main(){

    var cat = Animal()

    cat.eat()
    cat.sleep()

}

// Output 
// Kio is Eating!
// Sleepy...zzz

```

### Properties

Properti merupakan suatu hal yang pasti dimiliki oleh sebuah kelas dalam Kotlin. Pada kelas sebelumnya terdapat properti _name_. Properti merupakan sebuah variabel, dimana sebuah variabel dapat bernilai **_mutable_ (var)** atau **_read-only_ (val)**.

Pada dasarnya, sebuah variabel yang bernilai _mutable_ pada Kotlin akan memiliki fungsi _setter_ dan _getter_. Sedangkan variabel yang bernilai _read-only_ hanya akan memiliki fungsi _getter_. Namun, kita dapat melakukan _overrride_ kedua fungsi tersebut untuk dapat membuatnya secara manual.

```kotlin
class Cat(name: String){

    var name = name
        get() {
            println("Fungsi Getter")
            return field
        }
        set(value) {
            println("Fungsi Setter")
            field = value
        }

    fun eat(){
        println("$name is Eating!")
    }

    fun sleep(){
        println("Sleepy...zzz")
    }

}

fun main(){

    var cat = Cat("Kio")

    cat.name
    cat.eat()
    cat.sleep()

}

// Output 
// Fungsi Getter
// Fungsi Getter
// Kio is Eating!
// Sleepy...zzz
```

### Lateinit & Lazy Property

Lateinit dan Lazy Property digunakan ketika kita tidak ingin menginialisasi nilai sebuah variabel secara langsung. **Nilai variabel hanya akan diinialisasi ketika variabel tersebut dibutuhkan** dalam program kita. Hal ini digunakan ketika terjadi sebuah kondisi dimana nilai dari suatu variabel baru akan diinialisasi setelah mendapatkan data dari constructor atau karena kita perlu memakai variabel tersebut di fungsi lain atau yang biasa disebut dengan global variable.

#### Lateinit Property

Lateinit property hanya bisa digunakan ketika disandingkan dengan **var**. Jika variabel akan digunaknan, variabel harus diinialisasi terlebih dahulu atau akan menyebabkan error. 

```
lateinit property [property name] has not been initialized
```

Contoh penggunaan _lateinit property_
```kotlin
lateinit var nim: String

fun main(){

    nim = "M0521062"

    println(nim)

}

// Output
// M0521062
```

Kita juga dapat melakukan pengecekan apakah variabel sudah terinisialisasi ataukah belum seperti pada kode di bawah ini :

```kotlin
    if(::nim.isInitialized){
        println(nim)
    }
    else {
        println("Not initialized.")
    }
```

#### Lazy Property

Berkebalikan dengan _lateinit_, penggunaan _lazy property_ harus disandingkan dengan **val**. Hal ini dikarenakan _lazy property_ hanya dapat diinialisasi sebanyak 1 kali.

```kotlin
val angkatan : String by lazy { 
    "2022"
}

fun main(){

    println(angkatan)

}

// Output
// 2022
```

### Primary Constructor

Penulisan _primary constructor_ mirip dengan penulisan parameter pada fungsi. 

```kotlin
class Movie(genre: String)
```

Sama seperti parameter pada fungsi, _primary constructor_ juga dapat memiliki nilai default.

```kotlin
class Movie(genre: String = "Action")
```

#### **Init Block**

Dalam Kotlin, terdapat _**init** block_ yang memungkinkan kita untuk menuliskan _property_ dalam _body class_ ketika kita menginialisasi kelas tersebut. Blok **init** juga memiliki fungsi lain, yaitu membantu kita melakukan **validasi** nilai terhadap properti tersebut sebelum diinialisasi.

```kotlin
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

// Output
// Action - 0 hour(s)
```

### Secondary Constructor

Secondary constructor digunakan ketika kita ingin menginialisasi sebuah kelas dengan cara yang berbeda. Sebuah kelas dapat memiliki **lebih dari satu** _secondary constructor_. 

```kotlin
class Book(name: String, year: Int){

    var name: String
    var year: Int
    var isSelfPublished: Boolean

    init {
        this.name = name
        this.year = if(year < 0) 2021 else year
        this.isSelfPublished = false
    }

    constructor(name: String, year: Int, isSelfPublished: Boolean) : this(name, year) {
        this.isSelfPublished = isSelfPublished
    }

}

fun main() {

    var book1 = Book(name = "Kotlin Programming", year = 2020)
    var book2 = Book(name = "Android Development", year = 2022, isSelfPublished = true)

    println("Book 1 : ${book1.name} - ${book1.year} - ${book1.isSelfPublished}")
    println("Book 2 : ${book2.name} - ${book2.year} - ${book2.isSelfPublished}")

}

// Output
// Book 1 : Kotlin Programming - 2020 - false
// Book 2 : Android Development - 2022 - true
```

Jika kita tidak membuat sebuah _constructor_ secara manual, maka Kotlin akan secara otomatis membuat sebuah **_default constructor_** pada kelas tersebut.

### Visibility Modifiers


### Overloading


### Inheritances


### Abstract Class


### Interfaces


### Extensions


### Exception

<br/>

## 3. Special Class


<br/>

## 4. Collections


<br/>

## 5. Kotlin Functional Programming


<br/>

## 6. Kotlin Generics


<br/>

## 7. Coroutines


<br/>
