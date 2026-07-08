package modelo.trenes;

/**
 * Representa un tren de pasajeros, que es un tipo de Tren.
 */
public class Pasajeros extends Tren {

    private String tipoMotor; // puede ser "eléctrico" o "gasolero"

    public Pasajeros(String id, int cantidadVagones, String tipoMotor) {
        super(id, cantidadVagones);
        this.tipoMotor = tipoMotor;
    }

    // ---------- Getters y Setters ----------

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    // ---------- Métodos ----------

    @Override
    public void mostrarDetalle() {
        super.mostrarDetalle();
        System.out.println("Tipo de motor: " + tipoMotor);
    }
}
