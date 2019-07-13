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
public class Casa1 {
    
    GL gl;

    float x, y, z;
    float w, h, d;
    float ang;
    
    Cubo pared, pared1,
         puerta;
    Esfera epuerta;
    
    
    public Casa1(GL gl, float x, float y, float z, float w, float h, float d, float ang) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang = ang;
        
        pared=new Cubo(gl,0,0,0,w,4*h/7,d,0.8f,0.58f,0.36f);
        pared1=new Cubo(gl,0,0,0,w,4*h/7,d,0.9f,0.68f,0.46f);
        puerta=new Cubo(gl,0,0,0,w/4,h/2f,d/3,0.46f,0.32f,0.19f);
        epuerta=new Esfera(gl,0,0,0,puerta.w/2,puerta.h/2,puerta.d,0.46f,0.32f,0.19f,10,10);
        
    }
    
    
    
    public void casa1(){
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        
        //PAREDES
        gl.glRotatef(ang,0,1,0);
        pared.paredes(10, pared, pared1, w, h, d, 0, 0, d/2, 0.8f,0.58f,0.36f, 0.9f,0.68f,0.46f);        
        gl.glPushMatrix();
        gl.glTranslatef(-w/2,0,0);
        gl.glScalef(0.5f,0.5f,1);
        pared.paredes(5, pared, pared1, w, h, d, 0, 0, d/2, 0.8f,0.58f,0.36f, 0.9f,0.68f,0.46f);
        gl.glPopMatrix();
        //FIN PAREDES
        
        
         //PUERTA
        gl.glPushMatrix();
        gl.glTranslatef(3*pared.w,pared.h,pared.d/1.15f);
        puerta.dibujarCubo();
        gl.glPopMatrix();
        //FIN PUERTA
        gl.glPopMatrix();
        
       
        
    }
    
}
