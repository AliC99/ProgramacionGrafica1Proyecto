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
public class Iglu {
    GL gl;

    float x, y, z;
    float w, h, d;
    float ang;

    Esfera base,base1;
    Cubo puerta,p1;
    
    public Iglu(GL gl, float x, float y, float z, float w, float h, float d, float ang) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang = ang;
        
        base=new Esfera(gl,0,0,0,w,h,d,0.75f,0.75f,0.85f,11,11);
        base1=new Esfera(gl,0,0,0,1.01f*w,1.01f*h,1.01f*d,0.65f,0.65f,0.75f,6,6);
        puerta=new Cubo(gl,0,0,0,w/1.5f,h/1.5f,d/10,0.65f,0.65f,0.9f);
        p1=new Cubo(gl,0,0,0,puerta.w/1.5f,puerta.h/1.2f,puerta.d,0.1f,0.1f,0.15f);
    }
    
    public void iglu(){
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        gl.glRotatef(ang,0,1,0);
        //BASE
        base.dibujarEsfera();
        
        gl.glPushMatrix();
        gl.glRotatef(90,1,0,0);
        base1.dibujarWireEsfera();
        gl.glPopMatrix();
        //FIN BASE
        
       gl.glPushMatrix();
       gl.glTranslatef(0,0,base.d);
       puerta.dibujarCubo();
       
       gl.glPushMatrix();
       gl.glTranslatef(0,-puerta.h/20,puerta.d/2);
       p1.dibujarCubo();
       gl.glPopMatrix();
       
       gl.glPopMatrix();
        
        gl.glPopMatrix();
    }
    
    
}
