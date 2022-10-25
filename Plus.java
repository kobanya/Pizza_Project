import javax.swing.*;
import java.awt.*;

public class Plus extends  JFrame {
    private JPanel mainPanel;
    private JPanel ingyenPanel;
    public JLabel frescaDbLabel;
    private JLabel poloDbLabel;
    private JLabel sorDbLabel;
    private JLabel cokeDbLabel;
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
    private JLabel OsszesSor;
    private JLabel OsszesCoke;
    private JLabel osszEtelLabel;
    private JLabel Ltotal;
    private JLabel osszItalLabel;
    private JPanel IgyenItalPanel;
    private JButton IngyenButton;
    private JLabel ingyenLabel;


    private int frescaDb;
    private int poloDb;
    private int cokeDb;
    private int beerDb;


    private int osszesenPolo;
    private int osszesenFreska;
    private int osszesenBeer;
    private int osszesenCoke;

    private boolean valasztasAktiv;
    private boolean ingyenItalValasztva = false;

    private boolean ingyenSor = false;
    private boolean ingyenCoke = false;

    public Plus(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        ingyenPanel.setVisible(false);
        IgyenItalPanel.setVisible(false);

        darabFresca.addActionListener(e -> {
            frescaDb++;
            calculate();
            refreshGUI();
        });

    // Fresca pizza  törlése
        buttonClear.addActionListener(e -> {
            frescaDb = 0;
            calculate();
            refreshGUI();
        });
    // Polo Pizza hozzáadása gomb
        PluszPolo.addActionListener(e -> {
            poloDb++;
            calculate();
            refreshGUI();
        });
     // Polo törlése
        TorolPolo.addActionListener(e -> {
            poloDb = 0;
            calculate();
            refreshGUI();
        });
     // Sör hozzáadása
        SorPlusz.addActionListener(e -> {
            beerDb++;
            calculate();
            refreshGUI();
        });
 // Sör törlése
        SorClear.addActionListener(e -> {
            beerDb = 0;
            calculate();
            refreshGUI();
        });

// Coke  darabszám hozzáadása

        CokePlusz.addActionListener(e -> {
            cokeDb++;
            calculate();
            refreshGUI();
        });
// Coke törlése

        CokeClear.addActionListener(e -> {
            cokeDb = 0;
            calculate();
            refreshGUI();
        });

// Ingyen coke hozzáadása
        RejtettCoke.addActionListener(e -> {
            ingyenCoke = true;
            ingyenItalValasztva = true;
            calculate();
            refreshGUI();
        });

// Ingyen sör hozzáadása
        RejtettSor.addActionListener(e -> {
            ingyenSor = true;
            ingyenItalValasztva = true;
            calculate();
            refreshGUI();
        });

// Minden adat  nullázása

        removeAll.addActionListener(e -> {
            frescaDb=0;
            poloDb=0;
            cokeDb=0;
            beerDb=0;
            ingyenItalValasztva = false;
            ingyenCoke = false;
            ingyenSor = false;
            valasztasAktiv= false;
            IgyenItalPanel.setVisible(false);

            calculate();
            refreshGUI();
        });
// ingyenital törlése
        IngyenButton.addActionListener(e -> IgyenItalPanel.setVisible(false));

            calculate();
            refreshGUI();
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


    void calculate() {
        int frescaAr = 18;
        osszesenFreska = frescaDb * frescaAr;
        int poloAr = 15;
        osszesenPolo = poloDb * poloAr;
        int cokeAr = 3;
        osszesenCoke = cokeDb * cokeAr;
        int beerAr = 4;
        osszesenBeer = beerDb * beerAr;
  //  Ingyenital panel megjelenítése majd újbóli eltüntetése ha ételt törölsz

        if (osszesenFreska + osszesenPolo >= 45 && !ingyenItalValasztva) {
            valasztasAktiv = true;
        }
        if  (osszesenFreska + osszesenPolo < 45 && !ingyenItalValasztva)
        {
            valasztasAktiv = false;
        }
    }
    void refreshGUI()
    {
        frescaDbLabel.setText(String.valueOf(frescaDb));
        poloDbLabel.setText(String.valueOf(poloDb));
        sorDbLabel.setText(String.valueOf(beerDb));
        cokeDbLabel.setText(String.valueOf(cokeDb));

        OsszesFresca.setText(" Összesen : "+ osszesenFreska + " €");
        OsszesPolo.setText(" Összesen : " + osszesenPolo + " €");
        OsszesSor.setText(" Összesen : " + osszesenBeer + " €");
        OsszesCoke.setText(" Összesen : " + osszesenCoke + " €");

        int osszEtel = osszesenFreska + osszesenPolo;
        int osszItal = osszesenCoke + osszesenBeer;

        osszEtelLabel.setText("Étel összesen / Food total: " + osszEtel + " €");
        osszItalLabel.setText("Itall összesen / Beverages total: " + osszItal + " €");

        Ltotal.setText(osszEtel + osszItal + " €");

        IngyenButton.addActionListener(e -> IgyenItalPanel.setVisible(false));
        ingyenPanel.setVisible(valasztasAktiv);

        if (ingyenCoke || ingyenSor)
        {
            if (ingyenSor) {
                ingyenLabel.setText("Ingyen ital  / Free beverage:   Sör / Beer");
            } else {
                ingyenLabel.setText("Ingyen ital / Free beverage:   Coke");
            }
            ingyenPanel.setVisible(false);
            IgyenItalPanel.setVisible(true);
        }

    }



}
