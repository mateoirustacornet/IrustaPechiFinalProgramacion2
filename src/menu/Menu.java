package menu;

import java.util.ArrayList;
import modelo.empleados.Empleado;
import modelo.empleados.Guarda;
import modelo.trenes.Tren;
import modelo.viajes.Viaje;
import util.Pantalla;

public class Menu {

    private static int mostrarYLeerOpcion() {
        Pantalla.imprimir("\n*********************************************");
        Pantalla.imprimir("** MENU PRINCIPAL                          **");
        Pantalla.imprimir("*********************************************");
        Pantalla.imprimir("1- Buscar empleado por DNI");
        Pantalla.imprimir("2- Buscar trenes con más vagones");
        Pantalla.imprimir("3- Buscar viajes por destino");
        Pantalla.imprimir("4- Buscar viajes por DNI de empleado");
        Pantalla.imprimir("5- Buscar viajes de trenes de carga");
        Pantalla.imprimir("6- Cargar un nuevo viaje");
        Pantalla.imprimir("7- Salir");
        Pantalla.imprimir("---------------------------------------------");
        
        return Pantalla.leerEntero("Seleccione una opción: ");
    }

    /**
     * Controla el ciclo de ejecución interactivo delegando las lecturas a cada clase.
     */
    public static void manejarSeleccion(ArrayList<Tren> trenes, ArrayList<Empleado> empleados, 
                                        ArrayList<Guarda> guardas, ArrayList<Viaje> viajes) {
        boolean salir = false;

        while (!salir) {
            int opcion = Menu.mostrarYLeerOpcion();

            switch (opcion) {
                case 1: {
                    String dni = Pantalla.leerString("Ingrese el DNI del empleado a buscar: ");
                    Empleado emp = Empleado.buscarPorDni(empleados, dni);
                    if (emp != null) {
                        Pantalla.imprimir("\n--- Empleado Encontrado ---");
                        emp.mostrarDetalle();
                    } else {
                        Pantalla.imprimir("Aviso: No se encontró ningún empleado con el DNI " + dni);
                    }
                    break;
                }
                case 2: {
                    int n = Pantalla.leerEntero("¿Cuántos trenes con más vagones desea buscar?: ");
                    if (n > 0) {
                        ArrayList<Tren> topTrenes = Tren.buscarTrenConMasVagones(trenes, n);
                        if (topTrenes.isEmpty()) {
                            Pantalla.imprimir("Aviso: No hay trenes registrados.");
                        } else {
                            Pantalla.imprimir("\n--- Top " + n + " Trenes con más vagones ---");
                            for (Tren t : topTrenes) {
                                t.mostrarDetalle();
                                Pantalla.imprimir("--------------------------");
                            }
                        }
                    } else {
                        Pantalla.imprimir("La cantidad debe ser mayor a 0.");
                    }
                    break;
                }
                case 3: {
                    String destino = Pantalla.leerString("Ingrese la estación de destino: ");
                    ArrayList<Viaje> viajesDestino = Viaje.buscarViajesPorDestino(viajes, destino);
                    if (viajesDestino.isEmpty()) {
                        Pantalla.imprimir("Aviso: No se encontraron viajes con destino a " + destino);
                    } else {
                        for (Viaje v : viajesDestino) {
                            Pantalla.imprimir("\nDetalle del Viaje:");
                            v.mostrarDetalle();
                            Pantalla.imprimir("--------------------------");
                        }
                    }
                    break;
                }
                case 4: {
                    String dniViaje = Pantalla.leerString("Ingrese el DNI del maquinista o guarda: ");
                    ArrayList<Viaje> viajesDni = Viaje.buscarViajesPorDniEmpleado(viajes, dniViaje);
                    if (viajesDni.isEmpty()) {
                        Pantalla.imprimir("Aviso: No se encontraron viajes asociados al DNI " + dniViaje);
                    } else {
                        for (Viaje v : viajesDni) {
                            Pantalla.imprimir("\nDetalle del Viaje:");
                            v.mostrarDetalle();
                            Pantalla.imprimir("--------------------------");
                        }
                    }
                    break;
                }
                case 5: {
                    Pantalla.imprimir("\n--- Viajes realizados por trenes de Carga ---");
                    ArrayList<Viaje> viajesCarga = Viaje.buscarViajesPorTipoTren(viajes, "Carga");
                    if (viajesCarga.isEmpty()) {
                        Pantalla.imprimir("Aviso: No se encontraron viajes realizados con trenes de carga.");
                    } else {
                        for (Viaje v : viajesCarga) {
                            Pantalla.imprimir("\nDetalle del Viaje:");
                            v.mostrarDetalle();
                            Pantalla.imprimir("--------------------------");
                        }
                    }
                    break;
                }
                case 6: {
                    Viaje nuevo = Viaje.crearViaje(trenes, empleados, guardas);
                    if (nuevo != null) {
                        viajes.add(nuevo);
                    }
                    break;
                }
                case 7: {
                    salir = true;
                    Pantalla.imprimir("Saliendo del programa... ¡Hasta luego!");
                    break;
                }
                default:{
                    Pantalla.imprimir("Opción ingresada no válida. Por favor, intente nuevamente.");
                    break;
                } 
            }
        }
    }
}