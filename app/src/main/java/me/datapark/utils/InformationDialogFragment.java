package me.datapark.utils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class InformationDialogFragment extends DialogFragment {

    public String title;
    public String snippet;

    public InformationDialogFragment(String title, String snippet) {
        this.title = title;
        this.snippet = snippet;
    }

    public InformationDialogFragment(String title, ArrayList<String> messages) {
        this.title = title;
        this.snippet = String.join("\n", messages);
    }

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
