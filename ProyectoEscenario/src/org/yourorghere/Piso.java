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
public class Piso {

    Cubo plano1, plano2, plano4, plano;
    Cubo tierra1, tierra2, tierra4;
    GL gl;

    float x, y, z;
    float w, h, d;

    public Piso(GL gl, float x, float y, float z, float w, float h, float d) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;

        plano = new Cubo(gl, 0, 0, 0, 2*w , h/2,  d , 0.32f,0.37f,0.16f);
        
        plano1 = new Cubo(gl, 0, 0, 0, 3 * w / 16, h, 11.5f * d / 25, 0.9f, 0.9f, 1.0f);
        tierra1 = new Cubo(gl, 0, 0, 0, plano1.w / 3, 1.1f * plano1.h, 9.5f*plano1.d/11.5f, 0.43f, 0.25f, 0.19f);
        
        plano2 = new Cubo(gl, 0, 0, 0, 10f * w / 16, h, 3 * w / 16, 0.9f, 0.9f, 1.0f);
        tierra2 = new Cubo(gl, 0, 0, 0, plano2.w , 1.1f * plano2.h, plano2.d/3, 0.43f, 0.25f, 0.19f);
        
        plano4 = new Cubo(gl, 0, 0, 0,  w , h, 5 * d / 16, 0.9f, 0.9f, 1.0f);
        tierra4 = new Cubo(gl, 0, 0, 0, plano4.w/2.5f , 1.1f * plano4.h, plano4.d/4, 0.43f, 0.25f, 0.19f);
    }

    public void dibujarPiso() {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        plano.dibujarCubo();
        
        //1
        gl.glPushMatrix();
        gl.glTranslatef(-6.5f * w / 16f, 0, 6.25f * d / 25f);
        plano1.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,0,plano1.d/11.5f);
        tierra1.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(plano1.w/3,0,-2.75f*plano1.d/11.5f);
        gl.glScalef(1,1,0.21f);
        tierra1.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        //FIN 1
        
        //2
        gl.glPushMatrix();
        gl.glTranslatef(0,0,3.5f*d/25);
        plano2.dibujarCubo();
        tierra2.dibujarCubo();
        gl.glPopMatrix();
        //FIN 2
        
        //3
        gl.glPushMatrix();
        gl.glTranslatef(6.5f * w / 16f, 0,  0.74f*d / 25f);
        plano1.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(0,0,-plano1.d/11.5f);
        tierra1.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(-plano1.w/3,0,2.75f*plano1.d/11.5f);
        gl.glScalef(1,1,0.21f);
        tierra1.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        //FIN 3
        
        //4
        gl.glPushMatrix();
        gl.glTranslatef(0,0,-d/2.8f);
        plano4.dibujarCubo();
        
        gl.glPushMatrix();
        gl.glTranslatef(plano4.w/4.22f,0,0);
        tierra4.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(plano4.w/2.465f,0,plano4.d/2);
        gl.glScalef(1,1,0.5f);
        gl.glRotatef(90,0,1,0);
        tierra4.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(plano4.w/35,0,-plano4.d/5.4f);
        gl.glScalef(0.6f,1,0.38f);
        gl.glRotatef(90,0,1,0);
        tierra4.dibujarCubo();
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        //FIN 4
        
        gl.glPopMatrix();
    }

}
