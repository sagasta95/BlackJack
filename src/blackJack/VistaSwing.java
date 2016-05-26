package blackJack;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.*;

public class VistaSwing extends JFrame implements InterfazVista {

    private JPanel jpMain, jpDatos, jpBotones, jpApuesta;
    private JLabel jlbMain, jlJugadorPuntos, jlCrupierPuntos, jlNombre, jlSaldo, jlApuesta;
    private JTextField jtfNombre, jtfSaldo, jtfApuesta;
    private JButton jbPedirCarta, jbPlantarse, jbNewJugador, jbtnApuesta;
    private Dimension d;
    private Controlador c;
    private int puntosJugador, puntosCrupier;

    public VistaSwing() {
        d = new Dimension(1200, 700);
        jpMain = new JPanel(null);
        jpBotones = new JPanel(new FlowLayout());
        jpDatos = new JPanel(new GridLayout(0, 2));
        jpApuesta = new JPanel(new FlowLayout());
        jlApuesta = new JLabel(new ImageIcon());

        jbPedirCarta = new JButton("Pedir");
        jbPlantarse = new JButton("Plantarse");
        jbNewJugador = new JButton("OK");
        jbtnApuesta = new JButton("Apostar");
        jlNombre = new JLabel("Nombre:");
        jlSaldo = new JLabel("Saldo:");
        jlApuesta = new JLabel("¿Cuanto quieres apostar?");
        jlJugadorPuntos = new JLabel("Puntos Jugador:           " + 0);
        jlCrupierPuntos = new JLabel("Puntos Crupier:           " + 0);
        jtfNombre = new JTextField();
        jtfSaldo = new JTextField();
        jtfApuesta = new JTextField("                ");

        jpDatos.add(jlNombre);
        jpDatos.add(jtfNombre);
        jpDatos.add(jlSaldo);
        jpDatos.add(jtfSaldo);
        jpDatos.add(jbNewJugador);
        jpDatos.setSize(300, 300);
        jpMain.add(jpDatos);
        jpDatos.setLocation(450, 250);

        jpApuesta.add(jlApuesta);
        jpApuesta.add(jtfApuesta);
        jpApuesta.add(jbtnApuesta);
        jpApuesta.setSize(400, 75);
        jpMain.add(jpApuesta);
        jpApuesta.setLocation(450, 250);
        jpApuesta.setVisible(false);

        jpBotones.add(jlJugadorPuntos);
        jpBotones.add(jbPedirCarta);
        jpBotones.add(jbPlantarse);
        jpBotones.add(jlCrupierPuntos);

        jlbMain = new JLabel(new ImageIcon("src\\fotosCartas\\tapete.jpg"));
        jpMain.add(jlbMain);
        jlbMain.setBounds(0, 0, 1200, 700);
        add(jpMain);
        jpMain.add(jpBotones);
        jpBotones.setBounds(0, 635, 1200, 50);

        jpMain.setComponentZOrder(jpBotones, 0);

        setSize(d);
        jpDatos.setVisible(true);
        setTitle("BlackJack");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public String getNombre() {
        return jtfNombre.getText().trim();
    }

    @Override
    public float getSaldo() {
        jpDatos.setVisible(false);
        jpApuesta.setVisible(true);
        return Float.parseFloat(jtfSaldo.getText().trim());
    }

    @Override
    public float getApuesta() {
        return Float.parseFloat(jtfApuesta.getText().trim());
    }

    @Override
    public void setCondicion(boolean a) {
        if (a) {
            jpApuesta.setVisible(false);
            JOptionPane.showMessageDialog(this, "Buena Suerte!!!", "GO", 1);
            c.actionPerformed(new ActionEvent(this, 1, "BotonJugadorCarta"));
            c.actionPerformed(new ActionEvent(this, 1, "BotonJugadorCarta"));
            c.actionPerformed(new ActionEvent(this, 2, "BotonCrupierCarta"));
            c.actionPerformed(new ActionEvent(this, 2, "BotonCrupierCarta"));

        } else {
            JOptionPane.showMessageDialog(this, "No tiene suficiente dinero ", "Error", 0);
        }
    }

    @Override
    public void setGanador(int a) {
        jbPedirCarta.setEnabled(false);
        jbPlantarse.setEnabled(false);
        if (a == 1) {
            JOptionPane.showMessageDialog(this, "Has ganado ", ":)", 0);
        } else if (a == 2) {
            JOptionPane.showMessageDialog(this, "Has perdido ", ":(", 0);
        } else {
            JOptionPane.showMessageDialog(this, "Habeis empatado ", ":(", 0);
        }
    }

    @Override
    public void setPuntuacionJugador(int puntos) {
        if (puntos < 21) {
            puntosJugador = puntos;
            jlJugadorPuntos.setText("Puntos Jugador:           " + puntosJugador);
        } else {
            puntosJugador = puntos;
            jlJugadorPuntos.setText("Puntos Jugador:           " + puntosJugador);
            c.actionPerformed(new ActionEvent(c, 1, "BotonJugadorPlantarse"));
        }

    }

    @Override
    public void setPuntuacionCrupier(int puntos) {
        puntosCrupier = puntos;
        jlCrupierPuntos.setText("Puntos Crupier:           " + puntosCrupier);
    }

    @Override
    public void setCartasJugdador(ArrayList<Carta> s) {
        for (int i = 0; i < s.size(); i++) {
            JLabel l1 = new JLabel(s.get(i).getFoto());
            jpMain.add(l1);
            l1.setBounds(s.get(0).getFoto().getIconWidth() * i, 325, s.get(0).getFoto().getIconWidth(), s.get(0).getFoto().getIconHeight());
            jpMain.setComponentZOrder(l1, 0);
        }
    }

    @Override
    public void setCartasCrupier(ArrayList<Carta> s) {
        for (int i = 0; i < s.size(); i++) {
            JLabel l1 = new JLabel(s.get(i).getFoto());
            jpMain.add(l1);
            l1.setBounds(s.get(0).getFoto().getIconWidth() * i, 0, s.get(0).getFoto().getIconWidth(), s.get(0).getFoto().getIconHeight());
            jpMain.setComponentZOrder(l1, 0);
        }
    }

    @Override
    public void setControlador(Controlador c) {
        jbNewJugador.setActionCommand("BotonNuevoJugador");
        jbNewJugador.addActionListener(c);
        jbtnApuesta.setActionCommand("BotonApuestaJugador");
        jbtnApuesta.addActionListener(c);
        jbPedirCarta.setActionCommand("BotonJugadorCarta");
        jbPedirCarta.addActionListener(c);
        jbPlantarse.setActionCommand("BotonJugadorPlantarse");
        jbPlantarse.addActionListener(c);
        this.c = c;
    }

}
