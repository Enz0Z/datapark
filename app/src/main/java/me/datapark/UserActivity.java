package me.datapark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import models.Car;

public class UserActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    public ListView miLista;
    public ArrayList<Car> items;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        items = new ArrayList<>();
        items.add(new Car("Citroen","Test","0000001X","Gasolina"));
        items.add(new Car("Citroen","C4","0000002X","Gasolina"));
        items.add(new Car("Citroen","Rodolfo","0000003X","Gasolina"));
        items.add(new Car("Citroen","Ferrari","0000004X","Gasolina"));

        try{
            miLista = (ListView) findViewById(R.id.ListView);
            PersonalAdapter miAdapatador = new PersonalAdapter(this, R.layout.item_cars, items);
            miLista.setAdapter(miAdapatador);
            miLista.setOnItemClickListener(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Se ha pulsado " + items.get(i), Toast.LENGTH_SHORT).show();
    }
}