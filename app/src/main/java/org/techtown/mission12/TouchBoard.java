package org.techtown.mission12;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
        import android.util.AttributeSet;
        import android.view.MotionEvent;
        import android.view.View;

/**
 *
 */

public class TouchBoard extends View {
    private Paint paint, poop;
    private Paint basePaint;
    Bitmap image;

    int rectWidth = 150;
    int rectHeight = 150;
    int curX = 100;
    int curY = 1280;
    int count1,count2,count3,count4,count5,count6,count7,x,x1,x2,x3,x4,x5,x6,handle_1;

    public TouchBoard(Context context) {
        super(context);
        mHandler.sendEmptyMessageDelayed(0, 10);
        init(context);
    }

    public TouchBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mHandler.sendEmptyMessageDelayed(0, 10);
        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);

        basePaint = new Paint();
        basePaint.setStyle(Paint.Style.FILL);
        basePaint.setColor(Color.WHITE);

        Resources r = context.getResources();
        image = BitmapFactory.decodeResource(r, R.drawable.ddong);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(0, 0, getWidth(), getHeight(), basePaint);
        canvas.drawRect(curX, curY, curX + rectWidth, curY + rectHeight, paint);
        int w1 = image.getWidth();
        int h1 = image.getHeight();
        int w2 = image.getWidth();
        int h2 = image.getHeight();
        int w3 = image.getWidth();
        int h3 = image.getHeight();
        int w4 = image.getWidth();
        int h4 = image.getHeight();
        int w5 = image.getWidth();
        int h5 = image.getHeight();
        int w6 = image.getWidth();
        int h6 = image.getHeight();
        int w7 = image.getWidth();
        int h7 = image.getHeight();

        Rect src = new Rect(0, 0, w1, h1);
        Rect dst = new Rect(0, 0 + count1, (w1 / 5), (h1 / 5) + count1);
        canvas.drawBitmap(image, src, dst, null);
        if(count1==0) {
            count1=(int)(Math.random()*20);
            x=count1;
        }


        Rect src1 = new Rect(0, 0, w2, h2);
        Rect dst1 = new Rect(160, 0 + count2, (w2 / 5) + 160, (h2 / 5) + count2);
        canvas.drawBitmap(image, src1, dst1, null);
        if(count2==0) {
            count2=(int)(Math.random()*20);
            x1=count2;
        }
        Rect src2 = new Rect(0, 0, w3, h3);
        Rect dst2 = new Rect(320, 0 + count3, (w3 / 5) + 320, (h3 / 5) + count3);
        canvas.drawBitmap(image, src2, dst2, null);
        if(count3==0) {
            count3=(int)(Math.random()*20);
            x2=count3;
        }

        Rect src3 = new Rect(0, 0, w4, h4);
        Rect dst3 = new Rect(480, 0 + count4, (w4 / 5) + 480, (h4 / 5) + count4);
        canvas.drawBitmap(image, src3, dst3, null);
        if(count4==0) {
            count4=(int)(Math.random()*20);
            x3=count4;
        }
        Rect src4 = new Rect(0, 0, w5, h5);
        Rect dst4 = new Rect(640, 0 + count5, (w5 / 5) + 640, (h5 / 5) + count5);
        canvas.drawBitmap(image, src4, dst4, null);
        if(count5==0) {
            count5=(int)(Math.random()*20);
            x4=count5;
        }
        Rect src5 = new Rect(0, 0, w6, h6);
        Rect dst5 = new Rect(800, 0 + count6, (w6 / 5) + 800, (h6 / 5) + count6);
        canvas.drawBitmap(image, src5, dst5, null);
        if(count6==0) {
            count6=(int)(Math.random()*20);
            x5=count6;
        }
        Rect src6 = new Rect(0, 0, w7, h7);
        Rect dst6 = new Rect(960, 0 + count7, (w7 / 5) + 960, (h7 / 5) + count7);
        canvas.drawBitmap(image, src6, dst6, null);
        if(count7==0) {
            count7=(int)(Math.random()*20);
            x6=count7;
        }
        count1+=x;
        count2+=x1;
        count3+=x2;
        count4+=x3;
        count5+=x4;
        count6+=x5;
        count7+=x6;
        if(count1>=1300){
            count1=0;
        }
        if(count2>=1300){
            count2=0;
        }
        if(count3>=1300){
            count3=0;
        }
        if(count4>=1300){
            count4=0;
        }
        if(count5>=1300){
            count5=0;
        }
        if(count6>=1300){
            count6=0;
        }

        if(count7>=1300){
            count7=0;
        }

    }
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            curX = (int) event.getX();
            if(curX > 860){
                curX=860;
            }
            //curY = (int) event.getY();

            invalidate();
        } else if (action == MotionEvent.ACTION_MOVE) {
            curX = (int) event.getX();
            //curY = (int) event.getY();
            if(curX > 860){
                curX=860;
            }
            invalidate();
        } else if (action == MotionEvent.ACTION_UP) {

        }

        return true;
    }
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
                invalidate();
                mHandler.sendEmptyMessageDelayed(0, 10);
            }
    };




}
