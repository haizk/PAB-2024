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

Properti merupakan suatu hal yang pasti dimiliki oleh sebuah kelas dalam Kotlin. Pada kelas sebelumnya terdapat properti _name_. Properti merupakan sebuah variabel, dimana sebuah variabel dapat bernilai **_mutable_ (`var`)** atau **_read-only_ (`val`)**.

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

Lateinit property hanya bisa digunakan ketika disandingkan dengan **`var`**. Jika variabel akan digunaknan, variabel harus diinialisasi terlebih dahulu atau akan menyebabkan error. 

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

Berkebalikan dengan _lateinit_, penggunaan _lazy property_ harus disandingkan dengan **`val`**. Hal ini dikarenakan _lazy property_ hanya dapat diinialisasi sebanyak 1 kali.

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

Dalam Kotlin, terdapat **`init`** _block_ yang memungkinkan kita untuk menuliskan _property_ dalam _body class_ ketika kita menginialisasi kelas tersebut. Blok **`init`** juga memiliki fungsi lain, yaitu membantu kita melakukan **validasi** nilai terhadap properti tersebut sebelum diinialisasi.

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
Hak akses suatu properti dalam Kotlin dapat kita tentukan sesuai sesuai kebutuhan. Dengan menentukan hak akses pada sebuah kelas, akses data dapat kita batasi. Dengan menentukan hak akses atau _visibility modifiers_, kita telah menerapkan salah satu pilar dalam OOP yaitu **_encapsulation_**  

Terdapat berbagai macam hak akses pada kotlin, yaitu 
- Public    : Dapat diakses dari **kelas manapun**.
- Private   : Hanya dapat diakses oleh properti pada **_scope_ yang sama**.
- Protected : Hanya dapat diakses oleh properti pada **kelas turunannya atau kelas itu sendiri**.
- Internal  : Hanya dapat diakses oleh properti yang **berada pada modul yang sama (satu modul)**.

```kotlin
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

// Output
// Dari luar kelas:
// Nilai angkaPublic (public): 20
// Nilai angkaInternal (internal): 40

// Memanggil method tampilkanNilai() dari luar kelas:
// Nilai angkaPrivate (private): 10
// Nilai angkaPublic (public): 20
// Nilai angkaProtected (protected): 30
// Nilai angkaInternal (internal): 40
```

### Overloading
Overloading merupakan penerapan dari salah satu pilar OOP yaitu _**polymorphism**_. Dengan overloading, kita dapat mendefinisikan **beberapa fungsi atau _constructor_ dengan nama yang sama pada satu kelas, tetapi dengan parameter yang berbeda**. Hal ini memungkinkan kita untuk beberapa versi dari fungsi yang melakukan tugas yang sama tetapi dengan jenis atau jumlah argumen yang berbeda.

Konsep overloading ini sangat berguna atau _powerful_ dalam pembuatan program kalkulator.

```kotlin
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

// Output
// Hasil penjumlahan dari dua bilangan integer: 8
// Hasil penjumlahan dari tiga bilangan integer: 12
// Hasil penjumlahan dari dua bilangan double: 6.0
```

### Inheritances
Inheritance atau pewarisan adalah salah satu pilar yang ada dalam 4 pilar OOP. Dengan menerapkan _inheritance_, kita dapat menghemat kode dan meminimalisir terjadinya _boilerplate_ pada kode yang kita buat.

```kotlin
// diberi "open" agar dapat dilakukan inheritance/pewarisan
open class Fish(){

    var name = "Kio"

    open fun eat(){
        println("$name is Eating!")
    }

    open fun sleep(){
        println("Sleepy...zzz")
    }

}

class Shark(name: String) : Fish() {

    init {
        super.name = name
    }

    override fun eat(){
        println("Yumm... $name is eating lots of fishes")
    }

    override fun sleep(){
        println("$name is sleeping underwater...")
    }

    fun swim(){
        println("$name is exploring the sea!!")
    }

}

fun main() {
    val shark = Shark("Rhoa")
    shark.eat()  
    shark.sleep()  
    shark.swim()
}

//  Output
// Yumm... Rhoa is eating lots of fishes
// Rhoa is sleeping underwater...
// Rhoa is exploring the sea!!
```

