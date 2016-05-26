package blackJack;

import java.util.ArrayList;

public class Modelo {

    Jugador jugador;
    Crupier crupier;

    public Modelo() {
        crupier = new Crupier("Crupier");
    }

    public void crearJugador(float saldo, String nombre) {
        jugador = new Jugador(saldo, nombre);
    }

    public boolean setApuesta(float apuesta) {
        return jugador.apostar(apuesta);
    }

    public ArrayList<Carta> cogerCartaJugador() {//cogela carta y devuelve la carta que es y su puntuacion
        jugador.getMano().añdirCarta();
        return jugador.getMano().getCartas();
    }

    public ArrayList<Carta> cogerCartaCrupier() {//lo mismo que del de arriba
        crupier.getMano().añdirCarta();
        return crupier.getMano().getCartas();
    }

    public ArrayList<Carta> crupuierJugar() {//Al plantarse el crupier juega su ronda
        crupier.jugar();
        return crupier.getMano().getCartas();
    }

    public int puntosJugador() {
        return jugador.getMano().puntuacionActual();
    }

    public int puntosCrupier() {
        return crupier.getMano().puntuacionActual();
    }
    
    public int finMano() {//1 gana jugador, 2 gana crupier, 3 empatados
        int aux;
        if(jugador.getMano().isBj() && crupier.getMano().isBj())
            aux = 3;
        else if(jugador.getMano().isBj() && !crupier.getMano().isBj())
            aux = 1;
        else if(!jugador.getMano().isBj() && crupier.getMano().isBj())
            aux = 2;
        else if(jugador.getMano().isPasa() && crupier.getMano().isPasa())
            aux = 3;
        else if(jugador.getMano().isPasa() && !crupier.getMano().isPasa())
            aux = 1;
        else if(!jugador.getMano().isPasa() && crupier.getMano().isPasa())
            aux = 2;
        else if(jugador.getMano().puntuacionActual() > crupier.getMano().puntuacionActual())
            aux = 1;
        else if(jugador.getMano().puntuacionActual() == crupier.getMano().puntuacionActual())
            aux = 3;
        else
            aux = 2;
        return aux;
    }
}
