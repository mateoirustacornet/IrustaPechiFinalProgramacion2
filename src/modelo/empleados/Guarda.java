package modelo.empleados;

/**
 * Representa a un guarda, que es un tipo de Empleado.
 * El turno se calcula automáticamente al crear el objeto,
 * según los años de experiencia.
 */
public class Guarda extends Empleado {

    private int añosExperiencia;
    private String turno; // "día" o "noche", se calcula automáticamente

    public Guarda(String name, String apellido, String dni, int añosExperiencia) {
        super(name, apellido, dni);
        this.añosExperiencia = añosExperiencia;
        this.turno = calcularTurno(añosExperiencia);
    }

    /**
     * Calcula el turno según la cantidad de años de experiencia.
     * Más de 10 años -> turno "noche". 10 o menos -> turno "día".
     */
    private String calcularTurno(int añosExperiencia) {
        if (añosExperiencia > 10) {
            return "noche";
        } else {
            return "día";
        }
    }

    // ---------- Getters y Setters ----------

    public int getañosExperiencia() {
        return añosExperiencia;
    }

    /**
     * Al modificar los años de experiencia, se recalcula el turno automáticamente.
     */
    public void setañosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
        this.turno = calcularTurno(añosExperiencia);
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
        System.out.println("Años de experiencia: " + añosExperiencia);
        System.out.println("Turno: " + turno);
    }
}
