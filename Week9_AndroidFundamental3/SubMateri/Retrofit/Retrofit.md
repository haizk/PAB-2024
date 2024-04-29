# Networking dengan library Retrofit
Merupakan library buatan Square yang populer digunakan untuk melakukan Networking ke Web API. Dengan Retrofit, mengatur endpoint API dan parsing JSON jadi jauh lebih mudah. Untuk menggunakan library ini diperlukan beberapa langkah, yaitu sebagai berikut:
- Tambahkan library pada bagian **dependency** yang ada di **build.gradle(Module: app)**, lalu pilih **sync now**:
    ```
    dependencies {
        implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
        implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    }
    ```
Penambahan library Gson untuk melakukan parsing secara otomatis caranya hanya dengan menambahkan annotation pada class model.Selain Gson ada juga converter lain yang dapat dilihat pda tautan [ini](https://github.com/square/retrofit/wiki/Converters).

- Dengan menggunakan contoh dummy API pada reqres.in sebelumnya yaitu https://reqres.in/api/users?page=1. Tampilan JSON nya adalah sebagai berikut:
    ```
    {
    "page": 1,
    "per_page": 6,
    "total": 12,
    "total_pages": 2,
    "data": [
    {
    "id": 1,
    "email": "george.bluth@reqres.in",
    "first_name": "George",
    "last_name": "Bluth",
    "avatar": "https://reqres.in/img/faces/1-image.jpg"
    },
    {
    "id": 2,
    "email": "janet.weaver@reqres.in",
    "first_name": "Janet",
    "last_name": "Weaver",
    "avatar": "https://reqres.in/img/faces/2-image.jpg"
    },
    {
    "id": 3,
    "email": "emma.wong@reqres.in",
    "first_name": "Emma",
    "last_name": "Wong",
    "avatar": "https://reqres.in/img/faces/3-image.jpg"
    },
    {
    "id": 4,
    "email": "eve.holt@reqres.in",
    "first_name": "Eve",
    "last_name": "Holt",
    "avatar": "https://reqres.in/img/faces/4-image.jpg"
    },
    {
    "id": 5,
    "email": "charles.morris@reqres.in",
    "first_name": "Charles",
    "last_name": "Morris",
    "avatar": "https://reqres.in/img/faces/5-image.jpg"
    },
    {
    "id": 6,
    "email": "tracey.ramos@reqres.in",
    "first_name": "Tracey",
    "last_name": "Ramos",
    "avatar": "https://reqres.in/img/faces/6-image.jpg"
    }
    ],
    "support": {
    "url": "https://reqres.in/#support-heading",
    "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
    }
    ```

- Setelah itu, buat kelas model berdasarkan data JSON di atas dan tambahkan annotation dan pastikan bahwa property yang ada di dalam SerializedName memiliki nilai yang sama persis dengan key yang pada respon JSON, seperti berikut:
    ```
    data class ResponseUser(
    @field:SerializedName("page")
    val page: Int? = null,
    
    @field:SerializedName("per_page")
    val perPage: Int? = null,
    
    @field:SerializedName("total")
    val total: Int? = null,
    
    @field:SerializedName("total_pages")
    val totalPages: Int? = null,
    
    @field:SerializedName("data")
    val data: List<DataItem>? = null
    )
    ```

    - Buat kelas model untuk data user nya dan tambahkan annotation, seperti berikut:
    ```xml
    data class DataItem(
        @field:SerializedName("id")
        val id: Int? = null,
    
        @field:SerializedName("email")
        val email: String? = null,
    
        @field:SerializedName("first_name")
        val firstName: String? = null,
    
        @field:SerializedName("last_name")
        val lastName: String? = null,
    
        @field:SerializedName("avatar")
        val avatar: String? = null
    )
    ```

Pada kelas model yang telah dibuat, SerializedName berfungsi untuk menandai suatu variabel untuk dimasukkan data dengan key yang sesuai dari JSON. Misalnya variabel firstName akan dimasukkan data dengan key "first_name". Pembuatan kelas model ini juga dapat dilakukan secara otomatis dengan menggunakan plugin RoboPOJOGenerator pada Android Studio.

- Buat interface nya:
    ```
    interface ApiService {
        @GET("api/users")
        fun getListUsers(@Query("page") page: String): Call<ResponseUser>
    }
    ```

kode di atas berdasarkan url dummy API yang telah disebutkan dengan memperhatikan ketentuan seperti berikut:
    - Base URL : https://reqres.in/ (URL dasar yang tetap yang akan diletakkan di Api )
    - Endpoint : api/users (bagian akhir URL yang biasanya digunakan untuk menentukan aksi)
    - Parameter : ?page=1 (ditandai dengan awalan “?” dan pemisah antar parameter “&”)

- Buat instance retrofit dengan menggunakan Retrofit.Builder:
    ```
    val retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService = retrofit.create(ApiService::class.java)
    ```
Pada kode di atas, converter factory berfungsi untuk menambahkan converter GSON.

- Eksekusi request secara asynchronous, dengan menggunakan fungsi enqueue seperti berikut:
    ```
    val client = apiService.getListUsers("1")
    
    client.enqueue(object : Callback<ResponseUser> {
        override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
            if (response.isSuccessful) {
                val listUser = response.body()?.data as List<DataItem>
                ...
            }
        }
    
        override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
            // Terpanggil ketika tidak dapat menghubungi server
        }
    })
    ```

- Jika melakukan eksekusi request secara asynchronous di atas tanpa menggunakan library Gson converter akan terlihat kurang ringkas seperti berikut:
    ```
    val listUser = arrayListOf<DataItem>()
    val jsonObject = JSONObject(response.body().toString())
    val jsonArray = jsonObject.getJSONArray("data")
    for (i in 0 until jsonArray.length()) {
        val id = jsonArray.getJSONObject(i).getInt("id")
        val email = jsonArray.getJSONObject(i).getString("email")
        val firstName = jsonArray.getJSONObject(i).getString("first_name")
        val lastName = jsonArray.getJSONObject(i).getString("last_name")
        val avatar = jsonArray.getJSONObject(i).getString("avatar")
        val user = DataItem(id, email, firstName, lastName, avatar)
        listUser.add(user)
    }
    ```

Berhubung materi yang telah di sampaikan di atas merupakan hal dasar, kalian dapat mengeksplorasinya sendiri (artikel di internet, buku, atau yang lainnya) untuk menambah pengetahuan dan pemahaman masing-masing.

Bisa dibuka untuk wawasan lebih lanjut:
1. [Retrofit](https://square.github.io/retrofit/)