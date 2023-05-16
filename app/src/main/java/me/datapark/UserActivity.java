package me.datapark;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    public ListView miLista;
    public ArrayList<String> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        items = new ArrayList<>();
        items.add("New Car");
        items.add("New Car");
        items.add("New Car");items.add("New Car");


        try{
            miLista = findViewById(R.id.ListView);
            ArrayAdapter<String> miAdapatador = new ArrayAdapter<>(this,R.layout.item_cars, items);
            //puente entre contenedor y datos
            miLista.setAdapter(miAdapatador);
            miLista.setOnItemClickListener(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Se ha pulsado " + items.get(i), Toast.LENGTH_SHORT).show();
    }
}