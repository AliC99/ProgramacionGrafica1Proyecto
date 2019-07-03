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
public class Estrella {
    Piramide punta;
    
    GL gl;

    float x, y, z;
    float w, h, d;
    float ang;  

    public Estrella(GL gl, float x, float y, float z, float w, float h, float d, float ang) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang = ang;
        
        punta=new Piramide(gl,0,0,0,w/3,1f*h/3,d,1,1,0.6f);
    }
    
    
    public void estrella(){
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        
        //PUNTA SUPERIOR
        gl.glPushMatrix();
        gl.glTranslatef(0,0.5f*h/3,0);
        punta.dibujarPiramide();
        gl.glPopMatrix();
        //FIN PUNTA SUPERIOR
        
        //PUNTA INFERIOR
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.5f*h/3,0);
        gl.glRotatef(180,1,0,0);
        punta.dibujarPiramide();
        gl.glPopMatrix();
        //FIN PUNTA INFERIOR
        
        //PUNTA DERECHA
        gl.glPushMatrix();
        gl.glTranslatef(0.85f*w/3,0,0);
        gl.glRotatef(-90,0,0,1);
        punta.dibujarPiramide();
        gl.glPopMatrix();
        //FIN PUNTA DERECHA
        
        //PUNTA IZQUIERDA
        gl.glPushMatrix();
        gl.glTranslatef(-0.85f*w/3,0,0);
        gl.glRotatef(90,0,0,1);
        punta.dibujarPiramide();
        gl.glPopMatrix();
        //FIN PUNTA IZQUIERDA
        
        gl.glPopMatrix();
        
    }
    
    
    
}

