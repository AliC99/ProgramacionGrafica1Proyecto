/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author Alison
 */
public class Esfera {

    GL gl;
    float x, y, z;
    float w, h, d;
    float c1, c2, c3;
    int slices, stacks;

    public Esfera(GL gl, float x, float y, float z, float w, float h, float d, float c1, float c2, float c3, int slices, int stacks) {
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
        this.slices = slices;
        this.stacks = stacks;
    }

    
    public void dibujarEsfera(){
        GLU glu = new GLU();
        gl.glPushMatrix();
        gl.glColor3f(c1, c2, c3);
        gl.glScalef(w,h,d);       
        GLUquadric esfera = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(esfera, GLU.GLU_FILL);
        glu.gluSphere(esfera, 1, slices, stacks);
        gl.glPopMatrix();
       
    }
    
   
    
    public void dibujarWireEsfera(){
        GLUT glut = new GLUT();
        gl.glPushMatrix();
        gl.glColor3f(c1, c2, c3);
        gl.glScalef(w,h,d);       
        glut.glutWireSphere(1, slices, stacks);
        gl.glPopMatrix();
       
    }
    
}
