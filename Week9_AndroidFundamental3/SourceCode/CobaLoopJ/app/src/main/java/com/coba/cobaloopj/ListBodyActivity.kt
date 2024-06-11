package com.coba.cobaloopj

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.coba.cobaloopj.databinding.ActivityListBodyBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray

// Activity untuk menampilkan daftar body dari API
class ListBodyActivity : AppCompatActivity() {

    companion object {
        private val TAG = ListBodyActivity::class.java.simpleName
    }
    private lateinit var binding: ActivityListBodyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBodyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur layout manager untuk RecyclerView
        val layoutManager = LinearLayoutManager(this)
        binding.listBody.setLayoutManager(layoutManager)

        // Menambahkan item decoration untuk RecyclerView
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.listBody.addItemDecoration(itemDecoration)

        // Memuat daftar body dari API
        getListBody()
    }

    // Memuat daftar body dari API menggunakan AsyncHttpClient
    private fun getListBody() {
        // Menampilkan progress bar
        binding.progressBar.visibility = View.VISIBLE

        // Membuat instance AsyncHttpClient
        val client = AsyncHttpClient()
        val url = "https://jsonplaceholder.typicode.com/posts"

        // Melakukan HTTP GET request
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
                // Jika koneksi berhasil
                binding.progressBar.visibility = View.INVISIBLE

                val listBody = ArrayList<String>()

                // Mengubah response menjadi string
                val result = String(responseBody)
                Log.d(TAG, result)

                // Mengolah JSON response
                try {
                    val jsonArray = JSONArray(result)
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val body = jsonObject.getString("body")
                        val title = jsonObject.getString("title")
                        listBody.add("\n$body\n — $title\n")
                    }

                    // Mengatur adapter untuk RecyclerView
                    val adapter = BodyAdapter(listBody)
                    binding.listBody.adapter = adapter
                } catch (e: Exception) {
                    // Menampilkan toast jika terjadi kesalahan
                    Toast.makeText(this@ListBodyActivity, e.message, Toast.LENGTH_SHORT).show()
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
                Toast.makeText(this@ListBodyActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}