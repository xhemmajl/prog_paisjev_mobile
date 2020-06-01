package com.example.fishjump;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;
import android.graphics.Typeface;
import android.graphics.Color;
import android.graphics.Paint;


public class GameView extends View {
        private Bitmap fish;
        private Bitmap backgroundImage;
        private Paint scorePaint = new Paint();


    public GameView(Context context) {
        super(context);
            //qet foto peshkit i gjeta ngoogle i morra , ish edhe versioni 2 najs kur klikon psh me i hap kraht
        //dmth po e vizatojm peshkin e par per momentin
        fish = BitmapFactory.decodeResource(getResources(),R.drawable.fish1);
            //backgroundi i lojes

        backgroundImage = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        //score
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);
    }





    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //pe vendosum npamje ku kan mu dok permes drawit
        canvas.drawBitmap(backgroundImage,0,0,null);
        canvas.drawBitmap(fish,0,0,null);
        canvas.drawText("Score :",20,60,scorePaint);
    }
}

