package com.reach360.reach360;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {
    Button b1,b2;
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        b1=(Button)findViewById(R.id.btnl);
        session = new Session(this);
        if(!session.loggedin()){
            logout();
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
        b2=(Button)findViewById(R.id.btnc);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this,optionsActivity.class));
            }
        });
    }
    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(SettingsActivity.this,LoginActivity.class));
    }
}
