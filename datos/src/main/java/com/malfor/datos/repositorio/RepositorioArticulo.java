package com.malfor.datos.repositorio;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.malfor.datos.dao.ArticuloDao;
import com.malfor.datos.db.BaseDeDatosInventario;
import com.malfor.datos.entidad.EntidadArticulo;

import java.util.List;

public class RepositorioArticulo {

    private ArticuloDao articuloDao;

    public RepositorioArticulo(Application application) {
        BaseDeDatosInventario baseDeDatosInventario = BaseDeDatosInventario.getBaseDeDatos(application);
        this.articuloDao = baseDeDatosInventario.articuloDao();
    }

    public LiveData<List<EntidadArticulo>> listarArticulos(){
        return articuloDao.listarArticulos();
    }

    public void guardar(EntidadArticulo entidadArticulo){
        new GuardarAsyncTask(articuloDao).execute(entidadArticulo);
    }

    private static class GuardarAsyncTask extends AsyncTask<EntidadArticulo, Void, Void>{

        private ArticuloDao mArticuloDao;

        GuardarAsyncTask(ArticuloDao mArticuloDao) {
            this.mArticuloDao = mArticuloDao;
        }

        @Override
        protected Void doInBackground(EntidadArticulo... entidadArticulos) {
            mArticuloDao.guardar(entidadArticulos[0]);
            return null;
        }
    }

}
