package mateu.jaume.appexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExamenApp extends AppCompatActivity {

    private static Retrofit retrofit = null;
    public static final String BASE_URL = "http://localhost:8080/examen/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen_app);

        login();
    }

    public void login(){

        Button buttonCerca = (Button) findViewById(R.id.button);
        buttonCerca.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                getActivityResults();

            }
        });

    }

    public void getActivityResults(){

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        Rest RestApiService = retrofit.create(Rest.class);

        Call<String> call = RestApiService.getLogin();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(Boolean.valueOf(response.body()) && response.isSuccessful()){

                    Intent mainIntent = new Intent(ExamenApp.this,Main.class);
                    EditText username = (EditText) findViewById(R.id.editText);
                    String user = username.getText().toString();
                    mainIntent.putExtra("username", user);
                    startActivityForResult(mainIntent,1);
                }else{
                    Toast.makeText(getBaseContext(), "Error: Contrasena o username", Toast.LENGTH_LONG).show();
                }

            }
            @Override
            public void onFailure(Call<String> call, Throwable throwable) {

                Toast.makeText(getBaseContext(), "Error: No hay conexion con la API", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }

}
