
package blackJack;

public class Crupier extends Persona{

    public Crupier(String nombre) {
        super(nombre);
    }
    
    public void jugar(){
        while(getMano().puntuacionActual() < 17)
            this.getMano().añdirCarta();
    }
}
