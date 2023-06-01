package me.datapark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class FormActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        //Menu parameters
        drawerLayout = findViewById(R.id.drawer_layout_form);
        navigationView = findViewById(R.id.nav_view_form);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open,R.string.close);
        menuImplementation();
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
                        Toast.makeText(FormActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.manageProfileMenu:{
                        Toast.makeText(FormActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.defaultCarHistoryMenu:{
                        Toast.makeText(FormActivity.this, "History", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.alarmsMenu:{
                        Toast.makeText(FormActivity.this, "Alarms", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.logOutMenu:{
                        Toast.makeText(FormActivity.this, "LogOut", Toast.LENGTH_SHORT).show();
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
}