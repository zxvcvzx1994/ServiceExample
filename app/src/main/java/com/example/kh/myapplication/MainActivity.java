package com.example.kh.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.kh.myapplication.Service.MyService;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="main";
    private Intent intentService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        intentService = new Intent(getApplicationContext(), MyService.class);
    }

    @OnClick(R.id.btnStart)
    public void startServices(){
        Log.i(TAG, "startServices: "+Thread.currentThread().getName());

        startService(intentService);
    }
    @OnClick(R.id.btnStop)
    public void stopServices(){
        stopService(intentService);
    }
}
