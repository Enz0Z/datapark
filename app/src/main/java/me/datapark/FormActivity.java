package me.datapark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import me.datapark.dgt_cameras.Activity;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }

    //TODO: METODOS DE LOS BOTONES PARA ENLAZAR CON LA BBDD (SAVE) Y LIMPIAR LOS EDITTEXT (CLEAR)
    public void clear(){}
    public void save(){}

    //CREACION DE MENU, SWITCH Y METODOS
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_profile,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.homeMenu:
                Toast.makeText(FormActivity.this, R.string.home, Toast.LENGTH_SHORT).show();
                goMap();
                break;
            case R.id.manageProfileMenu:
                Toast.makeText(FormActivity.this, R.string.profile, Toast.LENGTH_SHORT).show();
                goProfile();
                break;
            case R.id.defaultCarHistoryMenu:
                Toast.makeText(FormActivity.this, R.string.hereUare, Toast.LENGTH_SHORT).show();
                break;
            case R.id.alarmsMenu:
                Toast.makeText(FormActivity.this, R.string.dgtCam, Toast.LENGTH_SHORT).show();
                goDGT();
                break;
            case R.id.logOutMenu:
                Toast.makeText(FormActivity.this, R.string.logout, Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // PILA DE METODOS PARA EL MENU
    public void goProfile(){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Profile",Toast.LENGTH_LONG).show();
    }

    //TODO: ENZO, NO SE POR QUE NO ME FUFA ESTE SI PUEDES MIRATELO XD
    public void goMap(){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Mapa",Toast.LENGTH_LONG).show();
    }

    public void goDGT(){
        Intent intent = new Intent(this, Activity.class);
        startActivity(intent);
        Toast.makeText(this,"DGT",Toast.LENGTH_LONG).show();
    }

}