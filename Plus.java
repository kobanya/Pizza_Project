import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Plus extends  JFrame {
    private JPanel mainPanel;
    private JTextField DarabFresca;
    private JButton ConverterButton;
    private JLabel OsszesTotal;
    private JButton buttonClear;
    private JTextField DarabPolo;
    private JButton PluszPolo;
    private JButton TorolPolo;

    public Plus(String title)   {
        super (title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        ConverterButton.addActionListener(e -> {
            // olvasd be az értéket
            //alakítsd át tizedesre
            // váltsd át
            int pizza1 = (int)(Double.parseDouble(DarabFresca.getText())
                    +1);
            DarabFresca.setText(String.valueOf(pizza1));

            int osszesen = (int) (Double.parseDouble(DarabFresca.getText())
                   * 15);
            OsszesTotal.setText("Összesen : 15 eur x " + pizza1 +" = "+osszesen+" eur");
        });

        // kosár törlése
        buttonClear.addActionListener(e -> {
            // nullazd ki a beviteli mező
            OsszesTotal.setText("A kosarad üres");
            DarabFresca.setText("0");
        });
// Polo Pizza hozzáadása gomb
        PluszPolo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pizzapolo = (int)(Double.parseDouble(DarabPolo.getText())
                        +1);
                DarabPolo.setText(String.valueOf(pizzapolo));

                int osszesen = (int) (Double.parseDouble(DarabPolo.getText())
                        * 17);
                OsszesTotal.setText("Összesen : 17 eur x " + pizzapolo +" = "+osszesen+" eur");
  // Polo hozzáadas vége

              }
        });
        // Polo törlése
        TorolPolo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OsszesTotal.setText("A kosarad üres");
                DarabPolo.setText("0");
            }
        });
    }
   public static void main(String[] args) {
      JFrame frame = new Plus("Pizza rendeles");
        frame.setVisible(true);
    }


}
