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


**Contoh kode** dapat dilihat pada file `operations.kt`.

<br/>

## 5. Kotlin Functional Programming

Dalam penulisan sintaksnya, Kotlin dapat menggunakan gaya _functional programming_. Functional Programming mengacu pada penggunaan fungsi sebagai unit utama komputasi. Paradigma ini menganggap fungsi sebagai objek pertama yang dapat disimpan dalam variabel, dikirim sebagai argumen ke fungsi lain, atau bahkan dihasilkan sebagai output dari fungsi lain. 

Terdapat beberapa sub-materi yang akan dibahas pada _functional programming_, yaitu : 
- Lambda
- Kotlin Standard Library
- Member Reference

### Lambda
Lambda expression atau _anonymous function_ adalah sebuah fungsi yang tidak memiliki nama. Namun, seperti fungsi pada umumnya, lambda expression juga dapat memiliki **parameter**, **body**, dan **return type**. 

#### Regular Function

```kotlin
fun morning(name: String): String{
    return "Good Morning $name!"
}
```

#### Function with Lambda

```kotlin
val morning : (String) -> String = { name: String ->
    "Good Morning $name!"
}
```

#### Karakteristik Lambda

- Dengan lambda, kita tidak perlu menentukan tipe tertentu untuk nilai kembaliannya. Kompiler secara otomatis akan menentukan jenisnya.
- Karena lambda bersifat anonymous, saat dideklarasikan, lambda tidak membutuhkan kata kunci fun dan modifikasi visibilitas karena tetap merupakan fungsi.
- Parameter akan dimasukkan ke dalam kurung kurawal {}. Ketika ingin mengembalikan nilai, kompiler akan secara otomatis mengembalikannya dari dalam body. Dengan demikian, kata kunci return tidak lagi diperlukan.
- Expression lambda dapat disimpan ke dalam variabel atau digunakan sebagai argumen untuk parameter.

#### Penggunaan Lambda Expression

```kotlin
val morning = { println("Good Morning!") }
```

Kode di atas merupakan sebuah contoh penggunaan _lambda expression_ secara singkat. Kode tersebut dapat dijalankan dengan cara berikut : 

```kotlin
fun main(){
    morning()
}

// Output
// Good Morning!
```

Jika kita ingin menambahkan parameter pada _lambda expression_, kita dapat melakukannya seperti berikut :

```kotlin
val printMsg = { msg: String -> println(msg) }

fun main(){
    printMsg("Hello Future!")
}

// Output
// Hello Future!
```

Dalam kurung kurawal, terdapat **parameter** lambda, seperti yang disebutkan sebelumnya. Untuk membedakannya dari **body**, tanda `"->"` ditambahkan setelah daftar **parameter** yang ada. Lalu, bagaimana cara mendeklarasikan lambda untuk dapat mengembalikan nilai? Hal tersebut dapat dilakukan dengan cara berikut : 

```kotlin
val add = { a: Int, b: Int -> println(a + b) }

fun main(){
    add(1,2)
}

// Output
// 3
```

#### Perulangan dengan Lambda

**forEach**
```kotlin
fun main(){
    ranges.forEach{ print("$it ") }
    println()
}

// Output
// 1 3 5 7
```

**forEachIndexed**

Merupakan perulangan seperti `forEach`, tetapi dengan mendapatkan indeks dari tiap nilai yang dicakup

```kotlin
fun main(){
    ranges.forEachIndexed { idx, num -> 
        print("$idx - $num  ") 
    }
    println()
}

// Output
// 0 - 1  1 - 3  2 - 5  3 - 7
```

### Kotlin Standard Library

**Standard Function Library** adalah sebuah extension functions dari sebuah objek yang menggunakan lambda sebagai argumen atau yang disebut sebagai _higher-order function_.

#### **Scope Function**

Scope function adalah fungsi yang disediakan oleh Kotlin Standard Library yang digunakan untuk mengeksekusi blok kode di dalam konteks sebuah objek. Fungsi-fungsi ini memungkinkan Anda untuk bekerja dengan objek secara lebih ekspresif dan mudah, serta memfasilitasi penggunaan lambda expressions dengan ruang lingkupnya sendiri.

