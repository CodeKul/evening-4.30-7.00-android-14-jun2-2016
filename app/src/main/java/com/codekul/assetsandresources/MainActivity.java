package com.codekul.assetsandresources;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int pureWhite = getResources()
                .getColor(R.color.pureWhite);

        pureWhite = ContextCompat
                .getColor(this,R.color.pureWhite);


    }
}
