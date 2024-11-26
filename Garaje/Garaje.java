
package Garaje;

import Excepciones.*;
import Vehiculos.Camion;
import Vehiculos.Vehiculo;
import Vehiculos.Camioneta;
import Vehiculos.Vehiculo;
import Vehiculos.Moto;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author USUARIO
 */

public class Garaje {
    private String departamento;
    private String ciudad;
    private String direccion;
    private String telefono;
    private String email;
    private String administrador;
    private int numEspacios;
    private List<Vehiculo> vehiculos;
    

    // Constructor
    public Garaje(String departamento, String ciudad, String direccion, String telefono, String email, String administrador, int numEspacios) {
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.administrador = administrador;
        this.numEspacios = numEspacios;
        this.vehiculos = new ArrayList<>();
    }

    // Métodos para ingresar y retirar vehículos
    public void ingresarVehiculo(Vehiculo vehiculo) throws ParqueaderoException {
        if (vehiculos.size() >= numEspacios) {
            throw new EspacioInsuficienteException("No hay espacios disponibles en este garaje.");
        }

        if (vehiculos.contains(vehiculo)) {
            throw new VehiculoYaRegistradoException("El vehículo ya está registrado en este garaje.");
        }

        int numMotos = (int) vehiculos.stream().filter(v -> v instanceof Moto).count();
        if (vehiculo instanceof Moto && numMotos >= numEspacios * 0.2) {
            throw new MaximoMotosException("Se ha alcanzado el límite de motos permitido en este garaje.");
        }

        int numCamiones = (int) vehiculos.stream().filter(v -> v instanceof Camion).count();
        if (vehiculo instanceof Camion) {
            int maxCamiones = numEspacios < 100 ? 10 : 20;
            if (numCamiones >= maxCamiones) {
                throw new MaximoCamionesException("Se ha alcanzado el límite de camiones permitido en este garaje.");
            }
        }

        vehiculos.add(vehiculo);
    }

    public void retirarVehiculo(String placa) {
        vehiculos.removeIf(v -> v.getPlaca().equalsIgnoreCase(placa));
    }

    // Informe de ocupación
    public int calcularOcupacion() {
        return vehiculos.size();
    }

    Object getDireccion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    int buscarVehiculo(String placa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getNumEspacios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    int calcularOcupacionPorTipoVehiculo(String tipoConsulta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    double calcularIngresos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}