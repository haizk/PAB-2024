# Networking dengan library LoopJ
Library ini juga disebut sebagai library AsyncHttpClient. Untuk menggunakan library ini diperlukan beberapa langkah, yaitu sebagai berikut:
- Menggunakan gradle untuk mengintegrasikan AsyncHttpClient ke aplikasi.
Menambahkan satu baris gradle script di bawah ini pada bagian **dependency** yang ada di **build.gradle(Module: app)**, lalu pilih **sync now**
    ```
    dependencies {
        ...
        implementation 'com.loopj.android:android-async-http:1.4.9'
    }
    ```

- Dengan menggunakan contoh dummy API pada reqres.in sebelumnya yaitu https://reqres.in/api/users?page=1. 


1. Penggunaannya untuk method GET:
    ```
    val client = AsyncHttpClient()
    val url = "https://reqres.in/api/users?page=1"
    client.get(url, object : AsyncHttpResponseHandler() {
        override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
            // called when response HTTP status is "200 OK"
        }
    
        override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
            // called when response HTTP status is "4XX" (eg. 401, 403, 404)
        }
    })
    ```
Berikut beberapa penjelasan singkatnya:
- AsyncHttpClient: client yang bertanggung jawab untuk koneksi data dan sifatnya adalah asynchronous.
- Callback onSuccess(): response yang memberikan kode status 200, yang artinya koneksi berhasil. Di dalam blok ini dapat dilakukan proses parsing JSON dan menampilkan data ke aplikasi.
- Callback onFailure(): response yang memberikan kode status 4xx (seperti 401, 403, 404, dll), yang artinya koneksi gagal

2. Penggunaannya untuk method POST:
    ```
    val client = AsyncHttpClient()
    val params = RequestParams()
    params.put("name", "arif faizin")
    params.put("job", "academy content writer")
    val url = "https://reqres.in/api/users"
    client.post(url, params, object : AsyncHttpResponseHandler() {
        override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
            // called when response HTTP status is "200 OK"
        }
    
        override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
            // called when response HTTP status is "4XX" (eg. 401, 403, 404)
        }
    })
    ```
- RequestParams(): digunakan untuk memasukkan parameternya.

3. Penggunaan untuk method PUT:
    ```
    val client = AsyncHttpClient()
    val params = RequestParams()
    params.put("name", "arif faizin")
    params.put("job", "academy content writer")
    val url = "https://reqres.in/api/users"
    client.put(url, params, object : AsyncHttpResponseHandler() {
        override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
            // called when response HTTP status is "200 OK"
        }
    
        override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
            // called when response HTTP status is "4XX" (eg. 401, 403, 404)
        }
    })
    ```

4. Penggunaan untuk method DELETE:
    ```
    val client = AsyncHttpClient()
    val params = RequestParams()
    params.put("id", "21");
    val url = "https://reqres.in/api/users"
    client.delete(url, params, object : AsyncHttpResponseHandler() {
        override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
            // called when response HTTP status is "200 OK"
        }
    
        override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
            // called when response HTTP status is "4XX" (eg. 401, 403, 404)
        }
    })
    ```

Berhubung materi yang telah di sampaikan di atas merupakan hal dasar, kalian dapat mengeksplorasinya sendiri (artikel di internet, buku, atau yang lainnya) untuk menambah pengetahuan dan pemahaman masing-masing. 