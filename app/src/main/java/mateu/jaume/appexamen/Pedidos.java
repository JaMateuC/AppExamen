package mateu.jaume.appexamen;

import java.util.ArrayList;

/**
 * Created by root on 18/12/17.
 */

public class Pedidos {

    private ArrayList<Producto> productos = new ArrayList<>();
    private String usuario;

    public Pedidos(String usuario, ArrayList<Producto> listPro) {
        this.usuario = usuario;
        this.productos = listPro;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
