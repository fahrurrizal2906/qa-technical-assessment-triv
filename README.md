# TRIV Mobile Automation

Proyek otomasi pengujian aplikasi Android TRIV menggunakan Java, Maven, Appium, Cucumber, JUnit, dan Allure Report.

Proyek ini menerapkan pendekatan *Behavior-Driven Development* (BDD) untuk menguji fungsionalitas login dan registrasi aplikasi TRIV. Hasil pengujian ditampilkan dalam laporan Cucumber dan Allure Report. Setiap skenario juga dilengkapi dengan rekaman video layar Android sebagai bukti pelaksanaan pengujian.

1. Gambaran Umum Proyek

Proyek ini dibuat untuk mengotomatisasi pengujian fungsional aplikasi Android TRIV.

Tujuan utama proyek ini adalah:

- Menguji fungsionalitas login dan registrasi aplikasi.
- Menulis skenario pengujian menggunakan Cucumber dan bahasa Gherkin.
- Mengotomatisasi interaksi aplikasi Android menggunakan Appium.
- Menghasilkan laporan hasil pengujian secara otomatis.
- Merekam aktivitas layar Android selama pelaksanaan skenario.
- Melampirkan rekaman video pada setiap skenario di Allure Report.
- Mempermudah analisis kegagalan pengujian melalui laporan dan bukti visual.

2. Teknologi yang Digunakan

| Teknologi | Versi | Fungsi |
| Java | 17 | Bahasa pemrograman |
| Maven | 3.10.0 | Mengelola dependensi dan proses pembangunan proyek |
| Appium Server | 3.1.0 | Menjalankan otomasi aplikasi Android |
| Appium Java Client | 9.4.0 | Menghubungkan Java dengan Appium |
| Selenium | 4.33.0 | Infrastruktur otomasi berbasis WebDriver |
| Cucumber | 7.20.1 | Menjalankan pengujian berbasis BDD |
| JUnit | 4.13.2 | Kerangka kerja pengujian |
| Maven Surefire | 3.5.2 | Menjalankan pengujian melalui Maven |
| Allure Commandline | 2.34.1 | Membuat dan membuka laporan pengujian interaktif |

3. Persyaratan Sistem

Pastikan perangkat dan aplikasi berikut tersedia sebelum menjalankan pengujian:

1. Java JDK 17.
2. Apache Maven.
3. Node.js dan npm.
4. Appium Server 3.1.0.
5. Driver UiAutomator2 untuk Appium.
6. Android SDK dan Android Platform Tools.
7. Perangkat Android atau emulator.
8. Aplikasi TRIV yang sudah terpasang pada perangkat.
9. Allure Commandline 2.34.1.

Periksa instalasi melalui terminal PowerShell:

```powershell
java -version
mvn -version
node --version
npm --version
appium --version
allure --version
adb devices
```

Perangkat Android harus terdeteksi oleh ADB sebelum pengujian dijalankan.

4. Struktur Proyek

```text
triv-mobile-automation/
├── pom.xml
├── README.md
├── KNOWN_ISSUES.md
├── allure-results/
├── src/
│   └── test/
│       ├── java/
│       │   └── id/
│       │       └── triv/
│       │           ├── config/
│       │           │   └── DriverFactory.java
│       │           ├── hooks/
│       │           │   └── Hooks.java
│       │           ├── pages/
│       │           │   ├── LoginPage.java
│       │           │   └── RegisterPage.java
│       │           ├── runners/
│       │           │   └── RunCucumberTest.java
│       │           └── steps/
│       │               ├── AppCommonSteps.java
│       │               ├── LoginSteps.java
│       │               └── RegisterSteps.java
│       └── resources/
│           └── features/
│               ├── login.feature
│               └── register.feature
└── target/
    └── cucumber-reports/
```

5. Komponen Utama

