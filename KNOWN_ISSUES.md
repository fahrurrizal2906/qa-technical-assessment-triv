# Dokumentasi Kendala dan Batasan Pengujian

## 1. Popup Login dengan Kredensial Tidak Valid Tidak Terdeteksi oleh Automation

**Kendala:**

Pada skenario LOG-003 (Login dengan Kredensial Tidak Valid), automation gagal mendeteksi popup error dengan judul `Credentials Don't Match`.

**Skenario Terdampak:**
- LOG-003 — Login dengan Kredensial Tidak Valid

**Penyebab / Indikasi:**

Berdasarkan pemeriksaan menggunakan Appium Inspector, popup memiliki informasi berikut:
- Resource ID: `id.co.triv:id/tv_title`
- Teks: `Credentials Don't Match`

Namun, ketika skenario automation dijalankan, assertion gagal menemukan popup tersebut.

Penyebab pastinya belum dapat dipastikan. Kemungkinan penyebab meliputi locator yang tidak berhasil menemukan elemen, waktu tunggu yang belum sesuai, atau perbedaan kondisi antarmuka aplikasi ketika pengujian dijalankan.

**Langkah Penanganan yang Sudah Dicoba:**
- Memeriksa popup melalui Appium Inspector.
- Memeriksa resource ID dan teks judul popup.
- Mencoba pencarian elemen berdasarkan resource ID dan teks.
- Menambahkan explicit wait untuk menunggu popup muncul.
- Menambahkan metode invalid loginWithInvalidCredentials untuk memberi waktu aplikasi menampilkan popup invalid 

**Status Saat Ini:**
terselesaikan (*resolved*). 

**Bukti:**
- Screenshot Appium Inspector yang menunjukkan popup `Credentials Don't Match`.





