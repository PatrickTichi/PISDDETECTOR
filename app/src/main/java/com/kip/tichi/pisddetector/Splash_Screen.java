package com.kip.tichi.pisddetector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Splash_Screen extends Activity {
    /** Duration of wait **/


    protected void onCreate(Bundle SavedInstance) {

        super.onCreate(SavedInstance);
        setContentView(R.layout.splash_screen);

        Thread thread=new Thread(){
            @Override
            public void run() {
                try{

                    sleep(5000);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent=new Intent(Splash_Screen.this,Login.class );
                    startActivity(intent);
                }
            }
        };
        thread.start();
    }

    }



