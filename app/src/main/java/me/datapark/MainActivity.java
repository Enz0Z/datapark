package me.datapark;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import me.datapark.profile.Activity;
import me.datapark.profile.RegisterActivity;

public class MainActivity extends AppCompatActivity {

    public static SQLiteDatabase DB;
    public static String Username;
    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB = openOrCreateDatabase("DataPark", Context.MODE_PRIVATE, null);

        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);

        MainActivity.DB.execSQL("CREATE TABLE IF NOT EXISTS vehicles(" +
                "plate VARCHAR," +
                "brand VARCHAR," +
                "model VARCHAR," +
                "fuel VARCHAR," +
                "power VARCHAR," +
                "notes VARCHAR);");

        MainActivity.DB.execSQL("CREATE TABLE IF NOT EXISTS users(" +
                "username VARCHAR," +
                "email VARCHAR," +
                "password VARCHAR);");
    }

    public void login(View view) {
        EditText[] editTexts = {username, password};

        for (EditText edit : editTexts) {
            if (TextUtils.isEmpty(edit.getText().toString().trim())) {
                Toast.makeText(this, R.string.fill_all_fields, Toast.LENGTH_LONG).show();
                return;
            }
        }
        if (MainActivity.DB.rawQuery("SELECT 1 FROM users WHERE username = '" + username.getText().toString() + "' AND password = '" + password.getText().toString() + "'", null).getCount() == 0) {
            Toast.makeText(this, "Incorrect user or password.", Toast.LENGTH_LONG).show();
            return;
        }
        Username = username.getText().toString();
        
        startActivity(new Intent(this, Activity.class));
    }

    public void register(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void forgotPassword(View view) {
        Snackbar.make(view, "Not implemented yet.", Snackbar.LENGTH_LONG).show();
    }
}