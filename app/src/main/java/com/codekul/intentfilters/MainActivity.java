package com.codekul.intentfilters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnOkay =
                (Button) findViewById(R.id.btnOkay);
        btnOkay.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent =
                        new Intent();

                //intent.setAction(Intent.ACTION_DIAL);

                intent.setAction("com.codekul.action.sample");
                //intent.setData(Uri.parse("http://codekul.com"));

                /*intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel://9762548833"));*/

                /*intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://codekul.com"));*/

                startActivity(intent);
            }
        });

    }
}
