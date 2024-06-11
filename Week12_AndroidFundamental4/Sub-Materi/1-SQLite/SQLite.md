# SQLite

SQLite adalah database _open source_ yang mendukung operasi relasi standar yang umumnya terdapat pada engine _database_ seperti sintaks SQL dan operasi transaksi. Meskipun berjalan seperti _database_, pada umumnya SQlite berukuran kecil dan mampu berjalan pada _device__ dengan memori terbatas seperti _smartphone_.

SQLite telah digunakan oleh aplikasi-aplikasi native dengan penyimpanan data yang tidak bersifat kompleks seperti Google Chrome dan Firefox. Contoh dari penggunaan SQLite adalah untuk menyimpan data _bookmark_ website yang dilakukan oleh pengguna dan juga aplikasi mobile seperti aplikasi _contact_ bawaan OS Android yang menggunakannya sebagai penyimpanan data lokal yang mendukung proses sinkronisasi ke server.

SQLite pada Android mendukung tipe data seperti `text`, `int`, dan `real`. Untuk tipe data yang tidak didukung, diperlukan konversi sebelum penyimpanan. SQLite sudah tersedia di semua perangkat Android tanpa perlu autentikasi atau setup administrasi seperti _database_ besar lainnya. _Database_ dibuat dan diatur otomatis oleh platform Android menggunakan perintah SQL untuk pembuatan dan pembaruan data.

_Database_ yang dibuat oleh sebuah aplikasi Android bersifat ___private___ dan hanya dapat diakses oleh aplikasi itu sendiri. Akses data oleh aplikasi lain memerlukan mekanisme ContentProvider. Contohnya, aplikasi kontak dan WhatsApp menggunakan sumber data yang sama untuk manipulasi data kontak. Ini mirip dengan API lokal yang memungkinkan aplikasi lain mengakses data.

SQLite mendukung penyimpanan data dalam jumlah besar dan optimasi untuk query dan input data. Pengalaman menunjukkan SQLite dapat mengelola lebih dari 150.000 baris data dengan optimasi Bulk Insert. Database disimpan di direktori data aplikasi pada perangkat Android, yang terlihat hanya jika perangkat di-root. Untuk manipulasi data dalam jumlah besar, disarankan menggunakan proses _asynchronous_ dengan Executor atau Coroutine.

## Pembuatan dan Pembaruan Database

Dalam pembuatan dan pembaruan database SQLite oleh aplikasi, langkah pertama yang dilakukan adalah mendefinisikan skema data yang akan diimplementasikan ke dalam _database_. Semua skema yang ada, dimasukkan pada satu file Java/Kotlin yang berisi nama table, nama kolom, bahkan query yang akan dijalankan. Ini adalah best practice yang direkomendasikan agar memudahkan dalam mengorganisasi kelas-kelas yang digunakan dalam proses coding.

Misalnya kita memiliki tabel kucing seperti di bawah ini:

| No | Nama Kucing | Umur | Jenis Kelamin | Warna   |
|----|-------------|------|---------------|---------|
| 1  | Simba       | 2    | Jantan        | Coklat  |
| 2  | Luna        | 1    | Betina        | Hitam   |
| 3  | Milo        | 3    | Jantan        | Putih   |
| 4  | Bella       | 4    | Betina        | Abu-abu |
| 5  | Leo         | 2    | Jantan        | Oranye  |
| 6  | Lucy        | 5    | Betina        | Coklat  |

Maka, kode _contract_ dari berkas tersebut adalah berikut:

```kotlin
class CatContract {
    class CatColumns : BaseColumns {
        companion object {
            const val TABLE_NAME = "cat"
            const val COLUMN_NAME_NO = "no"
            const val COLUMN_NAME_NAME = "name"
            const val COLUMN_NAME_AGE = "age"
            const val COLUMN_NAME_GENDER = "gender"
            const val COLUMN_NAME_COLOR = "color"
        }
    }
}
```

Perhatikan semua variabel nama tabel dan kolom didefinisikan secara global dan menjadi konstanta, sehingga mempermudah untuk diakses di semua struktur bagian program. Satu hal yang harus diingat, setiap kolom yang bersifat _incremental_ dan menjadi _primary key_ seperti ID pada SQLite haruslah berbentuk seperti ini —  "___id__ ". Dengan mengimplementasikan `BaseColumns`, kolom ___id__ akan secara otomatis menjadi bagian dari kolom yang ditentukan pada sebuah tabel.

