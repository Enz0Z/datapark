package me.datapark.profile;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import me.datapark.MainActivity;
import me.datapark.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText username, email, password, confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.register_username);
        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);
        confirm_password = findViewById(R.id.register_confirm_password);
    }

    public void registerAccount(View view) {
        EditText[] editTexts = {username, email, password, confirm_password};

        for (EditText edit : editTexts) {
            if (TextUtils.isEmpty(edit.getText().toString().trim())) {
                Toast.makeText(this, R.string.fill_all_fields, Toast.LENGTH_LONG).show();
                return;
            }
        }
        if (!password.getText().toString().equals(confirm_password.getText().toString())) {
            Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_LONG).show();
            return;
        }
        if (MainActivity.DB.rawQuery("SELECT 1 FROM users WHERE username = '" + username.getText().toString() + "'", null).getCount() > 0) {
            Toast.makeText(this, "That user already exists.", Toast.LENGTH_LONG).show();
            return;
        }
        MainActivity.DB.execSQL("INSERT INTO users VALUES (" +
                "'" + username.getText().toString() + "'," +
                "'" + email.getText().toString() + "'," +
                "'" + password.getText().toString() + "')");
        finish();
    }
}