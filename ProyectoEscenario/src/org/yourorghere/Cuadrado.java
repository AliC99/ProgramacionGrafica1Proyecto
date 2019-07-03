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
public class Cuadrado {

    GL gl;
    float x, y, z, w, h, d;
    float c1, c2, c3;

    public Cuadrado(GL gl, float x, float y, float z, float w, float h, float d, float c1, float c2, float c3) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    public void dibujarBase() {
        gl.glTranslatef(x,y,z);
        float w1 = w / 2;
        float h1 = h / 2;
        float d1 = d / 2;

        //BASE
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1, c2, c3);
        gl.glVertex3f(0 - w1, 0 - h1, 0 + d1);
        gl.glVertex3f(0 + w1, 0 - h1, 0 + d1);
        gl.glVertex3f(0 + w1, 0 - h1, 0 - d1);
        gl.glVertex3f(0 - w1, 0 - h1, 0 - d1);
        gl.glEnd();
    }

    
    public void dibujarPosterior() {
         gl.glTranslatef(x,y,z);
        float w1 = w / 2;
        float h1 = h / 2;
        float d1 = d / 2;
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1, c2, c3);
        gl.glVertex3f(0 - w1, 0 - h1, 0 - d1);
        gl.glColor3f(c1 - 0.2f, c2 - 0.1f, c3);
        gl.glVertex3f(0 + w1, 0 - h1, 0 - d1);
        gl.glColor3f(c1 - 0.3f, c2 - 0.2f, c3);
        gl.glVertex3f(0 + w1, 0 + h1, 0 - d1);
        gl.glVertex3f(0 - w1, 0 + h1, 0 - d1);
        gl.glEnd();
    }
    
        public void dibujarCuadradoxy() {
             gl.glTranslatef(x,y,z);
        float w1 = w / 2;
        float h1 = h / 2;
        float d1 = d / 2;
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1, c2, c3);
        gl.glVertex3f(0 - w1, 0 - h1, 0 - d1);     
        gl.glVertex3f(0 + w1, 0 - h1, 0 - d1);
        gl.glVertex3f(0 + w1, 0 + h1, 0 - d1);
        gl.glVertex3f(0 - w1, 0 + h1, 0 - d1);
        gl.glEnd();
    }

    public void dibujarLateralIz() {
         gl.glTranslatef(x,y,z);
        float w1 = w / 2;
        float h1 = h / 2;
        float d1 = d / 2;
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1 - 0.2f, c2 - 0.1f, c3);
        gl.glVertex3f(0 - w1, 0 - h1, 0 + d1);
        gl.glColor3f(c1, c2, c3);
        gl.glVertex3f(0 - w1, 0 - h1, 0 - d1);
        gl.glColor3f(c1 - 0.3f, c2 - 0.2f, c3);
        gl.glVertex3f(0 - w1, 0 + h1, 0 - d1);
        gl.glVertex3f(0 - w1, 0 + h1, 0 + d1);
        gl.glEnd();
    }

    public void dibujarLateralDe() {
         gl.glTranslatef(x,y,z);
        float w1 = w / 2;
        float h1 = h / 2;
        float d1 = d / 2;
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1, c2, c3);
        gl.glVertex3f(0 + w1, 0 - h1, 0 + d1);
        gl.glColor3f(c1 - 0.2f, c2 - 0.1f, c3);
        gl.glVertex3f(0 + w1, 0 - h1, 0 - d1);
        gl.glColor3f(c1 - 0.3f, c2 - 0.2f, c3);
        gl.glVertex3f(0 + w1, 0 + h1, 0 - d1);
        gl.glVertex3f(0 + w1, 0 + h1, 0 + d1);
        gl.glEnd();
    }

}
