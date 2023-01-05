package com.nguyenviet.flappybirdv1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {
    Bitmap background_game;
    public BitmapBank(Resources resources){
        background_game = BitmapFactory.decodeResource(resources, R.drawable.background_game);
        background_game = scaleImage(background_game);

    }
    //return backgroundbitmap

    public Bitmap getBackground_game() {
        return background_game;
    }
    //return backgroundWidth
    public  int getBackgroundWidth(){
        return background_game.getWidth();
    }
    public int getBackgroundHeight(){
        return background_game.getHeight();
    }
    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();

        int backgroundScaleWidth = (int) widthHeightRatio *AppConstants.SCREEN_HEIGHT;
        return  Bitmap.createScaledBitmap(bitmap,backgroundScaleWidth, AppConstants.SCREEN_HEIGHT,false );
    }
}
