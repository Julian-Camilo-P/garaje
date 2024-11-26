
package Vehiculos;

/**
 *
 * @author USUARIO
 */
public class Vehiculo {
    private String placa;
    private String marca;
    private double precio;
    private int cilindraje;
    private double impuestoCirculacion;
    private double cuotaMesGaraje;

    // Constante para la cuota mensual por defecto
    private static final double CUOTA_MES_POR_DEFECTO = 100;

    // Constructor
    public Vehiculo(String marca, double precio, int cilindraje) {
        this.placa = null; // Por defecto
        this.marca = marca;
        this.precio = precio;
        this.cilindraje = cilindraje;
        this.cuotaMesGaraje = CUOTA_MES_POR_DEFECTO; // Por defecto
        calcularImpuestoCirculacion();
    }

    // Getters y Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public double getImpuestoCirculacion() {
        return impuestoCirculacion;
    }

    public double getCuotaMesGaraje() {
        return cuotaMesGaraje;
    }

    public void setCuotaMesGaraje(double cuotaMesGaraje) {
        if (cuotaMesGaraje >= 0) {
            this.cuotaMesGaraje = cuotaMesGaraje;
        } else {
            System.out.println("La cuota mensual no puede ser negativa.");
        }
    }

    // Métodos
    public void calcularImpuestoCirculacion() {
        this.impuestoCirculacion = this.precio * 0.02;
    }

    public boolean matricular(String matricula) {
        if (matricula != null && matricula.length() == 6) {
            this.placa = matricula;
            return true;
        }
        return false;
    }
}