#### Overriding
Overriding adalah konsep dalam pemrograman berorientasi objek di mana kelas turunan (_subclass_) dapat **mengganti implementasi metode yang sama** dari kelas dasar (_superclass_). Dalam Kotlin, Anda menggunakan kata kunci **`override`** sebelum metode yang ingin Anda ganti. Ini memungkinkan kelas turunan menyediakan perilaku khusus yang sesuai dengan kebutuhan kelas tersebut. Penting untuk memperhatikan bahwa nama, tipe, dan parameter metode harus cocok persis dengan metode yang ingin dioverride di kelas dasar.

```kotlin
override fun eat(){
    println("Yumm... $name is eating lots of fishes")
}
```

### Abstract Class
Abstract class adalah sebuah kelas yang **tidak dapat diinstansiasi secara langsung** dan dapat memiliki metode abstrak (_abstract method_). Metode abstrak adalah metode yang tidak memiliki implementasi di dalam kelas abstrak, tetapi harus diimplementasikan oleh kelas turunannya (_subclass_). Abstraksi digunakan ketika kita ingin memiliki kelas dasar yang menyediakan kerangka kerja umum, tetapi membiarkan detail implementasi khusus ditentukan oleh kelas turunannya.

```kotlin
abstract class Vehicle {
    abstract fun start()

    abstract fun stop()

    fun accelerate() {
        println("Accelerating...")
    }
}

class Motorcycle : Vehicle() {
    override fun start() {
        println("Motorcycle started")
    }

    override fun stop() {
        println("Motorcycle stopped")
    }
}

fun main() {

    val motorcycle = Motorcycle()
    motorcycle.start() 
    motorcycle.accelerate() 
    motorcycle.stop() 
}

// Output
// Motorcycle started
// Accelerating...
// Motorcycle stopped
```

### Interfaces
Interface adalah konsep mengenai sifat umum yang akan digunakan oleh suatu kelas untuk memiliki sifat tersebut. Interface sangat mirip dengan _abstract class_, namun tanpa sebuah properti deklarasi dan fungsi yang dideklarasikan tanpa isi. Interface bertujuan untuk diimplementasikan oleh sebuah kelas. Pengimplementasian _interface_ pada sebuah kelas **harus meng-_override_ seluruh properti dan fungsi** sekaligus memberikan definisi terhadap isi fungsi yang terdapat dalam _interface_ tersebut.

```kotlin
interface Shape {
    val area: Double
    
    fun calculateArea(): Double
}

// Kelas Circle yang mewarisi dari interface Shape
class Circle(val radius: Double) : Shape {
    // Implementasi properti area dari interface Shape
    override val area: Double
        get() = Math.PI * radius * radius
    
    // Implementasi metode calculateArea dari interface Shape
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

fun main() {
    val circle = Circle(5.0)
    println("Area of the circle: ${circle.calculateArea()}")

}

// Output
// Area of the circle: 78.53981633974483
```

### Extensions

Pada Kotlin, kita dimungkinkan untuk menambahkan fungsi baru pada sebuah kelas tanpa harus mewarisi kelas tersebut. Terdapat 2 jenis _extensions_ yang didukung oleh Kotlin, yaitu **Extension Function** dan **Extension Properties**.

#### Extension Function
Extension function berfungsi untuk **menambahkan fungsi baru**. Extension Function dideklarasikan dengan menentukan terlebih dahulu _receiver type_, kemudian nama fungsi yang dipisahkan oleh tanda titik (.). 

```kotlin
fun Int.dollarToRupiah(): String {
    val rupiah = this * 15700
    return "Rp.$rupiah"
}

fun main() {
    val price = 15
    println("Harga dalam Rupiah: ${price.dollarToRupiah()}") 
}

// Output
// Harga dalam Rupiah: Rp.235500
```

#### Extension Property
Selain menambah fungsi baru, Kotlin juga mendukung extension untuk menambah sebuah properti baru pada sebuah kelas tanpa harus menyentuh kode di dalam kelas tersebut. Cara pendeklarasiannya pun sama seperti _extension function_, kita perlu menentukan terlebih dahulu _receiver type_, kemudian nama properti yang dipisahkan oleh tanda titik (.). 

```kotlin
val String.lengthWithSpaces: Int
    get() = this.length + this.count { it == ' ' }

fun main() { 
    val text = "Hello World"
    println("Panjang string termasuk spasi: ${text.lengthWithSpaces}")
}

// Output
// Panjang string termasuk spasi: 12
```

