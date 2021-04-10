package com.example.mycaculator.my_control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
/* tab

 */
public class MyTextView extends androidx.appcompat.widget.AppCompatTextView {
    Paint paint=new Paint();

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        //  framk work
        canvas.drawLine(0,0,this.getWidth(),0,paint);//top side
        canvas.drawLine(0,this.getHeight(),this.getWidth(),this.getHeight(),paint);//bottom side
        canvas.drawLine(0,0,0,this.getHeight(),paint);// left side
        canvas.drawLine(this.getWidth(),0,this.getWidth(),this.getHeight(),paint);//right side
    }
}
