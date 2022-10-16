import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JLabel Sor;
    private JTextField SorDarab;
    private JButton SorPlusz;
    private JButton SorClear;
    private JLabel SorOsszesen;
    private JLabel cokeLabel;
    private JTextField CokeDarab;
    private JButton CokePlusz;
    private JButton CokeClear;
    private JLabel CokeOsszesen;


    public Plus(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        ConverterButton.addActionListener(e -> {
            // olvasd be az értéket
            //alakítsd át tizedesre
            // váltsd át
            int pizza1 = (int) (Double.parseDouble(DarabFresca.getText())
                    + 1);
            DarabFresca.setText(String.valueOf(pizza1));

            int osszesenFreska = (int) (Double.parseDouble(DarabFresca.getText())
                    * 18);

            OsszesFresca.setText("Összesen : " + osszesenFreska + " €");
        });

        // Fresca pizza  törlése
        buttonClear.addActionListener(e -> {
            // nullazd ki a beviteli mező
            OsszesFresca.setText(" 0 €");
            DarabFresca.setText("0");
        });
// Polo Pizza hozzáadása gomb
        PluszPolo.addActionListener(e -> {
            int pizzapolo = (int) (Double.parseDouble(DarabPolo.getText())
                    + 1);
            DarabPolo.setText(String.valueOf(pizzapolo));

            int osszesenPolo = (int) (Double.parseDouble(DarabPolo.getText())
                    * 15);
            OsszesPolo.setText("Összesen : " + osszesenPolo + " €");
// Polo hozzáadas vége

        });
        // Polo törlése
        TorolPolo.addActionListener(e -> {
            OsszesPolo.setText(" 0 €");
            DarabPolo.setText("0");
        });
// Sör hozzáadása
        SorPlusz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sorBeer = (int) (Double.parseDouble(SorDarab.getText())
                        + 1);
                SorDarab.setText(String.valueOf(sorBeer));

                int sorOsszesen = (int) (Double.parseDouble(SorDarab.getText())
                        * 4);
                SorOsszesen.setText("Összesen : " + sorOsszesen + " €");
            }
        });
        // Sör törlése
        SorClear.addActionListener(e -> {
            // nullazd ki a beviteli mező
            SorOsszesen.setText(" 0 €");
            SorDarab.setText("0");
        });


        // Coke  darabszám hozzáadása

        CokePlusz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int Coke = (int) (Double.parseDouble(CokeDarab.getText())
                        + 1);
                CokeDarab.setText(String.valueOf(Coke));

                int cokeOsszesen = (int) (Double.parseDouble(SorDarab.getText())
                        * 3);
                CokeOsszesen.setText("Összesen : " + cokeOsszesen + " €");
            }
        });
    // Coke törlése

        CokeClear.addActionListener(e -> {
            // nullazd ki a beviteli mező
            CokeOsszesen.setText(" 0 €");
            CokeDarab.setText("0");
        });
    }

   public static void main(String[] args) {
      JFrame frame = new Plus("Pizza rendeles");
        frame.setVisible(true);
    }


}
