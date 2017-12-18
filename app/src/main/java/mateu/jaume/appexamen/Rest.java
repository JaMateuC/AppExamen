package mateu.jaume.appexamen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by root on 18/12/17.
 */

public interface Rest {

    @GET("login")
    Call<String> getLogin();

    @GET("got/listaOrdenada/precio")
    Call<List<Producto>> getListProductos();

    @GET("got/pedidos/{username}")
    Call<List<Pedidos>> getListPedidos(@Path("username") String username);

}
