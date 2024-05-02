package com.coba.cobaloopj

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.coba.cobaloopj.databinding.ActivityMainBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

// Activity utama yang menampilkan body dan title dari post acak
class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Memuat body dan title dari post acak
        getRandomBody()

        // Menambahkan listener untuk tombol btnAllBody
        binding.btnAllBody.setOnClickListener {
            startActivity(Intent(this@MainActivity, ListBodyActivity::class.java))
        }
    }

    // Memuat body dan title dari post acak menggunakan AsyncHttpClient
    private fun getRandomBody() {
        // Menampilkan progress bar
        binding.progressBar.visibility = View.VISIBLE
        val client = AsyncHttpClient()

        // Membuat instance AsyncHttpClient
        val url = "https://jsonplaceholder.typicode.com/posts/1"

        // Melakukan HTTP GET request
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
                // Jika koneksi berhasil
                binding.progressBar.visibility = View.INVISIBLE

                // Mengubah response menjadi string
                val result = String(responseBody)
                Log.d(TAG, result)

                // Mengolah JSON response
                try {
                    val responseObject = JSONObject(result)
                    val body = responseObject.getString("body")
                    val title = responseObject.getString("title")

                    // Menampilkan body dan title pada TextView
                    binding.tvBody.text = title
                    binding.tvTitle.text = body
                } catch (e: Exception) {
                    // Menampilkan toast jika terjadi kesalahan
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            }
            override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
                // Jika koneksi gagal
                binding.progressBar.visibility = View.INVISIBLE

                // Menampilkan toast dengan pesan kesalahan
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error.message}"
                }
                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}