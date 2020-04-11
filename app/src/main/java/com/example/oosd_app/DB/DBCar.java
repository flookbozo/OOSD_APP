package com.example.oosd_app.DB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.oosd_app.model.IllegalCar;

import java.util.concurrent.Executors;

@Database(entities = {IllegalCar.class}, exportSchema = false, version = 1)
public abstract class DBCar extends RoomDatabase {

    private static final String DB_NAME = "car.db";

    public abstract CarDao carDao();

    private static DBCar mInstance;

    public static synchronized DBCar getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room
                    .databaseBuilder(
                            context.getApplicationContext(),
                            DBCar.class,
                            DB_NAME
                    )
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);

                            Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                                @Override
                                public void run() {
                                    mInstance.carDao().insertCar(
                                            new IllegalCar(
                                                    0,"aaa", "aaa"
                                            )
                                    );
                                }
                            });
                        }
                    })
                    .build();
        }
        return mInstance;
    }

}
