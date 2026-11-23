# LATIHAN-GUI_F1D02410057# Toko Bunga (Java Swing)

Aplikasi GUI sederhana untuk memilih bunga, memasukkannya ke keranjang, dan menghitung total belanja.
Dibuat dengan Java Swing, hanya memakai tiga import:

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
```

## Fitur

- Memilih bunga dari katalog (Mawar, Melati, Tulip, Anggrek, Matahari, Lily)
- Mengatur jumlah tangkai dengan spinner
- Bunga yang sama otomatis digabung di keranjang (jumlahnya bertambah)
- Total harga dihitung otomatis
- Tombol **Bayar** menampilkan total lalu mengosongkan keranjang
- Tombol **Kosongkan** menghapus semua isi keranjang
- Tombol berubah warna saat disorot mouse

## Struktur file

| File | Peran |
|---|---|
| `Mulai.java` | Class utama, hanya berisi method `main` |
| `JendelaUtama.java` | Top-level Container (`extends JFrame`) |
| `PanelKatalog.java` | Intermediate Container (`extends JPanel`), tombol bunga dan input jumlah |
| `PanelKeranjang.java` | Intermediate Container (`extends JPanel`), daftar belanjaan, total, tombol Bayar dan Kosongkan |
| `Keranjang.java` | Model: `Keranjang` (public), `Bunga`, dan `ItemBelanja` |

## Komponen GUI

| Kategori | Class yang dipakai |
|---|---|
| Top-level Container | `JFrame` (`JendelaUtama`) |
| Intermediate Container | `JPanel` (`PanelKatalog`, `PanelKeranjang`, serta panel kecil di dalamnya) |
| Atomic Component | `JLabel`, `JButton`, `JSpinner`, `JList` |
| Layout | `BorderLayout`, `GridLayout`, `FlowLayout` |
| Event Listener | `ActionListener` (interface), `MouseAdapter` (adapter class) |

## Layout yang dipakai

| Lokasi | Layout |
|---|---|
| `JendelaUtama` (frame) | `BorderLayout` |
| `JendelaUtama` (panel tengah) | `GridLayout` 1 baris, 2 kolom |
| `PanelKatalog` (tombol bunga) | `GridLayout` 3 baris, 2 kolom |
| `PanelKatalog` (input jumlah) | `FlowLayout` |
| `PanelKeranjang` (total dan tombol) | `FlowLayout` |

## Event Listener

| Class | Jenis | Lokasi | Fungsi |
|---|---|---|---|
| `TambahListener` | `implements ActionListener` | `PanelKatalog` | Menambah bunga ke keranjang saat tombol diklik |
| `AksiKeranjang` | `implements ActionListener` | `PanelKeranjang` | Menangani tombol Bayar dan Kosongkan |
| `HoverAdapter` | `extends MouseAdapter` | `PanelKatalog` | Mengubah warna tombol saat mouse masuk dan keluar |

## Cara menjalankan

Pastikan JDK sudah terpasang, lalu letakkan semua file `.java` di satu folder dan jalankan:

```
javac *.java
java Mulai
```

## Cara pakai

1. Atur jumlah tangkai lewat spinner.
2. Klik tombol bunga yang diinginkan, maka bunga masuk ke keranjang.
3. Klik **Bayar** untuk menyelesaikan belanja, atau **Kosongkan** untuk mengulang.

## Menambah atau mengubah bunga

Buka `PanelKatalog.java`, lalu ubah array `daftarBunga`:

```java
new Bunga("Nama Bunga", harga)
```

Jika jumlah bunga berubah, sesuaikan juga baris dan kolom `GridLayout(3, 2, 8, 8)` supaya semua tombol muat.