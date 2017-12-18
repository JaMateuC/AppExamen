package mateu.jaume.appexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main extends AppCompatActivity {

    private String operation;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");

    }

    public void ordenarProductos(){

        Button buttonCerca = (Button) findViewById(R.id.button);
        buttonCerca.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Button operationName = (Button) findViewById(R.id.button2);
                operation = operationName.getText().toString();
                getNewAct();

            }
        });

    }

    public void PedidosRealizados(){

        Button buttonCerca = (Button) findViewById(R.id.button);
        buttonCerca.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Button operationName = (Button) findViewById(R.id.button3);
                operation = operationName.getText().toString();
                getNewAct();

            }
        });

    }

    public void getNewAct(){

        Intent proIntent = new Intent(Main.this,Progress.class);

        proIntent.putExtra("operation", operation);
        proIntent.putExtra("username",username);
        startActivityForResult(proIntent,1);

    }



}
