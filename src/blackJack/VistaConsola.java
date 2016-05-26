//no puede haber clsaes jugador ni mano eso hay que cambiarlo luego
package blackJack;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class VistaConsola implements InterfazVista {

    private Scanner sc;
    private String nombre, cartasJugador, cartasCrupier;
    private float apuesta, saldo;
    private boolean jugar1, jugar2, condicion;
    private int opcion, puntuacioJugador, puntuacioCrupier;
    private Controlador controlador;

    public VistaConsola() {
        sc = new Scanner(System.in);
        jugar1 = true;
        jugar2 = true;
    }

    public void loop() {

        System.out.println("BlackJack modo Consola");
        System.out.println("Cual es tu nombre??");//creado nuevo jugador
        nombre = sc.nextLine();
        System.out.println("¿Cuanta pasta tienes?");
        saldo = sc.nextFloat();
        controlador.actionPerformed(new ActionEvent(this, 1, "BotonNuevoJugador"));

        do {
            System.out.println("¿Cuanto quieres apostar?");//Hacer apuesta
            apuesta = sc.nextFloat();
            controlador.actionPerformed(new ActionEvent(this, 2, "BotonApuestaJugador"));
            if (!condicion) {
                System.out.println("No tiene suficiente dinero haz una apuesta menor");
            }
        } while (!condicion);

        System.out.println("Comenzamos:");
        controlador.actionPerformed(new ActionEvent(this, 3, "BotonJugadorCarta"));
        controlador.actionPerformed(new ActionEvent(this, 4, "BotonCrupierCarta"));
        controlador.actionPerformed(new ActionEvent(this, 3, "BotonJugadorCarta"));
        controlador.actionPerformed(new ActionEvent(this, 4, "BotonCrupierCarta"));

        System.out.println("Estas son tus cartas:");
        System.out.println(cartasJugador + " Tu puntuacion : " + puntuacioJugador);
        System.out.println("Estas son las cartas del crupier:");
        System.out.println(cartasCrupier + " Puntos Crupier : " + puntuacioCrupier);
        while (jugar1) {//jugador pide cartas hasta plantarse
            if (puntuacioJugador == 21 || puntuacioJugador > 21) {
                break;
            } else {
                System.out.println(nombre + " ¿Que quieres plantarte[1] o pedir carta[2]?");
                opcion = sc.nextInt();
                if (opcion == 1) {
                    break;
                } else {
                    controlador.actionPerformed(new ActionEvent(this, 3, "BotonJugadorCarta"));
                    System.out.println(cartasJugador + " Tu puntuacion : " + puntuacioJugador);
                }
            }
        }
        System.out.println("Veamos quien a ganado: ");
        controlador.actionPerformed(new ActionEvent(controlador, 1, "BotonJugadorPlantarse"));
        System.out.println("Estas son tus cartas:");
        System.out.println(cartasJugador + " Tu puntuacion : " + puntuacioJugador);
        System.out.println("Estas son las cartas del crupier:");
        System.out.println(cartasCrupier + " Puntos Crupier : " + puntuacioCrupier);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public float getSaldo() {
        return saldo;
    }

    @Override
    public float getApuesta() {
        return apuesta;
    }

    @Override
    public void setCondicion(boolean a) {
        condicion = a;
    }

    @Override
    public void setPuntuacionJugador(int puntos) {
        puntuacioJugador = puntos;
    }

    @Override
    public void setPuntuacionCrupier(int puntos) {
        puntuacioCrupier = puntos;
    }

    @Override
    public void setControlador(Controlador c) {
        controlador = c;
        loop();
    }

    @Override
    public void setCartasJugdador(ArrayList<Carta> s) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.size(); i++) {
            sb.append(s.get(i).getPalo() + " " + s.get(i).getValor() + " ");
        }
        cartasJugador = sb.toString();
    }

    @Override
    public void setCartasCrupier(ArrayList<Carta> s) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.size(); i++) {
            sb.append(s.get(i).getPalo() + " " + s.get(i).getValor() + " ");
        }
        cartasCrupier = sb.toString();
    }

    @Override
    public void setGanador(int a) {
        if (a == 1) {
            System.out.println("Has ganado  :) : )");
        } else if (a == 2) {
            System.out.println("Has perdido :(");
        } else {
            System.out.println("Habeis empatado !!!");
        }
    }

}
