import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JLabel Sor;
    private JLabel OsszesSor;
    private JLabel cokeLabel;
    private JLabel OsszesCoke;
    private JLabel osszEtelLabel;
    private JLabel OsszesenTotal;
    private JLabel Ltotal;
    private JLabel osszItalLabel;
    private JLabel IngyenItalSzamla;
    private JPanel IgyenItalPanel;
    private JButton IngyenButton;
    private JPanel kosar;



    private final int frescaAr = 18;
    private final int poloAr = 15;
    private final int beerAr = 4;
    private final int cokeAr = 3;

    private int frescaDb;
    private int poloDb;
    private int cokeDb;
    private int beerDb;


    private int osszesenPolo;
    private int osszesenFreska;
    private int osszesenBeer;
    private int osszesenCoke;

    private boolean valasztasAktiv;
    private boolean ingyenItalValasztva; 

    public Plus(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        ingyenPanel.setVisible(false);

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
// Minden adat  nullázása

        removeAll.addActionListener(e -> {
            frescaDb=0;
            poloDb=0;
            cokeDb=0;
            beerDb=0;

            calculate();
            refreshGUI();
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

        if (osszesenFreska + osszesenPolo >= 45 && !ingyenItalValasztva )
        {  ingyenPanel.setVisible(true);
            RejtettCoke.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
// mit tegyen ha megnyomom
                    ingyenPanel.setVisible(false);

            RejtettSor.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
// mit tegyen ha megnyomom
                            ingyenPanel.setVisible(false);
                        }
                    });
                }
            });

                // valasztasAktiv = true;
            //ingyenItalValasztva = true;
        }
        else { ingyenPanel.setVisible(false);
        }
    }

    void refreshGUI()
    {
        frescaDbLabel.setText(String.valueOf(frescaDb));
        poloDbLabel.setText(String.valueOf(poloDb));
        sorDbLabel.setText(String.valueOf(beerDb));
        cokeDbLabel.setText(String.valueOf(cokeDb));

        OsszesFresca.setText("Összesen :"+ osszesenFreska + " €");
        OsszesPolo.setText("Összesen : " + osszesenPolo + " €");
        OsszesSor.setText("Összesen : " + osszesenBeer + " €");
        OsszesCoke.setText("Összesen : " + osszesenCoke + " €");

        int osszEtel = osszesenFreska + osszesenPolo;
        int osszItal = osszesenCoke + osszesenBeer;

        osszEtelLabel.setText("Étel összesen / Food total: " + osszEtel + " €");
        osszItalLabel.setText("Itall összesen / Beverages total: " + osszItal + " €");

        Ltotal.setText(String.valueOf(osszEtel+osszItal+" €"));
//        OsszesenTotal=;
//        IngyenItalSzamla=;
    }
}
