package mateu.jaume.appexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static mateu.jaume.appexamen.ExamenApp.BASE_URL;

public class Progress extends AppCompatActivity {

    private static Retrofit retrofit = null;
    private String username;
    private String operacio;
    private ArrayList<Producto> listaPro;
    private ArrayList<Integer> compradosP;
    private ArrayList<String> nombresP;
    private ArrayList<Double> costesP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        operacio = extras.getString("operacio");
        listaPro = new ArrayList<>();
        compradosP = new ArrayList<>();
        nombresP = new ArrayList<>();
        costesP = new ArrayList<>();
    }

    public void getActivityResultsListaOrdenada(){

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        Rest RestApiService = retrofit.create(Rest.class);

        Call<List<Producto>> call = RestApiService.getListProductos();

        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {

                if(response.isSuccessful()) {
                    if (!response.body().isEmpty()) {
                        Intent ProdIntent = new Intent(Progress.this, Main.class);
                        listaPro.addAll(response.body());
                        createStringLists();
                        ProdIntent.putExtra("nombres",nombresP);
                        ProdIntent.putExtra("numComprados",compradosP);
                        ProdIntent.putExtra("precio",costesP);
                        startActivityForResult(ProdIntent, 1);
                    } else {
                        Toast.makeText(getBaseContext(), "Info: No hay productos", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getBaseContext(), "Error: error con la respuesta", Toast.LENGTH_LONG).show();
                }

            }
            @Override
            public void onFailure(Call<List<Producto>> call, Throwable throwable) {

                Toast.makeText(getBaseContext(), "Error: No hay conexion con la API", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }

    public void getActivityResultsListaOrdenada(){

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        Rest RestApiService = retrofit.create(Rest.class);

        Call<List<Producto>> call = RestApiService.getListProductos();

        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {

                if(response.isSuccessful()) {
                    if (!response.body().isEmpty()) {
                        Intent ProdIntent = new Intent(Progress.this.getBaseContext(), Main.class);

                        listaPro.addAll(response.body());
                        ProdIntent.putExtra("Productos",nombresP);
                        startActivityForResult(ProdIntent, 1);
                    } else {
                        Toast.makeText(getBaseContext(), "Info: No hay productos", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getBaseContext(), "Error: error con la respuesta", Toast.LENGTH_LONG).show();
                }

            }
            @Override
            public void onFailure(Call<List<Producto>> call, Throwable throwable) {

                Toast.makeText(getBaseContext(), "Error: No hay conexion con la API", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }

    public void createStringLists(){

        for(Producto pro: listaPro){

            nombresP.add(pro.getNombre());
            costesP.add(pro.getCoste());
            compradosP.add(pro.getNumComprado());

        }

    }



}
