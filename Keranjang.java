import javax.swing.*;

class Bunga {
    private final String nama;
    private final int harga;

    public Bunga(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() { return nama; }
    public int getHarga() { return harga; }
}

class ItemBelanja {
    private final Bunga bunga;
    private int jumlah;

    public ItemBelanja(Bunga bunga, int jumlah) {
        this.bunga = bunga;
        this.jumlah = jumlah;
    }

    public Bunga getBunga() { return bunga; }

    public void tambahJumlah(int n) {
        jumlah += n;
    }

    public int getSubtotal() {
        return bunga.getHarga() * jumlah;
    }

    @Override
    public String toString() {
        return bunga.getNama() + " x" + jumlah + " = Rp " + getSubtotal();
    }
}

public class Keranjang {
    private final DefaultListModel<ItemBelanja> items = new DefaultListModel<>();

    public void tambah(Bunga b, int jumlah) {
        for (int i = 0; i < items.size(); i++) {
            ItemBelanja item = items.get(i);
            if (item.getBunga() == b) {
                item.tambahJumlah(jumlah);
                items.set(i, item);
                return;
            }
        }
        items.addElement(new ItemBelanja(b, jumlah));
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getSubtotal();
        }
        return total;
    }

    public boolean isEmpty() { return items.isEmpty(); }
    public void kosongkan() { items.clear(); }
    public DefaultListModel<ItemBelanja> getItems() { return items; }
}