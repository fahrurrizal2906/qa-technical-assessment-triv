# Dokumentasi Kendala dan Batasan Pengujian

## 1.  Kendala Otomasi Verifikasi OTP pada Login

**Status: Otomasi Sebagian**  
**Prioritas: Sedang**  
**Modul: Login**  
**Lingkungan Pengujian: Aplikasi Android TRIV**

###  Deskripsi Kendala

Proses otomasi pengujian login telah dikembangkan untuk menjalankan langkah-langkah awal menggunakan kredensial yang valid. Namun, aplikasi TRIV memerlukan verifikasi OTP sebelum pengguna dapat mengakses halaman utama (*homepage*).

Karena proyek ini dikembangkan untuk keperluan *technical assessment* dan belum tersedia akses ke layanan OTP khusus pengujian, akun pengujian khusus otomasi, atau mekanisme pengambilan OTP secara otomatis yang diizinkan, proses verifikasi OTP belum dapat dijalankan sepenuhnya secara otomatis.

###  Dampak terhadap Pengujian

- Proses login belum dapat diselesaikan secara otomatis hingga halaman utama.
- Keberhasilan navigasi menuju halaman utama belum dapat diverifikasi secara otomatis apabila proses OTP belum diselesaikan.
- Skenario pengujian login menggunakan kredensial valid masih berstatus otomasi sebagian.
- Pengujian yang bergantung pada keberhasilan login secara menyeluruh belum dapat dijalankan secara otomatis.

###  Solusi Sementara

1. Otomasi difokuskan pada langkah-langkah login yang dapat dijalankan dengan akses yang tersedia.
2. Proses verifikasi OTP didokumentasikan sebagai keterbatasan lingkungan pengujian. Apabila diperlukan, verifikasi OTP dapat dilakukan secara manual untuk melanjutkan pengujian.
3. Skenario login hanya dinyatakan berhasil apabila menampilkan halaman OTP dan OTP juga sudah terkirim di email User

### Rekomendasi Perbaikan

Untuk memungkinkan pengujian login secara menyeluruh (*end-to-end automation*), diperlukan dukungan dari tim pengembang atau pengelola aplikasi, antara lain:

1. Menyediakan akun khusus untuk pengujian otomasi.
2. Menyediakan mekanisme pengambilan OTP yang aman dan telah disetujui, misalnya layanan OTP khusus pengujian, kotak surat pengujian, atau API pengujian.
3. Menyediakan dokumentasi alur autentikasi untuk kebutuhan pengujian.
4. Memastikan mekanisme pengujian tetap mengikuti kebijakan keamanan aplikasi.

### Kesimpulan

- Keterbatasan ini disebabkan oleh belum tersedianya akses dan mekanisme OTP yang diperlukan untuk pengujian otomasi secara menyeluruh. Kondisi tersebut tidak serta-merta menunjukkan adanya cacat pada aplikasi.

- Pengembangan otomasi login hingga halaman utama dapat dilanjutkan apabila tersedia mekanisme OTP yang aman dan sesuai untuk lingkungan pengujian.

## 2. Kendala Otomasi Verifikasi Email pada Registrasi

**Status: Otomasi Sebagian**
**Prioritas: Sedang**
**Modul: Registrasi**
**Lingkungan Pengujian: Aplikasi Android TRIV**

### Deskripsi Kendala

Pada proses registrasi akun, aplikasi memerlukan verifikasi email untuk memastikan bahwa alamat email yang didaftarkan dapat diverifikasi sebelum proses registrasi dinyatakan selesai.

Dalam pengembangan otomasi untuk keperluan technical assessment, belum tersedia akses ke mekanisme pengambilan email verifikasi secara otomatis atau akun email khusus pengujian yang dapat digunakan untuk menyelesaikan proses tersebut.

Akibatnya, proses registrasi belum dapat dijalankan sepenuhnya secara otomatis hingga tahap verifikasi email selesai.

### Dampak terhadap Pengujian

- Proses registrasi belum dapat diselesaikan secara otomatis apabila verifikasi email masih diperlukan.
- Keberhasilan verifikasi email belum dapat dipastikan melalui otomasi.
- Pengujian alur registrasi secara menyeluruh hingga akun berhasil diverifikasi belum dapat dilakukan sepenuhnya.
- Skenario yang bergantung pada akun terverifikasi belum dapat dijalankan secara otomatis apabila akun tersebut belum tersedia.

### Solusi Sementara

1. Otomasi difokuskan pada langkah-langkah registrasi yang dapat dijalankan dengan akses yang tersedia.
2. Tahap verifikasi email didokumentasikan sebagai keterbatasan lingkungan pengujian. Apabila diperlukan, verifikasi dapat dilakukan secara manual untuk melanjutkan pengujian.
3. Status keberhasilan registrasi hanya diberikan apabila proses sudah meminta user untuk verifikasi email

### Rekomendasi Perbaikan

Untuk memungkinkan otomasi registrasi secara menyeluruh, diperlukan dukungan berikut:

1. Akun email khusus pengujian yang dapat diakses secara aman.
2. Mekanisme untuk mengambil email verifikasi secara otomatis, misalnya melalui layanan email pengujian atau API yang diizinkan.
3. Dokumentasi alur verifikasi email pada lingkungan pengujian.
4. Akun atau mekanisme pengujian yang memungkinkan skenario registrasi diulang tanpa mengganggu akun pengguna sebenarnya.

### Kesimpulan

- Keterbatasan otomasi registrasi disebabkan oleh belum tersedianya akses dan mekanisme yang diperlukan untuk menyelesaikan verifikasi email secara otomatis.

- Pengembangan otomasi hingga registrasi berhasil dan email terverifikasi dapat dilanjutkan apabila mekanisme pengujian yang sesuai telah tersedia.

## 3. Popup Login dengan Kredensial Tidak Valid Tidak Terdeteksi oleh Automation

**Status: SOlved**
**Prioritas: Sedang**
**Modul: Login**
**Lingkungan Pengujian: Aplikasi Android TRIV**

Pada skenario LOG-003 (Login dengan Kredensial Tidak Valid), automation gagal mendeteksi popup error dengan judul `Credentials Don't Match`.

## Skenario Terdampak:
- LOG-003 — Login dengan Kredensial Tidak Valid

## Penyebab / Indikasi:

Berdasarkan pemeriksaan menggunakan Appium Inspector, popup memiliki informasi berikut:
- Resource ID: `id.co.triv:id/tv_title`
- Teks: `Credentials Don't Match`

Namun, ketika skenario automation dijalankan, assertion gagal menemukan popup tersebut.

Penyebab pastinya belum dapat dipastikan. Kemungkinan penyebab meliputi locator yang tidak berhasil menemukan elemen, waktu tunggu yang belum sesuai, atau perbedaan kondisi antarmuka aplikasi ketika pengujian dijalankan.

## Langkah Penanganan yang Sudah Dicoba:
- Memeriksa popup melalui Appium Inspector.
- Memeriksa resource ID dan teks judul popup.
- Mencoba pencarian elemen berdasarkan resource ID dan teks.
- Menambahkan explicit wait untuk menunggu popup muncul.
- Menambahkan metode invalid loginWithInvalidCredentials untuk memberi waktu aplikasi menampilkan popup invalid 







