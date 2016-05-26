
package blackJack;

import javax.swing.ImageIcon;

public class Carta {
    private char palo;
    private int valor;
    private ImageIcon foto;

    public Carta(char palo, int valor, ImageIcon foto) {
        this.palo = palo;
        this.valor = valor;
        this.foto=foto;
    }

    public ImageIcon getFoto() {
        return foto;
    }
    

    public char getPalo() {
        return palo;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.palo;
        hash = 67 * hash + this.valor;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.palo != other.palo) {
            return false;
        }
        if (this.valor != other.valor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + valor + palo;
    }
    
    
}
