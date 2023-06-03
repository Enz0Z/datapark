package me.datapark.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import me.datapark.R;

public class VehicleAdapter extends ArrayAdapter<Vehicle> {

    private final int resource;
    private final ArrayList<Vehicle> vehicles;

    public VehicleAdapter(@NonNull Context context, int resource, @NonNull List<Vehicle> objects) {
        super(context, resource, objects);
        this.resource = resource;
        vehicles = (ArrayList<Vehicle>) objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItem(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItem(position, convertView, parent);
    }

    private View createItem(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        TextView slot1 = view.findViewById(R.id.vehicle_slot1);
        TextView slot2 = view.findViewById(R.id.vehicle_slot2);
        Vehicle vehicle = vehicles.get(position);

        slot1.setText(vehicle.getBrand() + " " + vehicle.getModel());
        slot2.setText(vehicle.getPlate());
        return view;
    }
}
