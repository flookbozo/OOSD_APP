package com.example.oosd_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oosd_app.DB.DBCar;
import com.example.oosd_app.model.IllegalCar;

public class MainActivity extends AppCompatActivity {

    private DBCar mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = DBCar.getInstance(MainActivity.this);
        Button uploadImage = findViewById(R.id.upload_button);
        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText imageEditText = findViewById(R.id.image_edit_text);
                String imageCar = imageEditText.getText().toString();
                if (imageCar.isEmpty()){
                    Toast.makeText(
                            MainActivity.this,
                            "กรุณาอัพโหลดรูปภาพ",
                            Toast.LENGTH_SHORT)
                            .show();
                }
                else{
                    Toast.makeText(
                            MainActivity.this,
                            "อัพโหลดสำเร็จ",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        Button addIllegalCar = findViewById(R.id.enter_button);
        addIllegalCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText imageEditText = findViewById(R.id.image_edit_text);
                String imageCar = imageEditText.getText().toString();

                EditText numberEditText = findViewById(R.id.number_edit_text);
                final String numberCar = numberEditText.getText().toString();

                final IllegalCar illegalCar = new IllegalCar(0, imageCar, numberCar);
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                            mDatabase.carDao().insertCar(illegalCar);
                    }
                });
                t.start();
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });

        Button searchCar = findViewById(R.id.search_button2);
        searchCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}
