package com.codekul.externalstorage;

import android.content.Context;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeToExternalStorage();

        readFromExternalStorage();
    }

    private void writeToExternalStorage() {

        if (Environment
                .getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED)) {

            try {

                File parent = Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

                File file =
                        new File(parent, "my.txt");

                FileOutputStream fos =
                        new FileOutputStream(file);
                fos.write("Thi is external storage".getBytes());
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            Toast.makeText(this, "Bad media", Toast.LENGTH_LONG)
                    .show();
        }
    }

    private void readFromExternalStorage() {

        if (Environment
                .getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED)) {

            try {
                File parent = Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

                File file =
                        new File(parent, "my.txt");

                FileInputStream fis =
                        new FileInputStream(file);

                StringBuilder builder =
                        new StringBuilder();
                while(true){

                    int ch = fis.read();
                    if(ch == -1) break;
                    else builder.append((char)ch);
                }
                Log.i("@codekul",builder.toString());
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
