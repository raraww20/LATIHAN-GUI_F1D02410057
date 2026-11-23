import javax.swing.*;
import java.awt.*;

public class JendelaUtama extends JFrame {

    public JendelaUtama() {
        super("Toko Bunga");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 420);
        setLocationRelativeTo(null);

        Keranjang keranjang = new Keranjang();
        PanelKeranjang panelKeranjang = new PanelKeranjang(keranjang);
        PanelKatalog panelKatalog = new PanelKatalog(keranjang, panelKeranjang);

        setLayout(new BorderLayout(10, 10));

        JLabel lblJudul = new JLabel("Toko Bunga", SwingConstants.CENTER);
        lblJudul.setFont(new Font("SansSerif", Font.BOLD, 20));

        JPanel panelTengah = new JPanel(new GridLayout(1, 2, 10, 10));
        panelTengah.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        panelTengah.add(panelKatalog);
        panelTengah.add(panelKeranjang);

        add(lblJudul, BorderLayout.NORTH);
        add(panelTengah, BorderLayout.CENTER);
    }
}