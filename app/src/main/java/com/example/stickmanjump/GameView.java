package com.example.stickmanjump;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

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

    //stepi asht per sa mu rrit speedi edhe level
    public int step = 100;
    //momenti kur kan mu ndrru leveli edhe speedi
    public int target=100;




    public int score,lifeCounterOfstickman;
    public int level;
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
            CheckLevelSpeedChange(score);
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
            score = score + 10;
            CheckLevelSpeedChange(score);
            picaX = -100;
        }
        if(picaX < 0 ){

            picaX = canvasWidth + 21;
            picaY =  (int) Math.floor(Math.random() * ( maxstickmanY - minstickmanY)) + minstickmanY;

        }

        canvas.drawBitmap(pica,picaX,picaY,null);
        koronaX = koronaX - koronaSpeed;
        korona2X = korona2X - korona2Speed;
        if(hitElementsChecker(koronaX,koronaY))
        {
            koronaX = -100;
            lifeCounterOfstickman--;
        if(hitElementsChecker(korona2X,korona2Y)) {
            korona2X = -100;
            lifeCounterOfstickman--;
        }
            if (lifeCounterOfstickman == 0) {
                    Toast.makeText(getContext(), "Loja Mbaroi(Game Over)", Toast.LENGTH_SHORT).show();

                    Intent gameOverIntent = new Intent(getContext(), GameOverActivity.class);
                    gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    getContext().startActivity(gameOverIntent);
        //me qet intentin po e bajm  te mundshme qasjen  e scores nga klasa GameOver, dmth kjo po na vyn me rujt highScore sa ki shkku -
                    Intent ruj = new Intent(getContext(), GameOverActivity.class);
                    ruj.putExtra("SCORE", score); //vendosja scoren
                    getContext().startActivity(ruj);
                }

        }
        if(koronaX < 0 ){

            koronaX = canvasWidth + 21;
            koronaY =  (int) Math.floor(Math.random() * (maxstickmanY - minstickmanY)) + minstickmanY;

        }
        if(korona2X<0){
            korona2X = canvasWidth + 21;
            korona2Y = (int) Math.floor(Math.random() * (maxstickmanY - minstickmanY)) + minstickmanY;
        }

        canvas.drawBitmap(korona,koronaX,koronaY,null);
        canvas.drawText("Level :"+level,20,170,levelPaint);
        canvas.drawText("Score :"+score,20,60,scorePaint);
        if(level>7){
            canvas.drawBitmap(korona2,korona2X,korona2Y,null);
        }
        for(int i=0;i<3;i++){

            int x = (int) (580+life[0].getWidth()*1.5*i);
            int y = 30;

            if(i<lifeCounterOfstickman){
                canvas.drawBitmap(life[0],x,y,null);


            }
            else
            {
                canvas.drawBitmap(life[1],x,y,null);

            }
        }









    }
    public boolean hitElementsChecker(int x,int y){

        if(stickmanX < x && x <(stickmanX + stickman[0].getWidth()) && stickmanY<y && y<(stickmanY+stickman[0].getHeight())){

            return true;

        }
        return false;

    }
    public void CheckLevelSpeedChange(int score){
        if(score == target){
            target +=step;
            level++;
            koronaSpeed+=4;
        }}
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {

            touch = true;

            stickmanSpeed = -22;
        }
        return true;
    }
    }
