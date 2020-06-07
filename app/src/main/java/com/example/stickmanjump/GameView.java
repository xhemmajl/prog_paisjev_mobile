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
    //STICKMAN X EDHE Y JAN POZITAT KU KAN MU VENDOS NE DISPLAY .
    private int stickmanX = 10;
    private int stickmanY;
    private int stickmanSpeed;
    //Qeto me X ,Y jan per mi vendos gjat lojes ku me u shfaq elementet random
    private int canvasWidth,canvasHeight;

    private int hamburgerX,hamburgerY,hamburgerSpeed = 15;

    private int picaX,picaY,picaSpeed = 20;

    private int koronaX,koronaY,koronaSpeed = 21;
    private int korona2X,korona2Y,korona2Speed=30;




    public int score,lifeCounterOfstickman;
    private boolean touch = false;

    private Bitmap backgroundImage;
    private Paint scorePaint = new Paint();
    private Paint levelPaint = new Paint();
    private Bitmap life[] = new Bitmap[2];
    private Bitmap hamburger;
    private Bitmap pica;
    private Bitmap korona;
    private Bitmap korona2;
    public GameView(Context context) {
        super(context);
        //qet foto stickmanit i gjeta ngoogle i morra , ish edhe versioni 2 najs kur klikon me kcy
        //dmth po e vizatojm stickmanin e par dhe dytin per momentin
        stickman[0] = BitmapFactory.decodeResource(getResources(),R.drawable.stickmanwalk);
        stickman[1] = BitmapFactory.decodeResource(getResources(),R.drawable.stickmanjump);
        //backgroundi i lojes
        //qetu jan elementet e lojes
        hamburger=BitmapFactory.decodeResource(getResources(),R.drawable.hamburgeri);
        pica=BitmapFactory.decodeResource(getResources(),R.drawable.pica);
        korona=BitmapFactory.decodeResource(getResources(),R.drawable.korona);
        korona2=BitmapFactory.decodeResource(getResources(),R.drawable.korona);
        
        backgroundImage = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        //score
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        levelPaint.setColor(Color.WHITE);
        levelPaint.setTextSize(70);
        levelPaint.setTypeface(Typeface.DEFAULT_BOLD);
        levelPaint.setAntiAlias(true);
        //qetu jan jetet nloj
        life[0] = BitmapFactory.decodeResource(getResources(),R.drawable.hearts);
        life[1] = BitmapFactory.decodeResource(getResources(),R.drawable.heart_grey);
        stickmanY = 550;

        score = 0;
        lifeCounterOfstickman = 3;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //pe vendosum npamje ku kan mu dok permes drawit
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();
        canvas.drawBitmap(backgroundImage,0,0,null);
        int minstickmanY = stickman[0].getHeight();
        int maxstickmanY = canvasHeight - stickman[0].getHeight() * 3;
        stickmanY = stickmanY + stickmanSpeed;
        if(stickmanY < minstickmanY) {

            stickmanY = minstickmanY;


        }
        if(stickmanY > maxstickmanY) {

            stickmanY = maxstickmanY;


        }
        stickmanSpeed = stickmanSpeed + 2;
        if(touch) {
            canvas.drawBitmap(stickman[1],stickmanX,stickmanY,null);
            touch = false;



        }
        else {

            canvas.drawBitmap(stickman[0],stickmanX,stickmanY,null);

        }
        hamburgerX = hamburgerX - hamburgerSpeed;
        if(hitElementsChecker(hamburgerX,hamburgerY))
        {
            score = score + 10;
            hamburgerX = -100;
        }
        if(hamburgerX < 0 ){

            hamburgerX = canvasWidth + 21;
            hamburgerY =  (int) Math.floor(Math.random() * (maxstickmanY - minstickmanY)) + minstickmanY;

        }

        canvas.drawBitmap(hamburger,hamburgerX,hamburgerY,null);
        picaX = picaX - picaSpeed;
        if(hitElementsChecker(picaX,picaY))
        {
            score = score + 20;
            picaX = -100;
        }
        if(picaX < 0 ){

            picaX = canvasWidth + 21;
            picaY =  (int) Math.floor(Math.random() * ( maxstickmanY - minstickmanY)) + minstickmanY;

        }

        canvas.drawBitmap(pica,picaX,picaY,null);
        canvas.drawText("Score :",20,60,scorePaint);
    }
    }