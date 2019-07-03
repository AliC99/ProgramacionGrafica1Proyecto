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
public class Cielo {
    
    //Cubo cielo;
    Cuadrado cielo;
    Estrella e1;
    
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
        
        //cielo=new Cubo(gl,0,0,0,w,h,d,0.0f,0.0f,0.25f);
        cielo=new Cuadrado(gl,0,0,0,w,h,d,0.0f,0.0f,0.1f);
        e1=new Estrella(gl,0,0,0,1f,1.3f,0.9f,0);
    }
    
    
    
    
    public void noche(){
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        //cielo.dibujarCubo();
        cielo.dibujarCuadradoxy();
        cielo.dibujarLateralDe();
        cielo.dibujarLateralIz();
        gl.glPushMatrix();
        gl.glTranslatef(0,h/2.6f,-d/2.3f);
        e1.estrella();
        gl.glPopMatrix();
        gl.glPopMatrix();
    }
    
    public void dia(){
        
    }
}
