import com.coba.cobaretrofit.data.response.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("users")
    fun getUsers(): Call<ArrayList<UserResponse>>
}