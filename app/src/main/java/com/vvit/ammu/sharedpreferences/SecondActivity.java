package com.vvit.ammu.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tv;
    Button logoutbtn;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sharedPreferences=getSharedPreferences(MainActivity.myPref,MODE_PRIVATE);

        String name=sharedPreferences.getString("Uname","");

        tv=(TextView)findViewById(R.id.textView_id);
        tv.setText("Welcome "+name);

        logoutbtn=(Button)findViewById(R.id.button_logout_id);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}
