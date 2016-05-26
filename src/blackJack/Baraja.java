package blackJack;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Baraja {

    private static ArrayList<Carta> baraja;
    private static int n_cartas;

    private Baraja() {
        baraja = new ArrayList();
        barajar();
    }

    public static void barajar() {
        if (baraja == null) {
            new Baraja();
        }
        n_cartas = 51;//52 cartas
        baraja.clear();
        for (int j = 1; j < 14; j++) {//13 cartas de cada palo instancia 52 Cartas
            baraja.add(new Carta('\u2660', j, new ImageIcon("src\\fotosCartas\\p" + j + ".png")));
            baraja.add(new Carta('\u2666', j, new ImageIcon("src\\fotosCartas\\d" + j + ".png")));
            baraja.add(new Carta('\u2663', j, new ImageIcon("src\\fotosCartas\\t" + j + ".png")));
            baraja.add(new Carta('\u2665', j, new ImageIcon("src\\fotosCartas\\c" + j + ".png")));
        }
    }

    public static Carta dameCarta() {
        if (baraja == null) {
            new Baraja();
        }
        Carta aux = baraja.get(AleatorioNum.dameAleatorio(0, n_cartas));
        n_cartas--;
        baraja.remove(aux);
        return aux;
    }

}
