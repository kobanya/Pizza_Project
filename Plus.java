import javax.swing.*;
import java.awt.*;

public class Plus extends  JFrame {
    private JPanel mainPanel;
    private JPanel ingyenPanel;
    public JTextField DarabFresca;
    private JTextField DarabPolo;
    private JTextField SorDarab;
    private JTextField CokeDarab;
    public JButton darabFresca;
    private JButton buttonClear;
    private JButton PluszPolo;
    private JButton TorolPolo;
    private JButton SorPlusz;
    private JButton SorClear;
    private JButton CokePlusz;
    private JButton CokeClear;
    private JButton removeAll;
    private JButton RejtettSor;
    private JButton RejtettCoke;
    public JLabel OsszesFresca;
    public JLabel OsszesPolo;
    private JLabel Sor;
    private JLabel SorOsszesen;
    private JLabel cokeLabel;
    private JLabel CokeOsszesen;
    private JLabel osszesenPizza;
    private JLabel OsszesenTotal;
    private JLabel Ltotal;
    private JLabel ItalokOsszesen;
    private JLabel IngyenItalSzamla;


    private final int frescaAr = 18;
    private final int poloAr = 15;
    private final int beerAr = 4;
    private final int cokeAr = 3;

    private int frescaDb;
    private int poloDb;
    private int cokeDb;
    private int beerDb;


    private int italOsszesen1;
    private int osszesenPolo;
    private int osszesenFreska;
    private int osszesenBeer;
    private int osszesenCoke;
    private int etelOsszesen;
    private  int minuszPolo1;
    private int  total;
    private int FrescaTotalMinusz;
    private int PoloTotalMinusz;


