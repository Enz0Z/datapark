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
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(resource, parent, false);
        TextView txtModel = view.findViewById(R.id.modelText);
        TextView txtType = view.findViewById(R.id.cartype);

        txtModel.setText(vehicles.get(position).getModelo());
        txtType.setText(vehicles.get(position).getTipoTanque());
        return view;
    }

}
