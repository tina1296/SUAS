package com.example.plz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SingleTouchView extends View {
    //메모 카테고리에서 활용할 커스텀 컴포넌트
    private Paint paint=new Paint();
    private Path path=new Path();

    public SingleTouchView(Context context, AttributeSet attrs) {
        //메모장에서 메모할 수 있는 부분
        super(context,attrs);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }
    protected void onDraw(Canvas canvas){
        canvas.drawPath(path, paint);
    }
    //이벤트 처리
    public boolean onTouchEvent(MotionEvent event){
        float eventX=event.getX();
        float eventY=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }
}
