package me.datapark;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import models.Car;

public class PersonalAdapter extends ArrayAdapter<Car> {

    private int mResource;
    private ArrayList<Car> myCars;

    public PersonalAdapter(@NonNull Context context, int resource, @NonNull List<Car> objects) {
        super(context, resource, objects);
        mResource =resource;
        myCars =(ArrayList<Car>) objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItem(position,convertView,parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItem(position,convertView,parent);
    }

    private View createItem(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater miInflador = LayoutInflater.from(getContext());
        View myItem = miInflador.inflate(mResource,parent,false);

        TextView txtModel=myItem.findViewById(R.id.modelText);
        TextView txtType=myItem.findViewById(R.id.cartype);

        txtModel.setText(myCars.get(position).getModelo());
        txtType.setText(myCars.get(position).getTipoTanque());
        Log.d("RDT","Coche insertado "+ position);
        return myItem;
    }

}
