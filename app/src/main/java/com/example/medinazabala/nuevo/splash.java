package com.example.medinazabala.nuevo;
import java.util.Timer;
import java.util.TimerTask;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;


public class splash extends Activity {
    public static final long SPLASH_SCREEN_DELAY = 3000;

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Orientacion
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        //Ocultar titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.activity_splash);
        imageView = (ImageView) findViewById(R.id.imageView1);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //iniciar a la siguiente actividad..
                Intent mainInten = new Intent().setClass(
                        splash.this, MainActivity.class);
                startActivity(mainInten);

                //cerrar la actividad
                finish();
            }
        };
        //simular un prceso de carga de proceso
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}