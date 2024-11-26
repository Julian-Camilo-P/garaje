
package Vehiculos;

import Garaje.*;

/**
 *
 * @author USUARIO
 */
public class Camioneta extends Vehiculo {
    private String tipoServicio; // SUV, Pickup, Carga u Otro
    private int numPasajeros;
    private boolean tieneRemolque;

    public Camioneta(String marca, double precio, int cilindraje, String tipoServicio, int numPasajeros, boolean tieneRemolque) {
        super(marca, precio, cilindraje);
        this.tipoServicio = tipoServicio;
        this.tieneRemolque = tieneRemolque;

        // Validación del número de pasajeros
        if ((tipoServicio.equalsIgnoreCase("Pickup") || tipoServicio.equalsIgnoreCase("Carga")) && numPasajeros > 2) {
            throw new IllegalArgumentException("Las camionetas tipo Pickup o Carga no pueden tener más de 2 pasajeros.");
        } else if (numPasajeros > 5) {
            throw new IllegalArgumentException("El número máximo de pasajeros para otras camionetas es 5.");
        }
        this.numPasajeros = numPasajeros;

        // Calcular impuesto de circulación
        setCuotaMesGaraje(getCuotaMesGaraje()); // Inicializa con valores de la superclase
        this.calcularImpuestoCirculacion();

        // Incrementos en la cuota mensual
        if (tipoServicio.equalsIgnoreCase("Pickup") || tipoServicio.equalsIgnoreCase("Carga") || tipoServicio.equalsIgnoreCase("Otro")) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.45);
        } else if (tipoServicio.equalsIgnoreCase("SUV")) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.1);
        }

        if (numPasajeros == 2) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.5);
        } else if (numPasajeros > 2) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.6);
        }

        if (tieneRemolque) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.1);
        }
    }

    @Override
    public void calcularImpuestoCirculacion() {
        setCuotaMesGaraje(getPrecio() * 0.05);
    }

    // Getters y Setters
    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public boolean isTieneRemolque() {
        return tieneRemolque;
    }

    public void setTieneRemolque(boolean tieneRemolque) {
        this.tieneRemolque = tieneRemolque;
    }
}

