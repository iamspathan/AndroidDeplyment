package me.sohailpathan.www.androiddeplyment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyView extends SurfaceView{
    SurfaceHolder holder;
    Context context;
    Canvas canvas;

    public MyView(Context context)
    {
        super(context);
        this.context = context;
        holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                canvas = holder.lockCanvas();
                draw(canvas);
                holder.unlockCanvasAndPost(canvas);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint =new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(100f);
        canvas.drawText("Hello" , 100 ,100,paint);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(150,250,150,paint);
        paint.setColor(Color.CYAN);
        float[] f={0,0,200,0,200,100,100,100,0,0};
        paint.setColor(Color.BLACK);
        canvas.drawLines(f,paint);

    }
}
