package com.example.stickmanjump;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

public class GameView extends View {
    private Bitmap stickman[] = new Bitmap[2];
    private int stickmanX = 10;
    private int stickmanY;
    private int stickmanSpeed;
    private Bitmap backgroundImage;
    private Paint scorePaint = new Paint();
    public GameView(Context context) {
        super(context);
        //qet foto stickmanit i gjeta ngoogle i morra , ish edhe versioni 2 najs kur klikon me kcy
        //dmth po e vizatojm stickmanin e par dhe dytin per momentin
        stickman[0] = BitmapFactory.decodeResource(getResources(),R.drawable.stickmanwalk);
        stickman[1] = BitmapFactory.decodeResource(getResources(),R.drawable.stickmanjump);
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
        canvas.drawText("Score :",20,60,scorePaint);
    }
    }
