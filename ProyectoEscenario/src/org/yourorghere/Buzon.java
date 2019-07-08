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
public class Buzon {
    
    Cubo buzon1, puerta1, base,
         buz;
    Esfera buzon2,buzon3, puerta2;
    
    GL gl;

    float x, y, z;
    float w, h, d;
    float ang;

    public Buzon(GL gl, float x, float y, float z, float w, float h, float d, float ang) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang = ang;
    
        base=new Cubo(gl,0,0,0,w/3,2*h/3,d/5,0.3f,0.1f,0.1f);
        buzon1=new Cubo(gl,0,0,0,w,2*h/9,d,0.87f,0.54f,0.35f);
        buzon2= new Esfera(gl, 0, 0, 0, w/1.35f, h/7.5f, d/1.95f, 0.83f,0.34f,0.15f, 15, 15);
        buzon3= new Esfera(gl, 0, 0, 0, w/2f, h/7.5f, d/15, 0.87f,0.54f,0.35f, 15, 15);
        buz=new Cubo(gl,0,0,0,w/2.2f,h/21,d/5,0.95f,0.27f,0.25f);
        puerta1=new Cubo(gl,0,0,0,w,2*h/9,d/5,0.53f,0.33f,0.25f);
        puerta2= new Esfera(gl, 0, 0, 0, w/1.9f, h/9, d/6f, 0.53f,0.33f,0.25f, 15, 15);        
        
    }
    
    
    public void buzon(){
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        gl.glRotatef(ang,0,1,0);
        parteSuperior();
        parteInferior();
        gl.glPopMatrix();
    }
    
    public void parteSuperior(){
       gl.glPushMatrix();
       gl.glTranslatef(0,2.5f*h/9,0);
      gl.glRotatef(ang,0,1,0);
       
       buzon1.dibujarCubo();
       
       
       gl.glPushMatrix();
       gl.glTranslatef(0,buzon1.h/1.9f,-buzon1.d/10.9f);
      // gl.glRotatef(45,1,0,0);
       buzon2.dibujarEsfera();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
       gl.glTranslatef(0,buzon1.h/1.9f,buzon1.d/2);
       buzon3.dibujarEsfera();
       gl.glPopMatrix();
       
       //ROJO
       gl.glPushMatrix();
       gl.glTranslatef(buzon1.w/2,0,0);
       buz.dibujarCubo();
       gl.glPopMatrix();
       
       gl.glPushMatrix();
       gl.glTranslatef(buzon1.w/1.3f,buz.h/1.45f,0);
       gl.glRotatef(-90,0,0,1);
       buz.dibujarCubo();
       gl.glPopMatrix();
       //FIN ROJO
       
        //Puerta
       gl.glPushMatrix();
       gl.glTranslatef(0,0,buzon1.d/2);
       gl.glScalef(0.5f,0.5f,1);      
       //gl.glRotatef(-90,0,1,0);
       puerta1.dibujarCubo();       
       gl.glPushMatrix();
       gl.glTranslatef(0,puerta1.h/2,0);       
       puerta2.dibujarEsfera();
       gl.glPopMatrix();
       
       gl.glPopMatrix();       
       
       gl.glPopMatrix();
       
       
       
      
       
       
    }
    
    public void parteInferior(){
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.5f*h/9,0);
        base.dibujarCubo();
        gl.glPopMatrix();


    }
    
    
}
