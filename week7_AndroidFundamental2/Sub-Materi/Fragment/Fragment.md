# Fragment

  Sebelum ke dasar teori dari materi ini, kalian bisa menonton video pengenalan Fragment di bawah ini.

-  [Pengenalan Fragment](https://youtu.be/5PBp6r3aZWU?si=F6CYhArN4nqMFoUU)

    Selain *Activity* terdapat *Fragment* sebagai salah satu bagian dari User Interface. Memiliki bentuk yang hampir mirip dengan *Activity*, yang mana *Fragment* ini memiliki class untuk menyimpan kode logika dan tampilan XML. Perbedaan antara kedua nya terletak pada kelasnya yang ***extends*** atau *inherit* ke Fragment dan tidak perlu dimasukkan ke dalam **AndroidManifest.xml** lagi.

    Fragment bersifat **modular** yang berarti satu activity bisa memiliki lebih dari satu fragment, sehingga tidak perlu repot-repot berpindah-pindah Activity lagi karena satu Activity tersebut dapat membuat banyak tampilan. Selain itu Fragment juga mempunyai sifat yang **reusable**, karena kita dapat memakai satu fragment dalam banyak Activity sekaligus. Untuk lebih jelasnya perhatikan gambar dibawah ini.

  ![analogi_fragment](assets/analogi_fragment.png)

-  *contoh penerapan fragment pada aplikasi Gmail di tablet*
  
  ![penerapan](assets/penerapan.png)

  List email dan detail email sama-sama memiliki fragment tersendiri. Kedua fragment tersebut dapat ditampilkan secara bersamaan pada satu Activity yang sama.

## Menambahkan Fragment

``` kotlin
val fragmentManager = supportFragmentManager
val exampleFragment = ExampleFragment()
 
fragmentManager
        .beginTransaction()
        .add(R.id.frame_container, exampleFragment)
        .addToBackStack(null)
        .commit()
```

FragmentManager adalah kelas yang bertanggung jawab untuk mengelola Fragment ke dalam Activity. Setelah menginisialisasi Fragment Manager, Anda bisa melakukan beberapa aksi terhadap Fragment seperti **add()**, **replace()**, dan **remove()**. Kemudian untuk mengaplikasikannya, Anda harus memanggil fungsi **commit()**. Sebelumnya, Anda dapat menambahkan kode **addToBackStack()** untuk menyimpan transaksi terakhir ke *back stack*.

*Back stack* dapat diilustrasikan seperti sebuah tumpukan buku, ketika melakukan transaksi seperti menambahkan buku baru di atasnya lalu menekan tombol back, maka buku yang paling atas diambil.

![back_stack](assets/back_stack.png)

Terdapat video tambahan yang menjelaskan mengenai penerapan *back stack* ini, dapat dilihat di bawah ini.

-  [Dissecting back stack](https://youtu.be/KzHvtS3B5zk?si=GqdFTSDptTDeLWcQ)

## Fragment Lifecycle
  Berikut ada beberapa state yang perlu diperhatikan sebelum menggunakan fragment.

-  **Resumed**
  Ketika Activity sedang berjalan, fragment dapat dilihat.

-  **Paused**
  Ketika ada activity lain yang menutupi sebagian dari activity dimana fragment ditambahkan.

-  **Stopped**
  Ketika fragment tidak terlihat di layar. Banyak faktor seperti, ketika activity dimana fragment tersebut ditambahkan berhenti atau fragment itu sendiri telah dihapus dari activity. Pada kondisi ini fragment masih hidup dengan semua informasinya. Akan tetapi sudah tidak kelihatan di layar dan akan dihancurkan.

Skema di bawah ini menunjukkan callback method apa saja yang akan dipanggil di dalam fragment ketika terjadi perubahan pada sebuah activity.
