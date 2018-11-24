package mx.edu.ittepic.dadm_u3_videojuego;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
    Naves nave, fondo, marciano1,puntero3,puntero4, puntero5,marciano2, marciano3, puntero, gameOver, puntero2, isla1, isla2, isla3, bala,eliminar, dmarciano, dmarciano2, dmarciano3;
    Naves puntos, win, punto1, punto2, punto3, vida, punto0, vidal, vidaf,  restart;
    int cont, contador2, disparo, disparo2, disparo3, contP, conElimina;
    MainActivity obj;


    public Lienzo(Context context) {
        super(context);

        vida=new Naves(R.drawable.vida,250,30,this,vida);
        vidaf=new Naves(R.drawable.vidafuera,250,30,this,vidaf);
        vidal=new Naves(R.drawable.vidal,10,0,this,vidal);
        fondo=new Naves(R.drawable.fondo,0,0,this,fondo);
        marciano1=new Naves(R.drawable.marciano1,10,0,this, marciano1);
        marciano2=new Naves(R.drawable.marciano2,500,0,this, marciano2);
        marciano3=new Naves(R.drawable.marciano3,800,0,this, marciano3);
        gameOver=new Naves(R.drawable.gameo,150,500,this, gameOver);
        isla1=new Naves(R.drawable.islaa,150,0,this, isla1);
        isla2=new Naves(R.drawable.islaa,300,0,this, isla2);
        isla3=new Naves(R.drawable.islaa,900,0,this, isla3);
        nave=new Naves(R.drawable.nave1,580,1440,this, nave);
        bala=new Naves(R.drawable.explo,6000,1400,this, bala);
        eliminar=new Naves(R.drawable.eliminacion,250,500,this, eliminar);
        win=new Naves(R.drawable.win,30,380,this, win);
        puntos=new Naves(R.drawable.puntos,600,0,this,puntos);
        punto1=new Naves(R.drawable.punto1,870,0,this,punto1);
        punto2=new Naves(R.drawable.punto2,870,0,this,punto2);
        punto3=new Naves(R.drawable.punto3,870,0,this,punto3);
        punto0=new Naves(R.drawable.punto0,870,0,this,punto0);
        dmarciano=new Naves(R.drawable.balama,120,130,this,marciano1); //marciano 1 hace que la bala aparezca en la posicion de y
        dmarciano2=new Naves(R.drawable.balama,620,130,this,marciano2);
        dmarciano3=new Naves(R.drawable.balama,920,130,this,marciano3);
        restart=new Naves(R.drawable.restart,450,1000,this,restart);
         obj=(MainActivity) context;

        marciano1.bajarNaves(5);
        marciano2.bajarNaves(20);
        marciano3.bajarNaves(2);

        isla1.bajarNaves(10);
        isla2.bajarNaves(30);
        isla3.bajarNaves(20);

        dmarciano.disparoMarciano(10);
        dmarciano2.disparoMarciano(25);
        dmarciano3.disparoMarciano(10);

        puntero=null;
        puntero2=null;
        puntero3=dmarciano;
        puntero4=dmarciano2;
        puntero5=dmarciano3;

        restart.hacerVisible(false);
        win.hacerVisible(false);
        gameOver.hacerVisible(false);
        eliminar.hacerVisible(false);
        punto0.hacerVisible(true);
        punto1.hacerVisible(false);
        punto2.hacerVisible(false);
        punto3.hacerVisible(false);
        vidaf.hacerVisible(false);

        cont=0;
        conElimina=0;
        contP=0;
        contador2=0;
        disparo=0;
        disparo2=0;
        disparo3=0;


    }

    public void onDraw(Canvas c) {
        super.onDraw(c);
        Paint p = new Paint();

        fondo.pintar(c, p);
        punto2.pintar(c,p);
        punto3.pintar(c,p);
        punto1.pintar(c,p);
        punto0.pintar(c,p);
        vida.pintar(c,p);
        vidal.pintar(c,p);
        vidaf.pintar(c,p);
        marciano1.pintar(c, p);
        marciano2.pintar(c, p);
        marciano3.pintar(c, p);
        isla1.pintar(c, p);
        isla2.pintar(c, p);
        isla3.pintar(c, p);
        bala.pintar(c, p);
        nave.pintar(c, p);
        eliminar.pintar(c, p);
        gameOver.pintar(c, p);
        puntos.pintar(c,p);
        win.pintar(c,p);
        dmarciano.pintar(c, p);
        dmarciano2.pintar(c, p);
        dmarciano3.pintar(c, p);
        restart.pintar(c, p);

        //CODIGO PARA COLISION ENTRE LA BALA  DE LA NAVE A LOS MARCIANOS

        puntero2=bala;

        if (puntero2.colision(marciano1) && disparo==0)         //Codigo para la colision entre la bala y el marciano
            {
                marciano1.hacerVisible(false);
                dmarciano.hacerVisible(false);
                cont = 1;
                contador2 = cont;
                disparo=1;
                contP=contP+1;
            }

        if(puntero2.colision(marciano2) && disparo2==0)         //Codigo para la colision entre la bala y el marciano
                                                                //Si disparo ==0 entonces se podra hacer invisible marciano 2 y disparo Y disparo cambiara a 1
        {
            marciano2.hacerVisible(false);
            dmarciano2.hacerVisible(false);
            cont=1;
            contador2=cont;
            disparo2=1;
            contP=contP+1;
        }

        if(puntero2.colision(marciano3) && disparo3==0)         //Codigo para la colision entre la bala y el marciano
        {
            marciano3.hacerVisible(false);
            dmarciano3.hacerVisible(false);
            cont=1;
            contador2=cont;
            disparo3=1;
            contP=contP+1;
        }

        ///////////////////MENSAJE DE PUNTOS
        if(contP==1)
        {
            punto0.hacerVisible(false);
            punto1.hacerVisible(true);
            punto2.hacerVisible(false);
            punto3.hacerVisible(false);
        }
        else
        {
            if(contP==2)
            {
                punto1.hacerVisible(false);
                punto2.hacerVisible(true);
                punto3.hacerVisible(false);
            }
            else
                if (contP==3)
                {
                    punto1.hacerVisible(false);
                    punto2.hacerVisible(false);
                    punto3.hacerVisible(true);
                    win.hacerVisible(true);
                    isla1.hacerVisible(false);
                    isla2.hacerVisible(false);
                    isla3.hacerVisible(false);
                    restart.hacerVisible(true);

                }
        }

        //CODIGO PARA APARECER IMAGEN CUANDO MATES A UN MARCIANO
        if(contador2==1 && contP!=3 && conElimina==0 )
        {
            eliminar.hacerVisible(true);
            conElimina=1;

        }
        if(contador2==0 && conElimina==0 )
        {
            eliminar.hacerVisible(false);
            conElimina=1;

        }


        //COLISIONES BALAS DE MARCIANOS CON NAVE

        if (puntero3.colision(nave) && disparo==0) {
            nave.hacerVisible(false);
            vidaf.hacerVisible(true);
            vida.hacerVisible(false);
            gameOver.hacerVisible(true);
            bala.hacerVisible(false);
            marciano1.hacerVisible(false);
            marciano2.hacerVisible(false);
            marciano3.hacerVisible(false);
            isla1.hacerVisible(false);
            isla2.hacerVisible(false);
            isla3.hacerVisible(false);
            dmarciano.hacerVisible(false);
            dmarciano2.hacerVisible(false);
            dmarciano3.hacerVisible(false);

        } else {

        if (puntero4.colision(nave) && disparo2==0) // si disparo cambio a 1 entonces la colision no se hara, es decir si ya eliminaron a la nave extrangera
                                                    //no tiene casi se haga una colision entre la bala y la navesita
        {
            vidaf.hacerVisible(true);
            nave.hacerVisible(false);
            vida.hacerVisible(false);
            gameOver.hacerVisible(true);
            marciano1.hacerVisible(false);
            marciano2.hacerVisible(false);
            marciano3.hacerVisible(false);
            isla1.hacerVisible(false);
            isla2.hacerVisible(false);
            isla3.hacerVisible(false);
            bala.hacerVisible(false);
            dmarciano.hacerVisible(false);
            dmarciano2.hacerVisible(false);
            dmarciano3.hacerVisible(false);

        } else {
            if (puntero5.colision(nave) && disparo3==0) {
                nave.hacerVisible(false);
                vidaf.hacerVisible(true);
                vida.hacerVisible(false);
                gameOver.hacerVisible(true);
                marciano1.hacerVisible(false);
                marciano2.hacerVisible(false);
                marciano3.hacerVisible(false);
                isla1.hacerVisible(false);
                isla2.hacerVisible(false);
                isla3.hacerVisible(false);
                bala.hacerVisible(false);
                dmarciano.hacerVisible(false);
                dmarciano2.hacerVisible(false);
                dmarciano3.hacerVisible(false);
            }
        }
    }
    }

   public boolean onTouchEvent(MotionEvent e) {
        float xtoque = e.getX();
        float ytoque = e.getY();

        switch (e.getAction()) {

            //Si se toca
            case MotionEvent.ACTION_DOWN:

                    if (nave.siSeToco(xtoque, ytoque)) {

                        bala = new Naves(R.drawable.explo, xtoque, ytoque, this, bala);  //codigo para que cuando toquues se suelte un bala
                        puntero2 = bala;
                        puntero = nave;
                        contador2 = 0;
                    }
                    bala.subirBala(30); //subir la bala
                


                if(restart.siSeToco(xtoque,ytoque))
                {
                    Intent otraventana=new Intent(obj,MainActivity.class);
                    obj.startActivity(otraventana);
                }

                break;

                //Si se mueve
            case MotionEvent.ACTION_MOVE:

               if (puntero == nave ) {
                   nave.mover(xtoque);

               }

                    break;

                    //Se ejecuta cuando quitas el dedo de la pantalla
                    case MotionEvent.ACTION_UP:
                        break;

                }
                invalidate();
                return true;

        }
    }





