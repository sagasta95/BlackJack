package bj.controlador;

import bj.vista.InterfazVista;
import bj.modelo.Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador implements ActionListener {

    private Modelo m;
    private InterfazVista v;

    public Controlador(Modelo mo, InterfazVista vi) {
        m = mo;
        v = vi;
        v.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("BotonNuevoJugador")) {
            String nombre = v.getNombre().trim();
            float saldo = v.getSaldo();
            m.crearJugador(saldo, nombre);
        } else if (e.getActionCommand().equals("BotonApuestaJugador")) {
            float apuesta = v.getApuesta();
            v.setCondicion(m.setApuesta(apuesta));
        } else if (e.getActionCommand().equals("BotonJugadorCarta")) {
            v.setCartasJugdador(m.cogerCartaJugador());
            v.setPuntuacionJugador(m.puntosJugador());
        } else if (e.getActionCommand().equals("BotonCrupierCarta")) {
            v.setCartasCrupier(m.cogerCartaCrupier());
            v.setPuntuacionCrupier(m.puntosCrupier());
        } else if (e.getActionCommand().equals("BotonJugadorPlantarse")) {
            v.setCartasCrupier(m.crupuierJugar());
            v.setPuntuacionCrupier(m.puntosCrupier());
            v.setGanador(m.finMano());
        }
        
    }

}
