package com.malfor.inventariomovil.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.malfor.inventariomovil.R;

public class RecyclerViewHolderArticulos extends RecyclerView.ViewHolder {

    ImageView imagenArticulo;

    TextView textCodigo;

    TextView textDescripcion;

    TextView textPrecio;

    public RecyclerViewHolderArticulos(@NonNull View itemView) {
        super(itemView);

        imagenArticulo = itemView.findViewById(R.id.imagenArticulo);

        textCodigo = itemView.findViewById(R.id.textCodigo);

        textDescripcion = itemView.findViewById(R.id.textDescripcion);

        textPrecio = itemView.findViewById(R.id.textPrecio);
    }
}