### Exception

Exception adalah suatu kondisi abnormal atau kejadian yang tidak diharapkan yang terjadi saat program sedang berjalan. Ketika exception terjadi, program biasanya akan berhenti atau mengalami gangguan jika tidak ditangani dengan benar. Penanganan exception memungkinkan program untuk merespons dengan baik terhadap kesalahan dan melanjutkan eksekusi program dengan normal.

Dalam Kotlin, exception diwakili oleh kelas-kelas yang mewarisi dari kelas _Throwable_, baik itu kelas bawaan seperti _Exception_, _RuntimeException_, atau kelas buatan pengguna. Kotlin menggunakan blok `try`, `catch`, dan `finally` untuk menangani exception.

```kotlin
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

// Output
// Terjadi kesalahan: / by zero
// Proses selesai
```

<br/>

## 3. Special Class

Special Class adalah yang memiliki fitur atau **karakteristik tertentu** yang tidak tersedia di _class_ biasa (reguler). 

Beberapa _special class_ dalam Kotlin telah kita pelajari sebelumnya, yaitu Abstract Class dan Interface. Selain itu, terdapat berbagai macam _special class_ lain, yaitu :
- Data Class    : Class yang digunakan untuk menyimpan data.
- [Nested Class](https://kotlinlang.org/docs/nested-classes.html)   : membuat Class di dalam Class tanpa akses ke kelas induk.
- [Inner Class](https://kotlinlang.org/docs/nested-classes.html#inner-classes) : membuat Class di dalam Class dengan akses ke kelas induk.
- Enum Class : tipe data dengan sekumpulan nilai konstan yang telah ditentukan.
- [Sealed Class](https://kotlinlang.org/docs/sealed-classes.html) : digunakan untuk pembatasan hierarki class.

### Data Class

Kotlin memperkenalkan konsep **data class**, sebuah kelas sederhana yang dapat berfungsi sebagai **data container**. Kelas ini tidak memiliki logika dan tidak memiliki fitur selain menangani data. Berbeda dengan kelas biasanya, _data class_ tidak membutuhkan banyak kode untuk mengelola sebuah data.

```kotlin
data class Mahasiswa(val nama: String, val nim: String)
```

Kompiler akan secara otomatis menghasilkan `constructor`, `toString()`, `equals()`, `hashCode()`, `copy()`, dan fungsi `componentN` hanya dengan satu baris kode di atas. Hal ini membuat kode kita lebih bersih dan lebih mudah dibanding ketika kita menuliskan kode secara manual. 

Terdapat beberapa hal yang perlu diperhatikan ketika membuat sebuah data class, yaitu : 
- Konstruktor utama pada kelas tersebut **harus memiliki setidaknya satu parameter**.
- Semua konstruktor utama **perlu dideklarasikan** sebagai `val` atau `var`;
- Sebuah data class **tidak dapat memiliki _modifier_** berupa `abstract`, `open`, `sealed`, atau `inner`.

#### **toString()** pada Data Class

Misalkan kita memiliki dua buah _class_, satu _class_ biasa dan 1 _data class_.

```kotlin
class Student(val name: String, val nim: String)

data class Mahasiswa(val name: String, val nim: String)
```

Kita akan mencoba menampilkan kedua objek yang dibuat dari kedua _class_ tersebut dengan menggunakan `println`.

```kotlin
fun main(){
    val student = Student("Rui", "M0522007")
    val mahasiswa = Mahasiswa("Rui", "M0522007")

    println(student)
    println(mahasiswa)
}

// Output
// Student@65b54208
// Mahasiswa(name=Rui, nim=M0522007)
```

Dapat dilihat bahwa objek student menghasilkan teks Student@65b54208, di mana Student adalah nama kelas itu sendiri, dan @65b54208 adalah memory address dari kelas tersebut. Namun, objek data maahsiswa menghasilkan teks Mahasiswa(name=Rui, nim=M0522007), yaitu nama kelas bersama dengan semua properti dan nilai dari properti tersebut. 

Hal tersebut menunjukkan bahwa kita dapat mengetahui informasi yang terdapat di `mahasiswa` hanya dengan melihat nilai dari properti yang ada. Kondisi ini dapat terjadi dikarenakan **data class** akan secara otomatis menghasilkan fungsi `toString()` didalamnya. Tanpa kelebihan tersebut, kita harus membuat fungsi `toString()` secara manual untuk dapat mengetahui semua informasi yang ada dalam suatu _class_. 

#### **equals()** pada Data Class

Ketika kita menggunakan _data class_, kita dapat membandingkan dua buah objek hanya dengan menggunakan fungsi `equals`. Hal yang dibandingkan pada fungsi ini adalah informasi dari objek tersebut.

```kotlin
fun main(){
    val mahasiswa = Mahasiswa("Rui", "M0522007")
    val mahasiswa2 = Mahasiswa("Rui", "M0522007")
    val mahasiswa3 = Mahasiswa("Atya", "M0521003")

    println(mahasiswa.equals(mahasiswa2))
    println(mahasiswa.equals(mahasiswa3))

    // Output : 
    // true
    // false
}
```

#### **copy()** pada Data Class

Data Class juga memungkinkan kita untuk melakukan duplikat pada sebuah objek dengan memperbarui nilai pada propertinya.

```kotlin
fun main(){
    val mahasiswa = Mahasiswa("Rui", "M0522007")

    println(mahasiswa.copy(name = "Kio"))
    println(mahasiswa.copy(name = "Rhode", nim = "M0511065"))
}

// Output
// Mahasiswa(name=Kio, nim=M0522007)
// Mahasiswa(name=Rhode, nim=M0511065)
```

### Enum Class

Enum class dalam Kotlin adalah tipe data khusus yang digunakan untuk mendefinisikan kumpulan nilai tetap (enumerasi). Enum class biasanya digunakan untuk merepresentasikan himpunan nilai yang tetap dan terbatas.

```kotlin
enum class DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

fun printDay(day: DayOfWeek) {
    println("Today is $day")
}

fun main() {
    val today = DayOfWeek.MONDAY
    printDay(today) 
}

// Output
// Today is MONDAY
```

<br/>

## 4. Collections

_Collections_ digunakan untuk menyimpan dan memanipulasi kelompok objek atau data. Terdapat dua jenis _collections_, yaitu `mutable` dan `immutable`. _Collections_ yang bersifat **_mutable_ dapat diubah** nilainya, sedangkan _collections_ yang bersifat **_immutable_** tidak dapat diubah nilainya atau bersifat **_read-only_**. Terdapat berbagai macam collections pada Kotlin, yaitu : 
- List
- Set
- Map

### List

List adalah kumpulan elemen terurut yang dapat berisi duplikat. Elemen-elemennya dapat diakses menggunakan indeks.

#### Mutable List

```kotlin
fun main() {
    val mutableList = mutableListOf(1, 2, 3, 4, 5)
    println("Mutable List: $mutableList")

    mutableList.add(6)
    mutableList.removeAt(1)
    mutableList[2] = 10

    println("Modified Mutable List: $mutableList")
}

// Output
// Mutable List: [1, 2, 3, 4, 5]
// Modified Mutable List: [1, 3, 10, 5, 6]
```

#### Immutable List

```kotlin
fun main() {
    // Immutable List
    val immutableList = listOf(1, 2, 3, 4, 5)
    println("Immutable List: $immutableList")
}

// Output
// Immutable List: [1, 2, 3, 4, 5]
```

### Set

Set adalah kumpulan elemen yang tidak terurut dan tidak boleh memiliki duplikat. 

#### Mutable Set

```kotlin
fun main() {
    // Mutable Set
    val mutableSet = mutableSetOf(1, 2, 3, 4, 5)
    println("Mutable Set: $mutableSet")

    mutableSet.add(6)
    mutableSet.remove(3)

    println("Modified Mutable Set: $mutableSet")
}

// Output
// Mutable Set: [1, 2, 3, 4, 5]
// Modified Mutable Set: [1, 2, 4, 5, 6]
```

#### Immutable Set

```kotlin
fun main() {
    // Immutable Set
    val immutableSet = setOf(1, 2, 3, 4, 5)
    println("Immutable Set: $immutableSet")
}

// Output
// Immutable Set: [1, 2, 3, 4, 5]
```

### Map

Map adalah kumpulan pasangan kunci-nilai di mana setiap kunci unik dan memiliki nilai yang terkait.

#### Mutable Map

```kotlin
fun main() {
    // Mutable Map
    val mutableMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
    println("Mutable Map: $mutableMap")

    mutableMap["four"] = 4
    mutableMap.remove("two")
    mutableMap["three"] = 30

    println("Modified Mutable Map: $mutableMap")
}

// Output
// Mutable Map: {one=1, two=2, three=3}
// Modified Mutable Map: {one=1, three=30, four=4}
```

#### Immutable Map

```kotlin
fun main() {
    // Immutable Map
    val immutableMap = mapOf("one" to 1, "two" to 2, "three" to 3)
    println("Immutable Map: $immutableMap")
}

// Output
// Immutable Map: {one=1, two=2, three=3}
```

### Kotlin Collections
Kotlin Collections juga memiliki berbagai fungsi operasi yang dapat digunakan untuk mengakses data didalamnya, diantaranya : 

| Operasi | Fungsi |
|---------|---------|
| filter() | Mengembalikan koleksi yang berisi elemen-elemen yang memenuhi kondisi tertentu.  | 
| filterNot() | Mengembalikan koleksi yang berisi elemen-elemen yang tidak memenuhi kondisi tertentu.  |
| map() | Mengubah setiap elemen dalam koleksi menjadi elemen baru sesuai dengan transformasi yang diberikan.  | 
| count() | Menghitung jumlah elemen dalam koleksi yang memenuhi kondisi tertentu.  |
| find() | Mengembalikan elemen pertama dalam koleksi yang memenuhi kondisi tertentu, atau _null_ jika tidak ada yang cocok.  | 
| firstOrNull() | Mengembalikan elemen pertama dalam koleksi, atau null jika koleksi kosong.  |
| lastOrNull() | Mengembalikan elemen terakhir dalam koleksi, atau null jika koleksi kosong.  | 
| first() | Mengembalikan elemen pertama dalam koleksi.  |
| last() | Mengembalikan elemen terakhir dalam koleksi.  | 
| sum() | Menghitung total nilai dari elemen-elemen dalam koleksi.  |
| sorted() | Mengurutkan elemen-elemen dalam koleksi.  | 
| fold() | Menggabungkan elemen-elemen koleksi dengan nilai awal tertentu menggunakan operasi yang ditentukan.  |
| foldRight() | Mirip dengan `fold()`, namun prosesnya dimulai dari elemen terakhir hingga elemen pertama.  | 
| drop() | Menghapus sejumlah elemen pertama dari koleksi dan mengembalikan sisanya.  |
| dropLast() | Menghapus sejumlah elemen terakhir dari koleksi dan mengembalikan sisanya.  | 
| slice() | Mengambil sebagian elemen dari koleksi berdasarkan indeks yang ditentukan.  |
| distinct() | Menghapus duplikat dari koleksi dan mengembalikan elemen-elemen unik.  | 
| distinctBy() | Menghapus duplikat berdasarkan kriteria tertentu dari koleksi dan mengembalikan elemen-elemen unik.  |
| chunked() | Membagi koleksi menjadi bagian-bagian dengan ukuran tertentu.  | 


*Contoh kode* dapat dilihat pada file `operations.kt`.

<br/>

## 5. Kotlin Functional Programming

Dalam penulisan sintaksnya, Kotlin dapat menggunakan gaya _functional programming_. Functional Programming mengacu pada penggunaan fungsi sebagai unit utama komputasi. Paradigma ini menganggap fungsi sebagai objek pertama yang dapat disimpan dalam variabel, dikirim sebagai argumen ke fungsi lain, atau bahkan dihasilkan sebagai output dari fungsi lain. 

Terdapat beberapa sub-materi yang akan dibahas pada _functional programming_, yaitu : 
- Function Type
- Lambda
- Higher-Order Function
- Lambda with receiver
- Kotlin Standard Library
- Member Reference

### Function Type



```kotlin

```

### Lambda



```kotlin

```

### Higher-Order Function



```kotlin

```

### Lambda with receiver



```kotlin

```

### Kotlin Standard Library



```kotlin

```

### Member Reference



```kotlin

```

<br/>

## 6. Kotlin Generics

Generics merupakan suatu konsep yang memungkinkan kelas atau interface menjadi tipe parameter yang dapat digunakan untuk berbagai tipe data.

### Kelas Generic



```kotlin

```

### Fungsi Generic



```kotlin

```

### Constraint Type Parameter



```kotlin

```

<br/>

## 7. Coroutines


<br/>
