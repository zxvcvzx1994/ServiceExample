package com.example.kh.myapplication.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;

/**
 * Created by kh on 6/24/2017.
 */


public class MyService  extends Service{

    private int mrandomNumber;
    private boolean mIsRandomGeneratorOn;

    private final int MAX = 100;
    private final int MIN = 0 ;

    class MyServiceBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }

    private IBinder mIBinder = new MyServiceBinder();



    private static final String TAG ="vo cong vinh" ;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: "+Thread.currentThread().getId());
        startRandomGenerator();
        return super.onStartCommand(intent, flags, startId);
    }

    public void startRandomGenerator(){
        mIsRandomGeneratorOn=true;
        while(mIsRandomGeneratorOn){
            try {
                Thread.sleep(2000);
                if(mIsRandomGeneratorOn){
                    mrandomNumber = new Random().nextInt(MAX)+MIN;
                    Log.i(TAG, "startRandomGenerator: "+Thread.currentThread().getName()+" "+mrandomNumber);
                }
            } catch (InterruptedException e) {
                Log.i(TAG, "startRandomGenerator: Interupted");

            }
        }
    }

    public void stopRandomGenerator(){
        mIsRandomGeneratorOn=false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
        stopRandomGenerator();

    }
}
