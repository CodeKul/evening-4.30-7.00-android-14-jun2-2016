package com.codekul.notifications;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialogfragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = null;

        if(getTag().equals("alert")) dialog = createAlertDialog();
        else if(getTag().equals("datePicker")) dialog = createDatePicker();
        else if(getTag().equals("timePicker")) dialog = createTimePicker();
        else if(getTag().equals("progress"))dialog = createProgressDialog();
        else dialog = createCustomDialog();

        return dialog;
    }

    private void mt(String msg){

        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT)
                .show();
    }

    private AlertDialog createAlertDialog(){

        DialogClick click =
                new DialogClick();

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getContext())
                .setTitle("Title")
                .setMessage("Message")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("+ve",click)
                .setNegativeButton("-ve",click)
                .setNeutralButton("=",click);

        return builder.create();
    }

    private DatePickerDialog createDatePicker(){

        DatePickerDialog datePicker =
                new DatePickerDialog(getContext(),
                      new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        mt(""+dayOfMonth +" - "+(monthOfYear+1)+" - "+year);
                    }
                }, 2016, 5, 30);

        return datePicker;
    }

    private TimePickerDialog createTimePicker(){

        TimePickerDialog timePicker =
                new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                mt(""+hourOfDay +" : "+minute);
                            }
                        }, 6, 11, false);

        return  timePicker;
    }

    private ProgressDialog createProgressDialog(){

        ProgressDialog progressDialog =
                new ProgressDialog(getContext());
        progressDialog.setTitle("Title");
        progressDialog.setMessage("Message");
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        return progressDialog;
    }

    private Dialog createCustomDialog(){

        LayoutInflater inflater = getActivity()
                .getLayoutInflater();

        View view = inflater
                .inflate(R.layout.custom_dialog,null,false);

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getContext())
                .setView(view);

        return builder.create();
    }

    private final class DialogClick
            implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {

            if(which == DialogInterface.BUTTON_POSITIVE){
                mt("+ve");
            }
            else if(which == DialogInterface.BUTTON_NEUTRAL){
                mt("=");
            }
            else {
                mt("-ve");
            }
        }
    }
}
