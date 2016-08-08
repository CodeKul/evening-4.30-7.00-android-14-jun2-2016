package com.codekul.helloworld;

import android.app.Activity;
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

        setContentView(R.layout.activity_main);

        final EditText edtName = (EditText) findViewById(R.id.edtName);

        Button btn = (Button) findViewById(R.id.btnOkay);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data = edtName.getText().toString();

                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(data);
            }
        });

       // TextView textView = (TextView) findViewById(R.id.textView);
    }

    private void createByCode(){

        final LinearLayout layout =
                new LinearLayout(this);
        final LinearLayout.LayoutParams paramsLayout =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(paramsLayout);

        final EditText edtText =
                new EditText(this);
        final LinearLayout.LayoutParams paramsEdit =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        edtText.setLayoutParams(paramsEdit);
        edtText.setHint("Name");
        layout.addView(edtText);

        final Button btnOkay = new Button(this);
        final LinearLayout.LayoutParams paramsBtn =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        btnOkay.setLayoutParams(paramsBtn);
        btnOkay.setText("Okay");
        layout.addView(btnOkay);

        setContentView(layout);
    }
}
