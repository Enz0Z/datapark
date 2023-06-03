package me.datapark.gas_station;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class StationInformationDialogFragment extends DialogFragment {

    public String title;
    public String snippet;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            builder.setTitle(title);
            builder.setMessage(snippet);
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
