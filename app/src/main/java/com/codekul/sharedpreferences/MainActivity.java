package com.codekul.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeToSharedPrefs();

       readFromPreferences();
    }

    private void writeToSharedPrefs(){

        // /data/data/your package/shared_prfes/my_prefs.xml

        SharedPreferences prefs =
                getSharedPreferences("my_prefs",MODE_PRIVATE);

        SharedPreferences.Editor editor
                = prefs.edit();

        editor.putString("key_string","{code}kul;");
        editor.putFloat("key_float",45.6f);

        editor.commit();
    }

    private void readFromPreferences(){

        SharedPreferences prefs =
                getSharedPreferences("my_prefs",MODE_PRIVATE);
        String keyString = prefs.getString("key_string","default");
        Float keyFloat = prefs.getFloat("key_float",-5f);

        Log.i("@codekul"," String "+keyString);
        Log.i("@codekul"," Float "+keyFloat);

    }
}
