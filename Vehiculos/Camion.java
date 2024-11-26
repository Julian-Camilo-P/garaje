
package Vehiculos;

/**
 *
 * @author USUARIO
 */

public class Camion extends Vehiculo {
    private double capacidadCarga; // Toneladas

    public Camion(String marca, double precio, int cilindraje, double capacidadCarga) {
        super(marca, precio, cilindraje);
        this.capacidadCarga = capacidadCarga;
        this.calcularImpuestoCirculacion();
    }

    @Override
    public void calcularImpuestoCirculacion() {
        setCuotaMesGaraje(getPrecio() * 0.08); // El impuesto de camiones es 8% del precio
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
}
