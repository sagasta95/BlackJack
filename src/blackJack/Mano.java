/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackJack;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sagastagoitia
 */
public class Mano {

    private ArrayList<Carta> mano;
    private int puntuacion1, puntuacion2;
    private boolean bj, pasa;


    public Mano() {
        mano = new ArrayList();
        puntuacion1 = 0;
        puntuacion2 = 0;
        bj = false;
        pasa = false;
    }
    
    public ArrayList<Carta> getCartas() {
        return mano;
    }

    public boolean isPasa() {
        return pasa;
    }

    public boolean isBj() {
        return bj;
    }
    
    public void añdirCarta() {
        Carta aux = Baraja.dameCarta();
        mano.add(aux);
        calcularPuntuacion();
        if(mano.size()== 2 && puntuacionActual() == 21)
            bj = true;
        if(puntuacionActual() > 21){
            pasa = true;
        }
    }
    
    public void nuevaMano(){
        mano.clear();
        puntuacion1 = 0;
        puntuacion2 = 0;
        bj = false;
        pasa = false;
    }

    public String mostrarCarta() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < mano.size(); i++) {
            sb.append(mano.get(i).toString() + "");
        }
        return sb.toString();
    }
    
    private void calcularPuntuacion() {
        for (Iterator<Carta> iterator = mano.iterator(); iterator.hasNext();) {
            Carta next = iterator.next();
            if (next.getValor() == 1){
                puntuacion1 = puntuacion1 + 1;
                puntuacion2 = puntuacion2 + 11;
            } else if (next.getValor() < 11) {
                puntuacion1 = puntuacion1 + next.getValor();
                puntuacion2 = puntuacion2 + next.getValor();
            } else {
                puntuacion1 = puntuacion1 + 10;
                puntuacion2 = puntuacion2 + 10;
            }
        }
    }
    
    public int puntuacionActual() {
        if (puntuacion2 > 21) {
            return puntuacion1;
        }else{
            return puntuacion2;
        }
    }
}
