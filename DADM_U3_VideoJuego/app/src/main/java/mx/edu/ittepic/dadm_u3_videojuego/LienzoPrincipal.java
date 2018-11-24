package mx.edu.ittepic.dadm_u3_videojuego;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

public class LienzoPrincipal extends View {
    Main2Activity ob;
    clasesLienzoP start;

    public LienzoPrincipal(Context context) {
        super(context);
        ob = (Main2Activity) context;
        start = new clasesLienzoP(R.drawable.start, 250, 500, this);
    }

    public void onDraw(Canvas c) {

        Paint p = new Paint();

        c.drawColor(Color.BLACK);
        start.pintar(c, p);



    }

    public boolean onTouchEvent(MotionEvent e) {
        float xtoque = e.getX();
        float ytoque = e.getY();

        switch (e.getAction()) {

            //TOCAR
            case MotionEvent.ACTION_DOWN:
                if (start.siSeToco(xtoque, ytoque)) {
                    Intent otraventana=new Intent(ob, MainActivity.class);
                    ob.startActivity(otraventana);
                }

                break;

            //MOVER
            case MotionEvent.ACTION_MOVE:


                break;

            case MotionEvent.ACTION_UP:

                break;
        }

        invalidate();
        return true;
    }

}

