package me.datapark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import me.datapark.dgt_cameras.Activity;
import models.Car;

public class ProfileActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

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
        items.add(new Car("Citroen","Test","0000001X","Gasolina"));
        items.add(new Car("Citroen","C4","0000002X","Gasolina"));
        items.add(new Car("Citroen","Rodolfo","0000003X","Gasolina"));
        items.add(new Car("Citroen","Ferrari","0000004X","Gasolina"));

        try{
            miLista = findViewById(R.id.ListView);
            PersonalAdapter miAdapatador = new PersonalAdapter(this, R.layout.item_cars, items);
            miLista.setAdapter(miAdapatador);
            miLista.setOnItemClickListener(this);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //TODO: BOTON UPDATE PARA ACTUALIZAR NOMBRE Y MAIL DESDE EL PERFIL
    public void updateData(){}

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Se ha pulsado " + items.get(i), Toast.LENGTH_SHORT).show();
    }

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
                Toast.makeText(ProfileActivity.this, R.string.home, Toast.LENGTH_SHORT).show();
                goMap();
                break;
            case R.id.manageProfileMenu:
                Toast.makeText(ProfileActivity.this, R.string.hereUare, Toast.LENGTH_SHORT).show();
                break;
            case R.id.defaultCarHistoryMenu:
                Toast.makeText(ProfileActivity.this, R.string.newCar, Toast.LENGTH_SHORT).show();
                goForm();
                break;
            case R.id.alarmsMenu:
                Toast.makeText(ProfileActivity.this, R.string.dgtCam, Toast.LENGTH_SHORT).show();
                goDGT();
                break;
            case R.id.logOutMenu:
                Toast.makeText(ProfileActivity.this, R.string.logout, Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void goForm(){
        Intent intent = new Intent(this,FormActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Form",Toast.LENGTH_LONG).show();
    }

    public void goDGT(){
        Intent intent = new Intent(this, Activity.class);
        startActivity(intent);
        Toast.makeText(this,"DGT",Toast.LENGTH_LONG).show();
    }

    public void goMap(){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Mapa",Toast.LENGTH_LONG).show();
    }
}