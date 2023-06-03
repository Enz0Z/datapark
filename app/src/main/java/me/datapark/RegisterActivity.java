package me.datapark;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void goSignin(View view) {
        //TODO: ENLACE BBDD
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}