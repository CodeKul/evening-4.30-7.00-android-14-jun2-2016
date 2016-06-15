package com.codekul.veryfirstapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        * View
        * - parent
        * - width and height
        * */

        setContentView(R.layout.activity_main); // ui using XML

        // child = parent -> wrong
        // parent = child -> correct

        Click click = new Click();

        Button btnOkay = (Button) findViewById(R.id.btnOkay);
        btnOkay.setOnClickListener(click);

        Button btnGood = (Button) findViewById(R.id.btnGood);
        btnGood.setOnClickListener(click);
    }

    private  void makeUiUsingJavaCode(){

        LinearLayout layoutRoot =
                new LinearLayout(this);

        LinearLayout.LayoutParams paramsRoot =
                new LinearLayout.LayoutParams(500,500);

        layoutRoot.setLayoutParams(paramsRoot);
        layoutRoot.setOrientation(LinearLayout.VERTICAL);

        EditText edtName =
                new EditText(this);
        LinearLayout.LayoutParams paramName =
                new LinearLayout.LayoutParams(500,150);
        edtName.setLayoutParams(paramName);
        layoutRoot.addView(edtName);

        Button btnOkay =
                new Button(this);
        LinearLayout.LayoutParams paramsBtn =
                new LinearLayout.LayoutParams(500,150);
        btnOkay.setLayoutParams(paramsBtn);
        layoutRoot.addView(btnOkay);

        setContentView(layoutRoot);
    }

    private class Click implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            if(v.getId() == R.id.btnOkay){

                EditText edtName = (EditText) findViewById(R.id.edtName);
                edtName.setText("Okay");
            }
            else {
                EditText edtName = (EditText) findViewById(R.id.edtName);
                edtName.setText("Good");
            }
        }
    }

}
