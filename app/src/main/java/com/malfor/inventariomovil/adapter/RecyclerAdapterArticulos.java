package com.malfor.inventariomovil.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.malfor.datos.entidad.EntidadArticulo;
import com.malfor.inventariomovil.R;

import java.util.List;

public class RecyclerAdapterArticulos extends RecyclerView.Adapter<RecyclerViewHolderArticulos> {

    private Context context;

    private LayoutInflater inflater;

    private List<EntidadArticulo> articulos;

    public RecyclerAdapterArticulos(Context context, List<EntidadArticulo> articulos) {
        this.context = context;
        this.articulos = articulos;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerViewHolderArticulos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolderArticulos(inflater.inflate(R.layout.item_articulo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolderArticulos holder, int position) {
        holder.imagenArticulo.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_manzana));
        holder.textCodigo.setText(String.valueOf(articulos.get(position).getCodigo()));
        holder.textDescripcion.setText(String.valueOf(articulos.get(position).getDescripcion()));
        holder.textPrecio.setText(String.format("$ %s", articulos.get(position).getPrecio()));
    }

    @Override
    public int getItemCount() {
        return articulos.size();
    }

    public void setArticulos(List<EntidadArticulo> articulos){
        this.articulos = articulos;
        notifyDataSetChanged();
    }
}
