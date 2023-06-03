package me.datapark.profile;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import me.datapark.MainActivity;
import me.datapark.R;
import me.datapark.utils.MainMenu;

public class VehicleCreateActivity extends AppCompatActivity {

    private EditText plate, brand, model, fueltype, power, notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_create);

        plate = findViewById(R.id.vehicle_plate);
        brand = findViewById(R.id.vehicle_brand);
        model = findViewById(R.id.vehicle_model);
        fueltype = findViewById(R.id.vehicle_fueltype);
        power = findViewById(R.id.vehicle_power);
        notes = findViewById(R.id.vehicle_notes);
    }

    public void clear(View view) {
        plate.setText("");
        brand.setText("");
        model.setText("");
        fueltype.setText("");
        power.setText("");
        notes.setText("");
    }

    public void save(View view) {
        EditText[] editTexts = {plate, brand, model, fueltype, power, notes};

        for (EditText edit : editTexts) {
            if (TextUtils.isEmpty(edit.getText().toString().trim())) {
                Toast.makeText(this, "Fill in all the fields", Toast.LENGTH_LONG).show();
                return;
            }
        }

        MainActivity.db.execSQL("INSERT INTO vehicles VALUES (" +
                "'" + plate.getText().toString() + "'," +
                "'" + brand.getText().toString() + "'," +
                "'" + model.getText().toString() + "'," +
                "'" + fueltype.getText().toString() + "'," +
                "'" + power.getText().toString() + "'," +
                "'" + notes.getText().toString() + "')");
        finish();
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