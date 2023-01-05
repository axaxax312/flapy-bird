package com.nguyenviet.flappybirdv1;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

import androidx.core.content.UnusedAppRestrictionsConstants;

public class GameThread extends  Thread{
    SurfaceHolder surfaceHolder;
    boolean isRunning;

    long startTime, loopTime;

    long DELAY =33;
    public GameThread(SurfaceHolder surfaceHolder){
        this.surfaceHolder = surfaceHolder;
        isRunning = true;

    }

    @Override
    public void run() {
        //looping until the boolen false

        while (isRunning){
            startTime = SystemClock.uptimeMillis();
            //Locking the canvas
            Canvas canvas = surfaceHolder.lockCanvas(null);
            if (canvas != null){
                synchronized (surfaceHolder){
                    AppConstants.getGameEngine().updateAndDrawableBackgroundImage(canvas);
                    //Unlock the canvas

                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
                //Loop time
                loopTime = SystemClock.uptimeMillis() - startTime;
                // Pause here to make sure update the th right amount per second

                if(loopTime <DELAY){
                    try{
                        Thread.sleep(DELAY - loopTime);
                    }catch (InterruptedException e){
                        Log.e("Interrumped", "Interrumped while sleeping");
                    }

                }
            }
        }
    }
    public  boolean isRunning(){
        return isRunning;
    }

    public void setRunning(boolean state){
        isRunning = state;
    }
}
