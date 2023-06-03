package me.datapark;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import me.datapark.profile.Activity;

public class MainActivity extends AppCompatActivity {

    public static SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("DataPark", Context.MODE_PRIVATE, null);
    }

    public void goMap(View view) {
        Intent intent = new Intent(this, me.datapark.gas_station.Activity.class);
        startActivity(intent);
    }

    // TODO: Cambiar metodo ventana principal a goMap
    public void goProfile(View view) {
        Intent intent = new Intent(this, Activity.class);
        startActivity(intent);
    }

    public void goRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void goRememberPass(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}