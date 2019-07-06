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
public class Cono {
     GL gl;
    float x, y, z;
    float w, h, d;  
    float r,g,b;
    int slices,stacks;

    public Cono(GL gl, float x, float y, float z, float w, float h, float d, float r, float g, float b, int slices, int stacks) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.r = r;
        this.g = g;
        this.b = b;        
        this.slices = slices;
        this.stacks = stacks;
    }
    
    public void cono(){
        GLUT glut=new GLUT();
        gl.glPushMatrix();
        gl.glColor3f(r, g, g);        
        gl.glScalef(w,h,d);   
        glut.glutSolidCone(1, 1, slices, stacks);
        gl.glPopMatrix();
    }
    
    public void wireCono(){
        
    }
}
