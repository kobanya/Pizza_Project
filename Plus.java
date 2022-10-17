import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Plus extends  JFrame {
    private JPanel mainPanel;
    public JTextField DarabFresca;
    public JButton ConverterButton;
    public JLabel OsszesFresca;
    private JButton buttonClear;
    private JTextField DarabPolo;
    private JButton PluszPolo;
    private JButton TorolPolo;
    public JLabel OsszesPolo;
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
    private JLabel osszesenPizza;
    private JLabel OsszesenTotal;
    private JLabel Ltotal;
    private JButton removeAll;
    private JTextArea textArea1;
    private int osszesenPolo;
    private int osszesenFreska;
    private int sorOsszesen;
    private int cokeOsszesen;
    private int etelOsszesen;
    private int minuszPolo=0;
    private int minuszFresca = 0;
    private  int minuszPolo1;
    private int italOsszesen1;
    private int  total;
    private JLabel ItalokOsszesen;


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

            osszesenFreska = (int) (Double.parseDouble(DarabFresca.getText())
                    * 18);

            OsszesFresca.setText("Összesen : " + osszesenFreska + " €");

            etelOsszesen = osszesenFreska  + osszesenPolo;
            osszesenPizza.setText("Étel osszesen / Food total :" + etelOsszesen + " €");
      // Totál definiálása
            total = osszesenFreska + osszesenPolo+ cokeOsszesen+sorOsszesen;
            Ltotal.setText( total + " €");

        });

        // Fresca pizza  törlése
        buttonClear.addActionListener(e -> {
            // nullazd ki a beviteli mező
            OsszesFresca.setText(" 0 €");
            DarabFresca.setText("0");
//  fresca pizza kivonása az összes pizzából

           // minuszFresca = etelOsszesen-osszesenFreska;
            //osszesenPizza.setText("Étel osszesen / Food total : "+minuszFresca+ " €");


        });
// Polo Pizza hozzáadása gomb
        PluszPolo.addActionListener(e -> {
            int pizzapolo = (int) (Double.parseDouble(DarabPolo.getText())
                    + 1);
            DarabPolo.setText(String.valueOf(pizzapolo));

            osszesenPolo = (int) (Double.parseDouble(DarabPolo.getText())
                    * 15);
            OsszesPolo.setText("Összesen : " + osszesenPolo + " €");
// étel összesen
            etelOsszesen=0;
            etelOsszesen = osszesenFreska  + osszesenPolo;
            osszesenPizza.setText("Étel osszesen / Food total : " + etelOsszesen + " €");
// Totál definiálása
            total = osszesenFreska + osszesenPolo+ cokeOsszesen+sorOsszesen;
            Ltotal.setText( total + " €");

        });

        // Polo törlése
        TorolPolo.addActionListener(e -> {
            OsszesPolo.setText(" 0 €");
            DarabPolo.setText("0");
        // összes pizza -  pizza polo vagyis a Polo pizzák törlése
           // minuszPolo1 = etelOsszesen-osszesenPolo;
           // osszesenPizza.setText("Étel összesen / Food total: "+minuszPolo1+ " €");

        });
// Sör hozzáadása
        SorPlusz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sorBeer = (int) (Double.parseDouble(SorDarab.getText())
                        + 1);
                SorDarab.setText(String.valueOf(sorBeer));

                sorOsszesen = (int) (Double.parseDouble(SorDarab.getText())
                        * 4);
                SorOsszesen.setText("Összesen : " + sorOsszesen + " €");

                // Totál definiálása
                total = osszesenFreska + osszesenPolo+ cokeOsszesen+sorOsszesen;
                Ltotal.setText( total + " €");

                italOsszesen1 = sorOsszesen + cokeOsszesen;
                ItalokOsszesen.setText("Ital osszesen / Drinks total : " + italOsszesen1 + " €");

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

                cokeOsszesen = (int) (Double.parseDouble(CokeDarab.getText())
                        * 3);
                CokeOsszesen.setText("Összesen : " + cokeOsszesen + " €");
                // Totál definiálása
                total = osszesenFreska + osszesenPolo+ cokeOsszesen+sorOsszesen;
                Ltotal.setText( total + " €");

                italOsszesen1 = sorOsszesen + cokeOsszesen;
                ItalokOsszesen.setText("Ital osszesen / Drinks total : " + italOsszesen1 + " €");
            }
        });
    // Coke törlése

        CokeClear.addActionListener(e -> {
            // nullazd ki a beviteli mező
            CokeOsszesen.setText(" 0 €");
            CokeDarab.setText("0");
        });


        removeAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ltotal.setText(0 + " €");
                DarabPolo.setText("0");
                DarabFresca.setText("0");
                CokeDarab.setText("0");
                SorDarab.setText("0");
                OsszesFresca.setText("0 €");
                OsszesPolo.setText("0 €");
                CokeOsszesen.setText("0 €");
                SorOsszesen.setText("0 €");
                osszesenPizza.setText("Étel összesen  / Food total : 0 €");
                ItalokOsszesen.setText("Ital összesen / Drink total: 0 €");
            }
        });
    }
// teszt összesen


   public static void main(String[] args) {
      JFrame frame = new Plus("Pizza rendeles");
        frame.setVisible(true);

    }


}
