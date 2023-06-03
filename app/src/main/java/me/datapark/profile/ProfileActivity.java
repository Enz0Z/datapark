package me.datapark.profile;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import me.datapark.R;
import me.datapark.utils.MainMenu;
import models.Car;

public class ProfileActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView miLista;
    private ArrayList<Car> items;
    private Button insertCar, update;
    TextView nickname, nicknameMail;
    private EditText name, mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        insertCar = findViewById(R.id.insertCarButton);
        update = findViewById(R.id.updateProfile);
        nickname = findViewById(R.id.userProfile);
        nicknameMail = findViewById(R.id.mailProfile);
        name = findViewById(R.id.editNameProfileField);
        mail = findViewById(R.id.editMailProfileField);
        items = new ArrayList<>();
        items.add(new Car("Citroen", "Test", "0000001X", "Gasolina"));
        items.add(new Car("Citroen", "C4", "0000002X", "Gasolina"));


        //LISTVIW
        miLista = findViewById(R.id.ListView);
        PersonalAdapter miAdapatador = new PersonalAdapter(this, R.layout.item_cars, items);
        miLista.setAdapter(miAdapatador);
        miLista.setOnItemClickListener(this);

    }
    public void updateData(View view) {
        if(name.getText().length()!=0 && mail.getText().length()!=0){
            nickname.setText(name.getText());
            nicknameMail.setText(mail.getText());
        }else{
            Toast.makeText(this, "Empty fields",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Se ha pulsado " + items.get(i), Toast.LENGTH_SHORT).show();
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