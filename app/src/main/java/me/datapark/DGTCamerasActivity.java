package me.datapark;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import me.datapark.utils.InformationDialogFragment;
import me.datapark.utils.MainMenu;

public class DGTCamerasActivity extends AppCompatActivity {

    public static AsyncHttpClient client = new AsyncHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dgt_cameras);
        setTitle(R.string.dgt_cameras);
        LinearLayout layout = findViewById(R.id.dgt_cameras_layout);

        client.get(getString(R.string.dgt_cameras_url), new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                Snackbar.make(layout, getString(R.string.loading), Snackbar.LENGTH_LONG).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody, StandardCharsets.UTF_8);
                    JSONObject json = new JSONObject(result);
                    JSONArray cameras = json.getJSONArray("camaras");

                    for (int i = 0; i < cameras.length(); i++) {
                        JSONObject camera = cameras.getJSONObject(i);

                        if (!camera.getString("provincia").equals("28")) continue;
                        ImageButton button = new ImageButton(getApplicationContext());

                        button.setOnClickListener(click -> {
                            try {
                                ArrayList<String> messages = new ArrayList<>();

                                messages.add(getString(R.string.date) + " " + camera.getString("fecha"));
                                messages.add(getString(R.string.direction) + " " + camera.getString("sentido"));
                                messages.add(getString(R.string.latitude) + " " + camera.getString("latitud"));
                                messages.add(getString(R.string.longitude) + " " + camera.getString("longitud"));
                                messages.add(getString(R.string.province) + " " + camera.getString("provincia"));
                                messages.add(getString(R.string.pk) + " " + camera.getString("pk"));
                                new InformationDialogFragment(camera.getString("carretera"), messages).show(getSupportFragmentManager(), "camera");
                            } catch (Exception e) {
                            }
                        });
                        loadBipmapFromUrl(button, camera.getString("imagen"));
                        layout.addView(button);
                    }
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

    public static void loadBipmapFromUrl(ImageButton button, String url) {
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                InputStream targetStream = new ByteArrayInputStream(responseBody);
                Bitmap bmp = BitmapFactory.decodeStream(targetStream);

                button.setImageBitmap(bmp);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
            }

            @Override
            public void onRetry(int retryNo) {
            }
        });
    }

    //CREACION DE MENU, SWITCH Y METODOS
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