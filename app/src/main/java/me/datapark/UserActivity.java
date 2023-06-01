package me.datapark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import models.Car;

public class UserActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView miLista;
    private ArrayList<Car> items;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;
    private Button insertCar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //Menu parameters
        drawerLayout = findViewById(R.id.drawer_layout_profile);
        navigationView = findViewById(R.id.nav_view_profile);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open,R.string.close);
        menuImplementation();

        insertCar = findViewById(R.id.insertCarButton);
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

    public void menuImplementation(){
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homeMenu:{
                        Toast.makeText(UserActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.manageProfileMenu:{
                        Toast.makeText(UserActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.defaultCarHistoryMenu:{
                        Toast.makeText(UserActivity.this, "History", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.alarmsMenu:{
                        Toast.makeText(UserActivity.this, "Alarms", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.logOutMenu:{
                        Toast.makeText(UserActivity.this, "LogOut", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                return false;
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void changeAct(View view){
        Intent intent = new Intent(this,FormActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Form",Toast.LENGTH_LONG).show();
    }
}