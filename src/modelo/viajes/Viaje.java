package modelo.viajes;

import java.util.ArrayList;

import modelo.empleados.Empleado;
import modelo.empleados.Guarda;
import modelo.empleados.Maquinista;
import modelo.trenes.Carga;
import modelo.trenes.Pasajeros;
import modelo.trenes.Tren;
import util.Pantalla;

/**
 * Representa un viaje realizado por un tren, con un maquinista y un guarda asignados.
 * La cantidad de paradas se calcula automáticamente según el tipo de tren.
 */
public class Viaje {

    private String codigo;
    private Maquinista maquinista;
    private Guarda guarda;
    private Tren tren;
    private String fecha;          // ej: "5/08/2024"
    private String horaSalida;     // ej: "08:25"
    private String estacionSalida;
    private String estacionDestino;
    private int nroParadas;        // se calcula automáticamente

    public Viaje(String codigo, Maquinista maquinista, Guarda guarda, Tren tren,
                 String fecha, String horaSalida, String estacionSalida, String estacionDestino) {
        this.codigo = codigo;
        this.maquinista = maquinista;
        this.guarda = guarda;
        this.tren = tren;
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.estacionSalida = estacionSalida;
        this.estacionDestino = estacionDestino;
        this.nroParadas = calcularNroParadas(tren);
    }

    /**
     * Calcula la cantidad de paradas según el tipo de tren asignado.
     * Pasajeros -> 5 paradas. Carga -> 2 paradas.
     */
    private int calcularNroParadas(Tren tren) {
        if (tren instanceof Pasajeros) {
            return 5;
        } else if (tren instanceof Carga) {
            return 2;
        }
        return 0;
    }

    // ---------- Getters y Setters ----------

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Maquinista getMaquinista() {
        return maquinista;
    }

    public void setMaquinista(Maquinista maquinista) {
        this.maquinista = maquinista;
    }

    public Guarda getGuarda() {
        return guarda;
    }

    public void setGuarda(Guarda guarda) {
        this.guarda = guarda;
    }

    public Tren getTren() {
        return tren;
    }

    /**
     * Al reasignar el tren, se recalcula automáticamente la cantidad de paradas.
     */
    public void setTren(Tren tren) {
        this.tren = tren;
        this.nroParadas = calcularNroParadas(tren);
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getEstacionSalida() {
        return estacionSalida;
    }

    public void setEstacionSalida(String estacionSalida) {
        this.estacionSalida = estacionSalida;
    }

    public String getEstacionDestino() {
        return estacionDestino;
    }

    public void setEstacionDestino(String estacionDestino) {
        this.estacionDestino = estacionDestino;
    }

    public int getNroParadas() {
        return nroParadas;
    }

    public void setNroParadas(int nroParadas) {
        this.nroParadas = nroParadas;
    }

    // ---------- Métodos ----------

    public void mostrarDetalle() {
        System.out.println("Código de viaje: " + codigo);
        System.out.println("Fecha: " + fecha + " - Hora salida: " + horaSalida);
        System.out.println("Estación salida: " + estacionSalida);
        System.out.println("Estación destino: " + estacionDestino);
        System.out.println("Nro. paradas: " + nroParadas);
        System.out.println("--- Maquinista asignado ---");
        maquinista.mostrarDetalle();
        System.out.println("--- Guarda asignado ---");
        guarda.mostrarDetalle();
        System.out.println("--- Tren asignado ---");
        tren.mostrarDetalle();
    }

    /**
     * Busca todos los viajes cuyo destino coincida con el indicado.
     */
    public static ArrayList<Viaje> buscarViajesPorDestino(ArrayList<Viaje> viajes, String destino) {
        ArrayList<Viaje> resultado = new ArrayList<>();
        for (Viaje v : viajes) {
            if (v.getEstacionDestino().equalsIgnoreCase(destino)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    /**
     * Busca todos los viajes cuyo maquinista asignado tenga el dni indicado.
     */
    public static ArrayList<Viaje> buscarViajesPorDniEmpleado(ArrayList<Viaje> viajes, String dni) {
        ArrayList<Viaje> resultado = new ArrayList<>();
        for (Viaje v : viajes) {
            if (v.getMaquinista().getDni().equals(dni) || v.getGuarda().getDni().equals(dni)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    /**
     * Busca todos los viajes cuyo tren asignado sea de un tipo determinado.
     * @param tipo nombre de la clase del tren (ej: "Carga" o "Pasajeros")
     */
    public static ArrayList<Viaje> buscarViajesPorTipoTren(ArrayList<Viaje> viajes, String tipo) {
        ArrayList<Viaje> resultado = new ArrayList<>();
        for (Viaje v : viajes) {
            if (v.getTren().getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    /**
     * Crea un nuevo viaje solicitando los datos por consola.
     * Utiliza Pantalla para la lectura/validación de datos,
     * y busca el tren y el maquinista según el id/dni ingresados.
     */
    public static Viaje crearViaje(ArrayList<Tren> trenes, ArrayList<Empleado> empleados,
                                    ArrayList<Guarda> guardas) {
        Pantalla.imprimir("--- Carga de nuevo viaje ---");

        String codigo = Pantalla.leerString("Ingrese código de viaje: ");

        String idTren = Pantalla.leerString("Ingrese id del tren: ");
        Tren tren = Tren.buscarTrenId(trenes, idTren);
        if (tren == null) {
            Pantalla.imprimir("No existe un tren con ese id. Se cancela la carga del viaje.");
            return null;
        }

        String dniMaquinista = Pantalla.leerString("Ingrese dni del maquinista: ");
        Empleado empleadoEncontrado = Empleado.buscarPorDni(empleados, dniMaquinista);
        if (!(empleadoEncontrado instanceof Maquinista)) {
            Pantalla.imprimir("No existe un maquinista con ese dni. Se cancela la carga del viaje.");
            return null;
        }
        Maquinista maquinista = (Maquinista) empleadoEncontrado;

        String dniGuarda = Pantalla.leerString("Ingrese dni del guarda: ");
        Guarda guarda = null;
        for (Guarda g : guardas) {
            if (g.getDni().equals(dniGuarda)) {
                guarda = g;
                break;
            }
        }
        if (guarda == null) {
            Pantalla.imprimir("No existe un guarda con ese dni. Se cancela la carga del viaje.");
            return null;
        }

        String fecha = Pantalla.leerString("Ingrese fecha (ej: 5/08/2024): ");
        String horaSalida = Pantalla.leerString("Ingrese hora de salida (ej: 08:25): ");
        String estacionSalida = Pantalla.leerString("Ingrese estación de salida: ");
        String estacionDestino = Pantalla.leerString("Ingrese estación de destino: ");

        Viaje nuevoViaje = new Viaje(codigo, maquinista, guarda, tren,
                fecha, horaSalida, estacionSalida, estacionDestino);

        Pantalla.imprimir("Viaje creado y guardado correctamente.");
        return nuevoViaje;
    }
}
