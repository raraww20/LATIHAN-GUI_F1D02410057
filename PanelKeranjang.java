import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelKeranjang extends JPanel {

    private final Keranjang keranjang;

    private final JList<ItemBelanja> daftarItem;
    private final JLabel lblTotal = new JLabel("Total: Rp 0");
    private final JButton btnBayar = new JButton("Bayar");
    private final JButton btnKosongkan = new JButton("Kosongkan");

    public PanelKeranjang(Keranjang keranjang) {
        this.keranjang = keranjang;
        this.daftarItem = new JList<>(keranjang.getItems());

        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createTitledBorder("Keranjang"));

        JPanel panelBawah = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 8));
        panelBawah.add(lblTotal);
        panelBawah.add(btnBayar);
        panelBawah.add(btnKosongkan);

        add(new JScrollPane(daftarItem), BorderLayout.CENTER);
        add(panelBawah, BorderLayout.SOUTH);

        AksiKeranjang aksi = new AksiKeranjang();
        btnBayar.addActionListener(aksi);
        btnKosongkan.addActionListener(aksi);
    }

    public void perbarui() {
        lblTotal.setText("Total: Rp " + keranjang.getTotal());
    }

    private class AksiKeranjang implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnBayar) {
                if (keranjang.isEmpty()) {
                    JOptionPane.showMessageDialog(PanelKeranjang.this, "Keranjang masih kosong!",
                            "Peringatan", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(PanelKeranjang.this,
                        "Total bayar: Rp " + keranjang.getTotal() + "\nTerima kasih sudah berbelanja!",
                        "Pembayaran", JOptionPane.INFORMATION_MESSAGE);
            }
            keranjang.kosongkan();
            perbarui();
        }
    }
}