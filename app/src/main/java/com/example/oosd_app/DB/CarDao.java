package com.example.oosd_app.DB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.oosd_app.model.IllegalCar;

import java.util.List;

@Dao
public interface CarDao {

    @Query("SELECT * FROM car")
    List<IllegalCar> getAllCar();

    @Insert
    void insertCar(IllegalCar illegalCar);
}
