# CoddeLab Networking dengan library Retrofit
1. Buatlah project baru di android studio, dengan ketentuan seperti gambar berikut ini:
   ![alt text](asset/1.newProject.png)
   Bisa diganti, jika ada yang perlu diganti.

2. API yang akan digunakan, yaitu:
    - https://jsonplaceholder.typicode.com/users

3. Buka url dummy API di atas pada browser, instal ekstensi JSON Formatter agar lebih mudah untuk dibaca.

4. Tambahkan kode di bawah ini, yang merupakan library retrofit, gson, dan interceptor, pada **build.gradle.kts(Module: app)**, lalu pilih **sync now** tunggu sampai proses sinkronisasi gradle selesai.

   ```
   dependencies {
        ...
        implementation("com.squareup.retrofit2:retrofit:2.6.1")
        implementation("com.squareup.retrofit2:converter-gson:2.6.1")
        implementation("com.squareup.okhttp3:logging-interceptor:4.2.0")
   }
   ```

5. Karena dalam mengambil data melalui Web API ini memerlukan internet, maka tambahkan kode permission berikut pada AndroidManifest seperti berikut:

   ```
   <?xml version="1.0" encoding="utf-8"?>
   <manifest xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:tools="http://schemas.android.com/tools"

       <uses-permission android:name="android.permission.INTERNET" />

       <application
           ...
       </application>
   </manifest>
   ```

6. Buatlah package bernama **data** pada package utama, dengan cara klik kanan pada package utama -> new -> package, seperti gambar berikut:
    ![alt text](asset/4.newpackage.png)

    Agar tampilan folder menjadi lebih mudah dibaca, uncheck **compact middle package**, dengan memilih ikon titik 3 di samping folder android, seperti pada gambar berikut:
    ![alt text](asset/5.tree.png)

    Buatlah package bernama **response** pada package response, lalu buatlah class model dengan nama **UserResponse** pada package response ini yang akan digunakan untuk menampung respon dari API. Pada class model ini, tambahkan kode seperti di bawah ini:
    ```
    data class UserResponse (
        @field:SerializedName("website")
        val website: String,

        @field:SerializedName("phone")
        val phone: String,

        @field:SerializedName("name")
        val name: String,

        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("email")
        val email: String,

        @field:SerializedName("username")
        val username: String
    )
    ```
    Pembuatan class model ini berdasarkan dummy api yang digunakan pada poin 2. Bisa juga menggunakan plugin RojoPojoGenerator.

7. Buatlah package bernama **retrofit** pada package data, lalu buatlah class dengan nama **ApiService** pada package response ini. Pada class ini tambahkan kode seperti di bawah ini:
    ```
    interface ApiService {
        @GET("users")
        fun getUsers(): Call<ArrayList<UserResponse>>
    }
    ```

8. Masih di package retrofit, buatlah class bernama **ApiConfig**, lalu tambahkan kode seperti di bawah ini:
    ```
    class ApiConfig {
        companion object{
            fun apiService(): ApiService {
                val loggingInterceptor =
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                val client = OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build()
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
                return retrofit.create(ApiService::class.java)
            }
        }
    }
    ```
    Kelas ini akan membuat kode menjadi lebih efektif karena tidak perlu membuat konfigurasi Retrofit baru setiap kali membutuhkannya, tetapi cukup memanggil fungsi yang ada di dalam class ini saja.

9. Buatlah package bernama **ui** pada package utama, lalu pindahkan MainActivity ke package ini. Package-package yang telah dibuat ini bertujuan agar lebih mudah dalam membaca dan mengelola kode.

10. Buka activiy_main.xml, lalu buatlah tampilan layoout nya seperti ini:
    ```
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/main"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".ui.MainActivity">

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/rvUser"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            tools:listitem="@layout/item_user"
            linearLayoutManager="androidx.recyclerview.widget.LinearLayoutManager">

        </androidx.recyclerview.widget.RecyclerView>

    </LinearLayout>
    ```

