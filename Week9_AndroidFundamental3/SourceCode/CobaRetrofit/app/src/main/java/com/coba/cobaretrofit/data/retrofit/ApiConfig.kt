import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Kelas untuk konfigurasi Retrofit dan OkHttpClient
class ApiConfig {
    companion object{
        // Mendapatkan instance ApiService dari Retrofit
        fun apiService(): ApiService {
            // Membuat interceptor untuk logging HTTP request dan response
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            // Membuat OkHttpClient dengan interceptor
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            // Membuat instance Retrofit dengan base URL dan converter factory Gson
            val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            // Mengembalikan instance ApiService dari Retrofit
            return retrofit.create(ApiService::class.java)
        }
    }
}