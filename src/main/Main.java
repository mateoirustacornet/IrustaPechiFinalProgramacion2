package main;

import java.util.ArrayList;
import menu.Menu;
import modelo.empleados.Empleado;
import modelo.empleados.Guarda;
import modelo.empleados.Maquinista;
import modelo.trenes.Carga;
import modelo.trenes.Pasajeros;
import modelo.trenes.Tren;
import modelo.viajes.Viaje;

public class Main {

    private static final ArrayList<Tren> trenes = new ArrayList<>();
    private static final ArrayList<Empleado> empleados = new ArrayList<>();
    private static final ArrayList<Guarda> guardas = new ArrayList<>();
    private static final ArrayList<Viaje> viajes = new ArrayList<>();

    public static void main(String[] args) {
        inicializarDatos();
        // Transferencia de control: el menú se encarga del bucle operativo
        Menu.manejarSeleccion(trenes, empleados, guardas, viajes);
    }

    /**
     * Crea objetos de prueba necesarios para cada entidad y los almacena en los ArrayList.
     */
    private static void inicializarDatos() {
        // Trenes
        Tren t1 = new Carga("T001", 30, "pesada");
        Tren t2 = new Pasajeros("T002", 15, "eléctrico");
        Tren t3 = new Carga("T003", 45, "liviana");
        Tren t4 = new Pasajeros("T004", 10, "gasolero");
        trenes.add(t1);
        trenes.add(t2);
        trenes.add(t3);
        trenes.add(t4);

        // Empleados: Maquinistas
        Maquinista m1 = new Maquinista("Juan", "Perez", "11111111", "LIC-01", 150, 1);
        Maquinista m2 = new Maquinista("Luis", "Gomez", "22222222", "LIC-02", 80, 2);
        empleados.add(m1);
        empleados.add(m2);

        // Empleados: Guardas
        Guarda g1 = new Guarda("Ana", "Lopez", "33333333", 12);
        Guarda g2 = new Guarda("Maria", "Diaz", "44444444", 5);
        empleados.add(g1);
        empleados.add(g2);
        guardas.add(g1);
        guardas.add(g2);

        // Viajes
        Viaje v1 = new Viaje("V-100", m1, g1, t1, "05/08/2024", "08:25", "Retiro", "Rosario");
        Viaje v2 = new Viaje("V-101", m2, g2, t2, "06/08/2024", "10:30", "Constitución", "Mar del Plata");
        Viaje v3 = new Viaje("V-102", m1, g2, t3, "07/08/2024", "14:15", "Once", "Bragado");
        viajes.add(v1);
        viajes.add(v2);
        viajes.add(v3);
    }
}