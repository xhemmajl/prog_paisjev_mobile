package com.example.fishjump;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class GameView extends View {
        private Bitmap fish;


    public GameView(Context context) {
        super(context);
            //qet foto peshkit i gjeta ngoogle i morra , ish edhe versioni 2 najs kur klikon psh me i hap kraht
        //dmth po e vizatojm peshkin e par per momentin
        fish = BitmapFactory.decodeResource(getResources(),R.drawable.fish1);
    }





    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