Android telah menyediakan satu set API yang diperuntukkan untuk melakukan pembuatan dan perbaruan aplikasi dalam kelas __SQLiteOpenHelper__. Kelas tersebut diperuntukkan untuk menjalankan fungsi-fungsi dalam Data Definition Language (DDL) pada sebuah database.

```kotlin
class CatsHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
 
    companion object {
        // Jika kamu mengubah skema database maka harus dinaikkan versi databasenya.
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "Cat.db"
    }
 
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }
 
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Method ini untuk melakukan proses upgrade pada perubahan tabel dan skema database. Fokus migrasi data akan dilakukan disini
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
 
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
}
```

`SQL_CREATE_ENTRIES` adalah statement untuk pembuatan database, yaitu seperti ini "__CREATE TABLE book (id INTEGER PRIMARY KEY, title TEXT, author TEXT, genre TEXT, pages INT)__". Dalam bentuk kode ditulis seperti ini:

```kotlin
private val SQL_CREATE_ENTRIES = "CREATE TABLE ${BookColums.TABLE_NAME}" +
        " (${BookColums._ID} INTEGER PRIMARY KEY," +
        " ${BookColums.COLUMN_NAME_TITLE} TEXT," +
        " ${BookColums.COLUMN_NAME_AUTHOR} TEXT," +
        " ${BookColums.COLUMN_NAME_GENRE} TEXT," +
        " ${BookColums.COLUMN_NAME_PAGES} INT)"
```

__Catatan :__
Perhatikan pula spasi dan koma supaya teks query-nya tepat, kurang koma atau spasi menyebabkan error saat membuat table.

Dan `SQL_DELETE_ENTRIES` adalah statement untuk penghapusan database yang ada untuk diperbarui menjadi versi terbaru. Query-nya yaitu "__DROP TABLE IF EXISTS book__". Dalam bentuk kode ditulis seperti ini:

```kotlin
private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $BookColums.TABLE_NAME"
```

Pertanyaannya adalah bagaimana jika Anda memiliki banyak tabel dalam satu database di dalam satu aplikasi? Best Practice untuk jawaban dari kasus ini adalah Anda diharuskan membuat masing-masing kelas seperti di atas untuk per tabel. Tujuannya tidak lain adalah untuk mempermudah pengorganisasian file sewaktu dilakukan proses penulisan kode di aplikasi. 

Nah, untuk detail method apa saja yang terdapat pada SQLiteOpenHelper untuk mendukung proses Data Definition Language (DDL) Anda bisa menuju pada tautan berikut ini.