    public Plus(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        ingyenPanel.setVisible(false);

        darabFresca.addActionListener(e -> {
     // olvasd be az értéket, alakítsd át tizedesre
            frescaDb++;

            calculate();

            refreshGUI();

            int pizzaFresca = (int) (Double.parseDouble(DarabFresca.getText())
                    + 1);
            DarabFresca.setText(String.valueOf(pizzaFresca));

            osszesenFreska = (int) (Double.parseDouble(DarabFresca.getText())
                    * 18);

            OsszesFresca.setText("Összesen : " + osszesenFreska + " €");

            etelOsszesen = osszesenFreska  + osszesenPolo;
            osszesenPizza.setText("Étel osszesen / Food total :" + etelOsszesen + " €");
    // Totál definiálása
            total = osszesenFreska + osszesenPolo+ osszesenCoke + osszesenBeer;
            Ltotal.setText( total + " €");
    // teszt  IF függvény
            if (etelOsszesen > 44 ) {
    // rejtett panael megjelenik ha meghaladja a 44 eurót az ételek összege
                ingyenPanel.setVisible(true);
    // coKe rejtett gomb + hozzáad majd eltűnik
                RejtettCoke.addActionListener(e14 -> {
                    RejtettCoke.setVisible(false);
                    int Coke = (int) (Double.parseDouble(CokeDarab.getText())
                            + 1);
                    //CokeDarab.setText(String.valueOf(Coke));
                    IngyenItalSzamla.setText("Ingyen Coke hozzáadva / Free Coke added "+0+" €");
                    ingyenPanel.setVisible(false);

                });
                RejtettSor.addActionListener(e13 -> {
                    RejtettSor.setVisible(false);
                    int Sor = (int) (Double.parseDouble(SorDarab.getText())
                            + 1);
                    //SorDarab.setText(String.valueOf(Sor));
                    IngyenItalSzamla.setText("Ingyen Sör  hozzáadva / Free Beer added "+0+" €");
                    ingyenPanel.setVisible(false);
                });

            } else { ingyenPanel.setVisible(false);

            }

        });



    // Fresca pizza  törlése
        buttonClear.addActionListener(e -> {
            // nullazd ki a beviteli mezőt
            OsszesFresca.setText(" 0 €");
            DarabFresca.setText("0");
            //Polo  pizza   töröl clear gomb esetén a totálból levonja a Polo pizzak törölt értékét
            FrescaTotalMinusz =total-osszesenFreska;
            Ltotal.setText( FrescaTotalMinusz + " €");
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
            total = osszesenFreska + osszesenPolo+ osszesenCoke + osszesenBeer;
            Ltotal.setText( total + " €");

    //  IF függvény
     if (etelOsszesen > 44) {
                // rejtett panael megjelenik ha meghaladja a 44 eurót az ételek összege

                ingyenPanel.setVisible(true);
                // coKe rejtett gomb + hozzáad majd eltűnik
                RejtettCoke.addActionListener(e12 -> {
                    RejtettCoke.setVisible(false);
                    int Coke = (int) (Double.parseDouble(CokeDarab.getText())
                            + 1);
                    //CokeDarab.setText(String.valueOf(Coke));
                    IngyenItalSzamla.setText("Ingyen Coke hozzáadva / Free Coke added "+0+" €");
                    ingyenPanel.setVisible(false);

                });
                RejtettSor.addActionListener(e1 -> {
                    RejtettSor.setVisible(false);
                   // RejtettCoke.setVisible(false);
                    int Sor = (int) (Double.parseDouble(SorDarab.getText())
                            + 1);
                    //SorDarab.setText(String.valueOf(Sor));
                    IngyenItalSzamla.setText("Ingyen sör hozzáadva / Free beer added "+0+" €");
                    ingyenPanel.setVisible(false);
                });



            } else { ingyenPanel.setVisible(false);

            }


        });
     // Polo törlése
        TorolPolo.addActionListener(e -> {
            OsszesPolo.setText(" 0 €");
            DarabPolo.setText("0");
            //Polo  pizza   töröl clear gomb esetén a totálból levonja a Polo pizzak törölt értékét
            PoloTotalMinusz =total-osszesenPolo;
            Ltotal.setText( PoloTotalMinusz + " €");
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

            osszesenBeer = (int) (Double.parseDouble(SorDarab.getText())
                    * 4);
            SorOsszesen.setText("Összesen : " + osszesenBeer + " €");

            // Totál definiálása
            total = osszesenFreska + osszesenPolo+ osszesenCoke + osszesenBeer;
            Ltotal.setText( total + " €");

            italOsszesen1 = osszesenBeer + osszesenCoke;
            ItalokOsszesen.setText("Ital osszesen / Drinks total : " + italOsszesen1 + " €");

        });
     // Sör törlése
        SorClear.addActionListener(e -> {
            // nullazd ki a beviteli mező
            SorOsszesen.setText(" 0 €");
            SorDarab.setText("0");
            osszesenBeer =0;
        });

       // Coke  darabszám hozzáadása

        CokePlusz.addActionListener(e -> {
            int Coke = (int) (Double.parseDouble(CokeDarab.getText())
                    + 1);
            CokeDarab.setText(String.valueOf(Coke));

            osszesenCoke = (int) (Double.parseDouble(CokeDarab.getText())
                    * 3);
            CokeOsszesen.setText("Összesen : " + osszesenCoke + " €");
            // Totál definiálása
            total = osszesenFreska + osszesenPolo+ osszesenCoke + osszesenBeer;
            Ltotal.setText( total + " €");

            italOsszesen1 = osszesenBeer + osszesenCoke;
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
            osszesenBeer =0;
            osszesenCoke =0;
            osszesenFreska=0;
            osszesenPolo=0;
            total=0;


        });





    }

   public static void main(String[] args) {
      JFrame frame = new Plus("Pizza rendelő rendszer / Pizza Ordering System");
        frame.setVisible(true);
   // az ablak a monitor közepén nyílik meg
       Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
       int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
       int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
       frame.setLocation(x, y);

    }

    void calculate()
    {
        osszesenFreska = frescaDb * frescaAr;
        osszesenPolo = poloDb * poloAr;
        osszesenCoke = cokeDb * cokeAr;
        osszesenBeer = beerDb * beerAr;

        if (osszesenFreska + osszesenPolo >= 45)
        {

        }
    }

    void refreshGUI()
    {

    }

}
