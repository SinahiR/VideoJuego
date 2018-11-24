package mx.edu.ittepic.dadm_u3_videojuego;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.widget.Toast;

public class Naves {
    private Bitmap icono;
    private float x,y, posicion;
    int desplazamiento, desplazamientoBala, desplazadmarciano, acum;
    private  boolean visible;
    CountDownTimer timer, timerBala, timerdmarciano;



    public Naves(int resource, final float posx, final float posy, final Lienzo l, final Naves n)

    {
        icono=BitmapFactory.decodeResource(l.getResources(),resource);
        x=posx;
        y=posy;
        visible=true;

        timer=new CountDownTimer(1000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                y+=desplazamiento;
                if(y>=1550)
                {
                  y=+posy;
                }
                l.invalidate();

            }

            @Override
            public void onFinish() {
                start();

            }
        };


        timerBala=new CountDownTimer(1000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                y-=desplazamientoBala;

                  if(y>=l.getHeight())
                   {
                       y=+1400; // donde volvera a empezar la bala despues de desaparecer
                   }


                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }

        };
        timerdmarciano=new CountDownTimer(1000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                y+=desplazadmarciano;


                if(y>=l.getHeight())
                {
                   y=n.getY()+150;
                }
                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };

    }
//*******************************************************************************


    public void bajarNaves(int desplaza)
    {
        desplazamiento=desplaza;
        timer.start();


    }

    public void subirBala(int desplazaBala)
    {
        desplazamientoBala=desplazaBala;
        timerBala.start();

    }

    public void disparoMarciano(int desdmarciano )
    {
        desplazadmarciano=desdmarciano;
        timerdmarciano.start();
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

    public void mover( float xp)
    {
        x=xp-(icono.getWidth()/2);
        //y=yp-(icono.getHeight()/2);
    }

    //Si se tocan
    public boolean colision(Naves objetoB)
    {
        float x2=x+icono.getWidth(); //Calculas el tocque osea de x1 hasta x2
        float y2=y+icono.getHeight();// de y hasta y2

        if(objetoB.siSeToco(x2,y))
        {
            //revisando caso 1
            return true;
        }

        if(objetoB.siSeToco(x,y))
        {
            //revisando caso 2
            return true;
        }

        if(objetoB.siSeToco(x2,y2))
        {
            //revisando caso 3
            return true;
        }

        if(objetoB.siSeToco(x,y2))
        {
            //revisando caso 4
            return true;
        }

        return false;
    }

    public float getY() {
        return y;
    }

    }


