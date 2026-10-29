# TRIV Mobile Automation Testing

## 1. Deskripsi Singkat Project

Project ini merupakan implementasi **Mobile Automation Testing** untuk aplikasi Android TRIV menggunakan Appium, Java, Maven, dan Cucumber dengan pendekatan Behavior-Driven Development (BDD).

Pengujian dilakukan untuk memvalidasi fungsi login dan registrasi, termasuk navigasi halaman, pengisian kredensial, serta penanganan login dengan kredensial tidak valid.

Test scenario ditulis menggunakan format Gherkin agar alur pengujian mudah dibaca dan dipahami oleh tim QA maupun tim pengembang.

### Tujuan Project
- Mengotomatisasi pengujian fungsional aplikasi Android TRIV.
- Memvalidasi navigasi dan elemen antarmuka aplikasi.
- Menguji perilaku login menggunakan kredensial valid dan tidak valid.
- Mendokumentasikan hasil pengujian, kendala, dan keterbatasan automation.

---

## 2. Daftar Tools dan Dependencies

### Tools

| Tools | Kegunaan |
| Java JDK 17 | Bahasa pemrograman untuk test automation |
| Apache Maven 3.10.0 | Mengelola dependencies dan menjalankan test |
| Appium 3.1.0 | Framework untuk mobile automation |
| Appium Inspector | Memeriksa elemen UI dan resource ID aplikasi |
| Cucumber | Menjalankan test scenario berbasis Gherkin |
| Android SDK | Mendukung komunikasi dan pengujian pada perangkat Android |
| UiAutomator2 | Automation driver untuk aplikasi Android |
| JUnit 4 | Menjalankan assertion dan mendukung eksekusi test |

### Dependencies Utama

| Dependency | Versi | Kegunaan |
| Appium Java Client | 9.4.0 | Menghubungkan Java dengan Appium |
| Selenium Java | 4.33.0 | Mengelola interaksi dan pencarian elemen UI |
| Cucumber Java | 7.20.1 | Mengimplementasikan step definition Cucumber |
| Cucumber JUnit | 7.20.1 | Mengintegrasikan Cucumber dengan JUnit |
| JUnit | 4.13.2 | Menjalankan assertion pada test |
| Maven Surefire Plugin | 3.5.2 | Menjalankan test melalui Maven |
| Maven Compiler Plugin | 3.13.0 | Mengompilasi kode Java |

Versi dependency mengikuti konfigurasi project yang digunakan selama pengerjaan.

---

## 3. Environment dan Versi Android

### Environment Pengujian

| Komponen | Detail |
| Sistem Operasi | Windows 11 |
| Bahasa Pemrograman | Java |
| Versi Java | 17.0.19 |
| Build Tool | Apache Maven 3.10.0 |
| Appium Server | 3.1.0 |
| Android Automation Driver | UiAutomator2 |
| Selenium | 4.33.0 |
| Perangkat Pengujian | Samsung Galaxy Tab A9 |
| Model Perangkat | SM-X115 |
| Android Version | Android 16 |
| Android API Level | 36 |
| Resolusi Layar | 800 × 1340 |
| App Package | `id.co.triv` |
| App Activity | `id.co.triv.main.splash.SplashActivity` |
| Appium Server URL | `http://127.0.0.1:4723/` |

### Konfigurasi Perangkat

Pengujian dilakukan menggunakan perangkat Android fisik yang terhubung dengan Appium melalui UiAutomator2.

Aplikasi yang diuji:
- Package: `id.co.triv`
- Activity awal: `id.co.triv.main.splash.SplashActivity`

---

## 4. Command untuk Menjalankan Test

Pastikan beberapa prasyarat berikut sudah terpenuhi:
1. Java JDK sudah terpasang.
2. Maven sudah terpasang dan dapat diakses melalui terminal.
3. Android SDK sudah dikonfigurasi.
4. Perangkat Android sudah terhubung dan terdeteksi.
5. Appium Server sedang berjalan.
6. Aplikasi TRIV sudah terpasang pada perangkat.

### Menjalankan Seluruh Test

Jalankan perintah berikut dari root project:

```bash
mvn test
```

### Menjalankan Test Berdasarkan Tag

**Menjalankan LOG-001 — Membuka halaman Login**

```bash
mvn test "-Dcucumber.filter.tags=@LOG-001"
```

**Menjalankan LOG-002 — Login dengan kredensial valid**

```bash
mvn test "-Dcucumber.filter.tags=@LOG-002"
```

**Menjalankan LOG-003 — Login dengan kredensial tidak valid**

```bash
mvn test "-Dcucumber.filter.tags=@LOG-003"
```

**Menjalankan REG-001 - membuka halaman register**

```bash
mvn test "-Dcucumber.filter.tags=@REG-001"
```

**Menjalankan REG-002 - melakukan test tidak mengisi field**

```bash
mvn test "-Dcucumber.filter.tags=@REG-002"
```

