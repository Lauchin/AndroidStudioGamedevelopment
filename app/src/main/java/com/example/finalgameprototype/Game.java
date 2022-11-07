package com.example.finalgameprototype;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

/**
 * Game manages all objects in the Game and is responsible for updating all states and render all objects to the screen
 */

public class Game extends SurfaceView implements SurfaceHolder.Callback {
    private GameLoop gameloop;
    private Context context;

    public Game(Context context) {
        super(context);

        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        this.context = context;
        gameloop = new GameLoop(this, surfaceHolder);
        gameloop.run();
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        gameloop.startLoop();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawUPS( canvas);
        drawFPS( canvas);
    }

    public void drawUPS(@NonNull Canvas canvas){
        String averageUPS = Double.toString(gameloop.getAverageUPS());
        Paint textPaint = new Paint();
        int color = ContextCompat.getColor(context, R.color.white);
        textPaint.setColor(color);
        textPaint.setTextSize(50);
        canvas.drawText("UPS:  " + averageUPS, 100, 100,textPaint);

    }

    public void drawFPS(@NonNull Canvas canvas){
        String averageFPS = Double.toString(gameloop.getAverageFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.white);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("FPS:  " + averageFPS, 100, 200,paint);
    }

    public void update(){

    }
}

