package com.malfor.datos.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.malfor.datos.dao.ArticuloDao;
import com.malfor.datos.entidad.EntidadArticulo;

@Database(entities = {EntidadArticulo.class}, version = 1)
public abstract class BaseDeDatosInventario extends RoomDatabase {

    public abstract ArticuloDao articuloDao();

    private static volatile BaseDeDatosInventario INSTANCE;

    public static BaseDeDatosInventario getBaseDeDatos(final Context context) {
        if (INSTANCE == null) {
            synchronized (BaseDeDatosInventario.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BaseDeDatosInventario.class, "basededatos_inventario")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
