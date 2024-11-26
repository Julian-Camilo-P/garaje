
package Vehiculos;

/**
 *
 * @author USUARIO
 */
public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    public Moto(String marca, double precio, int cilindraje, boolean tieneSidecar) {
        super(marca, precio, cilindraje);
        this.tieneSidecar = tieneSidecar;

        // Ajuste del impuesto y cuota si tiene sidecar
        if (tieneSidecar) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.5);
            setCuotaMesGaraje(getImpuestoCirculacion() + getPrecio() * 0.1);
        }
    }

    public boolean isTieneSidecar() {
        return tieneSidecar;
    }

    public void setTieneSidecar(boolean tieneSidecar) {
        this.tieneSidecar = tieneSidecar;
    }
}
