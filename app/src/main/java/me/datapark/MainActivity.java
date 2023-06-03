package me.datapark;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import me.datapark.profile.Activity;
import me.datapark.profile.RegisterActivity;

public class MainActivity extends AppCompatActivity {

    public static SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("DataPark", Context.MODE_PRIVATE, null);
    }

    public void goMap(View view) {
        Intent intent = new Intent(this, GasStationsActivity.class);
        startActivity(intent);
    }

    // TODO: Cambiar metodo ventana principal a goMap
    public void login(View view) {
        Intent intent = new Intent(this, Activity.class);
        startActivity(intent);
    }

    public void register(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void forgotPassword(View view) {
        Snackbar.make(view, "Not implemented yet.", Snackbar.LENGTH_LONG).show();
    }
}