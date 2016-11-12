package com.example.dell.sharedpreferencestest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button savedata;

    private Button restoredata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savedata = (Button) findViewById(R.id.save_data);
        restoredata = (Button) findViewById(R.id.restore_data);
        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data",
                        MODE_PRIVATE).edit();
                editor.putString("name","Tom");
                editor.putInt("age",20);
                editor.putBoolean("married",false);
                editor.commit();
            }
        });
        restoredata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("data",
                        MODE_PRIVATE);
                String name = preferences.getString("name","");
                int age = preferences.getInt("age",0);
                Boolean marriage = preferences.getBoolean("married",false);
                Log.d("MainActivity" , "name is :"+name);
                Log.d("MainActivity","age is :" + age);
                Log.d("MainActivity","married is :"+ marriage);
            }
        });
    }
}
