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
    //Cuadrado plano;
    Esfera nieve;
    Cubo plano;
    Cubo tierra;
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
        
        //plano=new Cuadrado(gl, 0, 0, 0, w, h, d, 0.9f, 0.9f, 1.0f);
        plano=new Cubo(gl, 0, 0, 0, w, h, d, 0.9f, 0.9f, 1.0f);
        nieve=new Esfera(gl,0,0,0,0.1f,0.1f,0.5f,0.9f, 0.9f, 1.0f,32,32);
        tierra=new Cubo(gl, 0, 0, 0, w/3, 1.1f*h, d, 0.43f,0.25f,0.19f);
    }
    
    public void dibujarPiso(){
     gl.glPushMatrix();
     gl.glTranslatef(x,y,z);
     
    // plano.dibujarBase();
      plano.dibujarCubo();
      tierra.dibujarCubo();
//     //Nieve
//     //1
//     gl.glPushMatrix();
//     gl.glTranslatef(x+0.25f, y+0.9f, z+2.5f);
//     nieve.dibujarEsfera();
//     gl.glPopMatrix();
//     //2
//     gl.glPushMatrix();
//     gl.glTranslatef(x+0.4f, y+0.6f, z+2.5f);
//     nieve.dibujarEsfera();
//     gl.glPopMatrix();
//     
//     //3
//     gl.glPushMatrix();
//     gl.glTranslatef(x+0.6f, y+0.56f, z+2.8f);
//     nieve.dibujarEsfera();
//     gl.glPopMatrix();
//     
//     //4
//     gl.glPushMatrix();
//     gl.glTranslatef(x+0.65f, y, z+1.3f);
//     nieve.dibujarEsfera();
//     gl.glPopMatrix();
//     
//     //5
//     gl.glPushMatrix();
//     gl.glTranslatef(x+0.75f, y+0.6f, z+1.1f);
//     nieve.dibujarEsfera();
//     gl.glPopMatrix();
//     
//     //6
//     gl.glPushMatrix();
//     gl.glTranslatef(x+0.85f, y+0.7f, z+1.3f);
//     nieve.dibujarEsfera();
//     gl.glPopMatrix();
//     
//     //7
//     gl.glPushMatrix();
//     gl.glTranslatef(x+0.95f, y+0.73f, z+1.3f);
//     nieve.dibujarEsfera();
//     gl.glPopMatrix();
//     
//     //8
//     gl.glPushMatrix();
//     gl.glTranslatef(x+1.05f, y+0.7f, z+1.3f);
//     nieve.dibujarEsfera();
//     gl.glPopMatrix();
//     
//     //9
//     gl.glPushMatrix();
//     gl.glTranslatef(x+1.15f, y+0.71f, z+1.3f);
//     nieve.dibujarEsfera();
//     gl.glPopMatrix();
//     
//     //10
//     gl.glPushMatrix();
//     gl.glTranslatef(x+1.25f, y+0.72f, z+1.5f);
//     nieve.dibujarEsfera();
//     gl.glPopMatrix();
//     
//     
//     //11
//     gl.glPushMatrix();
//     gl.glTranslatef(x+1.42f, y+0.73f, z+1.5f);
//     nieve.dibujarEsfera();
//     gl.glPopMatrix(); 
//     
//     //12
//     gl.glPushMatrix();
//     gl.glTranslatef(x+1.65f, y+0.71f, z+1.5f);
//     nieve.dibujarEsfera();
//     gl.glPopMatrix();
//     
//     //13
//     gl.glPushMatrix();
//     gl.glTranslatef(x+1.75f, y+0.72f, z+1.5f);
//     nieve.dibujarEsfera();
//     gl.glPopMatrix();
//     
//     //14
//     gl.glPushMatrix();
//     gl.glTranslatef(x+0.85f, y+0.73f, z+1.5f);
//     nieve.dibujarEsfera();
//     gl.glPopMatrix();
     
     gl.glPopMatrix();
    }
    
}
