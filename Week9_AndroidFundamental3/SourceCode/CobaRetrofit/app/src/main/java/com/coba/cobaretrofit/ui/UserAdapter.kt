import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.coba.cobaretrofit.R
import com.coba.cobaretrofit.data.response.UserResponse

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