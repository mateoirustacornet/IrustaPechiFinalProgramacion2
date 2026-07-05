package modelo.empleados;

/**
 * Representa a un maquinista, que es un tipo de Empleado.
 */
public class Maquinista extends Empleado {

    private String nroLicencia;      // código identificador
    private int nroViajesRealizados;
    private int categoria;           // puede ser 1, 2 o 3

    public Maquinista(String name, String apellido, String dni,
                       String nroLicencia, int nroViajesRealizados, int categoria) {
        super(name, apellido, dni);
        this.nroLicencia = nroLicencia;
        this.nroViajesRealizados = nroViajesRealizados;
        this.categoria = categoria;
    }

    // ---------- Getters y Setters ----------

    public String getNroLicencia() {
        return nroLicencia;
    }

    public void setNroLicencia(String nroLicencia) {
        this.nroLicencia = nroLicencia;
    }

    public int getNroViajesRealizados() {
        return nroViajesRealizados;
    }

    public void setNroViajesRealizados(int nroViajesRealizados) {
        this.nroViajesRealizados = nroViajesRealizados;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    // ---------- Métodos ----------

    @Override
    public void mostrarDetalle() {
        super.mostrarDetalle();
        System.out.println("Nro. Licencia: " + nroLicencia);
        System.out.println("Nro. Viajes realizados: " + nroViajesRealizados);
        System.out.println("Categoría: " + categoria);
    }
}
