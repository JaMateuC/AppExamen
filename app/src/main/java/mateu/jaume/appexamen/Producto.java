package mateu.jaume.appexamen;

import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 18/12/17.
 */

public class Producto {

    @SerializedName("numComprado")
    private int numComprado;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("coste")
    private double coste;

    public Producto() {
    }

    public Producto(String nombre, double coste, int numComprado) {
        this.numComprado = numComprado;
        this.nombre = nombre;
        this.coste = coste;
    }

    public int getNumComprado() {
        return numComprado;
    }

    public void setNumComprado(int numComprado) {
        this.numComprado = numComprado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

}
