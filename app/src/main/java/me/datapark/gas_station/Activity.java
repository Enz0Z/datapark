package me.datapark.gas_station;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.OverlayItem;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import me.datapark.R;
import me.datapark.utils.MainMenu;

public class Activity extends AppCompatActivity {

    public static AsyncHttpClient client = new AsyncHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_station);
        setTitle(R.string.gas_stations);
        SharedPreferences sharedPreferences = getSharedPreferences("osmdroid", MODE_PRIVATE);
        MapView mapView = findViewById(R.id.map);

        mapView.getController().setZoom(9);
        mapView.getController().setCenter(new GeoPoint(40.416442, -3.7038013));
        Configuration.getInstance().load(getApplicationContext(), sharedPreferences);
        mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE);

        client.get(getString(R.string.gas_stations_url), new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                Snackbar.make(mapView, getString(R.string.loading), Snackbar.LENGTH_LONG).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody, StandardCharsets.UTF_8);
                    JSONObject json = new JSONObject(result);
                    JSONArray stations = json.getJSONArray("ListaEESSPrecio");
                    List<OverlayItem> items = new ArrayList<>();

                    for (int i = 0; i < stations.length(); i++) {
                        JSONObject station = stations.getJSONObject(i);

                        if (!station.getString("Provincia").equals("MADRID")) continue;
                        ArrayList<String> message = new ArrayList<>();

                        if (!station.getString("Precio Biodiesel").equals(""))
                            message.add("Biodiesel" + "\n    €" + station.getString("Precio Biodiesel").replace(",", ".") + "/L");
                        if (!station.getString("Precio Bioetanol").equals(""))
                            message.add("Bioetanol" + "\n    €" + station.getString("Precio Bioetanol").replace(",", ".") + "/L");
                        if (!station.getString("Precio Gas Natural Comprimido").equals(""))
                            message.add("Gas Natural Comprimido" + "\n    €" + station.getString("Precio Gas Natural Comprimido").replace(",", ".") + "/L");
                        if (!station.getString("Precio Gas Natural Licuado").equals(""))
                            message.add("Gas Natural Licuado" + "\n    €" + station.getString("Precio Gas Natural Licuado").replace(",", ".") + "/L");
                        if (!station.getString("Precio Gases licuados del petróleo").equals(""))
                            message.add("Gases licuados del petróleo" + "\n    €" + station.getString("Precio Gases licuados del petróleo").replace(",", ".") + "/L");
                        if (!station.getString("Precio Gasoleo A").equals(""))
                            message.add("Gasoleo A" + "\n    €" + station.getString("Precio Gasoleo A").replace(",", ".") + "/L");
                        if (!station.getString("Precio Gasoleo B").equals(""))
                            message.add("Gasoleo B" + "\n    €" + station.getString("Precio Gasoleo B").replace(",", ".") + "/L");
                        if (!station.getString("Precio Gasoleo Premium").equals(""))
                            message.add("Gasoleo Premium" + "\n    €" + station.getString("Precio Gasoleo Premium").replace(",", ".") + "/L");
                        if (!station.getString("Precio Gasolina 95 E10").equals(""))
                            message.add("Gasolina 95 E10" + "\n    €" + station.getString("Precio Gasolina 95 E10").replace(",", ".") + "/L");
                        if (!station.getString("Precio Gasolina 95 E5").equals(""))
                            message.add("Gasolina 95 E5" + "\n    €" + station.getString("Precio Gasolina 95 E5").replace(",", ".") + "/L");
                        if (!station.getString("Precio Gasolina 95 E5 Premium").equals(""))
                            message.add("Gasolina 95 E5 Premium" + "\n    €" + station.getString("Precio Gasolina 95 E5 Premium").replace(",", ".") + "/L");
                        if (!station.getString("Precio Gasolina 98 E10").equals(""))
                            message.add("Gasolina 98 E10" + "\n    €" + station.getString("Precio Gasolina 98 E10").replace(",", ".") + "/L");
                        if (!station.getString("Precio Gasolina 98 E5").equals(""))
                            message.add("Gasolina 98 E5" + "\n    €" + station.getString("Precio Gasolina 98 E5").replace(",", ".") + "/L");
                        if (!station.getString("Precio Hidrogeno").equals(""))
                            message.add("Hidrogeno" + "\n    €" + station.getString("Precio Hidrogeno").replace(",", ".") + "/L");

                        GeoPoint point = new GeoPoint(
                                Double.parseDouble(station.getString("Latitud").replace(",", ".")),
                                Double.parseDouble(station.getString("Longitud (WGS84)").replace(",", "."))
                        );
                        OverlayItem overlayItem = new OverlayItem(
                                station.getString("Dirección"),
                                String.join("\n\n", message),
                                point
                        );

                        items.add(overlayItem);
                    }
                    ItemizedIconOverlay<OverlayItem> itemizedIconOverlay = new ItemizedIconOverlay<>(items, new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                        @Override
                        public boolean onItemSingleTapUp(int index, OverlayItem item) {
                            StationInformationDialogFragment fragment = new StationInformationDialogFragment();
                            fragment.title = item.getTitle();
                            fragment.snippet = item.getSnippet();

                            fragment.show(getSupportFragmentManager(), "station");
                            return true;
                        }

                        @Override
                        public boolean onItemLongPress(int index, OverlayItem item) {
                            return false;
                        }
                    }, getApplicationContext());
                    mapView.getOverlays().add(itemizedIconOverlay);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
            }

            @Override
            public void onRetry(int retryNo) {
            }
        });
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