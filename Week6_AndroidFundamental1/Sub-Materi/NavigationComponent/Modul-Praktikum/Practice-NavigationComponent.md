# NAVIGATION COMPONENT PRACTICE

## Membuat Project Android Studio

Pastikan bahwa kalian sudah menginstall Android Studio pada device kalian masing-masing yaa!

1. Kalian bisa **Running** Android Studio terlebih dahulu, maka akan menampilkan tampilan kurang lebih seperti ini. Kemudian, kalian bisa pilih **New Project**.

    ![alt text](assets/Membuat-Project-Android/1.png)

2. Kemudian, ditampilkan seperti di bawah ini. Dikarenkakan kita hanya membuat **basic project** saja maka kalian bisa memilih yang **Empty View Activity**. Kemudian, bisa klik **Next**.

    ![alt text](assets/Membuat-Project-Android/2.png)

3. Maka, akan ditampilkan window seperti berikut ini. Untuk **nama**, **Language**, **Minimum SDK**, dan **Build configuration language** bisa mengikuti seperti pada gambar, sedangkan untuk package bisa disesuaikan dengan format berikut ini: 

    **com.nim.2namapertama.beamvolume**.

4. Kemudian, untuk save location bisa disesuaikan sesuai dengan path pada device masing-masing. Lalu bisa pilih **Finish**.

    ![alt text](assets/Membuat-Project-Android/3.png)

5. Jika sudah, **tunggu build.gradles hingga selesai** dan tampilannya akan menjadi seperti ini.

    ![alt text](assets/Membuat-Project-Android/4.png)

6. 

```kotlin
[versions]
...
navigation = "2.7.7"

[libraries]
...
androidx-fragment-navigation = {group = "androidx.navigation", name = "navigation-fragment", version.ref = "ktx"}
androidx-ui-navigation = {group = "androidx.navigation", name = "navigation-ui", version.ref="ktx"}
```
sehingga menjadi

```kotlin
[versions]
agp = "8.3.1"
kotlin = "1.9.0"
coreKtx = "1.12.0"
junit = "4.13.2"
junitVersion = "1.1.5"
espressoCore = "3.5.1"
appcompat = "1.6.1"
material = "1.11.0"
activity = "1.8.0"
constraintlayout = "2.1.4"
navigation = "2.7.7" // version libraries yang ditambahkan

[libraries]
androidx-core-ktx = { group = "androidx.core", name = "core-ktx", version.ref = "coreKtx" }
junit = { group = "junit", name = "junit", version.ref = "junit" }
androidx-junit = { group = "androidx.test.ext", name = "junit", version.ref = "junitVersion" }
androidx-espresso-core = { group = "androidx.test.espresso", name = "espresso-core", version.ref = "espressoCore" }
androidx-appcompat = { group = "androidx.appcompat", name = "appcompat", version.ref = "appcompat" }
material = { group = "com.google.android.material", name = "material", version.ref = "material" }
androidx-activity = { group = "androidx.activity", name = "activity", version.ref = "activity" }
androidx-constraintlayout = { group = "androidx.constraintlayout", name = "constraintlayout", version.ref = "constraintlayout" }
// <-- Libraries yang ditambahkan -->
androidx-fragment-navigation = {group = "androidx.navigation", name = "navigation-fragment", version.ref = "ktx"}
androidx-ui-navigation = {group = "androidx.navigation", name = "navigation-ui", version.ref="ktx"}
// <-- end -->

[plugins]
androidApplication = { id = "com.android.application", version.ref = "agp" }
jetbrainsKotlinAndroid = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }

```