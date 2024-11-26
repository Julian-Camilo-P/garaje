
package Garaje;


import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author USUARIO
 */


public class RedParqueaderos {
    private List<Garaje> garajes;

    public RedParqueaderos() {
        this.garajes = new ArrayList<>();
    }

    public void agregarGaraje(Garaje garaje) {
        garajes.add(garaje);
    }

    public void eliminarGaraje(String direccion) {
    for (int i = 0; i < garajes.size(); i++) {
        if (garajes.get(i).getDireccion().equals(direccion)) {
            garajes.remove(i);
            return;
        }
    }
    System.out.println("No se encontró un garaje con esa dirección.");
}


    public boolean vehiculoEnRed(String placa) {
        for (Garaje garaje : garajes) {
            if (garaje.buscarVehiculo(placa) != -99) {
                return true;
            }
        }
        return false;
    }

    Iterable<Garaje> getGarajes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
