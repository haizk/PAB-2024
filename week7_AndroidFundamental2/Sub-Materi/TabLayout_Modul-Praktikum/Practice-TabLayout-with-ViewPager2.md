# TabLayout

***Pemahaman singkat mengenai Tab Layout***


  Tab Layout adalah salah satu bagian dari Android Design Support Library yang menyediakan UI untuk menavigasi antara beberapa tab dengan konten yang terkait dalam aplikasi Android. Dengan TabLayout, pengguna dapat dengan mudah beralih antara berbagai bagian atau fitur dalam aplikasi tanpa perlu meninggalkan tampilan utama. Setiap tab biasanya memiliki label yang deskriptif dan bisa memiliki ikon sebagai representasi visual dari konten yang terkait.

  TabLayout biasanya digunakan bersama dengan ViewPager, yang memungkinkan pengguna untuk menggeser antara tab atau dengan FragmentContainerView untuk menampilkan konten yang terkait dengan setiap tab. Berikut adalah beberapa kegunaan umum TabLayout dalam pengembangan aplikasi Android:

-  ***Navigasi antara bagian aplikasi***
-  ***Pengaturan***
-  ***Profil pengguna***

Untuk selengkapnya dapat dilihat dan belajar mandiri melalui tautan di bawah ini.

[Tab Layout](https://developer.android.com/reference/com/google/android/material/tabs/TabLayout)

## PRACTICE TAB LAYOUT WITH VIEWPAGER2

Pastikan bahwa kalian sudah menginstall Android Studio pada device kalian masing-masing yaa!

1. Kalian bisa Running Android Studio terlebih dahulu, maka akan menampilkan tampilan kurang lebih seperti ini. Kemudian, kalian bisa pilih New Project.

![1](assets/1.png)

2. Dikarenkakan kita hanya membuat basic project saja maka kalian bisa memilih yang Empty View Activity seperti biasa. Kemudian, bisa klik Next.

3. Maka, akan ditampilkan window seperti berikut ini. Untuk nama, Language, Minimum SDK, dan Build configuration language bisa mengikuti seperti pada gambar, sedangkan untuk package bisa disesuaikan dengan format berikut ini:


**com.nim.namapertama.tablayout**

![2](assets/2.png)

4. Kemudian, untuk save location bisa disesuaikan sesuai dengan path pada device masing-masing. Lalu bisa pilih Finish.

5. Pertama, tambahkan terlebih dahulu library ViewPager2 dan material design untuk membuat TabLayout. Silakan masuk ke build.gradle.kts(Module: app) dan tambahkan kode berikut:

6. Dimulai dengan menambahkan library ViewPager2 dan material design untuk membuat TabLayout. Silahkan ke **Gradle Scripts** →  **build.gradle.kts(Module: app)** dan tambahkan kode seperpti di bawah ini.

```kotlin
implementation("com.google.android.material:material:1.11.0") //jika belum ada
implementation("androidx.viewpager2:viewpager2:1.0.0")
```

//nyusul

Jangan lupa untuk **sync project** yang berada dipojok kanan atas agar library tersebut dapat berfungsi pada projek kalian.

7.  Setelah itu tambahkan *TabLayout* dan *viewPager2* ke **activity_main.xml** seperti kode di bawah ini.

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">
 
    <com.google.android.material.tabs.TabLayout
        android:id="@+id/tabs"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="?attr/colorPrimary"
        app:tabTextColor="@android:color/white"/>
    <androidx.viewpager2.widget.ViewPager2
        android:id="@+id/view_pager"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</LinearLayout>
```

8.  

9. 

