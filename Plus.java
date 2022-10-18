import javax.swing.*;
import java.awt.*;

public class Plus extends  JFrame {
    private JPanel mainPanel;
    public JTextField DarabFresca;
    public JButton darabFresca;
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
    private int osszesenPolo;
    private int osszesenFreska;
    private int sorOsszesen;
    private int cokeOsszesen;
    private int etelOsszesen;

    private  int minuszPolo1;
    private int italOsszesen1;
    private int  total;
    private JLabel ItalokOsszesen;
    private JButton RejtettSor;
    private JButton RejtettCoke;
    private JPanel ingenPanel;
    private JLabel IngyenItalSzamla;


    public Plus(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        ingenPanel.setVisible(false);
        darabFresca.addActionListener(e -> {
     // olvasd be az értéket, alakítsd át tizedesre
            int pizzaFresca = (int) (Double.parseDouble(DarabFresca.getText())
                    + 1);
            DarabFresca.setText(String.valueOf(pizzaFresca));

            osszesenFreska = (int) (Double.parseDouble(DarabFresca.getText())
                    * 18);

            OsszesFresca.setText("Összesen : " + osszesenFreska + " €");

            etelOsszesen = osszesenFreska  + osszesenPolo;
            osszesenPizza.setText("Étel osszesen / Food total :" + etelOsszesen + " €");
    // Totál definiálása
            total = osszesenFreska + osszesenPolo+ cokeOsszesen+sorOsszesen;
            Ltotal.setText( total + " €");
    // teszt  IF függvény
            if (etelOsszesen > 45) {
    // rejtett panael megjelenik ha meghaladja a 45 eurót az ételek összege
                ingenPanel.setVisible(true);
    // coKe rejtett gomb + hozzáad majd eltűnik
                RejtettCoke.addActionListener(e14 -> {
                    RejtettCoke.setVisible(false);
                    int Coke = (int) (Double.parseDouble(CokeDarab.getText())
                            + 1);
                    CokeDarab.setText(String.valueOf(Coke));
                    ingenPanel.setVisible(false);

                });
                RejtettSor.addActionListener(e13 -> {
                    RejtettSor.setVisible(false);
                    int Sor = (int) (Double.parseDouble(SorDarab.getText())
                            + 1);
                    SorDarab.setText(String.valueOf(Sor));
                    ingenPanel.setVisible(false);
                });

            } else { ingenPanel.setVisible(false);

            }

        });



    // Fresca pizza  törlése
        buttonClear.addActionListener(e -> {
            // nullazd ki a beviteli mező
            OsszesFresca.setText(" 0 €");
            DarabFresca.setText("0");
            osszesenFreska=0;


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

            etelOsszesen = osszesenFreska  + osszesenPolo;
            osszesenPizza.setText("Étel osszesen / Food total : " + etelOsszesen + " €");
    // Totál definiálása
            total = osszesenFreska + osszesenPolo+ cokeOsszesen+sorOsszesen;
            Ltotal.setText( total + " €");

    //  IF függvény
     if (etelOsszesen > 45) {
                // rejtett panael megjelenik ha meghaladja a 45 eurót az ételek összege

                ingenPanel.setVisible(true);
                // coKe rejtett gomb + hozzáad majd eltűnik
                RejtettCoke.addActionListener(e12 -> {
                    RejtettCoke.setVisible(false);
                    int Coke = (int) (Double.parseDouble(CokeDarab.getText())
                            + 1);
                    //CokeDarab.setText(String.valueOf(Coke));
                    IngyenItalSzamla.setText("Ingyen Coke hozzáadva / Free CoKe added "+0+" €");

                    ingenPanel.setVisible(false);

                });
                RejtettSor.addActionListener(e1 -> {
                    RejtettSor.setVisible(false);
                   // RejtettCoke.setVisible(false);
                    int Sor = (int) (Double.parseDouble(SorDarab.getText())
                            + 1);
                    //SorDarab.setText(String.valueOf(Sor));
                    ingenPanel.setVisible(false);
                    IngyenItalSzamla.setText("Ingyen sör hozzáadva / Free beer added "+0+" €");
                    ingenPanel.setVisible(false);
                });



            } else { ingenPanel.setVisible(false);

            }


        });
     // Polo törlése
        TorolPolo.addActionListener(e -> {
            OsszesPolo.setText(" 0 €");
            DarabPolo.setText("0");
            osszesenPolo=0;
        // összes pizza -  pizza polo vagyis a Polo pizzák törlése

           minuszPolo1 = etelOsszesen-osszesenPolo;
           osszesenPizza.setText("Étel összesen / Food total: "+minuszPolo1+ " €");

        });
     // Sör hozzáadása
        SorPlusz.addActionListener(e -> {
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

        });
     // Sör törlése
        SorClear.addActionListener(e -> {
            // nullazd ki a beviteli mező
            SorOsszesen.setText(" 0 €");
            SorDarab.setText("0");
            sorOsszesen=0;
        });

       // Coke  darabszám hozzáadása

        CokePlusz.addActionListener(e -> {
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
        });
    // Coke törlése

        CokeClear.addActionListener(e -> {
            // nullazd ki a beviteli mező
            CokeOsszesen.setText(" 0 €");
            CokeDarab.setText("0");
        });

     // Minden adat  nullázása
        removeAll.addActionListener(e -> {
     // SZöveges mezők törlése
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
            IngyenItalSzamla.setText("  ");
     // Változók nullázása
            sorOsszesen=0;
            cokeOsszesen=0;
            osszesenFreska=0;
            osszesenPolo=0;
            total=0;


        });





    }

   public static void main(String[] args) {
      JFrame frame = new Plus("Pizza rendeles");
        frame.setVisible(true);
   // az ablak a monitor közepén nyílik meg
       Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
       int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
       int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
       frame.setLocation(x, y);

    }


}
