import javax.swing.*;

public class Plus extends  JFrame {
    private JPanel mainPanel;
    private JTextField DarabFresca;
    private JButton ConverterButton;
    private JLabel OsszesTotal;
    private JButton buttonClear;

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
    }
   public static void main(String[] args) {
      JFrame frame = new Plus("Pizza rendeles");
        frame.setVisible(true);
    }


}
