package me.datapark;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import me.datapark.utils.MainMenu;

public class FormActivity extends AppCompatActivity {

    private EditText model,brand, plate, fuel, tankSize, distance, power, notes;
    private Button save, clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        model = findViewById(R.id.carModelField);
        brand = findViewById(R.id.brandField);
        plate = findViewById(R.id.plateField);
        fuel = findViewById(R.id.fuelTypeField);
        tankSize = findViewById(R.id.fuelSizeField);
        distance = findViewById(R.id.distanceField);
        power = findViewById(R.id.powerField);
        notes = findViewById(R.id.descriptionField);
        save = findViewById(R.id.saveButton);
        clear = findViewById(R.id.cleanButton);
    }

    public void clear(View view) {
        model.setText("");
        brand.setText("");
        plate.setText("");
        fuel.setText("");
        tankSize.setText("");
        distance.setText("");
        power.setText("");
        notes.setText("");
    }

    //TODO: ENLAZAR CON LA BBDD (SAVE)
    public void save(View view) {
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