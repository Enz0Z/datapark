package me.datapark;

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

import me.datapark.utils.MainMenu;
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