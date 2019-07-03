/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author Alison
 */
public class Cilindro {
    GL gl;
    float x, y, z;
    float w, h, d;    
    float c1, c2, c3;
    int slices, stacks;
    double rs, ri;

    public Cilindro(GL gl, float x, float y, float z, float w, float h, float d, float c1, float c2, float c3, int slices, int stacks, double rs, double ri) {
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
        this.rs = rs;
        this.ri = ri;
    }
    
    public void dibujarCilindro(){
        GLU glu = new GLU();
        gl.glPushMatrix();
        gl.glColor3f(c1, c2, c3);
        gl.glScalef(w,h,d);
        GLUquadric cilindro = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(cilindro, GLU.GLU_FILL);
        glu.gluCylinder(cilindro, ri, rs, 1, slices, stacks);
        gl.glPopMatrix();
        gl.glEnd();
    }
   
}
