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
public class CoposNieve {
    GL gl;
    
    Esfera copo;

    float x, y, z;
    float w, h, d;
    float ang;  

    public CoposNieve(GL gl, float x, float y, float z, float w, float h, float d, float ang) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.ang = ang;
        
        copo = new Esfera(gl, 0, 0, 0,w, h, d, 0.85f, 0.8f, 0.8f, 2, 2);
    }
    
    
    public void copoNieve(){
        gl.glPushMatrix();
        gl.glTranslatef(x,y,z);
        copo.dibujarEsfera();
        gl.glPopMatrix();
    }
    
    
}
