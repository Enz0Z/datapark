package me.datapark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goMap(View view){
            Intent intent = new Intent(this,MapsActivity.class);
            startActivity(intent);
            Toast.makeText(this,"Mapa",Toast.LENGTH_LONG).show();
    }

    // TODO: Cambiar metodo ventana principal a goMap
    public void goProfile(View view){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Profile",Toast.LENGTH_LONG).show();
    }

    public void goRegister(View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Registro!",Toast.LENGTH_LONG).show();
    }

    public void goRememberPass(View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Registro!",Toast.LENGTH_LONG).show();
    }

}