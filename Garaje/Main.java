
package Garaje;

import Excepciones.ParqueaderoException;
import Vehiculos.Auto;
import Vehiculos.Camion;
import Vehiculos.Camioneta;
import Vehiculos.Vehiculo;
import Vehiculos.Moto;
import java.util.Scanner;
/**
 *
 * @author USUARIO
 */


public class Main {
    public static void main(String[] args) {
        RedParqueaderos redParqueaderos = new RedParqueaderos();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Menú principal
        do {
            System.out.println("\n--- Menú de Gestión de Parqueaderos ---");
            System.out.println("1.- Crear un garaje");
            System.out.println("2.- Eliminar un garaje");
            System.out.println("3.- Actualizar datos de un garaje");
            System.out.println("4.- Ingresar vehículo a un garaje");
            System.out.println("5.- Retirar vehículo de un garaje");
            System.out.println("6.- Consultar ocupación de garajes");
            System.out.println("7.- Consultar ocupación por tipo de vehículo");
            System.out.println("8.- Consultar recaudo mensual por garaje");
            System.out.println("9.- Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los datos del nuevo garaje:");
                    System.out.print("Departamento: ");
                    String departamento = scanner.nextLine();
                    System.out.print("Ciudad: ");
                    String ciudad = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Administrador: ");
                    String administrador = scanner.nextLine();
                    System.out.print("Número de espacios: ");
                    int numEspacios = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea

                    Garaje garaje = new Garaje(departamento, ciudad, direccion, telefono, email, administrador, numEspacios);
                    redParqueaderos.agregarGaraje(garaje);
                    System.out.println("Garaje creado exitosamente.");
                    break;

                case 2:
                    System.out.print("Ingrese la dirección del garaje a eliminar: ");
                    String direccionEliminar = scanner.nextLine();
                    redParqueaderos.eliminarGaraje(direccionEliminar);
                    System.out.println("Garaje eliminado.");
                    break;

                case 3:
                    System.out.print("Ingrese la dirección del garaje a actualizar: ");
                    String direccionActualizar = scanner.nextLine();
                    // Implementación de la lógica de actualización (por ejemplo, cambiar número de espacios o datos)
                    System.out.println("Datos de garaje actualizados.");
                    break;

                case 4:
                    System.out.println("Ingrese matrícula del vehículo a ingresar:");
                    String matricula = scanner.nextLine();
                    System.out.print("Tipo de vehículo (auto/moto/camioneta/camion): ");
                    String tipoVehiculo = scanner.nextLine().toLowerCase();

                    // Revisa si el vehículo ya está registrado en otro garaje
                    if (redParqueaderos.vehiculoEnRed(matricula)) {
                        System.out.println("El vehículo ya está registrado en otro garaje.");
                        break;
                    }

                    // Crear y agregar vehículo
                    Vehiculo vehiculo = null;
                    if (tipoVehiculo.equals("auto")) {
                        System.out.print("Marca: ");
                        String marcaAuto = scanner.nextLine();
                        System.out.print("Precio: ");
                        double precioAuto = scanner.nextDouble();
                        System.out.print("Cilindraje: ");
                        int cilindrajeAuto = scanner.nextInt();
                        scanner.nextLine(); // Consumir salto de línea
                        vehiculo = new Auto(marcaAuto, precioAuto, cilindrajeAuto, false, false);
                    } else if (tipoVehiculo.equals("moto")) {
                        System.out.print("Marca: ");
                        String marcaMoto = scanner.nextLine();
                        System.out.print("Precio: ");
                        double precioMoto = scanner.nextDouble();
                        System.out.print("Cilindraje: ");
                        int cilindrajeMoto = scanner.nextInt();
                        System.out.print("¿Tiene sidecar? (true/false): ");
                        boolean tieneSidecar = scanner.nextBoolean();
                        scanner.nextLine(); // Consumir salto de línea
                        vehiculo = new Moto(marcaMoto, precioMoto, cilindrajeMoto, tieneSidecar);
                    } else if (tipoVehiculo.equals("camioneta")) {
                        System.out.print("Marca: ");
                        String marcaCamioneta = scanner.nextLine();
                        System.out.print("Precio: ");
                        double precioCamioneta = scanner.nextDouble();
                        System.out.print("Cilindraje: ");
                        int cilindrajeCamioneta = scanner.nextInt();
                        System.out.print("Tipo de servicio (SUV/Pickup/Carga/Otro): ");
                        scanner.nextLine(); // Consumir salto de línea
                        String tipoServicio = scanner.nextLine();
                        System.out.print("Número de pasajeros: ");
                        int numPasajeros = scanner.nextInt();
                        System.out.print("¿Tiene remolque? (true/false): ");
                        boolean tieneRemolque = scanner.nextBoolean();
                        scanner.nextLine(); // Consumir salto de línea
                        vehiculo = new Camioneta(marcaCamioneta, precioCamioneta, cilindrajeCamioneta, tipoServicio, numPasajeros, tieneRemolque);
                    } else if (tipoVehiculo.equals("camion")) {
                        System.out.print("Marca: ");
                        String marcaCamion = scanner.nextLine();
                        System.out.print("Precio: ");
                        double precioCamion = scanner.nextDouble();
                        System.out.print("Cilindraje: ");
                        int cilindrajeCamion = scanner.nextInt();
                        System.out.print("Capacidad de carga (en toneladas): ");
                        double capacidadCarga = scanner.nextDouble();
                        scanner.nextLine(); // Consumir salto de línea
                        vehiculo = new Camion(marcaCamion, precioCamion, cilindrajeCamion, capacidadCarga);
                    }

                    if (vehiculo != null) {
                        System.out.print("Ingrese la dirección del garaje al que desea agregar el vehículo: ");
                        String direccionGaraje = scanner.nextLine();
                        Garaje garajeDestino = encontrarGaraje(redParqueaderos, direccionGaraje);
                        if (garajeDestino != null) {
                            try {
                                garajeDestino.ingresarVehiculo(vehiculo);
                                System.out.println("Vehículo ingresado exitosamente.");
                            } catch (ParqueaderoException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Garaje no encontrado.");
                        }
                    }
                    break;

                case 5:
                    System.out.print("Ingrese matrícula del vehículo a retirar: ");
                    String matriculaRetirar = scanner.nextLine();
                    System.out.print("Ingrese la dirección del garaje desde donde retirar: ");
                    String direccionRetiro = scanner.nextLine();
                    Garaje garajeRetiro = encontrarGaraje(redParqueaderos, direccionRetiro);
                    if (garajeRetiro != null) {
                        garajeRetiro.retirarVehiculo(matriculaRetirar);
                        System.out.println("Vehículo retirado exitosamente.");
                    } else {
                        System.out.println("Garaje no encontrado.");
                    }
                    break;

                case 6:
                    System.out.print("¿Desea consultar la ocupación de un garaje específico? (sí/no): ");
                    String consultaOcupacion = scanner.nextLine();
                    if (consultaOcupacion.equalsIgnoreCase("sí")) {
                        System.out.print("Ingrese la dirección del garaje: ");
                        String direccionConsulta = scanner.nextLine();
                        Garaje garajeConsulta = encontrarGaraje(redParqueaderos, direccionConsulta);
                        if (garajeConsulta != null) {
                            System.out.println("Ocupación del garaje: " + garajeConsulta.calcularOcupacion() + "/" + garajeConsulta.getNumEspacios());
                        } else {
                            System.out.println("Garaje no encontrado.");
                        }
                    } else {
                        for (Garaje g : redParqueaderos.getGarajes()) {
                            System.out.println("Ocupación en " + g.getDireccion() + ": " + g.calcularOcupacion() + "/" + g.getNumEspacios());
                        }
                    }
                    break;

                case 7:
                    System.out.print("¿Desea consultar la ocupación por tipo de vehículo? (sí/no): ");
                    String consultaTipoVehiculo = scanner.nextLine();
                    if (consultaTipoVehiculo.equalsIgnoreCase("sí")) {
                        System.out.print("¿Por qué tipo de vehículo? (auto/moto/camioneta/camion): ");
                        String tipoConsulta = scanner.nextLine().toLowerCase();
                        for (Garaje g : redParqueaderos.getGarajes()) {
                            int ocupacion = g.calcularOcupacionPorTipoVehiculo(tipoConsulta);
                            System.out.println("Ocupación de " + tipoConsulta + " en " + g.getDireccion() + ": " + ocupacion);
                        }
                    } else {
                        System.out.println("Operación cancelada.");
                    }
                    break;

                case 8:
                    double recaudoTotal = 0;
                    for (Garaje g : redParqueaderos.getGarajes()) {
                        double recaudoGaraje = g.calcularIngresos();
                        System.out.println("Recaudo mensual de " + g.getDireccion() + ": " + recaudoGaraje);
                        recaudoTotal += recaudoGaraje;
                    }
                    System.out.println("Recaudo total de todos los garajes: " + recaudoTotal);
                    break;

                case 9:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 9);

        scanner.close();
    }

    // Método para encontrar un garaje por dirección
    private static Garaje encontrarGaraje(RedParqueaderos redParqueaderos, String direccion) {
        for (Garaje garaje : redParqueaderos.getGarajes()) {
            if (garaje.getDireccion().equals(direccion)) {
                return garaje;
            }
        }
        return null;
    }
}