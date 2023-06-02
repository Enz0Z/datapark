package me.datapark;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import me.datapark.dgt_cameras.Activity;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }

    //TODO: METODOS DE LOS BOTONES PARA ENLAZAR CON LA BBDD (SAVE) Y LIMPIAR LOS EDITTEXT (CLEAR)
    public void clear() {
    }

    public void save() {
    }

    //CREACION DE MENU, SWITCH Y METODOS
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_button:
                goMap();
                break;
            case R.id.manage_profile:
                goProfile();
                break;
            case R.id.car_history:
                break;
            case R.id.dgt_cameras:
                goDGT();
                break;
            case R.id.log_out:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // PILA DE METODOS PARA EL MENU
    public void goProfile() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    //TODO: ENZO, NO SE POR QUE NO ME FUFA ESTE SI PUEDES MIRATELO XD
    public void goMap() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void goDGT() {
        Intent intent = new Intent(this, Activity.class);
        startActivity(intent);
    }

}