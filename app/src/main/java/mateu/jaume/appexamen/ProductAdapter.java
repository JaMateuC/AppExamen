package mateu.jaume.appexamen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 18/12/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {


    private Context mCtx;

    private List<Producto> productList;

    public ProductAdapter(Context mCtx, List<Producto> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        Producto producto = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewCoste.setText("Coste: " + Double.toString(producto.getCoste()));
        holder.textViewComprados.setText("Comprados: " +producto.getNumComprado());
        holder.textViewNombre.setText("Nombre: " +producto.getNombre());


    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCoste;
        TextView textViewComprados;
        TextView textViewNombre;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewCoste = itemView.findViewById(R.id.textViewCoste);

            textViewComprados = itemView.findViewById(R.id.textViewComprados);

            textViewNombre = itemView.findViewById(R.id.textViewNombre);

        }
    }
}
