package com.mohamedmorsi.pandaq;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Logo extends AppCompatActivity {

    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);


    }
    @Override
    protected void onStart(){
        runnable = new Runnable() {
            @Override
            public void run() {
                if(checkAuthentication()) {
                    startActivity(new Intent(Logo.this, Main.class));
                }else{
                    startActivity(new Intent(Logo.this, Sign_In.class));
                }
            }
        };
        handler.postDelayed(runnable,2000);
        super.onStart();
    }

    private boolean checkAuthentication() {
        //until we decide how to authenticate

        return false;
    }
}
