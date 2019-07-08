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
public class Cubo {
    
    //GL
    GL gl;
    //coordenadas
    float x,y,z;
    //dimensiones
    float w,h,d; //ancho, alto, profundidad
    //colores
    float c1,c2,c3;
    
    
    public Cubo(GL gl, float x, float y, float z, float w, float h, float d, float c1, float c2, float c3) {
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

    
    
    
    public void dibujarCubo(){
       
       
     gl.glTranslatef(x,y,z);
        float w1=w/2;
        float h1=h/2;
        float d1=d/2;
        
        //BASE
        
        gl.glBegin(gl.GL_QUADS);
       
        gl.glColor3f(c1,c2,c3);
        gl.glVertex3f(0-w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0-d1);
        gl.glVertex3f(0-w1, 0-h1, 0-d1);
        gl.glEnd();
        
        //SUPERIOR
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2,c3-0.2f);
        gl.glVertex3f(0-w1, 0+h1, 0+d1);
        gl.glVertex3f(0+w1, 0+h1, 0+d1);
        gl.glVertex3f(0+w1, 0+h1, 0-d1);
        gl.glVertex3f(0-w1, 0+h1, 0-d1);
        gl.glEnd();
        
        //FRONTAL
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2,c3);
        gl.glVertex3f(0-w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0+h1, 0+d1);
        gl.glVertex3f(0-w1, 0+h1, 0+d1);
        gl.glEnd();
        
        //POSTERIOR
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2-0.1f,c3-0.2f);
        gl.glVertex3f(0-w1, 0-h1, 0-d1);
        gl.glVertex3f(0+w1, 0-h1, 0-d1);
        gl.glVertex3f(0+w1, 0+h1, 0-d1);
        gl.glVertex3f(0-w1, 0+h1, 0-d1);
        gl.glEnd();
        
        //LATERAL IZQUIERDA
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2-0.2f,c3-0.2f);
        gl.glVertex3f(0-w1, 0-h1, 0+d1);
        gl.glVertex3f(0-w1, 0-h1, 0-d1);
        gl.glVertex3f(0-w1, 0+h1, 0-d1);
        gl.glVertex3f(0-w1, 0+h1, 0+d1);
        gl.glEnd();
        
        //LATERAL DERECHA
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2-0.2f,c3-0.2f);
        gl.glVertex3f(0+w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0-d1);
        gl.glVertex3f(0+w1, 0+h1, 0-d1);
        gl.glVertex3f(0+w1, 0+h1, 0+d1);
        gl.glEnd();
        
    }    
    
    public void wireCubo(){
        GLUT glut=new GLUT();
        gl.glPushMatrix();
        gl.glColor3f(c1, c2, c3);
        gl.glScalef(w,h,d);       
        glut.glutWireCube(1);
        gl.glPopMatrix();
    }
    
    
    public void dibujarTrapecio(float r){
               
     gl.glTranslatef(x,y,z);
        float w1=w/2;
        float h1=h/2;
        float d1=d/2;
        
        //BASE
        
        gl.glBegin(gl.GL_QUADS);
       
        gl.glColor3f(c1,c2,c3);
        gl.glVertex3f(0-w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0-d1);
        gl.glVertex3f(0-w1, 0-h1, 0-d1);
        gl.glEnd();
        
        //SUPERIOR
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2,c3-0.2f);
        gl.glVertex3f(0-w1+r, 0+h1, 0+d1);
        gl.glVertex3f(0+w1-r, 0+h1, 0+d1);
        gl.glVertex3f(0+w1-r, 0+h1, 0-d1);
        gl.glVertex3f(0-w1+r, 0+h1, 0-d1);
        gl.glEnd();
        
        //FRONTAL
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2,c3);
        gl.glVertex3f(0-w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1-r, 0+h1, 0+d1);
        gl.glVertex3f(0-w1+r, 0+h1, 0+d1);
        gl.glEnd();
        
        //POSTERIOR
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2,c3-0.2f);
        gl.glVertex3f(0-w1, 0-h1, 0-d1);
        gl.glVertex3f(0+w1, 0-h1, 0-d1);
        gl.glVertex3f(0+w1-r, 0+h1, 0-d1);
        gl.glVertex3f(0-w1+r, 0+h1, 0-d1);
        gl.glEnd();
        
        //LATERAL IZQUIERDA
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2-0.2f,c3-0.2f);
        gl.glVertex3f(0-w1, 0-h1, 0+d1);
        gl.glVertex3f(0-w1, 0-h1, 0-d1);
        gl.glVertex3f(0-w1+r, 0+h1, 0-d1);
        gl.glVertex3f(0-w1+r, 0+h1, 0+d1);
        gl.glEnd();
        
        //LATERAL DERECHA
        gl.glBegin(gl.GL_QUADS);
        gl.glColor3f(c1,c2-0.1f,c3-0.2f);
        gl.glVertex3f(0+w1, 0-h1, 0+d1);
        gl.glVertex3f(0+w1, 0-h1, 0-d1);
        gl.glVertex3f(0+w1-r, 0+h1, 0-d1);
        gl.glVertex3f(0+w1-r, 0+h1, 0+d1);
        gl.glEnd();
    }
    
     
    
}