**Menjalankan REG-003 - melakukan input registrasi dengan data valid**

```bash
mvn test "-Dcucumber.filter.tags=@REG-003"
```


### Lokasi Hasil Pengujian

Hasil pengujian Maven dapat diperiksa pada direktori:

```text
target/surefire-reports/
```

Direktori tersebut berisi laporan hasil eksekusi test yang dapat digunakan untuk memeriksa skenario yang berhasil maupun gagal.

---

## 5. Daftar Skenario dan Status Pengujian

### A. Skenario Login

| Test Case ID | Skenario | Status | Keterangan |
| LOG-001 | Membuka halaman Login | PASS | Halaman Login berhasil dibuka dan divalidasi. |
| LOG-002 | Login menggunakan kredensial valid | PASS | Skenario sebelumnya berhasil dijalankan hingga tahap validasi instruksi OTP. |
| LOG-003 | Login menggunakan kredensial tidak valid | PASS | Popup `Credentials Don't Match`  berhasil dideteksi oleh automation. |

**Catatan status:**
- PASS: Skenario telah berhasil dijalankan dan assertion terpenuhi.
- FAIL: Skenario telah dijalankan, tetapi assertion tidak terpenuhi.
- BLOCKED: Skenario belum dapat dijalankan atau dilanjutkan karena terdapat kendala yang belum terselesaikan.

Status di atas mengikuti hasil pengujian yang diperoleh selama pengerjaan. Untuk laporan final, status dapat diperbarui berdasarkan eksekusi terbaru.

### B. Skenario Registrasi

| Test Case ID | Skenario | Status | Keterangan |
| REG-001 | Membuka halaman registrasi | PASS | Skenario sebelumnya berhasil dijalankan. |
| REG-002 | Mengisi form registrasi | PASS | Skenario sebelumnya telah dikerjakan; verifikasi akhir perlu mengikuti hasil eksekusi terakhir. |
| REG-003 | Melanjutkan registrasi hingga verifikasi email | PASS | Skenario sebelumnya mencapai halaman verifikasi email; status akhir mengikuti hasil eksekusi terakhir. |


---

## 6. Kendala dan Keterbatasan Pengerjaan

### 6.1 Popup Invalid Login Tidak Terdeteksi

**Kendala:**

Pada skenario LOG-003, automation gagal mendeteksi popup `Credentials Don't Match` setelah tombol Login diklik menggunakan kredensial tidak valid.

**Indikasi:**
- Popup dapat diamati melalui Appium Inspector.
- Resource ID judul popup teridentifikasi sebagai `id.co.triv:id/tv_title`.
- Assertion automation tetap gagal menemukan popup ketika test dijalankan.

**Langkah yang Sudah Dicoba:**
- Memeriksa elemen popup melalui Appium Inspector.
- Mencoba locator berdasarkan resource ID dan teks.
- Menambahkan explicit wait.
- Memeriksa kemungkinan perbedaan waktu kemunculan popup.

**Status:**  terselesaikan (*resolved*).


### 6.2 Waktu Tunggu Setelah Login Tidak Valid

**Kendala:**

Popup login tidak valid menampilkan hitung mundur sebelum pengguna dapat mencoba kembali.

**Indikasi:**

Pada screenshot Appium Inspector, aplikasi menampilkan pesan `Credentials Don't Match` beserta informasi waktu tunggu.

**Dampak terhadap Pengujian:**

Percobaan login berulang dapat dipengaruhi oleh kondisi aplikasi dan waktu tunggu tersebut.

**Status:** Teramati (*Observed*). Kesesuaian perilaku dengan spesifikasi aplikasi belum diverifikasi.

**Tindak Lanjut:**
- Memastikan perilaku waktu tunggu sesuai dengan requirement.
- Mempertimbangkan cooldown saat menjalankan test berulang.
- Memastikan kondisi aplikasi siap sebelum percobaan berikutnya.

### 6.3 Keterbatasan Pengujian

- Pengujian dilakukan pada satu perangkat Android fisik dengan Android 16.
- Kompatibilitas pada perangkat dan versi Android lain belum diverifikasi.
- Pengujian difokuskan pada alur fungsional login dan registrasi yang telah diimplementasikan.
- Hasil pengujian bergantung pada kondisi aplikasi, perangkat, jaringan, dan konfigurasi Appium ketika test dijalankan.


---

## Kesimpulan

Project TRIV Mobile Automation Testing telah mengimplementasikan pengujian fungsional berbasis Appium, Java, Maven, dan Cucumber.

Skenario yang telah dikerjakan mencakup pembukaan halaman Login, login menggunakan kredensial valid, login menggunakan kredensial tidak valid, serta alur registrasi.

Dokumentasi ini menjadi acuan untuk menjalankan test, mengevaluasi hasil pengujian, dan menindaklanjuti kendala yang ditemukan selama pengerjaan.




