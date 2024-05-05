# Tugas Praktikum PAB Week 9

### Buatlah aplikasi android sederhana dengan ketentuan sebagai berikut:
1. Mengimplementasikan networking dengan retrofit.
2. Cari dan gunakanlah public API untuk poin 1.
3. Dengan memanfaatkan **method get** buatlah 2 tampilan dengan ketentuan sebagai berikut:
    - tampilan utama menampilkan data sederhana (bukan list) dari public API dan ada tombol untuk navigasi ke tampilan kedua, 
    - lalu tampilan kedua menampilkan data list dari public API (manfaatkan recycleview).

4. Buat tampilannya sekreatif mungkin.
5. **(Optional)** Buat tampilan lagi dengan ketentuan di bawah ini:
    - Pada tampilan pertama menambahkan satu tombol lagi untuk navigasi ke tampilan ketiga,
    - Pada tampilan ketiga ini implementasikan networking dengan retrofit **selain method get** (post, put, delete), buatlah dengan sekreatif mungkin.

**Note:** Jika menerapkan fitur opsional maka akan mendapat nilai tambahan, asisten sangat merekomendasikan untuk membuat fitur opsional jika pengumpuluan tugas praktikum sebelumnya banyak mengalami keterlambatan pengumpuluan.

### Referensi Layout
1. Tampilan Utama

    ![FirstLayout](asset/firstLayout.png)

2. Tampilan Kedua

    ![SecondLayout](asset/secondLayout.png)

**Keterangan**
1. Tulisan "Text" di atas mengindikasikan hasil get data dari public api, data yang di-get tidak harus bertipe string, bisa berupa tipe data yang lain **(semakin bervariasi tipe datanya, semakin bagus nilainya)**.
2. Silahkan kreasikan tampilan dengan kreativitas masing-masing.

### Ketentuan Source Code Aplikasi
1. Menggunakan Android Studio.
2. Menggunakan bahasa pemrograman Kotlin.
3. Pastikan saat build aplikasi, atur supaya **Minimum SDK >= 21** dan **target SDK <= 34**.


### Detail Laporan Praktikum
#### Laporan berisi screenshot source code dan tampilan user interface beserta penjelasannya disertai dengan kesimpulan. 
    
Tugas dikumpulkan dalam bentuk **.ZIP** dengan format nama **PPAB-09_NIM_Nama.zip yang berisi source code dari aplikasi** dan **.PDF dengan format nama PPAB-09_NIM_Nama.pdf yang berisi laporan praktikum**. Perlu diingat bahwa **file .zip tidak berisikan file pdf, murni berisi source code saja** dan gunakan **cara .zip sesuai yang diajarkan oleh asisten**.

    PPAB-XX_NIM_Nama.zip
    PPAB-XX_NIM_Nama.pdf
    
    xx = week praktikum

### Penilaian didasarkan pada: 

  1. Aplikasi Bebas dari error ketika dijalankan secara normal (10%)
  2. Relevansi source code dengan instruksi di atas (50%) 
  3. Kompleksitas Program yang dibuat (30%)
  4. Kreativitas masing-masing individu (10%).