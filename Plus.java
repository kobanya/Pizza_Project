import javax.swing.*;

public class Plus extends  JFrame {
    private JPanel mainPanel;
    private JTextField DarabFresca;
    private JButton ConverterButton;
    private JLabel OsszesFresca;
    private JButton buttonClear;
    private JTextField DarabPolo;
    private JButton PluszPolo;
    private JButton TorolPolo;
    private JLabel OsszesPolo;


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

            int osszesenFreska = (int) (Double.parseDouble(DarabFresca.getText())
                   * 17);

            OsszesFresca.setText("Összesen : " +osszesenFreska+" eur");
        });

        // kosár törlése
        buttonClear.addActionListener(e -> {
            // nullazd ki a beviteli mező
            OsszesFresca.setText(" 0 €");
            DarabFresca.setText("0");
        });
// Polo Pizza hozzáadása gomb
        PluszPolo.addActionListener(e -> {
            int pizzapolo = (int)(Double.parseDouble(DarabPolo.getText())
                    +1);
            DarabPolo.setText(String.valueOf(pizzapolo));

            int osszesenPolo = (int) (Double.parseDouble(DarabPolo.getText())
                    * 15);
            OsszesPolo.setText("Összesen : "+osszesenPolo+" eur");
// Polo hozzáadas vége

          });
        // Polo törlése
        TorolPolo.addActionListener(e -> {
            OsszesPolo.setText(" 0 €");
            DarabPolo.setText("0");
        });
    }
   public static void main(String[] args) {
      JFrame frame = new Plus("Pizza rendeles");
        frame.setVisible(true);
    }


}
