package com.codekul.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeToInternalStorage();

        readFromInternalStorage();

    }

    private void writeToInternalStorage(){

        // /data/data/your package/files/
        try {

            FileOutputStream fos = openFileOutput("my.txt",
                    MODE_PRIVATE);
            fos.write("This is internal storage".getBytes());
            fos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void readFromInternalStorage(){
        try {

            FileInputStream fis =
                    openFileInput("my.txt");

            StringBuilder builder =
                    new StringBuilder();

            //String str = new String(); heavy

            while(true){
                int ch = fis.read();
                    if(ch == -1) break;
                //else str = str + (char)ch; heavy
                else builder.append((char)ch);
            }

            Log.i("@codekul",builder.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    private void whatIsGetFilesDir(){

        Log.i("@codekul", "Get Files Dir - "+getFilesDir().toString());

        try {

            File file = new File(getFilesDir(),"my1.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("This is getFilesDir".getBytes());
            fos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
