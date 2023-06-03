package me.datapark;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import me.datapark.utils.MainMenu;

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
        MainMenu.onOptionsItemSelected(this, item);
        return super.onOptionsItemSelected(item);
    }
}