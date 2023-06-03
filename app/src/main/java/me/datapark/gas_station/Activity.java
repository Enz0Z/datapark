package me.datapark.gas_station;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.Collections;

import me.datapark.R;
import me.datapark.utils.MainMenu;

public class Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_station);
        SharedPreferences sharedPreferences = getSharedPreferences("osmdroid", MODE_PRIVATE);
        MapView mapView = findViewById(R.id.map);

        Configuration.getInstance().load(getApplicationContext(), sharedPreferences);
        mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MapView mapView = findViewById(R.id.map);

        GeoPoint point = new GeoPoint(40.7128, -74.0060);
        OverlayItem overlayItem = new OverlayItem("New York City", "Description", point);
        ItemizedIconOverlay<OverlayItem> itemizedIconOverlay = new ItemizedIconOverlay<>(Collections.singletonList(overlayItem), null, getApplicationContext());
        mapView.getOverlays().add(itemizedIconOverlay);
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