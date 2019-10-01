package com.malfor.inventariomovil.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.malfor.datos.entidad.EntidadArticulo;
import com.malfor.inventariomovil.R;
import com.malfor.inventariomovil.adapter.RecyclerAdapterArticulos;
import com.malfor.inventariomovil.dialogo.DialogoAgregarArticulo;
import com.malfor.inventariomovil.viewmodel.ViewModelArticulo;

import java.util.ArrayList;
import java.util.List;

public class FragmentoArticulo extends Fragment {

    private ViewModelArticulo viewModelArticulo;

    private RecyclerAdapterArticulos adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new RecyclerAdapterArticulos(getContext(), new ArrayList<EntidadArticulo>());
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModelArticulo =
                ViewModelProviders.of(this).get(ViewModelArticulo.class);
        View root = inflater.inflate(R.layout.fragmento_articulo, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerArticulos);

        FloatingActionButton fab = root.findViewById(R.id.fab);

        viewModelArticulo.listarArticulos().observe(this, new Observer<List<EntidadArticulo>>() {
            @Override
            public void onChanged(List<EntidadArticulo> entidadArticulos) {
                try {
                    adapter.setArticulos(entidadArticulos);
                } catch (NullPointerException e) {
                    Toast.makeText(getContext(), "No hay articulos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar();
            }
        });

        return root;
    }

    private void guardar() {
        final DialogoAgregarArticulo dialogoAgregarArticulo = new DialogoAgregarArticulo();
        dialogoAgregarArticulo.show(getActivity().getSupportFragmentManager(), getString(R.string.agregar_articulo));
        getActivity().getSupportFragmentManager().executePendingTransactions();

        dialogoAgregarArticulo.botonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoAgregarArticulo.dismiss();
            }
        });

        dialogoAgregarArticulo.botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int codigo;
                String descripcion;
                double precio;

                if (dialogoAgregarArticulo.tieCodigo.getText().toString().equals("") ||
                        Integer.parseInt(dialogoAgregarArticulo.tieCodigo.getText().toString()) <= 0) {
                    dialogoAgregarArticulo.tilCodigo.setError(getString(R.string.error_codigo));
                    return;
                } else {
                    codigo = Integer.parseInt(dialogoAgregarArticulo.tieCodigo.getText().toString().trim());
                }

                if (dialogoAgregarArticulo.tieDescripcion.getText().toString().equals("") ||
                        dialogoAgregarArticulo.tieDescripcion.getText().toString().length() < 3) {
                    dialogoAgregarArticulo.tilDescripcion.setError(getString(R.string.error_descripcion));
                    return;
                } else {
                    descripcion = dialogoAgregarArticulo.tieDescripcion.getText().toString();
                }

                if (dialogoAgregarArticulo.tiePrecio.getText().toString().equals("") ||
                        Double.parseDouble(dialogoAgregarArticulo.tiePrecio.getText().toString().trim()) < 50) {
                    dialogoAgregarArticulo.tilPrecio.setError(getString(R.string.error_precio));
                    return;
                } else {
                    precio = Double.parseDouble(dialogoAgregarArticulo.tiePrecio.getText().toString().trim());
                }

                viewModelArticulo.guardar(new EntidadArticulo(codigo, descripcion, precio));
                dialogoAgregarArticulo.dismiss();
            }
        });
    }

}