#### **Context Object**

Terdapat **dua cara** untuk mengakses konteks sebuah objek dari dalam lambda yang menjadi bagian dari scope function. Cara pertama adalah diakses sebagai **lambda receiver** atau `this`. Sedangkan cara kedua yaitu diakses sebagai **lambda argument** atau `it`. Kapabilitas yang sama dimiliki oleh keduanya, tetapi penggunaannya untuk kasus yang berbeda.  

#### **Lambda Receiver** atau `this`

Beberapa fungsi yang menggunakan lambda receiver adalah `run`, `with`, dan `apply`.

**run**

Jika di dalam blok lambda terdapat **inisialisasi objek** dan **perhitungan nilai kembalian**, fungsi `run` akan sangat bermanfaat karena fungsi ini akan menggunakan _receiver_ (`this`) untuk mengakses konteks objek dan mengembalikan nilai berdasarkan ekspresi yang ada di dalam blok lambda.

```kotlin
fun main() {
    val sentence = "I love programming"
    val result = sentence.run {
        val original = this
        val length = this.length
        "Length of text $original is $length"
    }
    println("Result: $result")
}

// Output
// Result: Length of text I love programming is 18
```

**with**

Fungsi `with` bukanlah merupakan sebuah _extension_, melainkan hanya fungsi biasa. Fungsi `with` menyematkan konteks objek sebagai argumen, kemudian oleh blok lambda diakses sebagai receiver.

```kotlin
fun main() {
    val text = "Hello, Kotlin!"

    val result = with(text) {
        println("Original text: $this")
        val modifiedText = this.replace("Kotlin", "World")
        println("Modified text: $modifiedText")
        "Modified text length: ${modifiedText.length}"
    }

    println(result)
}

// Output
// Original text: Hello, Kotlin!
// Modified text: Hello, World!
// Modified text length: 13
```

Fungsi `with` disarankan untuk mengakses apa yang menjadi anggotanya tanpa harus menyediakan nilai kembalian. Fungsi with juga berguna untuk mengurangi _boilerplate_ pada kode yang kita buat.

**apply**

Fungsi `apply` mengembalikan nilai dari konteks objeknya, dimana objek konteksnya merupakan _receiver_ (`this`). Fungsi `apply` sebaiknya dapat melakukan inialisasi atau konfigurasi dari _receiver_-nya.

```kotlin
fun main(){
    val text = StringBuilder().apply{
        append("Hi! ")
        append("Nice to meet you :)")
    }

    println(text.toString())
}

// Output
// Hi! Nice to meet you :)
```

Metode ini memiliki kekurangan: kita tidak dapat membedakan objek penerima dengan objek di luar lingkup fungsi. Cara ini lebih berfokus pada fungsi objek itu sendiri, seperti memanggil fungsi dan menginialisasi nilai anggota yang termasuk dalam objek.

#### **Lambda Argument** atau `it`

Terdapat dua fungsi yang menggunakan lambda argument untuk mengakses konteks dari sebuah objek, yaitu fungsi `let` dan `also`. Berbeda dengan sebelumnya, pada fungsi ini, produksi atau inialisasi nilai dari argumen untuk variabel lain dapat dilakukan.

Secara default, nama dari argumen pada fungsi ini adalah `it`, tetapi nama tersebut dapat kita ubah.

**let**

Fungsi `let` banyak digunakan dalam objek bertipe **_nullable_**

```kotlin
fun main(){
    val nim: String? = null
    nim?.let { 
        val length = it.length * 2
        val text = "nim length is $length"
        println(text)
    }
}

// Output : (Kosong)
```

Dengan menggunakan fungsi `let`, kita dapat melakukan pengecekan dengan mengurangi penggunaan operator safe call seperti kode berikut : 

```kotlin
fun main(){
    val nim: String? = null
    val length = nim?.length ?: 0 * 2
    val text = "nim length is $length"
    println(text)
}

// Output
// nim length is 0
```

