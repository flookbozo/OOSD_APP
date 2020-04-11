package com.example.oosd_app.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "car")
public class IllegalCar {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "imagecar")
    public String imageCar;

    @ColumnInfo(name = "numbercar")
    public String numberCar;


    public IllegalCar(int id, String imageCar, String numberCar) {
        this.id = id;
        this.imageCar = imageCar;
        this.numberCar = numberCar;
    }
}
