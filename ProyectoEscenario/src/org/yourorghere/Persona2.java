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
public class Persona2 {
    GL gl;
    float x, y, z;
    float w, h, d;
    float ang;

    Esfera cabeza;
    Cubo cuerpo,ropa, 
         lentes,
         brazo,hombro, cuello;
    
    
    
    public Persona2(GL gl, float x, float y, float z, float w, float h, float d, float ang) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang = ang;
        
        cabeza = new Esfera(gl, 0, 0, 0, 2.5f*w / 5, 2.5f*w / 5, 2.5f*w / 5, 1.0f, 0.79f, 0.05f, 15, 15);
        cuerpo = new Cubo(gl, 0, 0, 0,w, 2f*h / 5, d, 0.1f, 0.1f, 0.1f);
        cuello = new Cubo(gl, 0, 0, 0,w/4, h / 10, d/4, 1.0f, 0.79f, 0.05f);
        ropa= new Cubo(gl, 0, 0, 0,cuerpo.w/2.5f, cuerpo.h / 2, cuerpo.d/1.5f, 0.9f, 0.9f, 0.9f);
        lentes= new Cubo(gl, 0, 0, 0,cabeza.w/2.5f, cabeza.h / 2, cabeza.d/2f, 0.4f, 0.6f, 0.8f);
    }
    
    public void persona2(){
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        gl.glRotatef(ang,0,1,0);
        
       
        
        gl.glPushMatrix();
        gl.glTranslatef(0,cuerpo.h/2,0);
        cuello.dibujarCubo();
        
         gl.glPushMatrix();
        gl.glTranslatef(0,2*cuello.h,0);
        cabeza.dibujarEsfera();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,0,-cabeza.d);
        gl.glScalef(0.25f,0.05f,0.2f);
        cuerpo.dibujarCubo();        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-cabeza.w/2,0,-cabeza.d);
        lentes.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(cabeza.w/2,0,-cabeza.d);
        lentes.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(180,1,0,0);
        cuerpo.dibujarTrapecio(w/6);
        
        gl.glPushMatrix();
        gl.glTranslatef(0,-cuerpo.h/4,cuerpo.d/2.5f);
        ropa.dibujarTrapecio(w/6);
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,-cuerpo.h,0);
        cuerpo.dibujarTrapecio(w/6);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(cuerpo.w/1.8f,cuerpo.h/5f,cuerpo.d/2.5f);
        ropa.dibujarTrapecio(w/6);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(cuerpo.w/1.6f,-cuerpo.h/3,cuerpo.d/2.5f);
        gl.glScalef(1,1.5f,0.9f);
        gl.glRotatef(200,1,0,0);
        gl.glRotatef(-30,0,0,1);
        ropa.dibujarTrapecio(w/6);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-cuerpo.w/1.6f,-cuerpo.h/3,cuerpo.d/2.5f);
        gl.glScalef(1,1.5f,0.9f);
        gl.glRotatef(200,1,0,0);
        gl.glRotatef(30,0,0,1);
        ropa.dibujarTrapecio(w/6);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-cuerpo.w/1.8f,cuerpo.h/5f,cuerpo.d/2.5f);
        ropa.dibujarTrapecio(w/6);
        gl.glPopMatrix();
        
        gl.glPopMatrix();
    }
    
    
    
}
