package modelo.empleados;

import java.util.ArrayList;

/**
 * Clase abstracta que representa un empleado de la empresa de trenes.
 * Es superclase de Maquinista y Guarda.
 */
public abstract class Empleado {

    protected String name;
    protected String apellido;
    protected String dni;

    public Empleado(String name, String apellido, String dni) {
        this.name = name;
        this.apellido = apellido;
        this.dni = dni;
    }

    // ---------- Getters y Setters ----------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // ---------- Métodos ----------

    /**
     * Muestra el detalle del empleado por consola.
     * Las subclases (Maquinista, Guarda) sobrescriben este método
     * para agregar sus propios atributos.
     */
    public void mostrarDetalle() {
        System.out.println("Tipo: " + this.getClass().getSimpleName());
        System.out.println("Nombre: " + name);
        System.out.println("Apellido: " + apellido);
        System.out.println("DNI: " + dni);
    }

    /**
     * Busca un empleado dentro de una lista según su dni.
     * @param empleados lista de empleados donde buscar
     * @param dni dni a buscar
     * @return el Empleado encontrado, o null si no existe coincidencia
     */
    public static Empleado buscarPorDni(ArrayList<Empleado> empleados, String dni) {
        for (Empleado e : empleados) {
            if (e.getDni().equals(dni)) {
                return e;
            }
        }
        return null;
    }
}
