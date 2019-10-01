package com.malfor.inventariomovil.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.malfor.datos.entidad.EntidadArticulo;
import com.malfor.datos.repositorio.RepositorioArticulo;

import java.util.List;

public class ViewModelArticulo extends AndroidViewModel {

    private RepositorioArticulo repositorioArticulo;

    public ViewModelArticulo(@NonNull Application application) {
        super(application);
        repositorioArticulo = new RepositorioArticulo(application);
    }

    public LiveData<List<EntidadArticulo>> listarArticulos(){
        return repositorioArticulo.listarArticulos();
    }

    public void guardar(EntidadArticulo entidadArticulo){
        repositorioArticulo.guardar(entidadArticulo);
    }

}