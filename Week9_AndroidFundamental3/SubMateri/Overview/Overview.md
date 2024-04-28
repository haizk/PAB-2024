# Overview
Overview kali ini akan membahas secara singkat mengenai Web API, JSON, dan Networking. Hal ini penting karena seorang android developer nantinya akan sering menangani kasus dimana aplikasi membutuhkan data dari server.

## **Web API (Application Programming Interface) atau Web Service**
Merupakan layanan yang mengizinkan dua aplikasi saling terhubung melalui jaringan, sehingga kita dapat mengambil dan mengirim data ke layanan tersebut dengan mudah.

Berikut merupakan ilustrasinya:

![Web API](asset/WebAPI.png)

Dengan menggunakan layanan ini, membuat proses development menjadi lebih efisien, karena API cukup dibuat sekali, tapi dapat dikonsumsi di berbagai macam platform, seperti mobile, desktop maupun web.

Di internet banyak bertebaran public API yang dapat digunakan oleh siapapun. Biasanya public API ini memiliki gaya standar perancangan (arsitektur), yaitu REST (REpresentation State Transfer). 

Dalam arsitektur REST data yang diberikan bisa berupa format JSON. Untuk berkomunikasi data bisanya menggunakan protokol HTTP memungkinkan untuk saling bertukar data antara server dan client. Protokol ini, terdapat beberapa request method yang biasa digunakan untuk proses CRUD, yaitu:
- POST : Untuk membuat data (Create)
- GET : Untuk membaca data (Read)
- PUT : Untuk mengubah data (Update)
- DELETE : Untuk menghapus data (Delete)

Berikut dummy API pada website reqres.in https://reqres.in/api/users?page=1&per_page=10, dengan penjelasan parameter-parameternya sebagai berikut:
- Path : “users”
- Query 1 : “page” bernilai “1” 
- Query 2 : “per_page” bernilai “10”
- Gunakan “?” sebagai separator sebelum parameter pertama
- Gunakan “&” sebagai separator untuk parameter selanjutnya
- Gunakan “=” untuk mengisi query dengan suatu nilai/value

Ketika mengakses link di atas melalui browser, agar bisa dibaca dengan baik cobalah untuk menginstal ekstensi JSON Formatter. Bisa juga menggunakan Postman, merupakan GUI API Caller yang dapat memasukkan parameter atau body dengan mudah pada API melalui form tanpa perlu kode.

## **JSON (Javascript Object Notation)**
Merupakan format pertukaran & penyimpanan data yang ringan dan mudah dibaca (dibanding XML) yang dapat digunakan di hampir semua bahasa pemrograman.

Contoh tabel basis data:
![DB](asset/Db.png)

Format JSON basis data di atas, yaitu:
![DB JSON](asset/DbWithJSON.png)

Berdaarkan gambar di atas terdapat 2 hal penting pada JSON, yaitu JSONArray dan JSONObject. Struktur dari JSON menggunakan format key-value untuk menampilkan field data. Berikut merupakan beberapa tipe data pada value JSON:
- String : teks (dibungkus dengan “ “)
- Integer : angka bulat (misal: 0, 3, 40)
- Double : angka desimal (misal 0.2,  3.14, 40.0)
- Boolean : true/false
- Array : [“value1”, “value2”]
- Object : { “key” : “value” }
- Null : null

Agar JSON ini dapat dipakai sesuai bahasa pemrograman yang kita pakai, maka perlu melakukan Parsing JSON. Dalam kasus ini, akan digunakan bahasa pemrograman kotlin berdasarkan dummy API yang telah disebut sebelumnya, yaitu sebagai berikut:
- JSON Field
Untuk method yang digunakan menyesuaikan dengan tipe data yang diambil. Misalnya ingin mengambil data “page” yang bernilai 1, berikut contoh kodenya:
```xml
val jsonObject = JSONObject(response)
val page = jsonObject.getInt("page")
```

- JSON Array
Untuk mengambil data yang bertanda [ ] (kurung siku), dapat menggunakan getJSONArray, berikut contoh kodenya:
```xml
val jsonObject = JSONObject(response)
val dataArray = jsonObject.getJSONArray("data")
```

- JSON Object
Untuk mengambil data yang bertanda { } (kurung kurawal), dapat menggunakan getJSONObject(index), misalnya ingin mengambil data email pada Object pertama (ke-0), berikut contoh kodenya:
```xml
val jsonObject = JSONObject(response);
val dataArray = jsonObject.getJSONArray("data")
val dataObject = dataArray.getJSONObject(0)
val email = dataObject.getString("email")
```

## **Networking**
Merupakan cara untuk mengambil data dari Web API. Untuk melakukannya diperlukan beberapa library, yaitu sebagai berikut:
1. [Networking dengan library LoopJ](../LoopJ/LoopJ.md)
2. [Networking dengan library Retrofit](../Retrofit/Retrofit.md)

Berhubung materi yang telah di sampaikan di atas merupakan hal dasar, kalian dapat mengeksplorasinya sendiri (artikel di internet, buku, atau yang lainnya) untuk menambah pengetahuan dan pemahaman masing-masing.

Bisa dibuka untuk wawasan lebih lanjut:
1. [Web API](https://formatberita.com/2020/04/29/apa-itu-web-api/)