Kita juga dapat menjalankan logika kode lain jika objeknya bernilai **null**. Hal inindapat dilakukan dengan memanfaatkan penggunaan fungsi `run` dan _elvis operator_, sehingga kode menjadi seperti berikut : 

```kotlin
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
}

// Output
// nim is null
```

Nilai kembalian pada fungsi `let` bergantung pada _expression_ yang berada di dalam blok lambda. Karena pada baris terakhir dari blok lambda tersebut adalah fungsi` println()`, maka nilai yang akan dikembalikan adalah **Unit**. Hal ini dikarenakan fungsi `println()` sendiri mengembalikan nilai **Unit**.

**also**

Fungsi `also` mirip seperti fungsi `apply`, dimana kembalian nilainya adalah konteks objek. Perbedaannya terletak pada bentuk konteks objeknya yaitu sebagai argumen (`it`). Jika kita ingin menggunakan konteks dari objek sebagai argumen tanpa harus mengubah nilainya, kita sebaiknya menggunakan fungsi `also`.

```kotlin
fun main() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)
    
    val result = numbers.also {
        it.add(6)
        println("List after adding element: $it")
    }

    println("Original list: $numbers")
    println("Result: $result")
}

// Output
// List after adding element: [1, 2, 3, 4, 5, 6]
// Original list: [1, 2, 3, 4, 5, 6]
// Result: [1, 2, 3, 4, 5, 6]
```

Fungsi `also` juga memodifikasi list `numbers`.

