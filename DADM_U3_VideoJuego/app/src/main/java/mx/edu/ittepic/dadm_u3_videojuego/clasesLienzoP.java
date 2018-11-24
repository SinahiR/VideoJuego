package mx.edu.ittepic.dadm_u3_videojuego;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;

public class clasesLienzoP {
    private Bitmap icono;
    private float x, y, posicion;
    private  boolean visible;


    public clasesLienzoP(int resource, final float posx, final float posy, final LienzoPrincipal l)

    {
        icono = BitmapFactory.decodeResource(l.getResources(), resource);
        x = posx;
        y = posy;
        visible=true;

    }

    public void pintar(Canvas c, Paint p)
    {
        if(visible)  c.drawBitmap(icono, x, y,p);
    }
    public void hacerVisible(boolean v)
    {
        visible=v;

    }


    //xp y yp son del toque
    public Boolean siSeToco(float xp, float yp)
    {
        if(!visible)
        {
            return false;
        }
        float x2, y2;

        x2=x+icono.getWidth();
        y2=y+icono.getHeight();

        if(xp>=x && xp<=x2)
        {
            if(yp>=y && yp<=y2)
            {
                return  true; //Regresara verdadero si ambos if son verdaderos
            }
        }

        return false;
    }

}
