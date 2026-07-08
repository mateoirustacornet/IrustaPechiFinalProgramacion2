package modelo.trenes;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase abstracta que representa un tren.
 * Es superclase de Carga y Pasajeros.
 * Implementa Comparable para poder ordenar/comparar trenes según
 * su cantidad de vagones.
 */
public abstract class Tren implements Comparable<Tren> {

    protected String id;
    protected int cantidadVagones;

    public Tren(String id, int cantidadVagones) {
        this.id = id;
        this.cantidadVagones = cantidadVagones;
    }

    // ---------- Getters y Setters ----------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCantidadVagones() {
        return cantidadVagones;
    }

    public void setCantidadVagones(int cantidadVagones) {
        this.cantidadVagones = cantidadVagones;
    }

    // ---------- Métodos ----------

    /**
     * Compara trenes según su cantidad de vagones (orden ascendente).
     */
    @Override
    public int compareTo(Tren otroTren) {
        return Integer.compare(this.cantidadVagones, otroTren.cantidadVagones);
    }

    /**
     * Muestra el detalle del tren por consola.
     * Las subclases (Carga, Pasajeros) sobrescriben este método
     * para agregar sus propios atributos.
     */
    public void mostrarDetalle() {
        System.out.println("Tipo: " + this.getClass().getSimpleName());
        System.out.println("Id: " + id);
        System.out.println("Cantidad de vagones: " + cantidadVagones);
    }

    /**
     * Busca, dentro de una lista de trenes, el/los trenes con más vagones.
     * @param trenes lista de trenes donde buscar
     * @param n cantidad de trenes con más vagones que se desean obtener
     * @return una lista con los "n" trenes con mayor cantidad de vagones,
     *         ordenados de mayor a menor.
     */
    public static ArrayList<Tren> buscarTrenConMasVagones(ArrayList<Tren> trenes, int n) {
        ArrayList<Tren> copia = new ArrayList<>(trenes);
        Collections.sort(copia, Collections.reverseOrder());

        ArrayList<Tren> resultado = new ArrayList<>();
        for (int i = 0; i < copia.size() && i < n; i++) {
            resultado.add(copia.get(i));
        }
        return resultado;
    }

    /**
     * Busca un tren dentro de una lista según su id.
     * @param trenes lista de trenes donde buscar
     * @param nro id del tren a buscar
     * @return el Tren encontrado, o null si no existe coincidencia
     */
    public static Tren buscarTrenId(ArrayList<Tren> trenes, String nro) {
        for (Tren t : trenes) {
            if (t.getId().equals(nro)) {
                return t;
            }
        }
        return null;
    }
}
