package com.malfor.datos.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.malfor.datos.entidad.EntidadArticulo;

import java.util.List;

@Dao
public interface ArticuloDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void guardar(EntidadArticulo entidadArticulo);

    @Query("SELECT * FROM articulos ORDER BY codigo ASC")
    LiveData<List<EntidadArticulo>> listarArticulos();

}
