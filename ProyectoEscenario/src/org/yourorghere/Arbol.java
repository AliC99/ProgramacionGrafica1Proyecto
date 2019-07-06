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
public class Arbol {
    Cubo tronco;
    Piramide hojas;
    Esfera luces,luces1, luces2,luces3;    
    GL gl;
    
    float x, y, z;
    float w, h, d;
    float ang;

    public float getX(){
        return x;
    }
    
    public Arbol(GL gl, float x, float y, float z, float w, float h, float d,float ang) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang=ang;
        
        tronco=new Cubo(gl,0,0,0,w/4,h/4,d/4,0.3f,0.1f,0.1f);
        hojas=new Piramide(gl,0,0,0, w, tronco.h, d, 0.2f, 0.5f, 0.3f);
        luces= new Esfera(gl, 0, 0, 0, hojas.w/12, hojas.h/9, hojas.d/20, 0.4f, 0, 0.1f, 5, 5);
        luces1= new Esfera(gl, 0, 0, 0, hojas.w/12, hojas.h/9, hojas.d/20, 0.7f, 0.7f, 0.3f, 5, 5);
        luces2= new Esfera(gl, 0, 0, 0, hojas.w/12, hojas.h/9, hojas.d/20, 0.3f, 0.3f, 0.5f, 5, 5);
        luces3= new Esfera(gl, 0, 0, 0, hojas.w/12, hojas.h/9, hojas.d/20, 0.3f, 0.7f, 0.5f, 5, 5);
    }
    
    public void dibujarArbol(){
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        gl.glRotatef(ang,0,1,0);
        //Teclado.rotarY(gl);
        tronco.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(tronco.x,tronco.y+tronco.h,tronco.z);  
        hojas.dibujarPiramide();
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glTranslatef(tronco.x,tronco.y+1.5f*tronco.h,tronco.z);  
        hojas.dibujarPiramide();
        gl.glPopMatrix();
        
         gl.glPushMatrix();
        gl.glTranslatef(tronco.x,tronco.y+2f*tronco.h,tronco.z);  
        hojas.dibujarPiramide();
        gl.glPopMatrix();
        
        
        //Luces
        gl.glPushMatrix();
        gl.glTranslatef(0, hojas.h/1.5f,hojas.d/2);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0, 2f*hojas.h,hojas.d/4);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-hojas.w/3, 1.2f*hojas.h,hojas.d/2.3f);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(hojas.w/3, 1.2f*hojas.h,hojas.d/2.3f);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0, 1.4f*hojas.h,hojas.d/2.3f);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces1.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(hojas.w/3.5f, 1.7f*hojas.h,hojas.d/2.4f);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces1.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0, 2.3f*hojas.h,hojas.d/6.5f);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces1.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-hojas.w/3.5f, hojas.h/1.5f,hojas.d/2f);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces1.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(hojas.w/3.5f, hojas.h/1.5f,hojas.d/2f);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces2.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0, 1.7f*hojas.h,hojas.d/2.5f);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces2.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0, 1.1f*hojas.h,hojas.d/2.2f);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces2.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(hojas.w/4f, 1.1f*hojas.h,hojas.d/2.2f);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces3.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-hojas.w/4f, 1.6f*hojas.h,hojas.d/2.2f);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces3.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(hojas.w/4.3f, 1.95f*hojas.h,hojas.d/3.7f);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces3.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-hojas.w/4.4f, 1.95f*hojas.h,hojas.d/3.7f);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces3.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-hojas.w/6f, hojas.h/1.2f,hojas.d/3f);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces3.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(hojas.w/6f, hojas.h/1.2f,hojas.d/3f);
        gl.glScalef(0.4f,0.7f,0.6f);
        luces3.dibujarEsfera();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        
        
    }
}
