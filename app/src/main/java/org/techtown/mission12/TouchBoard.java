package org.techtown.mission12;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
import android.graphics.Rect;
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

    public TouchBoard(Context context) {
        super(context);

        init(context);
    }

    public TouchBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

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
        int w = image.getWidth();
        int h = image.getHeight();
        Rect src = new Rect(0, 0, w, h);
        Rect dst = new Rect(0, 0, (w / 5), h / 5);
        canvas.drawBitmap(image, src, dst, null);
        Rect src1 = new Rect(0, 0, w, h);
        Rect dst1 = new Rect(160, 0, (w / 5)+160, h / 5);
        canvas.drawBitmap(image, src1, dst1, null);
        Rect src2 = new Rect(0, 0, w, h);
        Rect dst2 = new Rect(320, 0, (w / 5)+320, h / 5);
        canvas.drawBitmap(image, src2, dst2, null);
        Rect src3 = new Rect(0, 0, w, h);
        Rect dst3 = new Rect(480, 0, (w / 5)+480, h / 5);
        canvas.drawBitmap(image, src3, dst3, null);
        Rect src4 = new Rect(0, 0, w, h);
        Rect dst4 = new Rect(640, 0, (w / 5)+640, h / 5);
        canvas.drawBitmap(image, src4, dst4, null);
        Rect src5 = new Rect(0, 0, w, h);
        Rect dst5 = new Rect(800, 0, (w / 5)+800, h / 5);
        canvas.drawBitmap(image, src5, dst5, null);
        Rect src6 = new Rect(0, 0, w, h);
        Rect dst6 = new Rect(960, 0, (w / 5)+960, h / 5);
        canvas.drawBitmap(image, src6, dst6, null);

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

}
