package com.codekul.notifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MyDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);

        findViewById(R.id.btnAlert)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openDialog("alert");
                    }
                });

        findViewById(R.id.btnDatePicker)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openDialog("datePicker");
                    }
                });

        findViewById(R.id.btnTimePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog("timePicker");
            }
        });

        findViewById(R.id.btnProgress)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        openDialog("progress");
                    }
                });

        findViewById(R.id.btnCustom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog("custom");
            }
        });
    }

    private void openDialog(String tag){

        MyDialogfragment dialog =
                new MyDialogfragment();
        dialog.show(getSupportFragmentManager(), tag);
    }
}
