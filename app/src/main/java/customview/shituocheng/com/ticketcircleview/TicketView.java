package customview.shituocheng.com.ticketcircleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by shituocheng on 2016/11/30.
 */

public class TicketView extends LinearLayout {

    private float circleGap = 8;

    private Paint paint;

    private float radius = 10;

    private int circleNum;

    private float remain;

    public TicketView(Context context) {
        super(context);
        init();
    }

    public TicketView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TicketView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setDither(true);

        paint.setColor(Color.WHITE);

        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (remain==0){
            remain = (int)(w-circleGap)%(2*radius+circleGap);
        }
        circleNum = (int) ((w-circleGap)/(2*radius+circleGap));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < circleNum; i++){
            float x = circleGap+radius+remain/2+((circleGap+radius*2)*i);
            canvas.drawCircle(x, 0, radius, paint);
            canvas.drawCircle(x, getHeight(), radius, paint);
        }
    }
}
