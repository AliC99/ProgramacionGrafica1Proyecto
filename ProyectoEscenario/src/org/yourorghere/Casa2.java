/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author Alison
 */
public class Casa2 {

    GL gl;

    float x, y, z;
    float w, h, d;
    float ang;
    
    Cubo base, base1,techo, soporte,tabla,nieve,letrero,cflecha,cletrero;
    Piramide pflecha;
    Esfera enieve;

    public Casa2(GL gl, float x, float y, float z, float w, float h, float d, float ang) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang = ang;
        
        soporte= new Cubo(gl, 0,0,0, 0.5f*w/6,5*h/6,0.5f*d/6,0.66f, 0.44f, 0.29f);        
        base= new Cubo(gl, 0,0,0, 1,1,1,0.55f,0.29f,0.15f);
        base1= new Cubo(gl, 0,0,0, 1,1,1,0.45f,0.19f,0.05f);
        techo= new Cubo(gl, 0,0,0, w,h/24,1.1f*d,0.4f,0.14f,0.07f);
        tabla= new Cubo(gl, 0,0,0, 1.5f*w,h/36,1.4f*d,0.5f,0.24f,0.17f); 
        nieve= new Cubo(gl, 0,0,0, w,h/24,1.1f*d,0.8f,0.8f,0.9f); 
        letrero= new Cubo(gl, 0,0,0, w/1.8f,h/6,d/30,0.49f,0.24f,0.11f);
        cletrero= new Cubo(gl, 0,0,0, letrero.w/5,1.5f*letrero.h,letrero.d,0.39f,0.14f,0.01f);
        cflecha= new Cubo(gl, 0,0,0, letrero.w/1.9f,letrero.h/3f,letrero.d,0.67f,0.04f,0.0f);
        pflecha=new Piramide(gl,0,0,0,letrero.w/3,letrero.h/2.5f,letrero.d,0.67f,0.04f,0.0f);
        enieve  = new Esfera(gl, 0, 0, 0, w/6f, h/35, d/5.5f, 0.8f,0.8f,0.9f, 10, 10);
    }

    
    public void casa2(){
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        
        //BASE
        gl.glPushMatrix();
        gl.glScalef(w/6,2*h/6,d);    
        base.cuboP(6, base,base1, base.w, base.h, base.d);                        
        gl.glPopMatrix();
        //FIN BASE
        
        //TABLA
        gl.glPushMatrix();
        gl.glTranslatef(0,h/6,0);
        tabla.dibujarCubo();
        
        //NIEVE
        gl.glPushMatrix();
        gl.glTranslatef(0,tabla.h/2,0);
        gl.glScalef(1.2f,1,1.9f);
        enieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-tabla.w/3f,tabla.h/2.2f,tabla.d/3f);
        enieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-tabla.w/5f,tabla.h/1.7f,tabla.d/2.6f);
        enieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(tabla.w/3f,tabla.h/2.2f,tabla.d/3f);
        enieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(tabla.w/5f,tabla.h/1.7f,tabla.d/2.6f);
        enieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,tabla.h/1.7f,tabla.d/2.4f);
        gl.glScalef(2f,1,1);
        enieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(tabla.w/2.3f,tabla.h/1.7f,tabla.d/2.3f);
        gl.glScalef(0.5f,1,0.5f);
        enieve.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-tabla.w/2.3f,tabla.h/1.7f,tabla.d/2.3f);
        gl.glScalef(0.5f,1,0.5f);
        enieve.dibujarEsfera();
        gl.glPopMatrix();
        //FIN NIEVE
        
        gl.glPopMatrix();
        //FIN TABLA
        
        //SOPORTE
        gl.glPushMatrix();
        gl.glTranslatef(-w/1.5f,h/4f,d/2);
        soporte.dibujarCubo();
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glTranslatef(-w/1.5f,h/4f,-d/2);
        soporte.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(w/1.5f,h/4f,d/2);
        soporte.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(w/1.5f,h/4f,-d/2);
        soporte.dibujarCubo();
        gl.glPopMatrix();
        //FIN SOPORTE
        
        //TECHO
        gl.glPushMatrix();
        gl.glTranslatef(-w/2.4f,h/1.35f,0);
        gl.glRotatef(30,0,0,1);
        techo.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,techo.h/2,0);
        nieve.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(w/2.4f,h/1.35f,0);
        gl.glRotatef(-30,0,0,1);
        techo.dibujarCubo();
        
         gl.glPushMatrix();
        gl.glTranslatef(0,techo.h/2,0);
        nieve.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        //FIN TECHO
        
        //LETRERO
        gl.glPushMatrix();
        gl.glTranslatef(0,h/3,0);
        letrero.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,-letrero.h/2,-letrero.d/2);
        cletrero.dibujarCubo();
        gl.glPopMatrix();
        
        //  FLECHA
        gl.glPushMatrix();
        gl.glTranslatef(-letrero.w/25f,0,letrero.d/2);
        cflecha.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(cflecha.w/2,0,0);
        gl.glRotatef(-90,0,0,1);
        pflecha.dibujarPiramide();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        //FIN FLECHA
        
        gl.glPopMatrix();
        //FIN LETRERO
        
        gl.glPopMatrix();
    }
    
}