Scope function sangat berguna untuk bekerja dengan objek secara ringkas dan ekspresif, sambil menghindari duplikasi kode. Untuk penjelasan lebih lanjut mengenai **scope function**, kunjungi link [berikut](https://kotlinlang.org/docs/scope-functions.html).

### Member Reference

Kotlin memungkinkan kita untuk memisahkan lambda expression menjadi fungsi tersendiri dan mereferensikannya langsung sebagai _instance_ dari function type seperti contoh berikut:

```kotlin
fun add(a: Int, b: Int): Int = a+ b

val sum: (Int, Int) -> Int = ::count
```

Kode tersebut ditulis menggunakan mekanisme **Reflection** yang memungkinkan kita untuk  mengamati struktur kode dari proyek yang sedang kita kerjakan secara langsung.

#### Function References

Kita juga dapat mengimplementasikan _member references_ pada sebuah fungsi. Dengan menggunakan operator `::`, kita dapat menggunakannya sebagai _instances_ dari function type.

```kotlin
fun length(name: String): Int {
    return name.length
}

fun main() {
    val names = listOf("John", "Alice", "Bob", "Charlie")

    val sortedNames = names.sortedBy(::length) 

    println(sortedNames)
}

// Output
// [Bob, John, Alice, Charlie]
```

Selain itu, kita juga dapat menggunakannya pada _extension function_ seperti contoh kode berikut :

```kotlin
fun String.clength(): Int = this.length

fun main() {
    val names = listOf("John", "Alice", "Bob", "Charlie")

    val sortedNamesDesc = names.sortedByDescending(String::clength)

    println(sortedNamesDesc)
}

// Output
// [Charlie, Alice, John, Bob]
```

#### Property References

Operator `::` juga dapat digunakan untuk mereferensikan sebuah properti. Kita dapat mengakses bagian dari properti tersebut seperti nama, fungsi _setter getter_, dll dengen operator. 

```kotlin
var num1 = 4
val num2 = 7

fun main(){

    println(::num1.get())
    println(::num1.name)

    ::num1.set(5)
    
    println(::num2.get())
    println(::num2.name)

    // Akan menampilkan error
    // ::num2.set(5)

}

// Output 
// 4
// num1
// 7
// num2
```

Ekspresi `::num1` akan dievaluasi ke dalam objek dengan **KMutableProperty**. Ini memungkinkan kita untuk membaca nilai dengan `get()`, menetapkan nilai dengan `set()`, dan mendapatkan nama properti dengan properti name. Sedangkan ekspresi `::num2` yang merupakan properti _immutable_ akan mengembalikan nilai dengan tipe **KProperty**, dimana hanya terdapat fungsi `get()` didalamnya.


<br/>

## 6. Kotlin Generics

Generics merupakan suatu konsep yang memungkinkan kelas atau interface menjadi tipe parameter yang dapat digunakan untuk berbagai tipe data.

### Kelas Generic

Penenrapan generic dapat dilakukan dengan **meletakkan tipe parameter dalam _angle brackets_ (<>)** seperti contoh berikut :

```kotlin
interface List<T>{
    operator fun get(idx: Int): T
}
```

Tipe parameter T digunakan dalam kode di atas sebagai tipe reguler yang mengembalikan tipe fungsi. Kita juga dapat menggambarkannya sebagai _placeholder_ yang dapat kita bebaskan untuk menentukan tipe dasar yang didukung oleh kode. 

Sebuah kelas yang mewarisi kelas atau _interface_ generic memerlukan penentuan tipe argumen sebagai tipe dasar dari parameter generic untuk kelas tersebut. Berikut contoh kodenya :

```kotlin
class LongList : List<Long>{
    override fun get(idx: Int): Long {
        return this[idx]
    }
}
```

Selain dapat mewarisi kelas atau _interface_ generic, kita juga dapat membuat sebuah kelas generic yang mewarisi kelas atau _interface_ generic. Hal ini dapat dilakukan dengan menambahkan kode generic seperti kode di bawah ini : 

```kotlin
class ArrayList : List<P>{
    override fun get(idx: Int): P {
        return this[idx]
    }
}
```

Dengan kode tersebut, ketika mengggunakan kelas `ArrayList`, kita perlu menentukan tipe argumen yang akan digunakan. Hal tersebut dapat dilakukan dengan : 

```kotlin
fun main{
    val arrayList = ArrayList<Double>()
    val firstDouble = arrayList.get(0)
}
```

### Fungsi Generic

Jika kita membuat sebuah fungsi yang berhubungan dnegan List, maka fungsi generic akan dibutuhkan. Misalnya, kita ingin membuat list yang dapat digunakan untuk berbagai tipe dan tidak terpaku pada tipe tertentu.

Tipe parameter yang dimiliki fungsi generic ditentukan ketika fungsi dipanggil. Metode pendeklarasiannya sedikit berbeda dengan kelas generic. Tipe parameter di dalam angle bracket harus ditempatkan sebelum nama fungsi yang ditentukan.

```kotlin
fun <T> run(): T {
    /*...*/
}
```

Berikut adalah contoh penerapan generic pada fungsi : 

```kotlin
fun <T> List<T>.getElementAt(indices: Iterable<Int>): List<T> {
    val result = mutableListOf<T>() // Membuat list untung menyimpan hasil
    // Melakukan iterasi terhadap semua index dalam List
    for (index in indices) {
        // Mengecek apakah index berada dalam range index List
        if (index in 0 until size) { 
            result.add(this[index]) // Memasukkan nilai pada index yang diminta
        }
    }
    return result
}

fun main() {
    val numbers = listOf(10, 20, 30, 40, 50)

    // Mengambil elemen di indeks 1 dan 3
    val result = numbers.getElementAt(listOf(1, 3))

    println("Selected elements: $result") 
}

// Output
// Selected elements: [20, 40]
```

### Constraint Type Parameter

Pembatasan berbagai tipe yang dapat digunakan sebagai parameter dapat dilakukan pada penerapan generics. Penentuan batas tersebut dapat dilakukan dengan menambahkan titik dua (`:`) setelah tipe parameter, kemudian diikuti oleh tipe yang akan dijadikan batasan. Contoh kode seperti berikut :

```kotlin
class class NumberList<T : Number> : MyList<T>{
    override fun get(idx: Int): T {
        return this[idx]
    }
}
```

Pada kode di atas, batasan tipe argumen untuk kelas `NumberList` adalah **Number**. Compiler akan menunjukkan _error_ jika tipe argumen pada _class_ tersebut selain Int, Long, Double, dan tipe angka lainnya.

```kotlin
fun main() {
    val num1 = NumberList<Int>()
    val num2 = NumberList<Double>()// error : Type argument is not within its bounds
}
```

Constraint Type Parameter juga dapat digunakan pada Fungsi Generic seperti pada contoh berikut : 

```kotlin
fun <T : Number> MyList<T>.sumNumber() : T {
    /* .. */
}
```

Untuk penjelasan lebih lanjut mengenai **Constraint Type Parameters** pada Kotlin, kunjungi link [berikut](https://kotlinlang.org/spec/kotlin-type-constraints.html).

<br/>

## 7. Coroutines

Concurrency dalam Kotlin mengacu pada kemampuan untuk menjalankan beberapa tugas secara bersamaan atau berselingan, terutama dalam lingkungan komputasi yang dapat dijalankan secara parallel. Ini memungkinkan program untuk melakukan beberapa operasi secara efisien tanpa harus menunggu operasi sebelumnya selesai.

### Concurency Vs Parallelism

#### Concurency 
Concurrency dalam Kotlin sering diimplementasikan menggunakan coroutine, yang memungkinkan penulisan kode yang terlihat bersamaan tanpa perlu membuat banyak thread fisik tambahan. Dengan coroutine, kita dapat menjalankan tugas-tugas secara konkuren tanpa overhead yang terkait dengan pembuatan dan pengelolaan thread.

#### Parallelism 
Paralelisme dalam Kotlin dapat dicapai dengan menggunakan konsep konkurensi dan alat yang dirancang khusus untuk menjalankan tugas-tugas secara paralel di beberapa core CPU. Pustaka standar Kotlin, seperti kotlinx.coroutines, mendukung paralelisme untuk menjalankan tugas-tugas secara konkuren di beberapa core CPU sesuai kebutuhan.

### Kotlin Coroutines
Coroutines sering disebut sebagai "thread yang ringan" karena mereka lebih efisien dalam penggunaan sumber daya daripada thread tradisional, memungkinkan jutaan coroutines berjalan pada beberapa thread. Meskipun memiliki life cycle yang mirip dengan thread, coroutines lebih mudah diterapkan dan lebih powerful, terutama di lingkungan mobile di mana kinerja sangat krusial. Meskipun dijalankan di dalam thread, coroutines tidak terikat dengan thread tersebut, memungkinkan pengguna untuk mengatur jalannya coroutine, termasuk menentukan apakah akan dijalankan dalam thread tertentu atau ditangguhkan untuk dilanjutkan pada thread lainnya. Berikut ini contoh dari penggunaan coroutines.
```kotlin
import kotlinx.coroutines.*

fun main() {
    // Membuat coroutine
    val job = GlobalScope.launch {
        delay(1000) // Menunda eksekusi selama 1 detik (tanpa menghalangi thread utama)
        println("Coroutine selesai dijalankan")
    }

    // Menunggu coroutine selesai
    println("Menunggu coroutine selesai")
    runBlocking {
        job.join() // Menunggu coroutine selesai sebelum melanjutkan eksekusi
    }
    println("Coroutine telah selesai")
}

```

### Coroutines Builder
Coroutine builder adalah fungsi yang digunakan untuk membuat coroutine dalam Kotlin. Ada beberapa coroutine builder yang umum digunakan, termasuk launch, async, dan runBlocking.
* **launch**: Digunakan untuk memulai coroutine yang tidak mengembalikan nilai (void). Coroutine yang dibuat dengan launch akan berjalan secara asynchronous.
* **async**: Digunakan untuk memulai coroutine yang mengembalikan nilai. Coroutine yang dibuat dengan async akan mengembalikan objek Deferred, yang dapat digunakan untuk mendapatkan nilai hasil coroutine di masa depan.
* **runBlocking**: Digunakan untuk membuat coroutine dari kode yang tidak bersifat suspending. Biasanya digunakan dalam fungsi main() untuk membuat coroutine tanpa harus menggunakan GlobalScope.


Misalkan kita ingin membuat sebuah aplikasi sederhana yang melakukan dua tugas secara asynchronous: mencetak "Hello" setelah 1 detik, dan mencetak "World" setelah 2 detik. Berikut contohnya:
```kotlin
import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        delay(1000)
        println("Hello")
    }

    GlobalScope.launch {
        delay(2000)
        println("World")
    }

    Thread.sleep(3000) // Menunggu agar semua coroutines selesai sebelum aplikasi berakhir
}

```


### Job dan Deferred
#### Job 
Job dalam Kotlin merupakan hasil dari perintah asynchronous yang dijalankan, merepresentasikan coroutine yang sebenarnya, dengan tiga properti utama: isActive, isCompleted, dan isCancelled, yang merefleksikan status dari job tersebut. Siklus hidup job meliputi state New, Active, Completed, Cancelling, dan Cancelled, yang menunjukkan status job mulai dari inisialisasi hingga selesai atau dibatalkan.

Berikut adalah contoh sederhana menjalankan sebuah job dalam Kotlin menggunakan coroutines:
```kotlin
import kotlinx.coroutines.*

fun main() {
    // Membuat job
    val job = GlobalScope.launch {
        println("Job sedang berjalan")
        delay(1000)
        println("Job selesai")
    }
    
    // Menunggu job selesai
    runBlocking {
        job.join()
    }

    println("Semua job telah selesai")
}
```
Berikut adalah contoh cara membatalkan sebuah job dalam Kotlin menggunakan coroutines:
```kotlin
import kotlinx.coroutines.*

fun main() {
    // Membuat job
    val job = GlobalScope.launch {
        println("Job sedang berjalan")
        delay(1000)
        println("Job selesai")
    }
    
    // Membatalkan job setelah 500 ms
    GlobalScope.launch {
        delay(500)
        println("Membatalkan job")
        job.cancel()
    }
    
    // Menunggu job selesai
    runBlocking {
        job.join()
        println("Semua job telah selesai")
    }
}
```

### Deferred
Deferred adalah nilai tangguhan yang menunda hasil atau pengecualian dari proses coroutines, biasanya dihasilkan oleh fungsi async. Meskipun mirip dengan job dalam life cycle, deferred memiliki kemampuan untuk menghasilkan nilai baik saat proses berhasil maupun gagal, dapat diakses dengan await dan pengecualian dapat diakses dengan getCompletionExceptionOrNull. Deferred juga dapat dimulai secara lazy menggunakan parameter opsional seperti CoroutineStart.LAZY.

### Coroutines Dispatcher
Coroutine Dispatcher adalah mekanisme dalam Kotlin untuk menentukan thread mana yang akan digunakan untuk menjalankan dan melanjutkan coroutines. Terdapat beberapa tipe Dispatcher yang tersedia:
* **Dispatchers.Default**: Dispatcher dasar yang digunakan jika tidak ada dispatcher lain yang ditentukan, menggunakan kumpulan thread pada JVM dengan jumlah maksimal yang sama dengan jumlah core CPU.
* **Dispatchers.IO**: Dispatcher untuk operasi I/O yang memungkinkan pembongkaran pemblokiran, menggunakan kumpulan thread yang dibuat berdasarkan permintaan.
* **Dispatchers.Unconfined**: Dispatcher yang menjalankan coroutines pada thread yang sedang berjalan sampai mencapai titik penangguhan, dan dilanjutkan pada thread yang memanggil fungsi penangguhan.
* **Single Thread Context**: Dispatcher yang menjamin bahwa coroutines akan dijalankan pada thread yang ditentukan secara eksplisit.
* **Thread Pool**: Dispatcher dengan kumpulan thread yang tersedia, dan proses distribusi bebannya ditentukan oleh runtime.

### Channels
Channels adalah nilai deferred yang menyediakan cara mudah untuk mentransfer nilai tunggal antara coroutines. Mereka mirip dengan BlockingQueue, tetapi alih-alih memblokir sebuah thread, channels menangguhkan sebuah coroutine yang lebih ringan. Channels memungkinkan komunikasi yang aman antar kode concurrent dengan mengirim dan menerima pesan tanpa harus peduli di thread mana coroutine berjalan.

<br/>
