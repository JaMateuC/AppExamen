package mateu.jaume.appexamen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProduList extends AppCompatActivity {

    private ArrayList<Integer> compadosP;
    private ArrayList<String> nombresP;
    private ArrayList<String> costeP;
    private ArrayList<Producto> prodList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produ_list);
        compadosP = new ArrayList<>();
        nombresP = new ArrayList<>();
        costeP = new ArrayList<>();

        Bundle extras = getIntent().getExtras();

        compadosP = extras.getIntegerArrayList("compadosP");
        costeP = extras.getStringArrayList("costeP");
        nombresP = extras.getStringArrayList("nombreP");


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        for(int i = 0;  i < compadosP.size(); i++){

            prodList.add(new Producto(nombresP.get(i),Double.parseDouble(costeP.get(i)),compadosP.get(i)));

        }

        mAdapter = new ProductAdapter(this,prodList);
        mRecyclerView.setAdapter(mAdapter);

    }





}
