# Cara Instalasi Kotlin di Windows

Berikut adalah _step-by-step_ melakukan instalasi compiler Kotlin di Windows.

## Requirement 

Telah menginstall JDK pada laptop/PC yang akan digunakan. Untuk mengeceknya, dapat menjalankan perintah berikut pada Command Prompt.
```
java --version
```

## Instalasi Kotlin pada Windows

### 1. Download compiler Kotlin pada link berikut
https://github.com/JetBrains/kotlin/releases/tag/v1.9.22

Note : Download file yang bernama **kotlin-compiler-1.9.22.zip**

### 2. Extract File

Extract file yang telah didownload dan letakkan pada **Drive C**.

### 3. Copy path "/bin" pada file yang telah diextract

Pada file yang telah diextract, buka folder **"kotlinc"**.

![Open Folder kotlinc](https://github.com/haizk/PAB-2024/blob/95176891a6f3e2a9ea14883149f0d9af816076f9/Instalasi%20Kotlin/Helper/open%20folder%20kotlinc.png)

Kemudian, pilih folder **"bin"** dan _copy path_ dari folder tersebut seperti gambar di bawah ini.

![Copy path folder bin](https://github.com/haizk/PAB-2024/blob/95176891a6f3e2a9ea14883149f0d9af816076f9/Instalasi%20Kotlin/Helper/open%20and%20copy%20folder%20bin.png)

### 4. Edit System Environtment Variables

Cari "edit system environtment variables" pada bagian search, kemudian klik hasil seperti pada gambar berikut.

![Search Edit System Environtment Variables](https://github.com/haizk/PAB-2024/blob/95176891a6f3e2a9ea14883149f0d9af816076f9/Instalasi%20Kotlin/Helper/edit%20system%20env.png)

**Link Tutorial Video Edit Env : [Klik untuk melihat video](https://drive.google.com/file/d/1guKIIDazd1JRT6X4MKUO3EKjK0uBL5pm/view?usp=sharing)**

Lalu, klik **"Environtment Variables"** dan fokus pada bagian **"System Variables"**.

Cari variable yang bernama **"Path"**, kemudian klik. Lalu klik **"Edit"**. 

Klik tombol **"New"** pada bagian kanan Tab, lalu paste atau tempelkan **_path_ dari folder bin** yang telah di-copy sebelumnya. Klik **"OK"** pada semua Tab yang telah terbuka.

### 5. Cek Kotlin yang telah terinstall

Untuk mengecek apakah compiler Kotlin telah berhasil terinstall, jalankan perintah ini pada Command Prompt.

```
kotlinc
```

Jika compiler Kotlin telah berhasil terinstall, maka Command Prompt akan menampilkan text seperti gambar berikut 
![Kotlin Compiler Installed](https://github.com/haizk/PAB-2024/blob/95176891a6f3e2a9ea14883149f0d9af816076f9/Instalasi%20Kotlin/Helper/kotlin%20installed.png)

<br/>
<br/>

## Install Extensions pada Visual Studio Code (VS Code)

### 1. Buka aplikasi VS Code lalu buka menu **"Extensions"**

![Open Extensions in VS Code](https://github.com/haizk/PAB-2024/blob/95176891a6f3e2a9ea14883149f0d9af816076f9/Instalasi%20Kotlin/Helper/open%20extension%20vscode.png)

### 2. Ketik **"Kotlin"** pada Search Bar

![Search kotlin extension](https://github.com/haizk/PAB-2024/blob/95176891a6f3e2a9ea14883149f0d9af816076f9/Instalasi%20Kotlin/Helper/kotlin%20extension%20in%20vs%20code.png)

Kita akan menginstall dua _extension_ teratas dari hasil pencarian tersebut.

### 3. Buka _extension_ **"Kotlin"** dan _install_

![Install Kotlin Extension](https://github.com/haizk/PAB-2024/blob/95176891a6f3e2a9ea14883149f0d9af816076f9/Instalasi%20Kotlin/Helper/install%20kotlin%20extension.png)

### 4. Buka _extension_ **"Kotlin Language"** dan _install_

![Install Kotlin Language Extension](https://github.com/haizk/PAB-2024/blob/95176891a6f3e2a9ea14883149f0d9af816076f9/Instalasi%20Kotlin/Helper/install%20kotlin%20language%20extension.png)

### 5. Ketik **"Code Runner"** pada Search Bar

![Search code runner extension](https://github.com/haizk/PAB-2024/blob/95176891a6f3e2a9ea14883149f0d9af816076f9/Instalasi%20Kotlin/Helper/search%20code%20runner.png)

Kita akan menginstall _extension_ yang paling atas yaitu **Code Runner**

Kita akan menginstall dua _extension_ teratas dari hasil pencarian tersebut.

### 6. Buka _extension_ **"Code Runner"** dan _install_

![Install Kotlin Extension](https://github.com/haizk/PAB-2024/blob/95176891a6f3e2a9ea14883149f0d9af816076f9/Instalasi%20Kotlin/Helper/install%20code%20runner.png)

### 7. Klik icon Gear dan klik **"Extension Settings"**

![Extension Setting Code Runner](https://github.com/haizk/PAB-2024/blob/95176891a6f3e2a9ea14883149f0d9af816076f9/Instalasi%20Kotlin/Helper/open%20extension%20settings%20code%20runner.png)

### 8. Scroll ke bawah dan cari **"Run In Terminal"**

![Code Runner Run In Terminal Checklist](https://github.com/haizk/PAB-2024/blob/95176891a6f3e2a9ea14883149f0d9af816076f9/Instalasi%20Kotlin/Helper/checklist%20bagian%20run%20in%20terminal.png)

Checklist bagian tersebut.

<br/>
<br/>

## Run File Kotlin

Buatlah sebuah file Kotlin dengan _extension_ **.kt**, lalu ketikkan kode berikut
```kotlin
fun main(){
    println("Hello World!")
}
```

Pada bagian pojok kanan atas, terdapat tombol _run_. Coba jalankan kode yang diatas.

Jika berhasil, maka tampilan VS Code akan menjadi seperti pada gambar di bawah ini

![Run Kotlin Succeed](https://github.com/haizk/PAB-2024/blob/95176891a6f3e2a9ea14883149f0d9af816076f9/Instalasi%20Kotlin/Helper/coba%20run%20kotlin.png)

**Hasil**
```powershell
PS C:\Users\putri> cd "c:\Users\putri\Downloads\" ; if ($?) { kotlinc coba.kt -include-runtime -d coba.jar } ; if ($?) { java -jar coba.jar }
Hello World!
PS C:\Users\putri\Downloads> 
```

<br/>
<br/>

## FAQ (Frequently Asked Questions)

### Muncul error **"Class Not Found"** saat menjalankan perintah "kotlinc"

```
Java HotSpot(TM) 64-Bit Server VM warning: Options -Xverify:none and -noverify were deprecated in JDK 13 and will likely be removed in a future release.
Error: Could not find or load main class org.jetbrains.kotlin.preloading.Preloader
Caused by: java.lang.ClassNotFoundException: org.jetbrains.kotlin.preloading.Preloader
```

Hal ini dapat terjadi karena letak file yang telah diextract terdapat pada selain **Drive C**. Pastikan Anda melakukan **ekstraksi file zip** Kotlin compiler pada **Drive C**.

### Tidak dapat menjalankan file Kotlin pada Terminal

Untuk kasus ini, Anda dapat mencoba beberapa step berikut:

1. Pastikan "Run In Terminal" pada Extension Settings di Code Runner sudah ter-_checklist_.
2. Coba tutup VS Code Anda, lalu buka kembali. _Allow_ atau setujui semua _alert_/notifikasi yang muncul, khususnya terkait penginstalan (Kotlin Debugger atau semacamnya).
3. Coba jalankan file Kotlin Anda kembali.

Jika cara tersebut masih tidak berhasil, coba untuk copy perintah pada terminal VS Code dan jalankan pada Windows Powershell Anda. 

Contoh perintah yang dimaksud : 
```powershell
cd "c:\Users\putri\Downloads\" ; if ($?) { kotlinc coba.kt -include-runtime -d coba.jar } ; if ($?) { java -jar coba.jar }
```


Jika masih terdapat kesulitan dalam instalasi Kotlin, silahkan hubungi salah satu Asisten Praktikum di kelas Anda.
