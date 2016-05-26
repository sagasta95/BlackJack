
package blackJack;

import java.util.ArrayList;


public interface InterfazVista {
    public abstract String getNombre();

    public abstract float getSaldo() ;

    public abstract float getApuesta() ;

    public abstract void setCondicion (boolean a);

    public abstract void setPuntuacionJugador(int puntos);

    public abstract void setPuntuacionCrupier(int puntos) ;

    public abstract void setCartasJugdador(ArrayList <Carta> s) ;

    public abstract void setCartasCrupier(ArrayList <Carta> s) ;

    public abstract void setControlador(Controlador c) ;
    
    public abstract void setGanador(int a);
}