11. Buat layout baru dengan cara klik kanan pada folder layout → New → Layout resource file dan beri nama **item_user.xml**, lalu ketikan seperti berikut:
    ```
    <?xml version="1.0" encoding="utf-8"?>
    <androidx.cardview.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/cvUser"
        android:layout_width="match_parent"
        android:layout_height="180dp"
        android:layout_margin="12dp"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        app:cardElevation="12dp"
        app:cardCornerRadius="7dp">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            android:layout_margin="7dp"
            android:weightSum="6"
            android:gravity="center">

            <TextView
                android:id="@+id/tvId"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="@string/id_user"/>

            <TextView
                android:id="@+id/tvName"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="@string/name_user"/>

            <TextView
                android:id="@+id/tvUsername"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="@string/username_user"/>

            <TextView
                android:id="@+id/tvPhone"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="@string/phone_user"/>

            <TextView
                android:id="@+id/tvEmail"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="@string/email_user"/>

            <TextView
                android:id="@+id/tvWeb"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="@string/website_user"/>

        </LinearLayout>

    </androidx.cardview.widget.CardView>
    ```
    Jangan lupa untuk menambahkan string resource seperti berikut:
    ```
    <resources>
        <string name="app_name">CobaRetrofit</string>
        <string name="id_user">Id User</string>
        <string name="name_user">Name User</string>
        <string name="username_user">Username User</string>
        <string name="phone_user">Phone User</string>
        <string name="email_user">Email User</string>
        <string name="website_user">Website User</string>
    </resources>
    ```

12. Buat class UsersAdapter pada package ui yang telah dibuat pada poin 9, lalu isikan seperti berikut :
    ```
    class UserAdapter (
        private val context: Context,
        private val data: ArrayList<UserResponse>
    ): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
        class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val tvId = view.findViewById<TextView>(R.id.tvId)
            val tvName = view.findViewById<TextView>(R.id.tvName)
            val tvUsername = view.findViewById<TextView>(R.id.tvUsername)
            val tvPhone = view.findViewById<TextView>(R.id.tvPhone)
            val tvEmail = view.findViewById<TextView>(R.id.tvEmail)
            val tvWeb = view.findViewById<TextView>(R.id.tvWeb)
            val cvUser = view.findViewById<CardView>(R.id.cvUser)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val itemView = layoutInflater.inflate(R.layout.item_user, parent, false)

            return UserViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
            holder.tvId.text = data.get(position).id.toString()
            holder.tvName.text = data.get(position).name
            holder.tvUsername.text = data.get(position).username
            holder.tvPhone.text = data.get(position).phone
            holder.tvEmail.text = data.get(position).email
            holder.tvWeb.text = data.get(position).website
            holder.cvUser.setOnClickListener {
                Toast.makeText(context, "" + data.get(position).username, Toast.LENGTH_SHORT).show()
            }
        }

        override fun getItemCount(): Int = data.size

        fun setData(newData: ArrayList<UserResponse>) {
            data.clear()
            data.addAll(newData)
            notifyDataSetChanged()
        }
    }

13. Bagian selanjutnya adalah proses mengambil data dengan retrofit dan menampilkannya di MainActivity, ketikkan kodenya seperti berikut:
    ```
    class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding
        private lateinit var adapter: UserAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityMainBinding.inflate(layoutInflater)

            setContentView(binding.root)

            adapter = UserAdapter(this@MainActivity, arrayListOf())

            binding.rvUser.adapter = adapter
            binding.rvUser.setHasFixedSize(true)
            binding.rvUser.layoutManager = LinearLayoutManager(this)

            getUsers()
        }

        fun getUsers() {
            ApiConfig.apiService().getUsers().enqueue(object : Callback<ArrayList<UserResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<UserResponse>>,
                    response: Response<ArrayList<UserResponse>>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        data?.let {
                            setData(it)
                        }
                    }
                }

                override fun onFailure(call: Call<ArrayList<UserResponse>>, t: Throwable) {
                    Log.d("Error", "" + t.stackTraceToString())
                }
            })
        }

        fun setData(data: ArrayList<UserResponse>) {
            adapter.setData(data)
        }
    }
    ```

14. Jalankan aplikasi, maka akan terlihat seperti ini:
    ![alt text](asset/6.CobaRetrofit.gif)