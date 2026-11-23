import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelKatalog extends JPanel {

    private final Bunga[] daftarBunga = {
        new Bunga("Mawar", 15000),
        new Bunga("Melati", 10000),
        new Bunga("Tulip", 20000),
        new Bunga("Anggrek", 35000),
        new Bunga("Matahari", 12000),
        new Bunga("Lily", 25000)
    };

    private final Keranjang keranjang;
    private final PanelKeranjang panelKeranjang;

    private final JSpinner spnJumlah = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));

    public PanelKatalog(Keranjang keranjang, PanelKeranjang panelKeranjang) {

        this.keranjang = keranjang;
        this.panelKeranjang = panelKeranjang;

        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createTitledBorder("Katalog Bunga"));

        JPanel panelTombol = new JPanel(new GridLayout(3, 2, 8, 8));

        TambahListener aksi = new TambahListener();
        HoverAdapter hover = new HoverAdapter();

        for (Bunga b : daftarBunga) {

            JButton btn = new JButton(
                    "<html><center>"
                    + b.getNama()
                    + "<br>Rp " + b.getHarga()
                    + "</center></html>"
            );

            btn.putClientProperty("bunga", b);
            btn.addActionListener(aksi);
            btn.addMouseListener(hover);
            panelTombol.add(btn);
        }

        JPanel panelJumlah = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 8, 5)
        );

        panelJumlah.add(new JLabel("Jumlah tangkai:"));
        panelJumlah.add(spnJumlah);

        add(panelTombol, BorderLayout.CENTER);
        add(panelJumlah, BorderLayout.SOUTH);
    }

    private class TambahListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();

            Bunga b = (Bunga) btn.getClientProperty("bunga");

            // Mengambil jumlah bunga dari spinner
            int jumlah = (Integer) spnJumlah.getValue();

            keranjang.tambah(b, jumlah);

            panelKeranjang.perbarui();
        }
    }

    private static class HoverAdapter extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {

            // Mengubah warna tombol menjadi pink
            JButton btn = (JButton) e.getSource();
            btn.setBackground(Color.PINK);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton btn = (JButton) e.getSource();
            btn.setBackground(UIManager.getColor("Button.background"));
        }
    }
}
