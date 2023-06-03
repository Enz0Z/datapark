package me.datapark.utils;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import me.datapark.MainActivity;
import me.datapark.R;
import me.datapark.profile.Activity;
import me.datapark.profile.VehicleCreateActivity;

public class MainMenu {

    public static void onOptionsItemSelected(Context context, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dgt_cameras:
                startActivity(context, new Intent(context, me.datapark.dgt_cameras.Activity.class), null);
                break;
            case R.id.gas_stations:
                startActivity(context, new Intent(context, me.datapark.gas_station.Activity.class), null);
                break;
            case R.id.profile:
                startActivity(context, new Intent(context, Activity.class), null);
                break;
            case R.id.form_menu:
                startActivity(context, new Intent(context, VehicleCreateActivity.class), null);
                break;
            case R.id.log_out:
                startActivity(context, new Intent(context, MainActivity.class), null);
                break;
        }
    }
}
