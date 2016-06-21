package com.codekul.fragmentsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_SAVED_DATA = "savedData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){

            ((TextView)findViewById(R.id.textInfo))
                    .setText(savedInstanceState
                            .getString(KEY_SAVED_DATA));
        }

        final Button btnOkay = (Button)
                findViewById(R.id.btnOkay);
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView textView =
                        (TextView) findViewById(R.id.textInfo);

                // r * 255
                textView.setText(""+(Math.random() * 255));
            }
        });
        mt("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        mt("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        mt("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        mt("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        mt("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mt("onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        mt("onRestart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        /*TextView textInfo =
                (TextView) findViewById(R.id.textInfo);
        String text = textInfo.getText().toString();

        outState.putString((KEY_SAVED_DATA,text);*/

        outState.putString(KEY_SAVED_DATA,
                ((TextView)findViewById(R.id.textInfo))
                .getText()
                .toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null){

            ((TextView)findViewById(R.id.textInfo))
                    .setText(savedInstanceState
                            .getString(KEY_SAVED_DATA));
        }
    }

    private void mt(String msg){

        Toast
                .makeText(this,msg,Toast.LENGTH_SHORT)
                .show();
    }
}
