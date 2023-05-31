package me.datapark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeAct(View view){
            Intent intent = new Intent(this,TestMenu.class);
            startActivity(intent);
            Toast.makeText(this,"Perfil",Toast.LENGTH_LONG).show();
    }

    public void registerAct(View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Registro!",Toast.LENGTH_LONG).show();
    }

    public void forgotPassAct(View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Registro!",Toast.LENGTH_LONG).show();
    }

}