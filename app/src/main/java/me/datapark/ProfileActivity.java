package me.datapark;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import me.datapark.dgt_cameras.Activity;
import models.Car;

public class ProfileActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView miLista;
    private ArrayList<Car> items;
    private Button insertCar, update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        insertCar = findViewById(R.id.insertCarButton);
        update = findViewById(R.id.updateProfile);
        items = new ArrayList<>();
        items.add(new Car("Citroen", "Test", "0000001X", "Gasolina"));
        items.add(new Car("Citroen", "C4", "0000002X", "Gasolina"));
        items.add(new Car("Citroen", "Rodolfo", "0000003X", "Gasolina"));
        items.add(new Car("Citroen", "Ferrari", "0000004X", "Gasolina"));

        try {
            miLista = findViewById(R.id.ListView);
            PersonalAdapter miAdapatador = new PersonalAdapter(this, R.layout.item_cars, items);
            miLista.setAdapter(miAdapatador);
            miLista.setOnItemClickListener(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TODO: BOTON UPDATE PARA ACTUALIZAR NOMBRE Y MAIL DESDE EL PERFIL
    public void updateData() {
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Se ha pulsado " + items.get(i), Toast.LENGTH_SHORT).show();
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
                break;
            case R.id.car_history:
                goForm();
                break;
            case R.id.dgt_cameras:
                goDGT();
                break;
            case R.id.log_out:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void goForm() {
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }

    public void goDGT() {
        Intent intent = new Intent(this, Activity.class);
        startActivity(intent);
    }

    public void goMap() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}