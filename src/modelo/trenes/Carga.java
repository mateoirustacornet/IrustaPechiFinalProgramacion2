package modelo.trenes;

/**
 * Representa un tren de carga, que es un tipo de Tren.
 */
public class Carga extends Tren {

    private String tipoCarga; // puede ser "pesada" o "liviana"

    public Carga(String id, int cantidadVagones, String tipoCarga) {
        super(id, cantidadVagones);
        this.tipoCarga = tipoCarga;
    }

    // ---------- Getters y Setters ----------

    public String getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    // ---------- Métodos ----------

    @Override
    public void mostrarDetalle() {
        super.mostrarDetalle();
        System.out.println("Tipo de carga: " + tipoCarga);
    }
}
