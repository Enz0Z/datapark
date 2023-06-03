package me.datapark.utils;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import me.datapark.R;

public class MainMenu {

    public static void onOptionsItemSelected(Context context, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dgt_cameras:
                startActivity(context, new Intent(context, me.datapark.dgt_cameras.Activity.class), null);
                break;
            case R.id.gas_stations:
                startActivity(context, new Intent(context, me.datapark.gas_station.Activity.class), null);
                break;
        }
    }
}
