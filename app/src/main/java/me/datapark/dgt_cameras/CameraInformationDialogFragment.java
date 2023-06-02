package me.datapark.dgt_cameras;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import org.json.JSONObject;

import java.util.ArrayList;

import me.datapark.R;

public class CameraInformationDialogFragment extends DialogFragment {

    public JSONObject object;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            ArrayList<String> message = new ArrayList<>();

            message.add(getString(R.string.date) + " " + object.getString("fecha"));
            message.add(getString(R.string.direction) + " " + object.getString("sentido"));
            message.add(getString(R.string.latitude) + " " + object.getString("latitud"));
            message.add(getString(R.string.longitude) + " " + object.getString("longitud"));
            message.add(getString(R.string.province) + " " + object.getString("provincia"));
            message.add(getString(R.string.pk) + " " + object.getString("pk"));

            builder.setTitle(object.getString("carretera"));
            builder.setMessage(String.join("\n", message));
            builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return builder.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