[SQLiteOpenHelper](https://developer.android.com/reference/android/database/sqlite/SQLiteOpenHelper)

## Proses Manipulasi Database

 Jika sudah familiar dengan proses CRUD (Create, Read, Update, dan Delete) pada database lain seperti MySQL, pastilah ini menjadi nilai mutlak yang harus diketahui. Beruntungnya Android sudah menyediakan sebuah kelas API dalam SQLiteDatabase untuk proses Data Manipulation Language (DML) pada sebuah tabel. Kelas API tersebut memiliki beberapa metode powerful seperti query(), insert(), update(), delete(). Nama metode sudah mewakili fungsi yang terdapat pada masing-masing metode.

 Untuk melakukan CREATE dengan menggunakan _method_ __insert()__, kita dapat menggunakan kode berikut:

 ```kotlin
 // Gets the data repository in write mode
val db = mDbHelper.getWritableDatabase()
 
// Create a new map of values, where column names are the keys
val values = ContentValues()
values.put(CatContract.CatColumns.COLUMN_NAME_NO, 1)
values.put(CatContract.CatColumns.COLUMN_NAME_NAME, "Simba")
values.put(CatContract.CatColumns.COLUMN_NAME_AGE, 2)
values.put(CatContract.CatColumns.COLUMN_NAME_GENDER, "Jantan")
values.put(CatContract.CatColumns.COLUMN_NAME_COLOR, "Coklat")
 
// Insert the new row, returning the primary key value of the new row
val newRowId = db.insert(CatColums.TABLE_NAME, null, values)
```

Hanya dibutuhkan sebuah obyek SQLiteDatabase yang didapat dari pemanggilan `getWritableDatabase()` melalui obyek `mDbHelper` yang berasal dari kelas `CatsHelper` yang dijelaskan sebelumnya. Selanjutnya Anda hanya perlu membuat obyek `values` yang merupakan _instance_ obyek dari `ContentValues`. Ini adalah obyek _map_ pasangan _key_ dan _value_, di mana yang menjadi _key_ adalah nama kolom tabel tujuan dan _value_-nya adalah nilai yang Anda masukkan.

Selanjutnya, untuk melakukan _insert_ data hanya dibutuhkan satu baris kode berikut.

```kotlin
val newRowId = db.insert(CatColums.TABLE_NAME, null, values)
```

Di mana terdapat tiga parameter utama yaitu _nama tabel_, _nullColumnHack_, dan obyek _map ContentValues_. _nullColumnHack_ yang dimaksud di sini adalah mekanisme di mana Anda ingin menginputkan obyek __ContentValues__ berisi _null_ pada kolom tertentu. Ketika Anda memasukkan nilai _null_ pada saat _insert()_ ke tabel tersebut maka nilai _nullColumnHack_ harus terisi nama kolom terkait dalam hal ini adalah kolom "warna" seperti berikut.

```kotlin
val newRowId = db.insert(CatColums.TABLE_NAME, CatColumns.COLUMN_NAME_COLOR, values)
```

Ketika dieksekusi nilai `_id` akan tetap terisi dan nilai color akan berisi _null_. Jika Anda tetap mengisi parameter _nullColumnHack_ dengan _null_, ini akan membuat _framework_ Android tidak akan menyimpan data apapun. Yang perlu diingat _nullColumnHack_ adalah bersifat __opsional__.

## Proses Pengambilan data (READ) dengan metode query() dan rawQuery()

Proses query yang dilakukan adalah dengan memanfaatkan metode query() dan rawQuery() yang memiliki banyak sekali bentuk dengan masing-masing parameter yang berbeda-beda. Output dari kedua metode di atas adalah sebuah obyek cursor. Obyek cursor itu sendiri merepresentasikan tabel yang diperoleh dari hasil query. Jelas, jika tabel maka memiliki baris dan kolom. Contohnya sebagai berikut.

```kotlin
import android.database.sqlite.SQLiteDatabase

var db = mDbHelper.getReadableDatabase()

// Definisikan kolom mana saja yang akan digunakan untuk menampilkan data
var projection = arrayOf(
    CatContract.CatColumns._ID,
    CatContract.CatColumns.COLUMN_NAME_NO,
    CatContract.CatColumns.COLUMN_NAME_NAME,
    CatContract.CatColumns.COLUMN_NAME_AGE,
    CatContract.CatColumns.COLUMN_NAME_GENDER,
    CatContract.CatColumns.COLUMN_NAME_COLOR
)

// Jika ada filter pada hasil yang diharapkan maka kita menambahkan klausa WHERE "gender" LIKE 'Jantan'
var selection = CatContract.CatColumns.COLUMN_NAME_GENDER + " LIKE ?"
var selectionArgs = arrayOf("Jantan")

// Lalu tentukan bagaimana hasil query yang didapatkan diurutkan
var sortOrder = CatContract.CatColumns.COLUMN_NAME_NAME + " ASC"

var c = db.query(
    CatContract.CatColumns.TABLE_NAME,  // Tabel yang digunakan
    projection,                         // Kolom yang ingin ditampilkan
    selection,                          // Kolom yang akan kita seleksi untuk kebutuhan filter dalam klausa WHERE
    selectionArgs,                      // Nilai pembanding untuk klausa WHERE untuk proses seleksi
    null,                               // apakah akan dilakukan pengelompokan hasil (group), null untuk tidak
    null,                               // apakah dilakukan proses filter berdasarkan hasil pengelompokan, null untuk tidak
    sortOrder                           // Urutan hasil yang diharapkan
)
```

Hasil dari kode tersebut akan menghasilkan tabel data seperti berikut:

| ID | Nama Kucing | Umur | Jenis Kelamin | Warna   
|----|-------------|------|---------------|---------|
| 1  | Simba       | 2    | Jantan        | Coklat  |
| 2  | Leo         | 2    | Jantan        | Oranye  |
| 3  | Milo        | 3    | Jantan        | Putih   |

Hasil dari projection menyebabkan data yang ditampilkan mencakup semua kolom yang ada. Kemudian selection digunakan untuk memfilter data berdasarkan kucing dengan jenis kelamin _Jantan_. Selanjutnya _sortOrder_ digunakan untuk mengurutkan data berdasarkan nama buku secara _ascending_ (A ke Z). 

Yang perlu diketahui yaitu ketiga parameter di atas bersifat optional. Jika Anda tidak ingin menggunakannya dan menampilkan semua data secara default, Anda dapat menggantinya dengan null seperti ini.

```kotlin
var c = db.query(CatColums.TABLE_NAME, null, null, null, null, null, null)
```

Karena hasilnya masih dalam obyek cursor, bagaimana untuk melakukan proses pengambilan data berdasarkan baris dan kolomnya? Caranya seperti ini.

```kotlin
import android.database.Cursor

if (c.moveToFirst()) {
    println("| No | ID | Nama Kucing | Umur | Jenis Kelamin | Warna   |")
    println("|----|----|-------------|------|---------------|---------|")
    do {
        val id = c.getInt(c.getColumnIndexOrThrow(CatContract.CatColumns._ID))
        val no = c.getInt(c.getColumnIndexOrThrow(CatContract.CatColumns.COLUMN_NAME_NO))
        val name = c.getString(c.getColumnIndexOrThrow(CatContract.CatColumns.COLUMN_NAME_NAME))
        val age = c.getInt(c.getColumnIndexOrThrow(CatContract.CatColumns.COLUMN_NAME_AGE))
        val gender = c.getString(c.getColumnIndexOrThrow(CatContract.CatColumns.COLUMN_NAME_GENDER))
        val color = c.getString(c.getColumnIndexOrThrow(CatContract.CatColumns.COLUMN_NAME_COLOR))
        
        println("| $no | $id | $name | $age | $gender | $color |")
    } while (c.moveToNext())
}

c.close()

```

Selain cara di atas, kita bisa menggunakan metode `rawQuery()` jika Anda ingin mengeksekusi _statement query_ secara tekstual seperti ini.

```kotlin
database.rawQuery("SELECT * FROM ${CatColums.TABLE_NAME} ORDER BY ${CatColums.COLUMN_NAME_AGE} DESC", null)
```

Contoh di atas adalah _raw query_ untuk mengambil data buku dengan urutan dari umur tertua (descending).


### Update data pada Database dengan update()

Untuk melakukan _update_ data pada tabel, SQLiteDatabase telah menyediakan metode _update()_ untuk melakukan itu semua.

```kotlin
val db = mDbHelper.getWritableDatabase()
 
// Nilai update untuk kolom
val values =  ContentValues()
values.put(BookColums.COLUMN_NAME_TITLE, title)
 
// Klausa kondisi untuk mengupdate data dengan kriteria tertentu
val selection = BookColums.COLUMN_NAME_GENRE + " = ?"
val selectionArgs = arrayOf("Programming")
 
val count = db.update(
    BookColums.TABLE_NAME,
    values,
    selection,
    selectionArgs
)
```

### Delete data pada Database dengan delete()

Untuk menghapus data dari _database_ cukup dengan menggunakan _delete()_ dengan beberapa parameter yang digunakan seperti nama tabel, seleksi, dan argumen seleksi.

```kotlin
// Definisikan proses seleksi 'where' dari query.
val selection = BookColums.COLUMN_NAME_NAME + " LIKE ?"
// Argumen yang ditentukan.
val selectionArgs = arrayOf("Milo")
// Eksekusi SQLstatement
db.delete(BookColums.TABLE_NAME, selection, selectionArgs)
```

Jika dibaca maka proses di atas akan menghapus data pada tabel entry untuk data kolom yang berisi kata-kata seperti Milo.

Cukup mudah melakukan proses _Data Manipulation Language_ pada SQLite. Untuk memahami lebih lanjut, kami sarankan Anda membaca dan melihat dokumentasi tentang SQLiteDatabase pada tautan ini:

[SQLiteDatabase](https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase)

## Keamanan Database

Terdapat beberapa mekanisme pengamanan database SQLite salah satu di antaranya adalah SQLiteCipher yang mana mudah diimplementasikan dengan dokumentasi yang cukup bagus untuk platform Android. SQLiteCipher dapat mengamankan data yang terdapat pada SQLite kita dengan metode enkripsi 256-bit AES.

Untuk lebih detail tentang SQLiteCipher Anda bisa kunjungi laman ini.

(SQLcipher for Android)[https://www.zetetic.net/sqlcipher/sqlcipher-for-android/] 