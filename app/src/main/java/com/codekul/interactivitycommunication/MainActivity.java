package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);

        /* to achieve immutability make variable final*/

        final EditText edtName =
                (EditText) findViewById(R.id.edtName);

        Click click = new Click();
        final Button btnNext =
                (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(click);
    }

    private final class Click implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.btnNext) {

                // i want to start new activity

                //only "this"  will refer to obj of inner class
                // but we are expecting object of context i.e. outer class
                // i.e. MainActivity.this

                Intent intent =
                        new Intent(MainActivity.this,NextActivity.class);
                startActivity(intent);

                /* NextActivity.class is in memory representaion of
                class NextActivity

                Class clsCar = Car.class;
                clsCar.getFields();

                Class clsAnimal = Animal.class;*/
            }
        }
    }
}
class Animal {

}
class Car {

}
