package org.yourorghere;



import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alison
 */
public class Dodecaedro {
    GL gl;
    float x, y, z;
    float w, h, d;  
    float r,g,b;

    public Dodecaedro(GL gl, float x, float y, float z, float w, float h, float d, float r, float g, float b) {
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
    }
    
    
    public void solido(){
         GLUT glut=new GLUT();
          gl.glPushMatrix();
        gl.glColor3f(r, g, b);        
        gl.glScalef(w,h,d);   
        glut.glutSolidDodecahedron();
        gl.glPopMatrix();
    }
    
    public void wire(){
        GLUT glut=new GLUT();
        gl.glPushMatrix();
        gl.glColor3f(r, g, b);        
        gl.glScalef(w,h,d);   
        glut.glutWireDodecahedron();
        gl.glPopMatrix();
    }
    
}
