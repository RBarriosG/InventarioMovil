package com.malfor.inventariomovil.dialogo;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.malfor.inventariomovil.R;

public class DialogoAgregarArticulo extends DialogFragment {

    public TextInputLayout tilCodigo;

    public TextInputEditText tieCodigo;

    public TextInputLayout tilDescripcion;

    public TextInputEditText tieDescripcion;

    public TextInputLayout tilPrecio;

    public TextInputEditText tiePrecio;

    public MaterialButton botonCancelar;

    public MaterialButton botonGuardar;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialogo_agregar_articulo, null);

        builder.setView(dialogView);

        tilCodigo = dialogView.findViewById(R.id.tilCodigo);
        tieCodigo = dialogView.findViewById(R.id.tieCodigo);
        tilDescripcion = dialogView.findViewById(R.id.tilDescripcion);
        tieDescripcion = dialogView.findViewById(R.id.tieDescripcion);
        tilPrecio = dialogView.findViewById(R.id.tilPrecio);
        tiePrecio = dialogView.findViewById(R.id.tiePrecio);
        botonCancelar = dialogView.findViewById(R.id.botonCancelar);
        botonGuardar = dialogView.findViewById(R.id.botonGuardar);

        return builder.create();
    }
}
