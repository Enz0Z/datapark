package me.datapark.profile;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import me.datapark.MainActivity;
import me.datapark.R;
import me.datapark.utils.MainMenu;

public class Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        MainActivity.db.execSQL("CREATE TABLE IF NOT EXISTS vehicles(" +
                "plate VARCHAR," +
                "brand VARCHAR," +
                "model VARCHAR," +
                "fuel VARCHAR," +
                "power VARCHAR," +
                "notes VARCHAR);");
    }

    @Override
    public void onResume() {
        super.onResume();
        refresh();
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

    public void refresh() {
        ListView list = findViewById(R.id.ListView);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Cursor cursor = MainActivity.db.rawQuery("SELECT * FROM vehicles", null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                vehicles.add(new Vehicle(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)
                ));
                cursor.moveToNext();
            }
        }
        cursor.close();

        list.setAdapter(new VehicleAdapter(this, R.layout.item_cars, vehicles));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity.db.delete("vehicles", "plate = ?", new String[]{vehicles.get(i).getPlate()});
                refresh();
            }
        });
    }
}