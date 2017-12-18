package mateu.jaume.appexamen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 18/12/17.
 */

/*public class PedidoAdapter extends RecyclerView.Adapter<PedidoAdapter.PedidoViewHolder> {


    private Context mCtx;

    private List<Pedidos> pedidoList;
    private List<String> productoList;
    private List<Producto> productoListInit;
    private ArrayAdapter<String> adapter;

    public PedidoAdapter(Context mCtx, List<Pedidos> pedidoList) {
        this.mCtx = mCtx;
        this.pedidoList = pedidoList;
    }

    @Override
    public PedidoAdapter.PedidoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_pedido_layout, null);
        return new PedidoAdapter.PedidoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ProductViewHolder holder, int position) {
        //getting the product of the specified position
        Pedidos pedido = pedidoList.get(position);

        //binding the data with the viewholder views
        holder.textViewNombre.setText("Usuario: " + pedido.getUsuario());



        adapter = new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,
                productoList);


    }


    @Override
    public int getItemCount() {
        return pedidoList.size();
    }


    class PedidoViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNombre;
        ListView operList;

        public PedidoViewHolder(View itemView) {
            super(itemView);

            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            operList = itemView.findViewById(R.id.listaOperations);
            operList.setAdapter(adapter);

            listCreator();

            adapter.notifyDataSetChanged();


        }
    }

    public void listCreator(){

        int count = 1;

        for(Producto pro: productoListInit){

            productoList.add("Nombre: " + pro.getCoste() + ", Coste: " +
            pro.getCoste() + ", Comprados: " + pro.getNumComprado());

            count++;

        }

    }
}*/
