# PRACTICE SENDING DATA BETWEEN FRAGMENTS

Selanjutnya kita akan berpindah dari satu fragment ke fragment lain dengan membawa data.

1. Kita akan membuat di file yang sama, jadi silahkan buka file projek **flexibleFragment** kalian.

2. Dengan cara yang sama seperti sebelumnya, dengan klik kanan pada package utama pada proyek aplikasi Anda → **New → Fragment → Fragment (Blank).** Lalu kemudian buat fragment baru dengan nama **DetailCategoryFragment**.

![3](assets/3.png)

![8](assets/8.png)

3. Pada **fragmetn_detail_category_** sesuaikan kodenya menjadi seperti di bawah ini.
```kotlin
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">
 
    <TextView
        android:id="@+id/tv_category_name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="16dp"
        android:text="@string/category_name" />
    <TextView
        android:id="@+id/tv_category_description"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="16dp"
        android:text="@string/category_description" />
    <Button
        android:id="@+id/btn_profile"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/to_profile" />
    <Button
        android:id="@+id/btn_show_dialog"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/show_dialog" />
</LinearLayout>
```

4. Setelah selesai, silakan lengkapi kode pada DetailCategoryFragment. Pertama, tambahkan beberapa view, dan juga casting-nya.
```kotlin
class DetailCategoryFragment : Fragment(){
 
    private lateinit var tvCategoryName: TextView
    private lateinit var tvCategoryDescription: TextView
    private lateinit var btnProfile: Button
    private lateinit var btnShowDialog: Button
   
    ...
 
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvCategoryName = view.findViewById(R.id.tv_category_name)
        tvCategoryDescription = view.findViewById(R.id.tv_category_description)
        btnProfile = view.findViewById(R.id.btn_profile)
        btnShowDialog = view.findViewById(R.id.btn_show_dialog)
    }
}
```
Dan tambahkan beberapa variabel dan berikan aksi ketika button diklik.

```kotlin
class DetailCategoryFragment : Fragment() {
    ...
    var description: String? = null
    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESCRIPTION = "extra_description"
    }
    
    ...
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ...
        if (savedInstanceState != null) {
            val descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = descFromBundle
        }
        if (arguments != null) {
            val categoryName = arguments?.getString(EXTRA_NAME)
            tvCategoryName.text = categoryName
            tvCategoryDescription.text = description
        }
    }
}
```

Kode di atas akan mendemonstrasikan bagaimana melakukan penampilan data yang dikirim melalui perpindahan fragment. Sehingga **DetailCategoryFragment** menjadi seperti ini:


```kotlin
class DetailCategoryFragment : Fragment() {
 
    lateinit var tvCategoryName: TextView
    lateinit var tvCategoryDescription: TextView
    lateinit var btnProfile: Button
    lateinit var btnShowDialog: Button
    var description: String? = null
 
    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESCRIPTION = "extra_description"
    }
   
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }
 
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvCategoryName = view.findViewById(R.id.tv_category_name)
        tvCategoryDescription = view.findViewById(R.id.tv_category_description)
        btnProfile = view.findViewById(R.id.btn_profile)
        btnShowDialog = view.findViewById(R.id.btn_show_dialog)
 
        if (savedInstanceState != null) {
            val descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = descFromBundle
        }
 
        if (arguments != null) {
            val categoryName = arguments?.getString(EXTRA_NAME)
            tvCategoryName.text = categoryName
            tvCategoryDescription.text = description
        }
    }
}
```


5. Sekarang buka kembali CategoryFragment lalu tambahkan baris berikut pada method **onClick()**.


```kotlin
override fun onClick(v: View?) {
    if (v?.id == R.id.btn_detail_category) {
        val detailCategoryFragment = DetailCategoryFragment()
        val bundle = Bundle()
        bundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle")
        val description = "Kategori ini akan berisi produk-produk lifestyle"
        detailCategoryFragment.arguments = bundle
        detailCategoryFragment.description = description
        val fragmentManager = parentFragmentManager
        fragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_container, detailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            
        }
    }
}
```

Sehingga kode CategoryFragment kita sekarang menjadi:

```kotlin
class CategoryFragment : Fragment(), View.OnClickListener {
 
 
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }
 
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetailCategory:Button = view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener(this)
    }
 
    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_detail_category) {
            val detailCategoryFragment = DetailCategoryFragment()
 
            val bundle = Bundle()
            bundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle")
            val description = "Kategori ini akan berisi produk-produk lifestyle"
 
            detailCategoryFragment.arguments = bundle
            detailCategoryFragment.description = description
 
            val fragmentManager = parentFragmentManager
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_container, detailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}
```


6. Sekarang setelah selesai semua, silakan jalankan aplikasinya untuk melihat hasil kode yang di atas. Seharusnya ketika Anda mengklik tombol **Kategory Lifestyle** pada **CategoryFragment** akan ada data yang dikirimkan sewaktu perpindahan fragment itu melalui object bundle dan mekanisme metode setter and getter. Tampilan aplikasi Anda sekarang sudah menjadi seperti ini.

//nyusul
7. 
8. 



