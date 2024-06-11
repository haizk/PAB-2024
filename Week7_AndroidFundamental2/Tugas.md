# Tugas Praktikum PAB (Week 7)

### Buatlah sebuah aplikasi Android dengan mengimplementasikan komponen-komponen di bawah ini.
 
 1. Aplikasi tersebut harus menggunakan **Tab Layout** dan **ViewPager2** bersama **Fragment** dengan **kriteria** sebagai berikut.
      - Menentukan tema pada Aplikasi yang ingin dibuat.
      - Minimal **isi** dari setiap Tab dapat menampilkan 10 data.
      - Mengganti **Judul** Tab menjadi **Icon** akan mendapat nilai tambahan **(Opsional)**.
        
 2. Aplikasi menerapkan **RecycleView** dalam memuat data di setiap Tab.

  Note: Jika menerapkan fitur opsional maka akan mendapat nilai tambahan, asisten sangat merekomendasikan untuk membuat fitur opsional jika pengumpuluan tugas praktikum sebelumnya banyak mengalami keterlambatan pengumpuluan.

### Berikut Simulasi dari Kriteria Aplikasi

![Simulesyen](simulasi.gif)


## Tips and Tricks
 1. Menambahkan kelas baru berupa **Repository** dalam mengambil data. **Fungsi** dari kelas **Repository** saat menerapkan ***RecycleView***,  untuk memisahkan dan mengelola sumber data yang akan digunakan. Sebagai contoh salah satu fungsi dalam kelas Repository dari simulasi di atas.
```kotlin
object MenuRepository {
    fun getMenuList(context: Context): ArrayList<Menu> {
        val resources = context.resources
        val menuNames = resources.getStringArray(R.array.food_name)
        val menuPrices = resources.getStringArray(R.array.food_price)
        val menuImages = resources.obtainTypedArray(R.array.img_food)

        val menuList = ArrayList<Menu>()
        for (i in menuNames.indices) {
            val name = menuNames[i]
            val price = menuPrices[i].toInt()
            val img = menuImages.getResourceId(i, 0)
            val type = Menu.Type.FOOD
            menuList.add(Menu(name, price, img, type))
        }
        menuImages.recycle()
        return menuList
    }
}
```

 2. Untuk membuat RecycleView diperlukan **persiapan Plugin** (Bagi Pengguna Android Studio tertentu), dan dalam menampilkan **RecycleView** jangan lupa membuat **Data Class** untuk menyediakan objek yang akan ditampilkan. Maka dari itu, kalian **harus membuka kembali modul praktikum Week 5** sebelum membuat sebuah RecycleView.

 3. Jangan lupa untuk menambahkan **Library** untuk **ViewPager2**

```kotlin
implementation("androidx.viewpager2:viewpager2:1.0.0")
```
   Lalu, memperbarui versi dari **Library** yang lain dan sesuaikan untuk versi **compileSdk** dan **targetSdk** nya juga, agar tidak terjadi error saat mem-*build* aplikasi Anda.


## Detail Laporan Praktikum
#### Laporan berisi screenshot source code dan tampilan user interface beserta penjelasannya disertai dengan kesimpulan. 
    
Tugas dikumpulkan dalam bentuk **.ZIP** dengan format nama **PPAB-07_NIM_Nama.zip yang berisi source code dari aplikasi** dan **.PDF dengan format nama PPAB-07_NIM_Nama.pdf yang berisi laporan praktikum**. Perlu diingat bahwa **file .zip tidak berisikan file pdf, murni berisi source code saja** dan gunakan **cara .zip sesuai yang diajarkan oleh asisten**.

    PPAB-XX_NIM_Nama.zip
    PPAB-XX_NIM_Nama.pdf
    
    xx = week praktikum

### Penilaian didasarkan pada: 

  1. Aplikasi Bebas dari error ketika dijalankan secara normal (10%)
  2. Relevansi source code dengan instruksi di atas (50%) 
  3. Kompleksitas Program yang dibuat (30%)
  4. Kreativitas masing-masing individu (10%). 
