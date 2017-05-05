package com.vvit.ammu.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText usered,passed;
    String uname,password;
    Button btn;
    public static final String myPref="MyPreferences";
    SharedPreferences shr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usered=(EditText)findViewById(R.id.user_id);
        passed=(EditText)findViewById(R.id.password_id);
        btn=(Button)findViewById(R.id.button_id);

        shr=getSharedPreferences(myPref,MODE_PRIVATE);
        if(shr.contains("Uname")){
            startActivity(new Intent(getApplicationContext(),SecondActivity.class));
            finish();
        }
        else
        {
          btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  uname = usered.getText().toString();
                  password=passed.getText().toString();

                  SharedPreferences.Editor editor=shr.edit();
                  editor.putString("Uname",uname);
                  editor.putString("pwd",password);
                  editor.apply();
                  startActivity(new Intent(getApplicationContext(),SecondActivity.class));
                  finish();
              }
          });
        }
    }
}
