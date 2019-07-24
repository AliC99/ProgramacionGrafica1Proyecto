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
public class Faro2 {
    GL gl;

    float x, y, z;
    float w, h, d;
    float ang;

    Cubo base,luz,sluz;
    Piramide baseluz;
    
    public Faro2(GL gl, float x, float y, float z, float w, float h, float d, float ang) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang = ang;
        
        base=new Cubo(gl,0,0,0,w/3,3.5f*h/6f,d/10,0.22f,0.11f,0.05f);
        luz=new Cubo(gl,0,0,0,w,h/8f,d/3,1,1,0.96f);
        baseluz=new Piramide(gl,0,0,0,w-w/6,h/6,d/3,0.22f,0.11f,0.05f);
        sluz=new Cubo(gl,0,0,0,w,h/17f,d/3,0.22f,0.11f,0.05f);
        
        
    }

    public void faro2(){
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        
        //Teclado.rotarY(gl);
        gl.glRotatef(ang,0,1,0);
        
        base.dibujarCubo();
        
        
        gl.glPushMatrix();
        gl.glTranslatef(0,-base.h/2,0);
        gl.glScalef(1,0.5f,1);
        baseluz.dibujarPiramide();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,base.h/2,0);
        gl.glRotatef(180,1,0,0);
        baseluz.dibujarPiramide();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,-baseluz.h/1.1f,0);
        luz.dibujarTrapecio(w/6);                
        
        //  MARCO LUZ
        gl.glPushMatrix();
        gl.glTranslatef(luz.w/2,0,luz.d/2);
        gl.glScalef(0.1f,0.24f,0.5f);
        gl.glRotatef(30,0,0,1);
        base.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(luz.w/2,0,-luz.d/2);
        gl.glScalef(0.1f,0.24f,0.5f);
        gl.glRotatef(30,0,0,1);
        base.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-luz.w/2,0,luz.d/2);
        gl.glScalef(0.1f,0.24f,0.5f);
        gl.glRotatef(-30,0,0,1);
        base.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-luz.w/2,0,-luz.d/2);
        gl.glScalef(0.1f,0.24f,0.5f);
        gl.glRotatef(-30,0,0,1);
        base.dibujarCubo();
        gl.glPopMatrix();
        
        //FIN MARCO LUZ
        
        
        gl.glPushMatrix();
        gl.glTranslatef(0,-luz.h/1.35f,0);
        gl.glRotatef(180,1,0,0);
        sluz.dibujarTrapecio(w/6);
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        
        gl.glPopMatrix();

        gl.glPopMatrix();

    }
    
}