- **DriverFactory.java** — Membuat, mengonfigurasi, dan mengakhiri sesi Appium.
- **Hooks.java** — Mengelola persiapan dan penyelesaian setiap skenario, termasuk perekaman video dan lampiran Allure.
- **Pages** — Menyimpan objek halaman dan metode interaksi dengan aplikasi.
- **Steps** — Berisi implementasi langkah-langkah pengujian Cucumber.
- **Features** — Menyimpan skenario pengujian menggunakan bahasa Gherkin.
- **RunCucumberTest.java** — Mengatur konfigurasi runner Cucumber dengan JUnit.
- **allure-results/** — Menyimpan data hasil pengujian dan lampiran yang digunakan untuk membuat Allure Report.

Folder laporan dan hasil pengujian dibuat selama proses eksekusi.

6. Konfigurasi Lingkungan

 6.1. Mengunduh Proyek

Jalankan perintah berikut:

```powershell
git clone https://github.com/fahrurrizal2906/qa-technical-assessment-triv.git
cd qa-technical-assessment-triv
```

6.2. Memasang Driver UiAutomator2

Jika driver belum terpasang, jalankan:

```powershell
appium driver install uiautomator2
```

Periksa driver yang sudah terpasang:

```powershell
appium driver list --installed
```

6.3. Menghubungkan Perangkat Android

Hubungkan perangkat Android melalui USB dan aktifkan *USB debugging*.

Periksa koneksi perangkat:

```powershell
adb devices
```

Perangkat yang terhubung seharusnya muncul pada daftar hasil perintah tersebut.

Konfigurasi bawaan proyek saat ini:

| Pengaturan | Nilai |
| URL server Appium | `http://127.0.0.1:4723/` |
| Nama perangkat | `R9RXB01MV5Z` |
| Paket aplikasi | `id.co.triv` |
| Aktivitas aplikasi | `id.co.triv.main.splash.SplashActivity` |
| Mesin otomasi | `UiAutomator2` |

Sesuaikan nilai tersebut jika perangkat atau konfigurasi aplikasi berubah.

6.4. Menjalankan Appium Server

Buka terminal terpisah dan jalankan:

```powershell
appium
```

Biarkan server Appium tetap berjalan selama proses pengujian.

6.5. Memeriksa Kompilasi Proyek

Buka terminal pada direktori utama proyek, kemudian jalankan:

```powershell
mvn clean test-compile
```

Perintah ini membersihkan hasil pembangunan sebelumnya dan mengompilasi kode pengujian tanpa menjalankan skenario.

7. Menjalankan Pengujian

7.1. Menjalankan Semua Skenario

```powershell
mvn test
```



7.2. Menjalankan Pengujian Login

```powershell
mvn test "-Dcucumber.filter.tags=@login"
```

7.3. Menjalankan Pengujian Registrasi

```powershell
mvn test "-Dcucumber.filter.tags=@register"
```

Perintah tersebut bergantung pada tag yang tersedia di dalam file fitur.

7.4. Membersihkan dan Menjalankan Pengujian

```powershell
mvn clean test
```

**Catatan:** Perintah `mvn clean` menghapus direktori `target` sebelum pengujian dijalankan. Akibatnya, laporan Cucumber dan artefak pembangunan yang sebelumnya berada di dalam direktori tersebut akan terhapus.

8. Generate laporan menggunakan Allure Report

Allure Report menyediakan tampilan interaktif untuk menganalisis hasil pengujian.

Informasi yang ditampilkan meliputi:

- Ringkasan hasil pengujian.
- Jumlah skenario berhasil, gagal, atau dilewati.
- Nama skenario dan tag pengujian.
- Durasi pelaksanaan.
- Detail langkah dan status setiap langkah.
- Lampiran pendukung, termasuk rekaman video.

8.1. Membuat Laporan Allure

Setelah pengujian selesai, jalankan:

```powershell
allure generate .\allure-results --clean -o .\allure-report
```

Keterangan:

- `allure-results` merupakan direktori sumber yang berisi data hasil pengujian.
- `--clean` membersihkan laporan lama pada direktori keluaran sebelum membuat laporan baru.
- `-o .\allure-report` menentukan lokasi penyimpanan laporan HTML.

Perintah ini tidak menghapus data sumber di dalam `allure-results`.

8.2. Membuka Laporan

Jalankan:

```powershell
allure open .\allure-report
```

Allure akan menjalankan server lokal dan membuka laporan pada browser.

8.3. Memeriksa Hasil Pengujian

1. Buka menu **Suites**.
2. Pilih fitur atau skenario yang ingin diperiksa.
3. Periksa status dan detail langkah pengujian.
4. Buka lampiran yang tersedia untuk melihat bukti pengujian.

8.4. Alur Pembuatan Laporan

```text
Menjalankan Pengujian Maven
             |
             v
Eksekusi Skenario Cucumber
             |
             v
Data Hasil Pengujian Allure
             |
             v
       allure-results/
             |
             v
       allure generate
             |
             v
Laporan HTML Interaktif
```

8.5. Rekaman Video Pengujian

Proyek ini menggunakan fitur perekaman layar Appium untuk menangkap aktivitas layar Android selama setiap skenario Cucumber.

Proses perekaman dikelola oleh `Hooks.java`.

8.6. Alur Perekaman

1. Hook `@Before` membuat sesi Appium.
2. Appium memulai perekaman layar Android.
3. Skenario pengujian dijalankan.
4. Hook `@After` menghentikan perekaman.
5. Data video hasil perekaman didekode dari Base64.
6. Video dilampirkan ke Allure menggunakan tipe media `video/mp4`.
7. Sesi Appium diakhiri.

8.7. Cara Melihat Video

Setelah pengujian selesai:

1. Buat laporan menggunakan perintah `allure generate`.
2. Buka laporan menggunakan `allure open`.
3. Pilih skenario yang ingin diperiksa.
4. Cari lampiran bernama `Video Recording - <nama skenario>`.
5. Buka lampiran untuk melihat rekaman pengujian.

Video dilampirkan untuk setiap skenario selama proses perekaman dan pelampiran berhasil.

9. Hal yang Perlu Diperhatikan

- Appium Server dan perangkat Android harus tetap terhubung selama pengujian.
- Perekaman video menambah penggunaan sumber daya dan ukuran laporan.
- Perekaman dapat gagal jika sesi Appium berakhir secara tidak terduga atau perangkat terputus.
- `DriverFactory.java` saat ini memiliki jeda 15 detik setelah sesi Appium dibuat. Karena perekaman dimulai setelah inisialisasi driver selesai, aktivitas selama jeda tersebut tidak ikut terekam.
- Lampiran video berukuran besar dapat meningkatkan ukuran laporan Allure.

10. Daftar Skenario Pengujian

File fitur yang tersedia mencakup alur login dan registrasi aplikasi TRIV.

10.1. Pengujian Login

| Test Case ID | Skenario | Status | Keterangan | | LOG-001 | Membuka halaman Login | PASS | Halaman Login berhasil dibuka dan divalidasi. | | LOG-002 | Login menggunakan kredensial valid | PASS | Skenario sebelumnya berhasil dijalankan hingga tahap validasi instruksi OTP. | | LOG-003 | Login menggunakan kredensial tidak valid | PASS | Popup Credentials Don't Match berhasil dideteksi oleh automation. |

Catatan status:

PASS: Skenario telah berhasil dijalankan dan assertion terpenuhi.
FAIL: Skenario telah dijalankan, tetapi assertion tidak terpenuhi.
BLOCKED: Skenario belum dapat dijalankan atau dilanjutkan karena terdapat kendala yang belum terselesaikan.
Status di atas mengikuti hasil pengujian yang diperoleh selama pengerjaan. Untuk laporan final, status dapat diperbarui berdasarkan eksekusi terbaru.

10.2.  Pengujian Registrasi

| Test Case ID | Skenario | Status | Keterangan | | REG-001 | Membuka halaman registrasi | PASS | Skenario sebelumnya berhasil dijalankan. | | REG-002 | Mengisi form registrasi | PASS | Skenario sebelumnya telah dikerjakan; verifikasi akhir perlu mengikuti hasil eksekusi terakhir. | | REG-003 | Melanjutkan registrasi hingga verifikasi email | PASS | Skenario sebelumnya mencapai halaman verifikasi email; status akhir mengikuti hasil eksekusi terakhir. |

11. Pemecahan Masalah

11.1. Perangkat Android Tidak Terdeteksi

Jalankan:

```powershell
adb devices
```

Pastikan perangkat terhubung dan USB debugging telah diaktifkan.

Periksa juga konfigurasi nama perangkat di `DriverFactory.java`.

11.2. Kompilasi Maven Gagal

Jalankan:

```powershell
mvn test-compile
```

Periksa pesan kesalahan pertama pada terminal. Pastikan dependensi di `pom.xml` dan import pada kode Java sudah benar.

11.3.  Data Hasil Pengujian Allure Tidak Ditemukan

Periksa apakah direktori hasil pengujian tersedia:

```powershell
Test-Path .\allure-results
```

Tampilkan isinya:

```powershell
Get-ChildItem .\allure-results
```

Setelah pengujian berjalan, direktori tersebut seharusnya berisi berkas hasil Allure.

Jika direktori tidak ditemukan atau kosong, periksa konfigurasi plugin Cucumber Allure pada `RunCucumberTest.java`, lalu jalankan kembali pengujian.

11.4. Laporan Allure Tidak Menampilkan Hasil Terbaru

Buat ulang laporan setelah pengujian selesai:

```powershell
allure generate .\allure-results --clean -o .\allure-report
```

Kemudian buka kembali:

```powershell
allure open .\allure-report
```

11.5.  Video Tidak Muncul di Laporan

Periksa output Maven dan cari pesan berikut:

```text
INFO: Video recording dimulai.
SUCCESS: Video dilampirkan ke Allure untuk: <nama skenario>
```

Jika terdapat pesan peringatan, periksa hal-hal berikut:

- Sesi Appium masih aktif.
- Perangkat Android tetap terhubung.
- Driver mendukung perekaman layar.
- Hook `@After` berhasil dijalankan.
- Lampiran video tersedia pada data hasil Allure.

11.6. Pembuatan Laporan Gagal

Pastikan Allure CLI terpasang:

```powershell
allure --version
```

Kemudian periksa direktori hasil pengujian:

```powershell
Get-ChildItem .\allure-results
```

12. Kendala dan Keterbatasan Pengerjaan

12.1.  Popup Invalid Login Tidak Terdeteksi
Kendala:

Pada skenario LOG-003, automation gagal mendeteksi popup Credentials Don't Match setelah tombol Login diklik menggunakan kredensial tidak valid.

Indikasi:

Popup dapat diamati melalui Appium Inspector.
Resource ID judul popup teridentifikasi sebagai id.co.triv:id/tv_title.
Assertion automation tetap gagal menemukan popup ketika test dijalankan.
Langkah yang Sudah Dicoba:

Memeriksa elemen popup melalui Appium Inspector.
Mencoba locator berdasarkan resource ID dan teks.
Menambahkan explicit wait.
Memeriksa kemungkinan perbedaan waktu kemunculan popup.
Status: terselesaikan (resolved).

12.2 Waktu Tunggu Setelah Login Tidak Valid
Kendala:

Popup login tidak valid menampilkan hitung mundur sebelum pengguna dapat mencoba kembali.

Indikasi:

Pada screenshot Appium Inspector, aplikasi menampilkan pesan Credentials Don't Match beserta informasi waktu tunggu.

Dampak terhadap Pengujian:

Percobaan login berulang dapat dipengaruhi oleh kondisi aplikasi dan waktu tunggu tersebut.

Status: Teramati (Observed). Kesesuaian perilaku dengan spesifikasi aplikasi belum diverifikasi.

Tindak Lanjut:

Memastikan perilaku waktu tunggu sesuai dengan requirement.
Mempertimbangkan cooldown saat menjalankan test berulang.
Memastikan kondisi aplikasi siap sebelum percobaan berikutnya.

12.3.  Keterbatasan Pengujian
Pengujian dilakukan pada satu perangkat Android fisik dengan Android 16.
Kompatibilitas pada perangkat dan versi Android lain belum diverifikasi.
Pengujian difokuskan pada alur fungsional login dan registrasi yang telah diimplementasikan.
Hasil pengujian bergantung pada kondisi aplikasi, perangkat, jaringan, dan konfigurasi Appium ketika test dijalankan.

Kesimpulan

Proyek TRIV Mobile Automation merupakan implementasi otomasi pengujian aplikasi Android menggunakan Java, Maven, Appium, Cucumber, dan JUnit dengan pendekatan Behavior-Driven Development (BDD).

Proyek ini dikembangkan untuk menguji fungsionalitas login dan registrasi secara otomatis, sehingga proses pengujian dapat dilakukan dengan lebih terstruktur, konsisten, dan mudah dievaluasi.

Integrasi Allure Report meningkatkan kemudahan analisis hasil pengujian melalui laporan interaktif yang menampilkan status skenario, detail langkah pengujian, durasi eksekusi, serta lampiran bukti pengujian. Selain itu, integrasi fitur video recording dari Appium memungkinkan aktivitas layar perangkat Android direkam selama setiap skenario dan dilampirkan langsung ke laporan Allure.

Dengan kombinasi otomasi pengujian, pelaporan interaktif, dan bukti visual, proyek ini diharapkan dapat membantu proses regression testing, mempercepat identifikasi kegagalan, serta meningkatkan efektivitas dokumentasi dan analisis hasil pengujian aplikasi TRIV.

Pengembangan selanjutnya dapat mencakup penambahan skenario pengujian untuk fitur lain, peningkatan stabilitas otomasi, pengelolaan kredensial pengujian yang lebih aman, serta integrasi dengan pipeline CI/CD agar pengujian dapat dijalankan secara otomatis.



