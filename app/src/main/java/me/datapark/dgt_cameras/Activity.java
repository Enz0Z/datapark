package me.datapark.dgt_cameras;

import android.content.Intent;
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

import cz.msebera.android.httpclient.Header;
import me.datapark.FormActivity;
import me.datapark.MapsActivity;
import me.datapark.ProfileActivity;
import me.datapark.R;

public class Activity extends AppCompatActivity {

    public static AsyncHttpClient client = new AsyncHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dgt_cameras);
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
                            CameraInformationDialogFragment fragment = new CameraInformationDialogFragment();
                            fragment.object = camera;

                            fragment.show(getSupportFragmentManager(), "camera");
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
        switch (item.getItemId()) {
            case R.id.home_button:
                goMap();
                break;
            case R.id.manage_profile:
                goProfile();
                break;
            case R.id.car_history:
                goForm();
                break;
            case R.id.dgt_cameras:
                break;
            case R.id.log_out:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void goForm() {
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }

    public void goProfile() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void goMap() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}