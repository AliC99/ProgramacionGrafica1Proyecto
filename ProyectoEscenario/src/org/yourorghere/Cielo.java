/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.util.ArrayList;
import javax.media.opengl.GL;

/**
 *
 * @author Alison
 */
public class Cielo {

    //Cubo cielo;
    Cuadrado cielo;
    Cuadrado cielo1;
    //Estrella e1;
    ArrayList<Estrella> e;
    ArrayList<Estrella> e1;

    ArrayList<CoposNieve> c;

    
    Esfera sol;
    CoposNieve c2;
    GL gl;

    float x, y, z;
    float w, h, d;

    public Cielo(GL gl, float x, float y, float z, float w, float h, float d) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;

        cielo = new Cuadrado(gl, 0, 0, 0, w, h, d, 0.0f, 0.0f, 0.1f);
        cielo1 = new Cuadrado(gl, 0, 0, 0, w, h, d, 0.62f,0.8f,0.89f);

        
        sol=new Esfera(gl, 0, 0, 0,w/33,w/33, w/33, 0.91f, 0.93f,0.36f, 12, 12);
        c = new ArrayList<CoposNieve>();
            for (float j = -(cielo.h ); j < 7; j++) {
                for (float k = -(cielo.w ); k < 10; k++) {
                    try {
                        c.add(new CoposNieve(gl, 1.2f * (float) Math.random() + k * 1, 1.2f * (float) Math.random() + j * 1, -Proyecto.ancho/2, 0.05f, 0.05f, 0.05f, 0));

                    } catch (Exception ex) {
                        System.exit(0);
                    }
                }

            }
        

    }

    public void cielo() {

        float j = 10000;
        float i = j + 600;

        if (Teclado.rotarY > i) {
            cielo.c1 = 0.0f;
            cielo.c2 = 0.0f;
            cielo.c3 = 0.1f;
            
           
            cielo1.c1 = 0.2f;
            cielo1.c2 = 0.2f;
            cielo1.c3 = 0.6f;
            Teclado.rotarY = 0;
        }

        if (Teclado.rotarY >= j && Teclado.rotarY <= i) {
            dia();

        } else {
            snoche();

        }

    }
  

    
    
    public void snoche() {
        
        cielo.c1 += 0.01f;
        cielo.c2 += 0.02f;
        cielo.c3 += 0.03f;



        gl.glPushMatrix();
        for (CoposNieve c1 : c) {
            Teclado.rotarY(gl, 0.3f);
            c1.copoNieve();
        }
        gl.glPopMatrix();
    }

    public void dia() {
        cielo.c1 -= 0.03f;
        cielo.c2 -= 0.03f;
        cielo.c3 -= 0.04f;
        
        
        if (Teclado.trasY<=-8.5f) {
            Teclado.trasY=0;
        }
        
        if (Teclado.trasY<=0 && Teclado.trasY>=-8.5f) {
            Teclado.trasladarY(gl);
        gl.glPushMatrix();        
        gl.glTranslatef(x, y, z);        
        sol.dibujarEsfera();
        gl.glPopMatrix();
        }
        

    }
}
