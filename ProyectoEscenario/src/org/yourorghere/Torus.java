/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;

/**
 *
 * @author Alison
 */
public class Torus {
    GL gl;
    float x, y, z;
    float w, h, d;    
    float c1, c2, c3;
    double ri,re;
    int sides,rings;

    public Torus(GL gl, float x, float y, float z, float w, float h, float d, float c1, float c2, float c3, double ri, double re, int sides, int rings) {
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
        this.ri = ri;
        this.re = re;
        this.sides = sides;
        this.rings = rings;
    }
   
    public void dibujarTorus(){
        GLUT glut = new GLUT();
        gl.glPushMatrix();
        gl.glColor3f(c1, c2, c3);
        gl.glScalef(w,h,d);
       glut.glutSolidTorus(ri, re, sides, rings);
        gl.glPopMatrix();
        
    }
    
    
}
