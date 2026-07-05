package modelo.empleados;

/**
 * Representa a un guarda, que es un tipo de Empleado.
 * El turno se calcula automáticamente al crear el objeto,
 * según los años de experiencia.
 */
public class Guarda extends Empleado {

    private int aniosExperiencia;
    private String turno; // "día" o "noche", se calcula automáticamente

    public Guarda(String name, String apellido, String dni, int aniosExperiencia) {
        super(name, apellido, dni);
        this.aniosExperiencia = aniosExperiencia;
        this.turno = calcularTurno(aniosExperiencia);
    }

    /**
     * Calcula el turno según la cantidad de años de experiencia.
     * Más de 10 años -> turno "noche". 10 o menos -> turno "día".
     */
    private String calcularTurno(int aniosExperiencia) {
        if (aniosExperiencia > 10) {
            return "noche";
        } else {
            return "día";
        }
    }

    // ---------- Getters y Setters ----------

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    /**
     * Al modificar los años de experiencia, se recalcula el turno automáticamente.
     */
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
        this.turno = calcularTurno(aniosExperiencia);
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    // ---------- Métodos ----------

    @Override
    public void mostrarDetalle() {
        super.mostrarDetalle();
        System.out.println("Años de experiencia: " + aniosExperiencia);
        System.out.println("Turno: " + turno);
    }
}
