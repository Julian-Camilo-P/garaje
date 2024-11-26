
package Vehiculos;

import Garaje.*;

/**
 *
 * @author USUARIO
 */
public class Auto extends Vehiculo {
    private boolean tieneRadio;
    private boolean tieneNavegador;

    public Auto(String marca, double precio, int cilindraje, boolean tieneRadio, boolean tieneNavegador) {
        super(marca, precio, cilindraje);
        this.tieneRadio = tieneRadio;
        this.tieneNavegador = tieneNavegador;

        // Ajuste del impuesto si tiene radio o navegador
        if (tieneRadio) {
            setCuotaMesGaraje(getCuotaMesGaraje() + getPrecio() * 0.01);
        }
        if (tieneNavegador) {
            setCuotaMesGaraje(getCuotaMesGaraje() + getPrecio() * 0.02);
        }

        // Ajuste de la cuota mensual si el cilindraje es mayor a 2499
        if (cilindraje > 2499) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.2);
        }
    }

    public boolean isTieneRadio() {
        return tieneRadio;
    }

    public void setTieneRadio(boolean tieneRadio) {
        this.tieneRadio = tieneRadio;
    }

    public boolean isTieneNavegador() {
        return tieneNavegador;
    }

    public void setTieneNavegador(boolean tieneNavegador) {
        this.tieneNavegador = tieneNavegador;
    }
}
